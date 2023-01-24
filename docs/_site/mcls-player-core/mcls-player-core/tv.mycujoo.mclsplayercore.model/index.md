//[mcls-player-core](../../index.md)/[tv.mycujoo.mclsplayercore.model](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [PointOfInterest](-point-of-interest/index.md) | [androidJvm]<br>data class [PointOfInterest](-point-of-interest/index.md)(val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val seekOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val poiType: [PointOfInterestType](-point-of-interest-type/index.md)) |
| [PointOfInterestType](-point-of-interest-type/index.md) | [androidJvm]<br>data class [PointOfInterestType](-point-of-interest-type/index.md)(val color: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = Color.RED.toString()) |
| [PositionedPointOfInterest](-positioned-point-of-interest/index.md) | [androidJvm]<br>data class [PositionedPointOfInterest](-positioned-point-of-interest/index.md)(var positionOnScreen: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val pointOfInterest: [PointOfInterest](-point-of-interest/index.md)) |
| [TimelineMarkerPosition](-timeline-marker-position/index.md) | [androidJvm]<br>interface [TimelineMarkerPosition](-timeline-marker-position/index.md) |
| [UiEvent](-ui-event/index.md) | [androidJvm]<br>data class [UiEvent](-ui-event/index.md)(val title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val description: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val startTime: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val posterUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |
