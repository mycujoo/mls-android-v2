//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.data.model](../index.md)/[EventSourceData](index.md)

# EventSourceData

[androidJvm]\
@JsonClass(generateAdapter = true)

data class [EventSourceData](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val thumbnailUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val poster_url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val locationSourceData: [LocationSourceData](../-location-source-data/index.md), val organiser: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val start_time: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val streams: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[StreamSourceData](../-stream-source-data/index.md)&gt;, val timezone: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val timeline_ids: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, val metadata: [MetadataSourceData](../-metadata-source-data/index.md), val is_test: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val is_protected: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))

## Constructors

| | |
|---|---|
| [EventSourceData](-event-source-data.md) | [androidJvm]<br>fun [EventSourceData](-event-source-data.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), thumbnailUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), poster_url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, locationSourceData: [LocationSourceData](../-location-source-data/index.md), organiser: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), start_time: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), streams: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[StreamSourceData](../-stream-source-data/index.md)&gt;, timezone: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), timeline_ids: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;, metadata: [MetadataSourceData](../-metadata-source-data/index.md), is_test: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), is_protected: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [description](description.md) | [androidJvm]<br>@Json(name = &quot;description&quot;)<br>val [description](description.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [id](id.md) | [androidJvm]<br>@Json(name = &quot;id&quot;)<br>val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [is_protected](is_protected.md) | [androidJvm]<br>@Json(name = &quot;is_protected&quot;)<br>val [is_protected](is_protected.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [is_test](is_test.md) | [androidJvm]<br>@Json(name = &quot;is_test&quot;)<br>val [is_test](is_test.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [locationSourceData](location-source-data.md) | [androidJvm]<br>@Json(name = &quot;location&quot;)<br>val [locationSourceData](location-source-data.md): [LocationSourceData](../-location-source-data/index.md) |
| [metadata](metadata.md) | [androidJvm]<br>@Json(name = &quot;metadata&quot;)<br>val [metadata](metadata.md): [MetadataSourceData](../-metadata-source-data/index.md) |
| [organiser](organiser.md) | [androidJvm]<br>@Json(name = &quot;organiser&quot;)<br>val [organiser](organiser.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [poster_url](poster_url.md) | [androidJvm]<br>@Json(name = &quot;poster_url&quot;)<br>val [poster_url](poster_url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [start_time](start_time.md) | [androidJvm]<br>@Json(name = &quot;start_time&quot;)<br>val [start_time](start_time.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [status](status.md) | [androidJvm]<br>@Json(name = &quot;status&quot;)<br>val [status](status.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [streams](streams.md) | [androidJvm]<br>@Json(name = &quot;streams&quot;)<br>val [streams](streams.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[StreamSourceData](../-stream-source-data/index.md)&gt; |
| [thumbnailUrl](thumbnail-url.md) | [androidJvm]<br>@Json(name = &quot;thumbnail_url&quot;)<br>val [thumbnailUrl](thumbnail-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [timeline_ids](timeline_ids.md) | [androidJvm]<br>@Json(name = &quot;timeline_ids&quot;)<br>val [timeline_ids](timeline_ids.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [timezone](timezone.md) | [androidJvm]<br>@Json(name = &quot;timezone&quot;)<br>val [timezone](timezone.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [title](title.md) | [androidJvm]<br>@Json(name = &quot;title&quot;)<br>val [title](title.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
