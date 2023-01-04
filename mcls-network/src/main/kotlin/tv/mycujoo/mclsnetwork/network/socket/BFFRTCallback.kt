package tv.mycujoo.mclsnetwork.network.socket

interface BFFRTCallback {

    fun onBadRequest(reason: String)

    fun onServerError()

    fun onLimitExceeded(allowedDevicesNumber: Int)
}
