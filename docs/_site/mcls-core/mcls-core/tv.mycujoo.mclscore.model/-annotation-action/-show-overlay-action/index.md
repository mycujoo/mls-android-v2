//[mcls-core](../../../../index.md)/[tv.mycujoo.mclscore.model](../../index.md)/[AnnotationAction](../index.md)/[ShowOverlayAction](index.md)

# ShowOverlayAction

[androidJvm]\
data class [ShowOverlayAction](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val svgData: [SvgData](../../-svg-data/index.md)? = null, val duration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, val viewSpec: [ViewSpec](../../-view-spec/index.md)? = null, val introTransitionSpec: [TransitionSpec](../../-transition-spec/index.md)? = null, val outroTransitionSpec: [TransitionSpec](../../-transition-spec/index.md)? = null, val placeHolders: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = emptyList(), val customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = UUID.randomUUID().toString()) : [AnnotationAction](../index.md)

An Annotation action which requires SDK to show an overlay.

## Constructors

| | |
|---|---|
| [ShowOverlayAction](-show-overlay-action.md) | [androidJvm]<br>fun [ShowOverlayAction](-show-overlay-action.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), svgData: [SvgData](../../-svg-data/index.md)? = null, duration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, viewSpec: [ViewSpec](../../-view-spec/index.md)? = null, introTransitionSpec: [TransitionSpec](../../-transition-spec/index.md)? = null, outroTransitionSpec: [TransitionSpec](../../-transition-spec/index.md)? = null, placeHolders: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = emptyList(), customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = UUID.randomUUID().toString()) |

## Functions

| Name | Summary |
|---|---|
| [isEligible](is-eligible.md) | [androidJvm]<br>open override fun [isEligible](is-eligible.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>return eligibility of action at given offset. Defaults to true |
| [isTillNowOrInRange](../is-till-now-or-in-range.md) | [androidJvm]<br>fun [isTillNowOrInRange](../is-till-now-or-in-range.md)(currentTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if an action belongs to this moment or is within this moment and next 1000ms |
| [updateOffset](update-offset.md) | [androidJvm]<br>open override fun [updateOffset](update-offset.md)(newOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [AnnotationAction.ShowOverlayAction](index.md)<br>region Abstract functions |

## Properties

| Name | Summary |
|---|---|
| [absoluteTime](absolute-time.md) | [androidJvm]<br>open override var [absoluteTime](absolute-time.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the absolute time that action should happen at |
| [customId](custom-id.md) | [androidJvm]<br>val [customId](custom-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>custom identifier of overlay |
| [duration](duration.md) | [androidJvm]<br>val [duration](duration.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null<br>duration of current action |
| [id](id.md) | [androidJvm]<br>open override val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>region Abstract fields |
| [introTransitionSpec](intro-transition-spec.md) | [androidJvm]<br>val [introTransitionSpec](intro-transition-spec.md): [TransitionSpec](../../-transition-spec/index.md)? = null<br>intro transition that should be displayed while bringing the overlay into screen |
| [offset](offset.md) | [androidJvm]<br>open override var [offset](offset.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the offset that action should happen at |
| [outroTransitionSpec](outro-transition-spec.md) | [androidJvm]<br>val [outroTransitionSpec](outro-transition-spec.md): [TransitionSpec](../../-transition-spec/index.md)? = null<br>outro transition that should be displayed while moving the overlay out of screen |
| [placeHolders](place-holders.md) | [androidJvm]<br>val [placeHolders](place-holders.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;<br>variable placeholder in this overlay |
| [priority](priority.md) | [androidJvm]<br>open override val [priority](priority.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>priority of the action, compared to other actions |
| [svgData](svg-data.md) | [androidJvm]<br>val [svgData](svg-data.md): [SvgData](../../-svg-data/index.md)? = null<br>data needed to parse SVG into overlay |
| [viewSpec](view-spec.md) | [androidJvm]<br>val [viewSpec](view-spec.md): [ViewSpec](../../-view-spec/index.md)? = null<br>position and size of required overlay |
