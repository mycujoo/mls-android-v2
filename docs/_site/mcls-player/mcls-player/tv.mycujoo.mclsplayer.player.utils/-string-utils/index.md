//[mcls-player](../../../index.md)/[tv.mycujoo.mclsplayer.player.utils](../index.md)/[StringUtils](index.md)

# StringUtils

[androidJvm]\
object [StringUtils](index.md)

## Functions

| Name | Summary |
|---|---|
| [getFormattedTime](get-formatted-time.md) | [androidJvm]<br>fun [getFormattedTime](get-formatted-time.md)(timeMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), stringBuilder: [StringBuilder](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/-string-builder/index.html), timeFormatter: [Formatter](https://developer.android.com/reference/kotlin/java/util/Formatter.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns the specified millisecond time formatted as a string. |
| [getNumberOfViewers](get-number-of-viewers.md) | [androidJvm]<br>fun [getNumberOfViewers](get-number-of-viewers.md)(count: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getSegmentTimeStamp](get-segment-time-stamp.md) | [androidJvm]<br>fun [getSegmentTimeStamp](get-segment-time-stamp.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Reads Segment url name and returns [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) presentation of absolute time value or &quot;-1&quot;. |
| [inputStreamToString](input-stream-to-string.md) | [androidJvm]<br>fun [inputStreamToString](input-stream-to-string.md)(inputStream: [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Will read the content from a given [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html) and return it as a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html). |
