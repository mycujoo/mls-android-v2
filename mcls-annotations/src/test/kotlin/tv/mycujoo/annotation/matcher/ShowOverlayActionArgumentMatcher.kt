package tv.mycujoo.annotation.matcher

import org.mockito.ArgumentMatcher
import tv.mycujoo.mclscore.model.Action

class ShowOverlayActionArgumentMatcher(private val id: String) :
    ArgumentMatcher<Action.ShowOverlayAction> {
    override fun matches(argument: Action.ShowOverlayAction?): Boolean {
        return argument?.id == id
    }
}