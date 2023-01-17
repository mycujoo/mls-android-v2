package tv.mycujoo.mclscast.widget

interface RemotePlayerControllerListener {
    fun onPlay()
    fun onPause()
    fun onSeekTo(newPosition: Long)
    fun onFastForward(amount: Long)
    fun onRewind(amount: Long)
}