---
title: Ima
---
//[mcls-ima](../../../index.html)/[tv.mycujoo.mclsima](../index.html)/[Ima](index.html)



# Ima

class [Ima](index.html)(adUnit: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), liveAdUnit: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, paramProvider: () -&gt; [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, listener: [ImaEventListener](../-ima-event-listener/index.html)? = null, debugMode: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, logger: Logger = Logger(LogLevel.VERBOSE)) : [IIma](../-i-ima/index.html)

MLS IMA integration to use Google IMA



#### Parameters


androidJvm

| | |
|---|---|
| adUnit | adUnit which is provided by Google IMA panel |
| liveAdUnit | adUnit for live events, provided by Google IMA panel |
| paramProvider | custom parameter to log through IMA |
| debugMode | debug/release mode the SDK is running. Caused to use debug adUnit |



## Constructors


| | |
|---|---|
| [Ima](-ima.html) | [androidJvm]<br>constructor(builder: ImaAdsLoader.Builder, listener: [ImaEventListener](../-ima-event-listener/index.html), adUnit: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), liveAdUnit: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))constructor(adUnit: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), liveAdUnit: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, paramProvider: () -&gt; [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, listener: [ImaEventListener](../-ima-event-listener/index.html)? = null, debugMode: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, logger: Logger = Logger(LogLevel.VERBOSE)) |


## Types


| Name | Summary |
|---|---|
| [Companion](-companion/index.html) | [androidJvm]<br>object [Companion](-companion/index.html) |


## Functions


| Name | Summary |
|---|---|
| [createMediaSource](create-media-source.html) | [androidJvm]<br>open override fun [createMediaSource](create-media-source.html)(defaultMediaSourceFactory: DefaultMediaSourceFactory, hlsMediaSource: MediaSource, imaCustomParams: [ImaCustomParams](../-ima-custom-params/index.html)): MediaSource<br>Create Media Source when IMA is active. Must be used when IMA integration is active. Exoplayer uses MediaSource to load content. |
| [getAdUnit](get-ad-unit.html) | [androidJvm]<br>open override fun [getAdUnit](get-ad-unit.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>AdUnit to feed Google IMA |
| [onDestroy](on-destroy.html) | [androidJvm]<br>open override fun [onDestroy](on-destroy.html)()<br>Destroy AdsLoader Must be called on app/SDK destroy to release resources |
| [onStop](on-stop.html) | [androidJvm]<br>open override fun [onStop](on-stop.html)()<br>Remove exoplayer from AdsLoader Must be called when hosting app is going to background |
| [prepare](prepare.html) | [androidJvm]<br>open override fun [prepare](prepare.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), adViewProvider: AdViewProvider, player: Player) |
| [setAdsLoaderProvider](set-ads-loader-provider.html) | [androidJvm]<br>open override fun [setAdsLoaderProvider](set-ads-loader-provider.html)(defaultMediaSourceFactory: DefaultMediaSourceFactory, styledPlayerView: StyledPlayerView)<br>Set Ima AdsLoaderProvider to MediaSourceFactory |

