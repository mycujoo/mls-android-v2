package tv.mycujoo.mlsdata.domain.usecase

import tv.mycujoo.mlsdata.domain.params.EventIdPairParam
import tv.mycujoo.mlsdata.domain.repository.IEventsRepository
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.model.Result
import javax.inject.Inject

/**
 * Usecase for getting Event details.
 * Input parameter is pair of eventId and eventUpdateId
 * @see EventIdPairParam
 */
class GetEventDetailUseCase @Inject constructor(private val repository: IEventsRepository) :
    AbstractParameterizedUseCase<EventIdPairParam, Result<Exception, EventEntity>>() {
    override suspend fun build(param: EventIdPairParam): Result<Exception, EventEntity> {
        return repository.getEventDetails(param.eventId, param.updateEventId)
    }
}