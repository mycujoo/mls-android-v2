package tv.mycujoo.cast

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.helper.valueOrNull
import tv.mycujoo.mclscore.model.MCLSEvent
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
        mclsNetwork = MCLSNetwork.builder()
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
            val event = mclsNetwork.getEventDetails(eventId).valueOrNull()

            if (event == null) {
                _error.postValue("Event Can't be found!")
                return@launch
            }

            if (event.streamStatus() == StreamStatus.PLAYABLE) {
                _activeEvent.postValue(event)
                return@launch
            }

            _error.postValue("Event can't be played ${event.streamStatus().name}")
        }
    }
}
