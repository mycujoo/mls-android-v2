---
title: CastListenerManagerImpl
---
//[mcls-cast](../../../index.html)/[tv.mycujoo.mclscast.manager](../index.html)/[CastListenerManagerImpl](index.html)



# CastListenerManagerImpl



[androidJvm]\
@Singleton



class [CastListenerManagerImpl](index.html)@Injectconstructor : [CastListenerManager](../-cast-listener-manager/index.html)



## Constructors


| | |
|---|---|
| [CastListenerManagerImpl](-cast-listener-manager-impl.html) | [androidJvm]<br>@Inject<br>constructor() |


## Functions


| Name | Summary |
|---|---|
| [addCastListener](add-cast-listener.html) | [androidJvm]<br>open override fun [addCastListener](add-cast-listener.html)(castApplicationListener: [CastApplicationListener](../-cast-application-listener/index.html))<br>open override fun [addCastListener](add-cast-listener.html)(castSessionListener: [CastSessionListener](../-cast-session-listener/index.html)) |
| [getListeners](get-listeners.html) | [androidJvm]<br>open override fun [getListeners](get-listeners.html)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[CastSessionListener](../-cast-session-listener/index.html)&gt; |
| [removeCastListener](remove-cast-listener.html) | [androidJvm]<br>open override fun [removeCastListener](remove-cast-listener.html)(castApplicationListener: [CastApplicationListener](../-cast-application-listener/index.html))<br>open override fun [removeCastListener](remove-cast-listener.html)(castSessionListener: [CastSessionListener](../-cast-session-listener/index.html)) |

