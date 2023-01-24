//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.data](../index.md)/[IDataManager](index.md)

# IDataManager

[androidJvm]\
interface [IDataManager](index.md) : [IInternalDataProvider](../-i-internal-data-provider/index.md), [DataProvider](../../tv.mycujoo.mclsnetwork.api/-data-provider/index.md)

## Functions

| Name | Summary |
|---|---|
| [fetchEvents](../../tv.mycujoo.mclsnetwork.api/-data-provider/fetch-events.md) | [androidJvm]<br>abstract fun [fetchEvents](../../tv.mycujoo.mclsnetwork.api/-data-provider/fetch-events.md)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, eventStatus: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventStatus&gt;? = null, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.md)? = null, fetchEventCallback: (eventList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventEntity&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null)<br>calls Event-list endpoint and emits result on eventLiveData |
| [getActions](../-i-internal-data-provider/get-actions.md) | [androidJvm]<br>abstract suspend fun [getActions](../-i-internal-data-provider/get-actions.md)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;&gt; |
| [getEventDetails](../-i-internal-data-provider/get-event-details.md) | [androidJvm]<br>abstract suspend fun [getEventDetails](../-i-internal-data-provider/get-event-details.md)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), EventEntity&gt; |
| [getEventsLiveData](../../tv.mycujoo.mclsnetwork.api/-data-provider/get-events-live-data.md) | [androidJvm]<br>abstract fun [getEventsLiveData](../../tv.mycujoo.mclsnetwork.api/-data-provider/get-events-live-data.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventEntity&gt;&gt;<br>subscribe to an observable which will emit list of EventEntities |
| [setLogLevel](../-i-internal-data-provider/set-log-level.md) | [androidJvm]<br>abstract fun [setLogLevel](../-i-internal-data-provider/set-log-level.md)(logLevel: LogLevel) |

## Inheritors

| Name |
|---|
| [DataManager](../../tv.mycujoo.mclsnetwork.api/-data-manager/index.md) |
