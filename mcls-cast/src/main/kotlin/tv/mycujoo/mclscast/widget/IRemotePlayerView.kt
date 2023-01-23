package tv.mycujoo.mclscast.widget

import androidx.annotation.ColorInt
import tv.mycujoo.mclscast.config.CastPlayerConfig
import tv.mycujoo.mclscast.player.CastPlayer
import tv.mycujoo.mclsplayercore.entity.LiveState

interface IRemotePlayerView {
    fun setPlayStatus(isPlaying: Boolean, isBuffering: Boolean? = null)
    fun setDuration(duration: Long)
    fun setPosition(position: Long)
    fun setLiveMode(liveState: LiveState)

    fun setTimeBarPlayedColor(@ColorInt color: Int)
    fun setPlayerMainButtonsColor(@ColorInt color: Int)
    fun setBufferingProgressBarsColor(@ColorInt color: Int)

    fun showPreEventInformationDialog()

    fun showCustomInformationDialog(message: String)

    fun clearDialogs()

    fun setEventInfo(title: String, description: String?, startTime: String?)

    fun attachPlayer(player: CastPlayer)

    fun config(config: CastPlayerConfig)

    fun hideController()

    fun showController()
}