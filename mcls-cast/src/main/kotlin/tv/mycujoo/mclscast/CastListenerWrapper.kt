package tv.mycujoo.mclscast

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CastListenerWrapper @Inject constructor(){

    @get:Synchronized
    private val castListeners = mutableSetOf<CastListener>()

    fun addCastListeners(castListener: CastListener) {
        castListeners.add(castListener)
    }

    fun remoteCastListener(castListener: CastListener) {
        castListeners.remove(castListener)
    }

    fun getListeners(): List<CastListener> {
        return castListeners.toList()
    }
}