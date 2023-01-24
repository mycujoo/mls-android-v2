---
title: getEventDetails
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.network](../index.html)/[MlsApi](index.html)/[getEventDetails](get-event-details.html)



# getEventDetails



[androidJvm]\




@GET(value = &quot;bff/events/v1beta1/{id}&quot;)



abstract suspend fun [getEventDetails](get-event-details.html)(@Path(value = &quot;id&quot;)id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Query(value = &quot;update_id&quot;)updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [EventSourceData](../../tv.mycujoo.mclsnetwork.data.model/-event-source-data/index.html)




