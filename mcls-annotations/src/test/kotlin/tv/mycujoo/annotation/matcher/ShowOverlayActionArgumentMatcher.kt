package tv.mycujoo.annotation.matcher

import org.mockito.ArgumentMatcher
import tv.mycujoo.mclscore.model.AnnotationAction

class ShowOverlayActionArgumentMatcher(private val id: String) :
    ArgumentMatcher<AnnotationAction.ShowOverlayAction> {
    override fun matches(argument: AnnotationAction.ShowOverlayAction?): Boolean {
        return argument?.id == id
    }
}