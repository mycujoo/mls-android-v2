package tv.mycujoo.mclsui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import tv.mycujoo.annotation.annotation.IAnnotationView
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.databinding.ViewAnnotationBinding
import tv.mycujoo.annotation.mediator.AnnotationManager
import tv.mycujoo.mclscore.helper.valueOrNull
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclsnetwork.MCLSNetwork
import javax.inject.Inject
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

@OptIn(DelicateCoroutinesApi::class)
class MLSAnnotationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), IAnnotationView {

    private val annotationManager: AnnotationManager

    private var viewInForeground = false

    private val mMCLSNetwork = MCLSNetwork
        .builder()
        .withContext(context)
        .build()

    init {
        val inflater = LayoutInflater.from(context)
        ViewAnnotationBinding.inflate(inflater, this, true)

        annotationManager = AnnotationManager.Builder()
            .withContext(context)
            .withAnnotationView(this)
            .build()
    }

    fun getEventById(
        publicKey: String,
        identityToken: String,
        eventId: String,
    ) {
        mMCLSNetwork.setIdentityToken(identityToken)
        mMCLSNetwork.setPublicKey(publicKey)

        GlobalScope.launch {
            val event = mMCLSNetwork.getEventDetails(eventId).valueOrNull() ?: return@launch

            event.timeline_ids.firstOrNull()?.let { timelineId ->
                val actions = mMCLSNetwork.getActions(
                    timelineId,
                    null
                ).valueOrNull() ?: return@let

                setActions(actions)
            }

        }
    }

    override fun attachPlayer(player: VideoPlayer) {
        GlobalScope.launch(Dispatchers.Main) {
            tickerFlow(500.milliseconds).collect {
                post {
                    annotationManager.setTime(player.currentPosition())
                }
            }
        }
    }

    fun setActions(actions: List<AnnotationAction>) {
        annotationManager.setActions(actions)
    }

    override fun getChildren(): Sequence<View> {
        return children
    }

    private fun tickerFlow(period: Duration, initialDelay: Duration = Duration.ZERO) = flow {
        delay(initialDelay)
        while (true) {
            if (viewInForeground) {
                emit(Unit)
            }
            delay(period)
        }
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Timber.d("OnPause")
        viewInForeground = false
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Timber.d("OnResume")
        viewInForeground = true
    }
}
