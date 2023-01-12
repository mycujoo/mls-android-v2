package tv.mycujoo.annotation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import tv.mycujoo.annotation.annotation.IAnnotationView
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.databinding.ViewAnnotationBinding
import tv.mycujoo.annotation.di.DaggerMCLSAnnotationsComponent
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

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        viewInForeground = false
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        viewInForeground = true
    }

    override fun attachPlayer(player: VideoPlayer) {
        Timber.d("Attaching Player!!!")
        getScope().launch {
            tickerFlow(500.milliseconds).collect {
                post {
                    Timber.d("Tick")
                    annotationMediator.build(player.currentPosition())
                }
            }
        }
    }

    private fun getScope(): CoroutineScope {
        return findViewTreeLifecycleOwner()?.lifecycleScope ?: GlobalScope
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
}
