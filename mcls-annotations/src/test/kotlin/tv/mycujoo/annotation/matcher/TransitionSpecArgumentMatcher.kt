package tv.mycujoo.annotation.matcher

import org.mockito.ArgumentMatcher
import tv.mycujoo.mclscore.model.TransitionSpec

class TransitionSpecArgumentMatcher(private val offset: Long) :
    ArgumentMatcher<TransitionSpec> {
    override fun matches(argument: TransitionSpec?): Boolean {
        return argument?.offset == offset
    }
}