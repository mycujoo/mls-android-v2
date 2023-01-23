package tv.mycujoo.mclscast.player

import androidx.lifecycle.DefaultLifecycleObserver
import com.google.android.gms.cast.MediaLoadOptions
import com.google.android.gms.cast.MediaSeekOptions
import com.google.android.gms.cast.framework.CastContext
import tv.mycujoo.mclscast.manager.CastSessionManager
import tv.mycujoo.mclscast.helper.CustomDataBuilder
import tv.mycujoo.mclscast.helper.MediaInfoBuilder
import tv.mycujoo.mclscast.model.CasterLoadRemoteMediaParams
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclscore.logger.MessageLevel
import javax.inject.Inject

class MCLSCastPlayer @Inject constructor(
    private val castSessionManager: CastSessionManager,
    private val castContext: CastContext,
    private val logger: Logger,
) : CastPlayer, DefaultLifecycleObserver {

    override fun loadRemoteMedia(params: CasterLoadRemoteMediaParams) {
        val customData = params.customPlaylistUrl?.let {
            CustomDataBuilder.build(
                it
            )
        } ?: CustomDataBuilder.build(
            params.id,
            params.publicKey,
            params.pseudoUserId,
            params.identityToken
        )

        logger.log(MessageLevel.INFO, "loadRemoteMedia: $customData")

        val mediaInfo = MediaInfoBuilder.build(
            "",
            params.title,
            params.thumbnailUrl,
            customData
        )

        val mediaLoadOptions: MediaLoadOptions = MediaLoadOptions
            .Builder()
            .setAutoplay(params.isPlaying)
            .setPlayPosition(params.currentPosition)
            .build()

        logger.log(MessageLevel.INFO, "${castSessionManager.getCurrentSession()}")
        castSessionManager.getCurrentSession()?.remoteMediaClient?.load(mediaInfo, mediaLoadOptions)
    }

    override fun play() {
        castSessionManager.getCurrentSession()?.remoteMediaClient?.play()
    }

    override fun pause() {
        castSessionManager.getCurrentSession()?.remoteMediaClient?.pause()
    }

    override fun seekTo(position: Long) {
        val option = MediaSeekOptions.Builder()
            .setPosition(position)
            .build()
        castSessionManager.getCurrentSession()?.remoteMediaClient?.seek(option)
    }

    override fun fastForward(amount: Long) {
        val currentSession = castSessionManager.getCurrentSession() ?: return

        if (castSessionManager.getCurrentSession() == null) {
            currentSession.remoteMediaClient?.approximateStreamPosition
        }

        val currentPosition = currentSession.remoteMediaClient?.approximateStreamPosition ?: 0
        val newPosition = currentPosition + amount

        val option = MediaSeekOptions.Builder()
            .setPosition(newPosition)
            .build()

        castSessionManager.getCurrentSession()?.remoteMediaClient?.seek(option)
    }

    /**
     * Rewind by given amount
     * @param amount
     */
    override fun rewind(amount: Long) {
        val position = currentPosition()
        val newPosition = if (position - amount < 0) {
            0
        } else {
            position - amount
        }
        val option = MediaSeekOptions.Builder()
            .setPosition(newPosition)
            .build()
        castSessionManager.getCurrentSession()?.remoteMediaClient?.seek(option)
    }

    /**
     * Return current position, if remote media client is setup
     * @return current position
     */
    override fun currentPosition(): Long {
        return castSessionManager.getCurrentSession()?.remoteMediaClient?.approximateStreamPosition
            ?: -1
    }

    override fun streamDuration(): Long? {
        return castSessionManager.getCurrentSession()?.remoteMediaClient?.streamDuration
    }

    override fun isPlaying(): Boolean {
        return castSessionManager.getCurrentSession()?.remoteMediaClient?.isPlaying ?: false
    }

    override fun release() {
        castContext.sessionManager.endCurrentSession(true)
    }
}