---
title: IVariableKeeper
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.manager](../index.html)/[IVariableKeeper](index.html)



# IVariableKeeper

interface [IVariableKeeper](index.html)

#### Inheritors


| |
|---|
| [VariableKeeper](../-variable-keeper/index.html) |


## Functions


| Name | Summary |
|---|---|
| [createTimerPublisher](create-timer-publisher.html) | [androidJvm]<br>abstract fun [createTimerPublisher](create-timer-publisher.html)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [createVariablePublisher](create-variable-publisher.html) | [androidJvm]<br>abstract fun [createVariablePublisher](create-variable-publisher.html)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [getTimerNames](get-timer-names.html) | [androidJvm]<br>abstract fun [getTimerNames](get-timer-names.html)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [getValue](get-value.html) | [androidJvm]<br>abstract fun [getValue](get-value.html)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getVariableNames](get-variable-names.html) | [androidJvm]<br>abstract fun [getVariableNames](get-variable-names.html)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [notifyTimers](notify-timers.html) | [androidJvm]<br>abstract fun [notifyTimers](notify-timers.html)(timerVariables: [HashMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-hash-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [TimerVariable](../-timer-variable/index.html)&gt;) |
| [notifyVariables](notify-variables.html) | [androidJvm]<br>abstract fun [notifyVariables](notify-variables.html)(variableEntities: [HashMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-hash-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [VariableEntity](../../tv.mycujoo.annotation.domain.entity/-variable-entity/index.html)&gt;) |
| [observeOnTimer](observe-on-timer.html) | [androidJvm]<br>abstract fun [observeOnTimer](observe-on-timer.html)(timerName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), callback: ([Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [observeOnVariable](observe-on-variable.html) | [androidJvm]<br>abstract fun [observeOnVariable](observe-on-variable.html)(variableName: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), callback: ([Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

