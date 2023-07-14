---
title: Builder
---
//[mcls-player](../../../../index.html)/[tv.mycujoo.mclsplayer.player](../../index.html)/[MCLSPlayer](../index.html)/[Builder](index.html)



# Builder



[androidJvm]\
class [Builder](index.html)



## Constructors


| | |
|---|---|
| [Builder](-builder.html) | [androidJvm]<br>constructor() |


## Functions


| Name | Summary |
|---|---|
| [build](build.html) | [androidJvm]<br>fun [build](build.html)(): [MCLSPlayer](../index.html) |
| [withActivity](with-activity.html) | [androidJvm]<br>fun [withActivity](with-activity.html)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html)): [MCLSPlayer.Builder](index.html) |
| [withAnalyticsDisabled](with-analytics-disabled.html) | [androidJvm]<br>fun [withAnalyticsDisabled](with-analytics-disabled.html)() |
| [withContext](with-context.html) | [androidJvm]<br>fun [withContext](with-context.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [MCLSPlayer.Builder](index.html) |
| [withExoPlayer](with-exo-player.html) | [androidJvm]<br>fun [withExoPlayer](with-exo-player.html)(exoPlayer: ExoPlayer): [MCLSPlayer.Builder](index.html) |
| [withIma](with-ima.html) | [androidJvm]<br>fun [withIma](with-ima.html)(IIma: IIma): [MCLSPlayer.Builder](index.html) |
| [withLifecycle](with-lifecycle.html) | [androidJvm]<br>fun [withLifecycle](with-lifecycle.html)(lifecycle: [Lifecycle](https://developer.android.com/reference/kotlin/androidx/lifecycle/Lifecycle.html)): [MCLSPlayer.Builder](index.html) |
| [withPlayerConfig](with-player-config.html) | [androidJvm]<br>fun [withPlayerConfig](with-player-config.html)(playerConfig: VideoPlayerConfig): [MCLSPlayer.Builder](index.html) |
| [withPlayerView](with-player-view.html) | [androidJvm]<br>fun [withPlayerView](with-player-view.html)(mclsPlayerView: [IMCLSPlayerView](../../../tv.mycujoo.mclsplayer.player.widget/-i-m-c-l-s-player-view/index.html)): [MCLSPlayer.Builder](index.html) |
| [withPseudoUserId](with-pseudo-user-id.html) | [androidJvm]<br>fun [withPseudoUserId](with-pseudo-user-id.html)(pseudoUserId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MCLSPlayer.Builder](index.html) |
| [withUserId](with-user-id.html) | [androidJvm]<br>fun [withUserId](with-user-id.html)(userId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MCLSPlayer.Builder](index.html) |


## Properties


| Name | Summary |
|---|---|
| [imaContainer](ima-container.html) | [androidJvm]<br>@Inject<br>lateinit var [imaContainer](ima-container.html): [IImaContainer](../../../tv.mycujoo.mclsplayer.player.ima/-i-ima-container/index.html) |
| [player](player.html) | [androidJvm]<br>@Inject<br>lateinit var [player](player.html): [Player](../../../tv.mycujoo.mclsplayer.player.player/-player/index.html) |
| [playerUser](player-user.html) | [androidJvm]<br>@Inject<br>lateinit var [playerUser](player-user.html): [UserPrefs](../../../tv.mycujoo.mclsplayer.player.user/-user-prefs/index.html) |
| [videoPlayerMediator](video-player-mediator.html) | [androidJvm]<br>@Inject<br>lateinit var [videoPlayerMediator](video-player-mediator.html): [VideoPlayerMediator](../../../tv.mycujoo.mclsplayer.player.mediator/-video-player-mediator/index.html) |
| [youboraAnalyticsClient](youbora-analytics-client.html) | [androidJvm]<br>@Inject<br>lateinit var [youboraAnalyticsClient](youbora-analytics-client.html): [YouboraAnalyticsClient](../../../tv.mycujoo.mclsplayer.player.analytics/-youbora-analytics-client/index.html) |

