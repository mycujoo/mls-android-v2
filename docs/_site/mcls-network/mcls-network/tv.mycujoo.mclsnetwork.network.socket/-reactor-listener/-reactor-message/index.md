//[mcls-network](../../../../index.md)/[tv.mycujoo.mclsnetwork.network.socket](../../index.md)/[ReactorListener](../index.md)/[ReactorMessage](index.md)

# ReactorMessage

[androidJvm]\
sealed class [ReactorMessage](index.md)

## Types

| Name | Summary |
|---|---|
| [CounterUpdate](-counter-update/index.md) | [androidJvm]<br>data class [CounterUpdate](-counter-update/index.md)(val counts: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ReactorListener.ReactorMessage](index.md) |
| [EventUpdate](-event-update/index.md) | [androidJvm]<br>data class [EventUpdate](-event-update/index.md)(val eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val updatedEventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ReactorListener.ReactorMessage](index.md) |
| [TimelineUpdate](-timeline-update/index.md) | [androidJvm]<br>data class [TimelineUpdate](-timeline-update/index.md)(val timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val updatedEventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ReactorListener.ReactorMessage](index.md) |
| [Unsupported](-unsupported/index.md) | [androidJvm]<br>data class [Unsupported](-unsupported/index.md)(val message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) : [ReactorListener.ReactorMessage](index.md) |

## Inheritors

| Name |
|---|
| [EventUpdate](-event-update/index.md) |
| [CounterUpdate](-counter-update/index.md) |
| [TimelineUpdate](-timeline-update/index.md) |
| [Unsupported](-unsupported/index.md) |
