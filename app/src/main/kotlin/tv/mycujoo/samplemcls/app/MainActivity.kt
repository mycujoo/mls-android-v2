package tv.mycujoo.samplemcls.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.entity.ServerConstants
import tv.mycujoo.mclscore.model.Err
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.MCLSStream
import tv.mycujoo.samplemcls.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playEvent1.setOnClickListener {
            binding.mclsView.playEvent(sampleEvent1())
            binding.mclsView.setOnFullScreenListener {
                Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show()
            }
//            binding.mclsView.setActions(getActions())
        }

        binding.playEvent2.setOnClickListener {
            binding.mclsView.playEvent("2Js0ryFLbJHDSjAFoOKp3bZylgf")
//            binding.mclsView.setActions(getActions())
        }

    }

    private fun sampleEvent1() = MCLSEvent(
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
            MCLSStream(
                id = "5",
                fullUrl = "https://devstreaming-cdn.apple.com/videos/streaming/examples/img_bipbop_adv_example_fmp4/master.m3u8",
                dvrWindowString = null,
                widevine = null,
            )
        ),
        timeline_ids = listOf(),
        thumbnailUrl = null,
        title = "Event",
        timezone = null,
    )

    private fun sampleGeoBlockedEvent() = MCLSEvent(
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
            MCLSStream(
                err = Err(
                    ServerConstants.ERROR_CODE_GEOBLOCKED,
                    ServerConstants.ERROR_CODE_GEOBLOCKED
                ),
                id = "5",
                fullUrl = null,
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
