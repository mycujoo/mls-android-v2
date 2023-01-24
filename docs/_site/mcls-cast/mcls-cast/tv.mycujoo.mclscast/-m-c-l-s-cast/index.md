//[mcls-cast](../../../index.md)/[tv.mycujoo.mclscast](../index.md)/[MCLSCast](index.md)

# MCLSCast

[androidJvm]\
class [MCLSCast](index.md) : [DefaultLifecycleObserver](https://developer.android.com/reference/kotlin/androidx/lifecycle/DefaultLifecycleObserver.html)

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [androidJvm]<br>class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [addListener](add-listener.md) | [androidJvm]<br>fun [addListener](add-listener.md)(castApplicationListener: [CastApplicationListener](../../tv.mycujoo.mclscast.manager/-cast-application-listener/index.md))<br>fun [addListener](add-listener.md)(castSessionListener: [CastSessionListener](../../tv.mycujoo.mclscast.manager/-cast-session-listener/index.md)) |
| [onCreate](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.md#139941652%2FFunctions%2F-1265366162) | [androidJvm]<br>open override fun [onCreate](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.md#139941652%2FFunctions%2F-1265366162)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onDestroy](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.md#1057561704%2FFunctions%2F-1265366162) | [androidJvm]<br>open override fun [onDestroy](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.md#1057561704%2FFunctions%2F-1265366162)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onPause](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.md#187777572%2FFunctions%2F-1265366162) | [androidJvm]<br>open override fun [onPause](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.md#187777572%2FFunctions%2F-1265366162)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onResume](on-resume.md) | [androidJvm]<br>open override fun [onResume](on-resume.md)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStart](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.md#1240777104%2FFunctions%2F-1265366162) | [androidJvm]<br>open override fun [onStart](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.md#1240777104%2FFunctions%2F-1265366162)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStop](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.md#487071706%2FFunctions%2F-1265366162) | [androidJvm]<br>open override fun [onStop](../../tv.mycujoo.mclscast.player/-m-c-l-s-cast-player/index.md#487071706%2FFunctions%2F-1265366162)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [playEvent](play-event.md) | [androidJvm]<br>fun [playEvent](play-event.md)(event: EventEntity, playWhenReady: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, position: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0) |
| [removeListener](remove-listener.md) | [androidJvm]<br>fun [removeListener](remove-listener.md)(castApplicationListener: [CastApplicationListener](../../tv.mycujoo.mclscast.manager/-cast-application-listener/index.md))<br>fun [removeListener](remove-listener.md)(castSessionListener: [CastSessionListener](../../tv.mycujoo.mclscast.manager/-cast-session-listener/index.md)) |
| [setLogLevel](set-log-level.md) | [androidJvm]<br>fun [setLogLevel](set-log-level.md)(logLevel: LogLevel) |

## Properties

| Name | Summary |
|---|---|
| [castListenerManager](cast-listener-manager.md) | [androidJvm]<br>@Inject<br>lateinit var [castListenerManager](cast-listener-manager.md): [CastListenerManager](../../tv.mycujoo.mclscast.manager/-cast-listener-manager/index.md) |
| [castPlayer](cast-player.md) | [androidJvm]<br>@Inject<br>lateinit var [castPlayer](cast-player.md): [CastPlayer](../../tv.mycujoo.mclscast.player/-cast-player/index.md) |
| [castPlayerConfig](cast-player-config.md) | [androidJvm]<br>val [castPlayerConfig](cast-player-config.md): [CastPlayerConfig](../../tv.mycujoo.mclscast.config/-cast-player-config/index.md) |
| [castSessionManager](cast-session-manager.md) | [androidJvm]<br>@Inject<br>lateinit var [castSessionManager](cast-session-manager.md): [CastSessionManager](../../tv.mycujoo.mclscast.manager/-cast-session-manager/index.md) |
| [identityToken](identity-token.md) | [androidJvm]<br>var [identityToken](identity-token.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [logger](logger.md) | [androidJvm]<br>@Inject<br>lateinit var [logger](logger.md): Logger |
| [pseudoUserId](pseudo-user-id.md) | [androidJvm]<br>var [pseudoUserId](pseudo-user-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [publicKey](public-key.md) | [androidJvm]<br>var [publicKey](public-key.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
