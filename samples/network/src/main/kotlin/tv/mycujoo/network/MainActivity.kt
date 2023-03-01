package tv.mycujoo.network

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import tv.mycujoo.network.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val vm: MainActivityViewModel by viewModels()

    private val adapter = MCLSEventsAdapter {
        val intent = Intent(this, EventActivity::class.java)
        intent.putExtra(EventActivity.KEY_EVENT_ID, it.id)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm.buildClient(this)
        vm.getEvents()
        binding.rv.adapter = adapter

        startListening()
    }

    private fun startListening() {
        vm.events.observe(this) {
            adapter.submitList(it)
        }
    }
}