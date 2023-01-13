package tv.mycujoo.annotation.mediator

import tv.mycujoo.mclscore.model.Action

interface IAnnotationManager {
    fun setLocalActions(actions: List<Action>)
    fun setMCLSActions(actions: List<Action>)

    fun build(currentPosition: Long)
}