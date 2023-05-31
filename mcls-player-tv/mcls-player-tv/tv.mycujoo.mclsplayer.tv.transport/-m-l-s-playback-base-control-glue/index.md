---
title: MLSPlaybackBaseControlGlue
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.transport](../index.html)/[MLSPlaybackBaseControlGlue](index.html)



# MLSPlaybackBaseControlGlue

abstract class [MLSPlaybackBaseControlGlue](index.html)&lt;[T](index.html) : [PlayerAdapter](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlayerAdapter.html)&gt;(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), val mPlayerAdapter: [T](index.html), val config: [MCLSTVConfiguration](../../tv.mycujoo.mclsplayer.tv.config/-m-c-l-s-t-v-configuration/index.html), val controllerAgent: [ControllerAgent](../../tv.mycujoo.mclsplayer.tv.controller/-controller-agent/index.html)) : [PlaybackGlue](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlaybackGlue.html), [OnActionClickedListener](https://developer.android.com/reference/kotlin/androidx/leanback/widget/OnActionClickedListener.html), [View.OnKeyListener](https://developer.android.com/reference/kotlin/android/view/View.OnKeyListener.html)

#### Inheritors


| |
|---|
| [MCLSPlaybackTransportControlGlueImpl](../-m-c-l-s-playback-transport-control-glue-impl/index.html) |


## Constructors


| | |
|---|---|
| [MLSPlaybackBaseControlGlue](-m-l-s-playback-base-control-glue.html) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), mPlayerAdapter: [T](index.html), config: [MCLSTVConfiguration](../../tv.mycujoo.mclsplayer.tv.config/-m-c-l-s-t-v-configuration/index.html), controllerAgent: [ControllerAgent](../../tv.mycujoo.mclsplayer.tv.controller/-controller-agent/index.html)) |


## Types


| Name | Summary |
|---|---|
| [Companion](-companion/index.html) | [androidJvm]<br>object [Companion](-companion/index.html) |


## Functions


| Name | Summary |
|---|---|
| [addPlayerCallback](index.html#-1827286474%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [addPlayerCallback](index.html#-1827286474%2FFunctions%2F-1202460562)(p0: [PlaybackGlue.PlayerCallback](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlaybackGlue.PlayerCallback.html)) |
| [fastForward](fast-forward.html) | [androidJvm]<br>fun [fastForward](fast-forward.html)() |
| [getBufferedPosition](get-buffered-position.html) | [androidJvm]<br>fun [getBufferedPosition](get-buffered-position.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [getContext](index.html#-471726228%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [getContext](index.html#-471726228%2FFunctions%2F-1202460562)(): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html) |
| [getControlsRow](get-controls-row.html) | [androidJvm]<br>fun [getControlsRow](get-controls-row.html)(): [PlaybackControlsRow](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackControlsRow.html)?<br>Returns the playback controls row managed by the glue layer. |
| [getHost](index.html#217478487%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [getHost](index.html#217478487%2FFunctions%2F-1202460562)(): [PlaybackGlueHost](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlaybackGlueHost.html) |
| [getPlayerAdapter](get-player-adapter.html) | [androidJvm]<br>fun [getPlayerAdapter](get-player-adapter.html)(): [T](index.html) |
| [getSubtitle](get-subtitle.html) | [androidJvm]<br>fun [getSubtitle](get-subtitle.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Return The media subtitle. |
| [getSupportedActions](get-supported-actions.html) | [androidJvm]<br>fun [getSupportedActions](get-supported-actions.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Returns a bitmask of actions supported by the media player. |
| [getTitle](get-title.html) | [androidJvm]<br>fun [getTitle](get-title.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Returns the title of the media item. |
| [isControlsOverlayAutoHideEnabled](is-controls-overlay-auto-hide-enabled.html) | [androidJvm]<br>fun [isControlsOverlayAutoHideEnabled](is-controls-overlay-auto-hide-enabled.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the controls auto hides after a timeout when media is playing. |
| [isPlaying](is-playing.html) | [androidJvm]<br>open override fun [isPlaying](is-playing.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isPrepared](is-prepared.html) | [androidJvm]<br>open override fun [isPrepared](is-prepared.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [next](next.html) | [androidJvm]<br>open operator override fun [next](next.html)() |
| [onActionClicked](on-action-clicked.html) | [androidJvm]<br>abstract override fun [onActionClicked](on-action-clicked.html)(action: [Action](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Action.html)) |
| [onKey](on-key.html) | [androidJvm]<br>abstract override fun [onKey](on-key.html)(v: [View](https://developer.android.com/reference/kotlin/android/view/View.html)?, keyCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), event: [KeyEvent](https://developer.android.com/reference/kotlin/android/view/KeyEvent.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Handles key events and returns true if handled.  A subclass may override this to provide additional support. |
| [onPreparedStateChanged](on-prepared-state-changed.html) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>fun [onPreparedStateChanged](on-prepared-state-changed.html)()<br>Event when ready state for play changes. |
| [pause](pause.html) | [androidJvm]<br>open override fun [pause](pause.html)() |
| [play](play.html) | [androidJvm]<br>open override fun [play](play.html)() |
| [playWhenPrepared](index.html#1882635322%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [playWhenPrepared](index.html#1882635322%2FFunctions%2F-1202460562)() |
| [previous](previous.html) | [androidJvm]<br>open override fun [previous](previous.html)() |
| [removePlayerCallback](index.html#-2128890551%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [removePlayerCallback](index.html#-2128890551%2FFunctions%2F-1202460562)(p0: [PlaybackGlue.PlayerCallback](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlaybackGlue.PlayerCallback.html)) |
| [rewind](rewind.html) | [androidJvm]<br>fun [rewind](rewind.html)() |
| [seekTo](seek-to.html) | [androidJvm]<br>fun [seekTo](seek-to.html)(position: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))<br>Seek media to a new position. |
| [setArt](set-art.html) | [androidJvm]<br>fun [setArt](set-art.html)(cover: [Drawable](https://developer.android.com/reference/kotlin/android/graphics/drawable/Drawable.html))<br>Sets the drawable representing cover image. The drawable will be rendered by default description presenter in {@link androidx.leanback.widget.PlaybackTransportRowPresenter#setDescriptionPresenter(Presenter)}. |
| [setControlsOverlayAutoHideEnabled](set-controls-overlay-auto-hide-enabled.html) | [androidJvm]<br>fun [setControlsOverlayAutoHideEnabled](set-controls-overlay-auto-hide-enabled.html)(enable: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Sets the controls to auto hide after a timeout when media is playing. |
| [setControlsRow](set-controls-row.html) | [androidJvm]<br>open fun [setControlsRow](set-controls-row.html)(controlsRow: [PlaybackControlsRow](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackControlsRow.html))<br>Sets the controls row to be managed by the glue layer. If {@link PlaybackControlsRow#getPrimaryActionsAdapter()} is not provided, a default {@link ArrayObjectAdapter} will be created and initialized in {@link #onCreatePrimaryActions(ArrayObjectAdapter)}. If {@link PlaybackControlsRow#getSecondaryActionsAdapter()} is not provided, a default {@link ArrayObjectAdapter} will be created and initialized in {@link #onCreateSecondaryActions(ArrayObjectAdapter)}. The primary actions and playback state related aspects of the row are updated by the glue. |
| [setHost](index.html#-165851475%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setHost](index.html#-165851475%2FFunctions%2F-1202460562)(p0: [PlaybackGlueHost](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlaybackGlueHost.html)) |
| [setSubtitle](set-subtitle.html) | [androidJvm]<br>fun [setSubtitle](set-subtitle.html)(subtitle: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Sets the media subtitle. The subtitle will be rendered by default description presenter {@link androidx.leanback.widget.PlaybackTransportRowPresenter#setDescriptionPresenter(Presenter)}. |
| [setTitle](set-title.html) | [androidJvm]<br>fun [setTitle](set-title.html)(title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Sets the media title. The title will be rendered by default description presenter {@link androidx.leanback.widget.PlaybackTransportRowPresenter#setDescriptionPresenter(Presenter)}}. |


## Properties


| Name | Summary |
|---|---|
| [config](config.html) | [androidJvm]<br>val [config](config.html): [MCLSTVConfiguration](../../tv.mycujoo.mclsplayer.tv.config/-m-c-l-s-t-v-configuration/index.html) |
| [controllerAgent](controller-agent.html) | [androidJvm]<br>val [controllerAgent](controller-agent.html): [ControllerAgent](../../tv.mycujoo.mclsplayer.tv.controller/-controller-agent/index.html) |
| [mControlsRow](m-controls-row.html) | [androidJvm]<br>var [mControlsRow](m-controls-row.html): [PlaybackControlsRow](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackControlsRow.html)? |
| [mFadeWhenPlaying](m-fade-when-playing.html) | [androidJvm]<br>var [mFadeWhenPlaying](m-fade-when-playing.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [mFastForwardAction](m-fast-forward-action.html) | [androidJvm]<br>lateinit var [mFastForwardAction](m-fast-forward-action.html): [MLSFastForwardAction](../../tv.mycujoo.mclsplayer.tv.widget/-m-l-s-fast-forward-action/index.html) |
| [mIsPlaying](m-is-playing.html) | [androidJvm]<br>var [mIsPlaying](m-is-playing.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [mPlayerAdapter](m-player-adapter.html) | [androidJvm]<br>val [mPlayerAdapter](m-player-adapter.html): [T](index.html) |
| [mPlayPauseAction](m-play-pause-action.html) | [androidJvm]<br>lateinit var [mPlayPauseAction](m-play-pause-action.html): [MLSPlayPauseAction](../../tv.mycujoo.mclsplayer.tv.widget/-m-l-s-play-pause-action/index.html) |
| [mRewindAction](m-rewind-action.html) | [androidJvm]<br>lateinit var [mRewindAction](m-rewind-action.html): [MLSRewindAction](../../tv.mycujoo.mclsplayer.tv.widget/-m-l-s-rewind-action/index.html) |

