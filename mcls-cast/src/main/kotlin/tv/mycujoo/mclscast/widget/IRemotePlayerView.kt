package tv.mycujoo.mclscast.widget

import androidx.annotation.ColorInt
import tv.mycujoo.mclscast.config.CastPlayerConfig
import tv.mycujoo.mclscast.player.RemotePlayer
import tv.mycujoo.mclsplayercore.entity.LiveState

interface IRemotePlayerView {
    fun setPlayStatus(isPlaying: Boolean, isBuffering: Boolean? = null)
    fun setDuration(duration: Long)
    fun setPosition(position: Long)
    fun setLiveMode(liveState: LiveState)

    fun setTimeBarPlayedColor(@ColorInt color: Int)
    fun setPlayerMainButtonsColor(@ColorInt color: Int)
    fun setBufferingProgressBarsColor(@ColorInt color: Int)

    fun attachPlayer(player: RemotePlayer)

    fun config(config: CastPlayerConfig)
}