package tv.mycujoo.mclsnetwork

import android.content.Context
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclscore.model.*
import tv.mycujoo.mclsnetwork.data.IDataManager
import tv.mycujoo.mclsnetwork.di.DaggerMCLSDataComponent
import tv.mycujoo.mclsnetwork.domain.entity.OrderByEventsParam
import tv.mycujoo.mclsnetwork.manager.IPrefManager
import tv.mycujoo.mclsnetwork.network.socket.IBFFRTSocket
import tv.mycujoo.mclsnetwork.network.socket.IReactorSocket
import javax.inject.Inject

interface MCLSNetwork {

    val reactorSocket: IReactorSocket
    val bffRtSocket: IBFFRTSocket

    fun setIdentityToken(identityToken: String)

    fun getIdentityToken(): String

    fun setPublicKey(publicKey: String)

    suspend fun getEventDetails(
        eventId: String,
        onEventComplete: (MCLSEvent) -> Unit,
        onError: ((String) -> Unit)? = null
    )

    suspend fun getEventDetails(eventId: String): MCLSResult<Exception, MCLSEvent>

    /**
     * Fetches Events List and Returns them in a MCLSResult wrapper
     *
     * @param pageSize the number of items wanted in a given response
     * @param pageToken used for pagination purposes
     * @param filter used for filtering events based on a given query.
     * @param orderBy the order of the event list
     *
     * @return the response of the call
     *
     * @see MCLSResult
     *
     * For more information about the filter query please refer to the following
     * {@link <a href="https://mcls.mycujoo.tv/api-docs/#list-events">https://mcls.mycujoo.tv/api-docs/#list-events</a>}
     */
    suspend fun getEventList(
        pageSize: Int? = null,
        pageToken: String? = null,
        filter: String? = null,
        orderBy: OrderByEventsParam? = null,
    ): MCLSResult<Exception, Events>

    /**
     * Fetches Events List and Returns them in a callback param
     *
     * @param pageSize the number of items wanted in a given response
     * @param pageToken used for pagination purposes
     * @param filter used for filtering events based on a given query.
     * @param orderBy the order of the event list
     *
     * For more information about the filter and the order by params queries please refer to the following
     * {@link <a href="https://mcls.mycujoo.tv/api-docs/#list-events">https://mcls.mycujoo.tv/api-docs/#list-events</a>}
     */
    suspend fun getEventsList(
        pageSize: Int? = null,
        pageToken: String? = null,
        filter: String? = null,
        orderBy: OrderByEventsParam? = null,
        fetchEventCallback: ((eventList: List<MCLSEventListItem>, previousPageToken: String, nextPageToken: String) -> Unit)? = null
    )

    /**
     * Fetches a list of Annotation Actions from the api, and returns them in a response wrapper for safe execution
     *
     * @param timelineId the id of the timeline needed
     * @param updateId a key used to get the latest update of a given timeline.
     *
     * @return a result wrapper of [AnnotationAction] for safe execution
     *
     * @see MCLSResult
     */
    suspend fun getActions(
        timelineId: String,
        updateId: String?,
    ): MCLSResult<Exception, List<AnnotationAction>>

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

            val mclsNetwork = MCLSNetworkImpl(
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