//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.data.entity](../index.md)/[ActionResponse](index.md)

# ActionResponse

[androidJvm]\
@JsonClass(generateAdapter = true)

data class [ActionResponse](index.md)(var data: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ActionSourceData](../../tv.mycujoo.mclsnetwork.domain.entity/-action-source-data/index.md)&gt;, var updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null)

## Constructors

| | |
|---|---|
| [ActionResponse](-action-response.md) | [androidJvm]<br>fun [ActionResponse](-action-response.md)(data: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ActionSourceData](../../tv.mycujoo.mclsnetwork.domain.entity/-action-source-data/index.md)&gt;, updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [data](data.md) | [androidJvm]<br>@Json(name = &quot;actions&quot;)<br>var [data](data.md): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ActionSourceData](../../tv.mycujoo.mclsnetwork.domain.entity/-action-source-data/index.md)&gt; |
| [updateId](update-id.md) | [androidJvm]<br>@Json(name = &quot;update_id&quot;)<br>var [updateId](update-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
