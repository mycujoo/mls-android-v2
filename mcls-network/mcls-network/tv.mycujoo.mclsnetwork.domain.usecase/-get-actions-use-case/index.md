---
title: GetActionsUseCase
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.domain.usecase](../index.html)/[GetActionsUseCase](index.html)



# GetActionsUseCase



[androidJvm]\
class [GetActionsUseCase](index.html)@Injectconstructor(repository: [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.html)) : [AbstractParameterizedUseCase](../-abstract-parameterized-use-case/index.html)&lt;[TimelineIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-timeline-id-pair-param/index.html), MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [ActionResponse](../../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.html)&gt;&gt; 

Usecase for getting Annotation Actions Input parameter is pair of timelineId and updateEventId



## Constructors


| | |
|---|---|
| [GetActionsUseCase](-get-actions-use-case.html) | [androidJvm]<br>@Inject<br>constructor(repository: [IEventsRepository](../../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [build](build.html) | [androidJvm]<br>open suspend override fun [build](build.html)(param: [TimelineIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-timeline-id-pair-param/index.html)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [ActionResponse](../../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.html)&gt; |
| [execute](index.html#-1561274254%2FFunctions%2F-506170386) | [androidJvm]<br>suspend fun [execute](index.html#-1561274254%2FFunctions%2F-506170386)(param: [TimelineIdPairParam](../../tv.mycujoo.mclsnetwork.domain.params/-timeline-id-pair-param/index.html)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [ActionResponse](../../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.html)&gt; |

