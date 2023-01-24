//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.network](../index.md)/[MlsApi](index.md)/[getEventDetails](get-event-details.md)

# getEventDetails

[androidJvm]\

@GET(value = &quot;bff/events/v1beta1/{id}&quot;)

abstract suspend fun [getEventDetails](get-event-details.md)(@Path(value = &quot;id&quot;)id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), @Query(value = &quot;update_id&quot;)updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [EventSourceData](../../tv.mycujoo.mclsnetwork.data.model/-event-source-data/index.md)
