package tv.mycujoo.network

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.MCLSEventListItem
import tv.mycujoo.mclsnetwork.MCLSNetwork

class MainActivityViewModel : ViewModel() {

    private lateinit var mclsNetwork: MCLSNetwork

    private val _events = MutableLiveData<List<MCLSEventListItem>>()
    val events get() = _events

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
                filter = "status:EVENT_STATUS_FINISHED"
            ) { eventList, _, _ ->
                _events.postValue(eventList)
            }
        }

    }
}