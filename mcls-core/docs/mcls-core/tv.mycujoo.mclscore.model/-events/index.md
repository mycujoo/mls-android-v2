---
title: Events
---
//[mcls-core](../../../index.html)/[tv.mycujoo.mclscore.model](../index.html)/[Events](index.html)



# Events



[androidJvm]\
data class [Events](index.html)(val eventEntities: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EventEntity](../-event-entity/index.html)&gt;, val previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)

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
| [Events](-events.html) | [androidJvm]<br>fun [Events](-events.html)(eventEntities: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EventEntity](../-event-entity/index.html)&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |


## Properties


| Name | Summary |
|---|---|
| [eventEntities](event-entities.html) | [androidJvm]<br>val [eventEntities](event-entities.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[EventEntity](../-event-entity/index.html)&gt; |
| [nextPageToken](next-page-token.html) | [androidJvm]<br>val [nextPageToken](next-page-token.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [previousPageToken](previous-page-token.html) | [androidJvm]<br>val [previousPageToken](previous-page-token.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |

