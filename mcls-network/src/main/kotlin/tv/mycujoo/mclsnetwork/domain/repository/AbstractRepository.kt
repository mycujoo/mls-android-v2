package tv.mycujoo.mclsnetwork.domain.repository

import retrofit2.HttpException
import timber.log.Timber
import tv.mycujoo.mclscore.model.MCLSResult
import java.io.IOException

abstract class AbstractRepository {
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): MCLSResult<Exception, T> {

        return try {
            MCLSResult.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is HttpException -> {
                    val code = throwable.code()
                    Timber.e(
                        "safeApiCall: $code \n\n\n" +
                                "${throwable.response()?.body()} \n" +
                                "${throwable.response()?.headers()} \n" +
                                "${throwable.response()?.raw()} \n"
                    )
                    return MCLSResult.GenericError(
                        code,
                        throwable.message()
                    )

                }
                is IOException -> {
                    // Network Error
                    MCLSResult.NetworkError(throwable)
                }
                else -> {
                    MCLSResult.NetworkError(Exception(throwable))
                }
            }
        }
    }
}