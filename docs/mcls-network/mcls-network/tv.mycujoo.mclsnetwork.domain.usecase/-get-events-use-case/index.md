---
title: GetEventsUseCase
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.domain.usecase](../index.html)/[GetEventsUseCase](index.html)



# GetEventsUseCase



[androidJvm]\
class [GetEventsUseCase](index.html)@Injectconstructor(repository: [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.html)) : [AbstractParameterizedUseCase](../-abstract-parameterized-use-case/index.html)&lt;[EventListParams](../../tv.mycujoo.mclsnetwork.domain.params/-event-list-params/index.html), MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt;&gt; 

Usecase for getting Events. Input parameter defines which types of Events should be returned



#### See also


androidJvm

| |
|---|
| [EventListParams](../../tv.mycujoo.mclsnetwork.domain.params/-event-list-params/index.html) |



## Constructors


| | |
|---|---|
| [GetEventsUseCase](-get-events-use-case.html) | [androidJvm]<br>@Inject<br>fun [GetEventsUseCase](-get-events-use-case.html)(repository: [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [build](build.html) | [androidJvm]<br>open suspend override fun [build](build.html)(param: [EventListParams](../../tv.mycujoo.mclsnetwork.domain.params/-event-list-params/index.html)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt; |
| [execute](index.html#1826672267%2FFunctions%2F-506170386) | [androidJvm]<br>suspend fun [execute](index.html#1826672267%2FFunctions%2F-506170386)(param: [EventListParams](../../tv.mycujoo.mclsnetwork.domain.params/-event-list-params/index.html)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt; |

