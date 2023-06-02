---
title: MediaOnLoadCompletedListener
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.player](../index.html)/[MediaOnLoadCompletedListener](index.html)



# MediaOnLoadCompletedListener



[androidJvm]\
class [MediaOnLoadCompletedListener](index.html)@Injectconstructor(exoPlayer: ExoPlayer) : MediaSourceEventListener



## Constructors


| | |
|---|---|
| [MediaOnLoadCompletedListener](-media-on-load-completed-listener.html) | [androidJvm]<br>@Inject<br>constructor(exoPlayer: ExoPlayer) |


## Functions


| Name | Summary |
|---|---|
| [clear](clear.html) | [androidJvm]<br>fun [clear](clear.html)() |
| [getDiscontinuityBoundaries](get-discontinuity-boundaries.html) | [androidJvm]<br>fun [getDiscontinuityBoundaries](get-discontinuity-boundaries.html)(): [CopyOnWriteArrayList](https://developer.android.com/reference/kotlin/java/util/concurrent/CopyOnWriteArrayList.html)&lt;[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)&gt;&gt; |
| [getWindowStartTime](get-window-start-time.html) | [androidJvm]<br>fun [getWindowStartTime](get-window-start-time.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [onDownstreamFormatChanged](index.html#-928968517%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onDownstreamFormatChanged](index.html#-928968517%2FFunctions%2F-1202460562)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)p1: MediaSource.MediaPeriodId?, p2: MediaLoadData) |
| [onLoadCanceled](index.html#-1773886879%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onLoadCanceled](index.html#-1773886879%2FFunctions%2F-1202460562)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)p1: MediaSource.MediaPeriodId?, p2: LoadEventInfo, p3: MediaLoadData) |
| [onLoadCompleted](on-load-completed.html) | [androidJvm]<br>open override fun [onLoadCompleted](on-load-completed.html)(windowIndex: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), mediaPeriodId: MediaSource.MediaPeriodId?, loadEventInfo: LoadEventInfo, mediaLoadData: MediaLoadData) |
| [onLoadError](index.html#2036408342%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onLoadError](index.html#2036408342%2FFunctions%2F-1202460562)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)p1: MediaSource.MediaPeriodId?, p2: LoadEventInfo, p3: MediaLoadData, p4: [IOException](https://developer.android.com/reference/kotlin/java/io/IOException.html), p5: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [onLoadStarted](index.html#-1307665249%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onLoadStarted](index.html#-1307665249%2FFunctions%2F-1202460562)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)p1: MediaSource.MediaPeriodId?, p2: LoadEventInfo, p3: MediaLoadData) |
| [onUpstreamDiscarded](index.html#1331629843%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onUpstreamDiscarded](index.html#1331629843%2FFunctions%2F-1202460562)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), p1: MediaSource.MediaPeriodId, p2: MediaLoadData) |

