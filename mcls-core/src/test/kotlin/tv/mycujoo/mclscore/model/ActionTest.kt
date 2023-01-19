package tv.mycujoo.mclscore.model

import org.amshove.kluent.`should be equal to`
import org.junit.Assert.assertEquals
import org.junit.Test
import tv.mycujoo.mclscore.entity.AnimationType

class ActionTest {

    @Test
    fun `ShowOverlayAction updateOffset test`() {
        val introTransitionSpec = TransitionSpec(0L, AnimationType.FADE_IN, 1000L)
        val outroTransitionSpec = TransitionSpec(0L, AnimationType.FADE_OUT, 1000L)
        val showOverlayAction =
            AnnotationAction.ShowOverlayAction(
                "id_00",
                0L,
                55550000L,
                outroTransitionSpec = outroTransitionSpec,
                introTransitionSpec = introTransitionSpec
            )

        val newOffset = 2000L
        val showOverlayActionWithUpdatedOffset =
            showOverlayAction.updateOffset(newOffset)

        assertEquals(newOffset, showOverlayActionWithUpdatedOffset.offset)
        assertEquals(newOffset, showOverlayActionWithUpdatedOffset.introTransitionSpec!!.offset)
        assertEquals(newOffset, showOverlayActionWithUpdatedOffset.outroTransitionSpec!!.offset)
    }

    @Test
    fun `HideOverlayAction updateOffset test`() {
        val outroTransitionSpec = TransitionSpec(0L, AnimationType.FADE_OUT, 1000L)
        val hideOverlayAction =
            AnnotationAction.HideOverlayAction("id_00", 0L, 55550000L, outroTransitionSpec, "cid_00")

        val newOffset = 2000L
        val hideOverlayActionWithUpdatedOffset =
            hideOverlayAction.updateOffset(newOffset)

        assertEquals(newOffset, hideOverlayActionWithUpdatedOffset.offset)
        assertEquals(newOffset, hideOverlayActionWithUpdatedOffset.outroTransitionSpec!!.offset)
    }

    @Test
    fun `ReshowOverlayAction updateOffset test`() {
        val reshowOverlayAction =
            AnnotationAction.ReshowOverlayAction("id_00", 0L, 55550000L, "cid_00")

        val newOffset = 2000L
        val reshowOverlayActionWithUpdatedOffset =
            reshowOverlayAction.updateOffset(newOffset)

        assertEquals(newOffset, reshowOverlayActionWithUpdatedOffset.offset)
    }

    @Test
    fun `CreateTimerAction updateOffset test`() {
        val createTimerAction =
            AnnotationAction.CreateTimerAction("id_00", 0L, 55550000L, "name", capValue = -1L)

        val newOffset = 2000L
        val createTimerActionWithUpdatedOffset =
            createTimerAction.updateOffset(newOffset)

        assertEquals(newOffset, createTimerActionWithUpdatedOffset.offset)
    }

    @Test
    fun `StartTimerAction updateOffset test`() {
        val startTimerAction =
            AnnotationAction.StartTimerAction("id_00", 0L, 55550000L, "name")

        val newOffset = 2000L
        val startTimerActionWithUpdatedOffset =
            startTimerAction.updateOffset(newOffset)

        assertEquals(newOffset, startTimerActionWithUpdatedOffset.offset)
    }


    @Test
    fun `PauseTimerAction updateOffset test`() {
        val pauseTimerAction =
            AnnotationAction.PauseTimerAction("id_00", 0L, 55550000L, "name")

        val newOffset = 2000L
        val pauseTimerActionWithUpdatedOffset =
            pauseTimerAction.updateOffset(newOffset)

        assertEquals(newOffset, pauseTimerActionWithUpdatedOffset.offset)
    }

    @Test
    fun `AdjustTimerAction updateOffset test`() {
        val adjustTimerAction =
            AnnotationAction.AdjustTimerAction("id_00", 0L, 55550000L, "name", 0L)

        val newOffset = 2000L
        val adjustTimerActionWithUpdatedOffset =
            adjustTimerAction.updateOffset(newOffset)

        assertEquals(newOffset, adjustTimerActionWithUpdatedOffset.offset)
    }

    @Test
    fun `SkipTimerAction updateOffset test`() {
        val skipTimerAction =
            AnnotationAction.SkipTimerAction("id_00", 0L, 55550000L, "name", 0L)

        val newOffset = 2000L
        val skipTimerActionWithUpdatedOffset =
            skipTimerAction.updateOffset(newOffset)

        assertEquals(newOffset, skipTimerActionWithUpdatedOffset.offset)
    }

    @Test
    fun `CreateVariableAction updateOffset test`() {
        val createVariableAction =
            AnnotationAction.CreateVariableAction("id_00", 0L, 55550000L, Variable.LongVariable("name", 0L))

        val newOffset = 2000L
        val createVariableActionWithUpdatedOffset =
            createVariableAction.updateOffset(newOffset)

        assertEquals(newOffset, createVariableActionWithUpdatedOffset.offset)
    }

    @Test
    fun `IncrementVariableAction updateOffset test`() {
        val incrementVariableAction =
            AnnotationAction.IncrementVariableAction("id_00", 0L, 55550000L, "name", 1.toDouble())

        val newOffset = 2000L
        val incrementVariableActionWithUpdatedOffset =
            incrementVariableAction.updateOffset(newOffset)

        assertEquals(newOffset, incrementVariableActionWithUpdatedOffset.offset)
    }

    @Test
    fun `MarkTimelineAction updateOffset test`() {
        val markTimelineAction =
            AnnotationAction.MarkTimelineAction("id_00", 0L, 55550000L, 1000L, "Goal!", "#ffffff")

        val newOffset = 2000L
        val markTimelineActionWithUpdatedOffset = markTimelineAction.updateOffset(newOffset)

        assertEquals(newOffset, markTimelineActionWithUpdatedOffset.offset)
    }

    @Test
    fun `DeleteAction updateOffset test`() {
        val deleteAction = AnnotationAction.DeleteAction("id_00", 0L, 55550000L, "targetId_00")

        val newOffset = 2000L
        val deleteActionWithUpdatedOffset = deleteAction.updateOffset(newOffset)

        assertEquals(newOffset, deleteActionWithUpdatedOffset.offset)
    }

    @Test
    fun `InvalidAction updateOffset test`() {
        val invalidAction = AnnotationAction.InvalidAction("id_00", 0L, 55550000L)

        val newOffset = 2000L
        val invalidActionWithUpdatedTime = invalidAction.updateOffset(newOffset)

        assertEquals(newOffset, invalidActionWithUpdatedTime.offset)
    }

    /**region isEligible test*/
    @Test
    fun `ShowOverlayAction eligible test`() {
        val showOverlayActionWithPositiveOffset =
            AnnotationAction.ShowOverlayAction(
                "id_00",
                0L,
                0L,
                duration = 5000L
            )
        val showOverlayActionWithNegativeOffsetWithDuration =
            AnnotationAction.ShowOverlayAction(
                "id_00",
                -1000L,
                -1L,
                duration = 5000L
            )
        val showOverlayActionWithNegativeOffsetWithoutDuration =
            AnnotationAction.ShowOverlayAction(
                "id_00",
                -1000L,
                -1L
            )

        val outroTransitionSpec = TransitionSpec(0L, AnimationType.FADE_OUT, 1000L)
        val showOverlayActionWithNegativeOffsetWithOutroSpec =
            AnnotationAction.ShowOverlayAction(
                "id_00",
                -1000L,
                -1L,
                outroTransitionSpec = outroTransitionSpec
            )
        val showOverlayActionWithNegativeOffsetWithoutOutroSpec =
            AnnotationAction.ShowOverlayAction(
                "id_00",
                -1000L,
                -1L
            )

        showOverlayActionWithPositiveOffset.isEligible() `should be equal to` true
        showOverlayActionWithNegativeOffsetWithDuration.isEligible() `should be equal to` false
        showOverlayActionWithNegativeOffsetWithoutDuration.isEligible() `should be equal to` true
        showOverlayActionWithNegativeOffsetWithOutroSpec.isEligible() `should be equal to` false
        showOverlayActionWithNegativeOffsetWithoutOutroSpec.isEligible() `should be equal to` true
    }

    @Test
    fun `all actions except ShowOverlayAction eligible test`() {
        val hideOverlayAction =
            AnnotationAction.HideOverlayAction("id_00", 0L, 55550000L, customId = "cid_00")

        assert(hideOverlayAction.isEligible())

    }
}