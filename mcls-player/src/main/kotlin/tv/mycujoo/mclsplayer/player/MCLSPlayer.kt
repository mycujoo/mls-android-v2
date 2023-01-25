package tv.mycujoo.mclsplayer.player

import android.content.Context
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.ExoPlayer
import timber.log.Timber
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclsplayer.player.config.VideoPlayerConfig
import tv.mycujoo.mclsplayer.player.di.DaggerMCLSPlayerComponent
import tv.mycujoo.mclsplayer.player.ima.IIma
import tv.mycujoo.mclsplayer.player.mediator.VideoPlayerMediator
import tv.mycujoo.mclsplayer.player.player.Player
import tv.mycujoo.mclsplayer.player.utils.ExoPlayerContainer
import tv.mycujoo.mclsplayer.player.widget.IMCLSPlayerView
import javax.inject.Inject

class MCLSPlayer private constructor(
    private val playerView: IMCLSPlayerView,
    private val exoPlayerContainer: ExoPlayerContainer,
    private val context: Context,
    private val onFullScreenClicked: (() -> Unit)?,
    ima: IIma?,
    videoPlayerConfig: VideoPlayerConfig,
) : DefaultLifecycleObserver {

    @Inject
    lateinit var videoPlayerMediator: VideoPlayerMediator

    @Inject
    lateinit var player: Player

    init {
        val component = DaggerMCLSPlayerComponent.builder()
            .bindContext(context)
            .bindExoPlayerContainer(exoPlayerContainer)
            .bindMCLSPlayerView(playerView)
            .bindIma(ima)
            .build()

        component.inject(this)

        playerView.config(videoPlayerConfig)
        playerView.setPlayer(player)
        onFullScreenClicked?.let { onClick ->
            playerView.setOnFullScreenClicked(onClick)
        }

        createExoPlayerIfNotPresent()
    }

    fun replaceExoPlayerInstance(exoPlayer: ExoPlayer) {
        if (exoPlayerContainer.exoPlayer != null) {
            exoPlayerContainer.exoPlayer?.pause()
            exoPlayerContainer.exoPlayer?.release()
            exoPlayerContainer.exoPlayer = null
        }

        exoPlayerContainer.exoPlayer = exoPlayer
    }

    fun playEvent(event: EventEntity) {
        videoPlayerMediator.playEvent(event)
    }

    fun setInFullScreen(onFullScreen: Boolean) {
        playerView.setInFullScreen(onFullScreen)
    }

    fun setOnFullScreenClicked(onClick: () -> Unit) {
        playerView.setOnFullScreenClicked(onClick)
    }

    fun seekTo(position: Long) {
        player.getExoPlayerInstance()?.seekTo(position)
    }

    private fun createExoPlayerIfNotPresent() {
        if (exoPlayerContainer.exoPlayer == null) {
            Timber.d("Creating new ExoPlayer Instance")
            exoPlayerContainer.exoPlayer = ExoPlayer.Builder(context).build()
        }
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)

        createExoPlayerIfNotPresent()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        exoPlayerContainer.exoPlayer?.release()
        exoPlayerContainer.exoPlayer = null
    }

    class Builder {
        private var context: Context? = null
        private var exoPlayerContainer: ExoPlayerContainer? = null
        private var mclsPlayerView: IMCLSPlayerView? = null
        private var onFullScreenClicked: (() -> Unit)? = null
        private var lifecycle: Lifecycle? = null

        private var videoPlayerConfig = VideoPlayerConfig.default()

        private var ima: IIma? = null

        fun withContext(context: Context) = apply {
            this.context = context
        }

        fun withExoPlayer(exoPlayer: ExoPlayer) = apply {
            exoPlayerContainer = ExoPlayerContainer(exoPlayer)
        }

        fun withPlayerView(mclsPlayerView: IMCLSPlayerView) = apply {
            this.mclsPlayerView = mclsPlayerView
        }

        fun withPlayerConfig(playerConfig: VideoPlayerConfig) = apply {
            videoPlayerConfig = playerConfig
        }

        fun withLifecycle(lifecycle: Lifecycle) = apply {
            this.lifecycle = lifecycle
        }

        fun withOnFullScreenButtonClicked(onFullScreenClicked: () -> Unit) = apply {
            this.onFullScreenClicked = onFullScreenClicked
        }

        fun withIma(IIma: IIma) = apply {
            this.ima = IIma
        }

        fun build(): MCLSPlayer {
            val ctx = context
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
                ima = ima
            )

            lifecycle?.addObserver(mclsPlayer)

            return mclsPlayer
        }
    }
}