//[mcls-core](../../../../index.md)/[tv.mycujoo.mclscore.model](../../index.md)/[AnnotationAction](../index.md)/[CreateTimerAction](index.md)

# CreateTimerAction

[androidJvm]\
data class [CreateTimerAction](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val format: [ScreenTimerFormat](../../../tv.mycujoo.mclscore.entity/-screen-timer-format/index.md) = ScreenTimerFormat.MINUTES_SECONDS, val direction: [ScreenTimerDirection](../../../tv.mycujoo.mclscore.entity/-screen-timer-direction/index.md) = ScreenTimerDirection.UP, val startValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0, val capValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [AnnotationAction](../index.md)

Action to create a Timer

#### See also

androidJvm

| |
|---|
| [ScreenTimerFormat](../../../tv.mycujoo.mclscore.entity/-screen-timer-format/index.md) |
| [ScreenTimerDirection](../../../tv.mycujoo.mclscore.entity/-screen-timer-direction/index.md) |

## Constructors

| | |
|---|---|
| [CreateTimerAction](-create-timer-action.md) | [androidJvm]<br>fun [CreateTimerAction](-create-timer-action.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), format: [ScreenTimerFormat](../../../tv.mycujoo.mclscore.entity/-screen-timer-format/index.md) = ScreenTimerFormat.MINUTES_SECONDS, direction: [ScreenTimerDirection](../../../tv.mycujoo.mclscore.entity/-screen-timer-direction/index.md) = ScreenTimerDirection.UP, startValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0, capValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [isEligible](../is-eligible.md) | [androidJvm]<br>open fun [isEligible](../is-eligible.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>return eligibility of action at given offset. Defaults to true |
| [isTillNowOrInRange](../is-till-now-or-in-range.md) | [androidJvm]<br>fun [isTillNowOrInRange](../is-till-now-or-in-range.md)(currentTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if an action belongs to this moment or is within this moment and next 1000ms |
| [updateOffset](update-offset.md) | [androidJvm]<br>open override fun [updateOffset](update-offset.md)(newOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [AnnotationAction.CreateTimerAction](index.md)<br>region Abstract functions |

## Properties

| Name | Summary |
|---|---|
| [absoluteTime](absolute-time.md) | [androidJvm]<br>open override var [absoluteTime](absolute-time.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the absolute time that action should happen at |
| [capValue](cap-value.md) | [androidJvm]<br>val [capValue](cap-value.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>max value that timer considers valid |
| [direction](direction.md) | [androidJvm]<br>val [direction](direction.md): [ScreenTimerDirection](../../../tv.mycujoo.mclscore.entity/-screen-timer-direction/index.md)<br>time is decreased or increased |
| [format](format.md) | [androidJvm]<br>val [format](format.md): [ScreenTimerFormat](../../../tv.mycujoo.mclscore.entity/-screen-timer-format/index.md)<br>format of time, MM:SS or just SS |
| [id](id.md) | [androidJvm]<br>open override val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>region Abstract fields |
| [name](name.md) | [androidJvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>name of timer |
| [offset](offset.md) | [androidJvm]<br>open override var [offset](offset.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the offset that action should happen at |
| [priority](priority.md) | [androidJvm]<br>open override val [priority](priority.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1000<br>priority of the action, compared to other actions |
| [startValue](start-value.md) | [androidJvm]<br>val [startValue](start-value.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0<br>start value of timer |
