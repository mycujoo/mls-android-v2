---
title: Builder
---
//[mcls-network](../../../../index.html)/[tv.mycujoo.mclsnetwork](../../index.html)/[MCLSNetwork](../index.html)/[Builder](index.html)



# Builder



[androidJvm]\
class [Builder](index.html)



## Constructors


| | |
|---|---|
| [Builder](-builder.html) | [androidJvm]<br>constructor() |


## Functions


| Name | Summary |
|---|---|
| [build](build.html) | [androidJvm]<br>fun [build](build.html)(): [MCLSNetwork](../index.html) |
| [withContext](with-context.html) | [androidJvm]<br>fun [withContext](with-context.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [MCLSNetwork.Builder](index.html) |
| [withIdentityToken](with-identity-token.html) | [androidJvm]<br>fun [withIdentityToken](with-identity-token.html)(identityToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MCLSNetwork.Builder](index.html) |
| [withLogLevel](with-log-level.html) | [androidJvm]<br>fun [withLogLevel](with-log-level.html)(logLevel: LogLevel): [MCLSNetwork.Builder](index.html) |
| [withPublicKey](with-public-key.html) | [androidJvm]<br>fun [withPublicKey](with-public-key.html)(publicKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MCLSNetwork.Builder](index.html) |


## Properties


| Name | Summary |
|---|---|
| [bffrtSocket](bffrt-socket.html) | [androidJvm]<br>@Inject<br>lateinit var [bffrtSocket](bffrt-socket.html): [IBFFRTSocket](../../../tv.mycujoo.mclsnetwork.network.socket/-i-b-f-f-r-t-socket/index.html) |
| [dataManager](data-manager.html) | [androidJvm]<br>@Inject<br>lateinit var [dataManager](data-manager.html): [IDataManager](../../../tv.mycujoo.mclsnetwork.data/-i-data-manager/index.html) |
| [identityTokenKeyStore](identity-token-key-store.html) | [androidJvm]<br>@Inject<br>lateinit var [identityTokenKeyStore](identity-token-key-store.html): [KeyStore](../../../tv.mycujoo.mclsnetwork.util/-key-store/index.html) |
| [logger](logger.html) | [androidJvm]<br>@Inject<br>lateinit var [logger](logger.html): Logger |
| [publicKeyKeyStore](public-key-key-store.html) | [androidJvm]<br>@Inject<br>lateinit var [publicKeyKeyStore](public-key-key-store.html): [KeyStore](../../../tv.mycujoo.mclsnetwork.util/-key-store/index.html) |
| [reactorSocket](reactor-socket.html) | [androidJvm]<br>@Inject<br>lateinit var [reactorSocket](reactor-socket.html): [IReactorSocket](../../../tv.mycujoo.mclsnetwork.network.socket/-i-reactor-socket/index.html) |

