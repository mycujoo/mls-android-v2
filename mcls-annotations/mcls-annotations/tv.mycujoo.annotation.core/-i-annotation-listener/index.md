---
title: IAnnotationListener
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.core](../index.html)/[IAnnotationListener](index.html)



# IAnnotationListener

interface [IAnnotationListener](index.html)

#### Inheritors


| |
|---|
| [AnnotationListener](../-annotation-listener/index.html) |


## Functions


| Name | Summary |
|---|---|
| [addOrUpdateLingeringIntroOverlay](add-or-update-lingering-intro-overlay.html) | [androidJvm]<br>abstract fun [addOrUpdateLingeringIntroOverlay](add-or-update-lingering-intro-overlay.html)(showOverlayAction: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [addOrUpdateLingeringMidwayOverlay](add-or-update-lingering-midway-overlay.html) | [androidJvm]<br>abstract fun [addOrUpdateLingeringMidwayOverlay](add-or-update-lingering-midway-overlay.html)(showOverlayAction: AnnotationAction.ShowOverlayAction) |
| [addOrUpdateLingeringOutroOverlay](add-or-update-lingering-outro-overlay.html) | [androidJvm]<br>abstract fun [addOrUpdateLingeringOutroOverlay](add-or-update-lingering-outro-overlay.html)(showOverlayAction: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [addOverlay](add-overlay.html) | [androidJvm]<br>abstract fun [addOverlay](add-overlay.html)(showOverlayAction: AnnotationAction.ShowOverlayAction) |
| [clearScreen](clear-screen.html) | [androidJvm]<br>abstract fun [clearScreen](clear-screen.html)()<br>[androidJvm]<br>abstract fun [clearScreen](clear-screen.html)(idList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;)<br>clears entire screen |
| [removeLingeringOverlay](remove-lingering-overlay.html) | [androidJvm]<br>abstract fun [removeLingeringOverlay](remove-lingering-overlay.html)(customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), outroTransitionSpec: TransitionSpec? = null) |
| [removeOverlay](remove-overlay.html) | [androidJvm]<br>abstract fun [removeOverlay](remove-overlay.html)(customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), outroTransitionSpec: TransitionSpec?) |
| [setTimelineMarkers](set-timeline-markers.html) | [androidJvm]<br>abstract fun [setTimelineMarkers](set-timeline-markers.html)(timelineMarkerEntityList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[TimelineMarkerEntity](../../tv.mycujoo.annotation.domain.entity/-timeline-marker-entity/index.html)&gt;) |

