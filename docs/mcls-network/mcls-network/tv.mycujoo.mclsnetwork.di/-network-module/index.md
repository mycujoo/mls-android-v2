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
| [NetworkModule](-network-module.html) | [androidJvm]<br>fun [NetworkModule](-network-module.html)() |


## Functions


| Name | Summary |
|---|---|
| [mlsApiBaseUrl](mls-api-base-url.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [mlsApiBaseUrl](mls-api-base-url.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [provideMlsApi](provide-mls-api.html) | [androidJvm]<br>@Singleton<br>@Provides<br>fun [provideMlsApi](provide-mls-api.html)(retrofit: Retrofit): [MlsApi](../../tv.mycujoo.mclsnetwork.network/-mls-api/index.html) |
| [provideMlsApiRetrofit](provide-mls-api-retrofit.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideMlsApiRetrofit](provide-mls-api-retrofit.html)(okHttpClient: OkHttpClient, baseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): Retrofit |
| [provideOkHttp](provide-ok-http.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideOkHttp](provide-ok-http.html)(prefManager: [IPrefManager](../../tv.mycujoo.mclsnetwork.manager/-i-pref-manager/index.html), context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): OkHttpClient |
| [publicBaseUrl](public-base-url.html) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [publicBaseUrl](public-base-url.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

