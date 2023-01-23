package tv.mycujoo.mclscast.widget

import android.content.Context
import android.content.ContextWrapper
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.annotation.ColorInt
import androidx.core.view.children
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.ui.TimeBar
import tv.mycujoo.mclscast.MCLSCast
import tv.mycujoo.mclscast.R
import tv.mycujoo.mclscast.config.CastPlayerConfig
import tv.mycujoo.mclscast.databinding.ViewRemotePlayerControllerBinding
import tv.mycujoo.mclscast.player.RemotePlayer
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclscore.logger.MessageLevel
import tv.mycujoo.mclsplayercore.dialog.inflateCustomInformationDialog
import tv.mycujoo.mclsplayercore.dialog.inflatePreEventInformationDialog
import tv.mycujoo.mclsplayercore.dialog.inflateStartedEventInformationDialog
import tv.mycujoo.mclsplayercore.entity.LiveState
import tv.mycujoo.mclsplayercore.helper.StringUtils
import tv.mycujoo.mclsplayercore.model.UiEvent
import tv.mycujoo.mclsplayercore.widget.LiveBadgeView
import tv.mycujoo.mclsplayercore.widget.MCLSTimeBar
import java.util.*

class RemotePlayerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), IRemotePlayerView {

    private var uiEvent = UiEvent()

    /**region Fields*/
    private var player: RemotePlayer? = null
    private val bufferingProgressBar: ProgressBar
    private val playButtonContainer: FrameLayout
    private val playButton: ImageButton
    private val pauseButton: ImageButton
    private val fastForwardContainer: FrameLayout
    private val fastForwardButton: ImageButton
    private val rewindContainer: FrameLayout
    private val rewindButton: ImageButton
    private val timeBar: MCLSTimeBar
    private val currentPositionTextView: TextView
    private val durationTextView: TextView

    private val liveBadgeView: LiveBadgeView

    private val topRightContainerHolder: FrameLayout
    private val topLeftContainerHolder: FrameLayout

    private var timeFormatBuilder = StringBuilder()
    private var timeFormatter = Formatter(timeFormatBuilder, Locale.getDefault())

    private var infoButton: ImageButton
    private var infoButtonLayout: LinearLayout

    /**endregion */

    private var cast: MCLSCast? = null

    private val binding: ViewRemotePlayerControllerBinding

    var logger = Logger(logLevel = LogLevel.MINIMAL)

    /**region Initializing*/
    init {
        val inflater = LayoutInflater.from(context)
        binding = ViewRemotePlayerControllerBinding.inflate(inflater, this, true)

        bufferingProgressBar = binding.remoteControllerBufferingProgressBar
        playButtonContainer = binding.remoteControllerPlayPauseButtonContainerLayout
        playButton = binding.remoteControllerPlay
        pauseButton = binding.remoteControllerPause
        fastForwardContainer = binding.remoteControllerFastForwardButtonContainerLayout
        fastForwardButton = binding.remoteControllerFastForwardButton
        rewindContainer = binding.remoteControllerRewButtonContainerLayout
        rewindButton = binding.remoteControllerRewindButton
        timeBar = binding.timeBar
        currentPositionTextView = binding.remoteControllerCurrentPositionTextView
        durationTextView = binding.remoteControllerDurationTextView
        topRightContainerHolder = binding.remoteControllerTopRightContainerHolder
        topLeftContainerHolder = binding.remoteControllerTopLeftContainerHolder
        infoButton = binding.controllerInformationButton
        infoButtonLayout = binding.controllerInformationButtonLayout

        initButtonsListener()
        initTimeBarListener()


        liveBadgeView = findViewById(R.id.remoteControllerLiveBadgeView)
    }

    private var inViewTree = false
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        inViewTree = true
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        inViewTree = false

        cast = null
    }

    internal fun setLogger(logger: Logger) {
        this.logger = logger
    }

    override fun showPreEventInformationDialog() {
        post {
            hideController()

            inflatePreEventInformationDialog(
                container = binding.infoDialogContainerLayout,
                uiEvent = uiEvent
            )
        }
    }

    override fun showCustomInformationDialog(message: String) {
        post {
            hideController()

            inflateCustomInformationDialog(
                container = binding.infoDialogContainerLayout,
                uiEvent = uiEvent,
                message = message
            )
        }
    }

    private fun hideController() {
        binding.remoteControllerPlayPauseButtonContainerLayout.visibility = INVISIBLE
        binding.remoteControllerFastForwardButtonContainerLayout.visibility = INVISIBLE
        binding.remoteControllerRewButtonContainerLayout.visibility = INVISIBLE
    }

    private fun showController() {
        binding.remoteControllerPlayPauseButtonContainerLayout.visibility = VISIBLE
        binding.remoteControllerFastForwardButtonContainerLayout.visibility = VISIBLE
        binding.remoteControllerRewButtonContainerLayout.visibility = VISIBLE
    }

    private fun getLifecycle(): Lifecycle? {
        var context = context
        while (context is ContextWrapper) {
            if (context is LifecycleOwner) {
                return context.lifecycle
            }
            context = context.baseContext
        }
        return null
    }

    override fun setEventInfo(title: String, description: String?, startTime: String?) {
        uiEvent = UiEvent(title, description, startTime)
    }

    private fun initButtonsListener() {
        playButton.setOnClickListener { player?.play() }
        pauseButton.setOnClickListener { player?.pause() }

        infoButton.setOnClickListener {
            showStartedEventInformationDialog()
        }

        infoButtonLayout.setOnClickListener {
            showStartedEventInformationDialog()
        }

        val fastForward = { player?.fastForward(10000L) }
        fastForwardContainer.setOnClickListener { fastForward.invoke() }
        fastForwardButton.setOnClickListener { fastForward.invoke() }

        val rewind = { player?.rewind(10000L) }
        rewindContainer.setOnClickListener { rewind.invoke() }
        rewindButton.setOnClickListener { rewind.invoke() }
    }

    private fun initTimeBarListener() {
        timeBar.addListener(object : TimeBar.OnScrubListener {
            override fun onScrubStart(timeBar: TimeBar, position: Long) {
            }

            override fun onScrubMove(timeBar: TimeBar, position: Long) {
            }

            override fun onScrubStop(timeBar: TimeBar, position: Long, canceled: Boolean) {
                player?.seekTo(position)
            }
        })
    }

    /**region Controls*/
    override fun setPlayStatus(isPlaying: Boolean, isBuffering: Boolean?) {
        when (isBuffering) {
            true -> {
                bufferingProgressBar.visibility = View.VISIBLE
            }
            else -> {
                bufferingProgressBar.visibility = View.GONE
            }
        }

        when (isPlaying) {
            true -> {
                playButton.visibility = View.GONE
                pauseButton.visibility = View.VISIBLE
            }
            false -> {
                if (isBuffering == true) {
                    return
                }
                playButton.visibility = View.VISIBLE
                pauseButton.visibility = View.GONE
            }
        }
    }

    override fun setDuration(duration: Long) {
        timeBar.setDuration(duration)
        durationTextView.text =
            StringUtils.getFormattedTime(duration, timeFormatBuilder, timeFormatter)
    }

    override fun setPosition(position: Long) {
        timeBar.setPosition(position)
        currentPositionTextView.text =
            StringUtils.getFormattedTime(position, timeFormatBuilder, timeFormatter)

    }

    override fun setTimeBarPlayedColor(@ColorInt color: Int) {
        timeBar.setPlayedColor(color)
    }

    override fun setPlayerMainButtonsColor(@ColorInt color: Int) {
        playButton.setColorFilter(
            color,
            PorterDuff.Mode.SRC_ATOP
        )
        pauseButton.setColorFilter(
            color,
            PorterDuff.Mode.SRC_ATOP
        )
        fastForwardButton.setColorFilter(
            color,
            PorterDuff.Mode.SRC_ATOP
        )
        rewindButton.setColorFilter(
            color,
            PorterDuff.Mode.SRC_ATOP
        )
    }

    override fun setLiveMode(liveState: LiveState) {
        liveBadgeView.setLiveMode(liveState)
    }

    override fun setBufferingProgressBarsColor(@ColorInt color: Int) {
        bufferingProgressBar.indeterminateTintList = ColorStateList.valueOf(color)
    }

    /**
     * Set exo-player time-bar & remote-player timer-bar played-color
     */
    private fun setTimeBarsColor(primaryColor: Int) {
        timeBar.setPlayedColor(primaryColor)
    }

    private fun showStartedEventInformationDialog() {
        // Calling the Constructor actually inflates this view.
        // Dialogs are just references for the removal process
        val dialog = inflateStartedEventInformationDialog(
            parent = binding.infoDialogContainerLayout,
            uiEvent = uiEvent,
        )

        dialog.setOnClickListener {
            hideInfoDialogs()
        }
    }

    private fun hideInfoDialogs() {
        post {
            logger.log(MessageLevel.INFO, "hideInfoDialogs")
            binding.infoDialogContainerLayout.children.forEach { dialog ->
                logger.log(MessageLevel.INFO, "Dialog $dialog")
                binding.infoDialogContainerLayout.removeView(dialog)
            }
        }
    }

    override fun config(config: CastPlayerConfig) {
        try {
            val primaryColor = Color.parseColor(config.primaryColor)
            val secondaryColor = Color.parseColor(config.secondaryColor)

            setTimeBarsColor(secondaryColor)
            setBufferingProgressBarsColor(primaryColor)
            setPlayerMainButtonsColor(primaryColor)

            // enableControls has the highest priority
            showBackForwardsButtons(config.showBackForwardsButtons)
            showSeekBar(config.showSeekBar)
            showTimers(config.showTimers)
            if (config.showEventInfoButton) {
                showEventInfoButton()
            } else {
                hideEventInfoButton()
            }

        } catch (e: Exception) {
            logger.log(MessageLevel.ERROR, e.message ?: "Error in configuring")
        }
    }

    private fun showEventInfoButton() {
        post {
            showEventInfoButtonInstantly()
        }
    }

    private fun hideEventInfoButton() {
        post {
            hideEventInfoButtonInstantly()
        }
    }

    private fun showEventInfoButtonInstantly() {
        post {
            binding.controllerInformationButtonLayout.visibility = View.VISIBLE
        }
    }

    private fun hideEventInfoButtonInstantly() {
        post {
            binding.controllerInformationButtonLayout.visibility = View.GONE
        }
    }

    private fun showTimers(showTimers: Boolean) {
        if (showTimers) {
            binding.remoteControllerTimersContainer.visibility = VISIBLE
        } else {
            binding.remoteControllerTimersContainer.visibility = View.GONE
        }
    }

    private fun showSeekBar(showSeekBar: Boolean) {
        binding.timeBar.visibility = if (showSeekBar) {
            VISIBLE
        } else {
            View.GONE
        }
    }

    private fun showBackForwardsButtons(showBackForwardsButtons: Boolean) {
        if (showBackForwardsButtons) {
            binding.remoteControllerRewButtonContainerLayout.visibility = VISIBLE
            binding.remoteControllerFastForwardButtonContainerLayout.visibility = VISIBLE
        } else {
            binding.remoteControllerRewButtonContainerLayout.visibility = View.GONE
            binding.remoteControllerFastForwardButtonContainerLayout.visibility = View.GONE
        }
    }


    /**endregion */

    override fun attachPlayer(player: RemotePlayer) {
        this.player = player
    }
}