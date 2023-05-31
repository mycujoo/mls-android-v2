---
title: ShowOverlayActionEntity
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.domain.entity](../index.html)/[ShowOverlayActionEntity](index.html)



# ShowOverlayActionEntity



[androidJvm]\
data class [ShowOverlayActionEntity](index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val svgInputStream: [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html)?, val positionGuide: PositionGuide, val size: [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)&gt;, val duration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, val introAnimationType: AnimationType, val introAnimationDuration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val outroAnimationType: AnimationType, val outroAnimationDuration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))



## Constructors


| | |
|---|---|
| [ShowOverlayActionEntity](-show-overlay-action-entity.html) | [androidJvm]<br>constructor(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, svgInputStream: [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html)?, positionGuide: PositionGuide, size: [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)&gt;, duration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, introAnimationType: AnimationType, introAnimationDuration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), outroAnimationType: AnimationType, outroAnimationDuration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |


## Properties


| Name | Summary |
|---|---|
| [customId](custom-id.html) | [androidJvm]<br>val [customId](custom-id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [duration](duration.html) | [androidJvm]<br>val [duration](duration.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? |
| [id](id.html) | [androidJvm]<br>val [id](id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [introAnimationDuration](intro-animation-duration.html) | [androidJvm]<br>val [introAnimationDuration](intro-animation-duration.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [introAnimationType](intro-animation-type.html) | [androidJvm]<br>val [introAnimationType](intro-animation-type.html): AnimationType |
| [outroAnimationDuration](outro-animation-duration.html) | [androidJvm]<br>val [outroAnimationDuration](outro-animation-duration.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [outroAnimationType](outro-animation-type.html) | [androidJvm]<br>val [outroAnimationType](outro-animation-type.html): AnimationType |
| [positionGuide](position-guide.html) | [androidJvm]<br>val [positionGuide](position-guide.html): PositionGuide |
| [size](size.html) | [androidJvm]<br>val [size](size.html): [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html), [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)&gt; |
| [svgInputStream](svg-input-stream.html) | [androidJvm]<br>val [svgInputStream](svg-input-stream.html): [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html)? |

