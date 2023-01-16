package tv.mycujoo.annotation.mediator

import tv.mycujoo.mclscore.model.Action

interface IAnnotationManager {
    fun setActions(actions: List<Action>)

    fun setTime(currentPosition: Long)
}