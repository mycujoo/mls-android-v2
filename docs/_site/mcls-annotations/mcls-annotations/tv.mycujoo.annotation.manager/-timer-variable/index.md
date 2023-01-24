//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.manager](../index.md)/[TimerVariable](index.md)

# TimerVariable

[androidJvm]\
class [TimerVariable](index.md)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), format: ScreenTimerFormat, direction: ScreenTimerDirection, startValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), capValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [ITimer](../-i-timer/index.md)

## Constructors

| | |
|---|---|
| [TimerVariable](-timer-variable.md) | [androidJvm]<br>fun [TimerVariable](-timer-variable.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), format: ScreenTimerFormat, direction: ScreenTimerDirection, startValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), capValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [adjust](adjust.md) | [androidJvm]<br>open override fun [adjust](adjust.md)(adjustTimer: [TimerEntity.AdjustTimer](../-timer-entity/-adjust-timer/index.md), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [getTime](get-time.md) | [androidJvm]<br>open override fun [getTime](get-time.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>region Over-ridden functions |
| [pause](pause.md) | [androidJvm]<br>open override fun [pause](pause.md)(pauseTimer: [TimerEntity.PauseTimer](../-timer-entity/-pause-timer/index.md), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [skip](skip.md) | [androidJvm]<br>open override fun [skip](skip.md)(skipTimer: [TimerEntity.SkipTimer](../-timer-entity/-skip-timer/index.md), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [start](start.md) | [androidJvm]<br>open override fun [start](start.md)(startTimer: [TimerEntity.StartTimer](../-timer-entity/-start-timer/index.md), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [androidJvm]<br>val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
