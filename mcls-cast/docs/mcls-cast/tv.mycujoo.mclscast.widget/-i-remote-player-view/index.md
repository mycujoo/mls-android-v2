---
title: IRemotePlayerView
---
//[mcls-cast](../../../index.html)/[tv.mycujoo.mclscast.widget](../index.html)/[IRemotePlayerView](index.html)



# IRemotePlayerView



[androidJvm]\
interface [IRemotePlayerView](index.html)



## Functions


| Name | Summary |
|---|---|
| [attachPlayer](attach-player.html) | [androidJvm]<br>abstract fun [attachPlayer](attach-player.html)(player: [CastPlayer](../../tv.mycujoo.mclscast.player/-cast-player/index.html)) |
| [clearDialogs](clear-dialogs.html) | [androidJvm]<br>abstract fun [clearDialogs](clear-dialogs.html)() |
| [config](config.html) | [androidJvm]<br>abstract fun [config](config.html)(config: [CastPlayerConfig](../../tv.mycujoo.mclscast.config/-cast-player-config/index.html)) |
| [hideController](hide-controller.html) | [androidJvm]<br>abstract fun [hideController](hide-controller.html)() |
| [setBufferingProgressBarsColor](set-buffering-progress-bars-color.html) | [androidJvm]<br>abstract fun [setBufferingProgressBarsColor](set-buffering-progress-bars-color.html)(@[ColorInt](https://developer.android.com/reference/kotlin/androidx/annotation/ColorInt.html)color: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [setDuration](set-duration.html) | [androidJvm]<br>abstract fun [setDuration](set-duration.html)(duration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [setEventInfo](set-event-info.html) | [androidJvm]<br>abstract fun [setEventInfo](set-event-info.html)(title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, startTime: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [setLiveMode](set-live-mode.html) | [androidJvm]<br>abstract fun [setLiveMode](set-live-mode.html)(liveState: LiveState) |
| [setPlayerMainButtonsColor](set-player-main-buttons-color.html) | [androidJvm]<br>abstract fun [setPlayerMainButtonsColor](set-player-main-buttons-color.html)(@[ColorInt](https://developer.android.com/reference/kotlin/androidx/annotation/ColorInt.html)color: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [setPlayStatus](set-play-status.html) | [androidJvm]<br>abstract fun [setPlayStatus](set-play-status.html)(isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), isBuffering: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null) |
| [setPosition](set-position.html) | [androidJvm]<br>abstract fun [setPosition](set-position.html)(position: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [setTimeBarPlayedColor](set-time-bar-played-color.html) | [androidJvm]<br>abstract fun [setTimeBarPlayedColor](set-time-bar-played-color.html)(@[ColorInt](https://developer.android.com/reference/kotlin/androidx/annotation/ColorInt.html)color: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [showController](show-controller.html) | [androidJvm]<br>abstract fun [showController](show-controller.html)() |
| [showCustomInformationDialog](show-custom-information-dialog.html) | [androidJvm]<br>abstract fun [showCustomInformationDialog](show-custom-information-dialog.html)(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [showPreEventInformationDialog](show-pre-event-information-dialog.html) | [androidJvm]<br>abstract fun [showPreEventInformationDialog](show-pre-event-information-dialog.html)() |


## Inheritors


| Name |
|---|
| [RemotePlayerView](../-remote-player-view/index.html) |

