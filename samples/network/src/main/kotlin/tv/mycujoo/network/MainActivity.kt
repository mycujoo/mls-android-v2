package tv.mycujoo.network

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import tv.mycujoo.network.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val vm: MainActivityViewModel by viewModels()

    private val adapter = MCLSEventsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm.buildClient(this)
        vm.getEvents()

        startListening()
    }

    private fun startListening() {
        vm.events.observe(this) {
            adapter.submitList(it)
        }
    }
}