---
title: joinEventAndTimelineUpdates
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork](../index.html)/[MCLSNetwork](index.html)/[joinEventAndTimelineUpdates](join-event-and-timeline-updates.html)



# joinEventAndTimelineUpdates



[androidJvm]\
abstract fun [joinEventAndTimelineUpdates](join-event-and-timeline-updates.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), scope: CoroutineScope)



Subscribes to changes in MCLSEvent and timeline AnnotationActions listeners



When changes happen listeners added from [addOnEventUpdateListener](add-on-event-update-listener.html) and [addOnAnnotationActionsUpdateListener](add-on-annotation-actions-update-listener.html) are informed about the updates.



Currently only 1 event is listened to at any given moment, so when [joinEventAndTimelineUpdates](join-event-and-timeline-updates.html) is triggered multiple times, only the last eventId is being monitored




