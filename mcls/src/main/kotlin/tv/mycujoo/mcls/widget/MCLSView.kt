package tv.mycujoo.mcls.widget

import android.content.Context
import android.content.ContextWrapper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import com.google.android.exoplayer2.Player.Listener
import com.google.android.exoplayer2.Player.STATE_READY
import kotlinx.coroutines.*
import timber.log.Timber
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.widget.AnnotationView
import tv.mycujoo.mclscast.MCLSCast
import tv.mycujoo.mclscast.manager.CastApplicationListener
import tv.mycujoo.mclscast.manager.CastSessionListener
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.helper.valueOrNull
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.model.MCLSResult
import tv.mycujoo.mclsnetwork.MCLSNetwork
import tv.mycujoo.mclsplayer.player.MCLSPlayer
import tv.mycujoo.mls.R
import tv.mycujoo.mls.databinding.ViewMlsBinding
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class MCLSView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), DefaultLifecycleObserver, CastApplicationListener {

    private var executor: ScheduledExecutorService? = null
    private val updateCastTimer = Runnable {
        post {
            approximateCastPlayerPosition = mclsCast?.castPlayer?.currentPosition() ?: -1
        }
    }
    private var castTimerJob: ScheduledFuture<*>? = null

    private var annotationView: AnnotationView

    private val binding: ViewMlsBinding
    private val mclsNetwork: MCLSNetwork
    private val mclsPlayer: MCLSPlayer
    private var mclsCast: MCLSCast? = null
    private val concurrencyControlEnabled: Boolean

    private var streamUrlPullJob: Job? = null
    private lateinit var scope: CoroutineScope

    var inCast = false
    var approximateCastPlayerPosition: Long = -1

    private var currentEvent: EventEntity? = null
    private var viewInForeground = false

    init {
        val layoutInflater = LayoutInflater.from(context)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MCLSView)
        val publicKey = typedArray.getString(R.styleable.MCLSView_publicKey) ?: ""
        val castAppId = typedArray.getString(R.styleable.MCLSView_castAppId) ?: ""
        concurrencyControlEnabled =
            typedArray.getBoolean(R.styleable.MCLSView_enableConcurrencyControl, false)
        typedArray.recycle()

        annotationView = AnnotationView(context)

        binding = ViewMlsBinding.inflate(layoutInflater, this, true)
        findViewById<FrameLayout>(com.google.android.exoplayer2.R.id.exo_content_frame)
            .addView(annotationView)

        mclsNetwork = MCLSNetwork.builder()
            .withContext(context)
            .withPublicKey(publicKey)
            .build()

        mclsPlayer = MCLSPlayer.Builder()
            .withContext(context)
            .withPlayerView(binding.playerView)
            .build()

        val activity = getActivity()
            ?: throw IllegalStateException("Please use an activity to inflate this view")

        val lifecycle = activity.lifecycle
        lifecycle.addObserver(this)
        lifecycle.addObserver(mclsPlayer)
        lifecycle.addObserver(annotationView)

        annotationView.attachPlayer(object : VideoPlayer {
            override fun currentPosition(): Long {
                return if (inCast) {
                    -1
                } else {
                    mclsPlayer.player.currentPosition()
                }
            }
        })

        if (castAppId.isNotEmpty()) {
            MCLSCast.Builder()
                .withActivity(activity)
                .withAppId(castAppId)
                .withPublicKey(publicKey)
                .withRemotePlayerView(binding.remotePlayerView)
                .withMediaButton(binding.remoteMediaButton)
                .build { cast ->
                    mclsCast = cast

                    cast.addListener(this@MCLSView)

                    cast.addListener(object : CastSessionListener() {
                        override fun onSessionResumed(wasSuspended: Boolean) {
                            super.onSessionResumed(wasSuspended)

                            val lastKnownPosition = mclsPlayer.player.currentPosition()
                            Timber.d("Last Known Position $lastKnownPosition")
                            if (lastKnownPosition > 0) {
                                mclsCast?.castPlayer?.seekTo(lastKnownPosition)
                            }
                        }
                    })
                }
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewInForeground = false
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewInForeground = true
    }

    fun playEvent(
        eventId: String,
        dispatcher: CoroutineDispatcher = Dispatchers.Default
    ) {
        scope = CoroutineScope(dispatcher)

        scope.launch {
            val eventResult = mclsNetwork.getEventDetails(eventId)

            if (eventResult !is MCLSResult.Success) {
                return@launch
            }

            playEvent(eventResult.value)

            joinEventTimelineUpdate(eventResult.value)
        }
    }

    fun setPublicKey(publicKey: String) {
        mclsNetwork.setPublicKey(publicKey)
    }

    fun setIdentityToken(identityToken: String) {
        mclsNetwork.setIdentityToken(identityToken)
    }

    fun playEvent(event: EventEntity) {
        currentEvent = event
        post {
            if (inCast) {
                mclsCast?.playEvent(event)
            } else {
                mclsPlayer.playEvent(event)
            }
        }
    }

    fun setActions(actions: List<AnnotationAction>) {
        post {
            annotationView.setActions(actions)
        }
    }

    private fun getActivity(): FragmentActivity? {
        var context = context
        while (context is ContextWrapper) {
            if (context is FragmentActivity) {
                return context
            }
            context = context.baseContext
        }
        return null
    }

    private suspend fun joinEventTimelineUpdate(event: EventEntity) {
        if (event.isMLS) {
            mclsNetwork.reactorSocket.joinEvent(event.id)
            startStreamUrlPullingIfNeeded(event)
            fetchActions(event)
        } else {
            cancelStreamUrlPulling()
        }
    }

    private suspend fun fetchActions(event: EventEntity) {
        val timelineId = event.timeline_ids.firstOrNull() ?: return

        val actions = mclsNetwork.getActions(timelineId, null).valueOrNull() ?: return

        annotationView.setActions(actions)
    }

    private fun startStreamUrlPullingIfNeeded(
        event: EventEntity,
    ) {
        cancelStreamUrlPulling()
        if (event.streamStatus() == StreamStatus.PLAYABLE) {
            return
        }
        streamUrlPullJob = scope.launch {
            delay(30000L)
            // This request is made by id to refresh links, if they change
            playEvent(event.id)
        }
    }

    @OptIn(FlowPreview::class, ObsoleteCoroutinesApi::class)
    override fun onApplicationConnected() {
        inCast = true
        binding.playerView.visibility = GONE
        binding.remotePlayerView.visibility = VISIBLE
        mclsPlayer.player.pause()
        currentEvent?.let {
            mclsCast?.playEvent(it)
        }

        Timber.d("${getActivity()}")

        Timber.d("Setting the Ticker")
        executor = Executors.newSingleThreadScheduledExecutor()
        castTimerJob = executor?.scheduleAtFixedRate(updateCastTimer, 0, 1, TimeUnit.SECONDS)
    }

    override fun onApplicationDisconnected() {
        inCast = false
        binding.playerView.visibility = VISIBLE
        binding.remotePlayerView.visibility = GONE
        mclsPlayer.player.getExoPlayerInstance()?.play()
        currentEvent?.let {
            playEvent(it)
        }

        executor?.shutdown()
        castTimerJob?.cancel(false)
        castTimerJob = null
        executor = null

        mclsPlayer.player.getExoPlayerInstance()?.addListener(object : Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                super.onPlaybackStateChanged(playbackState)
                if (playbackState == STATE_READY && approximateCastPlayerPosition > 0) {
                    mclsPlayer.seekTo(approximateCastPlayerPosition)
                    approximateCastPlayerPosition = -1
                }
            }
        })
    }

    private fun cancelStreamUrlPulling() {
        streamUrlPullJob?.cancel()
    }
}