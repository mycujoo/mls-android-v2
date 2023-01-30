package tv.mycujoo.annotation.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.*
import tv.mycujoo.annotation.TestData.Companion.getSampleHideOverlayAction
import tv.mycujoo.annotation.TestData.Companion.getSampleShowOverlayAction
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.manager.IVariableKeeper
import tv.mycujoo.annotation.matcher.ShowOverlayActionArgumentMatcher
import tv.mycujoo.annotation.matcher.TimerVariablesMapArgumentMatcher
import tv.mycujoo.annotation.matcher.TransitionSpecArgumentMatcher
import tv.mycujoo.annotation.matcher.VariablesMapArgumentMatcher
import tv.mycujoo.mclscore.entity.AnimationType
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.TransitionSpec
import tv.mycujoo.mclscore.model.Variable
import kotlin.test.assertTrue

@RunWith(MockitoJUnitRunner::class)
class AnnotationFactoryTest {

    /**region subject under test*/
    private lateinit var annotationFactory: AnnotationFactory

    /**endregion */

    /**region fields*/
    @Mock
    lateinit var annotationListener: IAnnotationListener

    @Mock
    lateinit var player: VideoPlayer

    @Mock
    lateinit var variableKeeper: IVariableKeeper

    /**endregion */

    /**region Setup*/
    @Before
    fun setUp() {
        annotationFactory = AnnotationFactory(
            annotationListener,
            variableKeeper,
        )
    }

    /**endregion */

    /**region Sorting*/
    @Test
    fun `sort timer related actions based on priority`() {
        val adjustTimerAction = AnnotationAction.AdjustTimerAction("id_01", 5000L, -1L, "name", 0L)
        val pauseTimerAction = AnnotationAction.PauseTimerAction("id_02", 5000L, -1L, "name")
        val startTimerAction = AnnotationAction.StartTimerAction("id_03", 5000L, -1L, "name")
        val createTimerAction =
            AnnotationAction.CreateTimerAction("id_04", 5000L, -1L, "name", capValue = -1L)
        annotationFactory.setActions(
            listOf(
                adjustTimerAction,
                pauseTimerAction,
                startTimerAction,
                createTimerAction
            )
        )


        assertTrue { annotationFactory.getCurrentActions()[0] is AnnotationAction.CreateTimerAction }
        assertTrue { annotationFactory.getCurrentActions()[1] is AnnotationAction.StartTimerAction }
        assertTrue { annotationFactory.getCurrentActions()[2] is AnnotationAction.PauseTimerAction }
        assertTrue { annotationFactory.getCurrentActions()[3] is AnnotationAction.AdjustTimerAction }
    }
    /**endregion */

    /**region Handling Negative/-1L offset*/
    @Test
    fun `given ShowOverlayAction {eligible} with Negative offset, should act on it`() {
        val action = AnnotationAction.ShowOverlayAction("id_01", -1000L, 1605609881000L, null)
        annotationFactory.setActions(listOf(action))
        annotationFactory.build(2001L)


        verify(annotationListener).addOrUpdateLingeringMidwayOverlay(
            argThat(
                ShowOverlayActionArgumentMatcher("id_01")
            )
        )
    }

    @Test
    fun `given ShowOverlayAction {not eligible} with Negative offset, should not act on it`() {
        val action =
            AnnotationAction.ShowOverlayAction("id_01", -1000L, 1605609881000L, null, duration = 5000L)
        annotationFactory.setActions(listOf(action))
        annotationFactory.build(2001L)


        verify(annotationListener, never()).addOrUpdateLingeringMidwayOverlay(any())
    }

    @Test
    fun `given ShowOverlayAction {eligible} with Negative offset, then HideOverlayAction, should not act on it`() {
//        whenever(player.duration()).thenReturn(120000L)

//        whenever(player.isWithinValidSegment(any())).thenReturn(true)
        val action =
            AnnotationAction.ShowOverlayAction("id_01", -1000L, 1605609881000L, null, customId = "cid_00")
        val transitionSpec = TransitionSpec(-1000L, AnimationType.NONE, 0L)
        val hideOverlayAction =
            AnnotationAction.HideOverlayAction(
                "id_01",
                -1000L,
                1605609881000L,
                transitionSpec,
                customId = "cid_00"
            )
        annotationFactory.setActions(listOf(action, hideOverlayAction))

        annotationFactory.build(2001L)


        verify(annotationListener, never()).addOrUpdateLingeringMidwayOverlay(
            argThat(
                ShowOverlayActionArgumentMatcher("id_01")
            )
        )
    }

    @Test
    fun `given ShowOverlayAction {eligible} with Negative offset from ReshowOverlayAction, should act on it`() {
        val action = AnnotationAction.ShowOverlayAction(
            "id_01",
            -5000L,
            1605609881000L,
            null,
            customId = "cid_00"
        )
        val reshowOverlayAction =
            AnnotationAction.ReshowOverlayAction("id_01", -1000L, 1605609881000L, "cid_00")
        annotationFactory.setActions(listOf(action, reshowOverlayAction))
        annotationFactory.build(2001L)


        verify(annotationListener, times(1)).addOrUpdateLingeringMidwayOverlay(
            argThat(
                ShowOverlayActionArgumentMatcher("id_01")
            )
        )
    }

    @Test
    fun `given ShowOverlayAction {not eligible} with Negative offset from ReshowOverlayAction, should not act on it`() {
        val action = AnnotationAction.ShowOverlayAction(
            "id_01",
            -1000L,
            1605609881000L,
            null,
            duration = 5000L,
            customId = "cid_00"
        )
        val reshowOverlayAction =
            AnnotationAction.ReshowOverlayAction("id_01", -1000L, 1605609881000L, "cid_00")
        annotationFactory.setActions(listOf(action, reshowOverlayAction))
        annotationFactory.build(2001L)


        verify(annotationListener, never()).addOrUpdateLingeringMidwayOverlay(any())
    }
    /**region Overlay related actions*/

    /**endregion */

    /**region Timer related actions*/
    @Test
    fun `given CreateTimerAction with Negative offset, should act on it`() {
        val action =
            AnnotationAction.CreateTimerAction("id_00", -2000L, 1605609880000L, "name", capValue = -1L)
        annotationFactory.setActions(listOf(action))
        annotationFactory.build(0L)

        verify(variableKeeper).notifyTimers(
            argThat(
                TimerVariablesMapArgumentMatcher(
                    "name",
                    "0:00"
                )
            )
        )
    }

    @Test
    fun `given CreateTimerAction with -1L offset, should act on it`() {
        val action =
            AnnotationAction.CreateTimerAction("id_00", -1L, 1605609881999L, "name", capValue = -1L)
        annotationFactory.setActions(listOf(action))
        annotationFactory.build(0L)

        verify(variableKeeper).notifyTimers(
            argThat(
                TimerVariablesMapArgumentMatcher(
                    "name",
                    "0:00"
                )
            )
        )
    }

    @Test
    fun `given StartTimerAction with Negative offset, should act on it`() {
        val createTimerAction =
            AnnotationAction.CreateTimerAction("id_00", -2000L, 1605609880000L, "name", capValue = -1L)
        val startTimerAction =
            AnnotationAction.StartTimerAction("id_01", -2000L, 1605609880000L, "name")
        annotationFactory.setActions(listOf(createTimerAction, startTimerAction))

        annotationFactory.build(1000L)

        verify(variableKeeper).notifyTimers(
            argThat(
                TimerVariablesMapArgumentMatcher(
                    "name",
                    "0:03"
                )
            )
        )
    }

    @Test
    fun `given StartTimerAction with -1L offset, should act on it`() {
        val createTimerAction =
            AnnotationAction.CreateTimerAction("id_00", -1L, 1605609881999L, "name", capValue = -1L)
        val startTimerAction =
            AnnotationAction.StartTimerAction("id_01", -1L, 1605609881999L, "name")
        annotationFactory.setActions(listOf(createTimerAction, startTimerAction))


        annotationFactory.build(1000L)

        verify(variableKeeper).notifyTimers(
            argThat(
                TimerVariablesMapArgumentMatcher(
                    "name",
                    "0:01"
                )
            )
        )
    }

    @Test
    fun `given PauseTimerAction with Negative offset, should act on it`() {
        val createTimerAction =
            AnnotationAction.CreateTimerAction("id_00", -2000L, 1605609880000L, "name", capValue = -1L)
        val startTimerAction =
            AnnotationAction.StartTimerAction("id_01", -2000L, 1605609880000L, "name")
        val pauseTimerAction =
            AnnotationAction.PauseTimerAction("id_01", -1000L, 1605609881000L, "name")
        annotationFactory.setActions(listOf(createTimerAction, startTimerAction, pauseTimerAction))
        annotationFactory.build(2000L)

        verify(variableKeeper).notifyTimers(
            argThat(
                TimerVariablesMapArgumentMatcher(
                    "name",
                    "0:01"
                )
            )
        )
    }

    @Test
    fun `given PauseTimerAction with -1L offset, should act on it`() {
        val createTimerAction =
            AnnotationAction.CreateTimerAction("id_00", -1L, 1605609881999L, "name", capValue = -1L)
        val startTimerAction =
            AnnotationAction.StartTimerAction("id_01", -1L, 1605609881999L, "name")
        val pauseTimerAction =
            AnnotationAction.PauseTimerAction("id_01", 1000L, 1605609883000L, "name")
        annotationFactory.setActions(listOf(createTimerAction, startTimerAction, pauseTimerAction))
        annotationFactory.build(2000L)

        verify(variableKeeper).notifyTimers(
            argThat(
                TimerVariablesMapArgumentMatcher(
                    "name",
                    "0:01"
                )
            )
        )
    }

    @Test
    fun `given AdjustTimerAction with Negative offset, should act on it`() {
        val createTimerAction =
            AnnotationAction.CreateTimerAction("id_00", -2000L, 1605609880000L, "name", capValue = -1L)
        val startTimerAction =
            AnnotationAction.StartTimerAction("id_01", -2000L, 1605609880000L, "name")
        val adjustTimerAction =
            AnnotationAction.AdjustTimerAction("id_01", -1000L, 1605609881000L, "name", value = 2000L)
        annotationFactory.setActions(listOf(createTimerAction, startTimerAction, adjustTimerAction))


        annotationFactory.build(2000L)

        verify(variableKeeper).notifyTimers(
            argThat(
                TimerVariablesMapArgumentMatcher(
                    "name",
                    "0:02"
                )
            )
        )
    }

    @Test
    fun `given AdjustTimerAction with -1L offset, should act on it`() {
        val createTimerAction =
            AnnotationAction.CreateTimerAction("id_00", -1L, 1605609881999L, "name", capValue = -1L)
        val startTimerAction =
            AnnotationAction.StartTimerAction("id_01", -1L, 1605609881999L, "name")
        val adjustTimerAction =
            AnnotationAction.AdjustTimerAction("id_01", -1L, 1605609881999L, "name", value = 2000L)
        annotationFactory.setActions(listOf(createTimerAction, startTimerAction, adjustTimerAction))

        annotationFactory.build(2000L)

        verify(variableKeeper).notifyTimers(
            argThat(
                TimerVariablesMapArgumentMatcher(
                    "name",
                    "0:02"
                )
            )
        )
    }

    @Test
    fun `given SkipTimerAction with Negative offset, should act on it`() {
        val createTimerAction =
            AnnotationAction.CreateTimerAction("id_00", -2000L, 1605609880000L, "name", capValue = -1L)
        val startTimerAction =
            AnnotationAction.StartTimerAction("id_01", -2000L, 1605609880000L, "name")
        val skipTimerAction =
            AnnotationAction.SkipTimerAction("id_01", -1000L, 1605609881000L, "name", value = 2000L)
        annotationFactory.setActions(listOf(createTimerAction, startTimerAction, skipTimerAction))
        annotationFactory.build(2000L)

        verify(variableKeeper).notifyTimers(
            argThat(
                TimerVariablesMapArgumentMatcher(
                    "name",
                    "0:06"
                )
            )
        )
    }

    @Test
    fun `given SkipTimerAction with -1L offset, should act on it`() {

        val createTimerAction =
            AnnotationAction.CreateTimerAction("id_00", -1L, 1605609881999L, "name", capValue = -1L)
        val startTimerAction =
            AnnotationAction.StartTimerAction("id_01", -1L, 1605609881999L, "name")
        val skipTimerAction =
            AnnotationAction.SkipTimerAction("id_01", -1L, 1605609881999L, "name", value = 2000L)
        annotationFactory.setActions(listOf(createTimerAction, startTimerAction, skipTimerAction))

        annotationFactory.build(2000L)

        verify(variableKeeper).notifyTimers(
            argThat(
                TimerVariablesMapArgumentMatcher(
                    "name",
                    "0:04"
                )
            )
        )
    }
    /**endregion */

    /**region Variable related actions*/
    @Test
    fun `given CreateVariableAction with Negative offset, should act on it`() {
        val action =
            AnnotationAction.CreateVariableAction("id_00", -123L, 123456L, Variable.LongVariable("name", 1L))
        annotationFactory.setActions(listOf(action))


        annotationFactory.build(0L)

        verify(variableKeeper).notifyVariables(argThat(VariablesMapArgumentMatcher("name", "1")))
    }

    @Test
    fun `given CreateVariableAction with -1L offset, should act on it`() {
        val action = AnnotationAction.CreateVariableAction(
                "id_00",
                -1L,
                1605609881999L,
                Variable.LongVariable("name", 1L)
            )
        annotationFactory.setActions(listOf(action))


        annotationFactory.build(0L)

        verify(variableKeeper).notifyVariables(argThat(VariablesMapArgumentMatcher("name", "1")))
    }

    @Test
    fun `given IncrementVariableAction with Negative offset, should act on it`() {
        val createVariableAction =
            AnnotationAction.CreateVariableAction("id_00", -123L, 123456L, Variable.LongVariable("name", 0L))
        val incrementVariableAction =
            AnnotationAction.IncrementVariableAction("id_01", -123L, 123456L, "name", 2.toDouble())
        annotationFactory.setActions(listOf(createVariableAction, incrementVariableAction))

        annotationFactory.build(0L)

        verify(variableKeeper).notifyVariables(argThat(VariablesMapArgumentMatcher("name", "2")))
    }

//    @Test
//    fun `given IncrementVariableAction with -1L offset, should act on it`() {
//        whenever(player.duration()).thenReturn(120000L)

//        val createVariableAction =
//            Action.CreateVariableAction(
//                "id_00",
//                -1L,
//                1605609881999L,
//                Variable.LongVariable("name", 0L)
//            )
//        val incrementVariableAction =
//            Action.IncrementVariableAction("id_01", -1L, 1605609881999L, "name", 2.toDouble())
//        annotationFactory.setActions(listOf(createVariableAction, incrementVariableAction))
//
//        val buildPoint = BuildPoint(0L, -1L, player, isPlaying = true)
//        annotationFactory.build(buildPoint)
//
//        verify(variableKeeper).notifyVariables(argThat(VariablesMapArgumentMatcher("name", "2")))
//    }
    /**endregion */

    /**region MarkTimelineAction*/
    @Test
    fun `given MarkTimeLine with Negative offset, should not act on it`() {
        val action =
            AnnotationAction.MarkTimelineAction("id_00", -1000L, 1605609881000L, 1000L, "Goal", "#ffffff")
        annotationFactory.setActions(listOf(action))

        annotationFactory.build(0L)

        verify(annotationListener).setTimelineMarkers(eq(emptyList()))
    }

    @Test
    fun `given MarkTimeLine with -1L offset, should not act on it`() {
        val action =
            AnnotationAction.MarkTimelineAction("id_00", -1L, 1605609881999L, 1000L, "Goal", "#ffffff")
        annotationFactory.setActions(listOf(action))


        annotationFactory.build(0L)

        verify(annotationListener).setTimelineMarkers(eq(emptyList()))
    }
    /**endregion */

    /**endregion */

    /**region Relative time system*/
    /**
     * Overlay is either On-screen or Off-screen.
     * In either way, it might go through several phases:
     * 1, Afterward[current time has not reached the action]
     *          on-screen: remove     off-screen: do-nothing
     * 2, Intro In-range [action is from now until next second]
     *          on-screen: do nothing     off-screen: add
     * 3, Lingering-intro [current time is in intro animation time]
     *          on-screen: addOrUpdate      off-screen: addLingering?
     * 4, Lingerin-midway [current time is after intro or intro animation, but before outro]
     * 5, Lingering-outro [current time is in outro-animation time]
     * 6, Outro in-range [action's removal is from now until next second]
     * 7, Aforetime [show-overlay action duration has passed OR
     *              explicit or implicit related hide-action has passed]
     */
    @Test
    fun `given afterward off-screen ShowOverlayAction, should not add overlay`() {
        val action = AnnotationAction.ShowOverlayAction("id_01", 5000L, -1L, null)
        annotationFactory.setActions(listOf(action))
        annotationFactory.build(3001L)


        verify(
            annotationListener,
            never()
        ).addOverlay(argThat(ShowOverlayActionArgumentMatcher("id_01")))
        verify(annotationListener, never()).removeLingeringOverlay(any(), any())
    }

    @Test
    fun `given afterward on-screen ShowOverlayAction, should remove overlay`() {
        val action = AnnotationAction.ShowOverlayAction("id_01", 5000L, -1L, null)
        annotationFactory.setActions(listOf(action))
        annotationFactory.build(4001L)
        annotationFactory.build(3001L)


        verify(
            annotationListener,
            times(1)
        ).addOverlay(argThat(ShowOverlayActionArgumentMatcher("id_01")))
        verify(
            annotationListener,
            times(1)
        ).removeOverlay(action.customId, null)
        verify(annotationListener, never()).removeLingeringOverlay(any(), any())
    }

    @Test
    fun `given intro-in-range off-screen ShowOverlayAction, should add overlay`() {
        val action = AnnotationAction.ShowOverlayAction("id_01", 5000L, -1L, null)
        annotationFactory.setActions(listOf(action))
        annotationFactory.build(4001L)


        verify(annotationListener).addOverlay(argThat(ShowOverlayActionArgumentMatcher("id_01")))
        verify(annotationListener, never()).removeLingeringOverlay(any(), any())
    }

    @Test
    fun `given intro-in-range on-screen ShowOverlayAction, should not add nor remove overlay`() {
        val action = AnnotationAction.ShowOverlayAction("id_01", 5000L, -1L, null)
        annotationFactory.setActions(listOf(action))

        annotationFactory.build(4001L)
        annotationFactory.build(4501L)

        verify(
            annotationListener,
            times(1)
        ).addOverlay(argThat(ShowOverlayActionArgumentMatcher("id_01")))
        verify(annotationListener, never()).removeLingeringOverlay(any(), any())
    }

    @Test
    fun `given outro-in-range{from Outro-spec} off-screen ShowOverlayAction, should not add nor remove overlay`() {
        val action = AnnotationAction.ShowOverlayAction(
            "id_01",
            5000L,
            -1L,
            null,
            outroTransitionSpec = TransitionSpec(10000L, AnimationType.FADE_OUT, 1000L)
        )
        annotationFactory.setActions(listOf(action))
        annotationFactory.build(9001L)

        verify(
            annotationListener,
            never()
        ).addOverlay(argThat(ShowOverlayActionArgumentMatcher("id_01")))
        verify(annotationListener, never()).removeOverlay("id_01", action.outroTransitionSpec)
    }

    @Test
    fun `given outro-in-range{from Duration} off-screen ShowOverlayAction, should not add nor remove overlay`() {
        val action = AnnotationAction.ShowOverlayAction("id_01", 5000L, -1L, null, duration = 5000L)
        annotationFactory.setActions(listOf(action))
        annotationFactory.build(9001L)


        verify(
            annotationListener,
            never()
        ).addOverlay(argThat(ShowOverlayActionArgumentMatcher("id_01")))
        verify(annotationListener, never()).removeOverlay("id_01", action.outroTransitionSpec)
    }

    @Test
    fun `given outro-in-range{from Duration} on-screen ShowOverlayAction, should remove overlay`() {
        val action = AnnotationAction.ShowOverlayAction("id_01", 5000L, -1L, null, duration = 5000L)
        annotationFactory.setActions(listOf(action))

        annotationFactory.build(4001L)
        annotationFactory.build(9001L)


        verify(
            annotationListener,
            times(1)
        ).addOverlay(argThat(ShowOverlayActionArgumentMatcher("id_01")))
        verify(annotationListener, times(1)).removeOverlay(
            action.customId,
            action.outroTransitionSpec
        )
    }

    @Test
    fun `given outro-in-range{from Outro-spec} on-screen ShowOverlayAction, should remove overlay`() {
        val action = AnnotationAction.ShowOverlayAction(
            "id_01",
            5000L,
            -1L,
            null,
            outroTransitionSpec = TransitionSpec(10000L, AnimationType.FADE_OUT, 1000L)
        )
        annotationFactory.setActions(listOf(action))

        annotationFactory.build(4001L)
        annotationFactory.build(9001L)


        verify(
            annotationListener,
            times(1)
        ).addOverlay(argThat(ShowOverlayActionArgumentMatcher("id_01")))
        verify(annotationListener, times(1)).removeOverlay(
            action.customId,
            action.outroTransitionSpec
        )
    }


    @Test
    fun `given aforetime{From duration} off-screen ShowOverlayAction, should not add nor remove it`() {
        val action = AnnotationAction.ShowOverlayAction("id_01", 5000L, -1L, null, duration = 5000L)
        annotationFactory.setActions(listOf(action))
        annotationFactory.build(15001L)


        verify(
            annotationListener,
            never()
        ).addOverlay(argThat(ShowOverlayActionArgumentMatcher("id_01")))
        verify(
            annotationListener,
            never()
        ).removeOverlay("id_01", null)
    }

    @Test
    fun `given aforetime{From duration} on-screen ShowOverlayAction, should remove it`() {
        val action = AnnotationAction.ShowOverlayAction("id_01", 5000L, -1L, null, duration = 5000L)
        annotationFactory.setActions(listOf(action))
        annotationFactory.build(4001L)
        annotationFactory.build(15000L)


        verify(
            annotationListener,
            times(1)
        ).addOverlay(argThat(ShowOverlayActionArgumentMatcher("id_01")))
        verify(
            annotationListener,
            times(1)
        ).removeOverlay(action.customId, null)
    }

    @Test
    fun `given aforetime{From explicit hide} off-screen ShowOverlayAction, should not add nor remove it`() {
        val action = AnnotationAction.ShowOverlayAction(
            "id_01",
            5000L,
            -1L,
            null,
            outroTransitionSpec = TransitionSpec(10000L, AnimationType.FADE_OUT, 1000L)
        )
        annotationFactory.setActions(listOf(action))


        annotationFactory.build(15000L)

        verify(
            annotationListener,
            never()
        ).addOverlay(argThat(ShowOverlayActionArgumentMatcher("id_01")))
        verify(
            annotationListener,
            never()
        ).removeOverlay("id_01", null)
    }

    @Test
    fun `given aforetime{From explicit hide} on-screen ShowOverlayAction, should remove it`() {
        val action = AnnotationAction.ShowOverlayAction(
            "id_01",
            5000L,
            -1L,
            null,
            outroTransitionSpec = TransitionSpec(10000L, AnimationType.FADE_OUT, 1000L)
        )
        annotationFactory.setActions(listOf(action))
        annotationFactory.build(4001L)
        annotationFactory.build(15000L)


        verify(
            annotationListener,
            times(1)
        ).addOverlay(argThat(ShowOverlayActionArgumentMatcher("id_01")))
        verify(
            annotationListener,
            times(1)
        ).removeOverlay(action.customId, null)
    }

    /**region HideOverlayAction related*/
    @Test
    fun `given HideOverlayAction, should remove overlay`() {
        val showOverlayAction = AnnotationAction.ShowOverlayAction(
            "id_01",
            1000L,
            -1L,
            null,
            customId = "cid_1001"
        )
        annotationFactory.setActions(listOf(showOverlayAction))
        annotationFactory.build(1L)


        val action = AnnotationAction.HideOverlayAction("id_01", 5000L, -1L, null, "cid_1001")
        annotationFactory.setActions(listOf(action))

        annotationFactory.build(4001L)

        verify(annotationListener).removeOverlay("cid_1001", null)
        verify(annotationListener, times(1)).addOverlay(showOverlayAction)
    }

    @Test
    fun `given HideOverlayAction with ReshowOverlayAction within range, should not remove overlay`() {
        val hideOverlayAction = AnnotationAction.HideOverlayAction("id_01", 5000L, -1L, null, "cid_1001")
        val reshowOverlayAction = AnnotationAction.ReshowOverlayAction("id_01", 5000L, -1L, "cid_1001")
        annotationFactory.setActions(listOf(hideOverlayAction, reshowOverlayAction))

        annotationFactory.build(4001L)


        verify(annotationListener, never()).removeOverlay("cid_1001", null)
        verify(annotationListener, never()).addOverlay(any())
    }
    /**endregion */

    /**region ReshowOverlayAction related*/
    @Test
    fun `given ReshowOverlayAction, should show overlay`() {
        val showOverlayAction = getSampleShowOverlayAction() // id is cid_1001
        val reshowOverlayAction = AnnotationAction.ReshowOverlayAction("id_01", 8000L, -1L, "cid_1001")
        annotationFactory.setActions(listOf(showOverlayAction, reshowOverlayAction))
        annotationFactory.build(7001L)


        verify(annotationListener).addOverlay(any())
        verify(annotationListener, never()).addOrUpdateLingeringIntroOverlay(any(), any(), any())
        verify(annotationListener, never()).addOrUpdateLingeringMidwayOverlay(any())
        verify(annotationListener, never()).addOrUpdateLingeringOutroOverlay(any(), any(), any())
    }

    @Test
    fun `given ReshowOverlayAction, without related ShowOverlay should not show overlay`() {
        val showOverlayAction = getSampleShowOverlayAction() // id is cid_1001
        val reshowOverlayAction = AnnotationAction.ReshowOverlayAction("id_01", 8000L, -1L, "cid_1002")
        annotationFactory.setActions(listOf(showOverlayAction, reshowOverlayAction))

        verify(annotationListener, never()).addOverlay(any())
        verify(annotationListener, never()).addOrUpdateLingeringIntroOverlay(any(), any(), any())
        verify(annotationListener, never()).addOrUpdateLingeringMidwayOverlay(any())
        verify(annotationListener, never()).addOrUpdateLingeringOutroOverlay(any(), any(), any())
    }
    /**endregion */
    /**endregion */


    /**region Absolute time system*/
    @Ignore("Time Error in CI (Java Related)")
    @Test
    fun `given ShowOverlay action, should add overlay, absolute time system`() {
        val action = AnnotationAction.ShowOverlayAction("id_01", -1L, 1605609887000L)
        annotationFactory.setActions(listOf(action))
//        whenever(player.isWithinValidSegment(any())).thenReturn(true)
//        whenever(player.duration()).thenReturn(120000L)
//        whenever(player.dvrWindowStartTime()).thenReturn(1605609882000L)

        whenever(player.currentPosition()).thenReturn(4001L)
//        whenever(player.currentAbsoluteTime()).thenReturn(1605609886001L)
//        whenever(player.isPlaying()).thenReturn(true)
        annotationFactory.build(4001L)


        verify(annotationListener).addOverlay(argThat(ShowOverlayActionArgumentMatcher("id_01")))
        verify(annotationListener, never()).removeLingeringOverlay(any(), any())
    }

    @Ignore("Time Conversion Error in the CI")
    @Test
    fun `given HideOverlay action, should remove overlay, -absolute-time-system`() {
        val action = AnnotationAction.ShowOverlayAction(
            "id_01",
            -1L,
            1605609886000L,
            null,
            customId = "cid_01"
        )
        annotationFactory.setActions(listOf(action))


        whenever(player.currentPosition()).thenReturn(1L)
//        whenever(player.currentAbsoluteTime()).thenReturn(1605609885001L)
//        whenever(player.isPlaying()).thenReturn(true)
        annotationFactory.build(1L)


        val outroTransitionSpec = TransitionSpec(3000L, AnimationType.FADE_OUT, 3000L)
        val hideAction =
            AnnotationAction.HideOverlayAction("id_01", -1L, 1605609887000L, outroTransitionSpec, "cid_01")
        annotationFactory.setActions(listOf(hideAction))
//        whenever(player.isWithinValidSegment(any())).thenReturn(true)
//        whenever(player.duration()).thenReturn(120000L)
//        whenever(player.dvrWindowStartTime()).thenReturn(1605609885000L)

        whenever(player.currentPosition()).thenReturn(1001L)
//        whenever(player.currentAbsoluteTime()).thenReturn(1605609886001L)
//        whenever(player.isPlaying()).thenReturn(true)
        annotationFactory.build(1001L)


        verify(annotationListener).removeOverlay(
            eq("cid_01"),
            argThat(TransitionSpecArgumentMatcher(2000L))
        )
        verify(annotationListener, never()).addOverlay(any())
    }

    /**region ReshowOverlayAction related*/
    @Test
    fun `given ReshowOverlayAction, should show overlay, -absolute-time-system`() {
        val showOverlayAction = getSampleShowOverlayAction() // id is cid_1001
        val reshowOverlayAction =
            AnnotationAction.ReshowOverlayAction("id_01", 2000L, 1605609887000L, "cid_1001")
        annotationFactory.setActions(listOf(showOverlayAction, reshowOverlayAction))

        annotationFactory.build(1001L)


        verify(annotationListener).addOverlay(any())
        verify(annotationListener, never()).addOrUpdateLingeringIntroOverlay(any(), any(), any())
        verify(annotationListener, never()).addOrUpdateLingeringMidwayOverlay(any())
        verify(annotationListener, never()).addOrUpdateLingeringOutroOverlay(any(), any(), any())
    }

    /**endregion */

    /**endregion */

    @Test
    fun `given mcls actions should get mcls actions as current actions`() {
        val showOverlayAction = getSampleShowOverlayAction()
        annotationFactory.setActions(listOf(showOverlayAction))
        annotationFactory.build(0L)
        annotationFactory.getCurrentActions() shouldBeEqualTo listOf(showOverlayAction)
    }

    @Test
    fun `given gql actions then mcls actions should get mcls actions as current actions`() {
        val hideOverlayActions = getSampleHideOverlayAction(animationType = AnimationType.NONE)
        annotationFactory.setActions(listOf(hideOverlayActions))
        val showOverlayAction = getSampleShowOverlayAction()
        annotationFactory.setActions(listOf(showOverlayAction))

        annotationFactory.getCurrentActions() shouldBeEqualTo listOf(showOverlayAction)
    }

    @Test
    fun `given mcls actions then clear screen then gql actions should get mcls actions as current actions`() {
        val showOverlayAction = getSampleShowOverlayAction()
        annotationFactory.setActions(listOf(showOverlayAction))

        annotationFactory.clearOverlays()

        val hideOverlayActions = getSampleHideOverlayAction(animationType = AnimationType.NONE)
        annotationFactory.setActions(listOf(hideOverlayActions))

        annotationFactory.getCurrentActions() shouldBeEqualTo listOf(hideOverlayActions)
    }
}
