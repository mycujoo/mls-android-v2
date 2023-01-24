---
title: AbstractParameterizedUseCase
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.domain.usecase](../index.html)/[AbstractParameterizedUseCase](index.html)



# AbstractParameterizedUseCase



[androidJvm]\
abstract class [AbstractParameterizedUseCase](index.html)&lt;in [P](index.html), out [T](index.html)&gt;



## Constructors


| | |
|---|---|
| [AbstractParameterizedUseCase](-abstract-parameterized-use-case.html) | [androidJvm]<br>fun [AbstractParameterizedUseCase](-abstract-parameterized-use-case.html)() |


## Functions


| Name | Summary |
|---|---|
| [build](build.html) | [androidJvm]<br>abstract suspend fun [build](build.html)(param: [P](index.html)): [T](index.html) |
| [execute](execute.html) | [androidJvm]<br>suspend fun [execute](execute.html)(param: [P](index.html)): [T](index.html) |


## Inheritors


| Name |
|---|
| [GetActionsUseCase](../-get-actions-use-case/index.html) |
| [GetEventDetailUseCase](../-get-event-detail-use-case/index.html) |
| [GetEventsUseCase](../-get-events-use-case/index.html) |

