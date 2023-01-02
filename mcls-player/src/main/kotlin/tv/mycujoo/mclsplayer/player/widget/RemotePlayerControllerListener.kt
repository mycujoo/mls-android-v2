package tv.mycujoo.mclsplayer.player.widget

interface RemotePlayerControllerListener {
    fun onPlay()
    fun onPause()
    fun onSeekTo(newPosition: Long)
    fun onFastForward(amount: Long)
    fun onRewind(amount: Long)
}