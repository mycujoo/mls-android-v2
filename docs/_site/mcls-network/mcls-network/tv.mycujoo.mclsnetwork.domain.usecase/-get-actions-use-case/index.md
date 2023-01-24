//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.domain.usecase](../index.md)/[GetActionsUseCase](index.md)

# GetActionsUseCase

[androidJvm]\
class [GetActionsUseCase](index.md)@Injectconstructor(repository: [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.md)) : [AbstractParameterizedUseCase](../-abstract-parameterized-use-case/index.md)&lt;[TimelineIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-timeline-id-pair-param/index.md), MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [ActionResponse](../../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.md)&gt;&gt; 

Usecase for getting Annotation Actions Input parameter is pair of timelineId and updateEventId

## Constructors

| | |
|---|---|
| [GetActionsUseCase](-get-actions-use-case.md) | [androidJvm]<br>@Inject<br>fun [GetActionsUseCase](-get-actions-use-case.md)(repository: [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [androidJvm]<br>open suspend override fun [build](build.md)(param: [TimelineIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-timeline-id-pair-param/index.md)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [ActionResponse](../../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.md)&gt; |
| [execute](index.md#-1561274254%2FFunctions%2F234995373) | [androidJvm]<br>suspend fun [execute](index.md#-1561274254%2FFunctions%2F234995373)(param: [TimelineIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-timeline-id-pair-param/index.md)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [ActionResponse](../../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.md)&gt; |
