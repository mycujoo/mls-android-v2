---
title: getActions
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.network](../index.html)/[MlsApi](index.html)/[getActions](get-actions.html)



# getActions



[androidJvm]\




@GET(value = &quot;bff/timeline/v1beta1/{timeline_id}&quot;)



abstract suspend fun [getActions](get-actions.html)(@Path(value = &quot;timeline_id&quot;)timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Query(value = &quot;update_id&quot;)updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [ActionResponse](../../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.html)




