//[mcls-core](../../../../index.md)/[tv.mycujoo.mclscore.model](../../index.md)/[AnnotationAction](../index.md)/[HideOverlayAction](index.md)

# HideOverlayAction

[androidJvm]\
data class [HideOverlayAction](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val outroTransitionSpec: [TransitionSpec](../../-transition-spec/index.md)? = null, val customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [AnnotationAction](../index.md)

An Annotation action which requires SDK to remove an existing overlay.

## Constructors

| | |
|---|---|
| [HideOverlayAction](-hide-overlay-action.md) | [androidJvm]<br>fun [HideOverlayAction](-hide-overlay-action.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), outroTransitionSpec: [TransitionSpec](../../-transition-spec/index.md)? = null, customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [isEligible](../is-eligible.md) | [androidJvm]<br>open fun [isEligible](../is-eligible.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>return eligibility of action at given offset. Defaults to true |
| [isTillNowOrInRange](../is-till-now-or-in-range.md) | [androidJvm]<br>fun [isTillNowOrInRange](../is-till-now-or-in-range.md)(currentTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if an action belongs to this moment or is within this moment and next 1000ms |
| [updateOffset](update-offset.md) | [androidJvm]<br>open override fun [updateOffset](update-offset.md)(newOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [AnnotationAction.HideOverlayAction](index.md)<br>region Abstract functions |

## Properties

| Name | Summary |
|---|---|
| [absoluteTime](absolute-time.md) | [androidJvm]<br>open override var [absoluteTime](absolute-time.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the absolute time that action should happen at |
| [customId](custom-id.md) | [androidJvm]<br>val [customId](custom-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>custom identifier of overlay |
| [id](id.md) | [androidJvm]<br>open override val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>region Abstract fields |
| [offset](offset.md) | [androidJvm]<br>open override var [offset](offset.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the offset that action should happen at |
| [outroTransitionSpec](outro-transition-spec.md) | [androidJvm]<br>val [outroTransitionSpec](outro-transition-spec.md): [TransitionSpec](../../-transition-spec/index.md)? = null<br>outro transition that should be displayed while moving the overlay out of screen |
| [priority](priority.md) | [androidJvm]<br>open override val [priority](priority.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>priority of the action, compared to other actions |
