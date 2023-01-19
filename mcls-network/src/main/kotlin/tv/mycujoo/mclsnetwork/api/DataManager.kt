package tv.mycujoo.mclsnetwork.api

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import tv.mycujoo.mcls.enum.C
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclsnetwork.data.IDataManager
import tv.mycujoo.mclsnetwork.domain.params.EventIdPairParam
import tv.mycujoo.mclsnetwork.domain.params.EventListParams
import tv.mycujoo.mclsnetwork.domain.usecase.GetEventDetailUseCase
import tv.mycujoo.mclsnetwork.domain.usecase.GetEventsUseCase
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclsnetwork.domain.entity.OrderByEventsParam
import tv.mycujoo.mclscore.model.MCLSResult
import tv.mycujoo.mclsnetwork.domain.params.TimelineIdPairParam
import tv.mycujoo.mclsnetwork.domain.usecase.GetActionsUseCase
import tv.mycujoo.mclsnetwork.enum.LogLevel
import tv.mycujoo.mclsnetwork.enum.MessageLevel
import tv.mycujoo.mclsnetwork.manager.Logger
import javax.inject.Inject

/**
 * Serves client as 'Data Provider'
 * Serves internal usage as 'Internal Data Provider'
 * @param scope CoroutineScope which calls will made on it's context
 * @param logger log info, error & warning based on required level of logging
 * @param getActionsUseCase an invocation for IEventsRepository#getActions
 * @param getEventDetailUseCase an invocation for IEventsRepository#getEventDetails
 * @param getEventsUseCase an invocation for IEventsRepository#getEventsList
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
    private val events = MutableSharedFlow<List<EventEntity>>(1)

    /**
     * callback for paginating through received Events
     */
    private var fetchEventCallback: ((eventList: List<EventEntity>, previousPageToken: String, nextPageToken: String) -> Unit)? =
        null

    /**endregion */


    /**region InternalDataProvider*/

    /**
     * fetch Event with details
     * @param eventId
     * @param updateId
     */
    override suspend fun getEventDetails(
        eventId: String,
        updateId: String?
    ): MCLSResult<Exception, EventEntity> {
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
    override fun getEventsLiveData(): Flow<List<EventEntity>> {
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
    ): MCLSResult<Exception, List<AnnotationAction>> {
        val actions =  getActionsUseCase.execute(
            TimelineIdPairParam(
                timelineId,
                updateId
            )
        )

        return when (actions) {
            is MCLSResult.GenericError -> actions
            is MCLSResult.NetworkError -> actions
            is MCLSResult.Success -> MCLSResult.Success(
                actions.value.data.map {
                    it.toAction()
                }
            )
        }
    }

    /**
     * fetch Events with given specification
     *
     * Events Are pushed into the LiveData events and fetchEventCallback when fetch is done.
     *
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
                is MCLSResult.Success -> {
                    scope.launch {
                        events.emit(
                            result.value.eventEntities
                        )
                    }
                    fetchEventCallback?.invoke(
                        result.value.eventEntities,
                        result.value.previousPageToken ?: "",
                        result.value.nextPageToken ?: ""
                    )
                }
                is MCLSResult.NetworkError -> {
                    logger.log(MessageLevel.DEBUG, C.NETWORK_ERROR_MESSAGE.plus(" ${result.error}"))
                }
                is MCLSResult.GenericError -> {
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