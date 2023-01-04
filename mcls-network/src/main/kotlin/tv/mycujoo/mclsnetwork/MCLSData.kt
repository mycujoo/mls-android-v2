package tv.mycujoo.mclsnetwork

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber
import tv.mycujoo.mcls.enum.C
import tv.mycujoo.mclscore.model.Action
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.model.Result
import tv.mycujoo.mclsnetwork.data.IDataManager
import tv.mycujoo.mclsnetwork.di.DaggerMCLSDataComponent
import tv.mycujoo.mclsnetwork.enum.LogLevel
import tv.mycujoo.mclsnetwork.enum.MessageLevel
import tv.mycujoo.mclsnetwork.manager.IPrefManager
import tv.mycujoo.mclsnetwork.manager.Logger
import tv.mycujoo.mclsnetwork.network.socket.IBFFRTSocket
import tv.mycujoo.mclsnetwork.network.socket.IReactorSocket
import javax.inject.Inject

class MCLSData private constructor(
    logLevel: LogLevel,
    private val prefManager: IPrefManager,
    private val logger: Logger,
    private val dataManager: IDataManager,
    val reactorSocket: IReactorSocket,
    val bffRtSocket: IBFFRTSocket,
) {

    companion object {
        fun builder(): Builder = Builder()
    }

    init {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        logger.setLogLevel(logLevel)
    }

    fun setIdentityToken(identityToken: String) {
        prefManager.persist(C.IDENTITY_TOKEN_PREF_KEY, identityToken)
    }

    fun setPublicKey(publicKey: String) {
        prefManager.persist(C.PUBLIC_KEY_PREF_KEY, publicKey)
    }

    suspend fun getEventDetails(eventId: String): Flow<EventEntity> {
        return flow {
            val result = dataManager
                .getEventDetails(eventId)

            when (result) {
                is Result.GenericError -> {
                    Timber.e(result.errorMessage)
                }
                is Result.NetworkError -> {
                    Timber.e(result.error)
                }
                is Result.Success -> {
                    emit(result.value)
                }
            }
        }
    }

    suspend fun getActions(
        timelineId: String,
        updateId: String?,
    ): Flow<List<Action>> {
        return flow {
            when (val result = dataManager.getActions(timelineId, updateId)) {
                is Result.Success -> {
                    emit(result.value)
                }
                is Result.NetworkError -> {
                    logger.log(MessageLevel.DEBUG, C.NETWORK_ERROR_MESSAGE.plus("${result.error}"))
                }
                is Result.GenericError -> {
                    logger.log(
                        MessageLevel.DEBUG,
                        C.INTERNAL_ERROR_MESSAGE.plus(" ${result.errorMessage} ${result.errorCode}")
                    )
                }
            }
        }
    }

    class Builder {
        private var logLevel: LogLevel = LogLevel.VERBOSE
        private var publicKey: String? = null
        private var identityToken: String? = null
        private lateinit var context: Context


        @Inject
        lateinit var prefManager: IPrefManager

        @Inject
        lateinit var logger: Logger

        @Inject
        lateinit var dataManager: IDataManager

        @Inject
        lateinit var reactorSocket: IReactorSocket

        @Inject
        lateinit var bffrtSocket: IBFFRTSocket

        fun withPublicKey(publicKey: String): Builder = apply {
            this.publicKey = publicKey
        }

        fun withIdentityToken(identityToken: String): Builder = apply {
            this.identityToken = identityToken
        }

        fun withContext(context: Context): Builder = apply {
            this.context = context
        }

        fun withLogLevel(logLevel: LogLevel): Builder = apply {
            this.logLevel = logLevel
        }

        fun build(): MCLSData {

            DaggerMCLSDataComponent
                .builder()
                .bindContext(context)
                .create()
                .inject(this)

            val mclsData = MCLSData(
                logLevel = logLevel,
                prefManager = prefManager,
                logger = logger,
                dataManager = dataManager,
                bffRtSocket = bffrtSocket,
                reactorSocket = reactorSocket,
            )

            identityToken?.let {
                mclsData.setIdentityToken(it)
            }
            publicKey?.let {
                mclsData.setPublicKey(it)
            }

            return mclsData
        }
    }
}
