---
title: HideOverlayAction
---
//[mcls-core](../../../../index.html)/[tv.mycujoo.mclscore.model](../../index.html)/[AnnotationAction](../index.html)/[HideOverlayAction](index.html)



# HideOverlayAction



[androidJvm]\
data class [HideOverlayAction](index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val outroTransitionSpec: [TransitionSpec](../../-transition-spec/index.html)? = null, val customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AnnotationAction](../index.html)

An Annotation action which requires SDK to remove an existing overlay.



## Constructors


| | |
|---|---|
| [HideOverlayAction](-hide-overlay-action.html) | [androidJvm]<br>constructor(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), outroTransitionSpec: [TransitionSpec](../../-transition-spec/index.html)? = null, customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [isEligible](../is-eligible.html) | [androidJvm]<br>open fun [isEligible](../is-eligible.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>return eligibility of action at given offset. Defaults to true |
| [isTillNowOrInRange](../is-till-now-or-in-range.html) | [androidJvm]<br>fun [isTillNowOrInRange](../is-till-now-or-in-range.html)(currentTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if an action belongs to this moment or is within this moment and next 1000ms |
| [updateOffset](update-offset.html) | [androidJvm]<br>open override fun [updateOffset](update-offset.html)(newOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [AnnotationAction.HideOverlayAction](index.html)<br>region Abstract functions |


## Properties


| Name | Summary |
|---|---|
| [absoluteTime](absolute-time.html) | [androidJvm]<br>open override var [absoluteTime](absolute-time.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the absolute time that action should happen at |
| [customId](custom-id.html) | [androidJvm]<br>val [customId](custom-id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>custom identifier of overlay |
| [id](id.html) | [androidJvm]<br>open override val [id](id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>region Abstract fields |
| [offset](offset.html) | [androidJvm]<br>open override var [offset](offset.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the offset that action should happen at |
| [outroTransitionSpec](outro-transition-spec.html) | [androidJvm]<br>val [outroTransitionSpec](outro-transition-spec.html): [TransitionSpec](../../-transition-spec/index.html)? = null<br>outro transition that should be displayed while moving the overlay out of screen |
| [priority](priority.html) | [androidJvm]<br>open override val [priority](priority.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>priority of the action, compared to other actions |

