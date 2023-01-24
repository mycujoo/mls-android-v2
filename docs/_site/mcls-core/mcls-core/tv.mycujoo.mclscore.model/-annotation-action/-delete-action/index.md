//[mcls-core](../../../../index.md)/[tv.mycujoo.mclscore.model](../../index.md)/[AnnotationAction](../index.md)/[DeleteAction](index.md)

# DeleteAction

[androidJvm]\
data class [DeleteAction](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val targetActionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AnnotationAction](../index.md)

Action which delete(ignore) another action

#### Parameters

androidJvm

| | |
|---|---|
| targetActionId | target action id that should be deleted |

## Constructors

| | |
|---|---|
| [DeleteAction](-delete-action.md) | [androidJvm]<br>fun [DeleteAction](-delete-action.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), targetActionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [isEligible](../is-eligible.md) | [androidJvm]<br>open fun [isEligible](../is-eligible.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>return eligibility of action at given offset. Defaults to true |
| [isTillNowOrInRange](../is-till-now-or-in-range.md) | [androidJvm]<br>fun [isTillNowOrInRange](../is-till-now-or-in-range.md)(currentTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if an action belongs to this moment or is within this moment and next 1000ms |
| [updateOffset](update-offset.md) | [androidJvm]<br>open override fun [updateOffset](update-offset.md)(newOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [AnnotationAction.DeleteAction](index.md)<br>region Abstract functions |

## Properties

| Name | Summary |
|---|---|
| [absoluteTime](absolute-time.md) | [androidJvm]<br>open override var [absoluteTime](absolute-time.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the absolute time that action should happen at |
| [id](id.md) | [androidJvm]<br>open override val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>region Abstract fields |
| [offset](offset.md) | [androidJvm]<br>open override var [offset](offset.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the offset that action should happen at |
| [priority](priority.md) | [androidJvm]<br>open override val [priority](priority.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 2000<br>priority of the action, compared to other actions |
| [targetActionId](target-action-id.md) | [androidJvm]<br>val [targetActionId](target-action-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
