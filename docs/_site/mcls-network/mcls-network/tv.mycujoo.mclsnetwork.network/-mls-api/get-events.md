//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.network](../index.md)/[MlsApi](index.md)/[getEvents](get-events.md)

# getEvents

[androidJvm]\

@GET(value = &quot;bff/events/v1beta1&quot;)

abstract suspend fun [getEvents](get-events.md)(@Query(value = &quot;page_size&quot;)pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, @Query(value = &quot;page_token&quot;)pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, @Query(value = &quot;status&quot;)status: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, @Query(value = &quot;order_by&quot;)orderBy: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): [EventsSourceData](../../tv.mycujoo.mclsnetwork.data.model/-events-source-data/index.md)
