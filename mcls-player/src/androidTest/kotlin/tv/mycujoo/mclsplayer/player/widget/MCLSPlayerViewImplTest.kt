package tv.mycujoo.mclsplayer.player.widget

import android.app.Application
import android.os.Handler
import android.os.Looper
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.exoplayer2.ExoPlayer
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import tv.mycujoo.mclscore.model.Stream
import tv.mycujoo.mclsplayer.player.DebugActivity
import tv.mycujoo.mclsplayer.player.EventFactory
import tv.mycujoo.mclsplayer.player.MCLSPlayer

@RunWith(AndroidJUnit4::class)
class MCLSPlayerViewImplTest {

    @get:Rule
    val activity = activityScenarioRule<DebugActivity>()

    private val context = ApplicationProvider.getApplicationContext<Application>()

    private val workingStreamUrl = "https://europe-west-hls.mls.mycujoo.tv/esgp/clb3fuaog0279017240juwas9/master.m3u8"

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

            mclsPlayer?.playEvent(EventFactory.getEvent(
                streams = listOf(
                    Stream(
                        id = "1",
                        fullUrl = workingStreamUrl,
                        widevine = null,
                        dvrWindowString = null,
                    )
                )
            ))
        }

        Thread.sleep(6000)

        Handler(Looper.getMainLooper()) {
            exoPlayer.isPlaying shouldBeEqualTo true
            exoPlayer.currentMediaItem?.localConfiguration?.uri.toString() shouldBeEqualTo workingStreamUrl
            true
        }
    }
}
