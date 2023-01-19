package tv.mycujoo.annotation

import android.app.Application
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import timber.log.Timber
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.widget.AnnotationView
import tv.mycujoo.annotation.widget.ScaffoldView
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.PositionGuide
import tv.mycujoo.mclscore.model.SvgData
import tv.mycujoo.mclscore.model.ViewSpec

@RunWith(AndroidJUnit4::class)
class OverlayPositioningTest {

    @get:Rule
    val activityRule = activityScenarioRule<DebugActivity>()

    val app = ApplicationProvider.getApplicationContext<Application>()

    @Before
    fun setUp() {
        Timber.plant(Timber.DebugTree())
    }

    @Test
    fun testOverlayPositionTopLeft() {
        val annotationView = AnnotationView(app)

        var currentPosition = 1000L

        activityRule.scenario.onActivity {
            val params = it.binding.root.layoutParams
            annotationView.layoutParams = params
            it.binding.root.addView(annotationView)
        }
        annotationView.setActions(generateTestOverlaysWithLeftTopGuide())
        // Attaching triggers First Event
        annotationView.attachPlayer(object : VideoPlayer {
            override fun currentPosition(): Long {
                return currentPosition
            }
        })

        // Allowing views to inflate. Usually this take anywhere between 50 millis and 200 millis
        Thread.sleep(600)

        annotationView.children.forEach {
            if (it !is ScaffoldView) {
                return@forEach
            }
            val position = "${it.tag}".toInt()
            val layoutParams = it.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.verticalBias shouldBeEqualTo (position * 20f) / 100
            layoutParams.horizontalBias shouldBeEqualTo (position * 20f) / 100
        }

        annotationView.children.filter { it is ScaffoldView }.count() shouldBeEqualTo 5

        currentPosition = 5001

        // This ensures that the update cycle is triggered. Just make it slightly bigger than the refresh rate in Annotation View
        Thread.sleep(1500)

        annotationView.children.filter { it is ScaffoldView }.count() shouldBeEqualTo 0
        currentPosition = 7001

        annotationView.children.forEach {
            if (it !is ScaffoldView) {
                return@forEach
            }
            val position = "${it.tag}".toInt()
            val layoutParams = it.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.verticalBias shouldBeEqualTo (position * 20f) / 100
            layoutParams.horizontalBias shouldBeEqualTo (position * 20f) / 100
        }
    }

    /**
     * Test the Positions of Scoreboard Overlays using the following guides:
     *      Top-Right
     */
    @Test
    fun testOverlayPositionTopRight() {
        val annotationView = AnnotationView(app)

        var currentPosition = 1000L

        activityRule.scenario.onActivity {
            val params = it.binding.root.layoutParams
            annotationView.layoutParams = params
            it.binding.root.addView(annotationView)
        }
        annotationView.setActions(generateTestOverlaysWithRightTopGuide())
        // Attaching triggers First Event
        annotationView.attachPlayer(object : VideoPlayer {
            override fun currentPosition(): Long {
                return currentPosition
            }
        })

        Thread.sleep(600)

        annotationView.children.filter { it is ScaffoldView }.count() shouldBeEqualTo 5

        annotationView.children.forEach {
            if (it !is ScaffoldView) {
                return@forEach
            }
            val position = "${it.tag}".toInt()
            val layoutParams = it.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.verticalBias shouldBeEqualTo (position * 20f) / 100
            layoutParams.horizontalBias shouldBeEqualTo 1 - ((position * 20f) / 100)
        }

        currentPosition = 5001
        Thread.sleep(1500)
        annotationView.children.filter { it is ScaffoldView }.count() shouldBeEqualTo 0

        currentPosition = 7001
        Thread.sleep(1500)

        annotationView.children.forEach {
            if (it !is ScaffoldView) {
                return@forEach
            }
            val position = "${it.tag}".toInt()
            val layoutParams = it.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.verticalBias shouldBeEqualTo (position * 20f) / 100
            layoutParams.horizontalBias shouldBeEqualTo 1 - ((position * 20f) / 100)
        }
    }

    /**
     * This Data Represent the folowing:
     *      1. Show 5 Overlays at Offset 0
     *      2. Hide those 5 overlays at Offset 5000
     *      3. Show 5 Overlays at Offset 7000
     */
    private fun generateTestOverlaysWithLeftTopGuide(): List<AnnotationAction> {
        val actionsList = TestData.getSampleScoreboardActionsList()
        for (i in 0 until 5) {
            actionsList.add(
                AnnotationAction.ShowOverlayAction(
                    id = "overlay_$i",
                    absoluteTime = 0,
                    offset = 0,
                    svgData = SvgData(
                        svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                    ),
                    viewSpec = ViewSpec(
                        PositionGuide(left = i * 20f, top = i * 20f),
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
                )
            )

            actionsList.add(
                AnnotationAction.HideOverlayAction(
                    id = "overlay_$i",
                    absoluteTime = 0,
                    offset = 5000,
                    customId = "$i",
                )
            )

            actionsList.add(
                AnnotationAction.ShowOverlayAction(
                    id = "overlay_$i",
                    absoluteTime = 0,
                    offset = 7000,
                    svgData = SvgData(
                        svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                    ),
                    viewSpec = ViewSpec(
                        PositionGuide(left = i * 20f, top = i * 20f),
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
                )
            )
        }

        return actionsList
    }

    /**
     * This Data Represent the folowing:
     *      1. Show 5 Overlays at Offset 0
     *      2. Hide those 5 overlays at Offset 5000
     *      3. Show 5 Overlays at Offset 7000
     */
    private fun generateTestOverlaysWithRightTopGuide(): List<AnnotationAction> {
        val actionsList = TestData.getSampleScoreboardActionsList()
        for (i in 0 until 5) {
            actionsList.add(
                AnnotationAction.ShowOverlayAction(
                    id = "overlay_$i",
                    absoluteTime = 0,
                    offset = 0,
                    svgData = SvgData(
                        svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                    ),
                    viewSpec = ViewSpec(
                        PositionGuide(right = i * 20f, top = i * 20f),
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
                )
            )

            actionsList.add(
                AnnotationAction.HideOverlayAction(
                    id = "overlay_$i",
                    absoluteTime = 0,
                    offset = 5000,
                    customId = "$i",
                )
            )

            actionsList.add(
                AnnotationAction.ShowOverlayAction(
                    id = "overlay_$i",
                    absoluteTime = 0,
                    offset = 7000,
                    svgData = SvgData(
                        svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                    ),
                    viewSpec = ViewSpec(
                        PositionGuide(right = i * 20f, top = i * 20f),
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
                )
            )
        }

        return actionsList
    }
}
