package tv.mycujoo.annotation.matcher

import org.mockito.ArgumentMatcher
import tv.mycujoo.annotation.domain.entity.VariableEntity

class VariablesMapArgumentMatcher(private val variableName: String, private val value: String) :
    ArgumentMatcher<HashMap<String, VariableEntity>> {
    override fun matches(argument: HashMap<String, VariableEntity>?): Boolean {
        return argument!!.containsKey(variableName) && argument[variableName]?.variable?.printValue() == value
    }
}