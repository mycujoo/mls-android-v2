---
title: StreamSourceData
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.data.model](../index.html)/[StreamSourceData](index.html)



# StreamSourceData



[androidJvm]\
@JsonClass(generateAdapter = true)



data class [StreamSourceData](index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val dvrWindowString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val drm: [DrmSourceData](../-drm-source-data/index.html)?, val errorCodeAndMessage: [ErrorCodeAndMessageSourceData](../-error-code-and-message-source-data/index.html)? = null)



## Constructors


| | |
|---|---|
| [StreamSourceData](-stream-source-data.html) | [androidJvm]<br>fun [StreamSourceData](-stream-source-data.html)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), dvrWindowString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, drm: [DrmSourceData](../-drm-source-data/index.html)?, errorCodeAndMessage: [ErrorCodeAndMessageSourceData](../-error-code-and-message-source-data/index.html)? = null) |


## Properties


| Name | Summary |
|---|---|
| [drm](drm.html) | [androidJvm]<br>@Json(name = &quot;drm&quot;)<br>val [drm](drm.html): [DrmSourceData](../-drm-source-data/index.html)? |
| [dvrWindowString](dvr-window-string.html) | [androidJvm]<br>@Json(name = &quot;dvr_window_size&quot;)<br>val [dvrWindowString](dvr-window-string.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [errorCodeAndMessage](error-code-and-message.html) | [androidJvm]<br>@Json(name = &quot;error&quot;)<br>val [errorCodeAndMessage](error-code-and-message.html): [ErrorCodeAndMessageSourceData](../-error-code-and-message-source-data/index.html)? = null |
| [fullUrl](full-url.html) | [androidJvm]<br>@Json(name = &quot;full_url&quot;)<br>val [fullUrl](full-url.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [id](id.html) | [androidJvm]<br>@Json(name = &quot;id&quot;)<br>val [id](id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

