package tv.mycujoo.annotation

import tv.mycujoo.mclscore.Consts.ONE_SECOND_IN_MS
import tv.mycujoo.mclscore.entity.AnimationType
import tv.mycujoo.mclscore.model.Action
import tv.mycujoo.mclscore.model.TransitionSpec
import tv.mycujoo.mclscore.model.ViewSpec

class TestData {

    companion object {
        fun getSampleShowOverlayActionN(
            offset: Long,
            customId : String = "cid_1001"
        ): Action.ShowOverlayAction {
            val viewSpec = ViewSpec(null, null)
            val introTransitionSpec =
                TransitionSpec(offset, AnimationType.NONE, 0L)

            return Action.ShowOverlayAction(
                id = "id_1001",
                offset = offset,
                absoluteTime = -1L,
                svgData = null,
                duration = 0L,
                viewSpec = viewSpec,
                introTransitionSpec = introTransitionSpec,
                outroTransitionSpec = null,
                placeHolders = emptyList(),
                customId = customId
            )
        }

        fun getSampleShowOverlayAction(): Action.ShowOverlayAction {
            val viewSpec = ViewSpec(null, null)
            val introTransitionSpec =
                TransitionSpec(0L, AnimationType.NONE, 0L)

            return Action.ShowOverlayAction(
                id = "id_1001",
                offset = 0L,
                absoluteTime = -1L,
                svgData = null,
                duration = 0L,
                viewSpec = viewSpec,
                introTransitionSpec = introTransitionSpec,
                outroTransitionSpec = null,
                placeHolders = emptyList(),
                customId = "cid_1001"
            )
        }

        fun getSampleShowOverlayAction(
            introAnimationType: AnimationType
        ): Action.ShowOverlayAction {
            val viewSpec = ViewSpec(null, null)
            val introTransitionSpec =
                TransitionSpec(0L, introAnimationType, ONE_SECOND_IN_MS)

            return Action.ShowOverlayAction(
                id = "id_1001",
                offset = 0L,
                absoluteTime = -1L,
                svgData = null,
                duration = 0L,
                viewSpec = viewSpec,
                introTransitionSpec = introTransitionSpec,
                outroTransitionSpec = null,
                placeHolders = emptyList()
            )
        }

        fun getSampleShowOverlayActionOutro(
            outroAnimationType: AnimationType
        ): Action.ShowOverlayAction {
            val viewSpec = ViewSpec(null, null)
            val introTransitionSpec =
                TransitionSpec(0L, AnimationType.NONE, 0L)
            val outroTransitionSpec =
                TransitionSpec(0L, outroAnimationType, ONE_SECOND_IN_MS)

            return Action.ShowOverlayAction(
                id = "id_1001",
                offset = 0L,
                absoluteTime = -1L,
                svgData = null,
                duration = 0L,
                viewSpec = viewSpec,
                introTransitionSpec = introTransitionSpec,
                outroTransitionSpec = outroTransitionSpec,
                placeHolders = emptyList()
            )
        }

        fun getSampleHideOverlayAction(
            animationType: AnimationType
        ): Action.HideOverlayAction {

            val outroTransitionSpec =
                TransitionSpec(0L, animationType, ONE_SECOND_IN_MS)

            return Action.HideOverlayAction(
                id = "id_1001",
                offset = 0L,
                absoluteTime = -1L,
                outroTransitionSpec = outroTransitionSpec,
                customId = "id_1001"
            )
        }

        fun getSampleHideOverlayAction(
            offset: Long,
            customId : String = "cid_1001"
        ): Action.HideOverlayAction {

            val outroTransitionSpec =
                TransitionSpec(offset, AnimationType.NONE, 0L)

            return Action.HideOverlayAction(
                id = "id_1001",
                offset = offset,
                absoluteTime = -1L,
                outroTransitionSpec = outroTransitionSpec,
                customId = customId
            )
        }

        @ExperimentalStdlibApi
        fun samplePosition(): Map<String, Double> {
            return buildMap {
                put("top", 5.toDouble())
                put("leading", 5.toDouble())
            }
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
    }

}