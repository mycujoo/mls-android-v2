package tv.mycujoo.tvplayer

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import timber.log.Timber
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.MCLSStream
import tv.mycujoo.mclsima.Ima
import tv.mycujoo.mclsplayer.tv.MCLSTVPlayer
import tv.mycujoo.mcls.tv.MCLSTVFragment
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.PositionGuide
import tv.mycujoo.mclscore.model.SvgData
import tv.mycujoo.mclscore.model.ViewSpec
import tv.mycujoo.tvplayer.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {

    private val mclsTvFragment = MCLSTVFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Timber.plant(Timber.DebugTree())

        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainer.id, mclsTvFragment)
            .commit()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()

        mclsTvFragment.playEvent(
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

        mclsTvFragment.setAnnotationActions(
            listOf(
                AnnotationAction.ShowOverlayAction(
                    absoluteTime = 0,
                    offset = 0,
                    id = "1",
                    duration = 5000,
                    svgData = SvgData(
                        svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                    ),
                    viewSpec = ViewSpec(
                        positionGuide = PositionGuide(
                            left = 0f,
                            top = 0f
                        ),
                        size = Pair(35F, 100F)
                    )
                )
            )
        )
    }
}