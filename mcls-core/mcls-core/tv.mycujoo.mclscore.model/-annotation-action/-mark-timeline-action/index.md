---
title: MarkTimelineAction
---
//[mcls-core](../../../../index.html)/[tv.mycujoo.mclscore.model](../../index.html)/[AnnotationAction](../index.html)/[MarkTimelineAction](index.html)



# MarkTimelineAction



[androidJvm]\
data class [MarkTimelineAction](index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val seekOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val color: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AnnotationAction](../index.html)

Action to mark a point in time-line as indicator of an event



## Constructors


| | |
|---|---|
| [MarkTimelineAction](-mark-timeline-action.html) | [androidJvm]<br>constructor(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), seekOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), color: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [isEligible](../is-eligible.html) | [androidJvm]<br>open fun [isEligible](../is-eligible.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>return eligibility of action at given offset. Defaults to true |
| [isTillNowOrInRange](../is-till-now-or-in-range.html) | [androidJvm]<br>fun [isTillNowOrInRange](../is-till-now-or-in-range.html)(currentTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if an action belongs to this moment or is within this moment and next 1000ms |
| [updateOffset](update-offset.html) | [androidJvm]<br>open override fun [updateOffset](update-offset.html)(newOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [AnnotationAction.MarkTimelineAction](index.html)<br>region Abstract functions |


## Properties


| Name | Summary |
|---|---|
| [absoluteTime](absolute-time.html) | [androidJvm]<br>open override var [absoluteTime](absolute-time.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the absolute time that action should happen at |
| [color](color.html) | [androidJvm]<br>val [color](color.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>color of marker |
| [id](id.html) | [androidJvm]<br>open override val [id](id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>region Abstract fields |
| [label](label.html) | [androidJvm]<br>val [label](label.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>label on top of marker |
| [offset](offset.html) | [androidJvm]<br>open override var [offset](offset.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the offset that action should happen at |
| [priority](priority.html) | [androidJvm]<br>open override val [priority](priority.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>priority of the action, compared to other actions |
| [seekOffset](seek-offset.html) | [androidJvm]<br>val [seekOffset](seek-offset.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>possible seeking offset |

