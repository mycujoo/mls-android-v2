package tv.mycujoo.mcls.widget

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player.Listener
import com.google.android.exoplayer2.Player.STATE_READY
import kotlinx.coroutines.*
import timber.log.Timber
import tv.mycujoo.annotation.mediator.AnnotationManager
import tv.mycujoo.annotation.widget.AnnotationView
import tv.mycujoo.mcls.widget.di.DaggerMCLSComponent
import tv.mycujoo.mcls.widget.prefs.Preferences
import tv.mycujoo.mclscast.MCLSCast
import tv.mycujoo.mclscast.manager.CastApplicationListener
import tv.mycujoo.mclscast.manager.CastSessionListener
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.helper.valueOrNull
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.MCLSResult
import tv.mycujoo.mclsdialogs.inflateCustomInformationDialog
import tv.mycujoo.mclsima.Ima
import tv.mycujoo.mclsnetwork.MCLSNetwork
import tv.mycujoo.mclsnetwork.network.socket.BFFRTCallback
import tv.mycujoo.mclsplayer.player.MCLSPlayer
import tv.mycujoo.mls.R
import tv.mycujoo.mls.databinding.ViewMlsBinding
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MCLSView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), DefaultLifecycleObserver, CastApplicationListener {

    private val castListeners = mutableSetOf<CastApplicationListener>()

    private var onLimitExceededListeners = mutableSetOf<ConcurrencyLimitListener>()

    // region Cast Executors and Timers
    /** Thread for Cast Timer **/
    private var castExecutor: ScheduledExecutorService? = null

    /** on Cast Timer Tick **/
    private val updateCastTimer = Runnable {
        post {
            approximateCastPlayerPosition = mclsCast?.castPlayer?.currentPosition() ?: -1
        }
    }

    /** Tick Job, should be cancelled on cast disconnected **/
    private var castTimerJob: ScheduledFuture<*>? = null
    // endregion

    // region Annotation Player sync job
    /** Annotation Sync Job **/
    private var annotationPlayerExecutor: ScheduledExecutorService? = null

    /** Annotation Sync On Tick **/
    private val annotationPlayerTickRunnable = Runnable {
        post {
            annotationManager.setTime(mclsPlayer.player.currentPosition())
        }
    }

    /** Annotation Future Sync Job **/
    private var futureAnnotationSyncJob: ScheduledFuture<*>? = null

    // endregion

    // region Concurrency Control Section
    private val concurrencyControlListener: BFFRTCallback = object : BFFRTCallback {
        override fun onBadRequest(reason: String) {
            Logger().e(reason)
        }

        override fun onServerError() {
            Logger().e("Server Error")
        }

        override fun onLimitExceeded(allowedDevicesNumber: Int) {
            mclsCast?.castPlayer?.release()
            mclsPlayer.player.release()

            onLimitExceededListeners.forEach { it.onLimitExceeded() }
            showError("Concurrency Limit Exceeded!")
        }
    }
    // endregion

    private lateinit var annotationManager: AnnotationManager

    private val binding: ViewMlsBinding
    private lateinit var mclsNetwork: MCLSNetwork
    private lateinit var mclsPlayer: MCLSPlayer
    private var mclsCast: MCLSCast? = null
    private var concurrencyControlEnabled: Boolean = false

    private var streamUrlPullJob: Job? = null
    private lateinit var scope: CoroutineScope

    private var inCast = false
    private var approximateCastPlayerPosition: Long = -1

    private var currentEvent: MCLSEvent? = null

    private val annotationView = AnnotationView(context)

    @Inject
    lateinit var prefs: Preferences

    var imaParamsMap: Map<String, String>? = null

    init {
        val layoutInflater = LayoutInflater.from(context)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MCLSView)
        val publicKey = typedArray.getString(R.styleable.MCLSView_publicKey) ?: ""
        val castAppId = typedArray.getString(R.styleable.MCLSView_castAppId) ?: ""
        val liveAdUnit = typedArray.getString(R.styleable.MCLSView_imaLiveAdUnit) ?: ""
        val adUnit = typedArray.getString(R.styleable.MCLSView_imaAdUnit) ?: ""
        concurrencyControlEnabled =
            typedArray.getBoolean(R.styleable.MCLSView_enableConcurrencyControl, false)
        typedArray.recycle()

        binding = ViewMlsBinding.inflate(layoutInflater, this, true)
        findViewById<FrameLayout>(com.google.android.exoplayer2.R.id.exo_content_frame)
            .addView(annotationView)

        initialize(
            publicKey,
            castAppId,
            liveAdUnit,
            adUnit,
            concurrencyControlEnabled
        )
    }

    // TODO: IMA Redesign on a Event By Event Basis
    fun initialize(
        publicKey: String,
        castAppId: String? = "",
        adUnit: String? = "",
        liveAdUnit: String? = "",
        concurrencyControlEnabled: Boolean = false,
    ) {

        DaggerMCLSComponent.builder()
            .bindContext(context)
            .build()
            .inject(this)

        this.concurrencyControlEnabled = concurrencyControlEnabled

        mclsNetwork = MCLSNetwork.builder()
            .withContext(context)
            .withPublicKey(publicKey)
            .build()

        val playerBuilder = MCLSPlayer.Builder()
            .withContext(context)
            .withPlayerView(binding.playerView)

        if (!adUnit.isNullOrEmpty()) {
            playerBuilder.withIma(Ima(
                adUnit = adUnit,
                liveAdUnit = liveAdUnit.orEmpty().ifEmpty { adUnit },
                paramProvider = {
                    buildMap {
                        imaParamsMap?.forEach { row  ->
                            put(row.key, row.value)
                        }
                        put("event_id", currentEvent?.id ?: "UNKNOWN")

                    }
                }
            ))
        }

        annotationManager = AnnotationManager.Builder()
            .withAnnotationView(annotationView)
            .withContext(context)
            .build()

        val activity = getActivity()
            ?: throw IllegalStateException("Please use an activity to inflate this view")

        val lifecycle = getLifecycle()
            ?: throw IllegalStateException("Please use a Lifecycle Owner to inflate this view in")

        mclsPlayer = playerBuilder
            .withActivity(activity)
            .build()

        lifecycle.addObserver(this)
        lifecycle.addObserver(mclsPlayer)
        lifecycle.addObserver(annotationView)

        annotationPlayerExecutor = Executors.newSingleThreadScheduledExecutor()
        futureAnnotationSyncJob = annotationPlayerExecutor?.scheduleAtFixedRate(
            annotationPlayerTickRunnable,
            0,
            1,
            TimeUnit.SECONDS
        )

        if (!castAppId.isNullOrEmpty()) {
            MCLSCast.Builder()
                .withLifecycle(lifecycle)
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

    fun playEvent(
        eventId: String,
        imaParamsMap: Map<String, String>? = null,
        dispatcher: CoroutineDispatcher = Dispatchers.Default,
    ) {
        imaParamsMap?.let {
            this.imaParamsMap = it
        }

        scope = CoroutineScope(dispatcher)

        scope.launch {
            val eventResult = mclsNetwork.getEventDetails(eventId)

            if (eventResult !is MCLSResult.Success) {
                return@launch
            }

            playEvent(eventResult.value)

            joinEventTimelineUpdate(eventResult.value)
            if (concurrencyControlEnabled) joinConcurrencyControlChannel(eventResult.value.id)
        }
    }

    fun setPublicKey(publicKey: String) {
        mclsNetwork.setPublicKey(publicKey)
    }

    fun addCastListener(applicationListener: CastApplicationListener) {
        castListeners.add(applicationListener)
        mclsCast?.addListener(applicationListener)
    }

    fun removeCastListener(applicationListener: CastApplicationListener) {
        castListeners.remove(applicationListener)
        mclsCast?.removeListener(applicationListener)
    }

    fun showError(errorMessage: String) {
        inflateCustomInformationDialog(
            binding.overlay,
            currentEvent?.title.orEmpty(),
            errorMessage
        )
    }

    fun setIdentityToken(identityToken: String) {
        mclsNetwork.setIdentityToken(identityToken)
    }

    fun playEvent(event: MCLSEvent) {
        currentEvent = event
        post {
            if (inCast) {
                mclsCast?.playEvent(event)
            } else {
                mclsPlayer.playEvent(event)
            }
        }
    }

    fun setImaParams(paramsMap: Map<String, String>) {

    }

    fun setUserId(userId: String) {
        mclsPlayer.playerUser.setUserId(userId)
    }

    fun setPseudoUserId(pseudoUserId: String) {
        mclsPlayer.playerUser.setPseudoUserId(pseudoUserId)
    }

    private fun joinConcurrencyControlChannel(eventId: String) {
        mclsNetwork.bffRtSocket.startSession(eventId, mclsNetwork.getIdentityToken())
        mclsNetwork.bffRtSocket.addListener(concurrencyControlListener)
    }

    fun setImaWithParams(
        liveAdUnit: String,
        adUnit: String,
    ) {
        mclsPlayer.setIma(
            Ima(
                liveAdUnit = liveAdUnit,
                adUnit = adUnit,
                paramProvider = {
                    buildMap {
                        put("event_id", currentEvent?.id ?: "UNKNOWN")
                    }
                }
            )
        )
    }

    fun setActions(actions: List<AnnotationAction>) {
        post {
            annotationManager.setActions(actions)
        }
    }

    private fun getActivity(): Activity? {
        var context = context
        while (context is ContextWrapper) {
            if (context is Activity) {
                return context
            }
            context = context.baseContext
        }
        return null
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

    private suspend fun joinEventTimelineUpdate(event: MCLSEvent) {
        if (event.isMLS) {
            mclsNetwork.reactorSocket.joinEvent(event.id)
            startStreamUrlPullingIfNeeded(event)
            fetchActions(event)
        } else {
            cancelStreamUrlPulling()
        }
    }

    private suspend fun fetchActions(event: MCLSEvent) {
        val timelineId = event.timeline_ids.firstOrNull() ?: return

        val actions = mclsNetwork.getActions(timelineId, null).valueOrNull() ?: return

        annotationManager.setActions(actions)
    }

    private fun startStreamUrlPullingIfNeeded(
        event: MCLSEvent,
    ) {
        cancelStreamUrlPulling()
        if (event.streamStatus() == StreamStatus.PLAYABLE) {
            return
        }

        if (event.streamStatus() != StreamStatus.GEOBLOCKED) {
            streamUrlPullJob = scope.launch {
                delay(30000L)
                // This request is made by id to refresh links, if they change
                playEvent(event.id)
            }
        }
    }

    @OptIn(FlowPreview::class, ObsoleteCoroutinesApi::class)
    override fun onApplicationConnected() {
        inCast = true
        binding.playerView.visibility = GONE
        binding.remotePlayerView.visibility = VISIBLE
        mclsPlayer.player.pause()
        currentEvent?.let {
            mclsCast?.playEvent(
                event = it,
                playWhenReady = true,
                position = mclsPlayer.player.currentPosition()
            )
        }

        Timber.d("${getActivity()}")

        Timber.d("Setting the Ticker")
        castExecutor = Executors.newSingleThreadScheduledExecutor()
        castTimerJob = castExecutor?.scheduleAtFixedRate(updateCastTimer, 0, 1, TimeUnit.SECONDS)

        annotationPlayerExecutor?.shutdown()
        futureAnnotationSyncJob?.cancel(false)
        futureAnnotationSyncJob = null
        annotationPlayerExecutor = null
    }

    override fun onApplicationDisconnected() {
        inCast = false
        binding.playerView.visibility = VISIBLE
        binding.remotePlayerView.visibility = GONE
        mclsPlayer.player.getExoPlayerInstance()?.play()
        currentEvent?.let {
            playEvent(it)
        }

        castExecutor?.shutdown()
        castTimerJob?.cancel(false)
        castTimerJob = null
        castExecutor = null

        annotationPlayerExecutor = Executors.newSingleThreadScheduledExecutor()
        futureAnnotationSyncJob = annotationPlayerExecutor?.scheduleAtFixedRate(
            annotationPlayerTickRunnable,
            0,
            1,
            TimeUnit.SECONDS
        )

        mclsPlayer.player.getExoPlayerInstance()?.addListener(object : Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                super.onPlaybackStateChanged(playbackState)
                if (playbackState == STATE_READY && approximateCastPlayerPosition > 0) {
                    mclsPlayer.seekTo(approximateCastPlayerPosition)
                    approximateCastPlayerPosition = -1
                }
            }

            override fun onPlayerError(error: PlaybackException) {
                super.onPlayerError(error)
                Timber.e("Error! $error")
            }

            override fun onPlayerErrorChanged(error: PlaybackException?) {
                super.onPlayerErrorChanged(error)
                Timber.e("Error Changed! $error")
            }
        })
    }

    private fun cancelStreamUrlPulling() {
        streamUrlPullJob?.cancel()
    }
}