//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork](../index.md)/[MCLSNetwork](index.md)

# MCLSNetwork

[androidJvm]\
class [MCLSNetwork](index.md)

## Types

| Name | Summary |
|---|---|
| [Builder](-builder/index.md) | [androidJvm]<br>class [Builder](-builder/index.md) |
| [Companion](-companion/index.md) | [androidJvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [getActions](get-actions.md) | [androidJvm]<br>suspend fun [getActions](get-actions.md)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;&gt; |
| [getEventDetails](get-event-details.md) | [androidJvm]<br>suspend fun [getEventDetails](get-event-details.md)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), EventEntity&gt; |
| [setIdentityToken](set-identity-token.md) | [androidJvm]<br>fun [setIdentityToken](set-identity-token.md)(identityToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [setPublicKey](set-public-key.md) | [androidJvm]<br>fun [setPublicKey](set-public-key.md)(publicKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [bffRtSocket](bff-rt-socket.md) | [androidJvm]<br>val [bffRtSocket](bff-rt-socket.md): [IBFFRTSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-b-f-f-r-t-socket/index.md) |
| [reactorSocket](reactor-socket.md) | [androidJvm]<br>val [reactorSocket](reactor-socket.md): [IReactorSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-reactor-socket/index.md) |
