---
title: AnnotationListener
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.core](../index.html)/[AnnotationListener](index.html)



# AnnotationListener



[androidJvm]\
class [AnnotationListener](index.html)@Injectconstructor(overlayViewHelper: [OverlayViewHelper](../../tv.mycujoo.annotation.helper/-overlay-view-helper/index.html), downloaderClient: [IDownloaderClient](../../tv.mycujoo.annotation.helper/-i-downloader-client/index.html)) : [IAnnotationListener](../-i-annotation-listener/index.html)



## Constructors


| | |
|---|---|
| [AnnotationListener](-annotation-listener.html) | [androidJvm]<br>@Inject<br>fun [AnnotationListener](-annotation-listener.html)(overlayViewHelper: [OverlayViewHelper](../../tv.mycujoo.annotation.helper/-overlay-view-helper/index.html), downloaderClient: [IDownloaderClient](../../tv.mycujoo.annotation.helper/-i-downloader-client/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [addOrUpdateLingeringIntroOverlay](add-or-update-lingering-intro-overlay.html) | [androidJvm]<br>open override fun [addOrUpdateLingeringIntroOverlay](add-or-update-lingering-intro-overlay.html)(showOverlayAction: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [addOrUpdateLingeringMidwayOverlay](add-or-update-lingering-midway-overlay.html) | [androidJvm]<br>open override fun [addOrUpdateLingeringMidwayOverlay](add-or-update-lingering-midway-overlay.html)(showOverlayAction: AnnotationAction.ShowOverlayAction) |
| [addOrUpdateLingeringOutroOverlay](add-or-update-lingering-outro-overlay.html) | [androidJvm]<br>open override fun [addOrUpdateLingeringOutroOverlay](add-or-update-lingering-outro-overlay.html)(showOverlayAction: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [addOverlay](add-overlay.html) | [androidJvm]<br>open override fun [addOverlay](add-overlay.html)(showOverlayAction: AnnotationAction.ShowOverlayAction) |
| [clearScreen](clear-screen.html) | [androidJvm]<br>open override fun [clearScreen](clear-screen.html)()<br>[androidJvm]<br>open override fun [clearScreen](clear-screen.html)(idList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;)<br>clears entire screen |
| [removeLingeringOverlay](remove-lingering-overlay.html) | [androidJvm]<br>open override fun [removeLingeringOverlay](remove-lingering-overlay.html)(customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), outroTransitionSpec: TransitionSpec?) |
| [removeOverlay](remove-overlay.html) | [androidJvm]<br>open override fun [removeOverlay](remove-overlay.html)(customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), outroTransitionSpec: TransitionSpec?) |
| [setTimelineMarkers](set-timeline-markers.html) | [androidJvm]<br>open override fun [setTimelineMarkers](set-timeline-markers.html)(timelineMarkerEntityList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TimelineMarkerEntity](../../tv.mycujoo.annotation.domain.entity/-timeline-marker-entity/index.html)&gt;) |

