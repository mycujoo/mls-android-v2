package tv.mycujoo.cast

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.MCLSResult
import tv.mycujoo.mclsnetwork.MCLSNetwork

class MainActivityViewModel : ViewModel() {

    private lateinit var mclsNetwork: MCLSNetwork

    private val _events = MutableLiveData<List<MCLSEvent>>()
    val events: LiveData<List<MCLSEvent>> get() = _events

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _activeEvent = MutableLiveData<MCLSEvent>()
    val activeEvent: LiveData<MCLSEvent> get() = _activeEvent

    /**
     * Builds MCLS Context
     *
     * @param context
     *
     * Note: Context should be provided via hilt's ApplicationContext, or Coin's androidContext()
     */
    fun buildClient(context: Context) {
        mclsNetwork = MCLSNetwork.Builder()
            .withContext(context)
            .withPublicKey("FBVKACGN37JQC5SFA0OVK8KKSIOP153G")
            .build()
    }

    fun getEvents() {
        viewModelScope.launch {
            mclsNetwork.getEventsList(
                pageSize = 10,
                eventStatus = listOf(EventStatus.EVENT_STATUS_FINISHED)
            ) { eventList, _, _ ->
                _events.postValue(eventList)
            }
        }
    }

    fun playEvent(eventId: String) {
        viewModelScope.launch {
            when(val details = mclsNetwork.getEventDetails(eventId)) {
                is MCLSResult.GenericError -> _error.postValue("Error! ${details.errorCode}")
                is MCLSResult.NetworkError -> _error.postValue("Error! ${details.error}")
                is MCLSResult.Success -> {
                    val event = details.value

                    if (event.streamStatus() == StreamStatus.PLAYABLE) {
                        _activeEvent.postValue(event)
                    } else {
                        _error.postValue("Event can't be played ${event.streamStatus().name}")
                    }
                }
            }
        }
    }
}
