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

