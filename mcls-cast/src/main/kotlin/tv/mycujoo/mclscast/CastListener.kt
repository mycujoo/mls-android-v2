package tv.mycujoo.mclscast

open class CastListener {

    open fun onSessionEnded(error: Int) {
    }

    open fun onSessionEnding() {
    }

    open fun onSessionResumeFailed(error: Int) {
    }

    open fun onSessionResumed(wasSuspended: Boolean) {
    }

    open fun onSessionResuming(sessionId: String) {
    }

    open fun onSessionStartFailed(error: Int) {
    }

    open fun onSessionStarted(sessionId: String) {
    }

    open fun onSessionStarting() {
    }

    open fun onSessionSuspended(reason: Int) {
    }
}
