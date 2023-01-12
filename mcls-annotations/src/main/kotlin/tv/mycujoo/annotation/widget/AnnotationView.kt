package tv.mycujoo.annotation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import tv.mycujoo.annotation.annotation.IAnnotationView
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.databinding.ViewAnnotationBinding
import tv.mycujoo.annotation.di.DaggerMCLSAnnotationsComponent
import tv.mycujoo.annotation.di.TickerFlow
import tv.mycujoo.annotation.mediator.IAnnotationMediator
import tv.mycujoo.mclscore.model.Action
import javax.inject.Inject
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

@OptIn(DelicateCoroutinesApi::class)
class AnnotationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), IAnnotationView {

    @Inject
    lateinit var annotationMediator: IAnnotationMediator

    private var viewInForeground = false

    init {
        val inflater = LayoutInflater.from(context)
        ViewAnnotationBinding.inflate(inflater, this, true)

        val mlsComponent = DaggerMCLSAnnotationsComponent.builder()
            .bindContext(context)
            .bindAnnotationView(this)
            .create()

        mlsComponent.inject(this)
    }

    override fun attachPlayer(player: VideoPlayer) {
        GlobalScope.launch(Dispatchers.Main) {
            tickerFlow(500.milliseconds).collect {
                annotationMediator.build(player.currentPosition())
            }
        }
    }

    override fun setMCLSActions(actions: List<Action>) {
        annotationMediator.setMCLSActions(actions)
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