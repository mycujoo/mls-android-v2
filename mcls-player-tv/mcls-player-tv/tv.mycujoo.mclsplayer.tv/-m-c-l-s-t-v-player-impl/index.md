---
title: MCLSTVPlayerImpl
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv](../index.html)/[MCLSTVPlayerImpl](index.html)



# MCLSTVPlayerImpl



[androidJvm]\
class [MCLSTVPlayerImpl](index.html)@Injectconstructor(videoPlayer: [TvVideoPlayer](../../tv.mycujoo.mclsplayer.tv.player/-tv-video-player/index.html), mMCLSTVFragment: [MCLSPlayerFragment](../../tv.mycujoo.mclsplayer.tv.ui/-m-c-l-s-player-fragment/index.html), exoPlayer: ExoPlayer) : [MCLSTVPlayer](../-m-c-l-s-t-v-player/index.html)



## Constructors


| | |
|---|---|
| [MCLSTVPlayerImpl](-m-c-l-s-t-v-player-impl.html) | [androidJvm]<br>@Inject<br>constructor(videoPlayer: [TvVideoPlayer](../../tv.mycujoo.mclsplayer.tv.player/-tv-video-player/index.html), mMCLSTVFragment: [MCLSPlayerFragment](../../tv.mycujoo.mclsplayer.tv.ui/-m-c-l-s-player-fragment/index.html), exoPlayer: ExoPlayer) |


## Functions


| Name | Summary |
|---|---|
| [currentPosition](current-position.html) | [androidJvm]<br>open override fun [currentPosition](current-position.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [isPlayingAd](is-playing-ad.html) | [androidJvm]<br>open override fun [isPlayingAd](is-playing-ad.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onCreate](index.html#139941652%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onCreate](index.html#139941652%2FFunctions%2F-1202460562)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onDestroy](index.html#1057561704%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onDestroy](index.html#1057561704%2FFunctions%2F-1202460562)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onPause](index.html#187777572%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onPause](index.html#187777572%2FFunctions%2F-1202460562)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onResume](on-resume.html) | [androidJvm]<br>open override fun [onResume](on-resume.html)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStart](index.html#1240777104%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onStart](index.html#1240777104%2FFunctions%2F-1202460562)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStop](index.html#487071706%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onStop](index.html#487071706%2FFunctions%2F-1202460562)(owner: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [playEvent](play-event.html) | [androidJvm]<br>open override fun [playEvent](play-event.html)(event: MCLSEvent) |


## Properties


| Name | Summary |
|---|---|
| [currentEvent](current-event.html) | [androidJvm]<br>var [currentEvent](current-event.html): MCLSEvent? |

