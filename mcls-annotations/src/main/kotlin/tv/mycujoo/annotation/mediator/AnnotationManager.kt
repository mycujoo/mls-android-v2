package tv.mycujoo.annotation.mediator

import android.content.Context
import tv.mycujoo.annotation.annotation.IAnnotationView
import tv.mycujoo.annotation.di.DaggerMCLSAnnotationsComponent
import tv.mycujoo.mclscore.model.AnnotationAction
import javax.inject.Inject

interface AnnotationManager {
    fun setActions(actions: List<AnnotationAction>)

    fun setTime(currentPosition: Long)

    class Builder {
        lateinit var annotationView: IAnnotationView
        lateinit var context: Context

        @Inject
        lateinit var annotationManager: AnnotationManager

        fun withAnnotationView(annotationView: IAnnotationView) = apply {
            this.annotationView = annotationView
        }

        fun withContext(context: Context) = apply {
            this.context = context
        }

        fun build(): AnnotationManager {
            DaggerMCLSAnnotationsComponent.builder()
                .bindContext(context)
                .bindAnnotationView(annotationView)
                .create()
                .inject(this)

            return annotationManager
        }

    }
}