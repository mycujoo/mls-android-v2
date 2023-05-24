package tv.mycujoo.annotation.core

import timber.log.Timber
import tv.mycujoo.annotation.domain.entity.TimelineMarkerEntity
import tv.mycujoo.annotation.domain.entity.VariableEntity
import tv.mycujoo.annotation.entity.ActionActor
import tv.mycujoo.annotation.helper.TimeRangeHelper
import tv.mycujoo.annotation.helper.TimeSystem
import tv.mycujoo.annotation.manager.TimerEntity
import tv.mycujoo.annotation.manager.TimerVariable
import tv.mycujoo.annotation.utils.TimeUtils
import tv.mycujoo.mclscore.Consts.ONE_SECOND_IN_MS
import tv.mycujoo.mclscore.model.AnnotationAction
import java.util.concurrent.CopyOnWriteArrayList
import javax.inject.Inject

class AnnotationFactory @Inject constructor(
    private val annotationListener: IAnnotationListener,
    private val variableKeeper: tv.mycujoo.annotation.manager.IVariableKeeper,
) : IAnnotationFactory {

    /**region Fields*/
    private var sortedActions =
        CopyOnWriteArrayList<AnnotationAction>() // actions, sorted by offset, then by priority
    private var adjustedActions =
        CopyOnWriteArrayList<AnnotationAction>() // sortedActionList + adjusted offset time
    private var timeSystem = TimeSystem.RELATIVE

    private var onScreenOverlayIds =
        CopyOnWriteArrayList<String>() // on-screen overlay actions cid

    private var localActions =
        CopyOnWriteArrayList<AnnotationAction>() // local Actions which will be merged with server defined actions

    private var allActions =
        CopyOnWriteArrayList<AnnotationAction>() // union of Sorted actions + Local actions

    /**endregion */

    /**
     * Set Local Actions, used for Mapped GQL events
     * @param actions List of Mapped GQL events to List<Action>
     */
    override fun setActions(actions: List<AnnotationAction>) {
        val sortedTemp = actions
            .sortedWith(compareBy<AnnotationAction> { it.offset }.thenByDescending { it.priority })

        val deleteActions = ArrayList<AnnotationAction>()
        deleteActions.addAll(sortedTemp.filterIsInstance<AnnotationAction.DeleteAction>())

        sortedActions.clear()
        sortedActions.addAll(sortedTemp.filter { actionObject ->
            deleteActions.none {
                actionObject.id == it.id
            }
        })

        allActions.apply {
            clear()
            addAll(localActions)
            addAll(sortedActions)
        }
    }

    override fun build(currentPosition: Long) {
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

            for (action in allActions) {
                val newOffset = TimeUtils.calculateOffset(
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

    override fun getCurrentActions(): List<AnnotationAction> {
        return adjustedActions.ifEmpty {
            sortedActions
        }
    }

    /**endregion */

    /**region Processing actions*/
    private fun process(
        isInDvrWindow: Boolean,
        list: List<AnnotationAction>,
        currentPosition: Long,
    ) {
        val showOverlayList = arrayListOf<AnnotationAction.ShowOverlayAction>()
        val hideOverlayList = arrayListOf<AnnotationAction.HideOverlayAction>()

        val timerVariables: HashMap<String, TimerVariable> = HashMap()
        val varVariables: HashMap<String, VariableEntity> = HashMap()

        val timelineMarkers = ArrayList<TimelineMarkerEntity>()


        for (action in list) {
            val isInGap = false
            when (action) {
                is AnnotationAction.ShowOverlayAction -> {
                    if (isInDvrWindow.not() && isInGap) {
                        break
                    }
                    addShowOverlayActionIfEligible(action, showOverlayList)
                }
                is AnnotationAction.HideOverlayAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        hideOverlayList.add(action)
                    }
                }
                is AnnotationAction.ReshowOverlayAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        list.firstOrNull { it is AnnotationAction.ShowOverlayAction && it.customId == action.customId }
                            ?.let { relatedShowAction ->
                                val updatedAction =
                                    relatedShowAction.updateOffset(action.offset) as AnnotationAction.ShowOverlayAction
                                addShowOverlayActionIfEligible(updatedAction, showOverlayList)
                            }
                    }
                }
                is AnnotationAction.CreateTimerAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        createTimer(action, timerVariables)
                    }
                }
                is AnnotationAction.StartTimerAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        startTimer(action, timerVariables, currentPosition)
                    }
                }
                is AnnotationAction.PauseTimerAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        pauseTimer(action, timerVariables, currentPosition)
                    }
                }
                is AnnotationAction.AdjustTimerAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        adjustTimer(action, timerVariables, currentPosition)
                    }
                }
                is AnnotationAction.SkipTimerAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        skipTimer(action, timerVariables, currentPosition)
                    }
                }
                is AnnotationAction.CreateVariableAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        createVariable(action, varVariables, currentPosition)
                    }
                }
                is AnnotationAction.IncrementVariableAction -> {
                    if (action.isTillNowOrInRange(currentPosition)) {
                        incrementVariable(action, varVariables, currentPosition)
                    }
                }
                is AnnotationAction.MarkTimelineAction -> {
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
                is AnnotationAction.DeleteAction,
                is AnnotationAction.InvalidAction -> {
                    // do nothing
                }
            }
        }

        val act = ActionActor().act(
            currentPosition, showOverlayList, hideOverlayList
        )


        for (pair in act) {
            when (pair.second) {
                is AnnotationAction.ShowOverlayAction -> {
                    val showOverlayAction = pair.second as AnnotationAction.ShowOverlayAction
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
                is AnnotationAction.HideOverlayAction -> {
                    val hideOverlayAction = pair.second as AnnotationAction.HideOverlayAction
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
        action: AnnotationAction.ShowOverlayAction,
        showOverlayList: ArrayList<AnnotationAction.ShowOverlayAction>
    ) {
        if (action.isEligible()) {
            showOverlayList.add(action)
        }
    }


    private fun shouldMarkTimeLine(
        action: AnnotationAction.MarkTimelineAction
    ): Boolean {
        if (action.offset < 0L) {
            return false
        }
        return true
    }

    private fun createTimer(
        action: AnnotationAction.CreateTimerAction,
        timerVariables: HashMap<String, TimerVariable>
    ) {
        variableKeeper.createTimerPublisher(action.name)

        timerVariables[action.name] =
            TimerVariable(
                action.name,
                action.format,
                action.direction,
                action.startValue,
                action.capValue
            )

    }

    private fun startTimer(
        action: AnnotationAction.StartTimerAction,
        timerVariables: HashMap<String, TimerVariable>,
        currentPosition: Long,
    ) {
        timerVariables[action.name]?.start(
            TimerEntity.StartTimer(action.name, action.offset),
            currentPosition
        )

    }

    private fun pauseTimer(
        action: AnnotationAction.PauseTimerAction,
        timerVariables: HashMap<String, TimerVariable>,
        currentPosition: Long,
    ) {
        timerVariables[action.name]?.pause(
            TimerEntity.PauseTimer(action.name, action.offset),
            currentPosition
        )

    }

    private fun adjustTimer(
        action: AnnotationAction.AdjustTimerAction,
        timerVariables: HashMap<String, TimerVariable>,
        currentPosition: Long,
    ) {
        timerVariables[action.name]?.adjust(
            TimerEntity.AdjustTimer(action.name, action.offset, action.value),
            currentPosition
        )

    }

    private fun skipTimer(
        action: AnnotationAction.SkipTimerAction,
        timerVariables: HashMap<String, TimerVariable>,
        currentPosition: Long,
    ) {
        timerVariables[action.name]?.skip(
            TimerEntity.SkipTimer(action.name, action.offset, action.value),
            currentPosition
        )
    }

    private fun createVariable(
        action: AnnotationAction.CreateVariableAction,
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
        action: AnnotationAction.IncrementVariableAction,
        varVariables: HashMap<String, VariableEntity>,
        currentPosition: Long,
    ) {
        if (currentPosition + ONE_SECOND_IN_MS > action.offset) {
            varVariables[action.name]?.variable?.increment(action.amount)
        }
    }

    /**endregion */

    override fun clearOverlays() {
        localActions.clear()
        annotationListener.clearScreen()
    }
}
