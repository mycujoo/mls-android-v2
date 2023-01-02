package tv.mycujoo.mlsdata.domain.usecase

import tv.mycujoo.mlsdata.domain.params.EventListParams
import tv.mycujoo.mlsdata.domain.repository.IEventsRepository
import tv.mycujoo.mclscore.model.Events
import tv.mycujoo.mclscore.model.Result
import javax.inject.Inject

/**
 * Usecase for getting Events.
 * Input parameter defines which types of Events should be returned
 * @see EventListParams
 */
class GetEventsUseCase @Inject constructor(private val repository: IEventsRepository) :
    AbstractParameterizedUseCase<EventListParams, Result<Exception, Events>>() {
    override suspend fun build(param: EventListParams): Result<Exception, Events> {
        return repository.getEventsList(param)
    }
}