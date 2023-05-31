---
title: TimerEntity
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.manager](../index.html)/[TimerEntity](index.html)



# TimerEntity

sealed class [TimerEntity](index.html)

#### Inheritors


| |
|---|
| [StartTimer](-start-timer/index.html) |
| [PauseTimer](-pause-timer/index.html) |
| [AdjustTimer](-adjust-timer/index.html) |
| [SkipTimer](-skip-timer/index.html) |


## Types


| Name | Summary |
|---|---|
| [AdjustTimer](-adjust-timer/index.html) | [androidJvm]<br>data class [AdjustTimer](-adjust-timer/index.html)(var name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val value: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [TimerEntity](index.html) |
| [PauseTimer](-pause-timer/index.html) | [androidJvm]<br>data class [PauseTimer](-pause-timer/index.html)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [TimerEntity](index.html) |
| [SkipTimer](-skip-timer/index.html) | [androidJvm]<br>data class [SkipTimer](-skip-timer/index.html)(var name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val value: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [TimerEntity](index.html) |
| [StartTimer](-start-timer/index.html) | [androidJvm]<br>data class [StartTimer](-start-timer/index.html)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [TimerEntity](index.html) |


## Properties


| Name | Summary |
|---|---|
| [name](name.html) | [androidJvm]<br>abstract val [name](name.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [offset](offset.html) | [androidJvm]<br>abstract val [offset](offset.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [priority](priority.html) | [androidJvm]<br>abstract val [priority](priority.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

