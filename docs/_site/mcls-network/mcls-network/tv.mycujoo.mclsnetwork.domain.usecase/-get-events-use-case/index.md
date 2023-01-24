//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.domain.usecase](../index.md)/[GetEventsUseCase](index.md)

# GetEventsUseCase

[androidJvm]\
class [GetEventsUseCase](index.md)@Injectconstructor(repository: [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.md)) : [AbstractParameterizedUseCase](../-abstract-parameterized-use-case/index.md)&lt;[EventListParams](../../tv.mycujoo.mclsnetwork.domain.params/-event-list-params/index.md), MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt;&gt; 

Usecase for getting Events. Input parameter defines which types of Events should be returned

#### See also

androidJvm

| |
|---|
| [EventListParams](../../tv.mycujoo.mclsnetwork.domain.params/-event-list-params/index.md) |

## Constructors

| | |
|---|---|
| [GetEventsUseCase](-get-events-use-case.md) | [androidJvm]<br>@Inject<br>fun [GetEventsUseCase](-get-events-use-case.md)(repository: [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [androidJvm]<br>open suspend override fun [build](build.md)(param: [EventListParams](../../tv.mycujoo.mclsnetwork.domain.params/-event-list-params/index.md)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt; |
| [execute](index.md#1826672267%2FFunctions%2F234995373) | [androidJvm]<br>suspend fun [execute](index.md#1826672267%2FFunctions%2F234995373)(param: [EventListParams](../../tv.mycujoo.mclsnetwork.domain.params/-event-list-params/index.md)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt; |
