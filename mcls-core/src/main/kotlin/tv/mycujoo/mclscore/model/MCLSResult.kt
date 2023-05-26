package tv.mycujoo.mclscore.model

/**
 * A crash safe wrapper to a result that uses when to infer the status of the result
 *
 * @sample
 *
 * val result = MCLSResult.Success(5)
 *
 * when (result) {
 *      is MCLSResult.Success -> {
 *          // Do Things
 *      }
 *      is MCLSResult.NetworkError -> {
 *          // React by retrying or informing the user
 *      }
 *      is MCLSResult.GenericError -> {
 *          // React to code execution errors
 *      }
 * }
 */
sealed class MCLSResult<out E, out V> {

    data class Success<out V>(val value: V) : MCLSResult<Nothing, V>()
    data class NetworkError<out E>(val error: E) : MCLSResult<E, Nothing>()
    data class GenericError(val errorCode: Int, val errorMessage: String) : MCLSResult<Nothing, Nothing>()

}