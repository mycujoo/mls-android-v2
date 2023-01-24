//[mcls-player-core](../../../index.md)/[tv.mycujoo.mclsplayercore.helper](../index.md)/[StringUtils](index.md)/[getSegmentTimeStamp](get-segment-time-stamp.md)

# getSegmentTimeStamp

[androidJvm]\
fun [getSegmentTimeStamp](get-segment-time-stamp.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)

Reads Segment url name and returns [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) presentation of absolute time value or &quot;-1&quot;.

#### Return

Returns `-1` if the the segment name is not in correct format. Else returns the absolute time from segment url name as [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html).

#### Parameters

androidJvm

| | |
|---|---|
| name | Segment url name [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) which should be read. |
