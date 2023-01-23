package tv.mycujoo.mclscast.manager

interface CastListenerManager {
    fun addCastListener(castSessionListener: CastSessionListener)

    fun addCastListener(castApplicationListener: CastApplicationListener)

    fun removeCastListener(castSessionListener: CastSessionListener)

    fun removeCastListener(castApplicationListener: CastApplicationListener)

    fun getListeners(): List<CastSessionListener>
}