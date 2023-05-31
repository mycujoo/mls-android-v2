---
title: createMediaSource
---
//[mcls-ima](../../../index.html)/[tv.mycujoo.mclsima](../index.html)/[Ima](index.html)/[createMediaSource](create-media-source.html)



# createMediaSource



[androidJvm]\
open override fun [createMediaSource](create-media-source.html)(defaultMediaSourceFactory: DefaultMediaSourceFactory, hlsMediaSource: MediaSource, imaCustomParams: [ImaCustomParams](../-ima-custom-params/index.html)): MediaSource



Create Media Source when IMA is active. Must be used when IMA integration is active. Exoplayer uses MediaSource to load content.



#### Return



MediaSource



#### Parameters


androidJvm

| | |
|---|---|
| defaultMediaSourceFactory | default factory for creating MediaSource |
| hlsMediaSource | source for defining MediaSource |
| imaCustomParams | MLS custom parameter for event |




