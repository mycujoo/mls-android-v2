package tv.mycujoo.network

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclsnetwork.MCLSNetwork

class ReactiveEventActivityViewModel : ViewModel() {

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
        mclsNetwork = MCLSNetwork.Builder()
            .withContext(context)
            .withPublicKey("PUBLIC_KEY_HERE")
            .build()
    }

    fun joinEventAndTimelineUpdates(eventId: String) {
        mclsNetwork.addOnAnnotationActionsUpdateListener {
            _annotationActions.postValue(it)
        }

        mclsNetwork.addOnEventUpdateListener {
            _event.postValue(it)
        }

        mclsNetwork.joinEventAndTimelineUpdates(
            eventId,
            viewModelScope
        )
    }

    fun stopUpdates() {
        mclsNetwork.leaveEventAndTimelineUpdates(true)
    }

    companion object {
        const val TAG = "EventActivityViewModel"
    }
}