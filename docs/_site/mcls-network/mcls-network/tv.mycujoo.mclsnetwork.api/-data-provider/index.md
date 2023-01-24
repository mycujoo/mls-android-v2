//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.api](../index.md)/[DataProvider](index.md)

# DataProvider

[androidJvm]\
interface [DataProvider](index.md)

## Functions

| Name | Summary |
|---|---|
| [fetchEvents](fetch-events.md) | [androidJvm]<br>abstract fun [fetchEvents](fetch-events.md)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, eventStatus: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventStatus&gt;? = null, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.md)? = null, fetchEventCallback: (eventList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventEntity&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null)<br>calls Event-list endpoint and emits result on eventLiveData |
| [getEventsLiveData](get-events-live-data.md) | [androidJvm]<br>abstract fun [getEventsLiveData](get-events-live-data.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventEntity&gt;&gt;<br>subscribe to an observable which will emit list of EventEntities |

## Inheritors

| Name |
|---|
| [IDataManager](../../tv.mycujoo.mclsnetwork.data/-i-data-manager/index.md) |
