---
title: CreateTimerAction
---
//[mcls-core](../../../../index.html)/[tv.mycujoo.mclscore.model](../../index.html)/[AnnotationAction](../index.html)/[CreateTimerAction](index.html)



# CreateTimerAction

data class [CreateTimerAction](index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val format: [ScreenTimerFormat](../../../tv.mycujoo.mclscore.entity/-screen-timer-format/index.html) = ScreenTimerFormat.MINUTES_SECONDS, val direction: [ScreenTimerDirection](../../../tv.mycujoo.mclscore.entity/-screen-timer-direction/index.html) = ScreenTimerDirection.UP, val startValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0, val capValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [AnnotationAction](../index.html)

Action to create a Timer



#### See also


| |
|---|
| [ScreenTimerFormat](../../../tv.mycujoo.mclscore.entity/-screen-timer-format/index.html) |
| [ScreenTimerDirection](../../../tv.mycujoo.mclscore.entity/-screen-timer-direction/index.html) |


## Constructors


| | |
|---|---|
| [CreateTimerAction](-create-timer-action.html) | [androidJvm]<br>constructor(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), format: [ScreenTimerFormat](../../../tv.mycujoo.mclscore.entity/-screen-timer-format/index.html) = ScreenTimerFormat.MINUTES_SECONDS, direction: [ScreenTimerDirection](../../../tv.mycujoo.mclscore.entity/-screen-timer-direction/index.html) = ScreenTimerDirection.UP, startValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0, capValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [isEligible](../is-eligible.html) | [androidJvm]<br>open fun [isEligible](../is-eligible.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>return eligibility of action at given offset. Defaults to true |
| [isTillNowOrInRange](../is-till-now-or-in-range.html) | [androidJvm]<br>fun [isTillNowOrInRange](../is-till-now-or-in-range.html)(currentTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if an action belongs to this moment or is within this moment and next 1000ms |
| [updateOffset](update-offset.html) | [androidJvm]<br>open override fun [updateOffset](update-offset.html)(newOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [AnnotationAction.CreateTimerAction](index.html)<br>region Abstract functions |


## Properties


| Name | Summary |
|---|---|
| [absoluteTime](absolute-time.html) | [androidJvm]<br>open override var [absoluteTime](absolute-time.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the absolute time that action should happen at |
| [capValue](cap-value.html) | [androidJvm]<br>val [capValue](cap-value.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>max value that timer considers valid |
| [direction](direction.html) | [androidJvm]<br>val [direction](direction.html): [ScreenTimerDirection](../../../tv.mycujoo.mclscore.entity/-screen-timer-direction/index.html)<br>time is decreased or increased |
| [format](format.html) | [androidJvm]<br>val [format](format.html): [ScreenTimerFormat](../../../tv.mycujoo.mclscore.entity/-screen-timer-format/index.html)<br>format of time, MM:SS or just SS |
| [id](id.html) | [androidJvm]<br>open override val [id](id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>region Abstract fields |
| [name](name.html) | [androidJvm]<br>val [name](name.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>name of timer |
| [offset](offset.html) | [androidJvm]<br>open override var [offset](offset.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the offset that action should happen at |
| [priority](priority.html) | [androidJvm]<br>open override val [priority](priority.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1000<br>priority of the action, compared to other actions |
| [startValue](start-value.html) | [androidJvm]<br>val [startValue](start-value.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0<br>start value of timer |

