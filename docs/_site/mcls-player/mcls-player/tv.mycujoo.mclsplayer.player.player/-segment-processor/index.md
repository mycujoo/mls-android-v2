//[mcls-player](../../../index.md)/[tv.mycujoo.mclsplayer.player.player](../index.md)/[SegmentProcessor](index.md)

# SegmentProcessor

[androidJvm]\
class [SegmentProcessor](index.md)@Injectconstructor : [ISegmentProcessor](../-i-segment-processor/index.md)

## Constructors

| | |
|---|---|
| [SegmentProcessor](-segment-processor.md) | [androidJvm]<br>@Inject<br>fun [SegmentProcessor](-segment-processor.md)() |

## Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | [androidJvm]<br>open override fun [clear](clear.md)() |
| [getDiscontinuityBoundaries](get-discontinuity-boundaries.md) | [androidJvm]<br>open override fun [getDiscontinuityBoundaries](get-discontinuity-boundaries.md)(): [CopyOnWriteArrayList](https://developer.android.com/reference/kotlin/java/util/concurrent/CopyOnWriteArrayList.html)&lt;[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)&gt;&gt; |
| [getWindowStartTime](get-window-start-time.md) | [androidJvm]<br>open override fun [getWindowStartTime](get-window-start-time.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [process](process.md) | [androidJvm]<br>open override fun [process](process.md)(segments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;HlsMediaPlaylist.Segment&gt;) |
