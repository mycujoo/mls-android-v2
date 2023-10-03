package tv.mycujoo.mclsnetwork.util

data class KeyStore(
    var key: String?
) {
    override fun toString(): String {
        return key ?: ""
    }
}
