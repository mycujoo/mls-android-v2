//[mcls-player](../../../index.md)/[tv.mycujoo.mclsplayer.player.player](../index.md)/[MediaOnLoadCompletedListener](index.md)

# MediaOnLoadCompletedListener

[androidJvm]\
class [MediaOnLoadCompletedListener](index.md)@Injectconstructor(exoPlayerContainer: [ExoPlayerContainer](../../tv.mycujoo.mclsplayer.player.utils/-exo-player-container/index.md), segmentProcessor: [ISegmentProcessor](../-i-segment-processor/index.md)) : MediaSourceEventListener

## Constructors

| | |
|---|---|
| [MediaOnLoadCompletedListener](-media-on-load-completed-listener.md) | [androidJvm]<br>@Inject<br>fun [MediaOnLoadCompletedListener](-media-on-load-completed-listener.md)(exoPlayerContainer: [ExoPlayerContainer](../../tv.mycujoo.mclsplayer.player.utils/-exo-player-container/index.md), segmentProcessor: [ISegmentProcessor](../-i-segment-processor/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | [androidJvm]<br>fun [clear](clear.md)() |
| [getDiscontinuityBoundaries](get-discontinuity-boundaries.md) | [androidJvm]<br>fun [getDiscontinuityBoundaries](get-discontinuity-boundaries.md)(): [CopyOnWriteArrayList](https://developer.android.com/reference/kotlin/java/util/concurrent/CopyOnWriteArrayList.html)&lt;[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)&gt;&gt; |
| [getWindowStartTime](get-window-start-time.md) | [androidJvm]<br>fun [getWindowStartTime](get-window-start-time.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [onDownstreamFormatChanged](index.md#-928968517%2FFunctions%2F1012385356) | [androidJvm]<br>open fun [onDownstreamFormatChanged](index.md#-928968517%2FFunctions%2F1012385356)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)p1: MediaSource.MediaPeriodId?, p2: MediaLoadData) |
| [onLoadCanceled](index.md#-1773886879%2FFunctions%2F1012385356) | [androidJvm]<br>open fun [onLoadCanceled](index.md#-1773886879%2FFunctions%2F1012385356)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)p1: MediaSource.MediaPeriodId?, p2: LoadEventInfo, p3: MediaLoadData) |
| [onLoadCompleted](on-load-completed.md) | [androidJvm]<br>open override fun [onLoadCompleted](on-load-completed.md)(windowIndex: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), mediaPeriodId: MediaSource.MediaPeriodId?, loadEventInfo: LoadEventInfo, mediaLoadData: MediaLoadData) |
| [onLoadError](index.md#2036408342%2FFunctions%2F1012385356) | [androidJvm]<br>open fun [onLoadError](index.md#2036408342%2FFunctions%2F1012385356)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)p1: MediaSource.MediaPeriodId?, p2: LoadEventInfo, p3: MediaLoadData, p4: [IOException](https://developer.android.com/reference/kotlin/java/io/IOException.html), p5: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [onLoadStarted](index.md#-1307665249%2FFunctions%2F1012385356) | [androidJvm]<br>open fun [onLoadStarted](index.md#-1307665249%2FFunctions%2F1012385356)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), @[Nullable](https://developer.android.com/reference/kotlin/androidx/annotation/Nullable.html)p1: MediaSource.MediaPeriodId?, p2: LoadEventInfo, p3: MediaLoadData) |
| [onUpstreamDiscarded](index.md#1331629843%2FFunctions%2F1012385356) | [androidJvm]<br>open fun [onUpstreamDiscarded](index.md#1331629843%2FFunctions%2F1012385356)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), p1: MediaSource.MediaPeriodId, p2: MediaLoadData) |
