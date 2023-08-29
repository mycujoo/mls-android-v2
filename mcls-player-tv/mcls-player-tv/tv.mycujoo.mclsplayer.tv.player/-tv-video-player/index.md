---
title: TvVideoPlayer
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.player](../index.html)/[TvVideoPlayer](index.html)



# TvVideoPlayer



[androidJvm]\
class [TvVideoPlayer](index.html)@Injectconstructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), player: [IPlayer](../-i-player/index.html), ima: IIma?, controllerAgent: [ControllerAgent](../../tv.mycujoo.mclsplayer.tv.controller/-controller-agent/index.html), youboraAnalyticsClient: [YouboraAnalyticsClient](../../tv.mycujoo.mclsplayer.tv.analytics/-youbora-analytics-client/index.html))



## Constructors


| | |
|---|---|
| [TvVideoPlayer](-tv-video-player.html) | [androidJvm]<br>@Inject<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), player: [IPlayer](../-i-player/index.html), ima: IIma?, controllerAgent: [ControllerAgent](../../tv.mycujoo.mclsplayer.tv.controller/-controller-agent/index.html), youboraAnalyticsClient: [YouboraAnalyticsClient](../../tv.mycujoo.mclsplayer.tv.analytics/-youbora-analytics-client/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [getPlayerDirectInstance](get-player-direct-instance.html) | [androidJvm]<br>fun [getPlayerDirectInstance](get-player-direct-instance.html)(): ExoPlayer?<br>endregion |
| [initialize](initialize.html) | [androidJvm]<br>fun [initialize](initialize.html)(mlsTvFragment: [MCLSPlayerFragment](../../tv.mycujoo.mclsplayer.tv.ui/-m-c-l-s-player-fragment/index.html))<br>region Initializing |
| [playVideo](play-video.html) | [androidJvm]<br>fun [playVideo](play-video.html)(event: MCLSEvent, defaultStreamId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?)<br>region Playback |
| [release](release.html) | [androidJvm]<br>fun [release](release.html)()<br>Release resources & leave Reactor service |


## Properties


| Name | Summary |
|---|---|
| [mlsTVConfiguration](mls-t-v-configuration.html) | [androidJvm]<br>var [mlsTVConfiguration](mls-t-v-configuration.html): [MCLSTVConfiguration](../../tv.mycujoo.mclsplayer.tv.config/-m-c-l-s-t-v-configuration/index.html) |
| [mMlsTvFragment](m-mls-tv-fragment.html) | [androidJvm]<br>lateinit var [mMlsTvFragment](m-mls-tv-fragment.html): [MCLSPlayerFragment](../../tv.mycujoo.mclsplayer.tv.ui/-m-c-l-s-player-fragment/index.html) |

