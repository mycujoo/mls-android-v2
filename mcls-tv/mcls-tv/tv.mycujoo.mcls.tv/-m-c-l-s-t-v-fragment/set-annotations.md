---
title: setAnnotations
---
//[mcls-tv](../../../index.html)/[tv.mycujoo.mcls.tv](../index.html)/[MCLSTVFragment](index.html)/[setAnnotations](set-annotations.html)



# setAnnotations



[androidJvm]\
fun [setAnnotations](set-annotations.html)(event: MCLSEvent)



sets annotations into annotation view when needed. using this ignores the disable marker in [playEvent](play-event.html) To use other timelines, please use [setAnnotationActionsByTimelineId](set-annotation-actions-by-timeline-id.html)



#### Parameters


androidJvm

| | |
|---|---|
| event | MCLSEvent. We use the first timeline id and set annotations based on it. |



#### Throws


| | |
|---|---|
| [PublicKeyNotSetException](../-public-key-not-set-exception/index.html) | when public key is not set |



