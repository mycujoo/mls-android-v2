//[mcls-player](../../../index.md)/[tv.mycujoo.mclsplayer.player](../index.md)/[MCLSPlayer](index.md)

# MCLSPlayer

[androidJvm]\
class [MCLSPlayer](index.md) : [DefaultLifecycleObserver](https://developer.android.com/reference/kotlin/androidx/lifecycle/DefaultLifecycleObserver.html)

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [androidJvm]<br>class [Builder](-builder/index.md) |

## Functions

| Name | Summary |
|---|---|
| [onCreate](on-create.md) | [androidJvm]<br>open override fun [onCreate](on-create.md)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onDestroy](on-destroy.md) | [androidJvm]<br>open override fun [onDestroy](on-destroy.md)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onPause](index.md#187777572%2FFunctions%2F1012385356) | [androidJvm]<br>open override fun [onPause](index.md#187777572%2FFunctions%2F1012385356)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onResume](index.md#-1807945979%2FFunctions%2F1012385356) | [androidJvm]<br>open override fun [onResume](index.md#-1807945979%2FFunctions%2F1012385356)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStart](index.md#1240777104%2FFunctions%2F1012385356) | [androidJvm]<br>open override fun [onStart](index.md#1240777104%2FFunctions%2F1012385356)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStop](index.md#487071706%2FFunctions%2F1012385356) | [androidJvm]<br>open override fun [onStop](index.md#487071706%2FFunctions%2F1012385356)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [playEvent](play-event.md) | [androidJvm]<br>fun [playEvent](play-event.md)(event: EventEntity) |
| [replaceExoPlayerInstance](replace-exo-player-instance.md) | [androidJvm]<br>fun [replaceExoPlayerInstance](replace-exo-player-instance.md)(exoPlayer: ExoPlayer) |
| [seekTo](seek-to.md) | [androidJvm]<br>fun [seekTo](seek-to.md)(position: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [setInFullScreen](set-in-full-screen.md) | [androidJvm]<br>fun [setInFullScreen](set-in-full-screen.md)(onFullScreen: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setOnFullScreenClicked](set-on-full-screen-clicked.md) | [androidJvm]<br>fun [setOnFullScreenClicked](set-on-full-screen-clicked.md)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [player](player.md) | [androidJvm]<br>@Inject<br>lateinit var [player](player.md): [Player](../../tv.mycujoo.mclsplayer.player.player/-player/index.md) |
| [videoPlayerMediator](video-player-mediator.md) | [androidJvm]<br>@Inject<br>lateinit var [videoPlayerMediator](video-player-mediator.md): [VideoPlayerMediator](../../tv.mycujoo.mclsplayer.player.mediator/-video-player-mediator/index.md) |
