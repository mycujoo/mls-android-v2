---
title: MLSPlaybackTransportRowPresenter
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.presenter](../index.html)/[MLSPlaybackTransportRowPresenter](index.html)



# MLSPlaybackTransportRowPresenter



[androidJvm]\
open class [MLSPlaybackTransportRowPresenter](index.html)(controllerAgent: [ControllerAgent](../../tv.mycujoo.mclsplayer.tv.controller/-controller-agent/index.html), config: [MCLSTVConfiguration](../../tv.mycujoo.mclsplayer.tv.config/-m-c-l-s-t-v-configuration/index.html)) : [PlaybackRowPresenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackRowPresenter.html)



## Constructors


| | |
|---|---|
| [MLSPlaybackTransportRowPresenter](-m-l-s-playback-transport-row-presenter.html) | [androidJvm]<br>constructor(controllerAgent: [ControllerAgent](../../tv.mycujoo.mclsplayer.tv.controller/-controller-agent/index.html), config: [MCLSTVConfiguration](../../tv.mycujoo.mclsplayer.tv.config/-m-c-l-s-t-v-configuration/index.html)) |


## Types


| Name | Summary |
|---|---|
| [BoundData](-bound-data/index.html) | [androidJvm]<br>class [BoundData](-bound-data/index.html) : [MLSPlaybackControlPresenter.BoundData](../-m-l-s-playback-control-presenter/-bound-data/index.html) |
| [Companion](-companion/index.html) | [androidJvm]<br>object [Companion](-companion/index.html) |
| [VH](-v-h/index.html) | [androidJvm]<br>open inner class [VH](-v-h/index.html)(rootView: [View](https://developer.android.com/reference/kotlin/android/view/View.html), descriptionPresenter: [Presenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.html)?) : [PlaybackRowPresenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackRowPresenter.ViewHolder.html), [PlaybackSeekUi](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackSeekUi.html)<br>A ViewHolder for the PlaybackControlsRow supporting seek UI. |


## Functions


| Name | Summary |
|---|---|
| [freeze](index.html#-1318720813%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [freeze](index.html#-1318720813%2FFunctions%2F-1202460562)(p0: [RowPresenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/RowPresenter.ViewHolder.html), p1: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [getFacet](index.html#-789590756%2FFunctions%2F-1202460562) | [androidJvm]<br>override fun [getFacet](index.html#-789590756%2FFunctions%2F-1202460562)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? |
| [getHeaderPresenter](index.html#257261990%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [getHeaderPresenter](index.html#257261990%2FFunctions%2F-1202460562)(): [RowHeaderPresenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/RowHeaderPresenter.html) |
| [getRowViewHolder](index.html#-1918726553%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [getRowViewHolder](index.html#-1918726553%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)): [RowPresenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/RowPresenter.ViewHolder.html) |
| [getSelectEffectEnabled](index.html#52688781%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [getSelectEffectEnabled](index.html#52688781%2FFunctions%2F-1202460562)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getSelectLevel](index.html#-682570396%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [getSelectLevel](index.html#-682570396%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [getSyncActivatePolicy](index.html#-934725223%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [getSyncActivatePolicy](index.html#-934725223%2FFunctions%2F-1202460562)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isUsingDefaultSelectEffect](index.html#-1663290313%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [isUsingDefaultSelectEffect](index.html#-1663290313%2FFunctions%2F-1202460562)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onBindViewHolder](index.html#-1615119423%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onBindViewHolder](index.html#-1615119423%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html), p1: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), p2: [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;)<br>override fun [onBindViewHolder](index.html#905561825%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html), p1: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)) |
| [onCreateViewHolder](index.html#1331033231%2FFunctions%2F-1202460562) | [androidJvm]<br>override fun [onCreateViewHolder](index.html#1331033231%2FFunctions%2F-1202460562)(p0: [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html)): [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html) |
| [onReappear](on-reappear.html) | [androidJvm]<br>open override fun [onReappear](on-reappear.html)(rowViewHolder: [RowPresenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/RowPresenter.ViewHolder.html)) |
| [onUnbindViewHolder](index.html#-1032564136%2FFunctions%2F-1202460562) | [androidJvm]<br>override fun [onUnbindViewHolder](index.html#-1032564136%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)) |
| [onViewAttachedToWindow](index.html#-937797307%2FFunctions%2F-1202460562) | [androidJvm]<br>override fun [onViewAttachedToWindow](index.html#-937797307%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)) |
| [onViewDetachedFromWindow](index.html#-446841022%2FFunctions%2F-1202460562) | [androidJvm]<br>override fun [onViewDetachedFromWindow](index.html#-446841022%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)) |
| [setDescriptionPresenter](set-description-presenter.html) | [androidJvm]<br>fun [setDescriptionPresenter](set-description-presenter.html)(descriptionPresenter: [Presenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.html)?) |
| [setEntranceTransitionState](index.html#2112053280%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [setEntranceTransitionState](index.html#2112053280%2FFunctions%2F-1202460562)(p0: [RowPresenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/RowPresenter.ViewHolder.html), p1: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setFacet](index.html#-523029608%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setFacet](index.html#-523029608%2FFunctions%2F-1202460562)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;, p1: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)) |
| [setHeaderPresenter](index.html#1632236993%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setHeaderPresenter](index.html#1632236993%2FFunctions%2F-1202460562)(p0: [RowHeaderPresenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/RowHeaderPresenter.html)) |
| [setOnClickListener](index.html#1820788726%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [setOnClickListener](index.html#1820788726%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html), p1: [View.OnClickListener](https://developer.android.com/reference/kotlin/android/view/View.OnClickListener.html)) |
| [setRowViewExpanded](index.html#-1856260324%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setRowViewExpanded](index.html#-1856260324%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html), p1: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setRowViewSelected](index.html#441672314%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setRowViewSelected](index.html#441672314%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html), p1: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setSelectEffectEnabled](index.html#-592401890%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setSelectEffectEnabled](index.html#-592401890%2FFunctions%2F-1202460562)(p0: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setSelectLevel](index.html#-1990978888%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setSelectLevel](index.html#-1990978888%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html), p1: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)) |
| [setSyncActivatePolicy](index.html#2000071275%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setSyncActivatePolicy](index.html#2000071275%2FFunctions%2F-1202460562)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |


## Properties


| Name | Summary |
|---|---|
| [progressColor](progress-color.html) | [androidJvm]<br>@get:[ColorInt](https://developer.android.com/reference/kotlin/androidx/annotation/ColorInt.html)<br>var [progressColor](progress-color.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Sets the primary color for the progress bar.  If not set, a default from the theme will be used. |
| [secondaryProgressColor](secondary-progress-color.html) | [androidJvm]<br>@get:[ColorInt](https://developer.android.com/reference/kotlin/androidx/annotation/ColorInt.html)<br>var [secondaryProgressColor](secondary-progress-color.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Sets the secondary color for the progress bar.  If not set, a default from the theme androidx.leanback.R.attr.playbackProgressSecondaryColor will be used. |

