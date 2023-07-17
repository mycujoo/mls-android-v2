---
title: EventSourceData
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.data.model](../index.html)/[EventSourceData](index.html)



# EventSourceData



[androidJvm]\
@JsonClass(generateAdapter = true)



data class [EventSourceData](index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val thumbnailUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val poster_url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val physical: [PhysicalSourceData](../-physical-source-data/index.html)?, val organiser: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val start_time: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val streams: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[StreamSourceData](../-stream-source-data/index.html)&gt; = emptyList(), val timezone: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val timeline_ids: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = emptyList(), val metadata: [MetadataSourceData](../-metadata-source-data/index.html)?, val is_test: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, val is_protected: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)



## Constructors


| | |
|---|---|
| [EventSourceData](-event-source-data.html) | [androidJvm]<br>constructor(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, thumbnailUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, poster_url: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, physical: [PhysicalSourceData](../-physical-source-data/index.html)?, organiser: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, start_time: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), status: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, streams: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[StreamSourceData](../-stream-source-data/index.html)&gt; = emptyList(), timezone: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, timeline_ids: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = emptyList(), metadata: [MetadataSourceData](../-metadata-source-data/index.html)?, is_test: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, is_protected: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false) |


## Properties


| Name | Summary |
|---|---|
| [description](description.html) | [androidJvm]<br>@Json(name = &quot;description&quot;)<br>val [description](description.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [id](id.html) | [androidJvm]<br>@Json(name = &quot;id&quot;)<br>val [id](id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [is_protected](is_protected.html) | [androidJvm]<br>@Json(name = &quot;isProtected&quot;)<br>val [is_protected](is_protected.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [is_test](is_test.html) | [androidJvm]<br>@Json(name = &quot;isTest&quot;)<br>val [is_test](is_test.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false |
| [metadata](metadata.html) | [androidJvm]<br>@Json(name = &quot;metadata&quot;)<br>val [metadata](metadata.html): [MetadataSourceData](../-metadata-source-data/index.html)? |
| [organiser](organiser.html) | [androidJvm]<br>@Json(name = &quot;organiser&quot;)<br>val [organiser](organiser.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [physical](physical.html) | [androidJvm]<br>@Json(name = &quot;physical&quot;)<br>val [physical](physical.html): [PhysicalSourceData](../-physical-source-data/index.html)? |
| [poster_url](poster_url.html) | [androidJvm]<br>@Json(name = &quot;posterUrl&quot;)<br>val [poster_url](poster_url.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [start_time](start_time.html) | [androidJvm]<br>@Json(name = &quot;startTime&quot;)<br>val [start_time](start_time.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [status](status.html) | [androidJvm]<br>@Json(name = &quot;status&quot;)<br>val [status](status.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [streams](streams.html) | [androidJvm]<br>@Json(name = &quot;streams&quot;)<br>val [streams](streams.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[StreamSourceData](../-stream-source-data/index.html)&gt; |
| [thumbnailUrl](thumbnail-url.html) | [androidJvm]<br>@Json(name = &quot;thumbnailUrl&quot;)<br>val [thumbnailUrl](thumbnail-url.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [timeline_ids](timeline_ids.html) | [androidJvm]<br>@Json(name = &quot;timelineIds&quot;)<br>val [timeline_ids](timeline_ids.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; |
| [timezone](timezone.html) | [androidJvm]<br>@Json(name = &quot;timezone&quot;)<br>val [timezone](timezone.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [title](title.html) | [androidJvm]<br>@Json(name = &quot;title&quot;)<br>val [title](title.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

