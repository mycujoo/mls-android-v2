package tv.mycujoo.mclsplayer.player

import android.app.Activity
import android.content.Context
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.ExoPlayer
import timber.log.Timber
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclsima.IIma
import tv.mycujoo.mclsplayer.R
import tv.mycujoo.mclsplayer.player.analytics.YouboraAnalyticsClient
import tv.mycujoo.mclsplayer.player.di.DaggerMCLSPlayerComponent
import tv.mycujoo.mclsplayer.player.di.IdentityToken
import tv.mycujoo.mclsplayer.player.di.PublicKey
import tv.mycujoo.mclsplayer.player.ima.IImaContainer
import tv.mycujoo.mclsplayer.player.mediator.VideoPlayerMediator
import tv.mycujoo.mclsplayer.player.player.Player
import tv.mycujoo.mclsplayer.player.user.UserPrefs
import tv.mycujoo.mclsplayer.player.utils.ExoPlayerContainer
import tv.mycujoo.mclsplayer.player.utils.KeyStore
import tv.mycujoo.mclsplayer.player.widget.IMCLSPlayerView
import tv.mycujoo.mclsplayercore.config.VideoPlayerConfig
import javax.inject.Inject

interface MCLSPlayer : DefaultLifecycleObserver {
    val player: Player

    fun playEvent(event: MCLSEvent, defaultStreamId: String? = null)

    fun setInFullScreen(onFullScreen: Boolean)

    fun setOnFullScreenClicked(onClick: () -> Unit)

    fun setOnPictureInPictureClicked(onClick: () -> Unit)

    fun setUserId(userId: String)

    fun setPseudoUserId(pseudoUserId: String)

    fun setIma(ima: IIma)

    fun setConfig(config: VideoPlayerConfig)

    fun setPublicKey(publicKey: String)

    fun setIdentityToken(identityToken: String)

    class Builder {

        @Inject
        lateinit var videoPlayerMediator: VideoPlayerMediator

        @Inject
        lateinit var player: Player

        @Inject
        lateinit var imaContainer: IImaContainer

        @Inject
        lateinit var playerUser: UserPrefs

        @Inject
        lateinit var youboraAnalyticsClient: YouboraAnalyticsClient

        @Inject
        @IdentityToken
        lateinit var identityTokenStore: KeyStore

        @Inject
        @PublicKey
        lateinit var publicKeyStore: KeyStore

        private var context: Context? = null
        private var exoPlayerContainer: ExoPlayerContainer? = null
        private var mclsPlayerView: IMCLSPlayerView? = null
        private var lifecycle: Lifecycle? = null
        private var activity: Activity? = null

        private var userId: String? = null
        private var pseudoUserId: String? = null

        private var publicKey: String? = null
        private var identityToken: String? = null

        private var analyticsEnabled = true

        private var youboraAccountCode: String? = null

        private var videoPlayerConfig = VideoPlayerConfig.default()

        private var ima: IIma? = null

        fun withContext(context: Context) = apply {
            this.context = context
        }

        fun withActivity(activity: Activity) = apply {
            this.activity = activity
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

        fun withPublicKey(publicKey: String) = apply {
            this.publicKey = publicKey
        }

        fun withIdentityToken(identityToken: String) = apply {
            this.identityToken = identityToken
        }

        fun withUserId(userId: String) = apply {
            this.userId = userId
        }

        fun withPseudoUserId(pseudoUserId: String) = apply {
            this.pseudoUserId = pseudoUserId
        }

        fun withAnalyticsDisabled() {
            analyticsEnabled = false
        }

        fun withIma(IIma: IIma) = apply {
            this.ima = IIma
        }

        fun build(): MCLSPlayer {
            val ctx = context
                ?: throw IllegalArgumentException("Please use withContext before building this component")

            val activity = activity
                ?: throw IllegalArgumentException("Please use withActivity before building this component")

            val playerView = mclsPlayerView
                ?: throw IllegalArgumentException("Please use withPlayerView before building this component")

            val exoPlayerContainer = exoPlayerContainer ?: run {
                val exoPlayer = ExoPlayer.Builder(ctx).build()
                ExoPlayerContainer(exoPlayer)
            }

            val component = DaggerMCLSPlayerComponent.builder()
                .bindContext(ctx)
                .bindExoPlayerContainer(exoPlayerContainer)
                .bindMCLSPlayerView(playerView)
                .bindIma(ima)
                .bindYouboraAccountCode(
                    youboraAccountCode ?: ctx.getString(R.string.youbora_account_code)
                )
                .bindLogLevel(logLevel = LogLevel.MINIMAL)
                .bindActivity(activity)
                .bindPublicKey(KeyStore(publicKey) )
                .bindIdentityToken(KeyStore(identityToken))
                .build()

            component.inject(this)

            if (analyticsEnabled) {
                youboraAnalyticsClient.initialize()
            }

            val mclsPlayer = MCLSPlayerImpl(
                playerView = playerView,
                exoPlayerContainer = exoPlayerContainer,
                context = ctx,
                videoPlayerConfig = videoPlayerConfig,
                imaContainer = imaContainer,
                videoPlayerMediator = videoPlayerMediator,
                player = player,
                playerUser = playerUser,
                identityTokenStore = identityTokenStore,
                publicKeyStore = publicKeyStore,
            )

            userId?.let {
                playerUser.setUserId(it)
            }

            pseudoUserId?.let {
                playerUser.setPseudoUserId(it)
            }

            lifecycle?.addObserver(mclsPlayer)

            return mclsPlayer
        }
    }
}

class MCLSPlayerImpl internal constructor(
    private val playerView: IMCLSPlayerView,
    private val exoPlayerContainer: ExoPlayerContainer,
    private val context: Context,
    private val imaContainer: IImaContainer,
    private val videoPlayerMediator: VideoPlayerMediator,
    videoPlayerConfig: VideoPlayerConfig,
    override val player: Player,
    var playerUser: UserPrefs,
    @PublicKey val publicKeyStore: KeyStore,
    @IdentityToken val identityTokenStore: KeyStore
) : MCLSPlayer {

    init {
        playerView.config(videoPlayerConfig)
        videoPlayerMediator.setConfig(videoPlayerConfig)
        playerView.setPlayer(player)

        createExoPlayerIfNotPresent()
    }

    override fun setIma(ima: IIma) {
        imaContainer.ima = ima
    }

    override fun setConfig(config: VideoPlayerConfig) {
        playerView.config(config)
        videoPlayerMediator.setConfig(config)
    }

    fun replaceExoPlayerInstance(exoPlayer: ExoPlayer) {
        if (exoPlayerContainer.exoPlayer != null) {
            exoPlayerContainer.exoPlayer?.pause()
            exoPlayerContainer.exoPlayer?.release()
            exoPlayerContainer.exoPlayer = null
        }

        exoPlayerContainer.exoPlayer = exoPlayer
    }

    override fun playEvent(event: MCLSEvent, defaultStreamId: String?) {
        videoPlayerMediator.playEvent(event, defaultStreamId)
    }

    override fun setInFullScreen(onFullScreen: Boolean) {
        playerView.setInFullScreen(onFullScreen)
    }

    override fun setOnFullScreenClicked(onClick: () -> Unit) {
        playerView.setOnFullScreenClicked(onClick)
    }

    override fun setOnPictureInPictureClicked(onClick: () -> Unit) {
        playerView.setOnPictureInPictureClicked(onClick)
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


    override fun setUserId(userId: String) {
        playerUser.setUserId(userId)
    }

    override fun setPseudoUserId(pseudoUserId: String) {
        playerUser.setPseudoUserId(pseudoUserId)
    }

    override fun setPublicKey(publicKey: String) {
        publicKeyStore.key = publicKey
    }

    override fun setIdentityToken(identityToken: String) {
        identityTokenStore.key = identityToken
    }
}