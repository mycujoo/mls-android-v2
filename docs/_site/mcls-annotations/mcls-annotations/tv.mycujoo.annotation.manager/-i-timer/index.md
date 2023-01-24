//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.manager](../index.md)/[ITimer](index.md)

# ITimer

[androidJvm]\
interface [ITimer](index.md)

## Functions

| Name | Summary |
|---|---|
| [adjust](adjust.md) | [androidJvm]<br>abstract fun [adjust](adjust.md)(adjustTimer: [TimerEntity.AdjustTimer](../-timer-entity/-adjust-timer/index.md), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [getTime](get-time.md) | [androidJvm]<br>abstract fun [getTime](get-time.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [pause](pause.md) | [androidJvm]<br>abstract fun [pause](pause.md)(pauseTimer: [TimerEntity.PauseTimer](../-timer-entity/-pause-timer/index.md), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [skip](skip.md) | [androidJvm]<br>abstract fun [skip](skip.md)(skipTimer: [TimerEntity.SkipTimer](../-timer-entity/-skip-timer/index.md), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [start](start.md) | [androidJvm]<br>abstract fun [start](start.md)(startTimer: [TimerEntity.StartTimer](../-timer-entity/-start-timer/index.md), now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |

## Inheritors

| Name |
|---|
| [TimerVariable](../-timer-variable/index.md) |
