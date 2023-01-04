package tv.mycujoo.mclsnetwork.network.socket

interface IBFFRTSocket {

    fun startSession(eventId: String, identityToken: String?)

    fun leaveCurrentSession()

    fun addListener(BFFRTCallback: BFFRTCallback)
}
