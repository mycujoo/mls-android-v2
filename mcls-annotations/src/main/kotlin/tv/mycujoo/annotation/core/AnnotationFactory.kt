package tv.mycujoo.annotation.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import tv.mycujoo.annotation.di.TickerFlow
import tv.mycujoo.annotation.domain.entity.TimelineMarkerEntity
import tv.mycujoo.annotation.domain.entity.VariableEntity
import tv.mycujoo.annotation.domain.enum.C.Companion.ONE_SECOND_IN_MS
import tv.mycujoo.annotation.entity.ActionActor
import tv.mycujoo.annotation.helper.TimeRangeHelper
import tv.mycujoo.annotation.helper.TimeSystem
import tv.mycujoo.mclscore.model.Action
import java.util.concurrent.CopyOnWriteArrayList
import javax.inject.Inject

class AnnotationFactory @Inject constructor(
    @TickerFlow private val currentTimeFlow: MutableSharedFlow<Long>,
    private val annotationListener: IAnnotationListener,
    private val variableKeeper: tv.mycujoo.annotation.manager.IVariableKeeper,
    scope: CoroutineScope,
) : IAnnotationFactory {

    init {
        scope.launch {
            currentTimeFlow.collect {
                build(it)
            }
        }
    }

    /**region Fields*/
    private var sortedActions =
        CopyOnWriteArrayList<Action>() // actions, sorted by offset, then by priority
    private var adjustedActions =
        CopyOnWriteArrayList<Action>() // sortedActionList + adjusted offset time
    private var timeSystem = TimeSystem.RELATIVE

    private var onScreenOverlayIds =
        CopyOnWriteArrayList<String>() // on-screen overlay actions cid

    private var localActions =
        CopyOnWriteArrayList<Action>() // local Actions which will be merged with server defined actions

    private var isMCLSActions = false

    private var allActions =
        CopyOnWriteArrayList<Action>() // union of Sorted actions + Local actions

    /**endregion */

    /**
     * Set Local Actions, used for Mapped GQL events
     * @param actions List of Mapped GQL events to List<Action>
     */
    override fun setActions(actions: List<Action>) {
        if (isMCLSActions) {
            return
        }

        val sortedTemp = actions
            .sortedWith(compareBy<Action> { it.offset }.thenByDescending { it.priority })

        val deleteActions = ArrayList<Action>()
        deleteActions.addAll(sortedTemp.filterIsInstance<Action.DeleteAction>())

        sortedActions.clear()
        sortedActions.addAll(sortedTemp.filter { actionObject ->
            deleteActions.none {
                actionObject.id == it.id
            }
        })
    }

    /**
     * Set Actions, used for MCLS Events
     * @param annotations List of MCLS Actions
     */
    override fun setMCLSActions(annotations: List<Action>) {
        if (annotations.isEmpty()) {
            return
        }

        isMCLSActions = true
        val sortedTemp = annotations
            .sortedWith(compareBy<Action> { it.offset }.thenByDescending { it.priority })

        val deleteActions = ArrayList<Action>()
        deleteActions.addAll(sortedTemp.filterIsInstance<Action.DeleteAction>())

        sortedActions.clear()
        sortedActions.addAll(sortedTemp.filter { actionObject ->
            deleteActions.none {
                actionObject.id == it.id
            }
        })
    }

    fun build(currentPosition: Long) {
        allActions.apply {
            clear()
            addAll(localActions)
            addAll(sortedActions)
        }

        val currentTimeInInDvrWindowDuration = TimeRangeHelper.isCurrentTimeInDvrWindowDuration(
            currentPosition,
            Long.MAX_VALUE // todo! This should be filled from Stream's dvr-window size value
        )

        if (currentTimeInInDvrWindowDuration) {
            timeSystem = TimeSystem.RELATIVE
            adjustedActions.clear()
            process(
                currentTimeInInDvrWindowDuration,
                allActions,
                currentPosition
            )

        } else {
            timeSystem = TimeSystem.ABSOLUTE
            adjustedActions.clear()

            allActions.forEach { action ->
                val newOffset = tv.mycujoo.annotation.utils.TimeUtils.calculateOffset(
                    0,
                    action.absoluteTime
                )
                adjustedActions.add(action.updateOffset(newOffset))
            }
            process(
                currentTimeInInDvrWindowDuration,
                adjustedActions,
                currentPosition
            )

        }
    }

    override fun getCurrentActions(): List<Action> {
        return if (adjustedActions.isNotEmpty()) {
            adjustedActions
        } else {
            sortedActions
        }
    }

    /**endregion */

    /**region Processing actions*/
    private fun process(
        isInDvrWindow: Boolean,
        list: List<Action>,
        currentPosition: Long,
    ) {
        val showOverlayList = arrayListOf<Action.ShowOverlayAction>()
        val hideOverlayList = arrayListOf<Action.HideOverlayAction>()

        val timerVariables: HashMap<String, tv.mycujoo.annotation.manager.TimerVariable> = HashMap()
        val varVariables: HashMap<String, VariableEntity> = HashMap()

        val timelineMarkers = ArrayList<TimelineMarkerEntity>()

        list.forEach { action ->
            val isInGap = false
            when (action) {
                is Action.ShowOverlayAction -> {
                    if (isInDvrWindow.not() && isInGap) {
                        return@forEach
                    }
                    addShowOverlayActionIfEligible(action, showOverlayList)
                }
                is Action.HideOverlayAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        hideOverlayList.add(action)
                    }
                }
                is Action.ReshowOverlayAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        list.firstOrNull { it is Action.ShowOverlayAction && it.customId == action.customId }
                            ?.let { relatedShowAction ->
                                val updatedAction =
                                    relatedShowAction.updateOffset(action.offset) as Action.ShowOverlayAction
                                addShowOverlayActionIfEligible(updatedAction, showOverlayList)
                            }
                    }
                }
                is Action.CreateTimerAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        createTimer(action, timerVariables)
                    }
                }
                is Action.StartTimerAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        startTimer(action, timerVariables, currentPosition)
                    }
                }
                is Action.PauseTimerAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        pauseTimer(action, timerVariables, currentPosition)
                    }
                }
                is Action.AdjustTimerAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        adjustTimer(action, timerVariables, currentPosition)
                    }
                }
                is Action.SkipTimerAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        skipTimer(action, timerVariables, currentPosition)
                    }
                }
                is Action.CreateVariableAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        createVariable(action, varVariables, currentPosition)
                    }
                }
                is Action.IncrementVariableAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        incrementVariable(action, varVariables, currentPosition)
                    }
                }
                is Action.MarkTimelineAction -> {
                    if (shouldMarkTimeLine(action)) {
                        timelineMarkers.add(
                            TimelineMarkerEntity(
                                action.id,
                                action.offset,
                                action.seekOffset,
                                action.label,
                                action.color
                            )
                        )
                    }
                }
                is Action.DeleteAction,
                is Action.InvalidAction -> {
                    // do nothing
                }
            }
        }

        val act = ActionActor().act(
            currentPosition, showOverlayList, hideOverlayList
        )
        act.forEach { pair ->
            when (pair.second) {
                is Action.ShowOverlayAction -> {
                    val showOverlayAction = pair.second as Action.ShowOverlayAction
                    when (pair.first) {
                        ActionActor.ActionAct.INTRO -> {
                            if (onScreenOverlayIds.none { it == showOverlayAction.customId }) {
                                onScreenOverlayIds.add(showOverlayAction.customId)
                                annotationListener.addOverlay(showOverlayAction)
                            }
                        }
                        ActionActor.ActionAct.MIDWAY -> {
                            if (onScreenOverlayIds.none { it == showOverlayAction.customId }) {
                                onScreenOverlayIds.add(showOverlayAction.customId)
                            }
                            annotationListener.addOrUpdateLingeringMidwayOverlay(showOverlayAction)
                        }
                        ActionActor.ActionAct.OUTRO -> {
                            if (onScreenOverlayIds.any { it == showOverlayAction.customId }) {
                                onScreenOverlayIds.remove(showOverlayAction.customId)
                                annotationListener.removeOverlay(
                                    showOverlayAction.customId,
                                    showOverlayAction.outroTransitionSpec
                                )
                            }
                        }
                        ActionActor.ActionAct.LINGERING_INTRO -> {
                            if (onScreenOverlayIds.none { it == showOverlayAction.customId }) {
                                onScreenOverlayIds.add(showOverlayAction.customId)
                            }
                            annotationListener.addOrUpdateLingeringIntroOverlay(
                                showOverlayAction,
                                currentPosition - showOverlayAction.introTransitionSpec!!.offset,
                                false
                            )

                        }
                        ActionActor.ActionAct.REMOVE -> {
                            if (onScreenOverlayIds.any { it == showOverlayAction.customId }) {
                                onScreenOverlayIds.remove(showOverlayAction.customId)
                                annotationListener.removeOverlay(showOverlayAction.customId, null)
                            }
                        }
                        ActionActor.ActionAct.DO_NOTHING -> {
                            // do nothing
                        }

                    }
                }
                is Action.HideOverlayAction -> {
                    val hideOverlayAction = pair.second as Action.HideOverlayAction
                    when (pair.first) {
                        ActionActor.ActionAct.OUTRO -> {
                            if (onScreenOverlayIds.any { it == hideOverlayAction.customId }) {
                                onScreenOverlayIds.remove(hideOverlayAction.customId)
                                annotationListener.removeOverlay(
                                    hideOverlayAction.customId,
                                    hideOverlayAction.outroTransitionSpec
                                )
                            }
                        }
                        ActionActor.ActionAct.REMOVE -> {
                            if (onScreenOverlayIds.any { it == hideOverlayAction.customId }) {
                                onScreenOverlayIds.remove(hideOverlayAction.customId)
                                annotationListener.removeOverlay(
                                    hideOverlayAction.customId, null
                                )
                            }
                        }
                        else -> {
                            // should not happen
                        }
                    }
                }
                else -> {
                    // should not happen
                }
            }
        }


        variableKeeper.notifyTimers(timerVariables)
        variableKeeper.notifyVariables(varVariables)

        annotationListener.setTimelineMarkers(timelineMarkers)
    }

    private fun addShowOverlayActionIfEligible(
        action: Action.ShowOverlayAction,
        showOverlayList: ArrayList<Action.ShowOverlayAction>
    ) {
        if (action.isEligible()) {
            showOverlayList.add(action)
        }
    }


    private fun shouldMarkTimeLine(
        action: Action.MarkTimelineAction
    ): Boolean {
        if (action.offset < 0L) {
            return false
        }
        return true
    }

    private fun createTimer(
        action: Action.CreateTimerAction,
        timerVariables: HashMap<String, tv.mycujoo.annotation.manager.TimerVariable>
    ) {
        variableKeeper.createTimerPublisher(action.name)

        timerVariables[action.name] =
            tv.mycujoo.annotation.manager.TimerVariable(
                action.name,
                action.format,
                action.direction,
                action.startValue,
                action.capValue
            )

    }

    private fun startTimer(
        action: Action.StartTimerAction,
        timerVariables: HashMap<String, tv.mycujoo.annotation.manager.TimerVariable>,
        currentPosition: Long,
    ) {
        timerVariables[action.name]?.start(
            tv.mycujoo.annotation.manager.TimerEntity.StartTimer(action.name, action.offset),
            currentPosition
        )

    }

    private fun pauseTimer(
        action: Action.PauseTimerAction,
        timerVariables: HashMap<String, tv.mycujoo.annotation.manager.TimerVariable>,
        currentPosition: Long,
    ) {
        timerVariables[action.name]?.pause(
            tv.mycujoo.annotation.manager.TimerEntity.PauseTimer(action.name, action.offset),
            currentPosition
        )

    }

    private fun adjustTimer(
        action: Action.AdjustTimerAction,
        timerVariables: HashMap<String, tv.mycujoo.annotation.manager.TimerVariable>,
        currentPosition: Long,
    ) {
        timerVariables[action.name]?.adjust(
            tv.mycujoo.annotation.manager.TimerEntity.AdjustTimer(action.name, action.offset, action.value),
            currentPosition
        )

    }

    private fun skipTimer(
        action: Action.SkipTimerAction,
        timerVariables: HashMap<String, tv.mycujoo.annotation.manager.TimerVariable>,
        currentPosition: Long,
    ) {
        timerVariables[action.name]?.skip(
            tv.mycujoo.annotation.manager.TimerEntity.SkipTimer(action.name, action.offset, action.value),
            currentPosition
        )
    }

    private fun createVariable(
        action: Action.CreateVariableAction,
        varVariables: HashMap<String, VariableEntity>,
        currentPosition: Long,
    ) {
        if (currentPosition + ONE_SECOND_IN_MS > action.offset) {
            variableKeeper.createVariablePublisher(action.variable.name)
            varVariables[action.variable.name] =
                VariableEntity(action.id, action.offset, action.variable.copy())
        }
    }

    private fun incrementVariable(
        action: Action.IncrementVariableAction,
        varVariables: HashMap<String, VariableEntity>,
        currentPosition: Long,
    ) {
        if (currentPosition + ONE_SECOND_IN_MS > action.offset) {
            varVariables[action.name]?.variable?.increment(action.amount)
        }
    }

    /**endregion */

    override fun clearOverlays() {
        isMCLSActions = false
        localActions.clear()
        annotationListener.clearScreen()
    }
}
