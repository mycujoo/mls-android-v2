---
title: ShowOverlayAction
---
//[mcls-core](../../../../index.html)/[tv.mycujoo.mclscore.model](../../index.html)/[AnnotationAction](../index.html)/[ShowOverlayAction](index.html)



# ShowOverlayAction



[androidJvm]\
data class [ShowOverlayAction](index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), var absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val svgData: [SvgData](../../-svg-data/index.html)? = null, val duration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, val viewSpec: [ViewSpec](../../-view-spec/index.html)? = null, val introTransitionSpec: [TransitionSpec](../../-transition-spec/index.html)? = null, val outroTransitionSpec: [TransitionSpec](../../-transition-spec/index.html)? = null, val placeHolders: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = emptyList(), val customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = UUID.randomUUID().toString()) : [AnnotationAction](../index.html)

An Annotation action which requires SDK to show an overlay.



## Constructors


| | |
|---|---|
| [ShowOverlayAction](-show-overlay-action.html) | [androidJvm]<br>constructor(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), svgData: [SvgData](../../-svg-data/index.html)? = null, duration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null, viewSpec: [ViewSpec](../../-view-spec/index.html)? = null, introTransitionSpec: [TransitionSpec](../../-transition-spec/index.html)? = null, outroTransitionSpec: [TransitionSpec](../../-transition-spec/index.html)? = null, placeHolders: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt; = emptyList(), customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = UUID.randomUUID().toString()) |


## Functions


| Name | Summary |
|---|---|
| [isEligible](is-eligible.html) | [androidJvm]<br>open override fun [isEligible](is-eligible.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>return eligibility of action at given offset. Defaults to true |
| [isTillNowOrInRange](../is-till-now-or-in-range.html) | [androidJvm]<br>fun [isTillNowOrInRange](../is-till-now-or-in-range.html)(currentTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Determines if an action belongs to this moment or is within this moment and next 1000ms |
| [updateOffset](update-offset.html) | [androidJvm]<br>open override fun [updateOffset](update-offset.html)(newOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [AnnotationAction.ShowOverlayAction](index.html)<br>region Abstract functions |


## Properties


| Name | Summary |
|---|---|
| [absoluteTime](absolute-time.html) | [androidJvm]<br>open override var [absoluteTime](absolute-time.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the absolute time that action should happen at |
| [customId](custom-id.html) | [androidJvm]<br>val [customId](custom-id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>custom identifier of overlay |
| [duration](duration.html) | [androidJvm]<br>val [duration](duration.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? = null<br>duration of current action |
| [id](id.html) | [androidJvm]<br>open override val [id](id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>region Abstract fields |
| [introTransitionSpec](intro-transition-spec.html) | [androidJvm]<br>val [introTransitionSpec](intro-transition-spec.html): [TransitionSpec](../../-transition-spec/index.html)? = null<br>intro transition that should be displayed while bringing the overlay into screen |
| [offset](offset.html) | [androidJvm]<br>open override var [offset](offset.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>the offset that action should happen at |
| [outroTransitionSpec](outro-transition-spec.html) | [androidJvm]<br>val [outroTransitionSpec](outro-transition-spec.html): [TransitionSpec](../../-transition-spec/index.html)? = null<br>outro transition that should be displayed while moving the overlay out of screen |
| [placeHolders](place-holders.html) | [androidJvm]<br>val [placeHolders](place-holders.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;<br>variable placeholder in this overlay |
| [priority](priority.html) | [androidJvm]<br>open override val [priority](priority.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0<br>priority of the action, compared to other actions |
| [svgData](svg-data.html) | [androidJvm]<br>val [svgData](svg-data.html): [SvgData](../../-svg-data/index.html)? = null<br>data needed to parse SVG into overlay |
| [viewSpec](view-spec.html) | [androidJvm]<br>val [viewSpec](view-spec.html): [ViewSpec](../../-view-spec/index.html)? = null<br>position and size of required overlay |

