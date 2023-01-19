package tv.mycujoo.annotation.core

import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.annotation.domain.entity.TimelineMarkerEntity
import tv.mycujoo.mclscore.model.TransitionSpec

interface IAnnotationListener {

    fun addOverlay(showOverlayAction: AnnotationAction.ShowOverlayAction)
    fun removeOverlay(customId: String, outroTransitionSpec: TransitionSpec?)


    fun addOrUpdateLingeringIntroOverlay(
        showOverlayAction: AnnotationAction.ShowOverlayAction,
        animationPosition: Long,
        isPlaying: Boolean
    )

    fun addOrUpdateLingeringOutroOverlay(
        showOverlayAction: AnnotationAction.ShowOverlayAction,
        animationPosition: Long,
        isPlaying: Boolean
    )

    fun addOrUpdateLingeringMidwayOverlay(showOverlayAction: AnnotationAction.ShowOverlayAction)

    fun removeLingeringOverlay(customId: String, outroTransitionSpec: TransitionSpec? = null)

    fun setTimelineMarkers(timelineMarkerEntityList: List<TimelineMarkerEntity>)


    /**
     * clears entire screen
     */
    fun clearScreen(idList: List<String>)

    fun clearScreen()
}
