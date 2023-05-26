package tv.mycujoo.network

import android.os.Bundle
import android.view.View.VISIBLE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import tv.mycujoo.network.databinding.ActivityEventBinding
import java.util.*

class ReactiveEventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventBinding

    private val adapter = ActionsAdapter()
    private val vm: ReactiveEventActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm.buildClient(this)

        binding.rvActions.adapter = adapter
        intent.getStringExtra(KEY_EVENT_ID)?.let {
            vm.joinEventAndTimelineUpdates(it)
        }

        startObservers()
    }

    fun startObservers() {
        vm.event.observe(this) {
            binding.title.text = it.title
            binding.dateAndTime.text = it.getFormattedStartTimeDate(Locale.ENGLISH)
            binding.status.text = it.status.name.split("_").last()
        }

        vm.annotationAction.observe(this) {
            adapter.submitAnnotationActions(it)
            binding.rvActions.visibility = VISIBLE
        }
    }

    companion object {
        const val KEY_EVENT_ID = "EVENT_ID"
    }
}