package tv.mycujoo.mlsdata.domain.repository

import retrofit2.HttpException
import timber.log.Timber
import tv.mycujoo.mclscore.model.Result
import java.io.IOException

abstract class AbstractRepository {
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<Exception, T> {

        return try {
            Result.Success(apiCall.invoke())
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
                    return Result.GenericError(
                        code,
                        throwable.message()
                    )

                }
                is IOException -> {
                    // Network Error
                    Result.NetworkError(throwable)
                }
                else -> {
                    Result.NetworkError(Exception(throwable))
                }
            }
        }
    }
}