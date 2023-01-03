package tv.mycujoo.mlsdata.network.socket

interface IBFFRTSocket {

    fun startSession(eventId: String, identityToken: String?)

    fun leaveCurrentSession()

    fun addListener(BFFRTCallback: BFFRTCallback)
}
