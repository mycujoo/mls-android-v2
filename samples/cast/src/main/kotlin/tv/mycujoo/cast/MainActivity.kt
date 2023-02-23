package tv.mycujoo.cast

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import tv.mycujoo.cast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val vm: MainActivityViewModel by viewModels()

    private val adapter = MCLSEventsAdapter {
        // Play in Connected Device
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm.buildClient(this)
        vm.getEvents()
        binding.rvEvents.adapter = adapter

        startListening()
    }

    private fun startListening() {
        vm.events.observe(this) {
            adapter.submitList(it)
        }
    }
}