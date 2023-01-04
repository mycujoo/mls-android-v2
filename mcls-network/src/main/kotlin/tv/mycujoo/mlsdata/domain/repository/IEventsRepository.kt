package tv.mycujoo.mlsdata.domain.repository

import tv.mycujoo.mlsdata.data.entity.ActionResponse
import tv.mycujoo.mlsdata.domain.params.EventListParams
import tv.mycujoo.mlsdata.domain.params.TimelineIdPairParam
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.model.Events
import tv.mycujoo.mclscore.model.Result

interface IEventsRepository {
    suspend fun getEventsList(eventListParams: EventListParams): Result<Exception, Events>

    suspend fun getEventDetails(
        eventId: String,
        updatedId: String? = null
    ): Result<Exception, EventEntity>

    suspend fun getActions(timelineIdPairParam: TimelineIdPairParam): Result<Exception, ActionResponse>
}