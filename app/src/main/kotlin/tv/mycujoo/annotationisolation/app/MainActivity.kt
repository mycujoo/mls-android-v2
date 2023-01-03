package tv.mycujoo.annotationisolation.app

import android.content.UriPermission
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import dagger.android.AndroidInjection
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.joda.time.DateTime
import timber.log.Timber
import tv.mycujoo.mclsui.ExoAnnotationViewBuilder
import tv.mycujoo.annotationisolation.databinding.ActivityMainBinding
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.*
import tv.mycujoo.mclsext.fetchActionsByEventId
import tv.mycujoo.mclsplayer.player.MCLSPlayer
import tv.mycujoo.mlsdata.MCLSData


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var isFullScreen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mclsView.playEvent("2FIj79Gm2gqZhvom8w778KX07Cl")
        binding.mclsView.setActions(getActions())

//        val mclsPlayer = MCLSPlayer.Builder()
//            .withContext(this)
//            .withPlayerView(binding.mclsPlayerView)
//            .withOnFullScreenButtonClicked { fullScreen ->
//                Timber.d("Full Screen Request $fullScreen")
//                isFullScreen = fullScreen
//                requestedOrientation = if (fullScreen) {
//                    ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE
//                } else {
//                    ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT
//                }
//            }
//            .build()
//
//        lifecycleScope.launch {
//            val data = MCLSData
//                .builder()
//                .withContext(this@MainActivity)
//                .withPublicKey("FBVKACGN37JQC5SFA0OVK8KKSIOP153G")
//                .build()
//
//            try {
//                data
//                    .getEventDetails("2FIj79Gm2gqZhvom8w778KX07Cl")
//                    .collect {
//                        mclsPlayer.playEvent(it)
//                    }
//            } catch (e: Exception) {
//                Timber.d("Error $e")
//            }
//        }

//        mclsPlayer.playEvent(
//            EventEntity(
//                id = "1",
//                description = "DESC",
//                is_test = true,
//                is_protected = false,
//                isNativeMLS = false,
//                organiser = null,
//                metadata = null,
//                location = null,
//                poster_url = null,
//                start_time = DateTime.now(),
//                status = EventStatus.EVENT_STATUS_STARTED,
//                streams = listOf(
//                    Stream(
//                        id = "5",
//                        fullUrl = "https://europe-west-hls.mls.mycujoo.tv/esgp/clb3fuaog0279017240juwas9/master.m3u8",
//                        dvrWindowString = null,
//                        widevine = null,
//                    )
//                ),
//                timeline_ids = listOf(),
//                thumbnailUrl = null,
//                title = "Event",
//                timezone = null,
//            )
//        )

//        val exoPlayer = ExoPlayer.Builder(this).build()
//        binding.playerView.player = exoPlayer
//
//        val mediaItem =
//            MediaItem.fromUri("https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
//        exoPlayer.setMediaItem(mediaItem)
//        exoPlayer.prepare()
//        exoPlayer.play()
//
//        val annotationView = ExoAnnotationViewBuilder()
//            .withActivity(this)
//            .withPlayer(exoPlayer)
//            .build()
//
//        annotationView.setMCLSActions(
//            getActions()
//        )
//
//
//        val mMCLSData = MCLSData
//            .builder()
//            .withContext(this)
//            .withPublicKey("FBVKACGN37JQC5SFA0OVK8KKSIOP153G")
//            .build()
//
//
//        lifecycleScope.launch {
//            mMCLSData.fetchActionsByEventId("2FIj79Gm2gqZhvom8w778KX07Cl").collect {
//                annotationView.setMCLSActions(it)
//            }
//        }

    }

    private fun getActions(): List<Action> {
        val actionsList = getSampleScoreboardActionsList()

        // region Top Left Action
        actionsList.add(
            Action.ShowOverlayAction(
                id = "overlay_topLeft",
                absoluteTime = 3000,
                offset = 3000,
                svgData = SvgData(
                    svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                ),
                viewSpec = ViewSpec(
                    PositionGuide(left = 0f, top = 0f),
                    Pair(35F, 100F)
                ),
                placeHolders = listOf(
                    "\$home_score",
                    "\$away_score",
                    "\$main_timer",
                    "\$home_abbr",
                    "\$away_abbr",
                    "\$home_color",
                    "\$away_color"
                ),
                customId = "topLeft",
            )
        )

        actionsList.add(
            Action.ShowOverlayAction(
                id = "overlay_topLeft",
                absoluteTime = 3000,
                offset = 7000,
                svgData = SvgData(
                    svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                ),
                viewSpec = ViewSpec(
                    PositionGuide(left = 0f, top = 0f),
                    Pair(35F, 100F)
                ),
                placeHolders = listOf(
                    "\$home_score",
                    "\$away_score",
                    "\$main_timer",
                    "\$home_abbr",
                    "\$away_abbr",
                    "\$home_color",
                    "\$away_color"
                ),
                customId = "topLeft",
            )
        )

        actionsList.add(
            Action.HideOverlayAction(
                id = "overlay_topLeft",
                absoluteTime = 3000,
                offset = 5000,
                customId = "topLeft",
            )
        )
        // endregion

        // region Top Right Actions
        actionsList.add(
            Action.ShowOverlayAction(
                id = "overlay_topRight",
                absoluteTime = 3000,
                offset = 0,
                svgData = SvgData(
                    svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                ),
                viewSpec = ViewSpec(
                    PositionGuide(top = 20f, right = 20f),
                    Pair(35F, 100F)
                ),
                placeHolders = listOf(
                    "\$home_score",
                    "\$away_score",
                    "\$main_timer",
                    "\$home_abbr",
                    "\$away_abbr",
                    "\$home_color",
                    "\$away_color"
                ),
                customId = "topRight",
            )
        )

        actionsList.add(
            Action.ShowOverlayAction(
                id = "overlay_topRight",
                absoluteTime = 3000,
                offset = 7000,
                svgData = SvgData(
                    svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                ),
                viewSpec = ViewSpec(
                    PositionGuide(top = 20f, right = 20f),
                    Pair(35F, 100F)
                ),
                placeHolders = listOf(
                    "\$home_score",
                    "\$away_score",
                    "\$main_timer",
                    "\$home_abbr",
                    "\$away_abbr",
                    "\$home_color",
                    "\$away_color"
                ),
                customId = "topRight",
            )
        )

        actionsList.add(
            Action.HideOverlayAction(
                id = "overlay_topRight",
                absoluteTime = 3000,
                offset = 5000,
                customId = "topRight",
            )
        )
        // endregion

        // region Bottom Left Action
        actionsList.add(
            Action.ShowOverlayAction(
                id = "overlay_bottomLeft",
                absoluteTime = 3000,
                offset = 0,
                svgData = SvgData(
                    svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                ),
                viewSpec = ViewSpec(
                    PositionGuide(left = 40f, bottom = 40f),
                    Pair(35F, 100F)
                ),
                placeHolders = listOf(
                    "\$home_score",
                    "\$away_score",
                    "\$main_timer",
                    "\$home_abbr",
                    "\$away_abbr",
                    "\$home_color",
                    "\$away_color"
                ),
                customId = "bottomLeft",
            )
        )

        actionsList.add(
            Action.ShowOverlayAction(
                id = "overlay_bottomLeft",
                absoluteTime = 3000,
                offset = 7000,
                svgData = SvgData(
                    svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                ),
                viewSpec = ViewSpec(
                    PositionGuide(left = 40f, bottom = 40f),
                    Pair(35F, 100F)
                ),
                placeHolders = listOf(
                    "\$home_score",
                    "\$away_score",
                    "\$main_timer",
                    "\$home_abbr",
                    "\$away_abbr",
                    "\$home_color",
                    "\$away_color"
                ),
                customId = "bottomLeft",
            )
        )

        actionsList.add(
            Action.HideOverlayAction(
                id = "overlay_bottomLeft",
                absoluteTime = 3000,
                offset = 5000,
                customId = "bottomLeft",
            )
        )
        // endregion

        // region Bottom Right Action
        actionsList.add(
            Action.ShowOverlayAction(
                id = "overlay_bottomRight",
                absoluteTime = 3000,
                offset = 0,
                svgData = SvgData(
                    svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                ),
                viewSpec = ViewSpec(
                    PositionGuide(bottom = 60f, right = 60f),
                    Pair(35F, 100F)
                ),
                placeHolders = listOf(
                    "\$home_score",
                    "\$away_score",
                    "\$main_timer",
                    "\$home_abbr",
                    "\$away_abbr",
                    "\$home_color",
                    "\$away_color"
                ),
                customId = "bottomRight",
            )
        )

        actionsList.add(
            Action.ShowOverlayAction(
                id = "overlay_bottomRight",
                absoluteTime = 3000,
                offset = 7000,
                svgData = SvgData(
                    svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                ),
                viewSpec = ViewSpec(
                    PositionGuide(bottom = 60f, right = 60f),
                    Pair(35F, 100F)
                ),
                placeHolders = listOf(
                    "\$home_score",
                    "\$away_score",
                    "\$main_timer",
                    "\$home_abbr",
                    "\$away_abbr",
                    "\$home_color",
                    "\$away_color"
                ),
                customId = "bottomRight",
            )
        )

        actionsList.add(
            Action.HideOverlayAction(
                id = "overlay_bottomRight",
                absoluteTime = 3000,
                offset = 5000,
                customId = "bottomRight",
            )
        )
        // endregion


        for (i in 0..10) {
            actionsList.add(
                Action.ShowOverlayAction(
                    id = "overlay_$i",
                    absoluteTime = 3000,
                    offset = 5000,
                    svgData = SvgData(
                        svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                    ),
                    viewSpec = ViewSpec(
                        PositionGuide(bottom = i * 2f, left = i * 2f),
                        Pair(35F, 100F)
                    ),
                    placeHolders = listOf(
                        "\$home_score",
                        "\$away_score",
                        "\$main_timer",
                        "\$home_abbr",
                        "\$away_abbr",
                        "\$home_color",
                        "\$away_color"
                    ),
                    customId = "$i",
                    duration = 600000
                )
            )

            actionsList.add(
                Action.HideOverlayAction(
                    id = "overlay_$i",
                    absoluteTime = 3000,
                    offset = 50000,
                    customId = "$i",
                )
            )
        }

        return actionsList
    }

    private fun getSampleScoreboardActionsList(): MutableList<Action> {
        val actionsList = mutableListOf<Action>()

        actionsList.add(
            Action.CreateTimerAction(
                id = "timer",
                absoluteTime = 0,
                offset = 0,
                name = "\$main_timer",
                capValue = 100000,
            )
        )

        actionsList.add(
            Action.StartTimerAction(
                id = "timer",
                absoluteTime = 0,
                offset = 0,
                name = "\$main_timer"
            )
        )

        // home team score
        actionsList.add(
            Action.CreateVariableAction(
                id = "2",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.LongVariable("\$home_score", 0L)
            )
        )

        // away team score
        actionsList.add(
            Action.CreateVariableAction(
                id = "3",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.LongVariable("\$away_score", 0L)
            )
        )

        // home team abbreviation
        actionsList.add(
            Action.CreateVariableAction(
                id = "4",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.StringVariable("\$home_abbr", "HOME")
            )
        )

        // away team abbreviation
        actionsList.add(
            Action.CreateVariableAction(
                id = "5",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.StringVariable("\$away_abbr", "AWAY")
            )
        )

        // home team color
        actionsList.add(
            Action.CreateVariableAction(
                id = "6",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.StringVariable("\$home_color", "#FFFFFF")
            )
        )

        // away team color
        actionsList.add(
            Action.CreateVariableAction(
                id = "7",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.StringVariable("\$away_color", "#FFFFFF")
            )
        )

        // announcement_line1, used for Goal overlay
        actionsList.add(
            Action.CreateVariableAction(
                id = "8",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.StringVariable("\$announcement_line1", "Goal")
            )
        )

        return actionsList
    }
}
