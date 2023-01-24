//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.network.socket](../index.md)/[BFFRTListener](index.md)

# BFFRTListener

[androidJvm]\
class [BFFRTListener](index.md)(BFFRTCallback: [BFFRTCallback](../-b-f-f-r-t-callback/index.md)) : WebSocketListener

## Constructors

| | |
|---|---|
| [BFFRTListener](-b-f-f-r-t-listener.md) | [androidJvm]<br>fun [BFFRTListener](-b-f-f-r-t-listener.md)(BFFRTCallback: [BFFRTCallback](../-b-f-f-r-t-callback/index.md)) |

## Types

| Name | Summary |
|---|---|
| [BFFRtMessage](-b-f-f-rt-message/index.md) | [androidJvm]<br>enum [BFFRtMessage](-b-f-f-rt-message/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[BFFRTListener.BFFRtMessage](-b-f-f-rt-message/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [onClosed](on-closed.md) | [androidJvm]<br>open override fun [onClosed](on-closed.md)(webSocket: WebSocket, code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onClosing](on-closing.md) | [androidJvm]<br>open override fun [onClosing](on-closing.md)(webSocket: WebSocket, code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onFailure](on-failure.md) | [androidJvm]<br>open override fun [onFailure](on-failure.md)(webSocket: WebSocket, t: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html), response: Response?) |
| [onMessage](../-reactor-listener/index.md#-413335953%2FFunctions%2F234995373) | [androidJvm]<br>open fun [onMessage](../-reactor-listener/index.md#-413335953%2FFunctions%2F234995373)(webSocket: WebSocket, bytes: ByteString)<br>open override fun [onMessage](on-message.md)(webSocket: WebSocket, text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onOpen](../-reactor-listener/index.md#-1195333275%2FFunctions%2F234995373) | [androidJvm]<br>open fun [onOpen](../-reactor-listener/index.md#-1195333275%2FFunctions%2F234995373)(webSocket: WebSocket, response: Response) |
