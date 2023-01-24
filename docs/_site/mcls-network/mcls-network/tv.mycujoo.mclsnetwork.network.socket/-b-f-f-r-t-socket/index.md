//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.network.socket](../index.md)/[BFFRTSocket](index.md)

# BFFRTSocket

[androidJvm]\
@Singleton

class [BFFRTSocket](index.md)@Injectconstructor(okHttpClient: OkHttpClient, mainSocketListener: [MainWebSocketListener](../-main-web-socket-listener/index.md), userPreferencesUtils: [UserPreferencesUtils](../../tv.mycujoo.mclsnetwork.util/-user-preferences-utils/index.md), webSocketUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [IBFFRTSocket](../-i-b-f-f-r-t-socket/index.md)

## Constructors

| | |
|---|---|
| [BFFRTSocket](-b-f-f-r-t-socket.md) | [androidJvm]<br>@Inject<br>fun [BFFRTSocket](-b-f-f-r-t-socket.md)(okHttpClient: OkHttpClient, mainSocketListener: [MainWebSocketListener](../-main-web-socket-listener/index.md), userPreferencesUtils: [UserPreferencesUtils](../../tv.mycujoo.mclsnetwork.util/-user-preferences-utils/index.md), webSocketUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [addListener](add-listener.md) | [androidJvm]<br>open override fun [addListener](add-listener.md)(BFFRTCallback: [BFFRTCallback](../-b-f-f-r-t-callback/index.md)) |
| [leaveCurrentSession](leave-current-session.md) | [androidJvm]<br>open override fun [leaveCurrentSession](leave-current-session.md)() |
| [startSession](start-session.md) | [androidJvm]<br>open override fun [startSession](start-session.md)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), identityToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
