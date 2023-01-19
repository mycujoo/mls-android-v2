package tv.mycujoo.samplemcls

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import timber.log.Timber
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.model.Stream
import tv.mycujoo.mclsplayer.compose.MCLSVideo
import java.util.Calendar

class MainActivity : ComponentActivity() {

    private val composePlayer = MCLSVideo()

    var event: EventEntity = sampleEvent1()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                Text(text = "Number")
                Button(
                    onClick = {
                        Timber.d("Click!!!")
                        if (event == sampleEvent1()) {
                            event = sampleEvent2()
                            composePlayer.playEvent(event)
                        } else {
                            event = sampleEvent1()
                            composePlayer.playEvent(event)
                        }
                    }
                ) {
                    Text(text = "Click Me")
                }

                composePlayer.MCLSPlayerView(
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }

    private fun sampleEvent1() = EventEntity(
        id = "1",
        description = "DESC",
        is_test = true,
        is_protected = false,
        isMLS = false,
        organiser = null,
        metadata = null,
        location = null,
        poster_url = null,
        start_time = Calendar.getInstance(),
        status = EventStatus.EVENT_STATUS_STARTED,
        streams = listOf(
            Stream(
                id = "5",
                fullUrl = "https://europe-west-hls.mls.mycujoo.tv/esgp/clb3fuaog0279017240juwas9/master.m3u8",
                dvrWindowString = null,
                widevine = null,
            )
        ),
        timeline_ids = listOf(),
        thumbnailUrl = null,
        title = "Event",
        timezone = null,
    )

    private fun sampleEvent2() = EventEntity(
        id = "1",
        description = "DESC",
        is_test = true,
        is_protected = false,
        isMLS = false,
        organiser = null,
        metadata = null,
        location = null,
        poster_url = null,
        start_time = Calendar.getInstance(),
        status = EventStatus.EVENT_STATUS_STARTED,
        streams = listOf(
            Stream(
                id = "5",
                fullUrl = "https://europe-west-hls.mls.mycujoo.tv/esgp/clb3fuaog0279017240juwas9/master.m3u8",
                dvrWindowString = null,
                widevine = null,
            )
        ),
        timeline_ids = listOf(),
        thumbnailUrl = null,
        title = "Event",
        timezone = null,
    )
}