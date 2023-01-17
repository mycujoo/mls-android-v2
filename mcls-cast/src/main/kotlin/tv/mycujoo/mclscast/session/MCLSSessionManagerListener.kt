package tv.mycujoo.mclscast.session

import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.cast.framework.SessionManagerListener
import tv.mycujoo.mclscast.ISessionManagerListener

/**
 * Wrapper around session manager listener
 * @property sessionManagerListener listener to be dispatch cast event
 * @property casterSession active caster session
 */
class MCLSSessionManagerListener(
    private val sessionManagerListener: ISessionManagerListener,
    private val casterSession: CasterSession,
) : SessionManagerListener<CastSession> {
    override fun onSessionStarting(session: CastSession) {
        casterSession.castSession = session
    }

    override fun onSessionStarted(session: CastSession, sessionId: String) {
        casterSession.castSession = session
        sessionManagerListener.onSessionStarted(casterSession, sessionId)
    }

    override fun onSessionStartFailed(session: CastSession, error: Int) {
        casterSession.castSession = session
        sessionManagerListener.onSessionStartFailed(casterSession, error)
    }

    override fun onSessionResuming(session: CastSession, sessionId: String) {
        casterSession.castSession = session
    }

    override fun onSessionResumed(session: CastSession, wasSuspended: Boolean) {
        casterSession.castSession = session
        sessionManagerListener.onSessionResumed(casterSession, wasSuspended)
    }

    override fun onSessionResumeFailed(session: CastSession, error: Int) {
        casterSession.castSession = session
        sessionManagerListener.onSessionResumeFailed(casterSession, error)
    }

    override fun onSessionSuspended(session: CastSession, reason: Int) {
        casterSession.castSession = session
    }

    override fun onSessionEnding(session: CastSession) {
        casterSession.castSession = session
        sessionManagerListener.onSessionEnding(casterSession)
    }

    override fun onSessionEnded(session: CastSession, error: Int) {
        casterSession.castSession = session
        sessionManagerListener.onSessionEnded(casterSession, error)
    }
}