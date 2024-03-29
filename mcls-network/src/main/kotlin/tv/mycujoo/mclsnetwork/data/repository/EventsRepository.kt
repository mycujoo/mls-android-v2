package tv.mycujoo.mclsnetwork.data.repository

import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.Events
import tv.mycujoo.mclscore.model.MCLSResult
import tv.mycujoo.mclsnetwork.data.entity.ActionResponse
import tv.mycujoo.mclsnetwork.data.mapper.EventMapper.Companion.mapEventSourceDataToEventEntity
import tv.mycujoo.mclsnetwork.data.mapper.EventMapper.Companion.mapEventSourceDataToEventListItem
import tv.mycujoo.mclsnetwork.domain.params.EventListParams
import tv.mycujoo.mclsnetwork.domain.params.TimelineIdPairParam
import tv.mycujoo.mclsnetwork.domain.repository.AbstractRepository
import tv.mycujoo.mclsnetwork.domain.repository.IEventsRepository
import tv.mycujoo.mclsnetwork.network.CDAApi
import tv.mycujoo.mclsnetwork.network.MlsApi
import tv.mycujoo.mclsnetwork.network.request.GetEventDetailsRequest
import tv.mycujoo.mclsnetwork.network.request.GetEventListRequest
import javax.inject.Inject

class EventsRepository @Inject constructor(
    private val api: MlsApi,
    private val cdaApi: CDAApi,
) : AbstractRepository(), IEventsRepository {

    override suspend fun getEventsList(eventListParams: EventListParams): MCLSResult<Exception, Events> {
        return safeApiCall {
            val eventsSourceData = cdaApi.getEvents(
                GetEventListRequest(
                    pageSize = eventListParams.pageSize ?: 10,
                    pageToken = eventListParams.pageToken,
                    filter = eventListParams.filter,
                    orderBy = eventListParams.orderBy
                )
            )
            val events = eventsSourceData.events.map {
                mapEventSourceDataToEventListItem(it)
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
    ): MCLSResult<Exception, MCLSEvent> {
        return safeApiCall {
            val eventDetails = cdaApi.getEventDetails(
                GetEventDetailsRequest(
                    eventId
                )
            )
            mapEventSourceDataToEventEntity(eventDetails.event)
        }
    }

    override suspend fun getActions(timelineIdPairParam: TimelineIdPairParam): MCLSResult<Exception, ActionResponse> {
        return safeApiCall {
            api.getActions(
                timelineIdPairParam.timelineId,
                timelineIdPairParam.updateEventId
            )
        }
    }
}