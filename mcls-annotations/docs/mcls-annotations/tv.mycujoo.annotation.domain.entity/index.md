---
title: tv.mycujoo.annotation.domain.entity
---
//[mcls-annotations](../../index.html)/[tv.mycujoo.annotation.domain.entity](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [HideOverlayActionEntity](-hide-overlay-action-entity/index.html) | [androidJvm]<br>data class [HideOverlayActionEntity](-hide-overlay-action-entity/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val outroAnimationType: AnimationType, val outroAnimationDuration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [ShowOverlayActionEntity](-show-overlay-action-entity/index.html) | [androidJvm]<br>data class [ShowOverlayActionEntity](-show-overlay-action-entity/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val svgInputStream: [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html)?, val positionGuide: PositionGuide, val size: [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)&gt;, val duration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, val introAnimationType: AnimationType, val introAnimationDuration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val outroAnimationType: AnimationType, val outroAnimationDuration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [TimelineMarkerEntity](-timeline-marker-entity/index.html) | [androidJvm]<br>data class [TimelineMarkerEntity](-timeline-marker-entity/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val seekOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val color: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Timeline marker info to mark some point on timeline based on Offset. |
| [VariableEntity](-variable-entity/index.html) | [androidJvm]<br>data class [VariableEntity](-variable-entity/index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val variable: Variable)<br>A variable with offset & id |

