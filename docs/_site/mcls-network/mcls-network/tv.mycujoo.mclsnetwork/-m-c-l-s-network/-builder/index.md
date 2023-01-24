//[mcls-network](../../../../index.md)/[tv.mycujoo.mclsnetwork](../../index.md)/[MCLSNetwork](../index.md)/[Builder](index.md)

# Builder

[androidJvm]\
class [Builder](index.md)

## Constructors

| | |
|---|---|
| [Builder](-builder.md) | [androidJvm]<br>fun [Builder](-builder.md)() |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [androidJvm]<br>fun [build](build.md)(): [MCLSNetwork](../index.md) |
| [withContext](with-context.md) | [androidJvm]<br>fun [withContext](with-context.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [MCLSNetwork.Builder](index.md) |
| [withIdentityToken](with-identity-token.md) | [androidJvm]<br>fun [withIdentityToken](with-identity-token.md)(identityToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MCLSNetwork.Builder](index.md) |
| [withLogLevel](with-log-level.md) | [androidJvm]<br>fun [withLogLevel](with-log-level.md)(logLevel: LogLevel): [MCLSNetwork.Builder](index.md) |
| [withPublicKey](with-public-key.md) | [androidJvm]<br>fun [withPublicKey](with-public-key.md)(publicKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MCLSNetwork.Builder](index.md) |

## Properties

| Name | Summary |
|---|---|
| [bffrtSocket](bffrt-socket.md) | [androidJvm]<br>@Inject<br>lateinit var [bffrtSocket](bffrt-socket.md): [IBFFRTSocket](../../../tv.mycujoo.mclsnetwork.network.socket/-i-b-f-f-r-t-socket/index.md) |
| [dataManager](data-manager.md) | [androidJvm]<br>@Inject<br>lateinit var [dataManager](data-manager.md): [IDataManager](../../../tv.mycujoo.mclsnetwork.data/-i-data-manager/index.md) |
| [logger](logger.md) | [androidJvm]<br>@Inject<br>lateinit var [logger](logger.md): Logger |
| [prefManager](pref-manager.md) | [androidJvm]<br>@Inject<br>lateinit var [prefManager](pref-manager.md): [IPrefManager](../../../tv.mycujoo.mclsnetwork.manager/-i-pref-manager/index.md) |
| [reactorSocket](reactor-socket.md) | [androidJvm]<br>@Inject<br>lateinit var [reactorSocket](reactor-socket.md): [IReactorSocket](../../../tv.mycujoo.mclsnetwork.network.socket/-i-reactor-socket/index.md) |
