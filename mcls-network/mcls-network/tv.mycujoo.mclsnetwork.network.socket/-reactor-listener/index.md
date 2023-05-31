---
title: ReactorListener
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.network.socket](../index.html)/[ReactorListener](index.html)



# ReactorListener



[androidJvm]\
class [ReactorListener](index.html)(reactorCallback: [ReactorCallback](../-reactor-callback/index.html)) : WebSocketListener



## Constructors


| | |
|---|---|
| [ReactorListener](-reactor-listener.html) | [androidJvm]<br>constructor(reactorCallback: [ReactorCallback](../-reactor-callback/index.html)) |


## Types


| Name | Summary |
|---|---|
| [ReactorMessage](-reactor-message/index.html) | [androidJvm]<br>sealed class [ReactorMessage](-reactor-message/index.html) |


## Functions


| Name | Summary |
|---|---|
| [onClosed](index.html#746747366%2FFunctions%2F-506170386) | [androidJvm]<br>open fun [onClosed](index.html#746747366%2FFunctions%2F-506170386)(webSocket: WebSocket, code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onClosing](index.html#-965341629%2FFunctions%2F-506170386) | [androidJvm]<br>open fun [onClosing](index.html#-965341629%2FFunctions%2F-506170386)(webSocket: WebSocket, code: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), reason: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onFailure](index.html#-593877028%2FFunctions%2F-506170386) | [androidJvm]<br>open fun [onFailure](index.html#-593877028%2FFunctions%2F-506170386)(webSocket: WebSocket, t: [Throwable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html), response: Response?) |
| [onMessage](index.html#-413335953%2FFunctions%2F-506170386) | [androidJvm]<br>open fun [onMessage](index.html#-413335953%2FFunctions%2F-506170386)(webSocket: WebSocket, bytes: ByteString)<br>open override fun [onMessage](on-message.html)(webSocket: WebSocket, text: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onOpen](index.html#-1195333275%2FFunctions%2F-506170386) | [androidJvm]<br>open fun [onOpen](index.html#-1195333275%2FFunctions%2F-506170386)(webSocket: WebSocket, response: Response) |

