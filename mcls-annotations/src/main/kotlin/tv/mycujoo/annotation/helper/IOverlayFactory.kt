package tv.mycujoo.annotation.helper

import tv.mycujoo.annotation.widget.ScaffoldView
import tv.mycujoo.mclscore.model.Action

/**
 * Contract for creating ready-to-be-displayed ScaffoldView
 */
interface IOverlayFactory {
    fun createScaffoldView(
        showOverlayAction: Action.ShowOverlayAction,
    ): ScaffoldView
}
