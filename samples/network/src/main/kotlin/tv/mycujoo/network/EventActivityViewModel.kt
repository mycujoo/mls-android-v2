package tv.mycujoo.network

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import tv.mycujoo.mclscore.helper.valueOrNull
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclsnetwork.MCLSNetwork

class EventActivityViewModel : ViewModel() {

    private lateinit var mclsNetwork: MCLSNetwork

    private val _event = MutableLiveData<MCLSEvent>()
    val event: LiveData<MCLSEvent> get() = _event

    private val _annotationActions = MutableLiveData<List<AnnotationAction>>()
    val annotationAction: LiveData<List<AnnotationAction>> get() = _annotationActions

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

    fun getEvent(eventId: String) {
        viewModelScope.launch {
            val eventResult = mclsNetwork.getEventDetails(eventId).valueOrNull() ?: return@launch
            _event.postValue(eventResult)

            Log.d(TAG, "getEvent: ${eventResult.timeline_ids}")
            val timelineId = eventResult.timeline_ids.firstOrNull() ?: return@launch

            val actions = mclsNetwork.getActions(timelineId, null).valueOrNull() ?: return@launch
            _annotationActions.postValue(actions)
        }
    }

    companion object {
        const val TAG = "EventActivityViewModel"
    }
}