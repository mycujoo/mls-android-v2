---
title: PlayerImpl
---
//[mcls-player](../../../index.html)/[tv.mycujoo.mclsplayer.player.player](../index.html)/[PlayerImpl](index.html)



# PlayerImpl



[androidJvm]\
class [PlayerImpl](index.html)@Injectconstructor(exoPlayerContainer: [ExoPlayerContainer](../../tv.mycujoo.mclsplayer.player.utils/-exo-player-container/index.html), mediaFactory: [MediaFactory](../../tv.mycujoo.mclsplayer.player.model/-media-factory/index.html), mediaOnLoadCompletedListener: [MediaOnLoadCompletedListener](../-media-on-load-completed-listener/index.html)) : [Player](../-player/index.html)



## Constructors


| | |
|---|---|
| [PlayerImpl](-player-impl.html) | [androidJvm]<br>@Inject<br>fun [PlayerImpl](-player-impl.html)(exoPlayerContainer: [ExoPlayerContainer](../../tv.mycujoo.mclsplayer.player.utils/-exo-player-container/index.html), mediaFactory: [MediaFactory](../../tv.mycujoo.mclsplayer.player.model/-media-factory/index.html), mediaOnLoadCompletedListener: [MediaOnLoadCompletedListener](../-media-on-load-completed-listener/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [clearQue](clear-que.html) | [androidJvm]<br>open override fun [clearQue](clear-que.html)() |
| [currentPosition](current-position.html) | [androidJvm]<br>open override fun [currentPosition](current-position.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [duration](duration.html) | [androidJvm]<br>open override fun [duration](duration.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [getExoPlayerInstance](get-exo-player-instance.html) | [androidJvm]<br>open override fun [getExoPlayerInstance](get-exo-player-instance.html)(): ExoPlayer? |
| [isLive](is-live.html) | [androidJvm]<br>open override fun [isLive](is-live.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [pause](pause.html) | [androidJvm]<br>open override fun [pause](pause.html)() |
| [play](play.html) | [androidJvm]<br>open override fun [play](play.html)(drmMediaData: [MediaDatum.DRMMediaData](../../tv.mycujoo.mclsplayer.player.model/-media-datum/-d-r-m-media-data/index.html))<br>open override fun [play](play.html)(mediaData: [MediaDatum.MediaData](../../tv.mycujoo.mclsplayer.player.model/-media-datum/-media-data/index.html)) |
| [seekTo](seek-to.html) | [androidJvm]<br>open override fun [seekTo](seek-to.html)(position: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |

