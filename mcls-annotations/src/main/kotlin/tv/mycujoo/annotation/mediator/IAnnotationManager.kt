package tv.mycujoo.annotation.mediator

import tv.mycujoo.mclscore.model.AnnotationAction

interface IAnnotationManager {
    fun setActions(actions: List<AnnotationAction>)

    fun setTime(currentPosition: Long)
}