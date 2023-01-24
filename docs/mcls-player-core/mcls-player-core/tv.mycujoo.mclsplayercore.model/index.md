---
title: tv.mycujoo.mclsplayercore.model
---
//[mcls-player-core](../../index.html)/[tv.mycujoo.mclsplayercore.model](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [PointOfInterest](-point-of-interest/index.html) | [androidJvm]<br>data class [PointOfInterest](-point-of-interest/index.html)(val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val seekOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val poiType: [PointOfInterestType](-point-of-interest-type/index.html)) |
| [PointOfInterestType](-point-of-interest-type/index.html) | [androidJvm]<br>data class [PointOfInterestType](-point-of-interest-type/index.html)(val color: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = Color.RED.toString()) |
| [PositionedPointOfInterest](-positioned-point-of-interest/index.html) | [androidJvm]<br>data class [PositionedPointOfInterest](-positioned-point-of-interest/index.html)(var positionOnScreen: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val pointOfInterest: [PointOfInterest](-point-of-interest/index.html)) |
| [TimelineMarkerPosition](-timeline-marker-position/index.html) | [androidJvm]<br>interface [TimelineMarkerPosition](-timeline-marker-position/index.html) |
| [UiEvent](-ui-event/index.html) | [androidJvm]<br>data class [UiEvent](-ui-event/index.html)(val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val startTime: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val posterUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

