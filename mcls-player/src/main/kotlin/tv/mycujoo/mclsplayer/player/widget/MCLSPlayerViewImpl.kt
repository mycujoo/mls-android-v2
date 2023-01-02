package tv.mycujoo.mclsplayer.player.widget

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ProgressBar
import androidx.annotation.MainThread
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.google.android.exoplayer2.ui.TimeBar
import com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
import timber.log.Timber
import tv.mycujoo.mclsplayer.R
import tv.mycujoo.mclsplayer.databinding.MclsPlayerViewBinding
import tv.mycujoo.mclsplayer.player.config.VideoPlayerConfig
import tv.mycujoo.mclsplayer.player.entity.LiveState
import tv.mycujoo.mclsplayer.player.model.UiEvent
import tv.mycujoo.mclsplayer.player.player.Player

class MCLSPlayerViewImpl @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), MCLSPlayerView {

    private var binding: MclsPlayerViewBinding
    private var uiEvent = UiEvent()

    private val dialogs = ArrayList<View>()

    private var enableControls = true

    private val bufferingProgressBar: ProgressBar
    private val remotePlayerControllerView: RemotePlayerControllerView
    private val timeBar: MCLSTimeBar
    private val liveBadge: LiveBadgeView
    private val mlsTimeBar: MCLSTimeBar
    private val fullScreenButton: ImageButton
    private var onFullScreenClicked: (() -> Unit)? = null

    private lateinit var currentPlayer: Player

    private var isEventLive = false

    init {
        val inflater = LayoutInflater.from(context)
        binding = MclsPlayerViewBinding.inflate(inflater, this, true)

        bufferingProgressBar = findViewById(R.id.controller_buffering)
        remotePlayerControllerView = findViewById(R.id.remotePlayerControllerView)
        timeBar = findViewById(R.id.timeBar)
        liveBadge = findViewById(R.id.controller_liveBadgeView)
        mlsTimeBar = findViewById(R.id.exo_progress)
        fullScreenButton = findViewById(R.id.controller_fullscreenImageButton)

        setScrubListener()
        setOnClickListeners()
    }

    override fun setEventInfo(title: String, description: String?, startTime: String?) {
        uiEvent = UiEvent(title, description, startTime)
    }

    override fun setPlayer(player: Player) {
        currentPlayer = player
        binding.styledPlayerView.player = player.getExoPlayerInstance()
    }

    override fun setOnFullScreenClicked(onFullScreenClicked: (() -> Unit)?) {
        this.onFullScreenClicked = onFullScreenClicked
    }

    override fun setPosterInfo(posterUrl: String?) {
        uiEvent = uiEvent.copy(posterUrl = posterUrl)
    }

    override fun showEventInfoButton() {
        post {
            showEventInfoButtonInstantly()
        }
    }

    override fun setLive(isLive: Boolean) {
        liveBadge.isVisible = isLive
        isEventLive = isLive
    }

    @MainThread
    fun showEventInfoButtonInstantly() {
        findViewById<LinearLayout>(R.id.controller_informationButtonLayout).visibility =
            View.VISIBLE
    }

    override fun hideEventInfoButton() {
        post { hideEventInfoButtonInstantly() }
    }

    @MainThread
    fun hideEventInfoButtonInstantly() {
        post {
            findViewById<LinearLayout>(R.id.controller_informationButtonLayout).visibility =
                View.GONE
        }
    }

    override fun showPreEventInformationDialog() {
        post {
            binding.styledPlayerView.hideController()

            val dialog = PreEventInformationDialog(
                container = binding.infoDialogContainerLayout,
                uiEvent = uiEvent
            )
            dialogs.add(dialog)
        }
    }

    override fun updateControllerVisibility(isPlaying: Boolean) {
        if (enableControls && isPlaying) {
            controllerVisibility(true)
            binding.styledPlayerView.showController()
        } else {
            controllerVisibility(false)
            binding.styledPlayerView.hideController()
        }
    }

    override fun hideInfoDialogs() {
        post {
            dialogs.forEach { dialog ->
                binding.infoDialogContainerLayout.removeView(dialog)
            }
            dialogs.clear()
        }
    }

    override fun showCustomInformationDialog(message: String) {
        post {
            binding.styledPlayerView.hideController()

            val dialog = CustomInformationDialog(
                container = binding.infoDialogContainerLayout,
                uiEvent = uiEvent,
                message = message
            )
            dialogs.add(dialog)
        }
    }

    override fun config(config: VideoPlayerConfig) {
        try {
            val primaryColor = Color.parseColor(config.primaryColor)
            val secondaryColor = Color.parseColor(config.secondaryColor)

            setTimeBarsColor(secondaryColor)
            setTimelineMarkerColor(config)
            setBufferingProgressBarsColor(primaryColor)
            setPlayerMainButtonsColor(primaryColor)

            // enableControls has the highest priority
            enableControls = config.enableControls

            if (!enableControls) {
                showBackForwardsButtons(false)
                showSeekBar(false)
                showFullScreenButton(false)
                showTimers(false)
                hideEventInfoButton()
                controllerVisibility(false)
            } else {
                showBackForwardsButtons(config.showBackForwardsButtons)
                showSeekBar(config.showSeekBar)
                showFullScreenButton(config.showFullScreenButton)
                showTimers(config.showTimers)
                if (config.showEventInfoButton) {
                    showEventInfoButton()
                } else {
                    hideEventInfoButton()
                }
                controllerVisibility(true)

                binding.styledPlayerView.player?.playWhenReady = config.autoPlay
                binding.styledPlayerView.showController()
            }

        } catch (e: Exception) {
            Timber.e(e.message ?: "Error in configuring")
        }
    }

    /**
     * Set exo-player & remote-player buffering progress-bar color
     */
    private fun setBufferingProgressBarsColor(primaryColor: Int) {
        bufferingProgressBar.indeterminateTintList = ColorStateList.valueOf(primaryColor)
        remotePlayerControllerView.setBufferingProgressBarsColor(primaryColor)
    }

    /**
     * Set exo-player & remote-player main buttons [Play, Pause, Fast-Forward & Rewind] color
     */
    private fun setPlayerMainButtonsColor(primaryColor: Int) {
        findViewById<ImageButton>(R.id.exo_play_pause).setColorFilter(
            primaryColor,
            PorterDuff.Mode.SRC_ATOP
        )

        findViewById<ImageButton>(R.id.exo_rew).setColorFilter(
            primaryColor,
            PorterDuff.Mode.SRC_ATOP
        )
        findViewById<ImageButton>(R.id.exo_ffwd).setColorFilter(
            primaryColor,
            PorterDuff.Mode.SRC_ATOP
        )

        remotePlayerControllerView.setPlayerMainButtonsColor(primaryColor)
    }

    override fun setInFullScreen(inFullScreen: Boolean) {
        if (inFullScreen) {
            fullScreenButton.setImageResource(R.drawable.ic_fullscreen_exit_24dp)
        } else {
            fullScreenButton.setImageResource(R.drawable.ic_fullscreen_24dp)
        }
    }

    private fun setOnClickListeners() {
        fullScreenButton.setOnClickListener {
            onFullScreenClicked?.invoke()
        }
    }

    private fun setScrubListener() {
        mlsTimeBar.addListener(object : OnScrubListener {
            override fun onScrubStart(timeBar: TimeBar, position: Long) {

            }

            override fun onScrubMove(timeBar: TimeBar, position: Long) {

            }

            override fun onScrubStop(timeBar: TimeBar, position: Long, canceled: Boolean) {
//                timelineMarkerActionEntities.firstOrNull { position in it.offset - 10000L..it.offset + 10000L }
//                    ?.let {
//                        player.seekTo(it.offset)
//                    }

                if (isEventLive) {
                    if (currentPlayer.currentPosition() + 20000L >= currentPlayer.duration()) {
                        liveBadge.setLiveMode(LiveState.LIVE_ON_THE_EDGE)
                    } else {
                        liveBadge.setLiveMode(LiveState.LIVE_TRAILING)
                    }
                } else {
                    // VOD
                    liveBadge.setLiveMode(LiveState.VOD)
                }
            }
        })
    }

    private fun showBackForwardsButtons(showBackForwardsButtons: Boolean) {
        if (showBackForwardsButtons) {
            findViewById<ImageButton>(R.id.exo_rew).visibility = VISIBLE
            findViewById<ImageButton>(R.id.exo_ffwd).visibility = VISIBLE
        } else {
            findViewById<ImageButton>(R.id.exo_rew).visibility = View.GONE
            findViewById<ImageButton>(R.id.exo_ffwd).visibility = View.GONE
        }
    }

    private fun controllerVisibility(isVisible: Boolean) {
        showControlsContainer(isVisible)
        binding.styledPlayerView.controllerAutoShow = isVisible
        binding.styledPlayerView.useController = isVisible
    }

    private fun showControlsContainer(show: Boolean) {
        if (show) {
            findViewById<ConstraintLayout>(R.id.controlsLayoutContainer).visibility =
                VISIBLE
        } else {
            findViewById<ConstraintLayout>(R.id.controlsLayoutContainer).visibility =
                GONE
        }

    }

    private fun showFullScreenButton(showFullScreenButton: Boolean) {
        if (showFullScreenButton) {
            findViewById<FrameLayout>(R.id.controller_fullscreenImageButton).visibility =
                VISIBLE
        } else {
            findViewById<FrameLayout>(R.id.controller_fullscreenImageButton).visibility =
                View.GONE
        }
    }

    private fun showSeekBar(showSeekBar: Boolean) {
        if (showSeekBar) {
            findViewById<FrameLayout>(R.id.controller_timeBarLayoutContainer).visibility =
                VISIBLE
        } else {
            findViewById<FrameLayout>(R.id.controller_timeBarLayoutContainer).visibility =
                View.GONE
        }
    }

    private fun showTimers(showTimers: Boolean) {
        if (showTimers) {
            findViewById<ConstraintLayout>(R.id.controller_timersContainer).visibility =
                VISIBLE
        } else {
            findViewById<ConstraintLayout>(R.id.controller_timersContainer).visibility =
                View.GONE
        }
    }

    private fun setTimelineMarkerColor(config: VideoPlayerConfig) {
        val timelineMarkerView =
            findViewById<TimelineMarkerView>(R.id.exo_styled_controls_timelineMarkerView)
        timelineMarkerView.initialize(config.secondaryColor)
    }

    /**
     * Set exo-player time-bar & remote-player timer-bar played-color
     */
    private fun setTimeBarsColor(primaryColor: Int) {
        mlsTimeBar.setPlayedColor(primaryColor)
        remotePlayerControllerView.setTimeBarPlayedColor(primaryColor)
    }
}