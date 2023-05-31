---
title: Player
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.player](../index.html)/[Player](index.html)



# Player





@Singleton



class [Player](index.html)@Injectconstructor(mediaFactory: [MediaFactory](../-media-factory/index.html), exoPlayer: ExoPlayer, mediaOnLoadCompletedListener: [MediaOnLoadCompletedListener](../-media-on-load-completed-listener/index.html)) : [IPlayer](../-i-player/index.html)

MLS video player, implementing IPlayer contract. All video playing related functionality is done by this class



#### See also


| |
|---|
| [IPlayer](../-i-player/index.html) |


## Constructors


| | |
|---|---|
| [Player](-player.html) | [androidJvm]<br>@Inject<br>constructor(mediaFactory: [MediaFactory](../-media-factory/index.html), exoPlayer: ExoPlayer, mediaOnLoadCompletedListener: [MediaOnLoadCompletedListener](../-media-on-load-completed-listener/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [addListener](add-listener.html) | [androidJvm]<br>open override fun [addListener](add-listener.html)(eventListener: Player.Listener)<br>Add listener to Exoplayer |
| [clearQue](clear-que.html) | [androidJvm]<br>open override fun [clearQue](clear-que.html)() |
| [create](create.html) | [androidJvm]<br>open override fun [create](create.html)(ima: IIma?)<br>Create a ready-to-use Player by setting all the given properties |
| [currentAbsoluteTime](current-absolute-time.html) | [androidJvm]<br>open override fun [currentAbsoluteTime](current-absolute-time.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Current absolute time |
| [currentPosition](current-position.html) | [androidJvm]<br>open override fun [currentPosition](current-position.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Current position |
| [destroy](destroy.html) | [androidJvm]<br>open override fun [destroy](destroy.html)()<br>reset all values to default Should only be called in onDestroy |
| [duration](duration.html) | [androidJvm]<br>open override fun [duration](duration.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Duration of current media item |
| [dvrWindowSize](dvr-window-size.html) | [androidJvm]<br>open override fun [dvrWindowSize](dvr-window-size.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Return current DVR window size |
| [dvrWindowStartTime](dvr-window-start-time.html) | [androidJvm]<br>open override fun [dvrWindowStartTime](dvr-window-start-time.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Return current DVR window start time |
| [getDirectInstance](get-direct-instance.html) | [androidJvm]<br>open override fun [getDirectInstance](get-direct-instance.html)(): ExoPlayer |
| [getPlayer](get-player.html) | [androidJvm]<br>open override fun [getPlayer](get-player.html)(): Player |
| [isLive](is-live.html) | [androidJvm]<br>open override fun [isLive](is-live.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Live status of current media item |
| [isPlaying](is-playing.html) | [androidJvm]<br>open override fun [isPlaying](is-playing.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Playing status of current media item |
| [isPlayingAd](is-playing-ad.html) | [androidJvm]<br>open override fun [isPlayingAd](is-playing-ad.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Playing-Ad status of current media item |
| [isWithinValidSegment](is-within-valid-segment.html) | [androidJvm]<br>open override fun [isWithinValidSegment](is-within-valid-segment.html)(targetAbsoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)?<br>Compare absolute time with current segment time range |
| [loadLastVideo](load-last-video.html) | [androidJvm]<br>open override fun [loadLastVideo](load-last-video.html)()<br>Load last loaded media item |
| [pause](pause.html) | [androidJvm]<br>open override fun [pause](pause.html)()<br>Pause current media item |
| [play](play.html) | [androidJvm]<br>open override fun [play](play.html)()<br>Play current media item<br>[androidJvm]<br>open override fun [play](play.html)(drmMediaData: [MediaDatum.DRMMediaData](../-media-datum/-d-r-m-media-data/index.html))<br>open override fun [play](play.html)(mediaData: [MediaDatum.MediaData](../-media-datum/-media-data/index.html))<br>Play media item |
| [reInit](re-init.html) | [androidJvm]<br>open override fun [reInit](re-init.html)(exoPlayer: ExoPlayer)<br>re-initialize Player by setting those properties that are life-cycle bound |
| [release](release.html) | [androidJvm]<br>open override fun [release](release.html)()<br>Release resources |
| [seekTo](seek-to.html) | [androidJvm]<br>open override fun [seekTo](seek-to.html)(offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))<br>Seek to given offset |
| [seekToWhenReady](seek-to-when-ready.html) | [androidJvm]<br>open override fun [seekToWhenReady](seek-to-when-ready.html)(offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [setIsCasting](set-is-casting.html) | [androidJvm]<br>open override fun [setIsCasting](set-is-casting.html)(isCasting: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |

