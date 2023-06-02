---
title: VH
---
//[mcls-player-tv](../../../../index.html)/[tv.mycujoo.mclsplayer.tv.presenter](../../index.html)/[MLSPlaybackTransportRowPresenter](../index.html)/[VH](index.html)



# VH

open inner class [VH](index.html)(rootView: [View](https://developer.android.com/reference/kotlin/android/view/View.html), descriptionPresenter: [Presenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.html)?) : [PlaybackRowPresenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackRowPresenter.ViewHolder.html), [PlaybackSeekUi](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackSeekUi.html)

A ViewHolder for the PlaybackControlsRow supporting seek UI.



#### Parameters


androidJvm

| | |
|---|---|
| rootView | Root view of the ViewHolder. |
| descriptionPresenter | The presenter that will be used to create description ViewHolder. The description view will be added into tree. |



## Constructors


| | |
|---|---|
| [VH](-v-h.html) | [androidJvm]<br>constructor(rootView: [View](https://developer.android.com/reference/kotlin/android/view/View.html), descriptionPresenter: [Presenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.html)?) |


## Functions


| Name | Summary |
|---|---|
| [dispatchItemSelection](dispatch-item-selection.html) | [androidJvm]<br>fun [dispatchItemSelection](dispatch-item-selection.html)() |
| [getFacet](index.html#-482893815%2FFunctions%2F-1202460562) | [androidJvm]<br>override fun [getFacet](index.html#-482893815%2FFunctions%2F-1202460562)(p0: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;*&gt;): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? |
| [getHeaderViewHolder](index.html#1855820534%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [getHeaderViewHolder](index.html#1855820534%2FFunctions%2F-1202460562)(): [RowHeaderPresenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/RowHeaderPresenter.ViewHolder.html) |
| [getOnItemViewClickedListener](index.html#-1844789278%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [getOnItemViewClickedListener](index.html#-1844789278%2FFunctions%2F-1202460562)(): [BaseOnItemViewClickedListener](https://developer.android.com/reference/kotlin/androidx/leanback/widget/BaseOnItemViewClickedListener.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |
| [getOnItemViewSelectedListener](index.html#1631582318%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [getOnItemViewSelectedListener](index.html#1631582318%2FFunctions%2F-1202460562)(): [BaseOnItemViewSelectedListener](https://developer.android.com/reference/kotlin/androidx/leanback/widget/BaseOnItemViewSelectedListener.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; |
| [getOnKeyListener](index.html#259321906%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [getOnKeyListener](index.html#259321906%2FFunctions%2F-1202460562)(): [View.OnKeyListener](https://developer.android.com/reference/kotlin/android/view/View.OnKeyListener.html) |
| [getPresenter](get-presenter.html) | [androidJvm]<br>fun [getPresenter](get-presenter.html)(primary: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)): [Presenter](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.html)? |
| [getRow](index.html#1666384172%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [getRow](index.html#1666384172%2FFunctions%2F-1202460562)(): [Row](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Row.html) |
| [getRowObject](index.html#-2101601427%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [getRowObject](index.html#-2101601427%2FFunctions%2F-1202460562)(): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [getSelectedItem](index.html#-525539514%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [getSelectedItem](index.html#-525539514%2FFunctions%2F-1202460562)(): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html) |
| [getSelectedItemViewHolder](index.html#1383083093%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [getSelectedItemViewHolder](index.html#1383083093%2FFunctions%2F-1202460562)(): [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html) |
| [getSelectLevel](index.html#1556691422%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [getSelectLevel](index.html#1556691422%2FFunctions%2F-1202460562)(): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [isExpanded](index.html#-1033760979%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [isExpanded](index.html#-1033760979%2FFunctions%2F-1202460562)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isSelected](index.html#2118830987%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [isSelected](index.html#2118830987%2FFunctions%2F-1202460562)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onBackward](on-backward.html) | [androidJvm]<br>fun [onBackward](on-backward.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onForward](on-forward.html) | [androidJvm]<br>fun [onForward](on-forward.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [setActivated](index.html#-1341674010%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setActivated](index.html#-1341674010%2FFunctions%2F-1202460562)(p0: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [setBufferedPosition](set-buffered-position.html) | [androidJvm]<br>fun [setBufferedPosition](set-buffered-position.html)(progressMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [setCurrentPosition](set-current-position.html) | [androidJvm]<br>fun [setCurrentPosition](set-current-position.html)(currentTimeMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [setFacet](index.html#1162492555%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setFacet](index.html#1162492555%2FFunctions%2F-1202460562)(p0: [Class](https://developer.android.com/reference/kotlin/java/lang/Class.html)&lt;*&gt;, p1: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)) |
| [setOnItemViewClickedListener](index.html#-474307770%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setOnItemViewClickedListener](index.html#-474307770%2FFunctions%2F-1202460562)(p0: [BaseOnItemViewClickedListener](https://developer.android.com/reference/kotlin/androidx/leanback/widget/BaseOnItemViewClickedListener.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;) |
| [setOnItemViewSelectedListener](index.html#-580155368%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setOnItemViewSelectedListener](index.html#-580155368%2FFunctions%2F-1202460562)(p0: [BaseOnItemViewSelectedListener](https://developer.android.com/reference/kotlin/androidx/leanback/widget/BaseOnItemViewSelectedListener.html)&lt;[Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;) |
| [setOnKeyListener](index.html#-1672686097%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [setOnKeyListener](index.html#-1672686097%2FFunctions%2F-1202460562)(p0: [View.OnKeyListener](https://developer.android.com/reference/kotlin/android/view/View.OnKeyListener.html)) |
| [setPlaybackSeekUiClient](set-playback-seek-ui-client.html) | [androidJvm]<br>open override fun [setPlaybackSeekUiClient](set-playback-seek-ui-client.html)(client: [PlaybackSeekUi.Client](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackSeekUi.Client.html)) |
| [setTotalTime](set-total-time.html) | [androidJvm]<br>fun [setTotalTime](set-total-time.html)(totalTimeMs: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [syncActivatedStatus](index.html#1518493873%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [syncActivatedStatus](index.html#1518493873%2FFunctions%2F-1202460562)(p0: [View](https://developer.android.com/reference/kotlin/android/view/View.html)) |


## Properties


| Name | Summary |
|---|---|
| [descriptionViewHolder](description-view-holder.html) | [androidJvm]<br>val [descriptionViewHolder](description-view-holder.html): [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)? |
| [mControlsBoundData](m-controls-bound-data.html) | [androidJvm]<br>var [mControlsBoundData](m-controls-bound-data.html): [MLSPlaybackTransportRowPresenter.BoundData](../-bound-data/index.html) |
| [mControlsDock](m-controls-dock.html) | [androidJvm]<br>val [mControlsDock](m-controls-dock.html): [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html) |
| [mControlsVh](m-controls-vh.html) | [androidJvm]<br>var [mControlsVh](m-controls-vh.html): [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)? |
| [mDescriptionDock](m-description-dock.html) | [androidJvm]<br>val [mDescriptionDock](m-description-dock.html): [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html) |
| [mImageView](m-image-view.html) | [androidJvm]<br>val [mImageView](m-image-view.html): [ImageView](https://developer.android.com/reference/kotlin/android/widget/ImageView.html) |
| [mListener](m-listener.html) | [androidJvm]<br>val [mListener](m-listener.html): [PlaybackControlsRow.OnPlaybackProgressCallback](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackControlsRow.OnPlaybackProgressCallback.html) |
| [mLiveBadgeLayout](m-live-badge-layout.html) | [androidJvm]<br>var [mLiveBadgeLayout](m-live-badge-layout.html): [FrameLayout](https://developer.android.com/reference/kotlin/android/widget/FrameLayout.html) |
| [mPlayPauseAction](m-play-pause-action.html) | [androidJvm]<br>var [mPlayPauseAction](m-play-pause-action.html): [PlaybackControlsRow.PlayPauseAction](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackControlsRow.PlayPauseAction.html)? |
| [mProgressBar](m-progress-bar.html) | [androidJvm]<br>val [mProgressBar](m-progress-bar.html): [MLSSeekBar](../../../tv.mycujoo.mclsplayer.tv.widget/-m-l-s-seek-bar/index.html) |
| [mSecondaryBoundData](m-secondary-bound-data.html) | [androidJvm]<br>var [mSecondaryBoundData](m-secondary-bound-data.html): [MLSPlaybackTransportRowPresenter.BoundData](../-bound-data/index.html) |
| [mSecondaryControlsDock](m-secondary-controls-dock.html) | [androidJvm]<br>val [mSecondaryControlsDock](m-secondary-controls-dock.html): [ViewGroup](https://developer.android.com/reference/kotlin/android/view/ViewGroup.html) |
| [mSecondaryControlsVh](m-secondary-controls-vh.html) | [androidJvm]<br>var [mSecondaryControlsVh](m-secondary-controls-vh.html): [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)? |
| [mSelectedItem](m-selected-item.html) | [androidJvm]<br>var [mSelectedItem](m-selected-item.html): [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)? |
| [mSelectedViewHolder](m-selected-view-holder.html) | [androidJvm]<br>var [mSelectedViewHolder](m-selected-view-holder.html): [Presenter.ViewHolder](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Presenter.ViewHolder.html)? |
| [mThumbHeroIndex](m-thumb-hero-index.html) | [androidJvm]<br>var [mThumbHeroIndex](m-thumb-hero-index.html): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [mThumbsBar](m-thumbs-bar.html) | [androidJvm]<br>val [mThumbsBar](m-thumbs-bar.html): [MLSThumbsBar](../../../tv.mycujoo.mclsplayer.tv.widget/-m-l-s-thumbs-bar/index.html) |
| [view](index.html#1384866063%2FProperties%2F-1202460562) | [androidJvm]<br>val [view](index.html#1384866063%2FProperties%2F-1202460562): [View](https://developer.android.com/reference/kotlin/android/view/View.html) |

