//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.util](../index.md)/[UserPreferencesUtils](index.md)

# UserPreferencesUtils

[androidJvm]\
class [UserPreferencesUtils](index.md)@Injectconstructor(val prefManager: [IPrefManager](../../tv.mycujoo.mclsnetwork.manager/-i-pref-manager/index.md))

## Constructors

| | |
|---|---|
| [UserPreferencesUtils](-user-preferences-utils.md) | [androidJvm]<br>@Inject<br>fun [UserPreferencesUtils](-user-preferences-utils.md)(prefManager: [IPrefManager](../../tv.mycujoo.mclsnetwork.manager/-i-pref-manager/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [getIdentityToken](get-identity-token.md) | [androidJvm]<br>fun [getIdentityToken](get-identity-token.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [getPseudoUserId](get-pseudo-user-id.md) | [androidJvm]<br>fun [getPseudoUserId](get-pseudo-user-id.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Generate Pseudo User Id when not persisted, and persist one if  not exist |
| [setPseudoUserId](set-pseudo-user-id.md) | [androidJvm]<br>fun [setPseudoUserId](set-pseudo-user-id.md)(pseudoUserId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [prefManager](pref-manager.md) | [androidJvm]<br>val [prefManager](pref-manager.md): [IPrefManager](../../tv.mycujoo.mclsnetwork.manager/-i-pref-manager/index.md) |
