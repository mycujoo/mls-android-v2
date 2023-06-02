---
title: setAnnotationsByEventId
---
//[mcls-tv](../../../index.html)/[tv.mycujoo.mcls.tv](../index.html)/[MCLSTVFragment](index.html)/[setAnnotationsByEventId](set-annotations-by-event-id.html)



# setAnnotationsByEventId



[androidJvm]\
fun [setAnnotationsByEventId](set-annotations-by-event-id.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))



sets annotations into annotation view when needed. using this ignores the disable marker in [playEvent](play-event.html)



#### Parameters


androidJvm

| | |
|---|---|
| eventId | MCLS Event Id, we extract the first Timeline Id, and set annotations based on it. |



#### Throws


| | |
|---|---|
| [PublicKeyNotSetException](../-public-key-not-set-exception/index.html) | when public key is not set |



