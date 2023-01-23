package tv.mycujoo.mclscast.manager

interface CastApplicationListener {

    fun onApplicationConnected()

    fun onApplicationDisconnected()
}