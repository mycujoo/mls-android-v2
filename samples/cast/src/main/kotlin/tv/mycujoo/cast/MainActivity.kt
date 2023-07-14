package tv.mycujoo.cast

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import tv.mycujoo.cast.databinding.ActivityMainBinding
import tv.mycujoo.mclscast.MCLSCast
import tv.mycujoo.mclscast.manager.CastApplicationListener
import tv.mycujoo.mclscore.entity.StreamStatus

class MainActivity : AppCompatActivity(), CastApplicationListener {

    private val vm: MainActivityViewModel by viewModels()

    var castPlayer: MCLSCast? = null
    lateinit var binding: ActivityMainBinding

    private val adapter = MCLSEventsAdapter {
        vm.playEvent(it.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
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
            .withPublicKey("PUBLIC_KEY_HERE")
            .build {
                castPlayer = it
                it.addListener(this)
            }

        startListening()
    }

    override fun onApplicationConnected() {
        Log.d(TAG, "onApplicationConnected: ")
        binding.remotePlayerView.visibility = View.VISIBLE
    }

    override fun onApplicationDisconnected() {
        Log.d(TAG, "onApplicationDisconnected: ")
        binding.remotePlayerView.visibility = View.GONE
    }

    private fun startListening() {
        vm.events.observe(this) {
            adapter.submitList(it)
        }

        vm.activeEvent.observe(this) {
            castPlayer?.playEvent(it)
            adapter.setActiveEventId(it.id)
        }

        vm.error.observe(this) {
            Snackbar.make(
                binding.root,
                it,
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}