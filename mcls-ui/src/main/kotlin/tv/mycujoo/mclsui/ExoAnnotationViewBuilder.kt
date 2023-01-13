package tv.mycujoo.mclsui

import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.R
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.widget.AnnotationView

class ExoAnnotationViewBuilder :  AnnotationViewBuilder() {

    private var mAnnotationView: AnnotationView? = null

    override fun withPlayer(exoPlayer: ExoPlayer): ExoAnnotationViewBuilder {
        this.videoPlayer = object : VideoPlayer {
            override fun currentPosition(): Long {
                return exoPlayer.currentPosition
            }
        }
        return this
    }

    override fun getAnnotationView(): AnnotationView {
        var annotationView = mAnnotationView
        val inflatedResult = if (annotationView == null) {
            annotationView = AnnotationView(activity)
            activity
                .findViewById<AspectRatioFrameLayout>(R.id.exo_content_frame)
                .addView(annotationView)
            annotationView
        } else {
            annotationView
        }

        mAnnotationView = inflatedResult
        return inflatedResult
    }
}
