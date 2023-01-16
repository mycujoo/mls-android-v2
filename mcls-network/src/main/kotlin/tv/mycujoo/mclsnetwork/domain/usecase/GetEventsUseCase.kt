package tv.mycujoo.mclsnetwork.domain.usecase

import tv.mycujoo.mclsnetwork.domain.params.EventListParams
import tv.mycujoo.mclsnetwork.domain.repository.IEventsRepository
import tv.mycujoo.mclscore.model.Events
import tv.mycujoo.mclscore.model.MCLSResult
import javax.inject.Inject

/**
 * Usecase for getting Events.
 * Input parameter defines which types of Events should be returned
 * @see EventListParams
 */
class GetEventsUseCase @Inject constructor(private val repository: IEventsRepository) :
    AbstractParameterizedUseCase<EventListParams, MCLSResult<Exception, Events>>() {
    override suspend fun build(param: EventListParams): MCLSResult<Exception, Events> {
        return repository.getEventsList(param)
    }
}