package tv.mycujoo.network

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclsnetwork.MCLSNetwork

class MainActivityViewModel : ViewModel() {

    private lateinit var mclsNetwork: MCLSNetwork

    private val _events = MutableLiveData<List<MCLSEvent>>()
    val events get() = _events

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
            mclsNetwork.getEventsList(pageSize = 10) { eventList, _, _ ->
                Log.d("MainActivityViewModel", "getEvents: $eventList")
                _events.postValue(eventList)
            }
        }

    }
}