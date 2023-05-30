package tv.mycujoo.samplemcls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.MCLSStream
import tv.mycujoo.mclsplayer.compose.MCLSVideo

class MainActivity : ComponentActivity() {

    private val mclsPlayer = MCLSVideo()

    private val eventToPlay = MCLSEvent(
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                mclsPlayer.MCLSPlayerView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Dp(240F))
                )
                Button(
                    onClick = {
                        mclsPlayer.playEvent(eventToPlay)
                    }
                ) {
                    Text(text = "Play Event")
                }
            }
        }
    }
}