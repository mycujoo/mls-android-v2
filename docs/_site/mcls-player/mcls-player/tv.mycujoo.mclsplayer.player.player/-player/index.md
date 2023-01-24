//[mcls-player](../../../index.md)/[tv.mycujoo.mclsplayer.player.player](../index.md)/[Player](index.md)

# Player

[androidJvm]\
interface [Player](index.md)

## Functions

| Name | Summary |
|---|---|
| [clearQue](clear-que.md) | [androidJvm]<br>abstract fun [clearQue](clear-que.md)() |
| [currentPosition](current-position.md) | [androidJvm]<br>abstract fun [currentPosition](current-position.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [duration](duration.md) | [androidJvm]<br>abstract fun [duration](duration.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [getExoPlayerInstance](get-exo-player-instance.md) | [androidJvm]<br>abstract fun [getExoPlayerInstance](get-exo-player-instance.md)(): ExoPlayer? |
| [isLive](is-live.md) | [androidJvm]<br>abstract fun [isLive](is-live.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [pause](pause.md) | [androidJvm]<br>abstract fun [pause](pause.md)() |
| [play](play.md) | [androidJvm]<br>abstract fun [play](play.md)(drmMediaData: [MediaDatum.DRMMediaData](../../tv.mycujoo.mclsplayer.player.model/-media-datum/-d-r-m-media-data/index.md))<br>abstract fun [play](play.md)(mediaData: [MediaDatum.MediaData](../../tv.mycujoo.mclsplayer.player.model/-media-datum/-media-data/index.md)) |
| [seekTo](seek-to.md) | [androidJvm]<br>abstract fun [seekTo](seek-to.md)(position: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |

## Inheritors

| Name |
|---|
| [PlayerImpl](../-player-impl/index.md) |
