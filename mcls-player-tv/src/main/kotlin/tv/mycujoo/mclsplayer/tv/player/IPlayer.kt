package tv.mycujoo.mclsplayer.tv.player

import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Player
import tv.mycujoo.mclsplayer.tv.ima.IIma

interface IPlayer {
    fun create(
        ima: IIma?,
    )
    fun reInit(exoPlayer: ExoPlayer)

    // will be removed!
    fun getDirectInstance(): ExoPlayer?
    fun getPlayer(): Player?

    fun addListener(eventListener: Player.Listener)

    fun seekTo(offset: Long)
    fun seekToWhenReady(offset: Long)
    fun currentPosition(): Long
    fun currentAbsoluteTime(): Long
    fun duration(): Long
    fun isLive(): Boolean
    fun isPlaying(): Boolean
    fun isPlayingAd(): Boolean

    fun release()
    fun destroy()

    fun clearQue()

    fun play(drmMediaData: MediaDatum.DRMMediaData)
    fun play(mediaData: MediaDatum.MediaData)

    fun setIsCasting(isCasting: Boolean)

    fun play()
    fun pause()

    fun loadLastVideo()

    fun isWithinValidSegment(targetAbsoluteTime: Long): Boolean?
    fun dvrWindowSize(): Long
    fun dvrWindowStartTime(): Long
}