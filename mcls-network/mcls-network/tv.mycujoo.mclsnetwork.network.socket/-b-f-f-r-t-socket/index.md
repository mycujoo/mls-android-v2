---
title: BFFRTSocket
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.network.socket](../index.html)/[BFFRTSocket](index.html)



# BFFRTSocket



[androidJvm]\
@Singleton



class [BFFRTSocket](index.html)@Injectconstructor(okHttpClient: OkHttpClient, mainSocketListener: [MainWebSocketListener](../-main-web-socket-listener/index.html), userPreferencesUtils: [UserPreferencesUtils](../../tv.mycujoo.mclsnetwork.util/-user-preferences-utils/index.html), webSocketUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [IBFFRTSocket](../-i-b-f-f-r-t-socket/index.html)



## Constructors


| | |
|---|---|
| [BFFRTSocket](-b-f-f-r-t-socket.html) | [androidJvm]<br>@Inject<br>constructor(okHttpClient: OkHttpClient, mainSocketListener: [MainWebSocketListener](../-main-web-socket-listener/index.html), userPreferencesUtils: [UserPreferencesUtils](../../tv.mycujoo.mclsnetwork.util/-user-preferences-utils/index.html), webSocketUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [addListener](add-listener.html) | [androidJvm]<br>open override fun [addListener](add-listener.html)(BFFRTCallback: [BFFRTCallback](../-b-f-f-r-t-callback/index.html)) |
| [leaveCurrentSession](leave-current-session.html) | [androidJvm]<br>open override fun [leaveCurrentSession](leave-current-session.html)() |
| [startSession](start-session.html) | [androidJvm]<br>open override fun [startSession](start-session.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), identityToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |

