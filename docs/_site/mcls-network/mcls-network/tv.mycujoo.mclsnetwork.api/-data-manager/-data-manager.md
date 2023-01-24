//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.api](../index.md)/[DataManager](index.md)/[DataManager](-data-manager.md)

# DataManager

[androidJvm]\

@Inject

fun [DataManager](-data-manager.md)(scope: CoroutineScope, logger: Logger, getEventDetailUseCase: [GetEventDetailUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-event-detail-use-case/index.md), getEventsUseCase: [GetEventsUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-events-use-case/index.md), getActionsUseCase: [GetActionsUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-actions-use-case/index.md))

#### Parameters

androidJvm

| | |
|---|---|
| scope | CoroutineScope which calls will made on it's context |
| logger | log info, error & warning based on required level of logging |
| getActionsUseCase | an invocation for IEventsRepository#getActions |
| getEventDetailUseCase | an invocation for IEventsRepository#getEventDetails |
| getEventsUseCase | an invocation for IEventsRepository#getEventsList |
