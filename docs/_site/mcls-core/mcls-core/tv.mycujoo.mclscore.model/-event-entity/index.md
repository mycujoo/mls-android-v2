//[mcls-core](../../../index.md)/[tv.mycujoo.mclscore.model](../index.md)/[EventEntity](index.md)

# EventEntity

[androidJvm]\
data class [EventEntity](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val thumbnailUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val poster_url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val location: [Location](../-location/index.md)?, val organiser: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val start_time: [Calendar](https://developer.android.com/reference/kotlin/java/util/Calendar.html)?, val status: [EventStatus](../../tv.mycujoo.mclscore.entity/-event-status/index.md), val streams: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Stream](../-stream/index.md)&gt;, val timezone: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val timeline_ids: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, val metadata: [Metadata](../-metadata/index.md)?, val is_test: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val isMLS: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, val is_protected: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

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
| [EventEntity](-event-entity.md) | [androidJvm]<br>fun [EventEntity](-event-entity.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, thumbnailUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, poster_url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, location: [Location](../-location/index.md)?, organiser: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, start_time: [Calendar](https://developer.android.com/reference/kotlin/java/util/Calendar.html)?, status: [EventStatus](../../tv.mycujoo.mclscore.entity/-event-status/index.md), streams: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Stream](../-stream/index.md)&gt;, timezone: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, timeline_ids: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, metadata: [Metadata](../-metadata/index.md)?, is_test: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), isMLS: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, is_protected: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |

## Functions

| Name | Summary |
|---|---|
| [getFormattedStartTimeDate](get-formatted-start-time-date.md) | [androidJvm]<br>fun [getFormattedStartTimeDate](get-formatted-start-time-date.md)(locale: [Locale](https://developer.android.com/reference/kotlin/java/util/Locale.html)?): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [streamStatus](stream-status.md) | [androidJvm]<br>fun [streamStatus](stream-status.md)(): [StreamStatus](../../tv.mycujoo.mclscore.entity/-stream-status/index.md) |

## Properties

| Name | Summary |
|---|---|
| [description](description.md) | [androidJvm]<br>val [description](description.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [id](id.md) | [androidJvm]<br>val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [is_protected](is_protected.md) | [androidJvm]<br>val [is_protected](is_protected.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [is_test](is_test.md) | [androidJvm]<br>val [is_test](is_test.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isMLS](is-m-l-s.md) | [androidJvm]<br>val [isMLS](is-m-l-s.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true |
| [location](location.md) | [androidJvm]<br>val [location](location.md): [Location](../-location/index.md)? |
| [metadata](metadata.md) | [androidJvm]<br>val [metadata](metadata.md): [Metadata](../-metadata/index.md)? |
| [organiser](organiser.md) | [androidJvm]<br>val [organiser](organiser.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [poster_url](poster_url.md) | [androidJvm]<br>val [poster_url](poster_url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [start_time](start_time.md) | [androidJvm]<br>val [start_time](start_time.md): [Calendar](https://developer.android.com/reference/kotlin/java/util/Calendar.html)? |
| [status](status.md) | [androidJvm]<br>val [status](status.md): [EventStatus](../../tv.mycujoo.mclscore.entity/-event-status/index.md) |
| [streams](streams.md) | [androidJvm]<br>val [streams](streams.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Stream](../-stream/index.md)&gt; |
| [thumbnailUrl](thumbnail-url.md) | [androidJvm]<br>val [thumbnailUrl](thumbnail-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [timeline_ids](timeline_ids.md) | [androidJvm]<br>val [timeline_ids](timeline_ids.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [timezone](timezone.md) | [androidJvm]<br>val [timezone](timezone.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [title](title.md) | [androidJvm]<br>val [title](title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
