package tv.mycujoo.mclsnetwork.api

import kotlinx.coroutines.runBlocking
import org.amshove.kluent.`should be equal to`
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.anyOrNull
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.model.Result
import tv.mycujoo.mclsnetwork.domain.repository.IEventsRepository
import tv.mycujoo.mclsnetwork.domain.usecase.GetEventDetailUseCase
import tv.mycujoo.mclsnetwork.factory.EventFactory

@RunWith(MockitoJUnitRunner::class)
class DataManagerTest {

    @Mock
    lateinit var eventRepository: IEventsRepository

    @Test
    fun testGetEventDetailsWithNoStreams(): Unit = runBlocking {
        val getEventDetailsUseCase = GetEventDetailUseCase(eventRepository)
        val dataManager = DataManager(
            scope = this,
            logger = mock(),
            getActionsUseCase = mock(),
            getEventDetailUseCase = getEventDetailsUseCase,
            getEventsUseCase = mock(),
        )

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
}