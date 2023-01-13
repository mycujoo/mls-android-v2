package tv.mycujoo.annotation.matcher

import org.mockito.ArgumentMatcher
import tv.mycujoo.annotation.manager.TimerVariable

class TimerVariablesMapArgumentMatcher(
    private val variableName: String,
    private val value: String
) :
    ArgumentMatcher<HashMap<String, TimerVariable>> {
    override fun matches(argument: HashMap<String, TimerVariable>?): Boolean {
        return argument!!.containsKey(variableName) && argument[variableName]?.getTime() == value
    }
}