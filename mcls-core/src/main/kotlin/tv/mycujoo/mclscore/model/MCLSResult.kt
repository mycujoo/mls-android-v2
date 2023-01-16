package tv.mycujoo.mclscore.model

sealed class MCLSResult<out E, out V> {

    data class Success<out V>(val value: V) : MCLSResult<Nothing, V>()
    data class NetworkError<out E>(val error: E) : MCLSResult<E, Nothing>()
    data class GenericError(val errorCode: Int, val errorMessage: String) : MCLSResult<Nothing, Nothing>()

}