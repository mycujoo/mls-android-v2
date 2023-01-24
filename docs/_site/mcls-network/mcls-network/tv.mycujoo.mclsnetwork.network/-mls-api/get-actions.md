//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.network](../index.md)/[MlsApi](index.md)/[getActions](get-actions.md)

# getActions

[androidJvm]\

@GET(value = &quot;bff/timeline/v1beta1/{timeline_id}&quot;)

abstract suspend fun [getActions](get-actions.md)(@Path(value = &quot;timeline_id&quot;)timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Query(value = &quot;update_id&quot;)updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [ActionResponse](../../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.md)
