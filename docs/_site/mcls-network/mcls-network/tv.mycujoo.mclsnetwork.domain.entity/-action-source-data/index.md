//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.domain.entity](../index.md)/[ActionSourceData](index.md)

# ActionSourceData

[androidJvm]\
data class [ActionSourceData](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val type: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, val absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, val data: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;?)

## Constructors

| | |
|---|---|
| [ActionSourceData](-action-source-data.md) | [androidJvm]<br>fun [ActionSourceData](-action-source-data.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, type: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, absoluteTime: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)?, data: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;?) |

## Functions

| Name | Summary |
|---|---|
| [toAction](to-action.md) | [androidJvm]<br>fun [toAction](to-action.md)(): AnnotationAction |

## Properties

| Name | Summary |
|---|---|
| [absoluteTime](absolute-time.md) | [androidJvm]<br>@Json(name = &quot;absoluteTime&quot;)<br>val [absoluteTime](absolute-time.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? |
| [data](data.md) | [androidJvm]<br>@Json(name = &quot;data&quot;)<br>val [data](data.md): [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt;? |
| [id](id.md) | [androidJvm]<br>@Json(name = &quot;id&quot;)<br>val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [offset](offset.md) | [androidJvm]<br>@Json(name = &quot;offset&quot;)<br>val [offset](offset.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)? |
| [type](type.md) | [androidJvm]<br>@Json(name = &quot;type&quot;)<br>val [type](type.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
