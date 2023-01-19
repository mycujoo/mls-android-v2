package tv.mycujoo.mclsnetwork

import tv.mycujoo.mclscore.Consts.ONE_SECOND_IN_MS
import tv.mycujoo.mclscore.entity.AnimationType
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.TransitionSpec
import tv.mycujoo.mclscore.model.ViewSpec

class TestData {

    companion object {
        fun getSampleShowOverlayActionN(
            offset: Long,
            customId : String = "cid_1001"
        ): AnnotationAction.ShowOverlayAction {
            val viewSpec = ViewSpec(null, null)
            val introTransitionSpec =
                TransitionSpec(offset, AnimationType.NONE, 0L)

            return AnnotationAction.ShowOverlayAction(
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

        fun getSampleShowOverlayAction(): AnnotationAction.ShowOverlayAction {
            val viewSpec = ViewSpec(null, null)
            val introTransitionSpec =
                TransitionSpec(0L, AnimationType.NONE, 0L)

            return AnnotationAction.ShowOverlayAction(
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
        ): AnnotationAction.ShowOverlayAction {
            val viewSpec = ViewSpec(null, null)
            val introTransitionSpec =
                TransitionSpec(0L, introAnimationType, ONE_SECOND_IN_MS)

            return AnnotationAction.ShowOverlayAction(
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
        ): AnnotationAction.ShowOverlayAction {
            val viewSpec = ViewSpec(null, null)
            val introTransitionSpec =
                TransitionSpec(0L, AnimationType.NONE, 0L)
            val outroTransitionSpec =
                TransitionSpec(0L, outroAnimationType, ONE_SECOND_IN_MS)

            return AnnotationAction.ShowOverlayAction(
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
        ): AnnotationAction.HideOverlayAction {

            val outroTransitionSpec =
                TransitionSpec(0L, animationType, ONE_SECOND_IN_MS)

            return AnnotationAction.HideOverlayAction(
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
        ): AnnotationAction.HideOverlayAction {

            val outroTransitionSpec =
                TransitionSpec(offset, AnimationType.NONE, 0L)

            return AnnotationAction.HideOverlayAction(
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
        ): AnnotationAction.ShowOverlayAction {
            val viewSpec = ViewSpec(null, null)
            val outroTransitionSpec = TransitionSpec(outroOffset, AnimationType.NONE, 0L)
            return AnnotationAction.ShowOverlayAction(
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
        ): AnnotationAction.ShowOverlayAction {
            val viewSpec = ViewSpec(null, null)
            return AnnotationAction.ShowOverlayAction(
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