package tv.mycujoo.samplemcls.app

import android.content.UriPermission
import tv.mycujoo.mclscore.model.*

object SampleActions {
    fun getActions(): List<Action> {
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