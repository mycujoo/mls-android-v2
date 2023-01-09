package tv.mycujoo.mclsplayer.player.mediator

import android.content.Context
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.entity.StreamStatus.*
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.model.Stream
import tv.mycujoo.mclsplayer.player.player.Player
import tv.mycujoo.mclsplayer.player.config.VideoPlayerConfig
import tv.mycujoo.mclsplayer.player.model.MediaDatum
import tv.mycujoo.mclsplayer.player.widget.MCLSPlayerView
import tv.mycujoo.mclsplayer.R
import com.google.android.exoplayer2.Player.Listener
import timber.log.Timber
import tv.mycujoo.mclsplayer.player.utils.ExoPlayerContainer
import javax.inject.Inject

class VideoPlayerMediatorImpl @Inject constructor(
    private val context: Context,
    private val player: Player,
    private val playerView: MCLSPlayerView,
    private val exoPlayerContainer: ExoPlayerContainer,
) : VideoPlayerMediator {

    private var videoPlayerConfig: VideoPlayerConfig = VideoPlayerConfig.default()

    private var currentEvent: EventEntity? = null
    private var streamStatus: StreamStatus = NO_STREAM_URL
    private var streaming = false

    override fun playEvent(event: EventEntity) {
        if (event.id != currentEvent?.id) {
            player.clearQue()
        }
        currentEvent = event
        streamStatus = event.streamStatus()
        playVideoOrDisplayEventInfo(event)
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
     * internal use: either play video, or display event info dialog.
     * This is decided based on status of stream url of event,
     * if it is playable, video player will start to stream.
     * @param event the event which is about to stream/display info
     * @see StreamStatus
     */
    private fun playVideoOrDisplayEventInfo(event: EventEntity) {
        playerView.setEventInfo(event.title, event.description, event.getFormattedStartTimeDate())
        playerView.setPosterInfo(event.poster_url)
        if (videoPlayerConfig.showEventInfoButton) {
            playerView.showEventInfoButton()
        } else {
            playerView.hideEventInfoButton()
        }

        when (event.streamStatus()) {
            NO_STREAM_URL -> {
                streaming = false
                player.pause()
                playerView.showPreEventInformationDialog()
                playerView.updateControllerVisibility(isPlaying = false)
            }
            PLAYABLE -> {
                if (streaming.not()) {
                    streaming = true
                    currentEvent = event
                    playerView.hideInfoDialogs()
                    playerView.updateControllerVisibility(isPlaying = true)
                    play(
                        stream = event.streams.first(),
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
     * @see Stream
     */
    private fun play(
        stream: Stream,
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