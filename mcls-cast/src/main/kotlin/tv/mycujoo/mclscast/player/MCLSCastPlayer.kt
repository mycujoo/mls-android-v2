package tv.mycujoo.mclscast.player

import androidx.lifecycle.DefaultLifecycleObserver
import com.google.android.gms.cast.MediaLoadOptions
import com.google.android.gms.cast.MediaSeekOptions
import com.google.android.gms.cast.framework.CastContext
import timber.log.Timber
import tv.mycujoo.mclscast.CastSessionWrapper
import tv.mycujoo.mclscast.helper.CustomDataBuilder
import tv.mycujoo.mclscast.helper.MediaInfoBuilder
import tv.mycujoo.mclscast.model.CasterLoadRemoteMediaParams
import javax.inject.Inject

class MCLSCastPlayer @Inject constructor(
    private val castSessionWrapper: CastSessionWrapper,
    private val castContext: CastContext,
) : RemotePlayer, DefaultLifecycleObserver {

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

        Timber.d("loadRemoteMedia: $customData")

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

        Timber.d("${castSessionWrapper.getCurrentSession()}")
        castSessionWrapper.getCurrentSession()?.remoteMediaClient?.load(mediaInfo, mediaLoadOptions)
    }

    override fun play() {
        castSessionWrapper.getCurrentSession()?.remoteMediaClient?.play()
    }

    override fun pause() {
        castSessionWrapper.getCurrentSession()?.remoteMediaClient?.pause()
    }

    override fun seekTo(position: Long) {
        val option = MediaSeekOptions.Builder()
            .setPosition(position)
            .build()
        castSessionWrapper.getCurrentSession()?.remoteMediaClient?.seek(option)
    }

    override fun fastForward(amount: Long) {
        val currentSession = castSessionWrapper.getCurrentSession() ?: return

        if (castSessionWrapper.getCurrentSession() == null) {
            currentSession.remoteMediaClient?.approximateStreamPosition
        }

        val currentPosition = currentSession.remoteMediaClient?.approximateStreamPosition ?: 0
        val newPosition = currentPosition + amount

        val option = MediaSeekOptions.Builder()
            .setPosition(newPosition)
            .build()

        castSessionWrapper.getCurrentSession()?.remoteMediaClient?.seek(option)
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
        castSessionWrapper.getCurrentSession()?.remoteMediaClient?.seek(option)
    }

    /**
     * Return current position, if remote media client is setup
     * @return current position
     */
    override fun currentPosition(): Long {
        return castSessionWrapper.getCurrentSession()?.remoteMediaClient?.approximateStreamPosition
            ?: -1
    }

    override fun streamDuration(): Long? {
        return castSessionWrapper.getCurrentSession()?.remoteMediaClient?.streamDuration
    }

    override fun isPlaying(): Boolean {
        return castSessionWrapper.getCurrentSession()?.remoteMediaClient?.isPlaying ?: false
    }

    override fun release() {
        castContext.sessionManager.endCurrentSession(true)
    }
}