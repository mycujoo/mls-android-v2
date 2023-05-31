---
title: MCLSPlaybackTransportControlGlueImpl
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.transport](../index.html)/[MCLSPlaybackTransportControlGlueImpl](index.html)



# MCLSPlaybackTransportControlGlueImpl



[androidJvm]\
class [MCLSPlaybackTransportControlGlueImpl](index.html)&lt;[AdapterT](index.html) : [PlayerAdapter](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlayerAdapter.html)&gt;(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), impl: [AdapterT](index.html), config: [MCLSTVConfiguration](../../tv.mycujoo.mclsplayer.tv.config/-m-c-l-s-t-v-configuration/index.html), controllerAgent: [ControllerAgent](../../tv.mycujoo.mclsplayer.tv.controller/-controller-agent/index.html)) : [MLSPlaybackBaseControlGlue](../-m-l-s-playback-base-control-glue/index.html)&lt;[AdapterT](index.html)&gt;



## Constructors


| | |
|---|---|
| [MCLSPlaybackTransportControlGlueImpl](-m-c-l-s-playback-transport-control-glue-impl.html) | [androidJvm]<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), impl: [AdapterT](index.html), config: [MCLSTVConfiguration](../../tv.mycujoo.mclsplayer.tv.config/-m-c-l-s-t-v-configuration/index.html), controllerAgent: [ControllerAgent](../../tv.mycujoo.mclsplayer.tv.controller/-controller-agent/index.html)) |


## Types


| Name | Summary |
|---|---|
| [Companion](-companion/index.html) | [androidJvm]<br>object [Companion](-companion/index.html) |
| [SeekUiClient](-seek-ui-client/index.html) | [androidJvm]<br>inner class [SeekUiClient](-seek-ui-client/index.html) : [PlaybackSeekUi.Client](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackSeekUi.Client.html) |
| [UpdatePlaybackStateHandler](-update-playback-state-handler/index.html) | [androidJvm]<br>inner class [UpdatePlaybackStateHandler](-update-playback-state-handler/index.html)&lt;[AdapterT](-update-playback-state-handler/index.html) : [PlayerAdapter](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlayerAdapter.html)&gt;(looper: [Looper](https://developer.android.com/reference/kotlin/android/os/Looper.html)) : [Handler](https://developer.android.com/reference/kotlin/android/os/Handler.html) |


## Functions


| Name | Summary |
|---|---|
| [addPlayerCallback](../-m-l-s-playback-base-control-glue/index.html#-1827286474%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [addPlayerCallback](../-m-l-s-playback-base-control-glue/index.html#-1827286474%2FFunctions%2F-1202460562)(p0: [PlaybackGlue.PlayerCallback](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlaybackGlue.PlayerCallback.html)) |
| [fastForward](../-m-l-s-playback-base-control-glue/fast-forward.html) | [androidJvm]<br>fun [fastForward](../-m-l-s-playback-base-control-glue/fast-forward.html)() |
| [getBufferedPosition](../-m-l-s-playback-base-control-glue/get-buffered-position.html) | [androidJvm]<br>fun [getBufferedPosition](../-m-l-s-playback-base-control-glue/get-buffered-position.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [getContext](../-m-l-s-playback-base-control-glue/index.html#-471726228%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [getContext](../-m-l-s-playback-base-control-glue/index.html#-471726228%2FFunctions%2F-1202460562)(): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html) |
| [getControlsRow](../-m-l-s-playback-base-control-glue/get-controls-row.html) | [androidJvm]<br>fun [getControlsRow](../-m-l-s-playback-base-control-glue/get-controls-row.html)(): [PlaybackControlsRow](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackControlsRow.html)?<br>Returns the playback controls row managed by the glue layer. |
| [getHost](../-m-l-s-playback-base-control-glue/index.html#217478487%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [getHost](../-m-l-s-playback-base-control-glue/index.html#217478487%2FFunctions%2F-1202460562)(): [PlaybackGlueHost](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlaybackGlueHost.html) |
| [getPlayerAdapter](../-m-l-s-playback-base-control-glue/get-player-adapter.html) | [androidJvm]<br>fun [getPlayerAdapter](../-m-l-s-playback-base-control-glue/get-player-adapter.html)(): [AdapterT](index.html) |
| [getSeekProvider](get-seek-provider.html) | [androidJvm]<br>fun [getSeekProvider](get-seek-provider.html)(): [PlaybackSeekDataProvider](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackSeekDataProvider.html)?<br>Get seek data provider used during user seeking. |
| [getSubtitle](../-m-l-s-playback-base-control-glue/get-subtitle.html) | [androidJvm]<br>fun [getSubtitle](../-m-l-s-playback-base-control-glue/get-subtitle.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Return The media subtitle. |
| [getSupportedActions](../-m-l-s-playback-base-control-glue/get-supported-actions.html) | [androidJvm]<br>fun [getSupportedActions](../-m-l-s-playback-base-control-glue/get-supported-actions.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Returns a bitmask of actions supported by the media player. |
| [getTitle](../-m-l-s-playback-base-control-glue/get-title.html) | [androidJvm]<br>fun [getTitle](../-m-l-s-playback-base-control-glue/get-title.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?<br>Returns the title of the media item. |
| [isControlsOverlayAutoHideEnabled](../-m-l-s-playback-base-control-glue/is-controls-overlay-auto-hide-enabled.html) | [androidJvm]<br>fun [isControlsOverlayAutoHideEnabled](../-m-l-s-playback-base-control-glue/is-controls-overlay-auto-hide-enabled.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Returns true if the controls auto hides after a timeout when media is playing. |
| [isPlaying](../-m-l-s-playback-base-control-glue/is-playing.html) | [androidJvm]<br>open override fun [isPlaying](../-m-l-s-playback-base-control-glue/is-playing.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isPrepared](../-m-l-s-playback-base-control-glue/is-prepared.html) | [androidJvm]<br>open override fun [isPrepared](../-m-l-s-playback-base-control-glue/is-prepared.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isSeekEnabled](is-seek-enabled.html) | [androidJvm]<br>fun [isSeekEnabled](is-seek-enabled.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [next](../-m-l-s-playback-base-control-glue/next.html) | [androidJvm]<br>open operator override fun [next](../-m-l-s-playback-base-control-glue/next.html)() |
| [onActionClicked](on-action-clicked.html) | [androidJvm]<br>open override fun [onActionClicked](on-action-clicked.html)(action: [Action](https://developer.android.com/reference/kotlin/androidx/leanback/widget/Action.html)) |
| [onKey](on-key.html) | [androidJvm]<br>open override fun [onKey](on-key.html)(v: [View](https://developer.android.com/reference/kotlin/android/view/View.html)?, keyCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), event: [KeyEvent](https://developer.android.com/reference/kotlin/android/view/KeyEvent.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Handles key events and returns true if handled.  A subclass may override this to provide additional support. |
| [onPreparedStateChanged](../-m-l-s-playback-base-control-glue/on-prepared-state-changed.html) | [androidJvm]<br>@[CallSuper](https://developer.android.com/reference/kotlin/androidx/annotation/CallSuper.html)<br>fun [onPreparedStateChanged](../-m-l-s-playback-base-control-glue/on-prepared-state-changed.html)()<br>Event when ready state for play changes. |
| [onUpdatePlaybackState](on-update-playback-state.html) | [androidJvm]<br>fun [onUpdatePlaybackState](on-update-playback-state.html)() |
| [pause](../-m-l-s-playback-base-control-glue/pause.html) | [androidJvm]<br>open override fun [pause](../-m-l-s-playback-base-control-glue/pause.html)() |
| [play](../-m-l-s-playback-base-control-glue/play.html) | [androidJvm]<br>open override fun [play](../-m-l-s-playback-base-control-glue/play.html)() |
| [playWhenPrepared](../-m-l-s-playback-base-control-glue/index.html#1882635322%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [playWhenPrepared](../-m-l-s-playback-base-control-glue/index.html#1882635322%2FFunctions%2F-1202460562)() |
| [previous](../-m-l-s-playback-base-control-glue/previous.html) | [androidJvm]<br>open override fun [previous](../-m-l-s-playback-base-control-glue/previous.html)() |
| [removePlayerCallback](../-m-l-s-playback-base-control-glue/index.html#-2128890551%2FFunctions%2F-1202460562) | [androidJvm]<br>open fun [removePlayerCallback](../-m-l-s-playback-base-control-glue/index.html#-2128890551%2FFunctions%2F-1202460562)(p0: [PlaybackGlue.PlayerCallback](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlaybackGlue.PlayerCallback.html)) |
| [rewind](../-m-l-s-playback-base-control-glue/rewind.html) | [androidJvm]<br>fun [rewind](../-m-l-s-playback-base-control-glue/rewind.html)() |
| [seekTo](../-m-l-s-playback-base-control-glue/seek-to.html) | [androidJvm]<br>fun [seekTo](../-m-l-s-playback-base-control-glue/seek-to.html)(position: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))<br>Seek media to a new position. |
| [setArt](../-m-l-s-playback-base-control-glue/set-art.html) | [androidJvm]<br>fun [setArt](../-m-l-s-playback-base-control-glue/set-art.html)(cover: [Drawable](https://developer.android.com/reference/kotlin/android/graphics/drawable/Drawable.html))<br>Sets the drawable representing cover image. The drawable will be rendered by default description presenter in {@link androidx.leanback.widget.PlaybackTransportRowPresenter#setDescriptionPresenter(Presenter)}. |
| [setControlsOverlayAutoHideEnabled](../-m-l-s-playback-base-control-glue/set-controls-overlay-auto-hide-enabled.html) | [androidJvm]<br>fun [setControlsOverlayAutoHideEnabled](../-m-l-s-playback-base-control-glue/set-controls-overlay-auto-hide-enabled.html)(enable: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Sets the controls to auto hide after a timeout when media is playing. |
| [setControlsRow](set-controls-row.html) | [androidJvm]<br>open override fun [setControlsRow](set-controls-row.html)(controlsRow: [PlaybackControlsRow](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackControlsRow.html))<br>Sets the controls row to be managed by the glue layer. If {@link PlaybackControlsRow#getPrimaryActionsAdapter()} is not provided, a default {@link ArrayObjectAdapter} will be created and initialized in {@link #onCreatePrimaryActions(ArrayObjectAdapter)}. If {@link PlaybackControlsRow#getSecondaryActionsAdapter()} is not provided, a default {@link ArrayObjectAdapter} will be created and initialized in {@link #onCreateSecondaryActions(ArrayObjectAdapter)}. The primary actions and playback state related aspects of the row are updated by the glue. |
| [setHost](../-m-l-s-playback-base-control-glue/index.html#-165851475%2FFunctions%2F-1202460562) | [androidJvm]<br>fun [setHost](../-m-l-s-playback-base-control-glue/index.html#-165851475%2FFunctions%2F-1202460562)(p0: [PlaybackGlueHost](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlaybackGlueHost.html)) |
| [setSeekEnabled](set-seek-enabled.html) | [androidJvm]<br>fun [setSeekEnabled](set-seek-enabled.html)(seekEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Enable or disable seek when .getSeekProvider is null. When true, [PlayerAdapter.seekTo](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlayerAdapter.html#seekto) will be called during user seeking. |
| [setSeekProvider](set-seek-provider.html) | [androidJvm]<br>fun [setSeekProvider](set-seek-provider.html)(seekProvider: [PlaybackSeekDataProvider](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackSeekDataProvider.html))<br>Set seek data provider used during user seeking. |
| [setSubtitle](../-m-l-s-playback-base-control-glue/set-subtitle.html) | [androidJvm]<br>fun [setSubtitle](../-m-l-s-playback-base-control-glue/set-subtitle.html)(subtitle: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Sets the media subtitle. The subtitle will be rendered by default description presenter {@link androidx.leanback.widget.PlaybackTransportRowPresenter#setDescriptionPresenter(Presenter)}. |
| [setTitle](../-m-l-s-playback-base-control-glue/set-title.html) | [androidJvm]<br>fun [setTitle](../-m-l-s-playback-base-control-glue/set-title.html)(title: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Sets the media title. The title will be rendered by default description presenter {@link androidx.leanback.widget.PlaybackTransportRowPresenter#setDescriptionPresenter(Presenter)}}. |


## Properties


| Name | Summary |
|---|---|
| [config](../-m-l-s-playback-base-control-glue/config.html) | [androidJvm]<br>val [config](../-m-l-s-playback-base-control-glue/config.html): [MCLSTVConfiguration](../../tv.mycujoo.mclsplayer.tv.config/-m-c-l-s-t-v-configuration/index.html) |
| [controllerAgent](../-m-l-s-playback-base-control-glue/controller-agent.html) | [androidJvm]<br>val [controllerAgent](../-m-l-s-playback-base-control-glue/controller-agent.html): [ControllerAgent](../../tv.mycujoo.mclsplayer.tv.controller/-controller-agent/index.html) |
| [mControlsRow](../-m-l-s-playback-base-control-glue/m-controls-row.html) | [androidJvm]<br>var [mControlsRow](../-m-l-s-playback-base-control-glue/m-controls-row.html): [PlaybackControlsRow](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackControlsRow.html)? |
| [mFadeWhenPlaying](../-m-l-s-playback-base-control-glue/m-fade-when-playing.html) | [androidJvm]<br>var [mFadeWhenPlaying](../-m-l-s-playback-base-control-glue/m-fade-when-playing.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [mFastForwardAction](../-m-l-s-playback-base-control-glue/m-fast-forward-action.html) | [androidJvm]<br>lateinit var [mFastForwardAction](../-m-l-s-playback-base-control-glue/m-fast-forward-action.html): [MLSFastForwardAction](../../tv.mycujoo.mclsplayer.tv.widget/-m-l-s-fast-forward-action/index.html) |
| [mIsPlaying](../-m-l-s-playback-base-control-glue/m-is-playing.html) | [androidJvm]<br>var [mIsPlaying](../-m-l-s-playback-base-control-glue/m-is-playing.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [mPlayerAdapter](../-m-l-s-playback-base-control-glue/m-player-adapter.html) | [androidJvm]<br>val [mPlayerAdapter](../-m-l-s-playback-base-control-glue/m-player-adapter.html): [AdapterT](index.html) |
| [mPlayPauseAction](../-m-l-s-playback-base-control-glue/m-play-pause-action.html) | [androidJvm]<br>lateinit var [mPlayPauseAction](../-m-l-s-playback-base-control-glue/m-play-pause-action.html): [MLSPlayPauseAction](../../tv.mycujoo.mclsplayer.tv.widget/-m-l-s-play-pause-action/index.html) |
| [mRewindAction](../-m-l-s-playback-base-control-glue/m-rewind-action.html) | [androidJvm]<br>lateinit var [mRewindAction](../-m-l-s-playback-base-control-glue/m-rewind-action.html): [MLSRewindAction](../../tv.mycujoo.mclsplayer.tv.widget/-m-l-s-rewind-action/index.html) |
| [mSeekEnabled](m-seek-enabled.html) | [androidJvm]<br>var [mSeekEnabled](m-seek-enabled.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [mSeekProvider](m-seek-provider.html) | [androidJvm]<br>var [mSeekProvider](m-seek-provider.html): [PlaybackSeekDataProvider](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackSeekDataProvider.html)? |

