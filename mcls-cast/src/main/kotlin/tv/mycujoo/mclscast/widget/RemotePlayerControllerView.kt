package tv.mycujoo.mclscast.widget

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.view.isVisible
import tv.mycujoo.mclscast.R
import tv.mycujoo.mclsplayercore.entity.LiveState
import tv.mycujoo.mclsplayercore.helper.StringUtils
import tv.mycujoo.mclsplayercore.widget.LiveBadgeView
import tv.mycujoo.mclsplayercore.widget.MCLSTimeBar
import java.util.*

class RemotePlayerControllerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {


    /**region Fields*/
    var listener: RemotePlayerControllerListener? = null
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
    /**endregion */


    /**region Initializing*/
    init {
        LayoutInflater.from(context).inflate(R.layout.view_remote_player_controller, this, true)
        bufferingProgressBar = findViewById(R.id.remoteControllerBufferingProgressBar)
        playButtonContainer = findViewById(R.id.remoteControllerPlayPauseButtonContainerLayout)
        playButton = findViewById(R.id.remoteControllerPlay)
        pauseButton = findViewById(R.id.remoteControllerPause)
        fastForwardContainer = findViewById(R.id.remoteControllerFastForwardButtonContainerLayout)
        fastForwardButton = findViewById(R.id.remoteControllerFastForwardButton)
        rewindContainer = findViewById(R.id.remoteControllerRewButtonContainerLayout)
        rewindButton = findViewById(R.id.remoteControllerRewindButton)
        timeBar = findViewById(R.id.timeBar)
        currentPositionTextView = findViewById(R.id.remoteControllerCurrentPositionTextView)
        durationTextView = findViewById(R.id.remoteControllerDurationTextView)
        topRightContainerHolder = findViewById(R.id.remoteController_topRightContainerHolder)
        topLeftContainerHolder = findViewById(R.id.remoteController_topLeftContainerHolder)
        initButtonsListener()
        initTimeBarListener()


        liveBadgeView = findViewById(R.id.remoteControllerLiveBadgeView)
    }

    private fun initButtonsListener() {
        playButton.setOnClickListener { listener?.onPlay() }
        pauseButton.setOnClickListener { listener?.onPause() }

        val fastForward = { listener?.onFastForward(10000L) }
        fastForwardContainer.setOnClickListener { fastForward.invoke() }
        fastForwardButton.setOnClickListener { fastForward.invoke() }

        val rewind = { listener?.onSeekTo(-10000L) }
        rewindContainer.setOnClickListener { rewind.invoke() }
        rewindButton.setOnClickListener { rewind.invoke() }
    }

    private fun initTimeBarListener() {
//        timeBar.addListener(object : TimeBar.OnScrubListener {
//            override fun onScrubStart(timeBar: TimeBar, position: Long) {
//            }
//
//            override fun onScrubMove(timeBar: TimeBar, position: Long) {
//            }
//
//            override fun onScrubStop(timeBar: TimeBar, position: Long, canceled: Boolean) {
//                listener?.onSeekTo(position)
//            }
//        })
    }

    /**region Controls*/
    fun setPlayStatus(isPlaying: Boolean, isBuffering: Boolean? = null) {
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

    fun setDuration(duration: Long) {
        timeBar.setDuration(duration)
        durationTextView.text =
            StringUtils.getFormattedTime(duration, timeFormatBuilder, timeFormatter)
    }

    fun setPosition(position: Long) {
        timeBar.setPosition(position)
        currentPositionTextView.text =
            StringUtils.getFormattedTime(position, timeFormatBuilder, timeFormatter)

    }

    fun setTimeBarPlayedColor(@ColorInt color: Int) {
        timeBar.setPlayedColor(color)
    }

    fun setPlayerMainButtonsColor(@ColorInt color: Int) {
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

    fun setLiveMode(liveState: LiveState) {
        liveBadgeView.setLiveMode(liveState)
    }

    fun setBufferingProgressBarsColor(@ColorInt color: Int) {
        bufferingProgressBar.indeterminateTintList = ColorStateList.valueOf(color)
    }

    fun addViewToTopRightHolder(view: ViewGroup) {
        topRightContainerHolder.removeAllViews()
        topRightContainerHolder.addView(view)
        topRightContainerHolder.isVisible = true
    }

    fun removeViewFromTopRightHolder() : View? {
        val view = topRightContainerHolder.getChildAt(0)
        topRightContainerHolder.removeAllViews()
        return view
    }

    fun addViewToTopLeftHolder(view: ViewGroup) {
        topLeftContainerHolder.removeAllViews()
        topLeftContainerHolder.addView(view)
        topLeftContainerHolder.isVisible = true
    }

    fun removeViewFromTopLeftHolder() : View? {
        val view = topLeftContainerHolder.getChildAt(0)
        topLeftContainerHolder.removeAllViews()
        return view
    }


    /**endregion */
}