//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.network.socket](../index.md)/[ReactorListener](index.md)

# ReactorListener

[androidJvm]\
class [ReactorListener](index.md)(reactorCallback: [ReactorCallback](../-reactor-callback/index.md)) : WebSocketListener

## Constructors

| | |
|---|---|
| [ReactorListener](-reactor-listener.md) | [androidJvm]<br>fun [ReactorListener](-reactor-listener.md)(reactorCallback: [ReactorCallback](../-reactor-callback/index.md)) |

## Types

| Name | Summary |
|---|---|
| [ReactorMessage](-reactor-message/index.md) | [androidJvm]<br>sealed class [ReactorMessage](-reactor-message/index.md) |

## Functions

| Name | Summary |
|---|---|
| [onClosed](index.md#746747366%2FFunctions%2F234995373) | [androidJvm]<br>open fun [onClosed](index.md#746747366%2FFunctions%2F234995373)(webSocket: WebSocket, code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onClosing](index.md#-965341629%2FFunctions%2F234995373) | [androidJvm]<br>open fun [onClosing](index.md#-965341629%2FFunctions%2F234995373)(webSocket: WebSocket, code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onFailure](index.md#-593877028%2FFunctions%2F234995373) | [androidJvm]<br>open fun [onFailure](index.md#-593877028%2FFunctions%2F234995373)(webSocket: WebSocket, t: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html), response: Response?) |
| [onMessage](index.md#-413335953%2FFunctions%2F234995373) | [androidJvm]<br>open fun [onMessage](index.md#-413335953%2FFunctions%2F234995373)(webSocket: WebSocket, bytes: ByteString)<br>open override fun [onMessage](on-message.md)(webSocket: WebSocket, text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onOpen](index.md#-1195333275%2FFunctions%2F234995373) | [androidJvm]<br>open fun [onOpen](index.md#-1195333275%2FFunctions%2F234995373)(webSocket: WebSocket, response: Response) |
