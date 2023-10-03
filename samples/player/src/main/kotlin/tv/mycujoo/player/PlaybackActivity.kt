package tv.mycujoo.player

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.MCLSStream
import tv.mycujoo.mclsima.Ima
import tv.mycujoo.mclsplayer.player.MCLSPlayer
import tv.mycujoo.mclsplayercore.config.VideoPlayerConfig
import tv.mycujoo.player.databinding.ActivityPlaybackBinding

class PlaybackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPlaybackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val exoPlayer = ExoPlayer.Builder(this).build()

        val player = MCLSPlayer.Builder()
            .withPlayerView(binding.mclsPlayerView)
            .withActivity(this)
            .withExoPlayer(exoPlayer)
            .withContext(this)
            .withIma(
                Ima(
                    adUnit = getString(R.string.ima_adunit_vod),
                    liveAdUnit = getString(R.string.ima_adunit_live),
                    paramProvider = {
                        buildMap {
                            "event_id" to "1"
                        }
                    }
                )
            )
            .withPseudoUserId("TEST_PSEUDO_USER_ID")
            .withUserId("TEST_USER_ID")
            .withPlayerConfig(
                VideoPlayerConfig(
                    primaryColor = "#FFFFFF",
                    secondaryColor = "#000000",
                    autoPlay = true,
                    enableControls = false, // No Controls
                    showPlayPauseButtons = true,
                    showBackForwardsButtons = true,
                    showSeekBar = true,
                    showTimers = true,
                    showFullScreenButton = true,
                    showLiveViewers = true,
                    showEventInfoButton = false,
                    showPictureInPictureButton = false
                )
            )
            .build()

        // The event can be provided from the MCLSNetwork or it can mapped like this
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
}