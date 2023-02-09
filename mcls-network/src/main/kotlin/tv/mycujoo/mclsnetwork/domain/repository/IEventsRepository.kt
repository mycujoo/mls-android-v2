package tv.mycujoo.mclsnetwork.domain.repository

import tv.mycujoo.mclsnetwork.data.entity.ActionResponse
import tv.mycujoo.mclsnetwork.domain.params.EventListParams
import tv.mycujoo.mclsnetwork.domain.params.TimelineIdPairParam
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.Events
import tv.mycujoo.mclscore.model.MCLSResult

interface IEventsRepository {
    suspend fun getEventsList(eventListParams: EventListParams): MCLSResult<Exception, Events>

    suspend fun getEventDetails(
        eventId: String,
        updatedId: String? = null
    ): MCLSResult<Exception, MCLSEvent>

    suspend fun getActions(timelineIdPairParam: TimelineIdPairParam): MCLSResult<Exception, ActionResponse>
}