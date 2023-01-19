package tv.mycujoo.mclsplayer.player.widget

import android.app.Application
import android.os.Handler
import android.os.Looper
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement
import com.google.android.exoplayer2.ExoPlayer
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.*
import timber.log.Timber
import tv.mycujoo.mclscore.model.Err
import tv.mycujoo.mclscore.model.Stream
import tv.mycujoo.mclsplayer.R
import tv.mycujoo.mclsplayer.player.DebugActivity
import tv.mycujoo.mclsplayer.player.EventFactory
import tv.mycujoo.mclsplayer.player.MCLSPlayer
import tv.mycujoo.mclsplayer.player.getMockExoPlayer
import java.util.*

@RunWith(AndroidJUnit4::class)
class MCLSPlayerViewImplTest {

    @get:Rule
    val activity = activityScenarioRule<DebugActivity>()

    private val context = ApplicationProvider.getApplicationContext<Application>()

    private val workingStreamUrl =
        "https://europe-west-hls.mls.mycujoo.tv/esgp/clb3fuaog0279017240juwas9/master.m3u8"

    @Before
    fun setup() {
        Timber.plant(Timber.DebugTree())
    }

    @Test
    fun testPlayback() {
        var mclsPlayer: MCLSPlayer?
        val exoPlayer = ExoPlayer.Builder(context).build()

        activity.scenario.onActivity {
            val playerView = MCLSPlayerViewImpl(it)
            it.binding.frame.addView(playerView)

            mclsPlayer = MCLSPlayer.Builder()
                .withContext(it)
                .withExoPlayer(exoPlayer)
                .withPlayerView(playerView)
                .build()

            mclsPlayer?.playEvent(
                EventFactory.getEvent(
                    streams = listOf(
                        Stream(
                            id = "1",
                            fullUrl = workingStreamUrl,
                            widevine = null,
                            dvrWindowString = null,
                        )
                    )
                )
            )
        }

        Thread.sleep(2000)

        Handler(Looper.getMainLooper()).post {
            exoPlayer.isPlaying shouldBeEqualTo true
            exoPlayer.currentMediaItem?.localConfiguration?.uri.toString() shouldBeEqualTo workingStreamUrl
        }
    }

    @Test
    fun testScheduledEvent() {
        var mclsPlayer: MCLSPlayer?
        val exoPlayer = ExoPlayer.Builder(context).build()

        activity.scenario.onActivity {
            val playerView = MCLSPlayerViewImpl(it)
            it.binding.frame.addView(playerView)

            mclsPlayer = MCLSPlayer.Builder()
                .withContext(it)
                .withExoPlayer(exoPlayer)
                .withPlayerView(playerView)
                .build()

            val cal = Calendar.getInstance()
            // Month is indexed from 0, so this is December, and should be outputted as 12 in string
            cal.set(2022, 11, 1, 11, 0, 30)

            mclsPlayer?.playEvent(
                EventFactory.getEvent(
                    streams = listOf(),
                    title = "Test Event",
                    description = "Test Description",
                    start_time = cal
                )
            )
        }

        Handler(Looper.getMainLooper()).post {
            exoPlayer.isPlaying shouldBeEqualTo false
        }

        onView(withId(R.id.preEventInfoDialog_titleTextView))
            .check(matches(withText("Test Event")))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.preEventInfoDialog_bodyTextView))
            .check(matches(withText("Test Description")))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.preEventInfoDialog_startTimeTextView))
            .check(matches(withText("01-12-2022 - 11:00")))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun testSwitchingEventsFromScheduledToOngoingEvent() {
        var mclsPlayer: MCLSPlayer? = null
        val exoPlayer = ExoPlayer.Builder(context).build()

        activity.scenario.onActivity {
            val playerView = MCLSPlayerViewImpl(it)
            it.binding.frame.addView(playerView)

            mclsPlayer = MCLSPlayer.Builder()
                .withContext(it)
                .withExoPlayer(exoPlayer)
                .withPlayerView(playerView)
                .build()

            val cal = Calendar.getInstance()
            // Month is indexed from 0, so this is December, and should be outputted as 12 in string
            cal.set(2022, 11, 1, 11, 0, 30)

            mclsPlayer?.playEvent(
                EventFactory.getEvent(
                    streams = listOf(),
                    title = "Test Event",
                    description = "Test Description",
                    start_time = cal
                )
            )
        }

        Handler(Looper.getMainLooper()).post {
            exoPlayer.isPlaying shouldBeEqualTo false
        }

        onView(withId(R.id.preEventInfoDialog_titleTextView))
            .check(matches(withText("Test Event")))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.preEventInfoDialog_bodyTextView))
            .check(matches(withText("Test Description")))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.preEventInfoDialog_startTimeTextView))
            .check(matches(withText("01-12-2022 - 11:00")))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

        UiThreadStatement.runOnUiThread {
            mclsPlayer?.playEvent(
                EventFactory.getEvent(
                    streams = listOf(
                        Stream(
                            id = "1",
                            fullUrl = workingStreamUrl,
                            widevine = null,
                            dvrWindowString = null,
                        )
                    )
                )
            )
        }

        Thread.sleep(2000)

        Handler(Looper.getMainLooper()).post {
            exoPlayer.isPlaying shouldBeEqualTo true
            exoPlayer.currentMediaItem?.localConfiguration?.uri.toString() shouldBeEqualTo workingStreamUrl
        }
    }

    @Test
    fun testPlayingTheSameEventTwice() {
        var mclsPlayer: MCLSPlayer? = null
        val exoPlayer: ExoPlayer = ExoPlayer.Builder(context).build()

        activity.scenario.onActivity {
            val playerView = MCLSPlayerViewImpl(it)
            it.binding.frame.addView(playerView)

            mclsPlayer = MCLSPlayer.Builder()
                .withContext(it)
                .withExoPlayer(exoPlayer)
                .withPlayerView(playerView)
                .build()
        }

        UiThreadStatement.runOnUiThread {
            mclsPlayer?.playEvent(
                EventFactory.getEvent(
                    streams = listOf(
                        Stream(
                            id = "1",
                            fullUrl = workingStreamUrl,
                            widevine = null,
                            dvrWindowString = null,
                        )
                    )
                )
            )
        }

        Thread.sleep(2000)

        var timeStamp1: Long? = null

        UiThreadStatement.runOnUiThread {
            timeStamp1 = mclsPlayer?.player?.getExoPlayerInstance()?.currentPosition!!
            mclsPlayer?.playEvent(
                EventFactory.getEvent(
                    streams = listOf(
                        Stream(
                            id = "1",
                            fullUrl = workingStreamUrl,
                            widevine = null,
                            dvrWindowString = null,
                        )
                    )
                )
            )
        }

        Thread.sleep(2000)

        var timeStamp2: Long? = null

        UiThreadStatement.runOnUiThread {
            timeStamp2 = mclsPlayer?.player?.getExoPlayerInstance()?.currentPosition!!
        }

        // Make sure the timer didn't reset => play and prepare was not triggered twice
        assert(timeStamp2!! > timeStamp1!!)
    }

    @Test
    fun testPlayingSwitchingEvents() {
        var mclsPlayer: MCLSPlayer? = null
        val exoPlayer: ExoPlayer = getMockExoPlayer()

        activity.scenario.onActivity {
            val playerView = MCLSPlayerViewImpl(it)
            it.binding.frame.addView(playerView)

            mclsPlayer = MCLSPlayer.Builder()
                .withContext(it)
                .withExoPlayer(exoPlayer)
                .withPlayerView(playerView)
                .build()
        }

        mclsPlayer?.playEvent(
            EventFactory.getEvent(
                id = "1",
                streams = listOf(
                    Stream(
                        id = "1",
                        fullUrl = "https://example.com/vid1.mp4",
                        widevine = null,
                        dvrWindowString = null,
                    )
                )
            )
        )

        mclsPlayer?.playEvent(
            EventFactory.getEvent(
                id = "2",
                streams = listOf(
                    Stream(
                        id = "1",
                        fullUrl = "https://example.com/vid2.mp4",
                        widevine = null,
                        dvrWindowString = null,
                    )
                )
            )
        )

        verify(exoPlayer, times(2))
            .setMediaSource(any(), any<Boolean>())
    }

    @Test
    fun testPlayingGeoBlockedEvent() {
        var mclsPlayer: MCLSPlayer? = null
        val exoPlayer: ExoPlayer = ExoPlayer.Builder(context).build()

        activity.scenario.onActivity {
            val playerView = MCLSPlayerViewImpl(it)
            it.binding.frame.addView(playerView)

            mclsPlayer = MCLSPlayer.Builder()
                .withContext(it)
                .withExoPlayer(exoPlayer)
                .withPlayerView(playerView)
                .build()
        }

        UiThreadStatement.runOnUiThread {
            mclsPlayer?.playEvent(
                EventFactory.getEvent(
                    id = "1",
                    title = "Test Event",
                    streams = listOf(
                        Stream(
                            fullUrl = null,
                            widevine = null,
                            dvrWindowString = null,
                            id = "1",
                            err = Err(
                                "ERROR_CODE_GEOBLOCKED",
                                "ERROR_CODE_GEOBLOCKED",
                            ),
                        )
                    )
                )
            )
        }

        onView(withId(R.id.preEventInfoDialog_bodyTextView))
            .check(matches(withText(R.string.message_geoblocked_stream)))

        onView(withId(R.id.preEventInfoDialog_titleTextView))
            .check(matches(withText("Test Event")))

        UiThreadStatement.runOnUiThread {
            mclsPlayer!!.player.getExoPlayerInstance()?.isPlaying shouldBeEqualTo false
        }
    }

    @Test
    fun testPlayingNonEntitledEvent() {
        var mclsPlayer: MCLSPlayer? = null
        val exoPlayer: ExoPlayer = ExoPlayer.Builder(context).build()

        activity.scenario.onActivity {
            val playerView = MCLSPlayerViewImpl(it)
            it.binding.frame.addView(playerView)

            mclsPlayer = MCLSPlayer.Builder()
                .withContext(it)
                .withExoPlayer(exoPlayer)
                .withPlayerView(playerView)
                .build()

            it.lifecycle.addObserver(mclsPlayer!!)
        }

        UiThreadStatement.runOnUiThread {
            mclsPlayer?.playEvent(
                EventFactory.getEvent(
                    id = "1",
                    title = "Test Event",
                    streams = listOf(
                        Stream(
                            fullUrl = null,
                            widevine = null,
                            dvrWindowString = null,
                            id = "1",
                            err = Err(
                                "ERROR_CODE_NO_ENTITLEMENT",
                                "ERROR_CODE_NO_ENTITLEMENT",
                            ),
                        )
                    )
                )
            )
        }

        onView(withId(R.id.preEventInfoDialog_bodyTextView))
            .check(matches(withText(R.string.message_no_entitlement_stream)))

        onView(withId(R.id.preEventInfoDialog_titleTextView))
            .check(matches(withText("Test Event")))

        UiThreadStatement.runOnUiThread {
            mclsPlayer!!.player.getExoPlayerInstance()?.isPlaying shouldBeEqualTo false
        }
    }
}
