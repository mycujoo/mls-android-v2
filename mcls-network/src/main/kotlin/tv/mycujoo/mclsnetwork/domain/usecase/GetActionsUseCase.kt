package tv.mycujoo.mclsnetwork.domain.usecase

import tv.mycujoo.mclsnetwork.data.entity.ActionResponse
import tv.mycujoo.mclsnetwork.domain.params.TimelineIdPairParam
import tv.mycujoo.mclscore.model.MCLSResult
import tv.mycujoo.mclsnetwork.domain.repository.IEventsRepository
import javax.inject.Inject

/**
 * Usecase for getting Annotation Actions
 * Input parameter is pair of timelineId and updateEventId
 */
class GetActionsUseCase @Inject constructor(private val repository: IEventsRepository) :
    AbstractParameterizedUseCase<TimelineIdPairParam, MCLSResult<Exception, ActionResponse>>() {
    override suspend fun build(param: TimelineIdPairParam): MCLSResult<Exception, ActionResponse> {
        return repository.getActions(param)
    }
}