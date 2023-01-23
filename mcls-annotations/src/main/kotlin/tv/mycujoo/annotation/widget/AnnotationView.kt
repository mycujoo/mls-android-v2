package tv.mycujoo.annotation.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import tv.mycujoo.annotation.R
import tv.mycujoo.annotation.annotation.IAnnotationView
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.databinding.ViewAnnotationBinding
import tv.mycujoo.annotation.di.DaggerMCLSAnnotationsComponent
import tv.mycujoo.annotation.mediator.AnnotationManager
import tv.mycujoo.mclscore.model.AnnotationAction
import java.util.*
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
    lateinit var annotationMediator: AnnotationManager

    private var viewInForeground = false

    private val refreshDelay: Long

    init {
        val inflater = LayoutInflater.from(context)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.AnnotationView)
        val refreshPerSecond = typedArray.getInteger(R.styleable.AnnotationView_refreshDelayPerSecond, 1)
        refreshDelay = (1000 / refreshPerSecond).toLong()
        typedArray.recycle()
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
        getScope().launch {
            tickerFlow(refreshDelay.milliseconds).collect {
                post {
                    annotationMediator.setTime(player.currentPosition())
                }
            }
        }
    }

    private fun getScope(): CoroutineScope {
        return findViewTreeLifecycleOwner()?.lifecycleScope ?: GlobalScope
    }

    override fun setActions(actions: List<AnnotationAction>) {
        annotationMediator.setActions(actions)
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
