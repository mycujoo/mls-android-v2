---
title: MCLSCast
---
//[mcls-cast](../../../index.html)/[tv.mycujoo.mclscast](../index.html)/[MCLSCast](index.html)



# MCLSCast



[androidJvm]\
class [MCLSCast](index.html) : [DefaultLifecycleObserver](https://developer.android.com/reference/kotlin/androidx/lifecycle/DefaultLifecycleObserver.html)



## Types


| Name | Summary |
|---|---|
| [Builder](-builder/index.html) | [androidJvm]<br>class [Builder](-builder/index.html) |


## Functions


| Name | Summary |
|---|---|
| [addListener](add-listener.html) | [androidJvm]<br>fun [addListener](add-listener.html)(castApplicationListener: [CastApplicationListener](../../tv.mycujoo.mclscast.manager/-cast-application-listener/index.html))<br>fun [addListener](add-listener.html)(castSessionListener: [CastSessionListener](../../tv.mycujoo.mclscast.manager/-cast-session-listener/index.html)) |
| [onCreate](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.html#139941652%2FFunctions%2F-52010099) | [androidJvm]<br>open override fun [onCreate](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.html#139941652%2FFunctions%2F-52010099)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onDestroy](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.html#1057561704%2FFunctions%2F-52010099) | [androidJvm]<br>open override fun [onDestroy](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.html#1057561704%2FFunctions%2F-52010099)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onPause](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.html#187777572%2FFunctions%2F-52010099) | [androidJvm]<br>open override fun [onPause](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.html#187777572%2FFunctions%2F-52010099)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onResume](on-resume.html) | [androidJvm]<br>open override fun [onResume](on-resume.html)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStart](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.html#1240777104%2FFunctions%2F-52010099) | [androidJvm]<br>open override fun [onStart](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.html#1240777104%2FFunctions%2F-52010099)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStop](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.html#487071706%2FFunctions%2F-52010099) | [androidJvm]<br>open override fun [onStop](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.html#487071706%2FFunctions%2F-52010099)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [playEvent](play-event.html) | [androidJvm]<br>fun [playEvent](play-event.html)(event: EventEntity, playWhenReady: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, position: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0) |
| [removeListener](remove-listener.html) | [androidJvm]<br>fun [removeListener](remove-listener.html)(castApplicationListener: [CastApplicationListener](../../tv.mycujoo.mclscast.manager/-cast-application-listener/index.html))<br>fun [removeListener](remove-listener.html)(castSessionListener: [CastSessionListener](../../tv.mycujoo.mclscast.manager/-cast-session-listener/index.html)) |
| [setLogLevel](set-log-level.html) | [androidJvm]<br>fun [setLogLevel](set-log-level.html)(logLevel: LogLevel) |


## Properties


| Name | Summary |
|---|---|
| [castListenerManager](cast-listener-manager.html) | [androidJvm]<br>@Inject<br>lateinit var [castListenerManager](cast-listener-manager.html): [CastListenerManager](../../tv.mycujoo.mclscast.manager/-cast-listener-manager/index.html) |
| [castPlayer](cast-player.html) | [androidJvm]<br>@Inject<br>lateinit var [castPlayer](cast-player.html): [CastPlayer](../../tv.mycujoo.mclscast.player/-cast-player/index.html) |
| [castPlayerConfig](cast-player-config.html) | [androidJvm]<br>val [castPlayerConfig](cast-player-config.html): [CastPlayerConfig](../../tv.mycujoo.mclscast.config/-cast-player-config/index.html) |
| [castSessionManager](cast-session-manager.html) | [androidJvm]<br>@Inject<br>lateinit var [castSessionManager](cast-session-manager.html): [CastSessionManager](../../tv.mycujoo.mclscast.manager/-cast-session-manager/index.html) |
| [identityToken](identity-token.html) | [androidJvm]<br>var [identityToken](identity-token.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [logger](logger.html) | [androidJvm]<br>@Inject<br>lateinit var [logger](logger.html): Logger |
| [pseudoUserId](pseudo-user-id.html) | [androidJvm]<br>var [pseudoUserId](pseudo-user-id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [publicKey](public-key.html) | [androidJvm]<br>var [publicKey](public-key.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

