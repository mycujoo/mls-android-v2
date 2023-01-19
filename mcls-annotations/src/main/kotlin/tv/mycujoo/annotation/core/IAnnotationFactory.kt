package tv.mycujoo.annotation.core

import tv.mycujoo.mclscore.model.AnnotationAction

interface IAnnotationFactory {
    fun setActions(actions: List<AnnotationAction>)

    fun getCurrentActions(): List<AnnotationAction>

    fun clearOverlays()

    fun build(currentPosition: Long)
}
