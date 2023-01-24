---
title: MCLSPlayer
---
//[mcls-player](../../../index.html)/[tv.mycujoo.mclsplayer.player](../index.html)/[MCLSPlayer](index.html)



# MCLSPlayer



[androidJvm]\
class [MCLSPlayer](index.html) : [DefaultLifecycleObserver](https://developer.android.com/reference/kotlin/androidx/lifecycle/DefaultLifecycleObserver.html)



## Types


| Name | Summary |
|---|---|
| [Builder](-builder/index.html) | [androidJvm]<br>class [Builder](-builder/index.html) |


## Functions


| Name | Summary |
|---|---|
| [onCreate](on-create.html) | [androidJvm]<br>open override fun [onCreate](on-create.html)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onDestroy](on-destroy.html) | [androidJvm]<br>open override fun [onDestroy](on-destroy.html)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onPause](index.html#187777572%2FFunctions%2F255153135) | [androidJvm]<br>open override fun [onPause](index.html#187777572%2FFunctions%2F255153135)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onResume](index.html#-1807945979%2FFunctions%2F255153135) | [androidJvm]<br>open override fun [onResume](index.html#-1807945979%2FFunctions%2F255153135)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStart](index.html#1240777104%2FFunctions%2F255153135) | [androidJvm]<br>open override fun [onStart](index.html#1240777104%2FFunctions%2F255153135)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStop](index.html#487071706%2FFunctions%2F255153135) | [androidJvm]<br>open override fun [onStop](index.html#487071706%2FFunctions%2F255153135)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [playEvent](play-event.html) | [androidJvm]<br>fun [playEvent](play-event.html)(event: EventEntity) |
| [replaceExoPlayerInstance](replace-exo-player-instance.html) | [androidJvm]<br>fun [replaceExoPlayerInstance](replace-exo-player-instance.html)(exoPlayer: ExoPlayer) |
| [seekTo](seek-to.html) | [androidJvm]<br>fun [seekTo](seek-to.html)(position: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [setInFullScreen](set-in-full-screen.html) | [androidJvm]<br>fun [setInFullScreen](set-in-full-screen.html)(onFullScreen: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setOnFullScreenClicked](set-on-full-screen-clicked.html) | [androidJvm]<br>fun [setOnFullScreenClicked](set-on-full-screen-clicked.html)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |


## Properties


| Name | Summary |
|---|---|
| [player](player.html) | [androidJvm]<br>@Inject<br>lateinit var [player](player.html): [Player](../../tv.mycujoo.mclsplayer.player.player/-player/index.html) |
| [videoPlayerMediator](video-player-mediator.html) | [androidJvm]<br>@Inject<br>lateinit var [videoPlayerMediator](video-player-mediator.html): [VideoPlayerMediator](../../tv.mycujoo.mclsplayer.player.mediator/-video-player-mediator/index.html) |

