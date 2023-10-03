---
title: Builder
---
//[mcls-network](../../../../index.html)/[tv.mycujoo.mclsnetwork.di](../../index.html)/[MCLSDataComponent](../index.html)/[Builder](index.html)



# Builder



[androidJvm]\
@Component.Builder



interface [Builder](index.html)



## Functions


| Name | Summary |
|---|---|
| [bindContext](bind-context.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindContext](bind-context.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [MCLSDataComponent.Builder](index.html) |
| [bindIdentityToken](bind-identity-token.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindIdentityToken](bind-identity-token.html)(identityToken: [KeyStore](../../../tv.mycujoo.mclsnetwork.util/-key-store/index.html)): [MCLSDataComponent.Builder](index.html) |
| [bindPublicKey](bind-public-key.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindPublicKey](bind-public-key.html)(publicKey: [KeyStore](../../../tv.mycujoo.mclsnetwork.util/-key-store/index.html)): [MCLSDataComponent.Builder](index.html) |
| [create](create.html) | [androidJvm]<br>abstract fun [create](create.html)(): [MCLSDataComponent](../index.html) |

