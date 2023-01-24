//[mcls-network](../../index.md)/[tv.mycujoo.mclsnetwork.network.socket](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [BFFRTCallback](-b-f-f-r-t-callback/index.md) | [androidJvm]<br>interface [BFFRTCallback](-b-f-f-r-t-callback/index.md) |
| [BFFRTListener](-b-f-f-r-t-listener/index.md) | [androidJvm]<br>class [BFFRTListener](-b-f-f-r-t-listener/index.md)(BFFRTCallback: [BFFRTCallback](-b-f-f-r-t-callback/index.md)) : WebSocketListener |
| [BFFRTSocket](-b-f-f-r-t-socket/index.md) | [androidJvm]<br>@Singleton<br>class [BFFRTSocket](-b-f-f-r-t-socket/index.md)@Injectconstructor(okHttpClient: OkHttpClient, mainSocketListener: [MainWebSocketListener](-main-web-socket-listener/index.md), userPreferencesUtils: [UserPreferencesUtils](../tv.mycujoo.mclsnetwork.util/-user-preferences-utils/index.md), webSocketUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [IBFFRTSocket](-i-b-f-f-r-t-socket/index.md) |
| [IBFFRTSocket](-i-b-f-f-r-t-socket/index.md) | [androidJvm]<br>interface [IBFFRTSocket](-i-b-f-f-r-t-socket/index.md) |
| [IReactorSocket](-i-reactor-socket/index.md) | [androidJvm]<br>interface [IReactorSocket](-i-reactor-socket/index.md) |
| [MainWebSocketListener](-main-web-socket-listener/index.md) | [androidJvm]<br>class [MainWebSocketListener](-main-web-socket-listener/index.md)@Injectconstructor : WebSocketListener |
| [ReactorCallback](-reactor-callback/index.md) | [androidJvm]<br>interface [ReactorCallback](-reactor-callback/index.md) |
| [ReactorListener](-reactor-listener/index.md) | [androidJvm]<br>class [ReactorListener](-reactor-listener/index.md)(reactorCallback: [ReactorCallback](-reactor-callback/index.md)) : WebSocketListener |
| [ReactorSocket](-reactor-socket/index.md) | [androidJvm]<br>class [ReactorSocket](-reactor-socket/index.md)@Injectconstructor(okHttpClient: OkHttpClient, mainSocketListener: [MainWebSocketListener](-main-web-socket-listener/index.md), uuidUtils: [UuidUtils](../tv.mycujoo.mclsnetwork.util/-uuid-utils/index.md), webSocketUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [IReactorSocket](-i-reactor-socket/index.md) |

## Properties

| Name | Summary |
|---|---|
| [DEVICE_ID](-d-e-v-i-c-e_-i-d.md) | [androidJvm]<br>const val [DEVICE_ID](-d-e-v-i-c-e_-i-d.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [EVENT_TOTAL](-e-v-e-n-t_-t-o-t-a-l.md) | [androidJvm]<br>const val [EVENT_TOTAL](-e-v-e-n-t_-t-o-t-a-l.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [EVENT_UPDATE](-e-v-e-n-t_-u-p-d-a-t-e.md) | [androidJvm]<br>const val [EVENT_UPDATE](-e-v-e-n-t_-u-p-d-a-t-e.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [IDENTITY_TOKEN](-i-d-e-n-t-i-t-y_-t-o-k-e-n.md) | [androidJvm]<br>const val [IDENTITY_TOKEN](-i-d-e-n-t-i-t-y_-t-o-k-e-n.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [JOIN_EVENT](-j-o-i-n_-e-v-e-n-t.md) | [androidJvm]<br>const val [JOIN_EVENT](-j-o-i-n_-e-v-e-n-t.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [JOIN_TIMELINE](-j-o-i-n_-t-i-m-e-l-i-n-e.md) | [androidJvm]<br>const val [JOIN_TIMELINE](-j-o-i-n_-t-i-m-e-l-i-n-e.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [LEAVE_EVENT](-l-e-a-v-e_-e-v-e-n-t.md) | [androidJvm]<br>const val [LEAVE_EVENT](-l-e-a-v-e_-e-v-e-n-t.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [LEAVE_TIMELINE](-l-e-a-v-e_-t-i-m-e-l-i-n-e.md) | [androidJvm]<br>const val [LEAVE_TIMELINE](-l-e-a-v-e_-t-i-m-e-l-i-n-e.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [NORMAL_CLOSURE_STATUS_CODE](-n-o-r-m-a-l_-c-l-o-s-u-r-e_-s-t-a-t-u-s_-c-o-d-e.md) | [androidJvm]<br>const val [NORMAL_CLOSURE_STATUS_CODE](-n-o-r-m-a-l_-c-l-o-s-u-r-e_-s-t-a-t-u-s_-c-o-d-e.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 1000 |
| [SEMICOLON](-s-e-m-i-c-o-l-o-n.md) | [androidJvm]<br>const val [SEMICOLON](-s-e-m-i-c-o-l-o-n.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [TIMELINE_UPDATE](-t-i-m-e-l-i-n-e_-u-p-d-a-t-e.md) | [androidJvm]<br>const val [TIMELINE_UPDATE](-t-i-m-e-l-i-n-e_-u-p-d-a-t-e.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
