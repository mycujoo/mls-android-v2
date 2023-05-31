---
title: tv.mycujoo.mclsnetwork.domain.usecase
---
//[mcls-network](../../index.html)/[tv.mycujoo.mclsnetwork.domain.usecase](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [AbstractParameterizedUseCase](-abstract-parameterized-use-case/index.html) | [androidJvm]<br>abstract class [AbstractParameterizedUseCase](-abstract-parameterized-use-case/index.html)&lt;in [P](-abstract-parameterized-use-case/index.html), out [T](-abstract-parameterized-use-case/index.html)&gt; |
| [GetActionsUseCase](-get-actions-use-case/index.html) | [androidJvm]<br>class [GetActionsUseCase](-get-actions-use-case/index.html)@Injectconstructor(repository: [IEventsRepository](../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.html)) : [AbstractParameterizedUseCase](-abstract-parameterized-use-case/index.html)&lt;[TimelineIdPairParam](../tv.mycujoo.mclsnetwork.domain.params/-timeline-id-pair-param/index.html), MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [ActionResponse](../tv.mycujoo.mclsnetwork.data.entity/-action-response/index.html)&gt;&gt; <br>Usecase for getting Annotation Actions Input parameter is pair of timelineId and updateEventId |
| [GetEventDetailUseCase](-get-event-detail-use-case/index.html) | [androidJvm]<br>class [GetEventDetailUseCase](-get-event-detail-use-case/index.html)@Injectconstructor(repository: [IEventsRepository](../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.html)) : [AbstractParameterizedUseCase](-abstract-parameterized-use-case/index.html)&lt;[EventIdPairParam](../tv.mycujoo.mclsnetwork.domain.params/-event-id-pair-param/index.html), MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), MCLSEvent&gt;&gt; <br>Usecase for getting Event details. Input parameter is pair of eventId and eventUpdateId |
| [GetEventsUseCase](-get-events-use-case/index.html) | [androidJvm]<br>class [GetEventsUseCase](-get-events-use-case/index.html)@Injectconstructor(repository: [IEventsRepository](../tv.mycujoo.mclsnetwork.domain.repository/-i-events-repository/index.html)) : [AbstractParameterizedUseCase](-abstract-parameterized-use-case/index.html)&lt;[EventListParams](../tv.mycujoo.mclsnetwork.domain.params/-event-list-params/index.html), MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt;&gt; <br>Usecase for getting Events. Input parameter defines which types of Events should be returned |

