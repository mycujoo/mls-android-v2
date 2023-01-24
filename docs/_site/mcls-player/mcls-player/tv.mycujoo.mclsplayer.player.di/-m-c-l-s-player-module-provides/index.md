//[mcls-player](../../../index.md)/[tv.mycujoo.mclsplayer.player.di](../index.md)/[MCLSPlayerModuleProvides](index.md)

# MCLSPlayerModuleProvides

[androidJvm]\
@Module

class [MCLSPlayerModuleProvides](index.md)

## Constructors

| | |
|---|---|
| [MCLSPlayerModuleProvides](-m-c-l-s-player-module-provides.md) | [androidJvm]<br>fun [MCLSPlayerModuleProvides](-m-c-l-s-player-module-provides.md)() |

## Functions

| Name | Summary |
|---|---|
| [provideHlsMediaSource](provide-hls-media-source.md) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [provideHlsMediaSource](provide-hls-media-source.md)(okHttpClient: OkHttpClient): HlsMediaSource.Factory |
| [provideMediaFactory](provide-media-factory.md) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideMediaFactory](provide-media-factory.md)(hlsMediaSource: HlsMediaSource.Factory): [MediaFactory](../../tv.mycujoo.mclsplayer.player.model/-media-factory/index.md) |
| [provideOkHttpClient](provide-ok-http-client.md) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideOkHttpClient](provide-ok-http-client.md)(): OkHttpClient |
