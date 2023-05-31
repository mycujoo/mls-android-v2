---
title: ActionResponse
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.data.entity](../index.html)/[ActionResponse](index.html)



# ActionResponse



[androidJvm]\
@JsonClass(generateAdapter = true)



data class [ActionResponse](index.html)(var data: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ActionSourceData](../../tv.mycujoo.mclsnetwork.domain.entity/-action-source-data/index.html)&gt;, var updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null)



## Constructors


| | |
|---|---|
| [ActionResponse](-action-response.html) | [androidJvm]<br>constructor(data: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ActionSourceData](../../tv.mycujoo.mclsnetwork.domain.entity/-action-source-data/index.html)&gt;, updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null) |


## Properties


| Name | Summary |
|---|---|
| [data](data.html) | [androidJvm]<br>@Json(name = &quot;actions&quot;)<br>var [data](data.html): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ActionSourceData](../../tv.mycujoo.mclsnetwork.domain.entity/-action-source-data/index.html)&gt; |
| [updateId](update-id.html) | [androidJvm]<br>@Json(name = &quot;update_id&quot;)<br>var [updateId](update-id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |

