package tv.mycujoo.mclscast.widget

import android.content.Context
import android.content.ContextWrapper
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
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.mediarouter.app.MediaRouteButton
import com.google.android.exoplayer2.ui.TimeBar
import com.google.android.gms.cast.framework.CastButtonFactory
import com.google.android.gms.cast.framework.CastContext
import kotlinx.coroutines.*
import timber.log.Timber
import tv.mycujoo.mclscast.MCLSCast
import tv.mycujoo.mclscast.R
import tv.mycujoo.mclscast.databinding.ViewRemotePlayerControllerBinding
import tv.mycujoo.mclscast.player.RemotePlayer
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclsplayercore.entity.LiveState
import tv.mycujoo.mclsplayercore.helper.StringUtils
import tv.mycujoo.mclsplayercore.widget.LiveBadgeView
import tv.mycujoo.mclsplayercore.widget.MCLSTimeBar
import java.util.*
import java.util.concurrent.Executors
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

class RemotePlayerView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), IRemotePlayerView {


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

    /**endregion */

    private var cast: MCLSCast? = null

    private val binding: ViewRemotePlayerControllerBinding

    private var publicKey: String
    private var castAppId: String
    private var castButton = MediaRouteButton(context)

    /**region Initializing*/
    init {
        val inflater = LayoutInflater.from(context)
        binding = ViewRemotePlayerControllerBinding.inflate(inflater, this, true)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.RemotePlayerView)
        publicKey = typedArray.getString(R.styleable.RemotePlayerView_publicKey) ?: ""
        castAppId = typedArray.getString(R.styleable.RemotePlayerView_castAppId) ?: ""

        binding.remoteControllerTopRightContainerHolder.addView(castButton)

        CastButtonFactory.setUpMediaRouteButton(context, castButton)

        typedArray.recycle()

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

        initButtonsListener()
        initTimeBarListener()


        liveBadgeView = findViewById(R.id.remoteControllerLiveBadgeView)

        CastContext.getSharedInstance(context, Executors.newSingleThreadExecutor())
            .addOnSuccessListener { castContext ->
                cast = MCLSCast.Builder()
                    .withAppId(castAppId)
                    .withMediaButton(castButton)
                    .withPublicKey(publicKey)
                    .withCastContext(castContext)
                    .build()

                cast?.let {
                    getLifecycle()?.addObserver(it)
                    player = it.remotePlayer
                }
            }
    }

    var inViewTree = false
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        inViewTree = true

        ticker {
            Timber.d("Tick!")
            syncPlayerView()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()

        inViewTree = false
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

    fun playEvent(event: EventEntity) {
        cast?.playEvent(event)
    }

    private fun syncPlayerView() {
        Timber.d("$player")
        player?.currentPosition()?.let {
            setPosition(it)
        }

        player?.streamDuration()?.let {
            setDuration(it)
        }

        player?.isPlaying()?.let {
            setPlayStatus(it, false)
        }
    }

    private fun ticker(
        delay: Duration = 1.seconds,
        dispatcher: CoroutineDispatcher = Dispatchers.Main,
        onTick: () -> Unit
    ) {
        CoroutineScope(dispatcher).launch {
            onTick()
            delay(delay)
            if (inViewTree) {
                ticker(delay, dispatcher, onTick)
            }
        }
    }

    private fun initButtonsListener() {
        playButton.setOnClickListener { player?.play() }
        pauseButton.setOnClickListener { player?.pause() }

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

    fun addViewToTopRightHolder(view: ViewGroup) {
        topRightContainerHolder.removeAllViews()
        topRightContainerHolder.addView(view)
        topRightContainerHolder.isVisible = true
    }

    fun removeViewFromTopRightHolder(): View? {
        val view = topRightContainerHolder.getChildAt(0)
        topRightContainerHolder.removeAllViews()
        return view
    }

    fun addViewToTopLeftHolder(view: ViewGroup) {
        topLeftContainerHolder.removeAllViews()
        topLeftContainerHolder.addView(view)
        topLeftContainerHolder.isVisible = true
    }

    fun removeViewFromTopLeftHolder(): View? {
        val view = topLeftContainerHolder.getChildAt(0)
        topLeftContainerHolder.removeAllViews()
        return view
    }


    /**endregion */

    override fun attachPlayer(player: RemotePlayer) {
        this.player = player
    }
}