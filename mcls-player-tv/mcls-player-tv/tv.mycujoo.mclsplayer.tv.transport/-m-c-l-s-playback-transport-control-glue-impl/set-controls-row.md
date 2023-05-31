---
title: setControlsRow
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.transport](../index.html)/[MCLSPlaybackTransportControlGlueImpl](index.html)/[setControlsRow](set-controls-row.html)



# setControlsRow



[androidJvm]\
open override fun [setControlsRow](set-controls-row.html)(controlsRow: [PlaybackControlsRow](https://developer.android.com/reference/kotlin/androidx/leanback/widget/PlaybackControlsRow.html))



Sets the controls row to be managed by the glue layer. If {@link PlaybackControlsRow#getPrimaryActionsAdapter()} is not provided, a default {@link ArrayObjectAdapter} will be created and initialized in {@link #onCreatePrimaryActions(ArrayObjectAdapter)}. If {@link PlaybackControlsRow#getSecondaryActionsAdapter()} is not provided, a default {@link ArrayObjectAdapter} will be created and initialized in {@link #onCreateSecondaryActions(ArrayObjectAdapter)}. The primary actions and playback state related aspects of the row are updated by the glue.




