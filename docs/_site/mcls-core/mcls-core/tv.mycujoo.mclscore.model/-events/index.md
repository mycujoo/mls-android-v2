//[mcls-core](../../../index.md)/[tv.mycujoo.mclscore.model](../index.md)/[Events](index.md)

# Events

[androidJvm]\
data class [Events](index.md)(val eventEntities: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EventEntity](../-event-entity/index.md)&gt;, val previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)

Used as a safe representation of the event list MCLS request.

#### Parameters

androidJvm

| | |
|---|---|
| eventEntities | List of entities |
| previousPageToken | A token to go back in pagination |
| nextPageToken | A token to go forward in pagination |

## Constructors

| | |
|---|---|
| [Events](-events.md) | [androidJvm]<br>fun [Events](-events.md)(eventEntities: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EventEntity](../-event-entity/index.md)&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |

## Properties

| Name | Summary |
|---|---|
| [eventEntities](event-entities.md) | [androidJvm]<br>val [eventEntities](event-entities.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EventEntity](../-event-entity/index.md)&gt; |
| [nextPageToken](next-page-token.md) | [androidJvm]<br>val [nextPageToken](next-page-token.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [previousPageToken](previous-page-token.md) | [androidJvm]<br>val [previousPageToken](previous-page-token.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
