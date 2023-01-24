---
title: DataManager
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.api](../index.html)/[DataManager](index.html)/[DataManager](-data-manager.html)



# DataManager



[androidJvm]\




@Inject



fun [DataManager](-data-manager.html)(scope: CoroutineScope, logger: Logger, getEventDetailUseCase: [GetEventDetailUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-event-detail-use-case/index.html), getEventsUseCase: [GetEventsUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-events-use-case/index.html), getActionsUseCase: [GetActionsUseCase](../../tv.mycujoo.mclsnetwork.domain.usecase/-get-actions-use-case/index.html))



#### Parameters


androidJvm

| | |
|---|---|
| scope | CoroutineScope which calls will made on it's context |
| logger | log info, error & warning based on required level of logging |
| getActionsUseCase | an invocation for IEventsRepository#getActions |
| getEventDetailUseCase | an invocation for IEventsRepository#getEventDetails |
| getEventsUseCase | an invocation for IEventsRepository#getEventsList |




