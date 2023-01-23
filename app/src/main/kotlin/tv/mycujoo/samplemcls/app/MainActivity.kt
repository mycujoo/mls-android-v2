package tv.mycujoo.samplemcls.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import tv.mycujoo.mclscast.CastApplicationListener
import tv.mycujoo.mclscast.CastListener
import tv.mycujoo.mclscast.MCLSCast
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.entity.ServerConstants
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclscore.model.Err
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.model.Stream
import tv.mycujoo.samplemcls.R
import tv.mycujoo.samplemcls.app.SampleActions.getActions
import tv.mycujoo.samplemcls.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var cast: MCLSCast? = null

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


        MCLSCast.Builder()
            .withMediaButton(binding.mediaRouteButton)
            .withAppId(getString(R.string.mcls_cast_app_id))
            .withPublicKey(getString(R.string.mcls_public_key))
            .withActivity(this)
            .withRemotePlayerView(binding.remotePlayer)
            .build {
                cast = it

                it.setLogLevel(LogLevel.VERBOSE)

                it.addListener(object : CastApplicationListener {
                    override fun onApplicationConnected() {
                        Timber.d("Connected")
                    }

                    override fun onApplicationDisconnected() {
                        Timber.d("Disconnected")
                    }

                })
            }

        binding.playEvent3.setOnClickListener {
            cast?.playEvent(sampleEvent1())
        }

        binding.playEvent4.setOnClickListener {
            cast?.playEvent(sampleGeoBlockedEvent())
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

    private fun sampleGeoBlockedEvent() = EventEntity(
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
