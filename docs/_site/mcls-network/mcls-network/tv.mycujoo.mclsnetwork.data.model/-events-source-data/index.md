//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.data.model](../index.md)/[EventsSourceData](index.md)

# EventsSourceData

[androidJvm]\
@JsonClass(generateAdapter = true)

data class [EventsSourceData](index.md)(val events: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EventSourceData](../-event-source-data/index.md)&gt;, val previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)

## Constructors

| | |
|---|---|
| [EventsSourceData](-events-source-data.md) | [androidJvm]<br>fun [EventsSourceData](-events-source-data.md)(events: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EventSourceData](../-event-source-data/index.md)&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |

## Properties

| Name | Summary |
|---|---|
| [events](events.md) | [androidJvm]<br>@Json(name = &quot;events&quot;)<br>val [events](events.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EventSourceData](../-event-source-data/index.md)&gt; |
| [nextPageToken](next-page-token.md) | [androidJvm]<br>@Json(name = &quot;next_page_token&quot;)<br>val [nextPageToken](next-page-token.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [previousPageToken](previous-page-token.md) | [androidJvm]<br>@Json(name = &quot;previous_page_token&quot;)<br>val [previousPageToken](previous-page-token.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
