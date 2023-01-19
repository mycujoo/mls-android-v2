package tv.mycujoo.mclscast

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.mediarouter.app.MediaRouteButton
import com.google.android.gms.cast.framework.CastButtonFactory
import com.google.android.gms.cast.framework.CastContext
import com.google.android.gms.cast.framework.CastSession
import tv.mycujoo.mclscast.di.DaggerMCLSCastComponent
import tv.mycujoo.mclscast.model.CasterLoadRemoteMediaParams
import tv.mycujoo.mclscast.player.RemotePlayer
import tv.mycujoo.mclscore.model.EventEntity
import javax.inject.Inject

class MCLSCast private constructor(
    mediaRouteButton: MediaRouteButton,
    appId: String,
    var publicKey: String,
    var pseudoUserId: String,
    var identityToken: String,
    private var castContext: CastContext,
) : DefaultLifecycleObserver {

    @Inject
    lateinit var remotePlayer: RemotePlayer

    @Inject
    lateinit var castSessionWrapper: CastSessionWrapper

    init {
        castContext.setReceiverApplicationId(appId)
        CastButtonFactory.setUpMediaRouteButton(mediaRouteButton.context, mediaRouteButton)

        DaggerMCLSCastComponent.builder()
            .bindAppId(appId)
            .bindMediaRouteButton(mediaRouteButton)
            .bindCastContext(castContext)
            .build()
            .inject(this)
    }

    fun playEvent(event: EventEntity, playWhenReady: Boolean = true) {
        val params = if (event.isNativeMLS) {
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
        private lateinit var castContext: CastContext

        fun withAppId(appId: String) = apply {
            this.appId = appId
        }

        fun withMediaButton(castButton: MediaRouteButton) = apply {
            this.castButton = castButton
        }

        fun withPublicKey(publicKey: String) = apply {
            this.publicKey = publicKey
        }

        fun withIdentityToken(identityToken: String) = apply {
            this.identityToken = identityToken
        }

        fun withPseudoUserId(pseudoUserId: String) = apply {
            this.pseudoUserId = pseudoUserId
        }

        fun withCastContext(castContext: CastContext) = apply {
            this.castContext = castContext
        }

        fun build(): MCLSCast {

            return MCLSCast(
                mediaRouteButton = castButton,
                appId = appId,
                publicKey = publicKey,
                pseudoUserId = pseudoUserId,
                identityToken = identityToken,
                castContext = castContext,
            )
        }
    }
}