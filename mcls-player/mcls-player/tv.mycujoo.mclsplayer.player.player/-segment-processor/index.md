---
title: SegmentProcessor
---
//[mcls-player](../../../index.html)/[tv.mycujoo.mclsplayer.player.player](../index.html)/[SegmentProcessor](index.html)



# SegmentProcessor



[androidJvm]\
class [SegmentProcessor](index.html)@Injectconstructor : [ISegmentProcessor](../-i-segment-processor/index.html)



## Constructors


| | |
|---|---|
| [SegmentProcessor](-segment-processor.html) | [androidJvm]<br>@Inject<br>constructor() |


## Functions


| Name | Summary |
|---|---|
| [clear](clear.html) | [androidJvm]<br>open override fun [clear](clear.html)() |
| [getDiscontinuityBoundaries](get-discontinuity-boundaries.html) | [androidJvm]<br>open override fun [getDiscontinuityBoundaries](get-discontinuity-boundaries.html)(): [CopyOnWriteArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CopyOnWriteArrayList.html)&lt;[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)&gt;&gt; |
| [getWindowStartTime](get-window-start-time.html) | [androidJvm]<br>open override fun [getWindowStartTime](get-window-start-time.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [process](process.html) | [androidJvm]<br>open override fun [process](process.html)(segments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;HlsMediaPlaylist.Segment&gt;) |

