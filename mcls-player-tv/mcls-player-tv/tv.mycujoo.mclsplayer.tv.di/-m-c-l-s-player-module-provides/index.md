---
title: MCLSPlayerModuleProvides
---
//[mcls-player-tv](../../../index.html)/[tv.mycujoo.mclsplayer.tv.di](../index.html)/[MCLSPlayerModuleProvides](index.html)



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
| [provideContext](provide-context.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideContext](provide-context.html)(activity: [FragmentActivity](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity.html)): [Context](https://developer.android.com/reference/kotlin/android/content/Context.html) |
| [provideDefaultMediaSourceFactory](provide-default-media-source-factory.html) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [provideDefaultMediaSourceFactory](provide-default-media-source-factory.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): DefaultMediaSourceFactory |
| [provideExoPlayer](provide-exo-player.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideExoPlayer](provide-exo-player.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): ExoPlayer |
| [provideHlsMediaSource](provide-hls-media-source.html) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [provideHlsMediaSource](provide-hls-media-source.html)(okHttpClient: OkHttpClient): HlsMediaSource.Factory |
| [provideLogger](provide-logger.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideLogger](provide-logger.html)(): Logger |
| [provideMediaFactory](provide-media-factory.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideMediaFactory](provide-media-factory.html)(hlsMediaSource: HlsMediaSource.Factory, defaultMediaSourceFactory: DefaultMediaSourceFactory): [MediaFactory](../../tv.mycujoo.mclsplayer.tv.player/-media-factory/index.html) |
| [provideOkHttpClient](provide-ok-http-client.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideOkHttpClient](provide-ok-http-client.html)(): OkHttpClient |

