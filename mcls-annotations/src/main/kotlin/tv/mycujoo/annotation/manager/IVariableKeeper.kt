package tv.mycujoo.annotation.manager

import tv.mycujoo.annotation.domain.entity.VariableEntity

interface IVariableKeeper {
    fun getValue(name: String): String

    fun createTimerPublisher(name: String)
    fun observeOnTimer(timerName: String, callback: (Pair<String, String>) -> Unit)
    fun getTimerNames(): List<String>
    fun notifyTimers(timerVariables: HashMap<String, TimerVariable>)

    fun createVariablePublisher(name: String)
    fun observeOnVariable(variableName: String, callback: (Pair<String, String>) -> Unit)
    fun getVariableNames(): List<String>
    fun notifyVariables(variableEntities: HashMap<String, VariableEntity>)
}