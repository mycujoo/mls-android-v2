---
title: MCLSControlBarViewHolder
---
//[mcls-player-tv](../../../../index.html)/[tv.mycujoo.mclsplayer.tv.presenter](../../index.html)/[MLSControlBarPresenter](../index.html)/[MCLSControlBarViewHolder](index.html)



# MCLSControlBarViewHolder

open inner class [MCLSControlBarViewHolder](index.html)(rootView: [View](https://developer.android.com/reference/kotlin/android/view/View.html)) : [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)

#### Inheritors


| |
|---|
| [MLSPlaybackControlPresenterViewHolder](../../-m-l-s-playback-control-presenter/-m-l-s-playback-control-presenter-view-holder/index.html) |


## Constructors


| | |
|---|---|
| [MCLSControlBarViewHolder](-m-c-l-s-control-bar-view-holder.html) | [androidJvm]<br>constructor(rootView: [View](https://developer.android.com/reference/kotlin/android/view/View.html)) |


## Functions


| Name | Summary |
|---|---|
| [bindControlToAction](bind-control-to-action.html) | [androidJvm]<br>fun [bindControlToAction](bind-control-to-action.html)(position: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), presenter: [Presenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.html)) |
| [getChildMarginDefault](get-child-margin-default.html) | [androidJvm]<br>fun [getChildMarginDefault](get-child-margin-default.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getChildMarginFromCenter](get-child-margin-from-center.html) | [androidJvm]<br>open fun [getChildMarginFromCenter](get-child-margin-from-center.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), numControls: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getControlIconWidth](get-control-icon-width.html) | [androidJvm]<br>fun [getControlIconWidth](get-control-icon-width.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getDisplayedAdapter](get-displayed-adapter.html) | [androidJvm]<br>open fun [getDisplayedAdapter](get-displayed-adapter.html)(): [ObjectAdapter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/ObjectAdapter.html)?<br>Returns the adapter currently bound to the displayed controls. May be overridden in a subclass. |
| [getFacet](../../-m-l-s-playback-transport-row-presenter/-v-h/index.html#-482893815%2FFunctions%2F-1202460562) | [androidJvm]<br>override fun [getFacet](../../-m-l-s-playback-transport-row-presenter/-v-h/index.html#-482893815%2FFunctions%2F-1202460562)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? |
| [setFacet](../../-m-l-s-playback-transport-row-presenter/-v-h/index.html#1162492555%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setFacet](../../-m-l-s-playback-transport-row-presenter/-v-h/index.html#1162492555%2FFunctions%2F-1202460562)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;, p1: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)) |
| [showControls](show-controls.html) | [androidJvm]<br>fun [showControls](show-controls.html)(presenter: [Presenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.html)?) |


## Properties


| Name | Summary |
|---|---|
| [adapter](adapter.html) | [androidJvm]<br>var [adapter](adapter.html): [ObjectAdapter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/ObjectAdapter.html)? |
| [controlBar](control-bar.html) | [androidJvm]<br>val [controlBar](control-bar.html): [MLSControlBar](../../../tv.mycujoo.mclsplayer.tv.widget/-m-l-s-control-bar/index.html) |
| [data](data.html) | [androidJvm]<br>var [data](data.html): [MLSControlBarPresenter.BoundData](../-bound-data/index.html)? |
| [dataObserver](data-observer.html) | [androidJvm]<br>val [dataObserver](data-observer.html): [ObjectAdapter.DataObserver](https://developer.android.com/reference/kotlin/androidx/leanback/widget/ObjectAdapter.DataObserver.html) |
| [presenter](presenter.html) | [androidJvm]<br>var [presenter](presenter.html): [Presenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.html)? |
| [view](../../-m-l-s-playback-transport-row-presenter/-v-h/index.html#1384866063%2FProperties%2F-1202460562) | [androidJvm]<br>val [view](../../-m-l-s-playback-transport-row-presenter/-v-h/index.html#1384866063%2FProperties%2F-1202460562): [View](https://developer.android.com/reference/kotlin/android/view/View.html) |

