package tv.mycujoo.mclsnetwork

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclscore.model.*
import tv.mycujoo.mclsnetwork.data.IDataManager
import tv.mycujoo.mclsnetwork.di.DaggerMCLSDataComponent
import tv.mycujoo.mclsnetwork.di.IdentityToken
import tv.mycujoo.mclsnetwork.di.PublicKey
import tv.mycujoo.mclsnetwork.domain.entity.OrderByEventsParam
import tv.mycujoo.mclsnetwork.network.socket.IBFFRTSocket
import tv.mycujoo.mclsnetwork.network.socket.IReactorSocket
import tv.mycujoo.mclsnetwork.util.KeyStore
import javax.inject.Inject

interface MCLSNetwork {

    fun interface OnEventUpdateListener {
        fun onEventUpdate(event: MCLSEvent)
    }

    fun interface OnTimelineUpdateListener {
        fun onTimelineUpdate(actions: List<AnnotationAction>)
    }


    /**
     * Row accessor to [IReactorSocket]
     * @see IReactorSocket
     */
    val reactorSocket: IReactorSocket

    /**
     * Row accessor to [IBFFRTSocket] used for concurrency limit
     * @see IBFFRTSocket
     */
    val bffRtSocket: IBFFRTSocket

    /**
     * Adds an annotation actions change listener. And sends the current state of [MCLSEvent] (if joined before)
     *
     * Listeners of this type are only triggered after [joinEventAndTimelineUpdates] is executed.
     *
     * @param onTimelineUpdate can be expressed as an interface implementation or as a function callback
     *
     */
    fun addOnAnnotationActionsUpdateListener(
        onTimelineUpdate: OnTimelineUpdateListener,
    )

    /**
     * Adds an event change update listener i.e. the event went live
     *
     * Listeners of this type are only triggered after [joinEventAndTimelineUpdates] is executed.
     *
     * @param onEventUpdate a SAM interface which can be expressed as an interface implementation or as a function callback
     */
    fun addOnEventUpdateListener(
        onEventUpdate: OnEventUpdateListener,
    )

    /**
     * Remove [OnEventUpdateListener] from event change subscribers
     *
     * @param listener the listener to be removed
     */
    fun removeEventUpdateListener(
        listener: OnEventUpdateListener
    )

    /**
     * Remove [OnTimelineUpdateListener] from timeline changes listeners
     *
     * @param listener the listener to be removed
     */
    fun removeOnAnnotationActionsUpdateListener(
        listener: OnTimelineUpdateListener
    )

    /**
     * Leave Reactor Socket, and remove all listeners
     */
    fun leaveEventAndTimelineUpdates(
        release: Boolean
    )

    /**
     * Subscribes to changes in [MCLSEvent] and timeline [AnnotationAction]s listeners
     *
     * When changes happen listeners added from [addOnEventUpdateListener] and
     * [addOnAnnotationActionsUpdateListener] are informed about the updates.
     *
     * Currently only 1 event is listened to at any given moment,
     * so when [joinEventAndTimelineUpdates] is triggered multiple times, only the last eventId
     * is being monitored
     */
    fun joinEventAndTimelineUpdates(
        eventId: String,
        scope: CoroutineScope
    )

    /**
     * Sets the identity token used for protected streams
     *
     * {@link <a href="https://mcls.mycujoo.tv/api-docs/#mls-api-identityservice>Api Identity Token </a>}
     *
     * @param identityToken the token generated from the platform backend
     */
    fun setIdentityToken(identityToken: String)

    /**
     * Gets the current identity token used for network calls
     *
     * @return identityToken
     */
    fun getIdentityToken(): String

    /**
     * Sets the public key used for network calls. this one is linked to your organization
     *
     * @param publicKey
     */
    fun setPublicKey(publicKey: String)

    /**
     * Gets event details
     *
     * @param eventId
     * @param onEventComplete a callback that triggers when the call finishes successfully
     */
    suspend fun getEventDetails(
        eventId: String,
        onEventComplete: (MCLSEvent) -> Unit,
    )

    /**
     * Gets event details
     *
     * @param eventId
     * @param onEventComplete a callback that triggers when the call finishes successfully
     * @param onError a callback that triggers when an error happens
     */
    suspend fun getEventDetails(
        eventId: String,
        onEventComplete: (MCLSEvent) -> Unit,
        onError: ((String) -> Unit)? = null
    )

    /**
     * Gets the event details raw response
     *
     * @see MCLSResult for usage
     *
     * @param eventId
     *
     * @return the raw response
     *
     */
    suspend fun getEventDetails(
        eventId: String,
        updateId: String? = null
    ): MCLSResult<Exception, MCLSEvent>

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
    suspend fun getTimelineActions(
        timelineId: String,
        updateId: String? = null,
    ): MCLSResult<Exception, List<AnnotationAction>>

    /**
     *
     * An automatic unwrap for [getTimelineActions] result
     *
     * @see [getTimelineActions]
     *
     * @param timelineId
     * @param updateId
     * @param onSuccess a callback executed when Timeline request success
     *
     * @see [AnnotationAction]
     *
     */
    suspend fun getTimelineActions(
        timelineId: String,
        updateId: String? = null,
        onSuccess: (List<AnnotationAction>) -> Unit
    )

    /**
     *
     * An automatic unwrap for [getTimelineActions] result
     *
     * @see [getTimelineActions]
     *
     * @param timelineId
     * @param updateId
     * @param onSuccess a callback executed when Timeline request success.
     * @param onError a callback executed when timeline fetch fails. It invokes with a String explaining the error
     *
     * @see [AnnotationAction]
     *
     */
    suspend fun getTimelineActions(
        timelineId: String,
        updateId: String? = null,
        onSuccess: (List<AnnotationAction>) -> Unit,
        onError: ((String) -> Unit)?
    )

    class Builder {
        private var logLevel: LogLevel = LogLevel.VERBOSE
        private var publicKey: String? = null
        private var identityToken: String? = null
        private lateinit var context: Context

        @Inject
        lateinit var logger: Logger

        @Inject
        lateinit var dataManager: IDataManager

        @Inject
        lateinit var reactorSocket: IReactorSocket

        @Inject
        lateinit var bffrtSocket: IBFFRTSocket

        @Inject
        @PublicKey
        lateinit var publicKeyKeyStore: KeyStore

        @Inject
        @IdentityToken
        lateinit var identityTokenKeyStore: KeyStore

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

            val publicKey = publicKey
                ?: throw IllegalStateException("Please set public key before building this component")

            DaggerMCLSDataComponent
                .builder()
                .bindContext(context)
                .bindPublicKey(KeyStore(publicKey))
                .bindIdentityToken(KeyStore(identityToken))
                .create()
                .inject(this)

            return MCLSNetworkImpl(
                logLevel = logLevel,
                logger = logger,
                dataManager = dataManager,
                bffRtSocket = bffrtSocket,
                reactorSocket = reactorSocket,
                publicKeyStore = publicKeyKeyStore,
                identityTokenStore = identityTokenKeyStore,
            )
        }
    }
}