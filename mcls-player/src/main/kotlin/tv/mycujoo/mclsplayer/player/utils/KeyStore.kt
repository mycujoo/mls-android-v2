package tv.mycujoo.mclsplayer.player.utils

data class KeyStore(
    var key: String?
) {
    override fun toString(): String {
        return key ?: ""
    }
}