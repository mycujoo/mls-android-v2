//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.di](../index.md)/[NetworkModule](index.md)

# NetworkModule

[androidJvm]\
@Module

class [NetworkModule](index.md)

## Constructors

| | |
|---|---|
| [NetworkModule](-network-module.md) | [androidJvm]<br>fun [NetworkModule](-network-module.md)() |

## Functions

| Name | Summary |
|---|---|
| [mlsApiBaseUrl](mls-api-base-url.md) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [mlsApiBaseUrl](mls-api-base-url.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [provideMlsApi](provide-mls-api.md) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [provideMlsApi](provide-mls-api.md)(retrofit: Retrofit): [MlsApi](../../tv.mycujoo.mclsnetwork.network/-mls-api/index.md) |
| [provideMlsApiRetrofit](provide-mls-api-retrofit.md) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideMlsApiRetrofit](provide-mls-api-retrofit.md)(okHttpClient: OkHttpClient, baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Retrofit |
| [provideOkHttp](provide-ok-http.md) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideOkHttp](provide-ok-http.md)(prefManager: [IPrefManager](../../tv.mycujoo.mclsnetwork.manager/-i-pref-manager/index.md), context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): OkHttpClient |
| [publicBaseUrl](public-base-url.md) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [publicBaseUrl](public-base-url.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
