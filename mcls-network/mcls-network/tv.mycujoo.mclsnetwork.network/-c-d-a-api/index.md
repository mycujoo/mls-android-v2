---
title: CDAApi
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.network](../index.html)/[CDAApi](index.html)



# CDAApi



[androidJvm]\
interface [CDAApi](index.html)



## Functions


| Name | Summary |
|---|---|
| [getEventDetails](get-event-details.html) | [androidJvm]<br>@POST(value = &quot;mcls.cda.events.v1.EventsService/Get&quot;)<br>abstract suspend fun [getEventDetails](get-event-details.html)(@BodyeventByIdRequest: [GetEventDetailsRequest](../../tv.mycujoo.mclsnetwork.network.request/-get-event-details-request/index.html)): [EventResponse](../../tv.mycujoo.mclsnetwork.data.model/-event-response/index.html) |
| [getEvents](get-events.html) | [androidJvm]<br>@POST(value = &quot;mcls.cda.events.v1.EventsService/List&quot;)<br>abstract suspend fun [getEvents](get-events.html)(@BodyeventListRequest: [GetEventListRequest](../../tv.mycujoo.mclsnetwork.network.request/-get-event-list-request/index.html)): [EventsSourceData](../../tv.mycujoo.mclsnetwork.data.model/-events-source-data/index.html) |

