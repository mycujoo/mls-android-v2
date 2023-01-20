package tv.mycujoo.mclscast

import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.cast.framework.SessionManagerListener
import com.google.android.gms.cast.framework.media.RemoteMediaClient
import timber.log.Timber
import tv.mycujoo.mclscast.widget.IRemotePlayerView
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CastSessionWrapper @Inject constructor(
    private val playerView: IRemotePlayerView?,
) : SessionManagerListener<CastSession> {

    private var castSession: CastSession? = null

    private val progressListener = RemoteMediaClient.ProgressListener { progress, duration ->
        Timber.d("Tick $playerView ${System.currentTimeMillis()}")
        playerView?.setPosition(progress)
        playerView?.setDuration(duration)
        playerView?.setPlayStatus(
            castSession?.remoteMediaClient?.isPlaying == true
        )
    }

    fun getCurrentSession(): CastSession? {
        castSession?.remoteMediaClient?.addProgressListener(progressListener, 1000)
        return castSession
    }

    override fun onSessionEnded(p0: CastSession, p1: Int) {
        castSession = p0
        Timber.d("onSessionEnded $p1")
    }

    override fun onSessionEnding(p0: CastSession) {
        castSession = p0
        Timber.d("onSessionEnding")
    }

    override fun onSessionResumeFailed(p0: CastSession, p1: Int) {
        castSession = p0
        Timber.d("onSessionResumeFailed $p1")
    }

    override fun onSessionResumed(p0: CastSession, p1: Boolean) {
        castSession = p0
        Timber.d("onSessionResumed $p1")
    }

    override fun onSessionResuming(p0: CastSession, p1: String) {
        castSession = p0
        Timber.d("onSessionResuming $p1")
    }

    override fun onSessionStartFailed(p0: CastSession, p1: Int) {
        castSession = p0
        Timber.d("onSessionStartFailed $p1")
    }

    override fun onSessionStarted(p0: CastSession, p1: String) {
        castSession = p0
        Timber.d("onSessionStarted $p1")
    }

    override fun onSessionStarting(p0: CastSession) {
        castSession = p0
        Timber.d("onSessionStarting")
    }

    override fun onSessionSuspended(p0: CastSession, p1: Int) {
        castSession = p0
        Timber.d("onSessionSuspended $p1")
    }
}
