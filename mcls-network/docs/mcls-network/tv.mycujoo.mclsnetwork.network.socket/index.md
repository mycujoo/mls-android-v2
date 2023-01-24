---
title: tv.mycujoo.mclsnetwork.network.socket
---
//[mcls-network](../../index.html)/[tv.mycujoo.mclsnetwork.network.socket](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [BFFRTCallback](-b-f-f-r-t-callback/index.html) | [androidJvm]<br>interface [BFFRTCallback](-b-f-f-r-t-callback/index.html) |
| [BFFRTListener](-b-f-f-r-t-listener/index.html) | [androidJvm]<br>class [BFFRTListener](-b-f-f-r-t-listener/index.html)(BFFRTCallback: [BFFRTCallback](-b-f-f-r-t-callback/index.html)) : WebSocketListener |
| [BFFRTSocket](-b-f-f-r-t-socket/index.html) | [androidJvm]<br>@Singleton<br>class [BFFRTSocket](-b-f-f-r-t-socket/index.html)@Injectconstructor(okHttpClient: OkHttpClient, mainSocketListener: [MainWebSocketListener](-main-web-socket-listener/index.html), userPreferencesUtils: [UserPreferencesUtils](../tv.mycujoo.mclsnetwork.util/-user-preferences-utils/index.html), webSocketUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [IBFFRTSocket](-i-b-f-f-r-t-socket/index.html) |
| [IBFFRTSocket](-i-b-f-f-r-t-socket/index.html) | [androidJvm]<br>interface [IBFFRTSocket](-i-b-f-f-r-t-socket/index.html) |
| [IReactorSocket](-i-reactor-socket/index.html) | [androidJvm]<br>interface [IReactorSocket](-i-reactor-socket/index.html) |
| [MainWebSocketListener](-main-web-socket-listener/index.html) | [androidJvm]<br>class [MainWebSocketListener](-main-web-socket-listener/index.html)@Injectconstructor : WebSocketListener |
| [ReactorCallback](-reactor-callback/index.html) | [androidJvm]<br>interface [ReactorCallback](-reactor-callback/index.html) |
| [ReactorListener](-reactor-listener/index.html) | [androidJvm]<br>class [ReactorListener](-reactor-listener/index.html)(reactorCallback: [ReactorCallback](-reactor-callback/index.html)) : WebSocketListener |
| [ReactorSocket](-reactor-socket/index.html) | [androidJvm]<br>class [ReactorSocket](-reactor-socket/index.html)@Injectconstructor(okHttpClient: OkHttpClient, mainSocketListener: [MainWebSocketListener](-main-web-socket-listener/index.html), uuidUtils: [UuidUtils](../tv.mycujoo.mclsnetwork.util/-uuid-utils/index.html), webSocketUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [IReactorSocket](-i-reactor-socket/index.html) |


## Properties


| Name | Summary |
|---|---|
| [DEVICE_ID](-d-e-v-i-c-e_-i-d.html) | [androidJvm]<br>const val [DEVICE_ID](-d-e-v-i-c-e_-i-d.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [EVENT_TOTAL](-e-v-e-n-t_-t-o-t-a-l.html) | [androidJvm]<br>const val [EVENT_TOTAL](-e-v-e-n-t_-t-o-t-a-l.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [EVENT_UPDATE](-e-v-e-n-t_-u-p-d-a-t-e.html) | [androidJvm]<br>const val [EVENT_UPDATE](-e-v-e-n-t_-u-p-d-a-t-e.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [IDENTITY_TOKEN](-i-d-e-n-t-i-t-y_-t-o-k-e-n.html) | [androidJvm]<br>const val [IDENTITY_TOKEN](-i-d-e-n-t-i-t-y_-t-o-k-e-n.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [JOIN_EVENT](-j-o-i-n_-e-v-e-n-t.html) | [androidJvm]<br>const val [JOIN_EVENT](-j-o-i-n_-e-v-e-n-t.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [JOIN_TIMELINE](-j-o-i-n_-t-i-m-e-l-i-n-e.html) | [androidJvm]<br>const val [JOIN_TIMELINE](-j-o-i-n_-t-i-m-e-l-i-n-e.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [LEAVE_EVENT](-l-e-a-v-e_-e-v-e-n-t.html) | [androidJvm]<br>const val [LEAVE_EVENT](-l-e-a-v-e_-e-v-e-n-t.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [LEAVE_TIMELINE](-l-e-a-v-e_-t-i-m-e-l-i-n-e.html) | [androidJvm]<br>const val [LEAVE_TIMELINE](-l-e-a-v-e_-t-i-m-e-l-i-n-e.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [NORMAL_CLOSURE_STATUS_CODE](-n-o-r-m-a-l_-c-l-o-s-u-r-e_-s-t-a-t-u-s_-c-o-d-e.html) | [androidJvm]<br>const val [NORMAL_CLOSURE_STATUS_CODE](-n-o-r-m-a-l_-c-l-o-s-u-r-e_-s-t-a-t-u-s_-c-o-d-e.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1000 |
| [SEMICOLON](-s-e-m-i-c-o-l-o-n.html) | [androidJvm]<br>const val [SEMICOLON](-s-e-m-i-c-o-l-o-n.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [TIMELINE_UPDATE](-t-i-m-e-l-i-n-e_-u-p-d-a-t-e.html) | [androidJvm]<br>const val [TIMELINE_UPDATE](-t-i-m-e-l-i-n-e_-u-p-d-a-t-e.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

