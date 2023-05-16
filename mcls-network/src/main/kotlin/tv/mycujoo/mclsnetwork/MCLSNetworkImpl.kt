package tv.mycujoo.mclsnetwork

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclscore.model.*
import tv.mycujoo.mclsnetwork.data.IDataManager
import tv.mycujoo.mclsnetwork.domain.entity.OrderByEventsParam
import tv.mycujoo.mclsnetwork.enum.C
import tv.mycujoo.mclsnetwork.manager.IPrefManager
import tv.mycujoo.mclsnetwork.network.socket.IBFFRTSocket
import tv.mycujoo.mclsnetwork.network.socket.IReactorSocket
import tv.mycujoo.mclsnetwork.network.socket.ReactorCallback

class MCLSNetworkImpl constructor(
    logLevel: LogLevel,
    private val prefManager: IPrefManager,
    logger: Logger,
    private val dataManager: IDataManager,
    override val reactorSocket: IReactorSocket,
    override val bffRtSocket: IBFFRTSocket,
) : MCLSNetwork {

    init {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        logger.setLogLevel(logLevel)
    }

    fun setOnAnnotationActionsUpdateListener(
        event: MCLSEvent,
        onUpdates: (List<AnnotationAction>) -> Unit,
        scope: CoroutineScope = CoroutineScope(Dispatchers.Default),
    ) {
        reactorSocket.leave(false)
        reactorSocket.joinEvent(event.id)
        reactorSocket.addListener(object : ReactorCallback {
            override fun onEventUpdate(eventId: String, updateId: String) {
            }

            override fun onCounterUpdate(counts: String) {
            }

            override fun onTimelineUpdate(timelineId: String, updateId: String) {
                scope.launch {
                    when (val actions = getActions(timelineId, updateId)) {
                        is MCLSResult.Success -> {
                            onUpdates(actions.value)
                        }

                        else -> {
                            // Do nothing
                        }
                    }
                }

            }
        })
    }

    override fun setIdentityToken(identityToken: String) {
        prefManager.persist(C.IDENTITY_TOKEN_PREF_KEY, identityToken)
    }

    override fun getIdentityToken(): String {
        return prefManager.get(C.IDENTITY_TOKEN_PREF_KEY).orEmpty()
    }

    override fun setPublicKey(publicKey: String) {
        prefManager.persist(C.PUBLIC_KEY_PREF_KEY, publicKey)
    }

    override suspend fun getEventDetails(
        eventId: String,
        onEventComplete: (MCLSEvent) -> Unit,
        onError: ((String) -> Unit)?
    ) {
        when (val eventDetailsResult = dataManager.getEventDetails(eventId)) {
            is MCLSResult.GenericError -> {
                onError?.invoke(
                    "Error ${eventDetailsResult.errorCode}: ${eventDetailsResult.errorMessage}"
                )
            }

            is MCLSResult.NetworkError -> {
                onError?.invoke(
                    eventDetailsResult.error.message ?: "Error Fetching Event"
                )
            }

            is MCLSResult.Success -> {
                onEventComplete(eventDetailsResult.value)
            }
        }
    }

    override suspend fun getEventDetails(eventId: String): MCLSResult<Exception, MCLSEvent> {
        return dataManager.getEventDetails(eventId)
    }

    override suspend fun getEventList(
        pageSize: Int?,
        pageToken: String?,
        eventStatus: List<EventStatus>?,
        orderBy: OrderByEventsParam?
    ): MCLSResult<Exception, Events> {
        return dataManager.fetchEvents(
            pageSize,
            pageToken,
            eventStatus,
            orderBy
        )
    }

    override suspend fun getEventsList(
        pageSize: Int?,
        pageToken: String?,
        eventStatus: List<EventStatus>?,
        orderBy: OrderByEventsParam?,
        fetchEventCallback: ((eventList: List<MCLSEventListItem>, previousPageToken: String, nextPageToken: String) -> Unit)?
    ) {
        return dataManager.fetchEvents(
            pageSize,
            pageToken,
            eventStatus,
            orderBy,
            fetchEventCallback
        )
    }

    override suspend fun getActions(
        timelineId: String,
        updateId: String?,
    ): MCLSResult<Exception, List<AnnotationAction>> {
        return dataManager.getActions(timelineId, updateId)
    }

}
