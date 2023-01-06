package tv.mycujoo.mclsnetwork.data.repository

import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.model.Events
import tv.mycujoo.mclscore.model.Result
import tv.mycujoo.mclsnetwork.data.entity.ActionResponse
import tv.mycujoo.mclsnetwork.data.mapper.EventMapper.Companion.mapEventSourceDataToEventEntity
import tv.mycujoo.mclsnetwork.domain.params.EventListParams
import tv.mycujoo.mclsnetwork.domain.params.TimelineIdPairParam
import tv.mycujoo.mclsnetwork.domain.repository.AbstractRepository
import tv.mycujoo.mclsnetwork.domain.repository.IEventsRepository
import tv.mycujoo.mclsnetwork.network.MlsApi
import javax.inject.Inject

class EventsRepository @Inject constructor(
    val api: MlsApi
) : AbstractRepository(), IEventsRepository {

    override suspend fun getEventsList(eventListParams: EventListParams): Result<Exception, Events> {
        return safeApiCall {
            val eventsSourceData = api.getEvents(
                pageSize = eventListParams.pageSize,
                pageToken = eventListParams.pageToken,
                status = eventListParams.status,
                orderBy = eventListParams.orderBy
            )
            val events = eventsSourceData.events.map {
                mapEventSourceDataToEventEntity(it)
            }
            Events(
                eventEntities = events,
                previousPageToken = eventsSourceData.previousPageToken,
                nextPageToken = eventsSourceData.nextPageToken
            )
        }
    }

    override suspend fun getEventDetails(
        eventId: String,
        updatedId: String?
    ): Result<Exception, EventEntity> {
        return safeApiCall {
            val eventDetails = api.getEventDetails(eventId, updatedId)
            mapEventSourceDataToEventEntity(eventDetails)
        }
    }

    override suspend fun getActions(timelineIdPairParam: TimelineIdPairParam): Result<Exception, ActionResponse> {
        return safeApiCall {
            api.getActions(
                timelineIdPairParam.timelineId,
                timelineIdPairParam.updateEventId
            )
        }
    }
}