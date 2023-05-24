package tv.mycujoo.annotation.mediator

import android.os.Handler
import android.os.Looper
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.core.IAnnotationFactory
import tv.mycujoo.mclscore.model.AnnotationAction
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class AnnotationManagerImpl @Inject constructor(
    private val annotationFactory: IAnnotationFactory,
) : AnnotationManager {
    /**endregion */

    private var player: VideoPlayer? = null

    // region Annotation Player sync job
    /** Annotation Sync Job **/
    private var annotationPlayerExecutor: ScheduledExecutorService? = null

    /** Annotation Sync On Tick **/
    private val annotationPlayerTickRunnable = Runnable {
        Handler(Looper.getMainLooper()).post {
            player?.let { annotationFactory.build(it.currentPosition()) }
        }
    }

    /** Annotation Future Sync Job **/
    private var futureAnnotationSyncJob: ScheduledFuture<*>? = null

    // endregion

    /**region Over-ridden Functions*/
    override fun setActions(actions: List<AnnotationAction>) {
        annotationFactory.setActions(actions)
    }

    override fun setTime(currentPosition: Long) {
        annotationFactory.build(currentPosition)
    }

    override fun attachPlayer(videoPlayer: VideoPlayer) {
        this.player = videoPlayer

        annotationPlayerExecutor = Executors.newSingleThreadScheduledExecutor()
        futureAnnotationSyncJob = annotationPlayerExecutor?.scheduleAtFixedRate(
            annotationPlayerTickRunnable,
            0,
            1,
            TimeUnit.SECONDS
        )
    }

    override fun release() {
        annotationFactory.setActions(emptyList())
        annotationPlayerExecutor?.shutdown()
        futureAnnotationSyncJob?.cancel(false)
        futureAnnotationSyncJob = null
        annotationPlayerExecutor = null
    }

    /**endregion */
}
