package tv.mycujoo.mlsdata.domain.usecase

import tv.mycujoo.mlsdata.data.entity.ActionResponse
import tv.mycujoo.mlsdata.domain.params.TimelineIdPairParam
import tv.mycujoo.mclscore.model.Result
import tv.mycujoo.mlsdata.domain.repository.IEventsRepository
import javax.inject.Inject

/**
 * Usecase for getting Annotation Actions
 * Input parameter is pair of timelineId and updateEventId
 */
class GetActionsUseCase @Inject constructor(private val repository: IEventsRepository) :
    AbstractParameterizedUseCase<TimelineIdPairParam, Result<Exception, ActionResponse>>() {
    override suspend fun build(param: TimelineIdPairParam): Result<Exception, ActionResponse> {
        return repository.getActions(param)
    }
}