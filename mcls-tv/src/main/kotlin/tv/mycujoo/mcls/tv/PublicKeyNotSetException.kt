package tv.mycujoo.mcls.tv

class PublicKeyNotSetException(
    msg: String = "Please set public key before trying to play it by eventId"
): IllegalStateException(msg)