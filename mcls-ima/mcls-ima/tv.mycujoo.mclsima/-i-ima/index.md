---
title: IIma
---
//[mcls-ima](../../../index.html)/[tv.mycujoo.mclsima](../index.html)/[IIma](index.html)



# IIma

interface [IIma](index.html)

#### Inheritors


| |
|---|
| [Ima](../-ima/index.html) |


## Functions


| Name | Summary |
|---|---|
| [createMediaSource](create-media-source.html) | [androidJvm]<br>abstract fun [createMediaSource](create-media-source.html)(defaultMediaSourceFactory: DefaultMediaSourceFactory, hlsMediaSource: MediaSource, imaCustomParams: [ImaCustomParams](../-ima-custom-params/index.html)): MediaSource |
| [getAdUnit](get-ad-unit.html) | [androidJvm]<br>abstract fun [getAdUnit](get-ad-unit.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [onDestroy](on-destroy.html) | [androidJvm]<br>abstract fun [onDestroy](on-destroy.html)() |
| [onStop](on-stop.html) | [androidJvm]<br>abstract fun [onStop](on-stop.html)() |
| [prepare](prepare.html) | [androidJvm]<br>abstract fun [prepare](prepare.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), adViewProvider: AdViewProvider, player: Player) |
| [setAdsLoaderProvider](set-ads-loader-provider.html) | [androidJvm]<br>abstract fun [setAdsLoaderProvider](set-ads-loader-provider.html)(defaultMediaSourceFactory: DefaultMediaSourceFactory, styledPlayerView: StyledPlayerView) |

