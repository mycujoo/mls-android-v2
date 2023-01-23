package tv.mycujoo.mclscast.manager

import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.cast.framework.SessionManagerListener
import com.google.android.gms.cast.framework.media.RemoteMediaClient
import tv.mycujoo.mclscast.widget.IRemotePlayerView
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclscore.logger.MessageLevel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CastSessionManager @Inject constructor(
    private val playerView: IRemotePlayerView?,
    private val castListenerManager: CastListenerManagerImpl,
    private val logger: Logger
) : SessionManagerListener<CastSession> {

    private var castSession: CastSession? = null

    private val progressListener = RemoteMediaClient.ProgressListener { progress, duration ->
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
        castListenerManager.getListeners().forEach {
            it.onSessionEnded(p1)
        }

        logger.log(MessageLevel.INFO, "onSessionEnded $p1")
    }

    override fun onSessionEnding(p0: CastSession) {
        castSession = p0
        castListenerManager.getListeners().forEach {
            it.onSessionEnding()
        }

        logger.log(MessageLevel.INFO, "onSessionEnding")
    }

    override fun onSessionResumeFailed(p0: CastSession, p1: Int) {
        castSession = p0
        castListenerManager.getListeners().forEach {
            it.onSessionResumeFailed(p1)
        }

        logger.log(MessageLevel.WARNING, "onSessionResumeFailed $p1")
    }

    override fun onSessionResumed(p0: CastSession, p1: Boolean) {
        castSession = p0
        castListenerManager.getListeners().forEach {
            it.onSessionResumed(p1)
        }

        logger.log(MessageLevel.INFO, "onSessionResumed $p1")
    }

    override fun onSessionResuming(p0: CastSession, p1: String) {
        castSession = p0
        castListenerManager.getListeners().forEach {
            it.onSessionResuming(p1)
        }

        logger.log(MessageLevel.INFO, "onSessionResuming $p1")
    }

    override fun onSessionStartFailed(p0: CastSession, p1: Int) {
        castSession = p0
        castListenerManager.getListeners().forEach {
            it.onSessionStartFailed(p1)
        }
        logger.log(MessageLevel.WARNING, "onSessionStartFailed $p1")
    }

    override fun onSessionStarted(p0: CastSession, p1: String) {
        castSession = p0
        castListenerManager.getListeners().forEach {
            it.onSessionStarted(p1)
        }
        logger.log(MessageLevel.INFO, "onSessionStarted $p1")
    }

    override fun onSessionStarting(p0: CastSession) {
        castSession = p0
        castListenerManager.getListeners().forEach {
            it.onSessionStarting()
        }
        logger.log(MessageLevel.INFO, "onSessionStarting")
    }

    override fun onSessionSuspended(p0: CastSession, p1: Int) {
        castSession = p0
        castListenerManager.getListeners().forEach {
            it.onSessionSuspended(p1)
        }
        logger.log(MessageLevel.INFO, "onSessionSuspended $p1")
    }
}
