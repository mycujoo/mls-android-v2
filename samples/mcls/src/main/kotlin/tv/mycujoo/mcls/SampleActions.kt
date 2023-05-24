package tv.mycujoo.mcls

import android.content.UriPermission
import tv.mycujoo.mclscore.model.*

object SampleActions {
    fun getActions(): List<AnnotationAction> {
        val actionsList = getSampleScoreboardActionsList()

        // region Top Left Action
        actionsList.add(
            AnnotationAction.ShowOverlayAction(
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
            AnnotationAction.ShowOverlayAction(
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
            AnnotationAction.HideOverlayAction(
                id = "overlay_topLeft",
                absoluteTime = 3000,
                offset = 5000,
                customId = "topLeft",
            )
        )
        // endregion

        // region Top Right Actions
        actionsList.add(
            AnnotationAction.ShowOverlayAction(
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
            AnnotationAction.ShowOverlayAction(
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
            AnnotationAction.HideOverlayAction(
                id = "overlay_topRight",
                absoluteTime = 3000,
                offset = 5000,
                customId = "topRight",
            )
        )
        // endregion

        // region Bottom Left Action
        actionsList.add(
            AnnotationAction.ShowOverlayAction(
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
            AnnotationAction.ShowOverlayAction(
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
            AnnotationAction.HideOverlayAction(
                id = "overlay_bottomLeft",
                absoluteTime = 3000,
                offset = 5000,
                customId = "bottomLeft",
            )
        )
        // endregion

        // region Bottom Right Action
        actionsList.add(
            AnnotationAction.ShowOverlayAction(
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
            AnnotationAction.ShowOverlayAction(
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
            AnnotationAction.HideOverlayAction(
                id = "overlay_bottomRight",
                absoluteTime = 3000,
                offset = 5000,
                customId = "bottomRight",
            )
        )
        // endregion


        for (i in 0..10) {
            actionsList.add(
                AnnotationAction.ShowOverlayAction(
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
                AnnotationAction.HideOverlayAction(
                    id = "overlay_$i",
                    absoluteTime = 3000,
                    offset = 50000,
                    customId = "$i",
                )
            )
        }

        return actionsList
    }

    fun getEasyActions(): List<AnnotationAction> {
        val actions = getSampleScoreboardActionsList()

        actions.add(
            AnnotationAction.ShowOverlayAction(
                id = "overlay_topLeft",
                absoluteTime = 0,
                offset = 0,
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
                customId = "1",
            )
        )

        actions.add(
            AnnotationAction.ShowOverlayAction(
                id = "overlay_topLeft",
                absoluteTime = 0,
                offset = 0,
                svgData = SvgData(
                    svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                ),
                viewSpec = ViewSpec(
                    PositionGuide(left = 0f, bottom = 0f),
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
                customId = "2",
            )
        )

        actions.add(
            AnnotationAction.ShowOverlayAction(
                id = "overlay_topLeft",
                absoluteTime = 0,
                offset = 0,
                svgData = SvgData(
                    svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                ),
                viewSpec = ViewSpec(
                    PositionGuide(right = 0f, top = 0f),
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
                customId = "3",
            )
        )

        actions.add(
            AnnotationAction.ShowOverlayAction(
                id = "overlay_topLeft",
                absoluteTime = 0,
                offset = 0,
                svgData = SvgData(
                    svgUrl = "https://mycujoo-static.imgix.net/eleven_svg_scoreboard.svg"
                ),
                viewSpec = ViewSpec(
                    PositionGuide(right = 0f, bottom = 0f),
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
                customId = "4",
            )
        )

        return actions
    }

    private fun getSampleScoreboardActionsList(): MutableList<AnnotationAction> {
        val actionsList = mutableListOf<AnnotationAction>()

        actionsList.add(
            AnnotationAction.CreateTimerAction(
                id = "timer",
                absoluteTime = 0,
                offset = 0,
                name = "\$main_timer",
                capValue = Long.MAX_VALUE,
            )
        )

        actionsList.add(
            AnnotationAction.StartTimerAction(
                id = "timer",
                absoluteTime = 0,
                offset = 0,
                name = "\$main_timer"
            )
        )

        // home team score
        actionsList.add(
            AnnotationAction.CreateVariableAction(
                id = "2",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.LongVariable("\$home_score", 0L)
            )
        )

        // away team score
        actionsList.add(
            AnnotationAction.CreateVariableAction(
                id = "3",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.LongVariable("\$away_score", 0L)
            )
        )

        // home team abbreviation
        actionsList.add(
            AnnotationAction.CreateVariableAction(
                id = "4",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.StringVariable("\$home_abbr", "HOME")
            )
        )

        // away team abbreviation
        actionsList.add(
            AnnotationAction.CreateVariableAction(
                id = "5",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.StringVariable("\$away_abbr", "AWAY")
            )
        )

        // home team color
        actionsList.add(
            AnnotationAction.CreateVariableAction(
                id = "6",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.StringVariable("\$home_color", "#FFFFFF")
            )
        )

        // away team color
        actionsList.add(
            AnnotationAction.CreateVariableAction(
                id = "7",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.StringVariable("\$away_color", "#FFFFFF")
            )
        )

        // announcement_line1, used for Goal overlay
        actionsList.add(
            AnnotationAction.CreateVariableAction(
                id = "8",
                offset = 0L,
                absoluteTime = UriPermission.INVALID_TIME,
                variable = Variable.StringVariable("\$announcement_line1", "Goal")
            )
        )

        return actionsList
    }
}