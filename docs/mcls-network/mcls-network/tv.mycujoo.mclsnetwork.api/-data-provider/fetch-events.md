---
title: fetchEvents
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.api](../index.html)/[DataProvider](index.html)/[fetchEvents](fetch-events.html)



# fetchEvents



[androidJvm]\
abstract fun [fetchEvents](fetch-events.html)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, eventStatus: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventStatus&gt;? = null, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.html)? = null, fetchEventCallback: (eventList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventEntity&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null)



calls Event-list endpoint and emits result on eventLiveData



