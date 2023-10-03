---
title: NetworkModule
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.di](../index.html)/[NetworkModule](index.html)



# NetworkModule



[androidJvm]\
@Module



class [NetworkModule](index.html)



## Constructors


| | |
|---|---|
| [NetworkModule](-network-module.html) | [androidJvm]<br>constructor() |


## Functions


| Name | Summary |
|---|---|
| [cdaApiBaseUrl](cda-api-base-url.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [cdaApiBaseUrl](cda-api-base-url.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [mlsApiBaseUrl](mls-api-base-url.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [mlsApiBaseUrl](mls-api-base-url.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [provideCdaApi](provide-cda-api.html) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [provideCdaApi](provide-cda-api.html)(retrofit: Retrofit): [CDAApi](../../tv.mycujoo.mclsnetwork.network/-c-d-a-api/index.html) |
| [provideCdaRetrofit](provide-cda-retrofit.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideCdaRetrofit](provide-cda-retrofit.html)(okHttpClient: OkHttpClient, cdaApiUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Retrofit |
| [provideMlsApi](provide-mls-api.html) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [provideMlsApi](provide-mls-api.html)(retrofit: Retrofit): [MlsApi](../../tv.mycujoo.mclsnetwork.network/-mls-api/index.html) |
| [provideMlsApiRetrofit](provide-mls-api-retrofit.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideMlsApiRetrofit](provide-mls-api-retrofit.html)(okHttpClient: OkHttpClient, baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Retrofit |
| [provideOkHttp](provide-ok-http.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideOkHttp](provide-ok-http.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), publicKey: [KeyStore](../../tv.mycujoo.mclsnetwork.util/-key-store/index.html), identityToken: [KeyStore](../../tv.mycujoo.mclsnetwork.util/-key-store/index.html)): OkHttpClient |
| [publicBaseUrl](public-base-url.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [publicBaseUrl](public-base-url.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

