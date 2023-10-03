---
title: IReactorSocket
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.network.socket](../index.html)/[IReactorSocket](index.html)



# IReactorSocket

interface [IReactorSocket](index.html)

Network Socket for event/timeline updates



#### Inheritors


| |
|---|
| [ReactorSocket](../-reactor-socket/index.html) |


## Functions


| Name | Summary |
|---|---|
| [addListener](add-listener.html) | [androidJvm]<br>abstract fun [addListener](add-listener.html)(reactorCallback: [ReactorCallback](../-reactor-callback/index.html))<br>Adds a listener to event updates. Those changes are only triggered after an event is joined via [joinEvent](join-event.html) |
| [joinEvent](join-event.html) | [androidJvm]<br>abstract fun [joinEvent](join-event.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Joins the event updates by id |
| [joinTimeline](join-timeline.html) | [androidJvm]<br>abstract fun [joinTimeline](join-timeline.html)(param: [JoinTimelineParam](../../tv.mycujoo.mclsnetwork.model/-join-timeline-param/index.html))<br>Joins timeline updates |
| [leave](leave.html) | [androidJvm]<br>abstract fun [leave](leave.html)(destroyAfter: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Leaves the socket, terminates the connections and releases resources (if leave(true)). |
