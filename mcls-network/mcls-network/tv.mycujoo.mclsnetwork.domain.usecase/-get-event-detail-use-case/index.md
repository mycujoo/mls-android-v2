---
title: GetEventDetailUseCase
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.domain.usecase](../index.html)/[GetEventDetailUseCase](index.html)



# GetEventDetailUseCase

class [GetEventDetailUseCase](index.html)@Injectconstructor(repository: [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.html)) : [AbstractParameterizedUseCase](../-abstract-parameterized-use-case/index.html)&lt;[EventIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-event-id-pair-param/index.html), MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), MCLSEvent&gt;&gt; 

Usecase for getting Event details. Input parameter is pair of eventId and eventUpdateId



#### See also


| |
|---|
| [EventIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-event-id-pair-param/index.html) |


## Constructors


| | |
|---|---|
| [GetEventDetailUseCase](-get-event-detail-use-case.html) | [androidJvm]<br>@Inject<br>constructor(repository: [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [build](build.html) | [androidJvm]<br>open suspend override fun [build](build.html)(param: [EventIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-event-id-pair-param/index.html)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), MCLSEvent&gt; |
| [execute](index.html#-304783589%2FFunctions%2F-506170386) | [androidJvm]<br>suspend fun [execute](index.html#-304783589%2FFunctions%2F-506170386)(param: [EventIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-event-id-pair-param/index.html)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), MCLSEvent&gt; |

