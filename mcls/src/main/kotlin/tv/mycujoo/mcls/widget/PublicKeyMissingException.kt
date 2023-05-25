package tv.mycujoo.mcls.widget

class PublicKeyMissingException(
    private val errorMessage: String = "Public Key is missing, please set it before trying to play an event"
) : IllegalStateException(errorMessage) {
    override fun toString(): String {
        return errorMessage
    }
}