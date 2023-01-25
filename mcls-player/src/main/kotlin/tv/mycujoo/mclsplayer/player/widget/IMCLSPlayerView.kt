package tv.mycujoo.mclsplayer.player.widget

import com.google.android.exoplayer2.ui.StyledPlayerView
import tv.mycujoo.mclsplayer.player.config.VideoPlayerConfig
import tv.mycujoo.mclsplayer.player.player.Player

interface IMCLSPlayerView {

    fun setPlayer(player: Player)

    /**
     * indicates click on Fullscreen/Minimize screen button in video-player
     * @param onFullScreenClicked true if video-player latest state (including the click event) is Fullscreen,
     * false otherwise
     */
    fun setOnFullScreenClicked(onFullScreenClicked: () -> Unit)
    fun setInFullScreen(inFullScreen: Boolean)

    fun setEventInfo(title: String, description: String?, startTime: String?)

    fun setPosterInfo(posterUrl: String?)

    fun showEventInfoButton()
    fun hideEventInfoButton()

    fun showPreEventInformationDialog()

    fun showStartedEventInformationDialog()

    fun updateControllerVisibility(isPlaying: Boolean)

    fun hideInfoDialogs()

    fun showCustomInformationDialog(message: String)

    fun config(config: VideoPlayerConfig)

    fun setLive(isLive: Boolean)

    fun getPlayerView(): StyledPlayerView
}