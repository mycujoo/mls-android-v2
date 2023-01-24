//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.data.repository](../index.md)/[EventsRepository](index.md)

# EventsRepository

[androidJvm]\
class [EventsRepository](index.md)@Injectconstructor(val api: [MlsApi](../../tv.mycujoo.mclsnetwork.network/-mls-api/index.md)) : [AbstractRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-abstract-repository/index.md), [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.md)

## Constructors

| | |
|---|---|
| [EventsRepository](-events-repository.md) | [androidJvm]<br>@Inject<br>fun [EventsRepository](-events-repository.md)(api: [MlsApi](../../tv.mycujoo.mclsnetwork.network/-mls-api/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [getActions](get-actions.md) | [androidJvm]<br>open suspend override fun [getActions](get-actions.md)(timelineIdPairParam: [TimelineIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-timeline-id-pair-param/index.md)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [ActionResponse](../../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.md)&gt; |
| [getEventDetails](get-event-details.md) | [androidJvm]<br>open suspend override fun [getEventDetails](get-event-details.md)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updatedId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), EventEntity&gt; |
| [getEventsList](get-events-list.md) | [androidJvm]<br>open suspend override fun [getEventsList](get-events-list.md)(eventListParams: [EventListParams](../../tv.mycujoo.mclsnetwork.domain.params/-event-list-params/index.md)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt; |
| [safeApiCall](../../tv.mycujoo.mclsnetwork.domain.repository/-abstract-repository/safe-api-call.md) | [androidJvm]<br>suspend fun &lt;[T](../../tv.mycujoo.mclsnetwork.domain.repository/-abstract-repository/safe-api-call.md)&gt; [safeApiCall](../../tv.mycujoo.mclsnetwork.domain.repository/-abstract-repository/safe-api-call.md)(apiCall: suspend () -&gt; [T](../../tv.mycujoo.mclsnetwork.domain.repository/-abstract-repository/safe-api-call.md)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [T](../../tv.mycujoo.mclsnetwork.domain.repository/-abstract-repository/safe-api-call.md)&gt; |

## Properties

| Name | Summary |
|---|---|
| [api](api.md) | [androidJvm]<br>val [api](api.md): [MlsApi](../../tv.mycujoo.mclsnetwork.network/-mls-api/index.md) |
