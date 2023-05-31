---
title: AnnotationAction
---
//[mcls-core](../../../index.html)/[tv.mycujoo.mclscore.model](../index.html)/[AnnotationAction](index.html)



# AnnotationAction

sealed class [AnnotationAction](index.html)

Annotation Action base sealed class. All annotation action will be of this type.



#### Inheritors


| |
|---|
| [ShowOverlayAction](-show-overlay-action/index.html) |
| [HideOverlayAction](-hide-overlay-action/index.html) |
| [ReshowOverlayAction](-reshow-overlay-action/index.html) |
| [CreateTimerAction](-create-timer-action/index.html) |
| [StartTimerAction](-start-timer-action/index.html) |
| [PauseTimerAction](-pause-timer-action/index.html) |
| [AdjustTimerAction](-adjust-timer-action/index.html) |
| [SkipTimerAction](-skip-timer-action/index.html) |
| [CreateVariableAction](-create-variable-action/index.html) |
| [IncrementVariableAction](-increment-variable-action/index.html) |
| [MarkTimelineAction](-mark-timeline-action/index.html) |
| [DeleteAction](-delete-action/index.html) |
| [InvalidAction](-invalid-action/index.html) |


## Types


| Name | Summary |
|---|---|
| [AdjustTimerAction](-adjust-timer-action/index.html) | [androidJvm]<br>data class [AdjustTimerAction](-adjust-timer-action/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val value: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [AnnotationAction](index.html)<br>Action to adjust value of a Timer |
| [CreateTimerAction](-create-timer-action/index.html) | [androidJvm]<br>data class [CreateTimerAction](-create-timer-action/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val format: [ScreenTimerFormat](../../tv.mycujoo.mclscore.entity/-screen-timer-format/index.html) = ScreenTimerFormat.MINUTES_SECONDS, val direction: [ScreenTimerDirection](../../tv.mycujoo.mclscore.entity/-screen-timer-direction/index.html) = ScreenTimerDirection.UP, val startValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = 0, val capValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [AnnotationAction](index.html)<br>Action to create a Timer |
| [CreateVariableAction](-create-variable-action/index.html) | [androidJvm]<br>data class [CreateVariableAction](-create-variable-action/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val variable: [Variable](../-variable/index.html)) : [AnnotationAction](index.html)<br>Action to create a variable to be used in overlays |
| [DeleteAction](-delete-action/index.html) | [androidJvm]<br>data class [DeleteAction](-delete-action/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val targetActionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AnnotationAction](index.html)<br>Action which delete(ignore) another action |
| [HideOverlayAction](-hide-overlay-action/index.html) | [androidJvm]<br>data class [HideOverlayAction](-hide-overlay-action/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val outroTransitionSpec: [TransitionSpec](../-transition-spec/index.html)? = null, val customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AnnotationAction](index.html)<br>An Annotation action which requires SDK to remove an existing overlay. |
| [IncrementVariableAction](-increment-variable-action/index.html) | [androidJvm]<br>data class [IncrementVariableAction](-increment-variable-action/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val amount: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)) : [AnnotationAction](index.html)<br>Action to increase a variable's value |
| [InvalidAction](-invalid-action/index.html) | [androidJvm]<br>data class [InvalidAction](-invalid-action/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [AnnotationAction](index.html)<br>Any action that is not in correct format, and must ignored will be an Invalid action |
| [MarkTimelineAction](-mark-timeline-action/index.html) | [androidJvm]<br>data class [MarkTimelineAction](-mark-timeline-action/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val seekOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val color: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AnnotationAction](index.html)<br>Action to mark a point in time-line as indicator of an event |
| [PauseTimerAction](-pause-timer-action/index.html) | [androidJvm]<br>data class [PauseTimerAction](-pause-timer-action/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AnnotationAction](index.html)<br>Action to pause a Timer |
| [ReshowOverlayAction](-reshow-overlay-action/index.html) | [androidJvm]<br>data class [ReshowOverlayAction](-reshow-overlay-action/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AnnotationAction](index.html)<br>An Annotation action which requires SDK to Re-Show an overlay. |
| [ShowOverlayAction](-show-overlay-action/index.html) | [androidJvm]<br>data class [ShowOverlayAction](-show-overlay-action/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val svgData: [SvgData](../-svg-data/index.html)? = null, val duration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, val viewSpec: [ViewSpec](../-view-spec/index.html)? = null, val introTransitionSpec: [TransitionSpec](../-transition-spec/index.html)? = null, val outroTransitionSpec: [TransitionSpec](../-transition-spec/index.html)? = null, val placeHolders: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = emptyList(), val customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = UUID.randomUUID().toString()) : [AnnotationAction](index.html)<br>An Annotation action which requires SDK to show an overlay. |
| [SkipTimerAction](-skip-timer-action/index.html) | [androidJvm]<br>data class [SkipTimerAction](-skip-timer-action/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val value: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [AnnotationAction](index.html)<br>Action to skip value of a Timer |
| [StartTimerAction](-start-timer-action/index.html) | [androidJvm]<br>data class [StartTimerAction](-start-timer-action/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AnnotationAction](index.html)<br>Action to start a Timer |


## Functions


| Name | Summary |
|---|---|
| [isEligible](is-eligible.html) | [androidJvm]<br>open fun [isEligible](is-eligible.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>return eligibility of action at given offset. Defaults to true |
| [isTillNowOrInRange](is-till-now-or-in-range.html) | [androidJvm]<br>fun [isTillNowOrInRange](is-till-now-or-in-range.html)(currentTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if an action belongs to this moment or is within this moment and next 1000ms |
| [updateOffset](update-offset.html) | [androidJvm]<br>abstract fun [updateOffset](update-offset.html)(newOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [AnnotationAction](index.html)<br>region Abstract functions |


## Properties


| Name | Summary |
|---|---|
| [absoluteTime](absolute-time.html) | [androidJvm]<br>abstract var [absoluteTime](absolute-time.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the absolute time that action should happen at |
| [id](id.html) | [androidJvm]<br>abstract val [id](id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>region Abstract fields |
| [offset](offset.html) | [androidJvm]<br>abstract var [offset](offset.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the offset that action should happen at |
| [priority](priority.html) | [androidJvm]<br>abstract val [priority](priority.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>priority of the action, compared to other actions |

