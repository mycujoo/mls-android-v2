package tv.mycujoo.samplemcls

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import tv.mycujoo.mcls.widget.MCLSView
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.model.Stream
import java.util.*

class MainActivity : ComponentActivity() {

    var mcls: MCLSView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MaterialTheme {
                Column {
                    Button(
                        onClick = {
                            mcls?.playEvent("2Krj7DLNFXngL3PRU99oxtie6of")
                        }
                    ) {
                        Text(text = "Click Me")
                    }

                    AndroidView(
                        factory = {
                            mcls = MCLSView(
                                context = it,
                            )

                        mcls?.initialize(
                            publicKey = getString(R.string.mcls_public_key),
                            castAppId = getString(R.string.mcls_cast_app_id),
                            liveAdUnit = getString(R.string.ima_adunit_live),
                            adUnit = getString(R.string.ima_adunit_vod),
                            concurrencyControlEnabled = false
                        )

                        mcls!!

//                            TextView(it)
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
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