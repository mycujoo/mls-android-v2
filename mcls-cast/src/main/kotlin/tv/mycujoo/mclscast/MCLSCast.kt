package tv.mycujoo.mclscast

import android.os.Build
import androidx.core.os.ConfigurationCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.mediarouter.app.MediaRouteButton
import com.google.android.gms.cast.framework.CastButtonFactory
import com.google.android.gms.cast.framework.CastContext
import com.google.android.gms.cast.framework.CastSession
import tv.mycujoo.mclscast.config.CastPlayerConfig
import tv.mycujoo.mclscast.di.DaggerMCLSCastComponent
import tv.mycujoo.mclscast.manager.*
import tv.mycujoo.mclscast.model.CasterLoadRemoteMediaParams
import tv.mycujoo.mclscast.player.CastPlayer
import tv.mycujoo.mclscast.widget.IRemotePlayerView
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclscore.model.MCLSEvent
import java.util.concurrent.Executors
import javax.inject.Inject

class MCLSCast private constructor(
    mediaRouteButton: MediaRouteButton,
    appId: String,
    var publicKey: String,
    var pseudoUserId: String,
    var identityToken: String,
    val castPlayerConfig: CastPlayerConfig,
    private var castContext: CastContext,
    private val remotePlayerView: IRemotePlayerView?,
) : DefaultLifecycleObserver {

    @Inject
    lateinit var castPlayer: CastPlayer

    @Inject
    lateinit var castSessionManager: CastSessionManager

    @Inject
    lateinit var castListenerManager: CastListenerManager

    @Inject
    lateinit var logger: Logger

    private val context = mediaRouteButton.context

    private var currentEvent: MCLSEvent? = null

    init {
        DaggerMCLSCastComponent.builder()
            .bindAppId(appId)
            .bindMediaRouteButton(mediaRouteButton)
            .bindCastContext(castContext)
            .bindRemotePlayerView(remotePlayerView)
            .build()
            .inject(this)

        remotePlayerView?.attachPlayer(castPlayer)
    }

    fun setLogLevel(logLevel: LogLevel) {
        logger.setLogLevel(logLevel)
    }

    fun addListener(castSessionListener: CastSessionListener) {
        castListenerManager.addCastListener(castSessionListener)
    }

    fun addListener(castApplicationListener: CastApplicationListener) {
        castListenerManager.addCastListener(castApplicationListener)
    }

    fun removeListener(castApplicationListener: CastApplicationListener) {
        castListenerManager.removeCastListener(castApplicationListener)
    }

    fun removeListener(castSessionListener: CastSessionListener) {
        castListenerManager.removeCastListener(castSessionListener)
    }

    fun playEvent(event: MCLSEvent, playWhenReady: Boolean = true, position: Long = 0) {
        if (currentEvent?.id != event.id) {
            remotePlayerView?.clearDialogs()

            if (castPlayerConfig.enableControls) {
                remotePlayerView?.showController()
            } else {
                remotePlayerView?.hideController()
            }
        }

        when (event.streamStatus()) {
            StreamStatus.NO_STREAM_URL -> {
                castPlayer.release()
                remotePlayerView?.showPreEventInformationDialog()
            }
            StreamStatus.PLAYABLE -> {
                val config = context.resources.configuration

                val locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    config.locales[0]
                } else {
                    ConfigurationCompat.getLocales(config)[0]
                }

                remotePlayerView?.setEventInfo(
                    event.title,
                    event.description,
                    event.getFormattedStartTimeDate(locale)
                )

                playEventInCast(
                    event = event,
                    playWhenReady = playWhenReady,
                    position = position
                )
            }
            StreamStatus.GEOBLOCKED -> {
                castPlayer.release()
                remotePlayerView?.showCustomInformationDialog(
                    context.getString(R.string.message_geoblocked_stream)
                )
            }
            StreamStatus.NO_ENTITLEMENT -> {
                castPlayer.release()
                remotePlayerView?.showCustomInformationDialog(
                    context.getString(R.string.message_no_entitlement_stream)
                )
            }
            StreamStatus.UNKNOWN_ERROR -> {
                castPlayer.release()
                remotePlayerView?.showPreEventInformationDialog()
            }
        }
    }

    private fun playEventInCast(event: MCLSEvent, position: Long = 0, playWhenReady: Boolean = true) {
        val params = if (event.isMLS) {
            CasterLoadRemoteMediaParams(
                id = event.id,
                publicKey = publicKey,
                pseudoUserId = pseudoUserId,
                title = event.title,
                thumbnailUrl = event.thumbnailUrl ?: "",
                isPlaying = castPlayer.isPlaying() || playWhenReady,
                currentPosition = castPlayer.currentPosition() ?: 0,
                identityToken = identityToken,
            )
        } else {
            CasterLoadRemoteMediaParams(
                id = event.id,
                customPlaylistUrl = event.streams[0].fullUrl,
                title = event.title,
                thumbnailUrl = event.thumbnailUrl ?: "",
                isPlaying = castPlayer.isPlaying() || playWhenReady,
                currentPosition = castPlayer.currentPosition() ?: 0
            )
        }

        castPlayer.loadRemoteMedia(params)
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)

        castContext.sessionManager.addSessionManagerListener(
            castSessionManager, CastSession::class.java
        )
    }

    class Builder {

        private lateinit var appId: String
        private lateinit var castButton: MediaRouteButton
        private lateinit var publicKey: String
        private var identityToken = ""
        private var pseudoUserId = ""
        private var lifecycle: Lifecycle? = null
        private var remotePlayerView: IRemotePlayerView? = null
        private var castPlayerConfig: CastPlayerConfig = CastPlayerConfig.default()

        fun withAppId(appId: String) = apply {
            this.appId = appId
        }

        fun withMediaButton(castButton: MediaRouteButton) = apply {
            this.castButton = castButton
        }

        fun withPublicKey(publicKey: String) = apply {
            this.publicKey = publicKey
        }

        fun withLifecycle(lifecycle: Lifecycle) = apply {
            this.lifecycle = lifecycle
        }

        fun withFragment(fragment: Fragment) = apply {
            this.lifecycle = fragment.lifecycle
        }

        fun withActivity(fragmentActivity: FragmentActivity) = apply {
            this.lifecycle = fragmentActivity.lifecycle
        }

        fun withIdentityToken(identityToken: String) = apply {
            this.identityToken = identityToken
        }

        fun withPseudoUserId(pseudoUserId: String) = apply {
            this.pseudoUserId = pseudoUserId
        }

        fun withRemotePlayerView(remotePlayerView: IRemotePlayerView) = apply {
            this.remotePlayerView = remotePlayerView
        }

        fun withCastPlayerConfig(castPlayerConfig: CastPlayerConfig) = apply {
            this.castPlayerConfig = castPlayerConfig
        }

        fun build(onSuccess: (MCLSCast) -> Unit) {
            CastButtonFactory.setUpMediaRouteButton(castButton.context, castButton)

            CastContext.getSharedInstance(
                castButton.context,
                Executors.newSingleThreadExecutor()
            ).addOnSuccessListener { castContext ->
                castContext.setReceiverApplicationId(appId)

                val cast = MCLSCast(
                    mediaRouteButton = castButton,
                    appId = appId,
                    publicKey = publicKey,
                    pseudoUserId = pseudoUserId,
                    identityToken = identityToken,
                    castContext = castContext,
                    remotePlayerView = remotePlayerView,
                    castPlayerConfig = castPlayerConfig
                )

                lifecycle?.addObserver(cast)

                onSuccess(cast)
            }
        }
    }
}