---
title: IDataManager
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.data](../index.html)/[IDataManager](index.html)



# IDataManager



[androidJvm]\
interface [IDataManager](index.html) : [IInternalDataProvider](../-i-internal-data-provider/index.html), [DataProvider](../../tv.mycujoo.mclsnetwork.api/-data-provider/index.html)



## Functions


| Name | Summary |
|---|---|
| [fetchEvents](../../tv.mycujoo.mclsnetwork.api/-data-provider/fetch-events.html) | [androidJvm]<br>abstract fun [fetchEvents](../../tv.mycujoo.mclsnetwork.api/-data-provider/fetch-events.html)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, eventStatus: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventStatus&gt;? = null, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.html)? = null, fetchEventCallback: (eventList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventEntity&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)? = null)<br>calls Event-list endpoint and emits result on eventLiveData |
| [getActions](../-i-internal-data-provider/get-actions.html) | [androidJvm]<br>abstract suspend fun [getActions](../-i-internal-data-provider/get-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;&gt; |
| [getEventDetails](../-i-internal-data-provider/get-event-details.html) | [androidJvm]<br>abstract suspend fun [getEventDetails](../-i-internal-data-provider/get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), EventEntity&gt; |
| [getEventsLiveData](../../tv.mycujoo.mclsnetwork.api/-data-provider/get-events-live-data.html) | [androidJvm]<br>abstract fun [getEventsLiveData](../../tv.mycujoo.mclsnetwork.api/-data-provider/get-events-live-data.html)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventEntity&gt;&gt;<br>subscribe to an observable which will emit list of EventEntities |
| [setLogLevel](../-i-internal-data-provider/set-log-level.html) | [androidJvm]<br>abstract fun [setLogLevel](../-i-internal-data-provider/set-log-level.html)(logLevel: LogLevel) |


## Inheritors


| Name |
|---|
| [DataManager](../../tv.mycujoo.mclsnetwork.api/-data-manager/index.html) |

