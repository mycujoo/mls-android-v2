package tv.mycujoo.mclsnetwork

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    private var currentEvent: MCLSEvent? = null
    private var currentTimelineActions: List<AnnotationAction>? = null

    @get:Synchronized
    private var eventUpdateListeners = mutableListOf<MCLSNetwork.OnEventUpdateListener>()

    @get:Synchronized
    private var timelineUpdateListeners = mutableSetOf<MCLSNetwork.OnTimelineUpdateListener>()

    private var coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Default)

    init {
        logger.setLogLevel(logLevel)
    }

    override fun addOnAnnotationActionsUpdateListener(
        onTimelineUpdate: MCLSNetwork.OnTimelineUpdateListener,
    ) {
        timelineUpdateListeners.add(onTimelineUpdate)

        currentTimelineActions?.let {
            onTimelineUpdate.onTimelineUpdate(it)
        }
    }

    override fun addOnEventUpdateListener(
        onEventUpdate: MCLSNetwork.OnEventUpdateListener,
    ) {
        eventUpdateListeners.add(onEventUpdate)

        currentEvent?.let {
            onEventUpdate.onEventUpdate(it)
        }
    }

    override fun removeEventUpdateListener(listener: MCLSNetwork.OnEventUpdateListener) {
        eventUpdateListeners.remove(listener)
    }

    override fun removeOnAnnotationActionsUpdateListener(listener: MCLSNetwork.OnTimelineUpdateListener) {
        timelineUpdateListeners.remove(listener)
    }

    override fun leaveEventAndTimelineUpdates(release: Boolean) {
        eventUpdateListeners.clear()
        timelineUpdateListeners.clear()
        currentEvent = null
        currentTimelineActions = null

        reactorSocket.leave(release)
    }

    override fun joinEventAndTimelineUpdates(
        eventId: String,
        scope: CoroutineScope
    ) {
        if (currentEvent?.id == eventId) {
            return
        }

        if (scope != coroutineScope) {
            coroutineScope = scope
        }

        scope.launch {
            val eventDetailsResult = getEventDetails(eventId)

            if (eventDetailsResult !is MCLSResult.Success) {
                return@launch
            }

            val event = eventDetailsResult.value
            updateEventListeners(event)

            val timelineId = event.timeline_ids.firstOrNull() ?: return@launch

            val timelineResult = getTimelineActions(timelineId)
            if (timelineResult !is MCLSResult.Success) {
                return@launch
            }

            updateTimelineIdsListeners(timelineResult.value)
        }

        reactorSocket.leave(false)
        reactorSocket.joinEvent(eventId)
        reactorSocket.addListener(object : ReactorCallback {
            override fun onEventUpdate(eventId: String, updateId: String) {
                scope.launch {
                    when (val eventDetails = getEventDetails(eventId, updateId)) {
                        is MCLSResult.Success -> {
                            updateEventListeners(eventDetails.value)
                        }

                        else -> {
                            // Do nothing
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
                            currentTimelineActions = actions.value
                            updateTimelineIdsListeners(actions.value)
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
    ) {
        getEventDetails(eventId, onEventComplete, null)
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

    override suspend fun getEventDetails(
        eventId: String,
        updateId: String?
    ): MCLSResult<Exception, MCLSEvent> {
        return dataManager.getEventDetails(eventId, updateId)
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

    private fun updateEventListeners(event: MCLSEvent) {
        currentEvent = event
        for (listener in eventUpdateListeners) {
            listener.onEventUpdate(event)
        }
    }

    private fun updateTimelineIdsListeners(actions: List<AnnotationAction>) {
        currentTimelineActions = actions
        for (listener in timelineUpdateListeners) {
            listener.onTimelineUpdate(actions)
        }
    }

}
