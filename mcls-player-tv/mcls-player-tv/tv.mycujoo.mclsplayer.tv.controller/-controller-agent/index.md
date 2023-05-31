---
title: ControllerAgent
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.controller](../index.html)/[ControllerAgent](index.html)



# ControllerAgent



[androidJvm]\
class [ControllerAgent](index.html)@Injectconstructor(val player: [IPlayer](../../tv.mycujoo.mclsplayer.tv.player/-i-player/index.html))

Represent possible actions for Controller Live state, Viewers count



Use ILiveBadgeStateListener to change Live state of controller



Use setViewerCountView() to change viewers count or hide it



## Constructors


| | |
|---|---|
| [ControllerAgent](-controller-agent.html) | [androidJvm]<br>@Inject<br>constructor(player: [IPlayer](../../tv.mycujoo.mclsplayer.tv.player/-i-player/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [addLiveBadgeStateListener](add-live-badge-state-listener.html) | [androidJvm]<br>fun [addLiveBadgeStateListener](add-live-badge-state-listener.html)(listenerBadge: [ILiveBadgeStateListener](../-i-live-badge-state-listener/index.html)) |
| [backToLive](back-to-live.html) | [androidJvm]<br>fun [backToLive](back-to-live.html)() |
| [hideViewersCount](hide-viewers-count.html) | [androidJvm]<br>fun [hideViewersCount](hide-viewers-count.html)() |
| [onBufferingStateChanged](on-buffering-state-changed.html) | [androidJvm]<br>fun [onBufferingStateChanged](on-buffering-state-changed.html)(state: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setBufferProgressBar](set-buffer-progress-bar.html) | [androidJvm]<br>fun [setBufferProgressBar](set-buffer-progress-bar.html)(progressBar: [ProgressBar](https://developer.android.com/reference/kotlin/android/widget/ProgressBar.html))<br>region Buffer progress-bar |
| [setControllerLiveMode](set-controller-live-mode.html) | [androidJvm]<br>fun [setControllerLiveMode](set-controller-live-mode.html)(state: LiveState) |
| [setViewerCount](set-viewer-count.html) | [androidJvm]<br>fun [setViewerCount](set-viewer-count.html)(numberOfViewers: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [setViewerCountView](set-viewer-count-view.html) | [androidJvm]<br>fun [setViewerCountView](set-viewer-count-view.html)(viewersCountLayout: [ConstraintLayout](https://developer.android.com/reference/kotlin/androidx/constraintlayout/widget/ConstraintLayout.html), viewersCountTextView: [TextView](https://developer.android.com/reference/kotlin/android/widget/TextView.html)) |


## Properties


| Name | Summary |
|---|---|
| [player](player.html) | [androidJvm]<br>val [player](player.html): [IPlayer](../../tv.mycujoo.mclsplayer.tv.player/-i-player/index.html) |

