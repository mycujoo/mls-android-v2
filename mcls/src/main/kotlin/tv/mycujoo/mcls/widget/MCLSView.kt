package tv.mycujoo.mcls.widget

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.core.view.isVisible
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player.Listener
import com.google.android.exoplayer2.Player.STATE_READY
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.mediator.AnnotationManager
import tv.mycujoo.annotation.widget.AnnotationView
import tv.mycujoo.mclscast.MCLSCast
import tv.mycujoo.mclscast.manager.CastApplicationListener
import tv.mycujoo.mclscast.manager.CastSessionListener
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.helper.valueOrNull
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.MCLSEvent
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
import kotlin.jvm.Throws

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
            approximateCastPlayerPosition = mclsCast?.player?.currentPosition() ?: -1
        }
    }

    /** Tick Job, should be cancelled on cast disconnected **/
    private var castTimerJob: ScheduledFuture<*>? = null
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
            mclsCast?.player?.release()
            mclsPlayer?.player?.release()

            onLimitExceededListeners.forEach { it.onLimitExceeded() }
            showError("Concurrency Limit Exceeded!")
        }
    }
    // endregion

    private var annotationManager: AnnotationManager? = null

    private val binding: ViewMlsBinding
    private var mclsNetwork: MCLSNetwork? = null
    private var mclsPlayer: MCLSPlayer? = null
    private var mclsCast: MCLSCast? = null
    private var concurrencyControlEnabled: Boolean = false

    private var streamUrlPullJob: Job? = null

    private var inCast = false
    private var approximateCastPlayerPosition: Long = -1

    private var currentEvent: MCLSEvent? = null

    private val annotationView = AnnotationView(context)

    var imaParamsMap: Map<String, String>? = null

    private var annotationsEnabled = true
    private var localActionsEnabled = false
    private var initialized = false

    private var publicKey = ""
    private var imaAdUnitVod = ""
    private var imaAdUnitLive = ""
    private var identityToken = ""
    private var pseudoUserId = ""
    private var userId = ""

    init {
        val layoutInflater = LayoutInflater.from(context)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MCLSView)
        publicKey = typedArray.getString(R.styleable.MCLSView_publicKey) ?: ""
        val castAppId = typedArray.getString(R.styleable.MCLSView_castAppId) ?: ""
        imaAdUnitLive = typedArray.getString(R.styleable.MCLSView_imaLiveAdUnit) ?: ""
        imaAdUnitVod = typedArray.getString(R.styleable.MCLSView_imaAdUnit) ?: ""
        concurrencyControlEnabled =
            typedArray.getBoolean(R.styleable.MCLSView_enableConcurrencyControl, false)
        typedArray.recycle()

        binding = ViewMlsBinding.inflate(layoutInflater, this, true)

        initialize(
            castAppId
        )
    }

    private fun initialize(
        castAppId: String? = "",
    ) {
        if (initialized) {
            return
        }
        initialized = true

        val lifecycle = getLifecycle()
            ?: throw IllegalStateException("Please use a Lifecycle Owner to inflate this view in")

        post {
            lifecycle.addObserver(this)
        }

        if (!castAppId.isNullOrEmpty()) {
            setupCast(castAppId)
        }
    }

    /**
     * Play an event using event id
     *
     * @param eventId the MCLS Event id
     * @param imaParamsMap Extra Params used for targeting in IMA
     *
     * @sample playEvent("1", null, viewModelScope)
     */
    fun playEvent(
        eventId: String,
        imaParamsMap: Map<String, String>? = null,
    ) {
        this.imaParamsMap = imaParamsMap ?: emptyMap()

        getLifecycleScope().launch {
            getNetworkClient().getEventDetails(
                eventId = eventId,
                onEventComplete = {
                    playEvent(it)
                    getLifecycleScope().launch {
                        joinEventTimelineUpdate(it)
                    }

                    if (concurrencyControlEnabled) joinConcurrencyControlChannel(it.id)
                },
                onError = {
                    showError(it)
                }
            )
        }
    }

    fun setConcurrencyEnabled(concurrencyLimitEnabled: Boolean) {
        this.concurrencyControlEnabled = concurrencyControlEnabled
    }

    fun addCastListener(applicationListener: CastApplicationListener) {
        castListeners.add(applicationListener)
        mclsCast?.addListener(applicationListener)
    }

    fun removeCastListener(applicationListener: CastApplicationListener) {
        castListeners.remove(applicationListener)
        mclsCast?.removeListener(applicationListener)
    }

    /**
     * Sets the identity token for MCLSNetwork and MCLSCast requests when needed.
     */
    fun setIdentityToken(identityToken: String) {
        this.identityToken = identityToken

        mclsNetwork?.setIdentityToken(identityToken)
        mclsCast?.identityToken = identityToken
    }

    fun setAnnotationActionsEnabled(enabled: Boolean) {
        annotationsEnabled = enabled

        if (!enabled) {
            annotationView.isVisible = false
        }
    }

    /**
     * Sets the public key for MCLSNetwork and MCLSCast requests
     */
    fun setPublicKey(publicKey: String) {
        this.publicKey = publicKey

        mclsNetwork?.setPublicKey(publicKey)
        mclsCast?.publicKey = publicKey
    }

    /**
     * Plays an event in active player:
     *      1. If a cast session is established, play the event in cast
     *      2. If not, it will be played in the local VideoPlayer
     *
     * @throws NotAttachedToActivityException when the view is not attached to [Activity]
     */
    fun playEvent(event: MCLSEvent) {
        currentEvent = event
        post {
            if (inCast) {
                mclsCast?.playEvent(event)
            } else {
                getMCLSPlayer().playEvent(event)
            }
        }
    }

    /**
     * Setter for UserId in Youbora for the local VideoPlayer
     */
    fun setUserId(userId: String) {
        getMCLSPlayer().setUserId(userId)
    }

    /**
     * Setter for PseudoUserId in Youbora for the local VideoPlayer
     */
    fun setPseudoUserId(pseudoUserId: String) {
        this.pseudoUserId = pseudoUserId

        mclsCast?.pseudoUserId = pseudoUserId
        mclsPlayer?.setPseudoUserId(pseudoUserId)
    }

    /**
     * Sets the cast integration
     *
     * @param castAppId the receiver app id being used.
     *
     * @throws IllegalStateException when the view isn't being set into a Lifecycle.
     * @throws IllegalStateException when MCLSCastOptionsProvider isn't being integrated into the app meta data
     */
    fun setupCast(castAppId: String) {
        val lifecycle = getLifecycle()
            ?: throw IllegalStateException("Please use a Lifecycle Owner to inflate this view in")

        binding.remoteMediaButton.isVisible = true

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

                        val lastKnownPosition = mclsPlayer?.player?.currentPosition() ?: 0
                        Timber.d("Last Known Position $lastKnownPosition")
                        if (lastKnownPosition > 0) {
                            mclsCast?.player?.seekTo(lastKnownPosition)
                        }
                    }
                })
            }
    }

    /**
     * Sets IMA in Local VideoPlayer
     *
     * @param adUnit VOD IMA Ad Unit
     * @param liveAdUnit Live IMA Ad Unit
     * @param paramsMap additional params map used for IMA targeting.
     */
    fun setImaWithParams(
        adUnit: String,
        liveAdUnit: String,
        paramsMap: Map<String, String>? = null
    ) {
        imaAdUnitVod = adUnit
        imaAdUnitLive = liveAdUnit

        mclsPlayer?.setIma(
            Ima(
                liveAdUnit = liveAdUnit,
                adUnit = adUnit,
                paramProvider = {
                    paramsMap ?: buildMap {
                        put("event_id", currentEvent?.id ?: "UNKNOWN")
                    }
                }
            )
        )
    }

    /**
     * Sets the [AnnotationAction] list to AnnotationView. those actions are processed based on
     * [VideoPlayer] currentTime
     *
     * @throws IllegalStateException when invoked without a lifecycle parent.
     */
    @Throws(IllegalStateException::class)
    fun setActions(actions: List<AnnotationAction>) {
        post {
            Timber.d("Current Actions ${actions.size}")
            localActionsEnabled = true
            getAnnotationManager().setActions(actions)
        }
    }

    /**
     * gets a build and ready annotation manager. it inflates the view in the local VideoPlayer,
     * attaches an [AnnotationManager] to it and returns it ready for usage
     *
     * @throws IllegalStateException when the view is being used in a non lifecycle parent (FragmentActivity is btw)
     *
     */
    @Throws(IllegalStateException::class)
    private fun getAnnotationManager(): AnnotationManager {
        val oldManager = annotationManager
        if (oldManager != null) {
            return oldManager
        }

        val lifecycle = getLifecycle()
            ?: throw IllegalStateException("Please use a Lifecycle Owner to inflate this view in")

        findViewById<FrameLayout>(com.google.android.exoplayer2.R.id.exo_content_frame)
            .addView(annotationView)

        val newManager = AnnotationManager.Builder()
            .withAnnotationView(annotationView)
            .withContext(context)
            .build()

        post {
            lifecycle.addObserver(annotationView)
        }

        newManager.attachPlayer(object : VideoPlayer {
            override fun currentPosition(): Long {
                if (!annotationsEnabled) {
                    return 0
                }

                return if (getMCLSPlayer().player.isPlayingAd()) {
                    0
                } else {
                    getMCLSPlayer().player.currentPosition()
                }
            }
        })

        annotationManager = newManager

        return newManager
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

    private fun getLifecycleScope(): CoroutineScope {
        return when (val activity = getActivity()) {
            is FragmentActivity -> {
                activity.lifecycleScope
            }

            is ComponentActivity -> {
                activity.lifecycleScope
            }

            else -> CoroutineScope(Dispatchers.Default)
        }
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

    override fun onApplicationConnected() {
        inCast = true
        binding.playerView.visibility = GONE
        binding.remotePlayerView.visibility = VISIBLE
        getMCLSPlayer().player.pause()
        currentEvent?.let {
            mclsCast?.playEvent(
                event = it,
                playWhenReady = true,
                position = getMCLSPlayer().player.currentPosition()
            )
        }

        castExecutor = Executors.newSingleThreadScheduledExecutor()
        castTimerJob = castExecutor?.scheduleAtFixedRate(
            updateCastTimer,
            0,
            1,
            TimeUnit.SECONDS
        )
    }

    override fun onApplicationDisconnected() {
        inCast = false
        binding.playerView.visibility = VISIBLE
        binding.remotePlayerView.visibility = GONE
        mclsPlayer?.player?.getExoPlayerInstance()?.play()
        currentEvent?.let {
            playEvent(it)
        }

        castExecutor?.shutdown()
        castTimerJob?.cancel(false)
        castTimerJob = null
        castExecutor = null

        mclsPlayer?.player?.getExoPlayerInstance()?.addListener(object : Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                super.onPlaybackStateChanged(playbackState)
                if (playbackState == STATE_READY && approximateCastPlayerPosition > 0) {
                    getMCLSPlayer().player.seekTo(approximateCastPlayerPosition)
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

    private fun showError(errorMessage: String) {
        post {
            inflateCustomInformationDialog(
                binding.overlay,
                currentEvent?.title.orEmpty(),
                errorMessage
            )
        }
    }

    private fun joinConcurrencyControlChannel(eventId: String) {
        getNetworkClient().bffRtSocket.startSession(eventId, getNetworkClient().getIdentityToken())
        getNetworkClient().bffRtSocket.addListener(concurrencyControlListener)
    }

    private suspend fun joinEventTimelineUpdate(event: MCLSEvent) {
        if (event.isMLS && localActionsEnabled.not()) {
            getNetworkClient().reactorSocket.joinEvent(event.id)
            startStreamUrlPullingIfNeeded(event)

            if (annotationsEnabled) fetchActions(event)
        } else {
            cancelStreamUrlPulling()
        }
    }

    private suspend fun fetchActions(event: MCLSEvent) {
        val timelineId = event.timeline_ids.firstOrNull() ?: return

        val actions =
            getNetworkClient().getTimelineActions(timelineId, null).valueOrNull() ?: return

        // Just being safe here, this should always be skipped when setActions are invoked
        if (localActionsEnabled.not()) {
            getAnnotationManager().setActions(actions)
        }
    }

    private fun startStreamUrlPullingIfNeeded(event: MCLSEvent) {
        cancelStreamUrlPulling()
        if (event.streamStatus() == StreamStatus.PLAYABLE) {
            return
        }

        if (event.streamStatus() != StreamStatus.GEOBLOCKED) {
            streamUrlPullJob = getLifecycleScope().launch {
                delay(30000L)
                // This request is made by id to refresh links, if they change
                playEvent(event.id)
            }
        }
    }

    private fun cancelStreamUrlPulling() {
        streamUrlPullJob?.cancel()
    }

    /**
     * Safe accessor to [MCLSPlayer] client, and builds only when needed
     *
     * When this is called, pseudoUserId and UserId are automatically set if they are provided before this is built
     *
     * @throws NotAttachedToActivityException when the player is requested without it being attached to an activity
     */
    private fun getMCLSPlayer(): MCLSPlayer {
        val oldPlayer = mclsPlayer
        if (oldPlayer != null) {
            return oldPlayer
        }

        val activity = getActivity()
            ?: throw IllegalStateException("Please use an activity to inflate this view")

        val lifecycle = getLifecycle()
            ?: throw IllegalStateException("Please use a Lifecycle Owner to inflate this view in")

        val playerBuilder = MCLSPlayer.Builder()
            .withContext(context)
            .withPlayerView(binding.playerView)

        if (imaAdUnitVod.isNotEmpty()) {
            playerBuilder.withIma(Ima(
                adUnit = imaAdUnitVod,
                liveAdUnit = imaAdUnitLive.ifEmpty { imaAdUnitVod },
                paramProvider = {
                    buildMap {
                        imaParamsMap?.forEach { row ->
                            put(row.key, row.value)
                        }
                        put("event_id", currentEvent?.id ?: "UNKNOWN")
                    }
                }
            ))
        }

        val newPlayer = playerBuilder
            .withActivity(activity)
            .build()

        if (pseudoUserId.isNotEmpty()) {
            newPlayer.setPseudoUserId(pseudoUserId)
        }

        if (userId.isNotEmpty()) {
            newPlayer.setUserId(userId)
        }

        post {
            lifecycle.addObserver(newPlayer)
        }

        mclsPlayer = newPlayer

        return newPlayer
    }

    /**
     *
     * Safe accessor to [MCLSNetwork] client, and builds it only when needed
     *
     * @throws PublicKeyMissingException when a client is requested without PublicKey
     * @return MCLSNetwork Client, from mclsNetwork if exists otherwise builds it and return a
     * null-safe object of it.
     */
    private fun getNetworkClient(): MCLSNetwork {
        var client = mclsNetwork
        return if (client == null) {

            if (publicKey.isEmpty()) {
                throw PublicKeyMissingException("Please set PublicKey before requesting via Network")
            }

            client = MCLSNetwork.Builder()
                .withContext(context)
                .withPublicKey(publicKey)
                .build()

            if (identityToken.isNotEmpty()) {
                client.setIdentityToken(identityToken)
            }

            mclsNetwork = client

            client
        } else {
            client
        }
    }
}
