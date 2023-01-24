---
title: ActionSourceData
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.domain.entity](../index.html)/[ActionSourceData](index.html)



# ActionSourceData



[androidJvm]\
data class [ActionSourceData](index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val type: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, val absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, val data: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;?)



## Constructors


| | |
|---|---|
| [ActionSourceData](-action-source-data.html) | [androidJvm]<br>fun [ActionSourceData](-action-source-data.html)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, type: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, data: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;?) |


## Functions


| Name | Summary |
|---|---|
| [toAction](to-action.html) | [androidJvm]<br>fun [toAction](to-action.html)(): AnnotationAction |


## Properties


| Name | Summary |
|---|---|
| [absoluteTime](absolute-time.html) | [androidJvm]<br>@Json(name = &quot;absoluteTime&quot;)<br>val [absoluteTime](absolute-time.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? |
| [data](data.html) | [androidJvm]<br>@Json(name = &quot;data&quot;)<br>val [data](data.html): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;? |
| [id](id.html) | [androidJvm]<br>@Json(name = &quot;id&quot;)<br>val [id](id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [offset](offset.html) | [androidJvm]<br>@Json(name = &quot;offset&quot;)<br>val [offset](offset.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? |
| [type](type.html) | [androidJvm]<br>@Json(name = &quot;type&quot;)<br>val [type](type.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |

