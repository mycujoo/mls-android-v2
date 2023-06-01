---
title: MLSPlaybackControlPresenter
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.presenter](../index.html)/[MLSPlaybackControlPresenter](index.html)



# MLSPlaybackControlPresenter

class [MLSPlaybackControlPresenter](index.html)(@[LayoutRes](https://developer.android.com/reference/kotlin/androidx/annotation/LayoutRes.html)layoutResourceId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [MLSControlBarPresenter](../-m-l-s-control-bar-presenter/index.html)

Constructor for a PlaybackControlsRowPresenter.



#### Parameters


androidJvm

| | |
|---|---|
| layoutResourceId | The resource id of the layout for this presenter. |



## Constructors


| | |
|---|---|
| [MLSPlaybackControlPresenter](-m-l-s-playback-control-presenter.html) | [androidJvm]<br>constructor(@[LayoutRes](https://developer.android.com/reference/kotlin/androidx/annotation/LayoutRes.html)layoutResourceId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |


## Types


| Name | Summary |
|---|---|
| [BoundData](-bound-data/index.html) | [androidJvm]<br>open class [BoundData](-bound-data/index.html) : [MLSControlBarPresenter.BoundData](../-m-l-s-control-bar-presenter/-bound-data/index.html) |
| [Companion](-companion/index.html) | [androidJvm]<br>object [Companion](-companion/index.html) |
| [MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html) | [androidJvm]<br>inner class [MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html)(rootView: [View](https://developer.android.com/reference/kotlin/android/view/View.html)) : [MLSControlBarPresenter.MCLSControlBarViewHolder](../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/index.html) |


## Functions


| Name | Summary |
|---|---|
| [areMoreActionsEnabled](are-more-actions-enabled.html) | [androidJvm]<br>fun [areMoreActionsEnabled](are-more-actions-enabled.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if secondary actions are enabled. |
| [enableSecondaryActions](enable-secondary-actions.html) | [androidJvm]<br>fun [enableSecondaryActions](enable-secondary-actions.html)(enabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Enables the display of secondary actions. A &quot;more actions&quot; button will be displayed.  When &quot;more actions&quot; is selected, the primary actions are replaced with the secondary actions. |
| [enableTimeMargins](enable-time-margins.html) | [androidJvm]<br>fun [enableTimeMargins](enable-time-margins.html)(vh: [MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html), enable: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [getCurrentTime](get-current-time.html) | [androidJvm]<br>fun [getCurrentTime](get-current-time.html)(vh: [MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getCurrentTimeLong](get-current-time-long.html) | [androidJvm]<br>fun [getCurrentTimeLong](get-current-time-long.html)(vh: [MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html)): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [getFacet](../-m-l-s-playback-transport-row-presenter/index.html#-789590756%2FFunctions%2F-1202460562) | [androidJvm]<br>override fun [getFacet](../-m-l-s-playback-transport-row-presenter/index.html#-789590756%2FFunctions%2F-1202460562)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? |
| [getTotalTime](get-total-time.html) | [androidJvm]<br>fun [getTotalTime](get-total-time.html)(vh: [MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getTotalTimeLong](get-total-time-long.html) | [androidJvm]<br>fun [getTotalTimeLong](get-total-time-long.html)(vh: [MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html)): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [onBindViewHolder](../-m-l-s-playback-transport-row-presenter/index.html#-1615119423%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onBindViewHolder](../-m-l-s-playback-transport-row-presenter/index.html#-1615119423%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html), p1: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), p2: [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;)<br>open override fun [onBindViewHolder](on-bind-view-holder.html)(viewHolder: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)?, item: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?) |
| [onCreateViewHolder](on-create-view-holder.html) | [androidJvm]<br>open override fun [onCreateViewHolder](on-create-view-holder.html)(parent: [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html)?): [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html) |
| [onUnbindViewHolder](on-unbind-view-holder.html) | [androidJvm]<br>open override fun [onUnbindViewHolder](on-unbind-view-holder.html)(viewHolder: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)?) |
| [onViewAttachedToWindow](index.html#-924568759%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onViewAttachedToWindow](index.html#-924568759%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)) |
| [onViewDetachedFromWindow](index.html#-619108282%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onViewDetachedFromWindow](index.html#-619108282%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)) |
| [resetFocus](reset-focus.html) | [androidJvm]<br>fun [resetFocus](reset-focus.html)(vh: [MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html)) |
| [setCurrentTime](set-current-time.html) | [androidJvm]<br>fun [setCurrentTime](set-current-time.html)(vh: [MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html), ms: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [setCurrentTimeLong](set-current-time-long.html) | [androidJvm]<br>fun [setCurrentTimeLong](set-current-time-long.html)(vh: [MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html), ms: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [setFacet](../-m-l-s-playback-transport-row-presenter/index.html#-523029608%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setFacet](../-m-l-s-playback-transport-row-presenter/index.html#-523029608%2FFunctions%2F-1202460562)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;, p1: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)) |
| [setOnClickListener](../-m-l-s-playback-transport-row-presenter/index.html#1820788726%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [setOnClickListener](../-m-l-s-playback-transport-row-presenter/index.html#1820788726%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html), p1: [View.OnClickListener](https://developer.android.com/reference/kotlin/android/view/View.OnClickListener.html)) |
| [setProgressColor](set-progress-color.html) | [androidJvm]<br>fun [setProgressColor](set-progress-color.html)(vh: [MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html), @[ColorInt](https://developer.android.com/reference/kotlin/androidx/annotation/ColorInt.html)color: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [setSecondaryProgress](set-secondary-progress.html) | [androidJvm]<br>fun [setSecondaryProgress](set-secondary-progress.html)(vh: [MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html), progressMs: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [setSecondaryProgressLong](set-secondary-progress-long.html) | [androidJvm]<br>fun [setSecondaryProgressLong](set-secondary-progress-long.html)(vh: [MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html), progressMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [setTotalTime](set-total-time.html) | [androidJvm]<br>fun [setTotalTime](set-total-time.html)(vh: [MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html), ms: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [showPrimaryActions](show-primary-actions.html) | [androidJvm]<br>fun [showPrimaryActions](show-primary-actions.html)(vh: [MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder/index.html)) |


## Properties


| Name | Summary |
|---|---|
| [defaultFocusToMiddle](../-m-l-s-control-bar-presenter/default-focus-to-middle.html) | [androidJvm]<br>var [defaultFocusToMiddle](../-m-l-s-control-bar-presenter/default-focus-to-middle.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True for middle item, false for 0. |
| [layoutResId](../-m-l-s-control-bar-presenter/layout-res-id.html) | [androidJvm]<br>val [layoutResId](../-m-l-s-control-bar-presenter/layout-res-id.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [mMoreActionsEnabled](m-more-actions-enabled.html) | [androidJvm]<br>var [mMoreActionsEnabled](m-more-actions-enabled.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onControlClickedListener](../-m-l-s-control-bar-presenter/on-control-clicked-listener.html) | [androidJvm]<br>var [onControlClickedListener](../-m-l-s-control-bar-presenter/on-control-clicked-listener.html): [MLSControlBarPresenter.OnControlClickedListener](../-m-l-s-control-bar-presenter/-on-control-clicked-listener/index.html)? |
| [onControlSelectedListener](../-m-l-s-control-bar-presenter/on-control-selected-listener.html) | [androidJvm]<br>var [onControlSelectedListener](../-m-l-s-control-bar-presenter/on-control-selected-listener.html): [MLSControlBarPresenter.OnControlSelectedListener](../-m-l-s-control-bar-presenter/-on-control-selected-listener/index.html)? |

