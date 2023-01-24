//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.data](../index.md)/[IInternalDataProvider](index.md)

# IInternalDataProvider

[androidJvm]\
interface [IInternalDataProvider](index.md)

## Functions

| Name | Summary |
|---|---|
| [getActions](get-actions.md) | [androidJvm]<br>abstract suspend fun [getActions](get-actions.md)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;&gt; |
| [getEventDetails](get-event-details.md) | [androidJvm]<br>abstract suspend fun [getEventDetails](get-event-details.md)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), EventEntity&gt; |
| [setLogLevel](set-log-level.md) | [androidJvm]<br>abstract fun [setLogLevel](set-log-level.md)(logLevel: LogLevel) |

## Inheritors

| Name |
|---|
| [IDataManager](../-i-data-manager/index.md) |
