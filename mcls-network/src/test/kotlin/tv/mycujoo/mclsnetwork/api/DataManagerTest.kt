package tv.mycujoo.mclsnetwork.api

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.`should be equal to`
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.anyOrNull
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.model.*
import tv.mycujoo.mclsnetwork.domain.entity.OrderByEventsParam
import tv.mycujoo.mclsnetwork.domain.repository.IEventsRepository
import tv.mycujoo.mclsnetwork.domain.usecase.GetActionsUseCase
import tv.mycujoo.mclsnetwork.domain.usecase.GetEventDetailUseCase
import tv.mycujoo.mclsnetwork.domain.usecase.GetEventsUseCase
import tv.mycujoo.mclsnetwork.factory.EventFactory
import kotlin.test.assertEquals

@RunWith(MockitoJUnitRunner::class)
class DataManagerTest {

    @Mock
    lateinit var eventRepository: IEventsRepository

    private lateinit var getEventDetailsUseCase: GetEventDetailUseCase
    private lateinit var getEventsUseCase: GetEventsUseCase
    private lateinit var getActionsUseCase: GetActionsUseCase

    private lateinit var dataManager: DataManager

    @Before
    fun setup() {
        getEventDetailsUseCase = GetEventDetailUseCase(eventRepository)
        getEventsUseCase = GetEventsUseCase(eventRepository)
        getActionsUseCase = GetActionsUseCase(eventRepository)

        dataManager = DataManager(
            scope = CoroutineScope(Dispatchers.Unconfined),
            logger = mock(),
            getActionsUseCase = getActionsUseCase,
            getEventDetailUseCase = getEventDetailsUseCase,
            getEventsUseCase = getEventsUseCase,
        )
    }

    @Test
    fun testGetEventDetails(): Unit = runBlocking {
        val testEvent = EventFactory.getEvent(
            title = "Title",
            id = "id",
            streams = emptyList()
        )

        whenever(eventRepository.getEventDetails(any(), anyOrNull()))
            .thenReturn(Result.Success(testEvent))

        val result = dataManager.getEventDetails("123")

        result as Result.Success
        val event = result.value

        event.id `should be equal to` "id"
        event.title `should be equal to` "Title"
        event.streamStatus() `should be equal to` StreamStatus.NO_STREAM_URL
    }

    @Test
    fun testGetEventLiveData(): Unit = runBlocking {
        val dataManager = DataManager(
            scope = this,
            logger = mock(),
            getActionsUseCase = mock(),
            getEventDetailUseCase = mock(),
            getEventsUseCase = getEventsUseCase,
        )

        val testEvent = EventFactory.getEvent(
            title = "Title",
            id = "id",
            streams = emptyList()
        )

        whenever(eventRepository.getEventsList(any()))
            .thenReturn(
                Result.Success(
                    Events(
                        eventEntities = listOf(testEvent),
                        previousPageToken = "previous",
                        nextPageToken = "next"
                    )
                )
            )

        val resultLiveData = dataManager.getEventsLiveData()

        dataManager.fetchEvents(
            pageSize = 10,
            pageToken = "123",
            eventStatus = listOf(EventStatus.EVENT_STATUS_SCHEDULED),
            orderBy = OrderByEventsParam.ORDER_START_TIME_ASC,
        )

        val events = resultLiveData.first()

        events[0].id `should be equal to` "id"
        events[0].title `should be equal to` "Title"
        events[0].streamStatus() `should be equal to` StreamStatus.NO_STREAM_URL
    }

    @Test
    fun testGetEventCallback(): Unit = runBlocking {
        val getEventsUseCase = GetEventsUseCase(eventRepository)
        val dataManager = DataManager(
            scope = this,
            logger = mock(),
            getActionsUseCase = mock(),
            getEventDetailUseCase = mock(),
            getEventsUseCase = getEventsUseCase,
        )

        val testEvent = EventFactory.getEvent(
            title = "Title",
            id = "id",
            streams = emptyList()
        )

        whenever(eventRepository.getEventsList(any()))
            .thenReturn(
                Result.Success(
                    Events(
                        eventEntities = listOf(testEvent),
                        previousPageToken = "previous",
                        nextPageToken = "next"
                    )
                )
            )
        dataManager.fetchEvents(
            pageSize = 10,
            pageToken = "123",
            eventStatus = listOf(EventStatus.EVENT_STATUS_SCHEDULED),
            orderBy = OrderByEventsParam.ORDER_START_TIME_ASC,
            fetchEventCallback = { events, prev, next ->
                events.size shouldBeEqualTo 1

                events[0].id `should be equal to` "id"
                events[0].title `should be equal to` "Title"
                events[0].streamStatus() `should be equal to` StreamStatus.NO_STREAM_URL

                prev `should be equal to` "previous"
                next `should be equal to` "next"
            }
        )
    }

    @Test
    fun `given event list on response of get event, should return in callback`() = runBlocking {
        whenever(getEventsUseCase.execute(any())).thenReturn(
            Result.Success(
                getSampleEvents(
                    null,
                    null
                )
            )
        )


        val eventEntityArrayList = ArrayList<EventEntity>()
        dataManager.fetchEvents(
            2,
            null,
            listOf(EventStatus.EVENT_STATUS_SCHEDULED, EventStatus.EVENT_STATUS_CANCELLED),
            OrderByEventsParam.ORDER_TITLE_ASC
        ) { eventList, _, _ -> eventEntityArrayList.addAll(eventList) }


        assertEquals(2, eventEntityArrayList.size)
    }

    @Test
    fun `given previousPageToken on response of get event, should return in callback`() =
        runBlocking {
            whenever(getEventsUseCase.execute(any())).thenReturn(
                Result.Success(
                    getSampleEvents(SAMPLE_PREVIOUS_PAGE_TOKEN, null)
                )
            )


            var result = ""
            dataManager.fetchEvents(
                2,
                null,
                listOf(EventStatus.EVENT_STATUS_SCHEDULED, EventStatus.EVENT_STATUS_CANCELLED),
                OrderByEventsParam.ORDER_TITLE_ASC
            ) { _, previousPageToken, _ -> result = previousPageToken }


            assertEquals(SAMPLE_PREVIOUS_PAGE_TOKEN, result)
        }

    @Test
    fun `given nextPageToken on response of get event, should return in callback`() = runBlocking {
        whenever(getEventsUseCase.execute(any())).thenReturn(
            Result.Success(
                getSampleEvents(null, SAMPLE_NEXT_PAGE_TOKEN)
            )
        )


        var result = ""
        dataManager.fetchEvents(
            2,
            null,
            listOf(EventStatus.EVENT_STATUS_SCHEDULED, EventStatus.EVENT_STATUS_CANCELLED),
            OrderByEventsParam.ORDER_TITLE_ASC
        ) { _, _, nextPageToken -> result = nextPageToken }


        assertEquals(SAMPLE_NEXT_PAGE_TOKEN, result)
    }

    @Test
    fun `given no event in event list on response of get event, should not add to callback`() =
        runBlocking {
            val eventEntityArrayList = ArrayList<EventEntity>()

            dataManager.fetchEvents(
                0,
                null,
                listOf(EventStatus.EVENT_STATUS_SCHEDULED, EventStatus.EVENT_STATUS_CANCELLED),
                OrderByEventsParam.ORDER_TITLE_ASC
            ) { eventList, _, _ -> eventEntityArrayList.addAll(eventList) }


            assertEquals(0, eventEntityArrayList.size)
        }

    private fun getSampleEventEntity(): EventEntity {
        val location = Location(Physical("", "", Coordinates(0.toDouble(), 0.toDouble()), "", ""))
        return EventEntity(
            "42",
            "",
            "",
            "",
            null,
            location,
            "",
            null,
            EventStatus.EVENT_STATUS_UNSPECIFIED,
            emptyList(),
            "",
            emptyList(),
            Metadata(),
            false
        )
    }

    private fun getSampleEvents(previousPageToken: String?, nextPageToken: String?): Events {
        return Events(
            listOf(getSampleEventEntity(), getSampleEventEntity()),
            previousPageToken,
            nextPageToken
        )
    }


    companion object {
        const val SAMPLE_PREVIOUS_PAGE_TOKEN = "sample_previous_page_token"
        const val SAMPLE_NEXT_PAGE_TOKEN = "sample_next_page_token"
    }
}