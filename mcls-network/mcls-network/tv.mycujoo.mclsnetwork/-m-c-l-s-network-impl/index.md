---
title: MCLSNetworkImpl
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork](../index.html)/[MCLSNetworkImpl](index.html)



# MCLSNetworkImpl



[androidJvm]\
class [MCLSNetworkImpl](index.html)(logLevel: LogLevel, prefManager: [IPrefManager](../../tv.mycujoo.mclsnetwork.manager/-i-pref-manager/index.html), logger: Logger, dataManager: [IDataManager](../../tv.mycujoo.mclsnetwork.data/-i-data-manager/index.html), val reactorSocket: [IReactorSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-reactor-socket/index.html), val bffRtSocket: [IBFFRTSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-b-f-f-r-t-socket/index.html)) : [MCLSNetwork](../-m-c-l-s-network/index.html)



## Constructors


| | |
|---|---|
| [MCLSNetworkImpl](-m-c-l-s-network-impl.html) | [androidJvm]<br>constructor(logLevel: LogLevel, prefManager: [IPrefManager](../../tv.mycujoo.mclsnetwork.manager/-i-pref-manager/index.html), logger: Logger, dataManager: [IDataManager](../../tv.mycujoo.mclsnetwork.data/-i-data-manager/index.html), reactorSocket: [IReactorSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-reactor-socket/index.html), bffRtSocket: [IBFFRTSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-b-f-f-r-t-socket/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [addOnAnnotationActionsUpdateListener](add-on-annotation-actions-update-listener.html) | [androidJvm]<br>open override fun [addOnAnnotationActionsUpdateListener](add-on-annotation-actions-update-listener.html)(onTimelineUpdate: [MCLSNetwork.OnTimelineUpdateListener](../-m-c-l-s-network/-on-timeline-update-listener/index.html))<br>Adds an annotation actions change listener. And sends the current state of MCLSEvent (if joined before) |
| [addOnEventUpdateListener](add-on-event-update-listener.html) | [androidJvm]<br>open override fun [addOnEventUpdateListener](add-on-event-update-listener.html)(onEventUpdate: [MCLSNetwork.OnEventUpdateListener](../-m-c-l-s-network/-on-event-update-listener/index.html))<br>Adds an event change update listener i.e. the event went live |
| [getEventDetails](get-event-details.html) | [androidJvm]<br>open suspend override fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), onEventComplete: (MCLSEvent) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>open suspend override fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), onEventComplete: (MCLSEvent) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), onError: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?)<br>Gets event details<br>[androidJvm]<br>open suspend override fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), MCLSEvent&gt;<br>Gets the event details raw response |
| [getEventList](get-event-list.html) | [androidJvm]<br>open suspend override fun [getEventList](get-event-list.html)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, filter: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt;<br>Fetches Events List and Returns them in a MCLSResult wrapper |
| [getEventsList](get-events-list.html) | [androidJvm]<br>open suspend override fun [getEventsList](get-events-list.html)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, filter: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.html)?, fetchEventCallback: (eventList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MCLSEventListItem&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?)<br>Fetches Events List and Returns them in a callback param |
| [getIdentityToken](get-identity-token.html) | [androidJvm]<br>open override fun [getIdentityToken](get-identity-token.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Gets the current identity token used for network calls |
| [getTimelineActions](get-timeline-actions.html) | [androidJvm]<br>open suspend override fun [getTimelineActions](get-timeline-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;&gt;<br>Fetches a list of Annotation Actions from the api, and returns them in a response wrapper for safe execution<br>[androidJvm]<br>open suspend override fun [getTimelineActions](get-timeline-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, onSuccess: ([List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>open suspend override fun [getTimelineActions](get-timeline-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, onSuccess: ([List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), onError: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?)<br>An automatic unwrap for [getTimelineActions](get-timeline-actions.html) result |
| [joinEventAndTimelineUpdates](join-event-and-timeline-updates.html) | [androidJvm]<br>open override fun [joinEventAndTimelineUpdates](join-event-and-timeline-updates.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), scope: CoroutineScope)<br>Subscribes to changes in MCLSEvent and timeline AnnotationActions listeners |
| [leaveEventAndTimelineUpdates](leave-event-and-timeline-updates.html) | [androidJvm]<br>open override fun [leaveEventAndTimelineUpdates](leave-event-and-timeline-updates.html)(release: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Leave Reactor Socket, and remove all listeners |
| [removeEventUpdateListener](remove-event-update-listener.html) | [androidJvm]<br>open override fun [removeEventUpdateListener](remove-event-update-listener.html)(listener: [MCLSNetwork.OnEventUpdateListener](../-m-c-l-s-network/-on-event-update-listener/index.html))<br>Remove OnEventUpdateListener from event change subscribers |
| [removeOnAnnotationActionsUpdateListener](remove-on-annotation-actions-update-listener.html) | [androidJvm]<br>open override fun [removeOnAnnotationActionsUpdateListener](remove-on-annotation-actions-update-listener.html)(listener: [MCLSNetwork.OnTimelineUpdateListener](../-m-c-l-s-network/-on-timeline-update-listener/index.html))<br>Remove OnTimelineUpdateListener from timeline changes listeners |
| [setIdentityToken](set-identity-token.html) | [androidJvm]<br>open override fun [setIdentityToken](set-identity-token.html)(identityToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Sets the identity token used for protected streams |
| [setPublicKey](set-public-key.html) | [androidJvm]<br>open override fun [setPublicKey](set-public-key.html)(publicKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Sets the public key used for network calls. this one is linked to your organization |


## Properties


| Name | Summary |
|---|---|
| [bffRtSocket](bff-rt-socket.html) | [androidJvm]<br>open override val [bffRtSocket](bff-rt-socket.html): [IBFFRTSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-b-f-f-r-t-socket/index.html)<br>Row accessor to [IBFFRTSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-b-f-f-r-t-socket/index.html) used for concurrency limit |
| [reactorSocket](reactor-socket.html) | [androidJvm]<br>open override val [reactorSocket](reactor-socket.html): [IReactorSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-reactor-socket/index.html)<br>Row accessor to [IReactorSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-reactor-socket/index.html) |

