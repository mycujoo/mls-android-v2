package tv.mycujoo.mclsnetwork.api

import kotlinx.coroutines.flow.Flow
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclsnetwork.domain.entity.OrderByEventsParam

interface DataProvider {
    /**
     * subscribe to an observable which will emit list of EventEntities
     */
    fun getEventsLiveData(): Flow<List<MCLSEvent>>

    /**
     * calls Event-list endpoint and emits result on eventLiveData
     */
    fun fetchEvents(
        pageSize: Int? = null,
        pageToken: String? = null,
        eventStatus: List<EventStatus>? = null,
        orderBy: OrderByEventsParam? = null,
        fetchEventCallback: ((eventList: List<MCLSEvent>, previousPageToken: String, nextPageToken: String) -> Unit)? = null
    )
}