---
title: ITimer
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.manager](../index.html)/[ITimer](index.html)



# ITimer

interface [ITimer](index.html)

#### Inheritors


| |
|---|
| [TimerVariable](../-timer-variable/index.html) |


## Functions


| Name | Summary |
|---|---|
| [adjust](adjust.html) | [androidJvm]<br>abstract fun [adjust](adjust.html)(adjustTimer: [TimerEntity.AdjustTimer](../-timer-entity/-adjust-timer/index.html), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [getTime](get-time.html) | [androidJvm]<br>abstract fun [getTime](get-time.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [pause](pause.html) | [androidJvm]<br>abstract fun [pause](pause.html)(pauseTimer: [TimerEntity.PauseTimer](../-timer-entity/-pause-timer/index.html), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [skip](skip.html) | [androidJvm]<br>abstract fun [skip](skip.html)(skipTimer: [TimerEntity.SkipTimer](../-timer-entity/-skip-timer/index.html), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [start](start.html) | [androidJvm]<br>abstract fun [start](start.html)(startTimer: [TimerEntity.StartTimer](../-timer-entity/-start-timer/index.html), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |

