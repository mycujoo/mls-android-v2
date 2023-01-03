package tv.mycujoo.mcls.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.google.android.exoplayer2.R
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclsplayer.player.MCLSPlayer
import tv.mycujoo.mclsui.AnnotationView
import tv.mycujoo.mls.databinding.ViewMlsBinding
import tv.mycujoo.mlsdata.MCLSData

class MCLSView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

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
}