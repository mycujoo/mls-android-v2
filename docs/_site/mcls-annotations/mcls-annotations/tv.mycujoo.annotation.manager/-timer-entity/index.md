//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.manager](../index.md)/[TimerEntity](index.md)

# TimerEntity

[androidJvm]\
sealed class [TimerEntity](index.md)

## Types

| Name | Summary |
|---|---|
| [AdjustTimer](-adjust-timer/index.md) | [androidJvm]<br>data class [AdjustTimer](-adjust-timer/index.md)(var name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val value: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [TimerEntity](index.md) |
| [PauseTimer](-pause-timer/index.md) | [androidJvm]<br>data class [PauseTimer](-pause-timer/index.md)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [TimerEntity](index.md) |
| [SkipTimer](-skip-timer/index.md) | [androidJvm]<br>data class [SkipTimer](-skip-timer/index.md)(var name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val value: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [TimerEntity](index.md) |
| [StartTimer](-start-timer/index.md) | [androidJvm]<br>data class [StartTimer](-start-timer/index.md)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [TimerEntity](index.md) |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [androidJvm]<br>abstract val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [offset](offset.md) | [androidJvm]<br>abstract val [offset](offset.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [priority](priority.md) | [androidJvm]<br>abstract val [priority](priority.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

## Inheritors

| Name |
|---|
| [StartTimer](-start-timer/index.md) |
| [PauseTimer](-pause-timer/index.md) |
| [AdjustTimer](-adjust-timer/index.md) |
| [SkipTimer](-skip-timer/index.md) |
