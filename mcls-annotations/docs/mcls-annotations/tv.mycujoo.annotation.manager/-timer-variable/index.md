---
title: TimerVariable
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.manager](../index.html)/[TimerVariable](index.html)



# TimerVariable



[androidJvm]\
class [TimerVariable](index.html)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), format: ScreenTimerFormat, direction: ScreenTimerDirection, startValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), capValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [ITimer](../-i-timer/index.html)



## Constructors


| | |
|---|---|
| [TimerVariable](-timer-variable.html) | [androidJvm]<br>fun [TimerVariable](-timer-variable.html)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), format: ScreenTimerFormat, direction: ScreenTimerDirection, startValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), capValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [adjust](adjust.html) | [androidJvm]<br>open override fun [adjust](adjust.html)(adjustTimer: [TimerEntity.AdjustTimer](../-timer-entity/-adjust-timer/index.html), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [getTime](get-time.html) | [androidJvm]<br>open override fun [getTime](get-time.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>region Over-ridden functions |
| [pause](pause.html) | [androidJvm]<br>open override fun [pause](pause.html)(pauseTimer: [TimerEntity.PauseTimer](../-timer-entity/-pause-timer/index.html), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [skip](skip.html) | [androidJvm]<br>open override fun [skip](skip.html)(skipTimer: [TimerEntity.SkipTimer](../-timer-entity/-skip-timer/index.html), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [start](start.html) | [androidJvm]<br>open override fun [start](start.html)(startTimer: [TimerEntity.StartTimer](../-timer-entity/-start-timer/index.html), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |


## Properties


| Name | Summary |
|---|---|
| [name](name.html) | [androidJvm]<br>val [name](name.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

