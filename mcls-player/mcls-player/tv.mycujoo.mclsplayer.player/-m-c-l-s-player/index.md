---
title: MCLSPlayer
---
//[mcls-player](../../../index.html)/[tv.mycujoo.mclsplayer.player](../index.html)/[MCLSPlayer](index.html)



# MCLSPlayer

interface [MCLSPlayer](index.html) : [DefaultLifecycleObserver](https://developer.android.com/reference/kotlin/androidx/lifecycle/DefaultLifecycleObserver.html)

#### Inheritors


| |
|---|
| [MCLSPlayerImpl](../-m-c-l-s-player-impl/index.html) |


## Types


| Name | Summary |
|---|---|
| [Builder](-builder/index.html) | [androidJvm]<br>class [Builder](-builder/index.html) |


## Functions


| Name | Summary |
|---|---|
| [onCreate](index.html#139941652%2FFunctions%2F255153135) | [androidJvm]<br>open fun [onCreate](index.html#139941652%2FFunctions%2F255153135)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onDestroy](index.html#1057561704%2FFunctions%2F255153135) | [androidJvm]<br>open fun [onDestroy](index.html#1057561704%2FFunctions%2F255153135)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onPause](../-m-c-l-s-player-impl/index.html#187777572%2FFunctions%2F255153135) | [androidJvm]<br>open fun [onPause](../-m-c-l-s-player-impl/index.html#187777572%2FFunctions%2F255153135)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onResume](../-m-c-l-s-player-impl/index.html#-1807945979%2FFunctions%2F255153135) | [androidJvm]<br>open fun [onResume](../-m-c-l-s-player-impl/index.html#-1807945979%2FFunctions%2F255153135)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStart](../-m-c-l-s-player-impl/index.html#1240777104%2FFunctions%2F255153135) | [androidJvm]<br>open fun [onStart](../-m-c-l-s-player-impl/index.html#1240777104%2FFunctions%2F255153135)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStop](../-m-c-l-s-player-impl/index.html#487071706%2FFunctions%2F255153135) | [androidJvm]<br>open fun [onStop](../-m-c-l-s-player-impl/index.html#487071706%2FFunctions%2F255153135)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [playEvent](play-event.html) | [androidJvm]<br>abstract fun [playEvent](play-event.html)(event: MCLSEvent, defaultStreamId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |
| [setConfig](set-config.html) | [androidJvm]<br>abstract fun [setConfig](set-config.html)(config: VideoPlayerConfig) |
| [setIma](set-ima.html) | [androidJvm]<br>abstract fun [setIma](set-ima.html)(ima: IIma) |
| [setInFullScreen](set-in-full-screen.html) | [androidJvm]<br>abstract fun [setInFullScreen](set-in-full-screen.html)(onFullScreen: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setOnFullScreenClicked](set-on-full-screen-clicked.html) | [androidJvm]<br>abstract fun [setOnFullScreenClicked](set-on-full-screen-clicked.html)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [setOnPictureInPictureClicked](set-on-picture-in-picture-clicked.html) | [androidJvm]<br>abstract fun [setOnPictureInPictureClicked](set-on-picture-in-picture-clicked.html)(onClick: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [setPseudoUserId](set-pseudo-user-id.html) | [androidJvm]<br>abstract fun [setPseudoUserId](set-pseudo-user-id.html)(pseudoUserId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [setUserId](set-user-id.html) | [androidJvm]<br>abstract fun [setUserId](set-user-id.html)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |


## Properties


| Name | Summary |
|---|---|
| [player](player.html) | [androidJvm]<br>abstract val [player](player.html): [Player](../../tv.mycujoo.mclsplayer.player.player/-player/index.html) |

