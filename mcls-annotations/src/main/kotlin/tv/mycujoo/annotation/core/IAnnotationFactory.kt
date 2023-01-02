package tv.mycujoo.annotation.core

import tv.mycujoo.mclscore.model.Action

interface IAnnotationFactory {
    fun setActions(actions: List<Action>)
    fun setMCLSActions(annotations: List<Action>)

    fun getCurrentActions(): List<Action>

    fun clearOverlays()
}
