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
import tv.mycujoo.annotation.mediator.AnnotationManager
import tv.mycujoo.mclscore.model.AnnotationAction
import java.util.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

class AnnotationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), IAnnotationView {

    init {
        val inflater = LayoutInflater.from(context)
        ViewAnnotationBinding.inflate(inflater, this, true)
    }

    override fun getChildren(): Sequence<View> {
        return children
    }
}
