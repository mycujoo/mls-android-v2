---
title: MainWebSocketListener
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.network.socket](../index.html)/[MainWebSocketListener](index.html)



# MainWebSocketListener



[androidJvm]\
class [MainWebSocketListener](index.html)@Injectconstructor : WebSocketListener



## Constructors


| | |
|---|---|
| [MainWebSocketListener](-main-web-socket-listener.html) | [androidJvm]<br>@Inject<br>constructor() |


## Functions


| Name | Summary |
|---|---|
| [addListener](add-listener.html) | [androidJvm]<br>fun [addListener](add-listener.html)(webSocketListener: WebSocketListener) |
| [onClosed](../-reactor-listener/index.html#746747366%2FFunctions%2F-506170386) | [androidJvm]<br>open fun [onClosed](../-reactor-listener/index.html#746747366%2FFunctions%2F-506170386)(webSocket: WebSocket, code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onClosing](../-reactor-listener/index.html#-965341629%2FFunctions%2F-506170386) | [androidJvm]<br>open fun [onClosing](../-reactor-listener/index.html#-965341629%2FFunctions%2F-506170386)(webSocket: WebSocket, code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onFailure](../-reactor-listener/index.html#-593877028%2FFunctions%2F-506170386) | [androidJvm]<br>open fun [onFailure](../-reactor-listener/index.html#-593877028%2FFunctions%2F-506170386)(webSocket: WebSocket, t: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html), response: Response?) |
| [onMessage](../-reactor-listener/index.html#-413335953%2FFunctions%2F-506170386) | [androidJvm]<br>open fun [onMessage](../-reactor-listener/index.html#-413335953%2FFunctions%2F-506170386)(webSocket: WebSocket, bytes: ByteString)<br>open override fun [onMessage](on-message.html)(webSocket: WebSocket, text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onOpen](../-reactor-listener/index.html#-1195333275%2FFunctions%2F-506170386) | [androidJvm]<br>open fun [onOpen](../-reactor-listener/index.html#-1195333275%2FFunctions%2F-506170386)(webSocket: WebSocket, response: Response) |

