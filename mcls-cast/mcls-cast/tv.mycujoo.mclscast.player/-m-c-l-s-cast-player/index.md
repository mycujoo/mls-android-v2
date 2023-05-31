---
title: MCLSCastPlayer
---
//[mcls-cast](../../../index.html)/[tv.mycujoo.mclscast.player](../index.html)/[MCLSCastPlayer](index.html)



# MCLSCastPlayer



[androidJvm]\
class [MCLSCastPlayer](index.html)@Injectconstructor(castSessionManager: [CastSessionManager](../../tv.mycujoo.mclscast.manager/-cast-session-manager/index.html), castContext: CastContext, logger: Logger) : [CastPlayer](../-cast-player/index.html), [DefaultLifecycleObserver](https://developer.android.com/reference/kotlin/androidx/lifecycle/DefaultLifecycleObserver.html)



## Constructors


| | |
|---|---|
| [MCLSCastPlayer](-m-c-l-s-cast-player.html) | [androidJvm]<br>@Inject<br>constructor(castSessionManager: [CastSessionManager](../../tv.mycujoo.mclscast.manager/-cast-session-manager/index.html), castContext: CastContext, logger: Logger) |


## Functions


| Name | Summary |
|---|---|
| [currentPosition](current-position.html) | [androidJvm]<br>open override fun [currentPosition](current-position.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Return current position, if remote media client is setup |
| [fastForward](fast-forward.html) | [androidJvm]<br>open override fun [fastForward](fast-forward.html)(amount: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [isPlaying](is-playing.html) | [androidJvm]<br>open override fun [isPlaying](is-playing.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [loadRemoteMedia](load-remote-media.html) | [androidJvm]<br>open override fun [loadRemoteMedia](load-remote-media.html)(params: [CasterLoadRemoteMediaParams](../../tv.mycujoo.mclscast.model/-caster-load-remote-media-params/index.html)) |
| [onCreate](index.html#139941652%2FFunctions%2F-52010099) | [androidJvm]<br>open fun [onCreate](index.html#139941652%2FFunctions%2F-52010099)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onDestroy](index.html#1057561704%2FFunctions%2F-52010099) | [androidJvm]<br>open fun [onDestroy](index.html#1057561704%2FFunctions%2F-52010099)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onPause](index.html#187777572%2FFunctions%2F-52010099) | [androidJvm]<br>open fun [onPause](index.html#187777572%2FFunctions%2F-52010099)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onResume](index.html#-1807945979%2FFunctions%2F-52010099) | [androidJvm]<br>open fun [onResume](index.html#-1807945979%2FFunctions%2F-52010099)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStart](index.html#1240777104%2FFunctions%2F-52010099) | [androidJvm]<br>open fun [onStart](index.html#1240777104%2FFunctions%2F-52010099)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStop](index.html#487071706%2FFunctions%2F-52010099) | [androidJvm]<br>open fun [onStop](index.html#487071706%2FFunctions%2F-52010099)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [pause](pause.html) | [androidJvm]<br>open override fun [pause](pause.html)() |
| [play](play.html) | [androidJvm]<br>open override fun [play](play.html)() |
| [release](release.html) | [androidJvm]<br>open override fun [release](release.html)() |
| [rewind](rewind.html) | [androidJvm]<br>open override fun [rewind](rewind.html)(amount: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))<br>Rewind by given amount |
| [seekTo](seek-to.html) | [androidJvm]<br>open override fun [seekTo](seek-to.html)(position: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [streamDuration](stream-duration.html) | [androidJvm]<br>open override fun [streamDuration](stream-duration.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? |

