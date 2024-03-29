package tv.mycujoo.annotation.core

import tv.mycujoo.annotation.domain.entity.TimelineMarkerEntity
import tv.mycujoo.annotation.helper.IDownloaderClient
import tv.mycujoo.annotation.helper.OverlayViewHelper
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.TransitionSpec
import javax.inject.Inject

class AnnotationListener @Inject constructor(
    private val overlayViewHelper: OverlayViewHelper,
    private val downloaderClient: IDownloaderClient,
) : IAnnotationListener {

    override fun addOverlay(showOverlayAction: AnnotationAction.ShowOverlayAction) {
        downloaderClient.download(showOverlayAction) { downloadedShowOverlayAction ->
            overlayViewHelper.addView(downloadedShowOverlayAction)
        }
    }

    override fun removeOverlay(customId: String, outroTransitionSpec: TransitionSpec?) {
        overlayViewHelper.removeView(customId, outroTransitionSpec)
    }

    override fun addOrUpdateLingeringIntroOverlay(
        showOverlayAction: AnnotationAction.ShowOverlayAction,
        animationPosition: Long,
        isPlaying: Boolean
    ) {
        downloaderClient.download(showOverlayAction) {
            overlayViewHelper.addOrUpdateLingeringIntroOverlay(
                it,
                animationPosition,
                isPlaying
            )
        }
    }

    override fun addOrUpdateLingeringOutroOverlay(
        showOverlayAction: AnnotationAction.ShowOverlayAction,
        animationPosition: Long,
        isPlaying: Boolean
    ) {
        downloaderClient.download(showOverlayAction) { downloadedShowOverlayAction ->
            overlayViewHelper.addOrUpdateLingeringOutroOverlay(
                downloadedShowOverlayAction,
                animationPosition,
                isPlaying
            )
        }
    }

    override fun addOrUpdateLingeringMidwayOverlay(showOverlayAction: AnnotationAction.ShowOverlayAction) {
        downloaderClient.download(showOverlayAction) { downloadedShowOverlayAction ->
            overlayViewHelper.addOrUpdateLingeringMidwayOverlay(downloadedShowOverlayAction)
        }
    }

    override fun removeLingeringOverlay(customId: String, outroTransitionSpec: TransitionSpec?) {
        overlayViewHelper.removeView(customId, outroTransitionSpec)
    }

    override fun setTimelineMarkers(timelineMarkerEntityList: List<TimelineMarkerEntity>) {
//        annotationView.setTimelineMarker(timelineMarkerEntityList)
    }

    override fun clearScreen(idList: List<String>) {
        overlayViewHelper.clearScreen()
    }

    override fun clearScreen() {
        overlayViewHelper.clearScreen()
    }
}
