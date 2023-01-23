package tv.mycujoo.mclscast.player

import tv.mycujoo.mclscast.model.CasterLoadRemoteMediaParams

interface CastPlayer {

    fun loadRemoteMedia(params: CasterLoadRemoteMediaParams)
    fun play()
    fun pause()
    fun seekTo(position: Long)
    fun fastForward(amount: Long)
    fun rewind(amount: Long)
    fun currentPosition(): Long?
    fun streamDuration(): Long?

    fun isPlaying(): Boolean

    fun release()
}