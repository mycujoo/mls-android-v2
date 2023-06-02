---
title: ISegmentProcessor
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.player](../index.html)/[ISegmentProcessor](index.html)



# ISegmentProcessor

interface [ISegmentProcessor](index.html)

#### Inheritors


| |
|---|
| [SegmentProcessor](../-segment-processor/index.html) |


## Functions


| Name | Summary |
|---|---|
| [clear](clear.html) | [androidJvm]<br>abstract fun [clear](clear.html)() |
| [getDiscontinuityBoundaries](get-discontinuity-boundaries.html) | [androidJvm]<br>abstract fun [getDiscontinuityBoundaries](get-discontinuity-boundaries.html)(): [CopyOnWriteArrayList](https://developer.android.com/reference/kotlin/java/util/concurrent/CopyOnWriteArrayList.html)&lt;[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)&gt;&gt; |
| [getWindowStartTime](get-window-start-time.html) | [androidJvm]<br>abstract fun [getWindowStartTime](get-window-start-time.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [process](process.html) | [androidJvm]<br>abstract fun [process](process.html)(segments: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;HlsMediaPlaylist.Segment&gt;) |

