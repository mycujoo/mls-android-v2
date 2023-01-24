//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.domain.usecase](../index.md)/[GetEventDetailUseCase](index.md)

# GetEventDetailUseCase

[androidJvm]\
class [GetEventDetailUseCase](index.md)@Injectconstructor(repository: [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.md)) : [AbstractParameterizedUseCase](../-abstract-parameterized-use-case/index.md)&lt;[EventIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-event-id-pair-param/index.md), MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), EventEntity&gt;&gt; 

Usecase for getting Event details. Input parameter is pair of eventId and eventUpdateId

#### See also

androidJvm

| |
|---|
| [EventIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-event-id-pair-param/index.md) |

## Constructors

| | |
|---|---|
| [GetEventDetailUseCase](-get-event-detail-use-case.md) | [androidJvm]<br>@Inject<br>fun [GetEventDetailUseCase](-get-event-detail-use-case.md)(repository: [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [androidJvm]<br>open suspend override fun [build](build.md)(param: [EventIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-event-id-pair-param/index.md)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), EventEntity&gt; |
| [execute](index.md#-304783589%2FFunctions%2F234995373) | [androidJvm]<br>suspend fun [execute](index.md#-304783589%2FFunctions%2F234995373)(param: [EventIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-event-id-pair-param/index.md)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), EventEntity&gt; |
