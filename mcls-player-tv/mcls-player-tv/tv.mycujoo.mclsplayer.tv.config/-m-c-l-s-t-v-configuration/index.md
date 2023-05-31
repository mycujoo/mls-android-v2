---
title: MCLSTVConfiguration
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.config](../index.html)/[MCLSTVConfiguration](index.html)



# MCLSTVConfiguration

data class [MCLSTVConfiguration](index.html)(val seekTolerance: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = ONE_SECOND_IN_MS, val videoPlayerConfig: VideoPlayerConfig = defaultTVVideoPlayerConfig(), val logLevel: LogLevel = LogLevel.MINIMAL)

configuration for MLS-TV component which set behavioural and visual settings of SDK



#### Parameters


androidJvm

| | |
|---|---|
| seekTolerance | how much should a Time-line action be seek-able back and forth. Defaults to 1ms. |
| videoPlayerConfig | configs related to video-player itself. i.e. show auto play vs hide |
| logLevel | level of logging that SDK should output. this ranges from MINIMAL to VERBOSE |



#### See also


| |
|---|
| VideoPlayerConfig |
| LogLevel |


## Constructors


| | |
|---|---|
| [MCLSTVConfiguration](-m-c-l-s-t-v-configuration.html) | [androidJvm]<br>constructor(seekTolerance: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = ONE_SECOND_IN_MS, videoPlayerConfig: VideoPlayerConfig = defaultTVVideoPlayerConfig(), logLevel: LogLevel = LogLevel.MINIMAL) |


## Properties


| Name | Summary |
|---|---|
| [logLevel](log-level.html) | [androidJvm]<br>val [logLevel](log-level.html): LogLevel |
| [seekTolerance](seek-tolerance.html) | [androidJvm]<br>val [seekTolerance](seek-tolerance.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [videoPlayerConfig](video-player-config.html) | [androidJvm]<br>val [videoPlayerConfig](video-player-config.html): VideoPlayerConfig |

