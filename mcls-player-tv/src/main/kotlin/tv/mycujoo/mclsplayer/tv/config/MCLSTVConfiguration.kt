package tv.mycujoo.mclsplayer.tv.config

import tv.mycujoo.mclscore.Consts.ONE_SECOND_IN_MS
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclsplayercore.config.VideoPlayerConfig

/**
 * configuration for MLS-TV component which set behavioural and visual settings of SDK
 * @param seekTolerance how much should a Time-line action be seek-able back and forth. Defaults to 1ms.
 * @param videoPlayerConfig configs related to video-player itself. i.e. show auto play vs hide
 * @param logLevel level of logging that SDK should output. this ranges from MINIMAL to VERBOSE
 *
 * @see VideoPlayerConfig
 * @see LogLevel
 */
data class MCLSTVConfiguration(
    val seekTolerance: Long = ONE_SECOND_IN_MS,
    val videoPlayerConfig: VideoPlayerConfig = defaultTVVideoPlayerConfig(),
    val logLevel: LogLevel = LogLevel.MINIMAL
)

fun defaultTVVideoPlayerConfig(): VideoPlayerConfig {
    return VideoPlayerConfig(
        primaryColor = "#FFFFFF",
        secondaryColor = "#000000",
        autoPlay = true,
        showBackForwardsButtons = true,
        showSeekBar = true,
        showTimers = true,
        showLiveViewers = true,
        enableControls = true,
        showEventInfoButton = false,
        showFullScreenButton = false,
        showPlayPauseButtons = true
    )
}
