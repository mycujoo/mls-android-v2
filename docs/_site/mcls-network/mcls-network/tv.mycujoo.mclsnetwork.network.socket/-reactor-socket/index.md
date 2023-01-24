//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.network.socket](../index.md)/[ReactorSocket](index.md)

# ReactorSocket

[androidJvm]\
class [ReactorSocket](index.md)@Injectconstructor(okHttpClient: OkHttpClient, mainSocketListener: [MainWebSocketListener](../-main-web-socket-listener/index.md), uuidUtils: [UuidUtils](../../tv.mycujoo.mclsnetwork.util/-uuid-utils/index.md), webSocketUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [IReactorSocket](../-i-reactor-socket/index.md)

## Constructors

| | |
|---|---|
| [ReactorSocket](-reactor-socket.md) | [androidJvm]<br>@Inject<br>fun [ReactorSocket](-reactor-socket.md)(okHttpClient: OkHttpClient, mainSocketListener: [MainWebSocketListener](../-main-web-socket-listener/index.md), uuidUtils: [UuidUtils](../../tv.mycujoo.mclsnetwork.util/-uuid-utils/index.md), webSocketUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [addListener](add-listener.md) | [androidJvm]<br>open override fun [addListener](add-listener.md)(reactorCallback: [ReactorCallback](../-reactor-callback/index.md)) |
| [joinEvent](join-event.md) | [androidJvm]<br>open override fun [joinEvent](join-event.md)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Joins to an Event with eventId by sending JOIN command. before doing so, it checks if active connection is already established, if so it will terminate that. Also, it checks if a socket client has been created, if not, it will create one. |
| [joinTimeline](join-timeline.md) | [androidJvm]<br>open override fun [joinTimeline](join-timeline.md)(param: [JoinTimelineParam](../../tv.mycujoo.mclsnetwork.model/-join-timeline-param/index.md))<br>Join a timeline to listen to timeline changes before doing so, a connection must be active |
| [leave](leave.md) | [androidJvm]<br>open override fun [leave](leave.md)(destroyAfter: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Leaves a connection by sending LEAVE command. eventId from formerly used join command will be used |
