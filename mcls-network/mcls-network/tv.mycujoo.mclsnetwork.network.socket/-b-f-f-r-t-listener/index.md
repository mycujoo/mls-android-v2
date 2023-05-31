---
title: BFFRTListener
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.network.socket](../index.html)/[BFFRTListener](index.html)



# BFFRTListener



[androidJvm]\
class [BFFRTListener](index.html)(BFFRTCallback: [BFFRTCallback](../-b-f-f-r-t-callback/index.html)) : WebSocketListener



## Constructors


| | |
|---|---|
| [BFFRTListener](-b-f-f-r-t-listener.html) | [androidJvm]<br>constructor(BFFRTCallback: [BFFRTCallback](../-b-f-f-r-t-callback/index.html)) |


## Types


| Name | Summary |
|---|---|
| [BFFRtMessage](-b-f-f-rt-message/index.html) | [androidJvm]<br>enum [BFFRtMessage](-b-f-f-rt-message/index.html) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[BFFRTListener.BFFRtMessage](-b-f-f-rt-message/index.html)&gt; |


## Functions


| Name | Summary |
|---|---|
| [onClosed](on-closed.html) | [androidJvm]<br>open override fun [onClosed](on-closed.html)(webSocket: WebSocket, code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onClosing](on-closing.html) | [androidJvm]<br>open override fun [onClosing](on-closing.html)(webSocket: WebSocket, code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onFailure](on-failure.html) | [androidJvm]<br>open override fun [onFailure](on-failure.html)(webSocket: WebSocket, t: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html), response: Response?) |
| [onMessage](../-reactor-listener/index.html#-413335953%2FFunctions%2F-506170386) | [androidJvm]<br>open fun [onMessage](../-reactor-listener/index.html#-413335953%2FFunctions%2F-506170386)(webSocket: WebSocket, bytes: ByteString)<br>open override fun [onMessage](on-message.html)(webSocket: WebSocket, text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onOpen](../-reactor-listener/index.html#-1195333275%2FFunctions%2F-506170386) | [androidJvm]<br>open fun [onOpen](../-reactor-listener/index.html#-1195333275%2FFunctions%2F-506170386)(webSocket: WebSocket, response: Response) |

