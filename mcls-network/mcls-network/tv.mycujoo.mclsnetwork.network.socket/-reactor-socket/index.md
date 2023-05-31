---
title: ReactorSocket
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.network.socket](../index.html)/[ReactorSocket](index.html)



# ReactorSocket



[androidJvm]\
class [ReactorSocket](index.html)@Injectconstructor(okHttpClient: OkHttpClient, mainSocketListener: [MainWebSocketListener](../-main-web-socket-listener/index.html), uuidUtils: [UuidUtils](../../tv.mycujoo.mclsnetwork.util/-uuid-utils/index.html), webSocketUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [IReactorSocket](../-i-reactor-socket/index.html)



## Constructors


| | |
|---|---|
| [ReactorSocket](-reactor-socket.html) | [androidJvm]<br>@Inject<br>constructor(okHttpClient: OkHttpClient, mainSocketListener: [MainWebSocketListener](../-main-web-socket-listener/index.html), uuidUtils: [UuidUtils](../../tv.mycujoo.mclsnetwork.util/-uuid-utils/index.html), webSocketUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [addListener](add-listener.html) | [androidJvm]<br>open override fun [addListener](add-listener.html)(reactorCallback: [ReactorCallback](../-reactor-callback/index.html))<br>Adds a listener to event updates. Those changes are only triggered after an event is joined via [joinEvent](join-event.html) |
| [joinEvent](join-event.html) | [androidJvm]<br>open override fun [joinEvent](join-event.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Joins to an Event with eventId by sending JOIN command. before doing so, it checks if active connection is already established, if so it will terminate that. Also, it checks if a socket client has been created, if not, it will create one. |
| [joinTimeline](join-timeline.html) | [androidJvm]<br>open override fun [joinTimeline](join-timeline.html)(param: [JoinTimelineParam](../../tv.mycujoo.mclsnetwork.model/-join-timeline-param/index.html))<br>Join a timeline to listen to timeline changes before doing so, a connection must be active |
| [leave](leave.html) | [androidJvm]<br>open override fun [leave](leave.html)(destroyAfter: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Leaves a connection by sending LEAVE command. eventId from formerly used join command will be used |

