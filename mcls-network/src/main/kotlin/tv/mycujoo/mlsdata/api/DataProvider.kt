package tv.mycujoo.mlsdata.api

import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mlsdata.domain.entity.OrderByEventsParam
import tv.mycujoo.mlsdata.model.SingleLiveEvent

interface DataProvider {
    /**
     * subscribe to an observable which will emit list of EventEntities
     */
    fun getEventsLiveData(): SingleLiveEvent<List<EventEntity>>

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