---
title: CastPlayerConfig
---
//[mcls-cast](../../../index.html)/[tv.mycujoo.mclscast.config](../index.html)/[CastPlayerConfig](index.html)



# CastPlayerConfig



[androidJvm]\
data class [CastPlayerConfig](index.html)(val primaryColor: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val secondaryColor: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val autoPlay: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val enableControls: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showPlayPauseButtons: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showBackForwardsButtons: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showSeekBar: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showTimers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showFullScreenButton: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showLiveViewers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val showEventInfoButton: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))



## Constructors


| | |
|---|---|
| [CastPlayerConfig](-cast-player-config.html) | [androidJvm]<br>constructor(primaryColor: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), secondaryColor: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), autoPlay: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), enableControls: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showPlayPauseButtons: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showBackForwardsButtons: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showSeekBar: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showTimers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showFullScreenButton: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showLiveViewers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), showEventInfoButton: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |


## Types


| Name | Summary |
|---|---|
| [Companion](-companion/index.html) | [androidJvm]<br>object [Companion](-companion/index.html) |


## Functions


| Name | Summary |
|---|---|
| [copy](copy.html) | [androidJvm]<br>fun [copy](copy.html)(primaryColor: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, secondaryColor: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, autoPlay: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, enableControls: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showPlayPauseButtons: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showBackForwardsButtons: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showSeekBar: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showTimers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showFullScreenButton: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showLiveViewers: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, showEventInfoButton: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null): [CastPlayerConfig](index.html) |


## Properties


| Name | Summary |
|---|---|
| [autoPlay](auto-play.html) | [androidJvm]<br>val [autoPlay](auto-play.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>determines whether a video stream should start playing immediately after it is loaded into the VideoPlayer, or if it should wait for the user to press play. |
| [enableControls](enable-controls.html) | [androidJvm]<br>val [enableControls](enable-controls.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the set of controls buttons should be shown (true) or hidden (false). This will over-ride other properties. |
| [primaryColor](primary-color.html) | [androidJvm]<br>val [primaryColor](primary-color.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>determines the color of various visual elements within the video player, e.g. the color of the controls. This should be a hexadecimal color code (e.g. #FFFFFF) |
| [secondaryColor](secondary-color.html) | [androidJvm]<br>val [secondaryColor](secondary-color.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>will be used in the future to determine the color of various visual elements, but is not used yet. This should be a hexadecimal color code (e.g. #000000) |
| [showBackForwardsButtons](show-back-forwards-buttons.html) | [androidJvm]<br>val [showBackForwardsButtons](show-back-forwards-buttons.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the 10s backwards/forwards buttons should be shown (true) or hidden (false). |
| [showEventInfoButton](show-event-info-button.html) | [androidJvm]<br>val [showEventInfoButton](show-event-info-button.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the &quot;info&quot; button in the top-right corner of the video player should be shown (true) or hidden (false). |
| [showFullScreenButton](show-full-screen-button.html) | [androidJvm]<br>val [showFullScreenButton](show-full-screen-button.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the full-screen button should be shown (true) or hidden (false). |
| [showLiveViewers](show-live-viewers.html) | [androidJvm]<br>val [showLiveViewers](show-live-viewers.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the number of concurrent viewers on a live stream should be shown (true) or hidden (false). |
| [showPlayPauseButtons](show-play-pause-buttons.html) | [androidJvm]<br>val [showPlayPauseButtons](show-play-pause-buttons.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the play/pause buttons should be shown (true) or hidden (false). |
| [showSeekBar](show-seek-bar.html) | [androidJvm]<br>val [showSeekBar](show-seek-bar.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the seek-bar should be shown (true) or hidden (false). |
| [showTimers](show-timers.html) | [androidJvm]<br>val [showTimers](show-timers.html): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Indicates whether the timers (elapsed timer & total timer) should be shown (true) or hidden (false). |

