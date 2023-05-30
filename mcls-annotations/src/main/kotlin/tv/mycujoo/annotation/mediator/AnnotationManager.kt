package tv.mycujoo.annotation.mediator

import android.content.Context
import com.caverock.androidsvg.SVG
import tv.mycujoo.annotation.annotation.IAnnotationView
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.di.DaggerMCLSAnnotationsComponent
import tv.mycujoo.annotation.helper.SVGAssetResolver
import tv.mycujoo.mclscore.model.AnnotationAction
import javax.inject.Inject

/**
 * Annotation management in AnnotationView.
 */
interface AnnotationManager {

    /**
     * Sets the actions in memory, queuing them for processing when [setTime] is triggered.
     *
     * @param actions the actions of a given event
     */
    fun setActions(actions: List<AnnotationAction>)

    /**
     * Processes actions and add/remove them to the AnnotationView
     *
     * @param currentPosition the current time of the video in ms
     */
    fun setTime(currentPosition: Long)

    /**
     * A shorthand recurrent call to [setTime] and takes care of the rate of refreshes based on our recommendations
     */
    fun attachPlayer(videoPlayer: VideoPlayer)

    /**
     * Releases the player from memory.
     */
    fun release()

    class Builder {
        lateinit var annotationView: IAnnotationView
        lateinit var context: Context

        @Inject
        lateinit var annotationManager: AnnotationManager

        @Inject
        lateinit var svgAssetResolver: SVGAssetResolver

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

            SVG.registerExternalFileResolver(svgAssetResolver)

            return annotationManager
        }

    }
}