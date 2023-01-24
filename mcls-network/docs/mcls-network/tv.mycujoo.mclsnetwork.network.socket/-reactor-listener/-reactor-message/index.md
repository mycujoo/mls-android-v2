---
title: ReactorMessage
---
//[mcls-network](../../../../index.html)/[tv.mycujoo.mclsnetwork.network.socket](../../index.html)/[ReactorListener](../index.html)/[ReactorMessage](index.html)



# ReactorMessage



[androidJvm]\
sealed class [ReactorMessage](index.html)



## Types


| Name | Summary |
|---|---|
| [CounterUpdate](-counter-update/index.html) | [androidJvm]<br>data class [CounterUpdate](-counter-update/index.html)(val counts: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ReactorListener.ReactorMessage](index.html) |
| [EventUpdate](-event-update/index.html) | [androidJvm]<br>data class [EventUpdate](-event-update/index.html)(val eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val updatedEventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ReactorListener.ReactorMessage](index.html) |
| [TimelineUpdate](-timeline-update/index.html) | [androidJvm]<br>data class [TimelineUpdate](-timeline-update/index.html)(val timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val updatedEventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [ReactorListener.ReactorMessage](index.html) |
| [Unsupported](-unsupported/index.html) | [androidJvm]<br>data class [Unsupported](-unsupported/index.html)(val message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) : [ReactorListener.ReactorMessage](index.html) |


## Inheritors


| Name |
|---|
| [EventUpdate](-event-update/index.html) |
| [CounterUpdate](-counter-update/index.html) |
| [TimelineUpdate](-timeline-update/index.html) |
| [Unsupported](-unsupported/index.html) |

