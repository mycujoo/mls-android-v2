//[mcls-cast](../../../index.md)/[tv.mycujoo.mclscast.player](../index.md)/[MCLSCastPlayer](index.md)

# MCLSCastPlayer

[androidJvm]\
class [MCLSCastPlayer](index.md)@Injectconstructor(castSessionManager: [CastSessionManager](../../tv.mycujoo.mclscast.manager/-cast-session-manager/index.md), castContext: CastContext, logger: Logger) : [CastPlayer](../-cast-player/index.md), [DefaultLifecycleObserver](https://developer.android.com/reference/kotlin/androidx/lifecycle/DefaultLifecycleObserver.html)

## Constructors

| | |
|---|---|
| [MCLSCastPlayer](-m-c-l-s-cast-player.md) | [androidJvm]<br>@Inject<br>fun [MCLSCastPlayer](-m-c-l-s-cast-player.md)(castSessionManager: [CastSessionManager](../../tv.mycujoo.mclscast.manager/-cast-session-manager/index.md), castContext: CastContext, logger: Logger) |

## Functions

| Name | Summary |
|---|---|
| [currentPosition](current-position.md) | [androidJvm]<br>open override fun [currentPosition](current-position.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Return current position, if remote media client is setup |
| [fastForward](fast-forward.md) | [androidJvm]<br>open override fun [fastForward](fast-forward.md)(amount: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [isPlaying](is-playing.md) | [androidJvm]<br>open override fun [isPlaying](is-playing.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [loadRemoteMedia](load-remote-media.md) | [androidJvm]<br>open override fun [loadRemoteMedia](load-remote-media.md)(params: [CasterLoadRemoteMediaParams](../../tv.mycujoo.mclscast.model/-caster-load-remote-media-params/index.md)) |
| [onCreate](index.md#139941652%2FFunctions%2F-1265366162) | [androidJvm]<br>open override fun [onCreate](index.md#139941652%2FFunctions%2F-1265366162)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onDestroy](index.md#1057561704%2FFunctions%2F-1265366162) | [androidJvm]<br>open override fun [onDestroy](index.md#1057561704%2FFunctions%2F-1265366162)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onPause](index.md#187777572%2FFunctions%2F-1265366162) | [androidJvm]<br>open override fun [onPause](index.md#187777572%2FFunctions%2F-1265366162)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onResume](index.md#-1807945979%2FFunctions%2F-1265366162) | [androidJvm]<br>open override fun [onResume](index.md#-1807945979%2FFunctions%2F-1265366162)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStart](index.md#1240777104%2FFunctions%2F-1265366162) | [androidJvm]<br>open override fun [onStart](index.md#1240777104%2FFunctions%2F-1265366162)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStop](index.md#487071706%2FFunctions%2F-1265366162) | [androidJvm]<br>open override fun [onStop](index.md#487071706%2FFunctions%2F-1265366162)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [pause](pause.md) | [androidJvm]<br>open override fun [pause](pause.md)() |
| [play](play.md) | [androidJvm]<br>open override fun [play](play.md)() |
| [release](release.md) | [androidJvm]<br>open override fun [release](release.md)() |
| [rewind](rewind.md) | [androidJvm]<br>open override fun [rewind](rewind.md)(amount: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))<br>Rewind by given amount |
| [seekTo](seek-to.md) | [androidJvm]<br>open override fun [seekTo](seek-to.md)(position: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [streamDuration](stream-duration.md) | [androidJvm]<br>open override fun [streamDuration](stream-duration.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? |
