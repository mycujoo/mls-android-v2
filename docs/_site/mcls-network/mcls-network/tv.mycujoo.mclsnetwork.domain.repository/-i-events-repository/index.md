//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.domain.repository](../index.md)/[IEventsRepository](index.md)

# IEventsRepository

[androidJvm]\
interface [IEventsRepository](index.md)

## Functions

| Name | Summary |
|---|---|
| [getActions](get-actions.md) | [androidJvm]<br>abstract suspend fun [getActions](get-actions.md)(timelineIdPairParam: [TimelineIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-timeline-id-pair-param/index.md)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [ActionResponse](../../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.md)&gt; |
| [getEventDetails](get-event-details.md) | [androidJvm]<br>abstract suspend fun [getEventDetails](get-event-details.md)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updatedId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), EventEntity&gt; |
| [getEventsList](get-events-list.md) | [androidJvm]<br>abstract suspend fun [getEventsList](get-events-list.md)(eventListParams: [EventListParams](../../tv.mycujoo.mclsnetwork.domain.params/-event-list-params/index.md)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt; |

## Inheritors

| Name |
|---|
| [EventsRepository](../../tv.mycujoo.mclsnetwork.data.repository/-events-repository/index.md) |
