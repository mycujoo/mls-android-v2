---
title: IMCLSPlayerView
---
//[mcls-player](../../../index.html)/[tv.mycujoo.mclsplayer.player.widget](../index.html)/[IMCLSPlayerView](index.html)



# IMCLSPlayerView

interface [IMCLSPlayerView](index.html)

#### Inheritors


| |
|---|
| [MCLSPlayerView](../-m-c-l-s-player-view/index.html) |


## Functions


| Name | Summary |
|---|---|
| [config](config.html) | [androidJvm]<br>abstract fun [config](config.html)(config: VideoPlayerConfig) |
| [getPlayerView](get-player-view.html) | [androidJvm]<br>abstract fun [getPlayerView](get-player-view.html)(): StyledPlayerView |
| [hideEventInfoButton](hide-event-info-button.html) | [androidJvm]<br>abstract fun [hideEventInfoButton](hide-event-info-button.html)() |
| [hideInfoDialogs](hide-info-dialogs.html) | [androidJvm]<br>abstract fun [hideInfoDialogs](hide-info-dialogs.html)() |
| [hidePictureInPictureButton](hide-picture-in-picture-button.html) | [androidJvm]<br>abstract fun [hidePictureInPictureButton](hide-picture-in-picture-button.html)() |
| [setEventInfo](set-event-info.html) | [androidJvm]<br>abstract fun [setEventInfo](set-event-info.html)(title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, startTime: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [setInFullScreen](set-in-full-screen.html) | [androidJvm]<br>abstract fun [setInFullScreen](set-in-full-screen.html)(inFullScreen: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setLive](set-live.html) | [androidJvm]<br>abstract fun [setLive](set-live.html)(isLive: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setOnFullScreenClicked](set-on-full-screen-clicked.html) | [androidJvm]<br>abstract fun [setOnFullScreenClicked](set-on-full-screen-clicked.html)(onFullScreenClicked: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>indicates click on Fullscreen/Minimize screen button in video-player |
| [setOnPictureInPictureClicked](set-on-picture-in-picture-clicked.html) | [androidJvm]<br>abstract fun [setOnPictureInPictureClicked](set-on-picture-in-picture-clicked.html)(onPictureInPictureClicked: () -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)) |
| [setPlayer](set-player.html) | [androidJvm]<br>abstract fun [setPlayer](set-player.html)(player: [Player](../../tv.mycujoo.mclsplayer.player.player/-player/index.html)) |
| [setPosterInfo](set-poster-info.html) | [androidJvm]<br>abstract fun [setPosterInfo](set-poster-info.html)(posterUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?) |
| [showCustomInformationDialog](show-custom-information-dialog.html) | [androidJvm]<br>abstract fun [showCustomInformationDialog](show-custom-information-dialog.html)(message: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [showEventInfoButton](show-event-info-button.html) | [androidJvm]<br>abstract fun [showEventInfoButton](show-event-info-button.html)() |
| [showPictureInPictureButton](show-picture-in-picture-button.html) | [androidJvm]<br>abstract fun [showPictureInPictureButton](show-picture-in-picture-button.html)() |
| [showPreEventInformationDialog](show-pre-event-information-dialog.html) | [androidJvm]<br>abstract fun [showPreEventInformationDialog](show-pre-event-information-dialog.html)() |
| [showStartedEventInformationDialog](show-started-event-information-dialog.html) | [androidJvm]<br>abstract fun [showStartedEventInformationDialog](show-started-event-information-dialog.html)() |
| [updateControllerVisibility](update-controller-visibility.html) | [androidJvm]<br>abstract fun [updateControllerVisibility](update-controller-visibility.html)(isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
