//[mcls-cast](../../../index.md)/[tv.mycujoo.mclscast.manager](../index.md)/[CastListenerManager](index.md)

# CastListenerManager

[androidJvm]\
interface [CastListenerManager](index.md)

## Functions

| Name | Summary |
|---|---|
| [addCastListener](add-cast-listener.md) | [androidJvm]<br>abstract fun [addCastListener](add-cast-listener.md)(castApplicationListener: [CastApplicationListener](../-cast-application-listener/index.md))<br>abstract fun [addCastListener](add-cast-listener.md)(castSessionListener: [CastSessionListener](../-cast-session-listener/index.md)) |
| [getListeners](get-listeners.md) | [androidJvm]<br>abstract fun [getListeners](get-listeners.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[CastSessionListener](../-cast-session-listener/index.md)&gt; |
| [removeCastListener](remove-cast-listener.md) | [androidJvm]<br>abstract fun [removeCastListener](remove-cast-listener.md)(castApplicationListener: [CastApplicationListener](../-cast-application-listener/index.md))<br>abstract fun [removeCastListener](remove-cast-listener.md)(castSessionListener: [CastSessionListener](../-cast-session-listener/index.md)) |

## Inheritors

| Name |
|---|
| [CastListenerManagerImpl](../-cast-listener-manager-impl/index.md) |
