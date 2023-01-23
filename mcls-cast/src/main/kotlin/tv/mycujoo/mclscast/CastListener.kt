package tv.mycujoo.mclscast

open class CastListener {

    open fun onSessionEnded(error: Int) {
    }

    open fun onSessionEnding() {
    }

    fun onSessionResumeFailed(error: Int) {
    }

    fun onSessionResumed(wasSuspended: Boolean) {
    }

    fun onSessionResuming(sessionId: String) {
    }

    fun onSessionStartFailed(error: Int) {
    }

    fun onSessionStarted(sessionId: String) {
    }

    fun onSessionStarting() {
    }

    fun onSessionSuspended(reason: Int) {
    }
}
