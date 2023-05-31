---
title: ReshowOverlayAction
---
//[mcls-core](../../../../index.html)/[tv.mycujoo.mclscore.model](../../index.html)/[AnnotationAction](../index.html)/[ReshowOverlayAction](index.html)



# ReshowOverlayAction



[androidJvm]\
data class [ReshowOverlayAction](index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AnnotationAction](../index.html)

An Annotation action which requires SDK to Re-Show an overlay.



## Constructors


| | |
|---|---|
| [ReshowOverlayAction](-reshow-overlay-action.html) | [androidJvm]<br>constructor(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [isEligible](../is-eligible.html) | [androidJvm]<br>open fun [isEligible](../is-eligible.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>return eligibility of action at given offset. Defaults to true |
| [isTillNowOrInRange](../is-till-now-or-in-range.html) | [androidJvm]<br>fun [isTillNowOrInRange](../is-till-now-or-in-range.html)(currentTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if an action belongs to this moment or is within this moment and next 1000ms |
| [updateOffset](update-offset.html) | [androidJvm]<br>open override fun [updateOffset](update-offset.html)(newOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [AnnotationAction.ReshowOverlayAction](index.html)<br>region Abstract functions |


## Properties


| Name | Summary |
|---|---|
| [absoluteTime](absolute-time.html) | [androidJvm]<br>open override var [absoluteTime](absolute-time.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the absolute time that action should happen at |
| [customId](custom-id.html) | [androidJvm]<br>val [customId](custom-id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>custom identifier of overlay |
| [id](id.html) | [androidJvm]<br>open override val [id](id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>region Abstract fields |
| [offset](offset.html) | [androidJvm]<br>open override var [offset](offset.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the offset that action should happen at |
| [priority](priority.html) | [androidJvm]<br>open override val [priority](priority.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>priority of the action, compared to other actions |

