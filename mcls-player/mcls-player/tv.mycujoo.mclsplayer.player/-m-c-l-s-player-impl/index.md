---
title: MCLSPlayerImpl
---
//[mcls-player](../../../index.html)/[tv.mycujoo.mclsplayer.player](../index.html)/[MCLSPlayerImpl](index.html)



# MCLSPlayerImpl



[androidJvm]\
class [MCLSPlayerImpl](index.html) : [MCLSPlayer](../-m-c-l-s-player/index.html)



## Functions


| Name | Summary |
|---|---|
| [onCreate](on-create.html) | [androidJvm]<br>open override fun [onCreate](on-create.html)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onDestroy](on-destroy.html) | [androidJvm]<br>open override fun [onDestroy](on-destroy.html)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onPause](index.html#187777572%2FFunctions%2F255153135) | [androidJvm]<br>open fun [onPause](index.html#187777572%2FFunctions%2F255153135)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onResume](index.html#-1807945979%2FFunctions%2F255153135) | [androidJvm]<br>open fun [onResume](index.html#-1807945979%2FFunctions%2F255153135)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStart](index.html#1240777104%2FFunctions%2F255153135) | [androidJvm]<br>open fun [onStart](index.html#1240777104%2FFunctions%2F255153135)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStop](index.html#487071706%2FFunctions%2F255153135) | [androidJvm]<br>open fun [onStop](index.html#487071706%2FFunctions%2F255153135)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [playEvent](play-event.html) | [androidJvm]<br>open override fun [playEvent](play-event.html)(event: MCLSEvent, defaultStreamId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [replaceExoPlayerInstance](replace-exo-player-instance.html) | [androidJvm]<br>fun [replaceExoPlayerInstance](replace-exo-player-instance.html)(exoPlayer: ExoPlayer) |
| [setConfig](set-config.html) | [androidJvm]<br>open override fun [setConfig](set-config.html)(config: VideoPlayerConfig) |
| [setIma](set-ima.html) | [androidJvm]<br>open override fun [setIma](set-ima.html)(ima: IIma) |
| [setInFullScreen](set-in-full-screen.html) | [androidJvm]<br>open override fun [setInFullScreen](set-in-full-screen.html)(onFullScreen: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setOnFullScreenClicked](set-on-full-screen-clicked.html) | [androidJvm]<br>open override fun [setOnFullScreenClicked](set-on-full-screen-clicked.html)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [setOnPictureInPictureClicked](set-on-picture-in-picture-clicked.html) | [androidJvm]<br>open override fun [setOnPictureInPictureClicked](set-on-picture-in-picture-clicked.html)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [setPseudoUserId](set-pseudo-user-id.html) | [androidJvm]<br>open override fun [setPseudoUserId](set-pseudo-user-id.html)(pseudoUserId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [setUserId](set-user-id.html) | [androidJvm]<br>open override fun [setUserId](set-user-id.html)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |


## Properties


| Name | Summary |
|---|---|
| [player](player.html) | [androidJvm]<br>open override val [player](player.html): [Player](../../tv.mycujoo.mclsplayer.player.player/-player/index.html) |
| [playerUser](player-user.html) | [androidJvm]<br>var [playerUser](player-user.html): [UserPrefs](../../tv.mycujoo.mclsplayer.player.user/-user-prefs/index.html) |

