package tv.mycujoo.mclscast.manager

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CastListenerManagerImpl @Inject constructor() : CastListenerManager {

    @get:Synchronized
    private val castSessionListeners = mutableMapOf<Int, CastSessionListener>()

    override fun addCastListener(castSessionListener: CastSessionListener) {
        castSessionListeners[castSessionListener.hashCode()] = castSessionListener
    }

    override fun removeCastListener(castSessionListener: CastSessionListener) {
        castSessionListeners.remove(castSessionListener.hashCode())
    }

    override fun removeCastListener(castApplicationListener: CastApplicationListener) {
        castSessionListeners.remove(castApplicationListener.hashCode())
    }

    override fun addCastListener(castApplicationListener: CastApplicationListener) {
        val listener = object : CastSessionListener() {
            override fun onSessionResuming(sessionId: String) {
                super.onSessionResuming(sessionId)

                castApplicationListener.onApplicationConnected()
            }

            override fun onSessionResumed(wasSuspended: Boolean) {
                super.onSessionResumed(wasSuspended)

                castApplicationListener.onApplicationConnected()
            }

            override fun onSessionStarted(sessionId: String) {
                super.onSessionStarted(sessionId)

                castApplicationListener.onApplicationConnected()
            }

            override fun onSessionStartFailed(error: Int) {
                super.onSessionStartFailed(error)

                castApplicationListener.onApplicationDisconnected()
            }

            override fun onSessionResumeFailed(error: Int) {
                super.onSessionResumeFailed(error)

                castApplicationListener.onApplicationDisconnected()
            }

            override fun onSessionEnded(code: Int) {
                super.onSessionEnded(code)

                castApplicationListener.onApplicationDisconnected()
            }
        }

        castSessionListeners[listener.hashCode()] = listener
    }

    override fun getListeners(): List<CastSessionListener> {
        return castSessionListeners.values.toList()
    }
}