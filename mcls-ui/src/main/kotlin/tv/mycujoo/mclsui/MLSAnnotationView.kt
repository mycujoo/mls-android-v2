package tv.mycujoo.mclsui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.lifecycle.LifecycleOwner
import timber.log.Timber
import tv.mycujoo.annotation.annotation.IAnnotationView
import tv.mycujoo.annotation.databinding.ViewAnnotationBinding

class MLSAnnotationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), IAnnotationView {

    private var viewInForeground = false

    init {
        val inflater = LayoutInflater.from(context)
        ViewAnnotationBinding.inflate(inflater, this, true)
    }

    override fun getChildren(): Sequence<View> {
        return children
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
