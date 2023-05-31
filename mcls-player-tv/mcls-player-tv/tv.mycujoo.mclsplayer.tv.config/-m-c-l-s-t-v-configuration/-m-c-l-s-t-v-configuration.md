---
title: MCLSTVConfiguration
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.config](../index.html)/[MCLSTVConfiguration](index.html)/[MCLSTVConfiguration](-m-c-l-s-t-v-configuration.html)



# MCLSTVConfiguration



[androidJvm]\
constructor(seekTolerance: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = ONE_SECOND_IN_MS, videoPlayerConfig: VideoPlayerConfig = defaultTVVideoPlayerConfig(), logLevel: LogLevel = LogLevel.MINIMAL)



#### Parameters


androidJvm

| | |
|---|---|
| seekTolerance | how much should a Time-line action be seek-able back and forth. Defaults to 1ms. |
| videoPlayerConfig | configs related to video-player itself. i.e. show auto play vs hide |
| logLevel | level of logging that SDK should output. this ranges from MINIMAL to VERBOSE |




