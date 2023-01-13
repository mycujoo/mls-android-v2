package tv.mycujoo.annotation

import android.content.UriPermission
import tv.mycujoo.annotation.domain.enum.C
import tv.mycujoo.mclscore.entity.AnimationType
import tv.mycujoo.mclscore.model.*

object TestData {
    val sampleSvgString = """
<?xml version="1.0" encoding="UTF-8"?>
<svg width="457px" height="69px" viewBox="0 0 457 69" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">
    <!-- Generator: Sketch 63.1 (92452) - https://sketch.com -->
    <title>Group 3</title>
    <desc>Created with Sketch.</desc>
    <g id="💬-Annotation-Overlays" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
        <g id="overlay-02-copy-3" transform="translate(-28.000000, -28.000000)">
            <g id="Group-3" transform="translate(28.000000, 28.000000)">
                <path d="M348,0 L450.009709,0 C453.87034,-7.5670452e-15 457,3.12966 457,6.99029126 L457,62.0097087 C457,65.87034 453.87034,69 450.009709,69 L348,69 L348,69 L348,0 Z" id="Rectangle" fill="#4C4C4E"></path>
                <path d="M6.99029126,0 L112,0 L112,0 L112,69 L6.99029126,69 C3.12966,69 -1.01853501e-14,65.87034 0,62.0097087 L0,6.99029126 C-1.36096939e-15,3.12966 3.12966,4.26190014e-15 6.99029126,0 Z" id="Rectangle-Copy-8" fill-opacity="0.9" fill="#ffff01"></path>
                <text id="{{T1}}" font-family="Rubik-Medium, Rubik" font-size="24" font-weight="400" fill="#FFFFFF">
                    <tspan x="24.056" y="43">Brusque</tspan>
                </text>
                <rect id="Rectangle-Copy-10" fill-opacity="0.9" fill="#000000" x="236" y="0" width="112" height="69"></rect>
                <rect id="Rectangle-Copy-13" fill-opacity="0.9" fill="#FFFFFF" x="112" y="0" width="124" height="69"></rect>
                <text id="{{T2}}" font-family="Rubik-Medium, Rubik" font-size="24" font-weight="400" fill="#FFFFFF">
                    <tspan x="258.184" y="43">Manaus</tspan>
                </text>
                <text id="0" font-family="Rubik-Medium, Rubik" font-size="24" font-weight="400" fill="#3A3A3A">
                    <tspan x="196.184" y="42">${"$"}homeScore</tspan>
                </text>
                <text id="0" font-family="Rubik-Medium, Rubik" font-size="24" font-weight="400" fill="#3A3A3A">
                    <tspan x="136.184" y="42">${"$"}awayScore</tspan>
                </text>
                <text id="-" font-family="Rubik-Medium, Rubik" font-size="24" font-weight="400" fill="#3A3A3A">
                    <tspan x="168.48" y="42">-</tspan>
                </text>
                <text id="10:10" font-family="Rubik-Medium, Rubik" font-size="24" font-weight="400" fill="#FFFFFF">
                    <tspan x="372.248" y="43">${"$"}scoreboardTimer</tspan>
                </text>
            </g>
        </g>
    </g>
</svg>
    """.trimIndent()

    fun getSampleShowOverlayAction(
    ): Action.ShowOverlayAction {
        val viewSpec = ViewSpec(PositionGuide(left = 10F, top = 10F), Pair(30F, 0F))
        val introTransitionSpec = TransitionSpec(C.ONE_SECOND_IN_MS, AnimationType.NONE, 0L)
        val outroTransitionSpec = TransitionSpec(2000L, AnimationType.NONE, 0L)
        val svgData = SvgData(null, sampleSvgString)

        return Action.ShowOverlayAction(
            id = "id_1001",
            offset = introTransitionSpec.offset,
            absoluteTime = -1L,
            svgData = svgData,
            duration = 0L,
            viewSpec = viewSpec,
            introTransitionSpec = introTransitionSpec,
            outroTransitionSpec = outroTransitionSpec,
            placeHolders = emptyList()
        )
    }

    fun getSampleShowOverlayAction(
        introTransitionSpec: TransitionSpec,
        outroOffset: Long
    ): Action.ShowOverlayAction {
        val viewSpec = ViewSpec(null, null)
        val outroTransitionSpec = TransitionSpec(outroOffset, AnimationType.NONE, 0L)
        return Action.ShowOverlayAction(
            id = "id_1001",
            offset = introTransitionSpec.offset,
            absoluteTime = -1L,
            svgData = null,
            duration = 0L,
            viewSpec = viewSpec,
            introTransitionSpec = introTransitionSpec,
            outroTransitionSpec = outroTransitionSpec,
            placeHolders = emptyList()
        )
    }

    fun getSampleShowOverlayAction(
        introTransitionSpec: TransitionSpec,
        outroTransitionSpec: TransitionSpec
    ): Action.ShowOverlayAction {
        val viewSpec = ViewSpec(null, null)
        return Action.ShowOverlayAction(
            id = "id_1001",
            offset = introTransitionSpec.offset,
            absoluteTime = -1L,
            svgData = null,
            duration = 0L,
            viewSpec = viewSpec,
            introTransitionSpec = introTransitionSpec,
            outroTransitionSpec = outroTransitionSpec,
            placeHolders = emptyList()
        )
    }

    fun getSampleScoreboardActionsList(): MutableList<Action> {
        val actionsList = mutableListOf<Action>()

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