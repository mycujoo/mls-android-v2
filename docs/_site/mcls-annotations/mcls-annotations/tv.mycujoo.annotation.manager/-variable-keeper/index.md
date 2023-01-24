//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.manager](../index.md)/[VariableKeeper](index.md)

# VariableKeeper

[androidJvm]\
@Singleton

class [VariableKeeper](index.md)@Injectconstructor(dispatcher: CoroutineScope) : [IVariableKeeper](../-i-variable-keeper/index.md)

## Constructors

| | |
|---|---|
| [VariableKeeper](-variable-keeper.md) | [androidJvm]<br>@Inject<br>fun [VariableKeeper](-variable-keeper.md)(dispatcher: CoroutineScope) |

## Functions

| Name | Summary |
|---|---|
| [createTimerPublisher](create-timer-publisher.md) | [androidJvm]<br>open override fun [createTimerPublisher](create-timer-publisher.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [createVariablePublisher](create-variable-publisher.md) | [androidJvm]<br>open override fun [createVariablePublisher](create-variable-publisher.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [getTimerNames](get-timer-names.md) | [androidJvm]<br>open override fun [getTimerNames](get-timer-names.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [getValue](get-value.md) | [androidJvm]<br>open override fun [getValue](get-value.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getVariableNames](get-variable-names.md) | [androidJvm]<br>open override fun [getVariableNames](get-variable-names.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [notifyTimers](notify-timers.md) | [androidJvm]<br>open override fun [notifyTimers](notify-timers.md)(timerVariables: [HashMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-hash-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [TimerVariable](../-timer-variable/index.md)&gt;) |
| [notifyVariables](notify-variables.md) | [androidJvm]<br>open override fun [notifyVariables](notify-variables.md)(variableEntities: [HashMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-hash-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [VariableEntity](../../tv.mycujoo.annotation.domain.entity/-variable-entity/index.md)&gt;) |
| [observeOnTimer](observe-on-timer.md) | [androidJvm]<br>open override fun [observeOnTimer](observe-on-timer.md)(timerName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), callback: ([Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [observeOnVariable](observe-on-variable.md) | [androidJvm]<br>open override fun [observeOnVariable](observe-on-variable.md)(variableName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), callback: ([Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
