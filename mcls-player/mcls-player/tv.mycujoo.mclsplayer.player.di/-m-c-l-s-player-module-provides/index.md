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
| [MCLSPlayerModuleProvides](-m-c-l-s-player-module-provides.html) | [androidJvm]<br>constructor() |


## Functions


| Name | Summary |
|---|---|
| [provideDefaultMediaSourceFactory](provide-default-media-source-factory.html) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [provideDefaultMediaSourceFactory](provide-default-media-source-factory.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): DefaultMediaSourceFactory |
| [provideHlsMediaSource](provide-hls-media-source.html) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [provideHlsMediaSource](provide-hls-media-source.html)(okHttpClient: OkHttpClient): HlsMediaSource.Factory |
| [provideLogger](provide-logger.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideLogger](provide-logger.html)(logLevel: LogLevel): Logger |
| [provideMediaFactory](provide-media-factory.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideMediaFactory](provide-media-factory.html)(hlsMediaSource: HlsMediaSource.Factory, defaultMediaSourceFactory: DefaultMediaSourceFactory): [MediaFactory](../../tv.mycujoo.mclsplayer.player.model/-media-factory/index.html) |
| [provideOkHttpClient](provide-ok-http-client.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideOkHttpClient](provide-ok-http-client.html)(publicKey: [KeyStore](../../tv.mycujoo.mclsplayer.player.utils/-key-store/index.html), identityToken: [KeyStore](../../tv.mycujoo.mclsplayer.player.utils/-key-store/index.html)): OkHttpClient |

