package tv.mycujoo.mclsui

import androidx.fragment.app.FragmentActivity
import com.google.android.exoplayer2.ExoPlayer
import tv.mycujoo.annotation.annotation.IAnnotationView
import tv.mycujoo.annotation.annotation.VideoPlayer

abstract class AnnotationViewBuilder {

    lateinit var activity: FragmentActivity
    private lateinit var mAnnotationView: IAnnotationView
    lateinit var videoPlayer: VideoPlayer

    abstract fun withPlayer(exoPlayer: ExoPlayer): AnnotationViewBuilder

    open fun withActivity(activity: FragmentActivity): AnnotationViewBuilder {
        this.activity = activity
        return this
    }

    open fun withAnnotationView(annotationView: IAnnotationView): AnnotationViewBuilder {
        this.mAnnotationView = annotationView
        return this
    }

    open fun getAnnotationView(): IAnnotationView {
        return mAnnotationView
    }

    fun build(): IAnnotationView {
        getAnnotationView().attachPlayer(videoPlayer)
        val annotationView = getAnnotationView()
        activity.lifecycle.addObserver(annotationView)
        return annotationView
    }
}