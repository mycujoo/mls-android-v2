---
title: MLSPlaybackControlPresenterViewHolder
---
//[mcls-player-tv](../../../../index.html)/[tv.mycujoo.mclsplayer.tv.presenter](../../index.html)/[MLSPlaybackControlPresenter](../index.html)/[MLSPlaybackControlPresenterViewHolder](index.html)



# MLSPlaybackControlPresenterViewHolder



[androidJvm]\
inner class [MLSPlaybackControlPresenterViewHolder](index.html)(rootView: [View](https://developer.android.com/reference/kotlin/android/view/View.html)) : [MLSControlBarPresenter.MCLSControlBarViewHolder](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/index.html)



## Constructors


| | |
|---|---|
| [MLSPlaybackControlPresenterViewHolder](-m-l-s-playback-control-presenter-view-holder.html) | [androidJvm]<br>constructor(rootView: [View](https://developer.android.com/reference/kotlin/android/view/View.html)) |


## Functions


| Name | Summary |
|---|---|
| [bindControlToAction](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/bind-control-to-action.html) | [androidJvm]<br>fun [bindControlToAction](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/bind-control-to-action.html)(position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), presenter: [Presenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.html)) |
| [getChildMarginDefault](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/get-child-margin-default.html) | [androidJvm]<br>fun [getChildMarginDefault](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/get-child-margin-default.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getChildMarginFromCenter](get-child-margin-from-center.html) | [androidJvm]<br>open override fun [getChildMarginFromCenter](get-child-margin-from-center.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), numControls: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getControlIconWidth](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/get-control-icon-width.html) | [androidJvm]<br>fun [getControlIconWidth](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/get-control-icon-width.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getCurrentTime](get-current-time.html) | [androidJvm]<br>fun [getCurrentTime](get-current-time.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [getDisplayedAdapter](get-displayed-adapter.html) | [androidJvm]<br>open override fun [getDisplayedAdapter](get-displayed-adapter.html)(): [ObjectAdapter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/ObjectAdapter.html)?<br>Returns the adapter currently bound to the displayed controls. May be overridden in a subclass. |
| [getFacet](../../-m-l-s-playback-transport-row-presenter/-v-h/index.html#-482893815%2FFunctions%2F-1202460562) | [androidJvm]<br>override fun [getFacet](../../-m-l-s-playback-transport-row-presenter/-v-h/index.html#-482893815%2FFunctions%2F-1202460562)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? |
| [getSecondaryProgress](get-secondary-progress.html) | [androidJvm]<br>fun [getSecondaryProgress](get-secondary-progress.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [getTotalTime](get-total-time.html) | [androidJvm]<br>fun [getTotalTime](get-total-time.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [setCurrentTime](set-current-time.html) | [androidJvm]<br>fun [setCurrentTime](set-current-time.html)(currentTimeMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [setFacet](../../-m-l-s-playback-transport-row-presenter/-v-h/index.html#1162492555%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setFacet](../../-m-l-s-playback-transport-row-presenter/-v-h/index.html#1162492555%2FFunctions%2F-1202460562)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;, p1: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)) |
| [setSecondaryProgress](set-secondary-progress.html) | [androidJvm]<br>fun [setSecondaryProgress](set-secondary-progress.html)(progressMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [setTotalTime](set-total-time.html) | [androidJvm]<br>fun [setTotalTime](set-total-time.html)(totalTimeMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [showControls](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/show-controls.html) | [androidJvm]<br>fun [showControls](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/show-controls.html)(presenter: [Presenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.html)?) |
| [showMoreActions](show-more-actions.html) | [androidJvm]<br>fun [showMoreActions](show-more-actions.html)(show: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [toggleMoreActions](toggle-more-actions.html) | [androidJvm]<br>fun [toggleMoreActions](toggle-more-actions.html)() |


## Properties


| Name | Summary |
|---|---|
| [adapter](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/adapter.html) | [androidJvm]<br>var [adapter](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/adapter.html): [ObjectAdapter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/ObjectAdapter.html)? |
| [controlBar](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/control-bar.html) | [androidJvm]<br>val [controlBar](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/control-bar.html): [MLSControlBar](../../../tv.mycujoo.mclsplayer.tv.widget/-m-l-s-control-bar/index.html) |
| [data](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/data.html) | [androidJvm]<br>var [data](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/data.html): [MLSControlBarPresenter.BoundData](../../-m-l-s-control-bar-presenter/-bound-data/index.html)? |
| [dataObserver](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/data-observer.html) | [androidJvm]<br>val [dataObserver](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/data-observer.html): [ObjectAdapter.DataObserver](https://developer.android.com/reference/kotlin/androidx/leanback/widget/ObjectAdapter.DataObserver.html) |
| [mCurrentTime](m-current-time.html) | [androidJvm]<br>var [mCurrentTime](m-current-time.html): [TextView](https://developer.android.com/reference/kotlin/android/widget/TextView.html)? |
| [mCurrentTimeInMs](m-current-time-in-ms.html) | [androidJvm]<br>var [mCurrentTimeInMs](m-current-time-in-ms.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [mCurrentTimeMarginStart](m-current-time-margin-start.html) | [androidJvm]<br>var [mCurrentTimeMarginStart](m-current-time-margin-start.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [mCurrentTimeStringBuilder](m-current-time-string-builder.html) | [androidJvm]<br>var [mCurrentTimeStringBuilder](m-current-time-string-builder.html): [StringBuilder](https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html) |
| [mMoreActionsAdapter](m-more-actions-adapter.html) | [androidJvm]<br>var [mMoreActionsAdapter](m-more-actions-adapter.html): [ObjectAdapter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/ObjectAdapter.html)? |
| [mMoreActionsDock](m-more-actions-dock.html) | [androidJvm]<br>var [mMoreActionsDock](m-more-actions-dock.html): [FrameLayout](https://developer.android.com/reference/kotlin/android/widget/FrameLayout.html)? |
| [mMoreActionsObserver](m-more-actions-observer.html) | [androidJvm]<br>var [mMoreActionsObserver](m-more-actions-observer.html): [ObjectAdapter.DataObserver](https://developer.android.com/reference/kotlin/androidx/leanback/widget/ObjectAdapter.DataObserver.html)? |
| [mMoreActionsShowing](m-more-actions-showing.html) | [androidJvm]<br>var [mMoreActionsShowing](m-more-actions-showing.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [mMoreActionsViewHolder](m-more-actions-view-holder.html) | [androidJvm]<br>var [mMoreActionsViewHolder](m-more-actions-view-holder.html): [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)? |
| [mProgressBar](m-progress-bar.html) | [androidJvm]<br>var [mProgressBar](m-progress-bar.html): [ProgressBar](https://developer.android.com/reference/kotlin/android/widget/ProgressBar.html)? |
| [mSecondaryProgressInMs](m-secondary-progress-in-ms.html) | [androidJvm]<br>var [mSecondaryProgressInMs](m-secondary-progress-in-ms.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [mTotalTime](m-total-time.html) | [androidJvm]<br>var [mTotalTime](m-total-time.html): [TextView](https://developer.android.com/reference/kotlin/android/widget/TextView.html)? |
| [mTotalTimeInMs](m-total-time-in-ms.html) | [androidJvm]<br>var [mTotalTimeInMs](m-total-time-in-ms.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [mTotalTimeMarginEnd](m-total-time-margin-end.html) | [androidJvm]<br>var [mTotalTimeMarginEnd](m-total-time-margin-end.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [mTotalTimeStringBuilder](m-total-time-string-builder.html) | [androidJvm]<br>var [mTotalTimeStringBuilder](m-total-time-string-builder.html): [StringBuilder](https://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html) |
| [presenter](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/presenter.html) | [androidJvm]<br>var [presenter](../../-m-l-s-control-bar-presenter/-m-c-l-s-control-bar-view-holder/presenter.html): [Presenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.html)? |
| [view](../../-m-l-s-playback-transport-row-presenter/-v-h/index.html#1384866063%2FProperties%2F-1202460562) | [androidJvm]<br>val [view](../../-m-l-s-playback-transport-row-presenter/-v-h/index.html#1384866063%2FProperties%2F-1202460562): [View](https://developer.android.com/reference/kotlin/android/view/View.html) |

