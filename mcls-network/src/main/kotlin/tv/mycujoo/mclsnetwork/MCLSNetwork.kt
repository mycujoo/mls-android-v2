package tv.mycujoo.mclsnetwork

import android.content.Context
import timber.log.Timber
import tv.mycujoo.mcls.enum.C
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.model.MCLSResult
import tv.mycujoo.mclsnetwork.data.IDataManager
import tv.mycujoo.mclsnetwork.di.DaggerMCLSDataComponent
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclsnetwork.manager.IPrefManager
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclsnetwork.network.socket.IBFFRTSocket
import tv.mycujoo.mclsnetwork.network.socket.IReactorSocket
import javax.inject.Inject

class MCLSNetwork private constructor(
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

    suspend fun getEventDetails(eventId: String): MCLSResult<Exception, EventEntity> {
        return dataManager
            .getEventDetails(eventId)
    }

    suspend fun getActions(
        timelineId: String,
        updateId: String?,
    ): MCLSResult<Exception, List<AnnotationAction>> {
        return dataManager.getActions(timelineId, updateId)
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

        fun build(): MCLSNetwork {

            DaggerMCLSDataComponent
                .builder()
                .bindContext(context)
                .create()
                .inject(this)

            val mclsNetwork = MCLSNetwork(
                logLevel = logLevel,
                prefManager = prefManager,
                logger = logger,
                dataManager = dataManager,
                bffRtSocket = bffrtSocket,
                reactorSocket = reactorSocket,
            )

            identityToken?.let {
                mclsNetwork.setIdentityToken(it)
            }
            publicKey?.let {
                mclsNetwork.setPublicKey(it)
            }

            return mclsNetwork
        }
    }
}
