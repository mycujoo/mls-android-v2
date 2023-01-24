//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.api](../index.md)/[DataManager](index.md)

# DataManager

[androidJvm]\
class [DataManager](index.md)@Injectconstructor(scope: CoroutineScope, logger: Logger, getEventDetailUseCase: [GetEventDetailUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-event-detail-use-case/index.md), getEventsUseCase: [GetEventsUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-events-use-case/index.md), getActionsUseCase: [GetActionsUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-actions-use-case/index.md)) : [IDataManager](../../tv.mycujoo.mclsnetwork.data/-i-data-manager/index.md)

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
| [DataManager](-data-manager.md) | [androidJvm]<br>@Inject<br>fun [DataManager](-data-manager.md)(scope: CoroutineScope, logger: Logger, getEventDetailUseCase: [GetEventDetailUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-event-detail-use-case/index.md), getEventsUseCase: [GetEventsUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-events-use-case/index.md), getActionsUseCase: [GetActionsUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-actions-use-case/index.md)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md)<br>endregion |

## Functions

| Name | Summary |
|---|---|
| [fetchEvents](fetch-events.md) | [androidJvm]<br>open override fun [fetchEvents](fetch-events.md)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, eventStatus: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventStatus&gt;?, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.md)?, fetchEventCallback: (eventList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventEntity&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?)<br>fetch Events with given specification |
| [getActions](get-actions.md) | [androidJvm]<br>open suspend override fun [getActions](get-actions.md)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;&gt;<br>get Annotation Actions |
| [getEventDetails](get-event-details.md) | [androidJvm]<br>open suspend override fun [getEventDetails](get-event-details.md)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), EventEntity&gt;<br>fetch Event with details |
| [getEventsLiveData](get-events-live-data.md) | [androidJvm]<br>open override fun [getEventsLiveData](get-events-live-data.md)(): Flow&lt;[List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventEntity&gt;&gt;<br>region Data Provider |
| [setLogLevel](set-log-level.md) | [androidJvm]<br>open override fun [setLogLevel](set-log-level.md)(logLevel: LogLevel)<br>set @param log level of Logger |
