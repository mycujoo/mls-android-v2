package tv.mycujoo.mcls.widget

import android.content.Context
import android.content.ContextWrapper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.firstOrNull
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.model.Action
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclsnetwork.MCLSNetwork
import tv.mycujoo.mclsplayer.player.MCLSPlayer
import tv.mycujoo.annotation.widget.AnnotationView
import tv.mycujoo.mls.R
import tv.mycujoo.mls.databinding.ViewMlsBinding

class MCLSView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), DefaultLifecycleObserver {

    private var annotationView: AnnotationView

    private val binding: ViewMlsBinding
    private val mclsNetwork: MCLSNetwork
    private val mclsPlayer: MCLSPlayer
    private val concurrencyControlEnabled: Boolean

    private var streamUrlPullJob: Job? = null
    private lateinit var scope: CoroutineScope

    init {
        val layoutInflater = LayoutInflater.from(context)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MCLSView)
        val publicKey = typedArray.getString(R.styleable.MCLSView_publicKey) ?: ""
        concurrencyControlEnabled = typedArray.getBoolean(R.styleable.MCLSView_enableConcurrencyControl, false)
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

        getLifecycle()?.let { lifecycle ->
            lifecycle.addObserver(this)
            lifecycle.addObserver(mclsPlayer)
            lifecycle.addObserver(annotationView)
        }

        annotationView.attachPlayer(object : VideoPlayer {
            override fun currentPosition(): Long {
                return mclsPlayer.player.currentPosition()
            }
        })
    }

    fun playEvent(
        eventId: String,
        dispatcher: CoroutineDispatcher = Dispatchers.Default
    ) {
        scope = CoroutineScope(dispatcher)

        scope.launch {
            val event = mclsNetwork.getEventDetails(eventId).firstOrNull() ?: return@launch

            playEvent(event)

            joinEventTimelineUpdate(event)
        }
    }

    fun setPublicKey(publicKey: String) {
        mclsNetwork.setPublicKey(publicKey)
    }

    fun setIdentityToken(identityToken: String) {
        mclsNetwork.setIdentityToken(identityToken)
    }

    fun playEvent(event: EventEntity) {
        post {
            mclsPlayer.playEvent(event)
        }
    }

    fun setActions(actions: List<Action>) {
        post {
            annotationView.setMCLSActions(actions)
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

    private suspend fun joinEventTimelineUpdate(event: EventEntity) {
        if (event.isNativeMLS) {
            mclsNetwork.reactorSocket.joinEvent(event.id)
            startStreamUrlPullingIfNeeded(event)
            fetchActions(event)
        } else {
            cancelStreamUrlPulling()
        }
    }

    private suspend fun fetchActions(event: EventEntity) {
        val timelineId = event.timeline_ids.firstOrNull() ?: return

        val actions = mclsNetwork.getActions(timelineId, null).firstOrNull() ?: return

        annotationView.setMCLSActions(actions)
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

    private fun cancelStreamUrlPulling() {
        streamUrlPullJob?.cancel()
    }
}