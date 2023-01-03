package tv.mycujoo.mlsdata.network.socket

interface BFFRTCallback {

    fun onBadRequest(reason: String)

    fun onServerError()

    fun onLimitExceeded(allowedDevicesNumber: Int)
}
