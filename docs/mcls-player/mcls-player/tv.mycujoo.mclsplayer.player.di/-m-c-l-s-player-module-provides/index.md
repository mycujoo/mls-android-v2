---
title: MCLSPlayerModuleProvides
---
//[mcls-player](../../../index.html)/[tv.mycujoo.mclsplayer.player.di](../index.html)/[MCLSPlayerModuleProvides](index.html)



# MCLSPlayerModuleProvides



[androidJvm]\
@Module



class [MCLSPlayerModuleProvides](index.html)



## Constructors


| | |
|---|---|
| [MCLSPlayerModuleProvides](-m-c-l-s-player-module-provides.html) | [androidJvm]<br>fun [MCLSPlayerModuleProvides](-m-c-l-s-player-module-provides.html)() |


## Functions


| Name | Summary |
|---|---|
| [provideHlsMediaSource](provide-hls-media-source.html) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [provideHlsMediaSource](provide-hls-media-source.html)(okHttpClient: OkHttpClient): HlsMediaSource.Factory |
| [provideMediaFactory](provide-media-factory.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideMediaFactory](provide-media-factory.html)(hlsMediaSource: HlsMediaSource.Factory): [MediaFactory](../../tv.mycujoo.mclsplayer.player.model/-media-factory/index.html) |
| [provideOkHttpClient](provide-ok-http-client.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideOkHttpClient](provide-ok-http-client.html)(): OkHttpClient |

