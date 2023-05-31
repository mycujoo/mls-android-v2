---
title: MCLSEvent
---
//[mcls-core](../../../index.html)/[tv.mycujoo.mclscore.model](../index.html)/[MCLSEvent](index.html)/[MCLSEvent](-m-c-l-s-event.html)



# MCLSEvent



[androidJvm]\
constructor(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, thumbnailUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, poster_url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, location: [Physical](../-physical/index.html)?, organiser: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, start_time: [Calendar](https://developer.android.com/reference/kotlin/java/util/Calendar.html)?, status: [EventStatus](../../tv.mycujoo.mclscore.entity/-event-status/index.html), streams: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[MCLSStream](../-m-c-l-s-stream/index.html)&gt;, timezone: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, timeline_ids: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, metadata: [Metadata](../-metadata/index.html)?, is_test: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), isMLS: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, is_protected: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)



#### Parameters


androidJvm

| | |
|---|---|
| id | Event Id |
| title | Event Title |
| description | Event Description |
| thumbnailUrl | Event Thumbnail |
| poster_url | Event Poster URL |
| location | Event Geo-Location |
| organiser | Event Organizer |
| start_time | Event Time, we are using Calendar to represent time in Java to minimize dependencies |
| status | Event Status, @see EventStatus |
| streams | List Of Stream Object that represents the links the player can play. |
| timezone | Timezone |
| timeline_ids | List of Ids can be used to pull annotation actions. |
| metadata | Generic Metadata Holder |
| is_test | an indication if this is a test event |
| isMLS | is used to indicate when the Event is Factored in-code, so we don't pull updates to override this stream and event. |
| is_protected |




