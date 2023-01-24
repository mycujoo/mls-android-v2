//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.core](../index.md)/[IAnnotationListener](index.md)

# IAnnotationListener

[androidJvm]\
interface [IAnnotationListener](index.md)

## Functions

| Name | Summary |
|---|---|
| [addOrUpdateLingeringIntroOverlay](add-or-update-lingering-intro-overlay.md) | [androidJvm]<br>abstract fun [addOrUpdateLingeringIntroOverlay](add-or-update-lingering-intro-overlay.md)(showOverlayAction: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [addOrUpdateLingeringMidwayOverlay](add-or-update-lingering-midway-overlay.md) | [androidJvm]<br>abstract fun [addOrUpdateLingeringMidwayOverlay](add-or-update-lingering-midway-overlay.md)(showOverlayAction: AnnotationAction.ShowOverlayAction) |
| [addOrUpdateLingeringOutroOverlay](add-or-update-lingering-outro-overlay.md) | [androidJvm]<br>abstract fun [addOrUpdateLingeringOutroOverlay](add-or-update-lingering-outro-overlay.md)(showOverlayAction: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [addOverlay](add-overlay.md) | [androidJvm]<br>abstract fun [addOverlay](add-overlay.md)(showOverlayAction: AnnotationAction.ShowOverlayAction) |
| [clearScreen](clear-screen.md) | [androidJvm]<br>abstract fun [clearScreen](clear-screen.md)()<br>[androidJvm]<br>abstract fun [clearScreen](clear-screen.md)(idList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;)<br>clears entire screen |
| [removeLingeringOverlay](remove-lingering-overlay.md) | [androidJvm]<br>abstract fun [removeLingeringOverlay](remove-lingering-overlay.md)(customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), outroTransitionSpec: TransitionSpec? = null) |
| [removeOverlay](remove-overlay.md) | [androidJvm]<br>abstract fun [removeOverlay](remove-overlay.md)(customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), outroTransitionSpec: TransitionSpec?) |
| [setTimelineMarkers](set-timeline-markers.md) | [androidJvm]<br>abstract fun [setTimelineMarkers](set-timeline-markers.md)(timelineMarkerEntityList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TimelineMarkerEntity](../../tv.mycujoo.annotation.domain.entity/-timeline-marker-entity/index.md)&gt;) |

## Inheritors

| Name |
|---|
| [AnnotationListener](../-annotation-listener/index.md) |
