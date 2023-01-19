package tv.mycujoo.mclscast.widget

interface RemotePlayerEventListener {
    fun onPlay()
    fun onPause()
    fun onSeekTo(newPosition: Long)
    fun onFastForward(amount: Long)
    fun onRewind(amount: Long)
}