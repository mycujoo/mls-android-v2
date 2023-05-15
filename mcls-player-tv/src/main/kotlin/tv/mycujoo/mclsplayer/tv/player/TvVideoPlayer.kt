package tv.mycujoo.mclsplayer.tv.player

import android.content.Context
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.leanback.app.VideoSupportFragmentGlueHost
import androidx.leanback.media.PlaybackGlue
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ext.leanback.LeanbackPlayerAdapter
import com.google.android.exoplayer2.ui.AdViewProvider
import timber.log.Timber
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.MCLSStream
import tv.mycujoo.mclsdialogs.inflateCustomInformationDialog
import tv.mycujoo.mclsdialogs.inflatePreEventInformationDialog
import tv.mycujoo.mclsplayer.tv.R
import tv.mycujoo.mclsplayer.tv.config.MCLSTVConfiguration
import tv.mycujoo.mclsplayer.tv.controller.ControllerAgent
import tv.mycujoo.mclsima.IIma
import tv.mycujoo.mclsplayer.tv.transport.MCLSPlaybackTransportControlGlueImpl
import tv.mycujoo.mclsplayer.tv.transport.MLSPlaybackSeekDataProvider
import tv.mycujoo.mclsplayer.tv.ui.MCLSTVFragment
import tv.mycujoo.mclsplayercore.entity.LiveState
import java.lang.IllegalStateException
import java.util.*
import javax.inject.Inject

class TvVideoPlayer @Inject constructor(
    private val context: Context,
    private val player: IPlayer,
    private val ima: IIma?,
    private val controllerAgent: ControllerAgent,
) {

    private var currentEvent: MCLSEvent? = null

    lateinit var mMlsTvFragment: MCLSTVFragment

    var mlsTVConfiguration: MCLSTVConfiguration = MCLSTVConfiguration()

    /**region Fields*/
    private lateinit var leanbackAdapter: LeanbackPlayerAdapter
    private lateinit var glueHost: VideoSupportFragmentGlueHost
    private lateinit var mTransportControlGlue: MCLSPlaybackTransportControlGlueImpl<LeanbackPlayerAdapter>
    private lateinit var eventInfoContainerLayout: FrameLayout
    private val dialogs = ArrayList<View>()

    private lateinit var overlayContainer: ConstraintLayout

    /**endregion */

    /**
     * Indicates if SDK user desires to have analytics enabled
     */
    private var hasAnalytic = false

    private var playerReady = false

    /**region Initializing*/
    fun initialize(mlsTvFragment: MCLSTVFragment) {
        this.mMlsTvFragment = mlsTvFragment

        // Initializers for Other Components
        val adViewProvider = addAdViewProvider(mMlsTvFragment.uiBinding.fragmentRoot)

        val currentExoPlayer =
            player.getDirectInstance() ?: throw IllegalStateException("Player was not set?!!")

        // IMA
        ima?.prepare(
            mMlsTvFragment.requireContext(),
            adViewProvider,
            currentExoPlayer
        )
        ima?.let {
            player.create(ima)
        }


        // Configurations
        currentExoPlayer.playWhenReady = mlsTVConfiguration.videoPlayerConfig.autoPlay
        leanbackAdapter = LeanbackPlayerAdapter(context, currentExoPlayer, 1000)

        glueHost = VideoSupportFragmentGlueHost(mMlsTvFragment.videoSupportFragment)

        Timber.d("initialize: Attached VideoSupportFragmentGlueHost and leanbackAdapter")

        // Buffer Progress Bar
        val bufferProgressBar = addProgressBar()

        player.getPlayer()?.let {
            controllerAgent.setBufferProgressBar(bufferProgressBar)
        }

        mTransportControlGlue = MCLSPlaybackTransportControlGlueImpl(
            context,
            leanbackAdapter,
            mlsTVConfiguration,
            controllerAgent
        )
        mTransportControlGlue.host = glueHost
        mTransportControlGlue.playWhenPrepared()

        if (mTransportControlGlue.isPrepared) {
            mTransportControlGlue.setSeekProvider(MLSPlaybackSeekDataProvider(5000L))
        } else {
            mTransportControlGlue.addPlayerCallback(object : PlaybackGlue.PlayerCallback() {
                override fun onPreparedStateChanged(glue: PlaybackGlue) {
                    if (glue.isPrepared) {
                        glue.removePlayerCallback(this)
                        val transportControlGlue =
                            glue as MCLSPlaybackTransportControlGlueImpl<*>
                        transportControlGlue.setSeekProvider(MLSPlaybackSeekDataProvider(5000L))
                    }
                }
            })
        }

        this.player.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                logEventIfNeeded()

                if (playbackState == ExoPlayer.STATE_READY) {
                    mTransportControlGlue.getSeekProvider()?.let {
                        (it as MLSPlaybackSeekDataProvider).setSeekPositions(player.duration())
                    }
                }

                if (player.isLive()) {
                    if (player.currentPosition() + 20000L >= player.duration()) {
                        controllerAgent.setControllerLiveMode(LiveState.LIVE_ON_THE_EDGE)
                    } else {
                        controllerAgent.setControllerLiveMode(LiveState.LIVE_TRAILING)
                    }
                } else {
                    // VOD
                    controllerAgent.setControllerLiveMode(LiveState.VOD)
                }

            }
        })

        if (mMlsTvFragment.view == null) {
            throw IllegalArgumentException("Fragment must be supported in a state which has active view!")
        } else {
            val rootView = mMlsTvFragment.uiBinding.fragmentRoot

            overlayContainer = ConstraintLayout(rootView.context)
            rootView.addView(
                overlayContainer,
                2,
                FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            )

            eventInfoContainerLayout = FrameLayout(rootView.context)
            rootView.addView(
                eventInfoContainerLayout,
                1,
                FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)
            )
        }

        playerReady = true
        playPendingEvent()
    }

    private fun addProgressBar(): ProgressBar {
        val bufferProgressBar = ProgressBar(context)
        bufferProgressBar.indeterminateDrawable.setTint(Color.parseColor(mlsTVConfiguration.videoPlayerConfig.primaryColor))
        val layoutParams = FrameLayout.LayoutParams(120, 120)
        layoutParams.gravity = Gravity.CENTER
        bufferProgressBar.visibility = View.GONE
        mMlsTvFragment.uiBinding.fragmentRoot.addView(bufferProgressBar, layoutParams)

        return bufferProgressBar
    }

    private fun addAdViewProvider(fragmentView: FrameLayout): AdViewProvider {
        val frameLayout = FrameLayout(fragmentView.context)
        fragmentView.addView(frameLayout, 0)
        return AdViewProvider { frameLayout }
    }

    /**
     * Log event through Youbora client.
     * Log should take place if only analytics is enabled in configuration and should only happen once per stream
     */
    private fun logEventIfNeeded() {
        if (!hasAnalytic) {
            return
        }
    }

    /**endregion */
    fun getPlayerDirectInstance(): ExoPlayer? {
        return player.getDirectInstance()
    }

    /**region Playback*/
    fun playVideo(event: MCLSEvent) {
        currentEvent = event

        if (playerReady) {
            playVideoOrDisplayEventInfo(event)
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                playVideo(event)
            }, 100)
        }
    }

    private fun playPendingEvent() {
        currentEvent?.let {
            playVideo(it)
        }
    }

    private fun playVideoOrDisplayEventInfo(event: MCLSEvent) {

        when (event.streamStatus()) {
            StreamStatus.NO_STREAM_URL -> {
                player.pause()
                displayPreEventInformationLayout()
            }
            StreamStatus.PLAYABLE -> {
                logEventIfNeeded()

                play(event.streams.first())
                eventInfoContainerLayout.visibility = View.GONE
                hideInfoDialogs()
            }
            StreamStatus.GEOBLOCKED -> {
                player.pause()
                showCustomInformationDialog(context.getString(R.string.message_geoblocked_stream))
            }
            StreamStatus.NO_ENTITLEMENT -> {
                player.pause()
                showCustomInformationDialog(context.getString(R.string.message_no_entitlement_stream))
            }
            StreamStatus.UNKNOWN_ERROR -> {
                player.pause()
                displayPreEventInformationLayout()
            }
        }
    }

    private fun play(stream: MCLSStream) {
        val wvFullUrl = stream.widevine?.fullUrl
        val wvLicenceUrl = stream.widevine?.licenseUrl
        val fullUrl = stream.fullUrl
        if (wvFullUrl != null && wvLicenceUrl != null) {
            player.play(
                MediaDatum.DRMMediaData(
                    fullUrl = wvFullUrl,
                    dvrWindowSize = stream.getDvrWindowSize(),
                    licenseUrl = wvLicenceUrl,
                    autoPlay = true
                )
            )
        } else if (fullUrl != null) {
            player.play(
                MediaDatum.MediaData(
                    fullUrl = fullUrl,
                    dvrWindowSize = stream.getDvrWindowSize(),
                    autoPlay = true
                )
            )
        }
    }

    /**
     * Release resources & leave Reactor service
     */
    fun release() {
        player.release()
    }
    /**endregion */

    /**region Event-information layout*/
    private fun showCustomInformationDialog(message: String) {
        glueHost.hideControlsOverlay(true)
        eventInfoContainerLayout.visibility = View.VISIBLE

        inflateCustomInformationDialog(
            container = eventInfoContainerLayout,
            title = currentEvent?.title.orEmpty(),
            message = message
        )
    }


    private fun displayPreEventInformationLayout() {
        glueHost.hideControlsOverlay(true)
        eventInfoContainerLayout.visibility = View.VISIBLE

        inflatePreEventInformationDialog(
            container = eventInfoContainerLayout,
            title = currentEvent?.title.orEmpty(),
            description = currentEvent?.description.orEmpty(),
            startTime = currentEvent?.getFormattedStartTimeDate(Locale.getDefault()).orEmpty(),
            posterUrl = currentEvent?.poster_url
        )
    }

    private fun hideInfoDialogs() {
        dialogs.forEach { dialog ->
            eventInfoContainerLayout.removeView(dialog)
        }
        dialogs.clear()
    }

    /**endregion */
}
