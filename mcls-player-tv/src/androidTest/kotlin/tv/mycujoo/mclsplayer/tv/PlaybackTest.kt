package tv.mycujoo.mclsplayer.tv

import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Rule
import org.junit.Test
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.MCLSStream
import tv.mycujoo.mclsplayer.tv.ui.MCLSTVFragment

class PlaybackTest {

    @get:Rule
    val mainActivityScenario = activityScenarioRule<TvTestActivity>()

    @Test
    fun testPlayback() {
        Thread.sleep(3000)

        val frag = MCLSTVFragment()

        mainActivityScenario.scenario.onActivity {
            it.supportFragmentManager
                .beginTransaction()
                .replace(it.binding.fragmentContainer.id, frag)
                .commit()

            val player = MCLSTVPlayer.Builder()
                .withContext(it)
                .withMCLSTvFragment(frag)
                .withLifecycle(frag.lifecycle)
                .build()

            player.playEvent(
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

        Thread.sleep(10000)
    }
}