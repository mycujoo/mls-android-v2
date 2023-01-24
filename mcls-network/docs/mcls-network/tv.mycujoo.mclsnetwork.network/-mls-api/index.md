---
title: MlsApi
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.network](../index.html)/[MlsApi](index.html)



# MlsApi



[androidJvm]\
interface [MlsApi](index.html)



## Functions


| Name | Summary |
|---|---|
| [getActions](get-actions.html) | [androidJvm]<br>@GET(value = &quot;bff/timeline/v1beta1/{timeline_id}&quot;)<br>abstract suspend fun [getActions](get-actions.html)(@Path(value = &quot;timeline_id&quot;)timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Query(value = &quot;update_id&quot;)updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [ActionResponse](../../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.html) |
| [getEventDetails](get-event-details.html) | [androidJvm]<br>@GET(value = &quot;bff/events/v1beta1/{id}&quot;)<br>abstract suspend fun [getEventDetails](get-event-details.html)(@Path(value = &quot;id&quot;)id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Query(value = &quot;update_id&quot;)updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [EventSourceData](../../tv.mycujoo.mclsnetwork.data.model/-event-source-data/index.html) |
| [getEvents](get-events.html) | [androidJvm]<br>@GET(value = &quot;bff/events/v1beta1&quot;)<br>abstract suspend fun [getEvents](get-events.html)(@Query(value = &quot;page_size&quot;)pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Query(value = &quot;page_token&quot;)pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Query(value = &quot;status&quot;)status: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, @Query(value = &quot;order_by&quot;)orderBy: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [EventsSourceData](../../tv.mycujoo.mclsnetwork.data.model/-events-source-data/index.html) |

