//[mcls-player](../../../index.md)/[tv.mycujoo.mclsplayer.player.player](../index.md)/[ISegmentProcessor](index.md)

# ISegmentProcessor

[androidJvm]\
interface [ISegmentProcessor](index.md)

## Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | [androidJvm]<br>abstract fun [clear](clear.md)() |
| [getDiscontinuityBoundaries](get-discontinuity-boundaries.md) | [androidJvm]<br>abstract fun [getDiscontinuityBoundaries](get-discontinuity-boundaries.md)(): [CopyOnWriteArrayList](https://developer.android.com/reference/kotlin/java/util/concurrent/CopyOnWriteArrayList.html)&lt;[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)&gt;&gt; |
| [getWindowStartTime](get-window-start-time.md) | [androidJvm]<br>abstract fun [getWindowStartTime](get-window-start-time.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [process](process.md) | [androidJvm]<br>abstract fun [process](process.md)(segments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;HlsMediaPlaylist.Segment&gt;) |

## Inheritors

| Name |
|---|
| [SegmentProcessor](../-segment-processor/index.md) |
