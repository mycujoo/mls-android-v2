package tv.mycujoo.annotation.core

import android.content.Context
import androidx.constraintlayout.widget.ConstraintLayout
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import tv.mycujoo.annotation.TestData.Companion.getSampleShowOverlayAction
import tv.mycujoo.annotation.helper.IDownloaderClient
import tv.mycujoo.annotation.helper.OverlayViewHelper
import tv.mycujoo.mclscore.entity.AnimationType
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.TransitionSpec

class AnnotationListenerTest {

    /**region Subject under test*/
    private lateinit var annotationListener: AnnotationListener
    /**endregion */

    /**region Fields*/
//    @Mock
//    lateinit var playerView: MLSPlayerView

    @Mock
    lateinit var overlayContainer: ConstraintLayout

    @Mock
    lateinit var overlayViewHelper: OverlayViewHelper

    @Mock
    lateinit var context: Context

    @Mock
    lateinit var downloaderClient: IDownloaderClient

    /**endregion */

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        annotationListener = AnnotationListener(overlayViewHelper, downloaderClient)
//        annotationListener.attachPlayer(playerView)
//        whenever(playerView.overlayHost()).thenReturn(overlayContainer)
//        whenever(playerView.context()).thenReturn(context)
        Mockito.`when`(downloaderClient.download(any(), any()))
            .then { i -> ((i.getArgument(1)) as (AnnotationAction.ShowOverlayAction) -> Unit).invoke(i.getArgument(0)) }
    }

    /**region addOverlay() tests*/
    @Test
    fun `given overlay with intro animation to add, should add it with animation`() {
        val action = getSampleShowOverlayAction()

        annotationListener.addOverlay(action)


        verify(overlayViewHelper).addView( action)
    }

    @Test
    fun `given overlay without intro animation to add, should add it without animation`() {
        val introTransitionSpec = TransitionSpec(15000L, AnimationType.NONE, 2000L)
        val action = getSampleShowOverlayAction(introTransitionSpec, 25000L)

        annotationListener.addOverlay(action)


        verify(overlayViewHelper).addView(action)
    }
    /**endregion */

    /**endregion removeOverlay() tests*/
    @Test
    fun `given overlay with outro animation to remove, should remove it with animation`() {
        val introTransitionSpec = TransitionSpec(15000L, AnimationType.FADE_IN, 2000L)
        val outroTransitionSpec = TransitionSpec(25000L, AnimationType.FADE_OUT, 2000L)
        val action = getSampleShowOverlayAction(introTransitionSpec, outroTransitionSpec)

        annotationListener.removeOverlay(action.id, action.outroTransitionSpec)


        verify(overlayViewHelper).removeView(
            action.id,
            action.outroTransitionSpec
        )
    }

    @Test
    fun `given overlay without outro animation to remove, should remove it with animation`() {
        val introTransitionSpec = TransitionSpec(15000L, AnimationType.FADE_IN, 2000L)
        val outroTransitionSpec = TransitionSpec(25000L, AnimationType.NONE, 2000L)
        val action = getSampleShowOverlayAction(introTransitionSpec, outroTransitionSpec)

        annotationListener.removeOverlay(action.id, action.outroTransitionSpec)


        verify(overlayViewHelper).removeView(
            action.id,
            action.outroTransitionSpec
        )
    }
    /**endregion */

    /**region addOrUpdateLingeringIntroOverlay() tests*/
    @Test
    fun `given lingering-intro overlay which is attached, should update it`() {
        val introTransitionSpec = TransitionSpec(15000L, AnimationType.NONE, 2000L)
        val action = getSampleShowOverlayAction(introTransitionSpec, 25000L)


        annotationListener.addOrUpdateLingeringIntroOverlay(action, 123L, true)


        verify(overlayViewHelper).addOrUpdateLingeringIntroOverlay(
            action,
            123L,
            true
        )
    }

    @Test
    fun `given lingering-intro overlay which is not attached, should add it as lingering`() {
        val introTransitionSpec = TransitionSpec(15000L, AnimationType.NONE, 2000L)
        val action = getSampleShowOverlayAction(introTransitionSpec, 25000L)


        annotationListener.addOrUpdateLingeringIntroOverlay(action, 123L, true)


        verify(overlayViewHelper).addOrUpdateLingeringIntroOverlay(
            action,
            123L,
            true
        )
    }
    /**endregion */

    /**region addOrUpdateLingeringOutroOverlay() tests*/
    @Test
    fun `given lingering-outro overlay which is attached, should update it`() {
        val introTransitionSpec = TransitionSpec(15000L, AnimationType.FADE_IN, 2000L)
        val outroTransitionSpec = TransitionSpec(25000L, AnimationType.NONE, 2000L)
        val action = getSampleShowOverlayAction(introTransitionSpec, outroTransitionSpec)


        annotationListener.addOrUpdateLingeringOutroOverlay(action, 123L, true)


        verify(overlayViewHelper).addOrUpdateLingeringOutroOverlay(
            action,
            123L,
            true
        )
    }

    @Test
    fun `given lingering-outro overlay which is not attached, should add it as lingering`() {
        val introTransitionSpec = TransitionSpec(15000L, AnimationType.FADE_IN, 2000L)
        val outroTransitionSpec = TransitionSpec(25000L, AnimationType.NONE, 2000L)
        val action = getSampleShowOverlayAction(introTransitionSpec, outroTransitionSpec)

        annotationListener.addOrUpdateLingeringOutroOverlay(action, 123L, true)


        verify(overlayViewHelper).addOrUpdateLingeringOutroOverlay(
            action,
            123L,
            true
        )
    }
    /**endregion */

    /**region addOrUpdateLingeringMidwayOverlay() tests*/
    @Test
    fun `given lingering-midway overlay which is attached, should update it`() {
        val introTransitionSpec = TransitionSpec(15000L, AnimationType.NONE, -1L)
        val outroTransitionSpec = TransitionSpec(25000L, AnimationType.NONE, -1L)
        val action = getSampleShowOverlayAction(introTransitionSpec, outroTransitionSpec)


        annotationListener.addOrUpdateLingeringMidwayOverlay(action)


        verify(overlayViewHelper).addOrUpdateLingeringMidwayOverlay(action)
    }

    @Test
    fun `given lingering-midway overlay which is not attached, should add it as lingering`() {
        val introTransitionSpec = TransitionSpec(15000L, AnimationType.NONE, -1L)
        val outroTransitionSpec = TransitionSpec(25000L, AnimationType.NONE, -1L)
        val action = getSampleShowOverlayAction(introTransitionSpec, outroTransitionSpec)


        annotationListener.addOrUpdateLingeringMidwayOverlay(action)


        verify(overlayViewHelper).addOrUpdateLingeringMidwayOverlay(action)
    }
    /**endregion */

    /**region clearScreen() tests*/
    @Test
    fun `given clear screen, should clear given list`() {
        val list = listOf("a0", "b1", "c2", "d4")


        annotationListener.clearScreen(list)


        verify(overlayViewHelper).clearScreen()
    }

    /**endregion */
}