package tv.mycujoo.mcls.widget

import android.content.Context
import android.content.ContextWrapper
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.R
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.mclscore.model.Action
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclsplayer.player.MCLSPlayer
import tv.mycujoo.mclsui.AnnotationView
import tv.mycujoo.mls.databinding.ViewMlsBinding
import tv.mycujoo.mclsnetwork.MCLSData


class MCLSView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), DefaultLifecycleObserver {

    private var annotationView: AnnotationView

    private val binding: ViewMlsBinding
    private val mclsData: MCLSData
    private val mclsPlayer: MCLSPlayer

    init {
        val layoutInflater = LayoutInflater.from(context)

        annotationView = AnnotationView(context)

        binding = ViewMlsBinding.inflate(layoutInflater, this, true)
        findViewById<FrameLayout>(R.id.exo_content_frame)
            .addView(annotationView)


        mclsData = MCLSData.builder()
            .withContext(context)
            .withPublicKey("FBVKACGN37JQC5SFA0OVK8KKSIOP153G")
            .withIdentityToken("")
            .build()

        mclsPlayer = MCLSPlayer.Builder()
            .withContext(context)
            .withPlayerView(binding.playerView)
            .build()

        getLifecycle()?.let { lifecycle ->
            lifecycle.addObserver(this)
            lifecycle.addObserver(annotationView)
        }

        annotationView.attachPlayer(object : VideoPlayer {
            override fun currentPosition(): Long {
                return mclsPlayer.player.currentPosition()
            }
        })
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

    fun playEvent(
        eventId: String,
        dispatcher: CoroutineDispatcher = Dispatchers.Default
    ) {
        CoroutineScope(dispatcher).launch {
            val event = mclsData.getEventDetails(eventId).firstOrNull() ?: return@launch

            post {
                mclsPlayer.playEvent(event)
            }

            val timelineId = event.timeline_ids.firstOrNull() ?: return@launch

            val actions = mclsData.getActions(timelineId, null).firstOrNull() ?: return@launch

            annotationView.setMCLSActions(actions)
        }
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
}