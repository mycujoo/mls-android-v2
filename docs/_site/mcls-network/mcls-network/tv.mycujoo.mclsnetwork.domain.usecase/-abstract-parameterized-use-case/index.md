//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.domain.usecase](../index.md)/[AbstractParameterizedUseCase](index.md)

# AbstractParameterizedUseCase

[androidJvm]\
abstract class [AbstractParameterizedUseCase](index.md)&lt;in [P](index.md), out [T](index.md)&gt;

## Constructors

| | |
|---|---|
| [AbstractParameterizedUseCase](-abstract-parameterized-use-case.md) | [androidJvm]<br>fun [AbstractParameterizedUseCase](-abstract-parameterized-use-case.md)() |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [androidJvm]<br>abstract suspend fun [build](build.md)(param: [P](index.md)): [T](index.md) |
| [execute](execute.md) | [androidJvm]<br>suspend fun [execute](execute.md)(param: [P](index.md)): [T](index.md) |

## Inheritors

| Name |
|---|
| [GetActionsUseCase](../-get-actions-use-case/index.md) |
| [GetEventDetailUseCase](../-get-event-detail-use-case/index.md) |
| [GetEventsUseCase](../-get-events-use-case/index.md) |
