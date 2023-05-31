---
title: EventsRepository
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.data.repository](../index.html)/[EventsRepository](index.html)



# EventsRepository



[androidJvm]\
class [EventsRepository](index.html)@Injectconstructor(api: [MlsApi](../../tv.mycujoo.mclsnetwork.network/-mls-api/index.html), cdaApi: [CDAApi](../../tv.mycujoo.mclsnetwork.network/-c-d-a-api/index.html)) : [AbstractRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-abstract-repository/index.html), [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.html)



## Constructors


| | |
|---|---|
| [EventsRepository](-events-repository.html) | [androidJvm]<br>@Inject<br>constructor(api: [MlsApi](../../tv.mycujoo.mclsnetwork.network/-mls-api/index.html), cdaApi: [CDAApi](../../tv.mycujoo.mclsnetwork.network/-c-d-a-api/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [getActions](get-actions.html) | [androidJvm]<br>open suspend override fun [getActions](get-actions.html)(timelineIdPairParam: [TimelineIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-timeline-id-pair-param/index.html)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [ActionResponse](../../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.html)&gt; |
| [getEventDetails](get-event-details.html) | [androidJvm]<br>open suspend override fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updatedId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), MCLSEvent&gt; |
| [getEventsList](get-events-list.html) | [androidJvm]<br>open suspend override fun [getEventsList](get-events-list.html)(eventListParams: [EventListParams](../../tv.mycujoo.mclsnetwork.domain.params/-event-list-params/index.html)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt; |
| [safeApiCall](../../tv.mycujoo.mclsnetwork.domain.repository/-abstract-repository/safe-api-call.html) | [androidJvm]<br>suspend fun &lt;[T](../../tv.mycujoo.mclsnetwork.domain.repository/-abstract-repository/safe-api-call.html)&gt; [safeApiCall](../../tv.mycujoo.mclsnetwork.domain.repository/-abstract-repository/safe-api-call.html)(apiCall: suspend () -&gt; [T](../../tv.mycujoo.mclsnetwork.domain.repository/-abstract-repository/safe-api-call.html)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [T](../../tv.mycujoo.mclsnetwork.domain.repository/-abstract-repository/safe-api-call.html)&gt; |

