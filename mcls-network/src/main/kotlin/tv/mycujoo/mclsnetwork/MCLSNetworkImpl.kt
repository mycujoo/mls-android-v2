package tv.mycujoo.mclsnetwork

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
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
        logger.setLogLevel(logLevel)
    }

    override fun setOnAnnotationActionsUpdateListener(
        event: MCLSEvent,
        onTimelineUpdate: (List<AnnotationAction>) -> Unit,
        onEventUpdate: ((MCLSEvent) -> Unit)?,
        scope: CoroutineScope,
    ) {
        reactorSocket.leave(false)
        reactorSocket.joinEvent(event.id)
        reactorSocket.addListener(object : ReactorCallback {
            override fun onEventUpdate(eventId: String, updateId: String) {
                scope.launch {
                    when (val eventDetails = getEventDetails(eventId)) {
                        is MCLSResult.Success -> {
                            onEventUpdate?.invoke(eventDetails.value)
                        }
                        else -> {

                        }
                    }
                }
            }

            override fun onCounterUpdate(counts: String) {
            }

            override fun onTimelineUpdate(timelineId: String, updateId: String) {
                scope.launch {
                    when (val actions = getTimelineActions(timelineId, updateId)) {
                        is MCLSResult.Success -> {
                            onTimelineUpdate(actions.value)
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
        filter: String?,
        orderBy: OrderByEventsParam?
    ): MCLSResult<Exception, Events> {
        return dataManager.fetchEvents(
            pageSize,
            pageToken,
            filter,
            orderBy
        )
    }

    override suspend fun getEventsList(
        pageSize: Int?,
        pageToken: String?,
        filter: String?,
        orderBy: OrderByEventsParam?,
        fetchEventCallback: ((eventList: List<MCLSEventListItem>, previousPageToken: String, nextPageToken: String) -> Unit)?
    ) {
        return dataManager.fetchEvents(
            pageSize,
            pageToken,
            filter,
            orderBy,
            fetchEventCallback
        )
    }

    override suspend fun getTimelineActions(
        timelineId: String,
        updateId: String?,
    ): MCLSResult<Exception, List<AnnotationAction>> {
        return dataManager.getActions(timelineId, updateId)
    }

}
