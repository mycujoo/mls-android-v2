---
title: DataManager
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.api](../index.html)/[DataManager](index.html)



# DataManager

class [DataManager](index.html)@Injectconstructor(scope: CoroutineScope, logger: Logger, getEventDetailUseCase: [GetEventDetailUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-event-detail-use-case/index.html), getEventsUseCase: [GetEventsUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-events-use-case/index.html), getActionsUseCase: [GetActionsUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-actions-use-case/index.html)) : [IDataManager](../../tv.mycujoo.mclsnetwork.data/-i-data-manager/index.html)

Serves client as 'Data Provider' Serves internal usage as 'Internal Data Provider'



#### Parameters


androidJvm

| | |
|---|---|
| scope | CoroutineScope which calls will made on it's context |
| logger | log info, error & warning based on required level of logging |
| getActionsUseCase | an invocation for IEventsRepository#getActions |
| getEventDetailUseCase | an invocation for IEventsRepository#getEventDetails |
| getEventsUseCase | an invocation for IEventsRepository#getEventsList |



## Constructors


| | |
|---|---|
| [DataManager](-data-manager.html) | [androidJvm]<br>@Inject<br>constructor(scope: CoroutineScope, logger: Logger, getEventDetailUseCase: [GetEventDetailUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-event-detail-use-case/index.html), getEventsUseCase: [GetEventsUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-events-use-case/index.html), getActionsUseCase: [GetActionsUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-actions-use-case/index.html)) |


## Types


| Name | Summary |
|---|---|
| [Companion](-companion/index.html) | [androidJvm]<br>object [Companion](-companion/index.html)<br>endregion |


## Functions


| Name | Summary |
|---|---|
| [fetchEvents](fetch-events.html) | [androidJvm]<br>open suspend override fun [fetchEvents](fetch-events.html)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, filter: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt;<br>[androidJvm]<br>open suspend override fun [fetchEvents](fetch-events.html)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, filter: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.html)?, fetchEventCallback: (eventList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MCLSEventListItem&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?)<br>fetch Events with given specification |
| [getActions](get-actions.html) | [androidJvm]<br>open suspend override fun [getActions](get-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;&gt;<br>get Annotation Actions |
| [getEventDetails](get-event-details.html) | [androidJvm]<br>open suspend override fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), MCLSEvent&gt;<br>fetch Event with details |
| [setLogLevel](set-log-level.html) | [androidJvm]<br>open override fun [setLogLevel](set-log-level.html)(logLevel: LogLevel)<br>set @param log level of Logger |

