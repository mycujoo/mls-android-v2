package tv.mycujoo.player

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.Stream
import tv.mycujoo.mclsplayer.player.MCLSPlayer
import tv.mycujoo.player.databinding.ActivityPlaybackBinding

class PlaybackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPlaybackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player = MCLSPlayer.Builder()
            .withPlayerView(binding.mclsPlayerView)
            .withActivity(this)
            .withContext(this)
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
                    Stream(
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