---
title: tv.mycujoo.mclsplayer.tv.player
---
//[mcls-player-tv](../../index.html)/[tv.mycujoo.mclsplayer.tv.player](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [IPlayer](-i-player/index.html) | [androidJvm]<br>interface [IPlayer](-i-player/index.html) |
| [ISegmentProcessor](-i-segment-processor/index.html) | [androidJvm]<br>interface [ISegmentProcessor](-i-segment-processor/index.html) |
| [MediaDatum](-media-datum/index.html) | [androidJvm]<br>sealed class [MediaDatum](-media-datum/index.html) |
| [MediaFactory](-media-factory/index.html) | [androidJvm]<br>class [MediaFactory](-media-factory/index.html)@Injectconstructor(val defaultMediaSourceFactory: DefaultMediaSourceFactory, hlsMediaFactory: HlsMediaSource.Factory, mediaItemBuilder: MediaItem.Builder) |
| [MediaOnLoadCompletedListener](-media-on-load-completed-listener/index.html) | [androidJvm]<br>class [MediaOnLoadCompletedListener](-media-on-load-completed-listener/index.html)@Injectconstructor(exoPlayer: ExoPlayer) : MediaSourceEventListener |
| [Player](-player/index.html) | [androidJvm]<br>@Singleton<br>class [Player](-player/index.html)@Injectconstructor(mediaFactory: [MediaFactory](-media-factory/index.html), exoPlayer: ExoPlayer, mediaOnLoadCompletedListener: [MediaOnLoadCompletedListener](-media-on-load-completed-listener/index.html)) : [IPlayer](-i-player/index.html)<br>MLS video player, implementing IPlayer contract. All video playing related functionality is done by this class |
| [SegmentProcessor](-segment-processor/index.html) | [androidJvm]<br>class [SegmentProcessor](-segment-processor/index.html) : [ISegmentProcessor](-i-segment-processor/index.html) |
| [TvVideoPlayer](-tv-video-player/index.html) | [androidJvm]<br>class [TvVideoPlayer](-tv-video-player/index.html)@Injectconstructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), player: [IPlayer](-i-player/index.html), ima: IIma?, controllerAgent: [ControllerAgent](../tv.mycujoo.mclsplayer.tv.controller/-controller-agent/index.html), youboraAnalyticsClient: [YouboraAnalyticsClient](../tv.mycujoo.mclsplayer.tv.analytics/-youbora-analytics-client/index.html)) |

