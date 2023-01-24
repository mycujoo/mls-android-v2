---
title: EventEntity
---
//[mcls-core](../../../index.html)/[tv.mycujoo.mclscore.model](../index.html)/[EventEntity](index.html)



# EventEntity



[androidJvm]\
data class [EventEntity](index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val thumbnailUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val poster_url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val location: [Location](../-location/index.html)?, val organiser: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val start_time: [Calendar](https://developer.android.com/reference/kotlin/java/util/Calendar.html)?, val status: [EventStatus](../../tv.mycujoo.mclscore.entity/-event-status/index.html), val streams: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Stream](../-stream/index.html)&gt;, val timezone: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val timeline_ids: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, val metadata: [Metadata](../-metadata/index.html)?, val is_test: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val isMLS: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val is_protected: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

This data class is used to represent the MCLS Event data type. We are using this class as the base of communication between MCLS Player, MCLS Network to protect the SDKs from future JSON changes inside the API.



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



## Constructors


| | |
|---|---|
| [EventEntity](-event-entity.html) | [androidJvm]<br>fun [EventEntity](-event-entity.html)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, thumbnailUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, poster_url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, location: [Location](../-location/index.html)?, organiser: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, start_time: [Calendar](https://developer.android.com/reference/kotlin/java/util/Calendar.html)?, status: [EventStatus](../../tv.mycujoo.mclscore.entity/-event-status/index.html), streams: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Stream](../-stream/index.html)&gt;, timezone: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, timeline_ids: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, metadata: [Metadata](../-metadata/index.html)?, is_test: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), isMLS: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, is_protected: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |


## Functions


| Name | Summary |
|---|---|
| [getFormattedStartTimeDate](get-formatted-start-time-date.html) | [androidJvm]<br>fun [getFormattedStartTimeDate](get-formatted-start-time-date.html)(locale: [Locale](https://developer.android.com/reference/kotlin/java/util/Locale.html)?): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [streamStatus](stream-status.html) | [androidJvm]<br>fun [streamStatus](stream-status.html)(): [StreamStatus](../../tv.mycujoo.mclscore.entity/-stream-status/index.html) |


## Properties


| Name | Summary |
|---|---|
| [description](description.html) | [androidJvm]<br>val [description](description.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [id](id.html) | [androidJvm]<br>val [id](id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [is_protected](is_protected.html) | [androidJvm]<br>val [is_protected](is_protected.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [is_test](is_test.html) | [androidJvm]<br>val [is_test](is_test.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isMLS](is-m-l-s.html) | [androidJvm]<br>val [isMLS](is-m-l-s.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true |
| [location](location.html) | [androidJvm]<br>val [location](location.html): [Location](../-location/index.html)? |
| [metadata](metadata.html) | [androidJvm]<br>val [metadata](metadata.html): [Metadata](../-metadata/index.html)? |
| [organiser](organiser.html) | [androidJvm]<br>val [organiser](organiser.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [poster_url](poster_url.html) | [androidJvm]<br>val [poster_url](poster_url.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [start_time](start_time.html) | [androidJvm]<br>val [start_time](start_time.html): [Calendar](https://developer.android.com/reference/kotlin/java/util/Calendar.html)? |
| [status](status.html) | [androidJvm]<br>val [status](status.html): [EventStatus](../../tv.mycujoo.mclscore.entity/-event-status/index.html) |
| [streams](streams.html) | [androidJvm]<br>val [streams](streams.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Stream](../-stream/index.html)&gt; |
| [thumbnailUrl](thumbnail-url.html) | [androidJvm]<br>val [thumbnailUrl](thumbnail-url.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [timeline_ids](timeline_ids.html) | [androidJvm]<br>val [timeline_ids](timeline_ids.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [timezone](timezone.html) | [androidJvm]<br>val [timezone](timezone.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [title](title.html) | [androidJvm]<br>val [title](title.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

