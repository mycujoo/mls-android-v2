package tv.mycujoo.annotation.entity

import tv.mycujoo.annotation.domain.enum.C
import tv.mycujoo.mclscore.model.AnnotationAction

/**
 * Actor for Annotation Actions
 */
class ActionActor {
    /**
     * Actions should be provided sorted based on their offset
     */
    fun act(
        now: Long,
        showOverlayActions: ArrayList<AnnotationAction.ShowOverlayAction>,
        hideOverlayActions: ArrayList<AnnotationAction.HideOverlayAction>
    ): List<Pair<ActionAct, AnnotationAction>> {
        val showMap = mutableMapOf<String, AnnotationAction.ShowOverlayAction>()
        val hideMap = mutableMapOf<String, AnnotationAction.HideOverlayAction>()

        val filteredShowOverlayActions: ArrayList<AnnotationAction.ShowOverlayAction> = arrayListOf()
        val afterwardsShowOverlayActions: ArrayList<AnnotationAction.ShowOverlayAction> = arrayListOf()

        showOverlayActions.forEach {
            if (it.isTillNowOrInRange(now)) {
                filteredShowOverlayActions.add(it)
            } else {
                afterwardsShowOverlayActions.add(it)
            }
        }

        filteredShowOverlayActions.sortBy { it.offset }

        filteredShowOverlayActions.forEach { action ->
            val relatedHideOverlayAction =
                hideOverlayActions.find { it.customId == action.customId }
            if (relatedHideOverlayAction != null) {
                hideOverlayActions.remove(relatedHideOverlayAction)
                if (relatedHideOverlayAction.offset >= action.offset) {
                    showMap.remove(relatedHideOverlayAction.customId)
                    hideMap[relatedHideOverlayAction.customId] = relatedHideOverlayAction
                } else {
                    hideMap.remove(action.customId)
                    showMap[action.customId] = action
                }
            } else {
                hideMap.remove(action.customId)
                showMap[action.customId] = action
            }
        }
        hideOverlayActions.forEach { action ->
            hideMap[action.customId] = action
        }

        val returnList = arrayListOf<Pair<ActionAct, AnnotationAction>>()
        showMap.forEach {
            val act = getCurrentAct(now, it.value)
            returnList.add(Pair(act, it.value))
        }

        hideMap.forEach {
            try {
                val lastShowOverlay =
                    returnList.last { item ->
                        item.second is AnnotationAction.ShowOverlayAction &&
                                (item.second as AnnotationAction.ShowOverlayAction).customId == it.key
                    }
                returnList.remove(lastShowOverlay)
            } catch (noItemFound: NoSuchElementException) {
                val act = getCurrentAct(now, it.value)
                returnList.add(Pair(act, it.value))
            }
        }

        afterwardsShowOverlayActions.forEach { afterwardsShowOverlayAction ->
            if (returnList.none { isPresentInReturningPairList(it, afterwardsShowOverlayAction) }
            ) {
                returnList.add(Pair(ActionAct.REMOVE, afterwardsShowOverlayAction))
            }
        }
        return returnList
    }

    private fun isPresentInReturningPairList(
        it: Pair<ActionAct, AnnotationAction>,
        afterwardsShowOverlayAction: AnnotationAction.ShowOverlayAction
    ) =
        it.second is AnnotationAction.ShowOverlayAction && (it.second as AnnotationAction.ShowOverlayAction).customId == afterwardsShowOverlayAction.customId ||
                it.second is AnnotationAction.HideOverlayAction && (it.second as AnnotationAction.HideOverlayAction).customId == afterwardsShowOverlayAction.customId

    private fun getCurrentAct(
        currentTime: Long,
        action: AnnotationAction.ShowOverlayAction
    ): ActionAct {

        fun isIntro(
            currentTime: Long,
            action: AnnotationAction
        ): Boolean {
            return (action.offset >= currentTime) && (action.offset < currentTime + C.ONE_SECOND_IN_MS)
        }

        fun isOutro(
            currentTime: Long,
            action: AnnotationAction.ShowOverlayAction
        ): Boolean {
            val bound: Long = action.outroTransitionSpec?.offset ?: (action.offset + (action.duration ?: 0L))
            return currentTime < bound && currentTime + C.ONE_SECOND_IN_MS > bound
        }

        // action belongs to the past
        fun isAforetime(currentTime: Long, action: AnnotationAction.ShowOverlayAction): Boolean {
            action.outroTransitionSpec?.let {
                return currentTime > it.offset + it.animationDuration
            } ?: return currentTime > action.offset + (action.duration ?: 0L)
        }

        fun isMidway(
            currentTime: Long,
            action: AnnotationAction.ShowOverlayAction
        ): Boolean {
            var leftBound = action.offset
            action.introTransitionSpec?.let {
                leftBound = action.offset + it.animationDuration
            }
            var rightBound = Long.MAX_VALUE
            action.outroTransitionSpec?.let {
                rightBound = it.offset
            }
            action.duration?.let {
                rightBound = action.offset + it
            }

            return (currentTime > leftBound) && (currentTime + C.ONE_SECOND_IN_MS < rightBound)
        }

        fun isLingeringIntro(
            currentTime: Long,
            action: AnnotationAction.ShowOverlayAction
        ): Boolean {

            val introTransitionSpec = action.introTransitionSpec

            if (introTransitionSpec == null || introTransitionSpec.animationDuration <= 0L) {
                return false
            }

            val leftBound = action.offset
            val rightBound =
                action.offset + introTransitionSpec.animationDuration

            return (leftBound <= currentTime) && (currentTime < rightBound)
        }

        fun isLingeringOutro(
            currentTime: Long,
            action: AnnotationAction.ShowOverlayAction
        ): Boolean {
            val outroTransitionSpec = action.outroTransitionSpec
            if (outroTransitionSpec == null || outroTransitionSpec.animationDuration == -1L) {
                return false
            }

            val leftBound = outroTransitionSpec.offset
            val rightBound = outroTransitionSpec.offset + outroTransitionSpec.animationDuration

            return (leftBound <= currentTime) && (currentTime < rightBound)
        }

        if (isIntro(currentTime, action)) {
            return ActionAct.INTRO
        }
        if (isMidway(currentTime, action)) {
            return ActionAct.MIDWAY
        }
        if (isOutro(currentTime, action)) {
            return ActionAct.OUTRO
        }
        if (isLingeringIntro(currentTime, action)) {
            return ActionAct.LINGERING_INTRO
        }
        if (isAforetime(currentTime, action)) {
            return ActionAct.REMOVE
        }

        return ActionAct.DO_NOTHING

    }

    private fun getCurrentAct(
        currentTime: Long,
        action: AnnotationAction.HideOverlayAction
    ): ActionAct {

        fun outroIsInCurrentTimeRange(
            currentTime: Long,
            hideOverlayAction: AnnotationAction.HideOverlayAction
        ): Boolean {
            val outroOffset =
                hideOverlayAction.offset

            return (outroOffset >= currentTime) && (outroOffset < currentTime + C.ONE_SECOND_IN_MS)
        }


        if (outroIsInCurrentTimeRange(currentTime, action)) {
            return ActionAct.OUTRO
        }

        return ActionAct.REMOVE
    }


    enum class ActionAct {

        INTRO,
        MIDWAY,
        OUTRO,
        LINGERING_INTRO,
        REMOVE,
        DO_NOTHING;
    }
}
