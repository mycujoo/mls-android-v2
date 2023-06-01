---
title: MLSControlBarPresenter
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.presenter](../index.html)/[MLSControlBarPresenter](index.html)



# MLSControlBarPresenter

open class [MLSControlBarPresenter](index.html)(@[LayoutRes](https://developer.android.com/reference/kotlin/androidx/annotation/LayoutRes.html)val layoutResId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) : [Presenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.html)

#### Inheritors


| |
|---|
| [MLSPlaybackControlPresenter](../-m-l-s-playback-control-presenter/index.html) |


## Constructors


| | |
|---|---|
| [MLSControlBarPresenter](-m-l-s-control-bar-presenter.html) | [androidJvm]<br>constructor(@[LayoutRes](https://developer.android.com/reference/kotlin/androidx/annotation/LayoutRes.html)layoutResId: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |


## Types


| Name | Summary |
|---|---|
| [BoundData](-bound-data/index.html) | [androidJvm]<br>open class [BoundData](-bound-data/index.html) |
| [Companion](-companion/index.html) | [androidJvm]<br>object [Companion](-companion/index.html) |
| [MCLSControlBarViewHolder](-m-c-l-s-control-bar-view-holder/index.html) | [androidJvm]<br>open inner class [MCLSControlBarViewHolder](-m-c-l-s-control-bar-view-holder/index.html)(rootView: [View](https://developer.android.com/reference/kotlin/android/view/View.html)) : [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html) |
| [OnControlClickedListener](-on-control-clicked-listener/index.html) | [androidJvm]<br>interface [OnControlClickedListener](-on-control-clicked-listener/index.html)<br>Listener for control clicked events. |
| [OnControlSelectedListener](-on-control-selected-listener/index.html) | [androidJvm]<br>interface [OnControlSelectedListener](-on-control-selected-listener/index.html)<br>Listener for control selected events. |


## Functions


| Name | Summary |
|---|---|
| [getFacet](../-m-l-s-playback-transport-row-presenter/index.html#-789590756%2FFunctions%2F-1202460562) | [androidJvm]<br>override fun [getFacet](../-m-l-s-playback-transport-row-presenter/index.html#-789590756%2FFunctions%2F-1202460562)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? |
| [onBindViewHolder](../-m-l-s-playback-transport-row-presenter/index.html#-1615119423%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onBindViewHolder](../-m-l-s-playback-transport-row-presenter/index.html#-1615119423%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html), p1: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html), p2: [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;)<br>open override fun [onBindViewHolder](on-bind-view-holder.html)(viewHolder: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)?, item: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?) |
| [onCreateViewHolder](on-create-view-holder.html) | [androidJvm]<br>open override fun [onCreateViewHolder](on-create-view-holder.html)(parent: [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html)?): [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html) |
| [onUnbindViewHolder](on-unbind-view-holder.html) | [androidJvm]<br>open override fun [onUnbindViewHolder](on-unbind-view-holder.html)(viewHolder: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)?) |
| [onViewAttachedToWindow](../-m-l-s-playback-control-presenter/index.html#-924568759%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onViewAttachedToWindow](../-m-l-s-playback-control-presenter/index.html#-924568759%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)) |
| [onViewDetachedFromWindow](../-m-l-s-playback-control-presenter/index.html#-619108282%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [onViewDetachedFromWindow](../-m-l-s-playback-control-presenter/index.html#-619108282%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)) |
| [setFacet](../-m-l-s-playback-transport-row-presenter/index.html#-523029608%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setFacet](../-m-l-s-playback-transport-row-presenter/index.html#-523029608%2FFunctions%2F-1202460562)(p0: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;*&gt;, p1: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)) |
| [setOnClickListener](../-m-l-s-playback-transport-row-presenter/index.html#1820788726%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [setOnClickListener](../-m-l-s-playback-transport-row-presenter/index.html#1820788726%2FFunctions%2F-1202460562)(p0: [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html), p1: [View.OnClickListener](https://developer.android.com/reference/kotlin/android/view/View.OnClickListener.html)) |


## Properties


| Name | Summary |
|---|---|
| [defaultFocusToMiddle](default-focus-to-middle.html) | [androidJvm]<br>var [defaultFocusToMiddle](default-focus-to-middle.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>True for middle item, false for 0. |
| [layoutResId](layout-res-id.html) | [androidJvm]<br>val [layoutResId](layout-res-id.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onControlClickedListener](on-control-clicked-listener.html) | [androidJvm]<br>var [onControlClickedListener](on-control-clicked-listener.html): [MLSControlBarPresenter.OnControlClickedListener](-on-control-clicked-listener/index.html)? |
| [onControlSelectedListener](on-control-selected-listener.html) | [androidJvm]<br>var [onControlSelectedListener](on-control-selected-listener.html): [MLSControlBarPresenter.OnControlSelectedListener](-on-control-selected-listener/index.html)? |

