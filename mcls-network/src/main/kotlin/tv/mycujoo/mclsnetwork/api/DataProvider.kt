package tv.mycujoo.mclsnetwork.api

import kotlinx.coroutines.flow.Flow
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclsnetwork.domain.entity.OrderByEventsParam

interface DataProvider {
    /**
     * subscribe to an observable which will emit list of EventEntities
     */
    fun getEventsLiveData(): Flow<List<EventEntity>>

    /**
     * calls Event-list endpoint and emits result on eventLiveData
     */
    fun fetchEvents(
        pageSize: Int? = null,
        pageToken: String? = null,
        eventStatus: List<EventStatus>? = null,
        orderBy: OrderByEventsParam? = null,
        fetchEventCallback: ((eventList: List<EventEntity>, previousPageToken: String, nextPageToken: String) -> Unit)? = null
    )
}