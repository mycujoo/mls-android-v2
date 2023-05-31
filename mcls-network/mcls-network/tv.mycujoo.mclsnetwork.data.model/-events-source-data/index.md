---
title: EventsSourceData
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.data.model](../index.html)/[EventsSourceData](index.html)



# EventsSourceData



[androidJvm]\
@JsonClass(generateAdapter = true)



data class [EventsSourceData](index.html)(val events: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EventSourceData](../-event-source-data/index.html)&gt;, val previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)



## Constructors


| | |
|---|---|
| [EventsSourceData](-events-source-data.html) | [androidJvm]<br>constructor(events: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EventSourceData](../-event-source-data/index.html)&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |


## Properties


| Name | Summary |
|---|---|
| [events](events.html) | [androidJvm]<br>@Json(name = &quot;events&quot;)<br>val [events](events.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EventSourceData](../-event-source-data/index.html)&gt; |
| [nextPageToken](next-page-token.html) | [androidJvm]<br>@Json(name = &quot;next_page_token&quot;)<br>val [nextPageToken](next-page-token.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [previousPageToken](previous-page-token.html) | [androidJvm]<br>@Json(name = &quot;previous_page_token&quot;)<br>val [previousPageToken](previous-page-token.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |

