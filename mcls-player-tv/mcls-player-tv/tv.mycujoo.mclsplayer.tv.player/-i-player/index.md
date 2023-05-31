---
title: IPlayer
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.player](../index.html)/[IPlayer](index.html)



# IPlayer

interface [IPlayer](index.html)

#### Inheritors


| |
|---|
| [Player](../-player/index.html) |


## Functions


| Name | Summary |
|---|---|
| [addListener](add-listener.html) | [androidJvm]<br>abstract fun [addListener](add-listener.html)(eventListener: Player.Listener) |
| [clearQue](clear-que.html) | [androidJvm]<br>abstract fun [clearQue](clear-que.html)() |
| [create](create.html) | [androidJvm]<br>abstract fun [create](create.html)(ima: IIma?) |
| [currentAbsoluteTime](current-absolute-time.html) | [androidJvm]<br>abstract fun [currentAbsoluteTime](current-absolute-time.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [currentPosition](current-position.html) | [androidJvm]<br>abstract fun [currentPosition](current-position.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [destroy](destroy.html) | [androidJvm]<br>abstract fun [destroy](destroy.html)() |
| [duration](duration.html) | [androidJvm]<br>abstract fun [duration](duration.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [dvrWindowSize](dvr-window-size.html) | [androidJvm]<br>abstract fun [dvrWindowSize](dvr-window-size.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [dvrWindowStartTime](dvr-window-start-time.html) | [androidJvm]<br>abstract fun [dvrWindowStartTime](dvr-window-start-time.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [getDirectInstance](get-direct-instance.html) | [androidJvm]<br>abstract fun [getDirectInstance](get-direct-instance.html)(): ExoPlayer? |
| [getPlayer](get-player.html) | [androidJvm]<br>abstract fun [getPlayer](get-player.html)(): Player? |
| [isLive](is-live.html) | [androidJvm]<br>abstract fun [isLive](is-live.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isPlaying](is-playing.html) | [androidJvm]<br>abstract fun [isPlaying](is-playing.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isPlayingAd](is-playing-ad.html) | [androidJvm]<br>abstract fun [isPlayingAd](is-playing-ad.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isWithinValidSegment](is-within-valid-segment.html) | [androidJvm]<br>abstract fun [isWithinValidSegment](is-within-valid-segment.html)(targetAbsoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? |
| [loadLastVideo](load-last-video.html) | [androidJvm]<br>abstract fun [loadLastVideo](load-last-video.html)() |
| [pause](pause.html) | [androidJvm]<br>abstract fun [pause](pause.html)() |
| [play](play.html) | [androidJvm]<br>abstract fun [play](play.html)()<br>abstract fun [play](play.html)(drmMediaData: [MediaDatum.DRMMediaData](../-media-datum/-d-r-m-media-data/index.html))<br>abstract fun [play](play.html)(mediaData: [MediaDatum.MediaData](../-media-datum/-media-data/index.html)) |
| [reInit](re-init.html) | [androidJvm]<br>abstract fun [reInit](re-init.html)(exoPlayer: ExoPlayer) |
| [release](release.html) | [androidJvm]<br>abstract fun [release](release.html)() |
| [seekTo](seek-to.html) | [androidJvm]<br>abstract fun [seekTo](seek-to.html)(offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [seekToWhenReady](seek-to-when-ready.html) | [androidJvm]<br>abstract fun [seekToWhenReady](seek-to-when-ready.html)(offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [setIsCasting](set-is-casting.html) | [androidJvm]<br>abstract fun [setIsCasting](set-is-casting.html)(isCasting: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |

