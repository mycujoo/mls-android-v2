package tv.mycujoo.mclscast

import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.cast.framework.SessionManagerListener
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CastSessionWrapper @Inject constructor() : SessionManagerListener<CastSession> {

    private var castSession: CastSession? = null

    fun getCurrentSession(): CastSession? {
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