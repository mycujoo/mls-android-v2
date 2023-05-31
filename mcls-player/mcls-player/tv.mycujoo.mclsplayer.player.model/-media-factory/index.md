---
title: MediaFactory
---
//[mcls-player](../../../index.html)/[tv.mycujoo.mclsplayer.player.model](../index.html)/[MediaFactory](index.html)



# MediaFactory



[androidJvm]\
class [MediaFactory](index.html)@Injectconstructor(val defaultMediaSourceFactory: DefaultMediaSourceFactory, hlsMediaFactory: HlsMediaSource.Factory, mediaItemBuilder: MediaItem.Builder)



## Constructors


| | |
|---|---|
| [MediaFactory](-media-factory.html) | [androidJvm]<br>@Inject<br>constructor(defaultMediaSourceFactory: DefaultMediaSourceFactory, hlsMediaFactory: HlsMediaSource.Factory, mediaItemBuilder: MediaItem.Builder) |


## Functions


| Name | Summary |
|---|---|
| [createHlsMediaSource](create-hls-media-source.html) | [androidJvm]<br>fun [createHlsMediaSource](create-hls-media-source.html)(mediaItem: MediaItem): MediaSource |
| [createMediaItem](create-media-item.html) | [androidJvm]<br>fun [createMediaItem](create-media-item.html)(uri: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): MediaItem |


## Properties


| Name | Summary |
|---|---|
| [defaultMediaSourceFactory](default-media-source-factory.html) | [androidJvm]<br>val [defaultMediaSourceFactory](default-media-source-factory.html): DefaultMediaSourceFactory |

