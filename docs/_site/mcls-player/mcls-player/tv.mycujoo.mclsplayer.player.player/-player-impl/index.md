//[mcls-player](../../../index.md)/[tv.mycujoo.mclsplayer.player.player](../index.md)/[PlayerImpl](index.md)

# PlayerImpl

[androidJvm]\
class [PlayerImpl](index.md)@Injectconstructor(exoPlayerContainer: [ExoPlayerContainer](../../tv.mycujoo.mclsplayer.player.utils/-exo-player-container/index.md), mediaFactory: [MediaFactory](../../tv.mycujoo.mclsplayer.player.model/-media-factory/index.md), mediaOnLoadCompletedListener: [MediaOnLoadCompletedListener](../-media-on-load-completed-listener/index.md)) : [Player](../-player/index.md)

## Constructors

| | |
|---|---|
| [PlayerImpl](-player-impl.md) | [androidJvm]<br>@Inject<br>fun [PlayerImpl](-player-impl.md)(exoPlayerContainer: [ExoPlayerContainer](../../tv.mycujoo.mclsplayer.player.utils/-exo-player-container/index.md), mediaFactory: [MediaFactory](../../tv.mycujoo.mclsplayer.player.model/-media-factory/index.md), mediaOnLoadCompletedListener: [MediaOnLoadCompletedListener](../-media-on-load-completed-listener/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [clearQue](clear-que.md) | [androidJvm]<br>open override fun [clearQue](clear-que.md)() |
| [currentPosition](current-position.md) | [androidJvm]<br>open override fun [currentPosition](current-position.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [duration](duration.md) | [androidJvm]<br>open override fun [duration](duration.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [getExoPlayerInstance](get-exo-player-instance.md) | [androidJvm]<br>open override fun [getExoPlayerInstance](get-exo-player-instance.md)(): ExoPlayer? |
| [isLive](is-live.md) | [androidJvm]<br>open override fun [isLive](is-live.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [pause](pause.md) | [androidJvm]<br>open override fun [pause](pause.md)() |
| [play](play.md) | [androidJvm]<br>open override fun [play](play.md)(drmMediaData: [MediaDatum.DRMMediaData](../../tv.mycujoo.mclsplayer.player.model/-media-datum/-d-r-m-media-data/index.md))<br>open override fun [play](play.md)(mediaData: [MediaDatum.MediaData](../../tv.mycujoo.mclsplayer.player.model/-media-datum/-media-data/index.md)) |
| [seekTo](seek-to.md) | [androidJvm]<br>open override fun [seekTo](seek-to.md)(position: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
