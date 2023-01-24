---
title: MCLSNetwork
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork](../index.html)/[MCLSNetwork](index.html)



# MCLSNetwork



[androidJvm]\
class [MCLSNetwork](index.html)



## Types


| Name | Summary |
|---|---|
| [Builder](-builder/index.html) | [androidJvm]<br>class [Builder](-builder/index.html) |
| [Companion](-companion/index.html) | [androidJvm]<br>object [Companion](-companion/index.html) |


## Functions


| Name | Summary |
|---|---|
| [getActions](get-actions.html) | [androidJvm]<br>suspend fun [getActions](get-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;&gt; |
| [getEventDetails](get-event-details.html) | [androidJvm]<br>suspend fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), EventEntity&gt; |
| [setIdentityToken](set-identity-token.html) | [androidJvm]<br>fun [setIdentityToken](set-identity-token.html)(identityToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [setPublicKey](set-public-key.html) | [androidJvm]<br>fun [setPublicKey](set-public-key.html)(publicKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |


## Properties


| Name | Summary |
|---|---|
| [bffRtSocket](bff-rt-socket.html) | [androidJvm]<br>val [bffRtSocket](bff-rt-socket.html): [IBFFRTSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-b-f-f-r-t-socket/index.html) |
| [reactorSocket](reactor-socket.html) | [androidJvm]<br>val [reactorSocket](reactor-socket.html): [IReactorSocket](../../tv.mycujoo.mclsnetwork.network.socket/-i-reactor-socket/index.html) |

