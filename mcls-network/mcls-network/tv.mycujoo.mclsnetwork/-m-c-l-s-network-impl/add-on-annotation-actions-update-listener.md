---
title: addOnAnnotationActionsUpdateListener
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork](../index.html)/[MCLSNetworkImpl](index.html)/[addOnAnnotationActionsUpdateListener](add-on-annotation-actions-update-listener.html)



# addOnAnnotationActionsUpdateListener



[androidJvm]\
open override fun [addOnAnnotationActionsUpdateListener](add-on-annotation-actions-update-listener.html)(onTimelineUpdate: [MCLSNetwork.OnTimelineUpdateListener](../-m-c-l-s-network/-on-timeline-update-listener/index.html))



Adds an annotation actions change listener. And sends the current state of MCLSEvent (if joined before)



Listeners of this type are only triggered after [joinEventAndTimelineUpdates](join-event-and-timeline-updates.html) is executed.



#### Parameters


androidJvm

| | |
|---|---|
| onTimelineUpdate | can be expressed as an interface implementation or as a function callback |




