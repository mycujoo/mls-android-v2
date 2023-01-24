//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.network.socket](../index.md)/[MainWebSocketListener](index.md)

# MainWebSocketListener

[androidJvm]\
class [MainWebSocketListener](index.md)@Injectconstructor : WebSocketListener

## Constructors

| | |
|---|---|
| [MainWebSocketListener](-main-web-socket-listener.md) | [androidJvm]<br>@Inject<br>fun [MainWebSocketListener](-main-web-socket-listener.md)() |

## Functions

| Name | Summary |
|---|---|
| [addListener](add-listener.md) | [androidJvm]<br>fun [addListener](add-listener.md)(webSocketListener: WebSocketListener) |
| [onClosed](../-reactor-listener/index.md#746747366%2FFunctions%2F234995373) | [androidJvm]<br>open fun [onClosed](../-reactor-listener/index.md#746747366%2FFunctions%2F234995373)(webSocket: WebSocket, code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onClosing](../-reactor-listener/index.md#-965341629%2FFunctions%2F234995373) | [androidJvm]<br>open fun [onClosing](../-reactor-listener/index.md#-965341629%2FFunctions%2F234995373)(webSocket: WebSocket, code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onFailure](../-reactor-listener/index.md#-593877028%2FFunctions%2F234995373) | [androidJvm]<br>open fun [onFailure](../-reactor-listener/index.md#-593877028%2FFunctions%2F234995373)(webSocket: WebSocket, t: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html), response: Response?) |
| [onMessage](../-reactor-listener/index.md#-413335953%2FFunctions%2F234995373) | [androidJvm]<br>open fun [onMessage](../-reactor-listener/index.md#-413335953%2FFunctions%2F234995373)(webSocket: WebSocket, bytes: ByteString)<br>open override fun [onMessage](on-message.md)(webSocket: WebSocket, text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onOpen](../-reactor-listener/index.md#-1195333275%2FFunctions%2F234995373) | [androidJvm]<br>open fun [onOpen](../-reactor-listener/index.md#-1195333275%2FFunctions%2F234995373)(webSocket: WebSocket, response: Response) |
