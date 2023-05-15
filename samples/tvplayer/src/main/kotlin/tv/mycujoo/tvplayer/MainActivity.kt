package tv.mycujoo.tvplayer

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.MCLSStream
import tv.mycujoo.mclsima.Ima
import tv.mycujoo.mclsplayer.tv.MCLSTVPlayer
import tv.mycujoo.mcls.tv.MCLSTVFragment
import tv.mycujoo.tvplayer.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val frag = binding.fragmentContainer.getFragment<MCLSTVFragment>()

        MCLSTVPlayer.Builder()
            .withContext(this)
            .withMCLSTvFragment(frag)
            .withLifecycle(lifecycle)
            .withIma(Ima(
                adUnit = getString(R.string.ima_adunit_vod),
                liveAdUnit = getString(R.string.ima_adunit_live),
                paramProvider = {
                    buildMap {
                    }
                }
            ))
            .build()
            .playEvent(
                MCLSEvent(
                    id = "1",
                    title = "Awesome Title",
                    description = null,
                    thumbnailUrl = null,
                    poster_url = null,
                    location = null,
                    organiser = null,
                    start_time = null,
                    status = EventStatus.EVENT_STATUS_STARTED,
                    streams = listOf(
                        MCLSStream(
                            id = "StreamID",
                            fullUrl = "https://europe-west-hls.mls.mycujoo.tv/esgp/clb3fuaog0279017240juwas9/master.m3u8",
                            dvrWindowString = null,
                            widevine = null,
                        )
                    ),
                    timezone = null,
                    timeline_ids = emptyList(),
                    metadata = null,
                    is_test = true
                )
            )
    }
}