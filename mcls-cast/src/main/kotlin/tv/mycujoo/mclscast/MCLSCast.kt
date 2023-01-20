package tv.mycujoo.mclscast

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.mediarouter.app.MediaRouteButton
import com.google.android.gms.cast.framework.CastButtonFactory
import com.google.android.gms.cast.framework.CastContext
import com.google.android.gms.cast.framework.CastSession
import timber.log.Timber
import tv.mycujoo.mclscast.di.DaggerMCLSCastComponent
import tv.mycujoo.mclscast.model.CasterLoadRemoteMediaParams
import tv.mycujoo.mclscast.player.RemotePlayer
import tv.mycujoo.mclscast.widget.IRemotePlayerView
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.model.EventEntity
import java.util.concurrent.Executors
import javax.inject.Inject

class MCLSCast private constructor(
    mediaRouteButton: MediaRouteButton,
    appId: String,
    var publicKey: String,
    var pseudoUserId: String,
    var identityToken: String,
    private var castContext: CastContext,
    private val remotePlayerView: IRemotePlayerView?,
) : DefaultLifecycleObserver {

    @Inject
    lateinit var remotePlayer: RemotePlayer

    @Inject
    lateinit var castSessionWrapper: CastSessionWrapper

    private val context = mediaRouteButton.context

    init {
        DaggerMCLSCastComponent.builder()
            .bindAppId(appId)
            .bindMediaRouteButton(mediaRouteButton)
            .bindCastContext(castContext)
            .bindRemotePlayerView(remotePlayerView)
            .build()
            .inject(this)

        castSessionWrapper.getCurrentSession()?.remoteMediaClient
    }

    fun playEvent(event: EventEntity, playWhenReady: Boolean = true) {
        when(event.streamStatus()) {
            StreamStatus.NO_STREAM_URL -> {
                remotePlayerView?.showPreEventInformationDialog()
            }
            StreamStatus.PLAYABLE -> {
                playEventInCast(event, playWhenReady)
            }
            StreamStatus.GEOBLOCKED -> {
                remotePlayerView?.showCustomInformationDialog(
                    context.getString(R.string.message_geoblocked_stream)
                )
            }
            StreamStatus.NO_ENTITLEMENT -> {
                remotePlayerView?.showCustomInformationDialog(
                    context.getString(R.string.message_no_entitlement_stream)
                )
            }
            StreamStatus.UNKNOWN_ERROR -> {
                remotePlayerView?.showPreEventInformationDialog()
            }
        }
    }

    private fun playEventInCast(event: EventEntity, playWhenReady: Boolean = true) {
        val params = if (event.isMLS) {
            CasterLoadRemoteMediaParams(
                id = event.id,
                publicKey = publicKey,
                pseudoUserId = pseudoUserId,
                title = event.title,
                thumbnailUrl = event.thumbnailUrl ?: "",
                isPlaying = remotePlayer.isPlaying() || playWhenReady,
                currentPosition = remotePlayer.currentPosition() ?: 0,
                identityToken = identityToken,
            )
        } else {
            CasterLoadRemoteMediaParams(
                id = event.id,
                customPlaylistUrl = event.streams[0].fullUrl,
                title = event.title,
                thumbnailUrl = event.thumbnailUrl ?: "",
                isPlaying = remotePlayer.isPlaying() || playWhenReady,
                currentPosition = remotePlayer.currentPosition() ?: 0
            )
        }

        remotePlayer.loadRemoteMedia(params)
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)

        castContext.sessionManager.addSessionManagerListener(
            castSessionWrapper, CastSession::class.java
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

        fun build(onSuccess: (MCLSCast) -> Unit) {
            CastButtonFactory.setUpMediaRouteButton(castButton.context, castButton)

            CastContext.getSharedInstance(
                castButton.context,
                Executors.newSingleThreadExecutor()
            ).addOnSuccessListener { castContext ->
                Timber.d("$lifecycle")
                castContext.setReceiverApplicationId(appId)

                val cast = MCLSCast(
                    mediaRouteButton = castButton,
                    appId = appId,
                    publicKey = publicKey,
                    pseudoUserId = pseudoUserId,
                    identityToken = identityToken,
                    castContext = castContext,
                    remotePlayerView = remotePlayerView
                )

                lifecycle?.addObserver(cast)

                onSuccess(cast)
            }
        }
    }
}