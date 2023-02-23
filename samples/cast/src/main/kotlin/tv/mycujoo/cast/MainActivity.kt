package tv.mycujoo.cast

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import tv.mycujoo.cast.databinding.ActivityMainBinding
import tv.mycujoo.mclscast.MCLSCast
import tv.mycujoo.mclscast.manager.CastApplicationListener

class MainActivity : AppCompatActivity() {

    private val vm: MainActivityViewModel by viewModels()

    var castPlayer: MCLSCast? = null

    private val adapter = MCLSEventsAdapter {
        castPlayer?.playEvent(it, true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm.buildClient(this)
        vm.getEvents()
        binding.rvEvents.adapter = adapter

        MCLSCast
            .Builder()
            .withActivity(this)
            .withAppId("4381F502")
            .withMediaButton(binding.mediaRouteButton)
            .withLifecycle(lifecycle)
            .withRemotePlayerView(binding.remotePlayerView)
            .withPublicKey("FBVKACGN37JQC5SFA0OVK8KKSIOP153G")
            .build {
                castPlayer = it
            }

        castPlayer?.addListener(object : CastApplicationListener {
            override fun onApplicationConnected() {
                binding.remotePlayerView.visibility = View.VISIBLE
            }

            override fun onApplicationDisconnected() {
                binding.remotePlayerView.visibility = View.GONE
            }
        })

        startListening()
    }

    private fun startListening() {
        vm.events.observe(this) {
            adapter.submitList(it)
        }
    }
}