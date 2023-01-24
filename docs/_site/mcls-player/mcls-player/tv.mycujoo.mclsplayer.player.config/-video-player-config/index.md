//[mcls-player](../../../index.md)/[tv.mycujoo.mclsplayer.player.config](../index.md)/[VideoPlayerConfig](index.md)

# VideoPlayerConfig

[androidJvm]\
data class [VideoPlayerConfig](index.md)(val primaryColor: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val secondaryColor: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val autoPlay: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val enableControls: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showPlayPauseButtons: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showBackForwardsButtons: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showSeekBar: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showTimers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showFullScreenButton: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showLiveViewers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showEventInfoButton: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))

## Constructors

| | |
|---|---|
| [VideoPlayerConfig](-video-player-config.md) | [androidJvm]<br>fun [VideoPlayerConfig](-video-player-config.md)(primaryColor: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), secondaryColor: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), autoPlay: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), enableControls: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showPlayPauseButtons: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showBackForwardsButtons: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showSeekBar: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showTimers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showFullScreenButton: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showLiveViewers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showEventInfoButton: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [copy](copy.md) | [androidJvm]<br>fun [copy](copy.md)(primaryColor: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, secondaryColor: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, autoPlay: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, enableControls: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showPlayPauseButtons: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showBackForwardsButtons: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showSeekBar: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showTimers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showFullScreenButton: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showLiveViewers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showEventInfoButton: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null): [VideoPlayerConfig](index.md) |

## Properties

| Name | Summary |
|---|---|
| [autoPlay](auto-play.md) | [androidJvm]<br>val [autoPlay](auto-play.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>determines whether a video stream should start playing immediately after it is loaded into the VideoPlayer, or if it should wait for the user to press play. |
| [enableControls](enable-controls.md) | [androidJvm]<br>val [enableControls](enable-controls.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the set of controls buttons should be shown (true) or hidden (false). This will over-ride other properties. |
| [primaryColor](primary-color.md) | [androidJvm]<br>val [primaryColor](primary-color.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>determines the color of various visual elements within the video player, e.g. the color of the controls. This should be a hexadecimal color code (e.g. #FFFFFF) |
| [secondaryColor](secondary-color.md) | [androidJvm]<br>val [secondaryColor](secondary-color.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>will be used in the future to determine the color of various visual elements, but is not used yet. This should be a hexadecimal color code (e.g. #000000) |
| [showBackForwardsButtons](show-back-forwards-buttons.md) | [androidJvm]<br>val [showBackForwardsButtons](show-back-forwards-buttons.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the 10s backwards/forwards buttons should be shown (true) or hidden (false). |
| [showEventInfoButton](show-event-info-button.md) | [androidJvm]<br>val [showEventInfoButton](show-event-info-button.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the &quot;info&quot; button in the top-right corner of the video player should be shown (true) or hidden (false). |
| [showFullScreenButton](show-full-screen-button.md) | [androidJvm]<br>val [showFullScreenButton](show-full-screen-button.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the full-screen button should be shown (true) or hidden (false). |
| [showLiveViewers](show-live-viewers.md) | [androidJvm]<br>val [showLiveViewers](show-live-viewers.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the number of concurrent viewers on a live stream should be shown (true) or hidden (false). |
| [showPlayPauseButtons](show-play-pause-buttons.md) | [androidJvm]<br>val [showPlayPauseButtons](show-play-pause-buttons.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the play/pause buttons should be shown (true) or hidden (false). |
| [showSeekBar](show-seek-bar.md) | [androidJvm]<br>val [showSeekBar](show-seek-bar.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the seek-bar should be shown (true) or hidden (false). |
| [showTimers](show-timers.md) | [androidJvm]<br>val [showTimers](show-timers.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the timers (elapsed timer & total timer) should be shown (true) or hidden (false). |
