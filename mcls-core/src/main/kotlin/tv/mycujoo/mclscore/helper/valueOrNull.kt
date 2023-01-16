package tv.mycujoo.mclscore.helper

import tv.mycujoo.mclscore.model.MCLSResult

fun <Param : Any> MCLSResult<Exception, Param>.valueOrNull(): Param? {
    return when (this) {
        is MCLSResult.GenericError -> null
        is MCLSResult.NetworkError -> null
        is MCLSResult.Success -> this.value
    }
}