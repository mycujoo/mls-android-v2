//[mcls-core](../../../../index.md)/[tv.mycujoo.mclscore.model](../../index.md)/[AnnotationAction](../index.md)/[MarkTimelineAction](index.md)

# MarkTimelineAction

[androidJvm]\
data class [MarkTimelineAction](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val seekOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val color: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AnnotationAction](../index.md)

Action to mark a point in time-line as indicator of an event

## Constructors

| | |
|---|---|
| [MarkTimelineAction](-mark-timeline-action.md) | [androidJvm]<br>fun [MarkTimelineAction](-mark-timeline-action.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), seekOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), color: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [isEligible](../is-eligible.md) | [androidJvm]<br>open fun [isEligible](../is-eligible.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>return eligibility of action at given offset. Defaults to true |
| [isTillNowOrInRange](../is-till-now-or-in-range.md) | [androidJvm]<br>fun [isTillNowOrInRange](../is-till-now-or-in-range.md)(currentTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if an action belongs to this moment or is within this moment and next 1000ms |
| [updateOffset](update-offset.md) | [androidJvm]<br>open override fun [updateOffset](update-offset.md)(newOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [AnnotationAction.MarkTimelineAction](index.md)<br>region Abstract functions |

## Properties

| Name | Summary |
|---|---|
| [absoluteTime](absolute-time.md) | [androidJvm]<br>open override var [absoluteTime](absolute-time.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the absolute time that action should happen at |
| [color](color.md) | [androidJvm]<br>val [color](color.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>color of marker |
| [id](id.md) | [androidJvm]<br>open override val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>region Abstract fields |
| [label](label.md) | [androidJvm]<br>val [label](label.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>label on top of marker |
| [offset](offset.md) | [androidJvm]<br>open override var [offset](offset.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the offset that action should happen at |
| [priority](priority.md) | [androidJvm]<br>open override val [priority](priority.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>priority of the action, compared to other actions |
| [seekOffset](seek-offset.md) | [androidJvm]<br>val [seekOffset](seek-offset.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>possible seeking offset |
