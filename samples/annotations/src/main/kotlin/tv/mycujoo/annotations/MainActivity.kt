package tv.mycujoo.annotations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tv.mycujoo.annotation.annotation.IAnnotationView
import tv.mycujoo.annotation.mediator.AnnotationManager
import tv.mycujoo.annotations.databinding.ActivityMainBinding
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.PositionGuide
import tv.mycujoo.mclscore.model.SvgData
import tv.mycujoo.mclscore.model.ViewSpec
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var exoPlayer: ExoPlayer

    private lateinit var annotationManager: AnnotationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exoPlayer = ExoPlayer
            .Builder(this)
            .build()

        binding.styledPlayerView.player = exoPlayer

        annotationManager = AnnotationManager.Builder()
            .withAnnotationView(binding.annotationView)
            .withContext(this)
            .build()

        attachAnnotationActions()
        playVideo()

        CoroutineScope(Dispatchers.Main).launch {
            tick()
        }
    }

    private suspend fun tick() {
        annotationManager.setTime(exoPlayer.currentPosition)
        delay(1000)
        tick()
    }

    private fun playVideo() {
        val mediaItem = MediaItem
            .fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4")

        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.play()
    }

    private fun attachAnnotationActions() {
        annotationManager.setActions(
            listOf(
                AnnotationAction.ShowOverlayAction(
                    absoluteTime = 0,
                    offset = 0,
                    id = "1",
                    duration = 5000,
                    svgData = SvgData(
                        svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                    ),
                    viewSpec = ViewSpec(
                        positionGuide = PositionGuide(
                            left = 0f,
                            top = 0f
                        ),
                        size = Pair(35F, 100F)
                    )
                )
            )
        )
    }
}