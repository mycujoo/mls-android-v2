package tv.mycujoo.mclsplayer.player

import android.content.Context
import android.content.res.Configuration
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.ExoPlayer
import timber.log.Timber
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclsplayer.player.config.VideoPlayerConfig
import tv.mycujoo.mclsplayer.player.di.DaggerMCLSPlayerComponent
import tv.mycujoo.mclsplayer.player.mediator.VideoPlayerMediator
import tv.mycujoo.mclsplayer.player.player.Player
import tv.mycujoo.mclsplayer.player.utils.ExoPlayerContainer
import tv.mycujoo.mclsplayer.player.widget.MCLSPlayerView
import javax.inject.Inject

class MCLSPlayer private constructor(
    private val playerView: MCLSPlayerView,
    private val exoPlayerContainer: ExoPlayerContainer,
    private val context: Context,
    private val onFullScreenClicked: ((Boolean) -> Unit)?,
    videoPlayerConfig: VideoPlayerConfig,
): DefaultLifecycleObserver {

    @Inject
    lateinit var videoPlayerMediator: VideoPlayerMediator

    @Inject
    lateinit var player: Player

    init {
        val component = DaggerMCLSPlayerComponent.builder()
            .bindContext(context)
            .bindExoPlayerContainer(exoPlayerContainer)
            .bindMCLSPlayerView(playerView)
            .build()

        component.inject(this)

        playerView.config(videoPlayerConfig)
        playerView.setPlayer(player)
    }

    fun playEvent(event: EventEntity) {
        videoPlayerMediator.playEvent(event)
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)

        when(context.resources.configuration.orientation ) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                playerView.setInFullScreen(true)
                playerView.setOnFullScreenClicked {
                    onFullScreenClicked?.invoke(false)
                }
            }
            Configuration.ORIENTATION_PORTRAIT -> {
                playerView.setInFullScreen(false)
                playerView.setOnFullScreenClicked {
                    onFullScreenClicked?.invoke(true)
                }
            }
            else -> {}
        }
    }

    class Builder {
        private var activity: FragmentActivity? = null
        private var exoPlayerContainer: ExoPlayerContainer? = null
        private var mclsPlayerView: MCLSPlayerView? = null
        private var onFullScreenClicked: ((Boolean) -> Unit)? = null

        private var videoPlayerConfig = VideoPlayerConfig.default()

        fun withContext(activity: FragmentActivity) = apply {
            this.activity = activity
        }

        fun withExoPlayer(exoPlayer: ExoPlayer) = apply {
            exoPlayerContainer = ExoPlayerContainer(exoPlayer)
        }

        fun withPlayerView(mclsPlayerView: MCLSPlayerView) = apply {
            this.mclsPlayerView = mclsPlayerView
        }

        fun withPlayerConfig(playerConfig: VideoPlayerConfig) = apply {
            videoPlayerConfig = playerConfig
        }

        fun withOnFullScreenButtonClicked(onFullScreenClicked: (Boolean) -> Unit) = apply {
            this.onFullScreenClicked = onFullScreenClicked
        }

        fun build(): MCLSPlayer {
            val ctx = activity
                ?: throw IllegalArgumentException("Please use withContext before building this component")

            val playerView = mclsPlayerView
                ?: throw IllegalArgumentException("Please use withPlayerView before building this component")

            val exoPlayerContainer = exoPlayerContainer ?: run {
                val exoPlayer = ExoPlayer.Builder(ctx).build()
                ExoPlayerContainer(exoPlayer)
            }

            val mclsPlayer = MCLSPlayer(
                playerView = playerView,
                exoPlayerContainer = exoPlayerContainer,
                context = ctx,
                onFullScreenClicked = onFullScreenClicked,
                videoPlayerConfig = videoPlayerConfig,
            )

            ctx.lifecycle.addObserver(mclsPlayer)

            return mclsPlayer
        }
    }
}