---
title: IInternalDataProvider
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.data](../index.html)/[IInternalDataProvider](index.html)



# IInternalDataProvider

interface [IInternalDataProvider](index.html)

#### Inheritors


| |
|---|
| [IDataManager](../-i-data-manager/index.html) |


## Functions


| Name | Summary |
|---|---|
| [getActions](get-actions.html) | [androidJvm]<br>abstract suspend fun [getActions](get-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;&gt; |
| [getEventDetails](get-event-details.html) | [androidJvm]<br>abstract suspend fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), MCLSEvent&gt; |
| [setLogLevel](set-log-level.html) | [androidJvm]<br>abstract fun [setLogLevel](set-log-level.html)(logLevel: LogLevel) |

