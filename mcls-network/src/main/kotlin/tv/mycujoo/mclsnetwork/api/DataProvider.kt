package tv.mycujoo.mclsnetwork.api

import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.Events
import tv.mycujoo.mclscore.model.MCLSEventListItem
import tv.mycujoo.mclscore.model.MCLSResult
import tv.mycujoo.mclsnetwork.domain.entity.OrderByEventsParam

interface DataProvider {

    /**
     * calls Event-list endpoint and emits result on eventLiveData
     */
    suspend fun fetchEvents(
        pageSize: Int? = null,
        pageToken: String? = null,
        filter: String? = null,
        orderBy: OrderByEventsParam? = null,
        fetchEventCallback: ((eventList: List<MCLSEventListItem>, previousPageToken: String, nextPageToken: String) -> Unit)? = null
    )

    suspend fun fetchEvents(
        pageSize: Int? = null,
        pageToken: String? = null,
        filter: String? = null,
        orderBy: OrderByEventsParam? = null,
    ): MCLSResult<Exception, Events>
}