---
title: MCLSNetwork
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork](../index.html)/[MCLSNetwork](index.html)



# MCLSNetwork

interface [MCLSNetwork](index.html)

#### Inheritors


| |
|---|
| [MCLSNetworkImpl](../-m-c-l-s-network-impl/index.html) |


## Types


| Name | Summary |
|---|---|
| [Builder](-builder/index.html) | [androidJvm]<br>class [Builder](-builder/index.html) |
| [OnEventUpdateListener](-on-event-update-listener/index.html) | [androidJvm]<br>fun interface [OnEventUpdateListener](-on-event-update-listener/index.html) |
| [OnTimelineUpdateListener](-on-timeline-update-listener/index.html) | [androidJvm]<br>fun interface [OnTimelineUpdateListener](-on-timeline-update-listener/index.html) |


## Functions


| Name | Summary |
|---|---|
| [addOnAnnotationActionsUpdateListener](add-on-annotation-actions-update-listener.html) | [androidJvm]<br>abstract fun [addOnAnnotationActionsUpdateListener](add-on-annotation-actions-update-listener.html)(onTimelineUpdate: [MCLSNetwork.OnTimelineUpdateListener](-on-timeline-update-listener/index.html))<br>Adds an annotation actions change listener. And sends the current state of MCLSEvent (if joined before) |
| [addOnEventUpdateListener](add-on-event-update-listener.html) | [androidJvm]<br>abstract fun [addOnEventUpdateListener](add-on-event-update-listener.html)(onEventUpdate: [MCLSNetwork.OnEventUpdateListener](-on-event-update-listener/index.html))<br>Adds an event change update listener i.e. the event went live |
| [getEventDetails](get-event-details.html) | [androidJvm]<br>abstract suspend fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), onEventComplete: (MCLSEvent) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>abstract suspend fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), onEventComplete: (MCLSEvent) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), onError: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null)<br>Gets event details<br>[androidJvm]<br>abstract suspend fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), MCLSEvent&gt;<br>Gets the event details raw response |
| [getEventList](get-event-list.html) | [androidJvm]<br>abstract suspend fun [getEventList](get-event-list.html)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, filter: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt;<br>Fetches Events List and Returns them in a MCLSResult wrapper |
| [getEventsList](get-events-list.html) | [androidJvm]<br>abstract suspend fun [getEventsList](get-events-list.html)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, filter: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.html)? = null, fetchEventCallback: (eventList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MCLSEventListItem&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null)<br>Fetches Events List and Returns them in a callback param |
| [getIdentityToken](get-identity-token.html) | [androidJvm]<br>abstract fun [getIdentityToken](get-identity-token.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Gets the current identity token used for network calls |
| [getTimelineActions](get-timeline-actions.html) | [androidJvm]<br>abstract suspend fun [getTimelineActions](get-timeline-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;&gt;<br>Fetches a list of Annotation Actions from the api, and returns them in a response wrapper for safe execution<br>[androidJvm]<br>abstract suspend fun [getTimelineActions](get-timeline-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, onSuccess: ([List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>abstract suspend fun [getTimelineActions](get-timeline-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, onSuccess: ([List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), onError: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?)<br>An automatic unwrap for [getTimelineActions](get-timeline-actions.html) result |
| [joinEventAndTimelineUpdates](join-event-and-timeline-updates.html) | [androidJvm]<br>abstract fun [joinEventAndTimelineUpdates](join-event-and-timeline-updates.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), scope: CoroutineScope)<br>Subscribes to changes in MCLSEvent and timeline AnnotationActions listeners |
| [leaveEventAndTimelineUpdates](leave-event-and-timeline-updates.html) | [androidJvm]<br>abstract fun [leaveEventAndTimelineUpdates](leave-event-and-timeline-updates.html)(release: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Leave Reactor Socket, and remove all listeners |
| [removeEventUpdateListener](remove-event-update-listener.html) | [androidJvm]<br>abstract fun [removeEventUpdateListener](remove-event-update-listener.html)(listener: [MCLSNetwork.OnEventUpdateListener](-on-event-update-listener/index.html))<br>Remove [OnEventUpdateListener](-on-event-update-listener/index.html) from event change subscribers |
| [removeOnAnnotationActionsUpdateListener](remove-on-annotation-actions-update-listener.html) | [androidJvm]<br>abstract fun [removeOnAnnotationActionsUpdateListener](remove-on-annotation-actions-update-listener.html)(listener: [MCLSNetwork.OnTimelineUpdateListener](-on-timeline-update-listener/index.html))<br>Remove [OnTimelineUpdateListener](-on-timeline-update-listener/index.html) from timeline changes listeners |
| [setIdentityToken](set-identity-token.html) | [androidJvm]<br>abstract fun [setIdentityToken](set-identity-token.html)(identityToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Sets the identity token used for protected streams |
| [setPublicKey](set-public-key.html) | [androidJvm]<br>abstract fun [setPublicKey](set-public-key.html)(publicKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Sets the public key used for network calls. this one is linked to your organization |


## Properties


| Name | Summary |
|---|---|
| [bffRtSocket](bff-rt-socket.html) | [androidJvm]<br>abstract val [bffRtSocket](bff-rt-socket.html): [IBFFRTSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-b-f-f-r-t-socket/index.html)<br>Row accessor to [IBFFRTSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-b-f-f-r-t-socket/index.html) used for concurrency limit |
| [reactorSocket](reactor-socket.html) | [androidJvm]<br>abstract val [reactorSocket](reactor-socket.html): [IReactorSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-reactor-socket/index.html)<br>Row accessor to [IReactorSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-reactor-socket/index.html) |

