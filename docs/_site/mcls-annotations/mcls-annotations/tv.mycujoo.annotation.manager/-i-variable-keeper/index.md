//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.manager](../index.md)/[IVariableKeeper](index.md)

# IVariableKeeper

[androidJvm]\
interface [IVariableKeeper](index.md)

## Functions

| Name | Summary |
|---|---|
| [createTimerPublisher](create-timer-publisher.md) | [androidJvm]<br>abstract fun [createTimerPublisher](create-timer-publisher.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [createVariablePublisher](create-variable-publisher.md) | [androidJvm]<br>abstract fun [createVariablePublisher](create-variable-publisher.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [getTimerNames](get-timer-names.md) | [androidJvm]<br>abstract fun [getTimerNames](get-timer-names.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [getValue](get-value.md) | [androidJvm]<br>abstract fun [getValue](get-value.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getVariableNames](get-variable-names.md) | [androidJvm]<br>abstract fun [getVariableNames](get-variable-names.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [notifyTimers](notify-timers.md) | [androidJvm]<br>abstract fun [notifyTimers](notify-timers.md)(timerVariables: [HashMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-hash-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [TimerVariable](../-timer-variable/index.md)&gt;) |
| [notifyVariables](notify-variables.md) | [androidJvm]<br>abstract fun [notifyVariables](notify-variables.md)(variableEntities: [HashMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-hash-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [VariableEntity](../../tv.mycujoo.annotation.domain.entity/-variable-entity/index.md)&gt;) |
| [observeOnTimer](observe-on-timer.md) | [androidJvm]<br>abstract fun [observeOnTimer](observe-on-timer.md)(timerName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), callback: ([Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [observeOnVariable](observe-on-variable.md) | [androidJvm]<br>abstract fun [observeOnVariable](observe-on-variable.md)(variableName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), callback: ([Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

## Inheritors

| Name |
|---|
| [VariableKeeper](../-variable-keeper/index.md) |
