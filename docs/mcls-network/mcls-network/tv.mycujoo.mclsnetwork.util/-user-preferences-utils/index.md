---
title: UserPreferencesUtils
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.util](../index.html)/[UserPreferencesUtils](index.html)



# UserPreferencesUtils



[androidJvm]\
class [UserPreferencesUtils](index.html)@Injectconstructor(val prefManager: [IPrefManager](../../tv.mycujoo.mclsnetwork.manager/-i-pref-manager/index.html))



## Constructors


| | |
|---|---|
| [UserPreferencesUtils](-user-preferences-utils.html) | [androidJvm]<br>@Inject<br>fun [UserPreferencesUtils](-user-preferences-utils.html)(prefManager: [IPrefManager](../../tv.mycujoo.mclsnetwork.manager/-i-pref-manager/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [getIdentityToken](get-identity-token.html) | [androidJvm]<br>fun [getIdentityToken](get-identity-token.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [getPseudoUserId](get-pseudo-user-id.html) | [androidJvm]<br>fun [getPseudoUserId](get-pseudo-user-id.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Generate Pseudo User Id when not persisted, and persist one if  not exist |
| [setPseudoUserId](set-pseudo-user-id.html) | [androidJvm]<br>fun [setPseudoUserId](set-pseudo-user-id.html)(pseudoUserId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |


## Properties


| Name | Summary |
|---|---|
| [prefManager](pref-manager.html) | [androidJvm]<br>val [prefManager](pref-manager.html): [IPrefManager](../../tv.mycujoo.mclsnetwork.manager/-i-pref-manager/index.html) |

