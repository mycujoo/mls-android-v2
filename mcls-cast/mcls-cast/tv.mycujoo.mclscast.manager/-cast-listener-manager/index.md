---
title: CastListenerManager
---
//[mcls-cast](../../../index.html)/[tv.mycujoo.mclscast.manager](../index.html)/[CastListenerManager](index.html)



# CastListenerManager

interface [CastListenerManager](index.html)

#### Inheritors


| |
|---|
| [CastListenerManagerImpl](../-cast-listener-manager-impl/index.html) |


## Functions


| Name | Summary |
|---|---|
| [addCastListener](add-cast-listener.html) | [androidJvm]<br>abstract fun [addCastListener](add-cast-listener.html)(castApplicationListener: [CastApplicationListener](../-cast-application-listener/index.html))<br>abstract fun [addCastListener](add-cast-listener.html)(castSessionListener: [CastSessionListener](../-cast-session-listener/index.html)) |
| [getListeners](get-listeners.html) | [androidJvm]<br>abstract fun [getListeners](get-listeners.html)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[CastSessionListener](../-cast-session-listener/index.html)&gt; |
| [removeCastListener](remove-cast-listener.html) | [androidJvm]<br>abstract fun [removeCastListener](remove-cast-listener.html)(castApplicationListener: [CastApplicationListener](../-cast-application-listener/index.html))<br>abstract fun [removeCastListener](remove-cast-listener.html)(castSessionListener: [CastSessionListener](../-cast-session-listener/index.html)) |

