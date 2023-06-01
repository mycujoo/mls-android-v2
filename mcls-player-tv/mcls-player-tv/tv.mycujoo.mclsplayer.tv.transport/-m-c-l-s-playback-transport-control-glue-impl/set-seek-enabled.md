---
title: setSeekEnabled
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.transport](../index.html)/[MCLSPlaybackTransportControlGlueImpl](index.html)/[setSeekEnabled](set-seek-enabled.html)



# setSeekEnabled



[androidJvm]\
fun [setSeekEnabled](set-seek-enabled.html)(seekEnabled: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))



Enable or disable seek when .getSeekProvider is null. When true, [PlayerAdapter.seekTo](https://developer.android.com/reference/kotlin/androidx/leanback/media/PlayerAdapter.html#seekTo-kotlin.Long-) will be called during user seeking.



#### Parameters


androidJvm

| | |
|---|---|
| seekEnabled | True to enable seek, false otherwise |




