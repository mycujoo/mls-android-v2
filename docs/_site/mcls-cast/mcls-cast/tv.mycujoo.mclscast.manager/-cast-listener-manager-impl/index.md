//[mcls-cast](../../../index.md)/[tv.mycujoo.mclscast.manager](../index.md)/[CastListenerManagerImpl](index.md)

# CastListenerManagerImpl

[androidJvm]\
@Singleton

class [CastListenerManagerImpl](index.md)@Injectconstructor : [CastListenerManager](../-cast-listener-manager/index.md)

## Constructors

| | |
|---|---|
| [CastListenerManagerImpl](-cast-listener-manager-impl.md) | [androidJvm]<br>@Inject<br>fun [CastListenerManagerImpl](-cast-listener-manager-impl.md)() |

## Functions

| Name | Summary |
|---|---|
| [addCastListener](add-cast-listener.md) | [androidJvm]<br>open override fun [addCastListener](add-cast-listener.md)(castApplicationListener: [CastApplicationListener](../-cast-application-listener/index.md))<br>open override fun [addCastListener](add-cast-listener.md)(castSessionListener: [CastSessionListener](../-cast-session-listener/index.md)) |
| [getListeners](get-listeners.md) | [androidJvm]<br>open override fun [getListeners](get-listeners.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[CastSessionListener](../-cast-session-listener/index.md)&gt; |
| [removeCastListener](remove-cast-listener.md) | [androidJvm]<br>open override fun [removeCastListener](remove-cast-listener.md)(castApplicationListener: [CastApplicationListener](../-cast-application-listener/index.md))<br>open override fun [removeCastListener](remove-cast-listener.md)(castSessionListener: [CastSessionListener](../-cast-session-listener/index.md)) |
