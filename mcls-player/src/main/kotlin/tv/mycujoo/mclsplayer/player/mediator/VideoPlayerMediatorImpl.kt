package tv.mycujoo.mclsplayer.player.mediator

import android.content.Context
import android.os.Build
import androidx.core.os.ConfigurationCompat
import com.google.android.exoplayer2.Player.Listener
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.entity.StreamStatus.*
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.MCLSStream
import tv.mycujoo.mclsplayer.R
import tv.mycujoo.mclsplayer.player.analytics.YouboraAnalyticsClient
import tv.mycujoo.mclsplayer.player.model.MediaDatum
import tv.mycujoo.mclsplayer.player.player.Player
import tv.mycujoo.mclsplayer.player.utils.ExoPlayerContainer
import tv.mycujoo.mclsplayer.player.widget.IMCLSPlayerView
import tv.mycujoo.mclsplayercore.config.VideoPlayerConfig
import javax.inject.Inject

class VideoPlayerMediatorImpl @Inject constructor(
    private val context: Context,
    private val player: Player,
    private val playerView: IMCLSPlayerView,
    private val exoPlayerContainer: ExoPlayerContainer,
    private val youboraAnalyticsClient: YouboraAnalyticsClient,
) : VideoPlayerMediator {

    private val config = context.resources.configuration

    private val locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        config.locales[0]
    } else {
        ConfigurationCompat.getLocales(config)[0]
    }

    private var videoPlayerConfig: VideoPlayerConfig = VideoPlayerConfig.default()

    private var currentEvent: MCLSEvent? = null
    private var streaming = false

    override fun playEvent(event: MCLSEvent, defaultStreamId: String?) {
        if (event.id != currentEvent?.id) {
            player.clearQue()
            streaming = false
        }
        currentEvent = event
        playVideoOrDisplayEventInfo(event, defaultStreamId)
    }

    override fun currentPosition(): Long {
        return player.currentPosition()
    }

    init {
        exoPlayerContainer.exoPlayer?.addListener(object : Listener {
            override fun onIsPlayingChanged(isPlaying: Boolean) {
                super.onIsPlayingChanged(isPlaying)

                playerView.setLive(exoPlayerContainer.exoPlayer?.isCurrentMediaItemLive == true)
            }
        })
    }

    /**
     * Sets the player config
     */
    override fun setConfig(config: VideoPlayerConfig) {
        this.videoPlayerConfig = config
    }

    /**
     * internal use: either play video, or display event info dialog.
     * This is decided based on status of stream url of event,
     * if it is playable, video player will start to stream.
     * @param event the event which is about to stream/display info
     * @see StreamStatus
     */
    private fun playVideoOrDisplayEventInfo(event: MCLSEvent, defaultStreamId: String?) {
        playerView.setEventInfo(
            event.title,
            event.description,
            event.getFormattedStartTimeDate(locale)
        )
        playerView.setPosterInfo(event.poster_url)
        if (videoPlayerConfig.showEventInfoButton) {
            playerView.showEventInfoButton()
        } else {
            playerView.hideEventInfoButton()
        }

        if (videoPlayerConfig.showPictureInPictureButton) {
            playerView.showPictureInPictureButton()
        } else {
            playerView.hidePictureInPictureButton()
        }

        if (event.streams.isEmpty()) {
            streaming = false
            player.pause()
            playerView.showPreEventInformationDialog()
            playerView.updateControllerVisibility(isPlaying = false)
            return
        }

        val streamToPlay = event.streams.firstOrNull { it.id == defaultStreamId }
            ?: event.streams.first()

        when (streamToPlay.streamStatus()) {
            PLAYABLE -> {
                if (streaming.not()) {
                    youboraAnalyticsClient.logEvent(event)
                    streaming = true
                    currentEvent = event
                    playerView.hideInfoDialogs()
                    playerView.updateControllerVisibility(isPlaying = true)
                    play(
                        stream = streamToPlay,
                        playWhenReady = true,
                        eventStatus = event.status
                    )
                }
            }

            GEOBLOCKED -> {
                streaming = false
                player.pause()
                playerView.showCustomInformationDialog(context.getString(R.string.message_geoblocked_stream))
                playerView.updateControllerVisibility(isPlaying = false)
            }

            NO_ENTITLEMENT -> {
                streaming = false
                player.pause()
                playerView.showCustomInformationDialog(context.getString(R.string.message_no_entitlement_stream))
                playerView.updateControllerVisibility(isPlaying = false)
            }

            UNKNOWN_ERROR -> {
                streaming = false
                player.pause()
                playerView.showPreEventInformationDialog()
                playerView.updateControllerVisibility(isPlaying = false)
            }
        }
    }

    /**
     * start playing the given Stream
     * @param stream information needed to play an event. including stream url, encoded type, etc
     * @see MCLSStream
     */
    private fun play(
        stream: MCLSStream,
        playWhenReady: Boolean? = null,
        eventStatus: EventStatus? = null,
    ) {
        if (stream.widevine?.fullUrl != null && stream.widevine?.licenseUrl != null) {
            player.play(
                MediaDatum.DRMMediaData(
                    fullUrl = stream.widevine?.fullUrl ?: "",
                    dvrWindowSize = stream.getDvrWindowSize(),
                    licenseUrl = stream.widevine?.licenseUrl ?: "",
                    autoPlay = playWhenReady ?: videoPlayerConfig.autoPlay,
                    eventStatus = eventStatus,
                )
            )
        } else if (stream.fullUrl != null) {
            player.play(
                MediaDatum.MediaData(
                    fullUrl = stream.fullUrl ?: "",
                    dvrWindowSize = stream.getDvrWindowSize(),
                    autoPlay = playWhenReady ?: videoPlayerConfig.autoPlay,
                    eventStatus = eventStatus,
                )
            )
        }
    }
    /**endregion */
}