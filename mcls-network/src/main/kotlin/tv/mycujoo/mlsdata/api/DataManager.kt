package tv.mycujoo.mlsdata.api

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import tv.mycujoo.mcls.enum.C
import tv.mycujoo.mclscore.model.Action
import tv.mycujoo.mlsdata.data.IDataManager
import tv.mycujoo.mlsdata.domain.params.EventIdPairParam
import tv.mycujoo.mlsdata.domain.params.EventListParams
import tv.mycujoo.mlsdata.domain.usecase.GetEventDetailUseCase
import tv.mycujoo.mlsdata.domain.usecase.GetEventsUseCase
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mlsdata.domain.entity.OrderByEventsParam
import tv.mycujoo.mclscore.model.Result
import tv.mycujoo.mlsdata.domain.params.TimelineIdPairParam
import tv.mycujoo.mlsdata.domain.usecase.GetActionsUseCase
import tv.mycujoo.mlsdata.enum.LogLevel
import tv.mycujoo.mlsdata.enum.MessageLevel
import tv.mycujoo.mlsdata.manager.Logger
import tv.mycujoo.mlsdata.model.SingleLiveEvent
import javax.inject.Inject

/**
 * Serves client as 'Data Provider'
 * Serves internal usage as 'Internal Data Provider'
 * @param scope CoroutineScope which calls will made on it's context
 * @param logger log info, error & warning based on required level of logging
 */
class DataManager @Inject constructor(
    private val scope: CoroutineScope,
    private val logger: Logger,
    private val getEventDetailUseCase: GetEventDetailUseCase,
    private val getEventsUseCase: GetEventsUseCase,
    private val getActionsUseCase: GetActionsUseCase,
) : IDataManager {


    /**region Fields*/
    /**
     * observable holder for Events.
     */
    private val events = SingleLiveEvent<List<EventEntity>>()

    /**
     * holds current active EventEntity.
     * for easier access
     */
    override var currentEvent: EventEntity? = null

    /**
     * callback for paginating through received Events
     */
    private var fetchEventCallback: ((eventList: List<EventEntity>, previousPageToken: String, nextPageToken: String) -> Unit)? =
        null

    /**endregion */


    /**region InternalDataProvider*/

    /**
     * fetch Event with details
     */
    override suspend fun getEventDetails(
        eventId: String,
        updateId: String?
    ): Result<Exception, EventEntity> {
        return getEventDetailUseCase.execute(EventIdPairParam(eventId, updateId))
    }

    /**
     * set @param log level of Logger
     * @see LogLevel
     */
    override fun setLogLevel(logLevel: LogLevel) {
        logger.setLogLevel(logLevel)
    }

    /**endregion */

    /**region Data Provider*/
    override fun getEventsLiveData(): SingleLiveEvent<List<EventEntity>> {
        return events
    }

    /**
     * get Annotation Actions
     * @param timelineId timeLineId of Event
     * @param updateId nullable update of Event
     * @return list of Actions or Exception
     */
    override suspend fun getActions(
        timelineId: String,
        updateId: String?
    ): Result<Exception, List<Action>> {
        val actions =  getActionsUseCase.execute(
            TimelineIdPairParam(
                timelineId,
                updateId
            )
        )

        return when (actions) {
            is Result.GenericError -> actions
            is Result.NetworkError -> actions
            is Result.Success -> Result.Success(
                actions.value.data.map {
                    it.toAction()
                }
            )
        }
    }

    /**
     * fetch Events with given specification
     * @param pageSize nullable size of page
     * @param pageToken nullable token of page
     * @param eventStatus nullable statuses of returned Events
     * @param orderBy nullable order of returned Events
     * @param fetchEventCallback nullable callback which will may be used to navigate through paginated data
     */
    override fun fetchEvents(
        pageSize: Int?,
        pageToken: String?,
        eventStatus: List<EventStatus>?,
        orderBy: OrderByEventsParam?,
        fetchEventCallback: ((eventList: List<EventEntity>, previousPageToken: String, nextPageToken: String) -> Unit)?
    ) {
        this.fetchEventCallback = fetchEventCallback
        scope.launch {

            val result = getEventsUseCase.execute(
                EventListParams(
                    pageSize,
                    pageToken,
                    eventStatus?.map { it.toString() },
                    orderBy?.toString()
                )
            )
            when (result) {
                is Result.Success -> {
                    events.postValue(
                        result.value.eventEntities
                    )
                    fetchEventCallback?.invoke(
                        result.value.eventEntities,
                        result.value.previousPageToken ?: "",
                        result.value.nextPageToken ?: ""
                    )
                }
                is Result.NetworkError -> {
                    logger.log(MessageLevel.DEBUG, C.NETWORK_ERROR_MESSAGE.plus(" ${result.error}"))
                }
                is Result.GenericError -> {
                    Timber.tag(TAG).d("fetchEvents: Error ${result.errorCode}")
                    logger.log(
                        MessageLevel.DEBUG,
                        C.INTERNAL_ERROR_MESSAGE.plus(" ${result.errorMessage} ${result.errorCode}")
                    )
                }

            }
        }
    }
    /**endregion */

    companion object {
        private const val TAG = "DataManager"
    }
}