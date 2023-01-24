---
title: IEventsRepository
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.domain.repository](../index.html)/[IEventsRepository](index.html)



# IEventsRepository



[androidJvm]\
interface [IEventsRepository](index.html)



## Functions


| Name | Summary |
|---|---|
| [getActions](get-actions.html) | [androidJvm]<br>abstract suspend fun [getActions](get-actions.html)(timelineIdPairParam: [TimelineIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-timeline-id-pair-param/index.html)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [ActionResponse](../../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.html)&gt; |
| [getEventDetails](get-event-details.html) | [androidJvm]<br>abstract suspend fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updatedId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), EventEntity&gt; |
| [getEventsList](get-events-list.html) | [androidJvm]<br>abstract suspend fun [getEventsList](get-events-list.html)(eventListParams: [EventListParams](../../tv.mycujoo.mclsnetwork.domain.params/-event-list-params/index.html)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt; |


## Inheritors


| Name |
|---|
| [EventsRepository](../../tv.mycujoo.mclsnetwork.data.repository/-events-repository/index.html) |

