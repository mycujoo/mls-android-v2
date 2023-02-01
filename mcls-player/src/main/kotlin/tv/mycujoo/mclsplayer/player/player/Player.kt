package tv.mycujoo.mclsplayer.player.player

import com.google.android.exoplayer2.ExoPlayer
import tv.mycujoo.mclsplayer.player.model.MediaDatum

interface Player {

    fun currentPosition(): Long
    fun duration(): Long

    fun isLive(): Boolean

    fun clearQue()

    fun pause()

    fun play(drmMediaData: MediaDatum.DRMMediaData)
    fun play(mediaData: MediaDatum.MediaData)

    fun seekTo(position: Long)

    fun release()

    fun getExoPlayerInstance(): ExoPlayer?
}