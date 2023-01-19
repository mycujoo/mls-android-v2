package tv.mycujoo.samplemcls.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.model.Stream
import tv.mycujoo.samplemcls.app.SampleActions.getActions
import tv.mycujoo.samplemcls.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playEvent1.setOnClickListener {
            binding.mclsView.playEvent("2FIj79Gm2gqZhvom8w778KX07Cl")
            binding.mclsView.setActions(getActions())
        }

        binding.playEvent2.setOnClickListener {
            binding.mclsView.playEvent("2Js0ryFLbJHDSjAFoOKp3bZylgf")
            binding.mclsView.setActions(getActions())
        }

        binding.playEvent3.setOnClickListener {
            binding.remotePlayer.playEvent(sampleEvent1())
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
}
