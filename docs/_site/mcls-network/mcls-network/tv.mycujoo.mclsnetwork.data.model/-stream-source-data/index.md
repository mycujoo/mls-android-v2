//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.data.model](../index.md)/[StreamSourceData](index.md)

# StreamSourceData

[androidJvm]\
@JsonClass(generateAdapter = true)

data class [StreamSourceData](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val dvrWindowString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val drm: [DrmSourceData](../-drm-source-data/index.md)?, val errorCodeAndMessage: [ErrorCodeAndMessageSourceData](../-error-code-and-message-source-data/index.md)? = null)

## Constructors

| | |
|---|---|
| [StreamSourceData](-stream-source-data.md) | [androidJvm]<br>fun [StreamSourceData](-stream-source-data.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), dvrWindowString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, drm: [DrmSourceData](../-drm-source-data/index.md)?, errorCodeAndMessage: [ErrorCodeAndMessageSourceData](../-error-code-and-message-source-data/index.md)? = null) |

## Properties

| Name | Summary |
|---|---|
| [drm](drm.md) | [androidJvm]<br>@Json(name = &quot;drm&quot;)<br>val [drm](drm.md): [DrmSourceData](../-drm-source-data/index.md)? |
| [dvrWindowString](dvr-window-string.md) | [androidJvm]<br>@Json(name = &quot;dvr_window_size&quot;)<br>val [dvrWindowString](dvr-window-string.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [errorCodeAndMessage](error-code-and-message.md) | [androidJvm]<br>@Json(name = &quot;error&quot;)<br>val [errorCodeAndMessage](error-code-and-message.md): [ErrorCodeAndMessageSourceData](../-error-code-and-message-source-data/index.md)? = null |
| [fullUrl](full-url.md) | [androidJvm]<br>@Json(name = &quot;full_url&quot;)<br>val [fullUrl](full-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [id](id.md) | [androidJvm]<br>@Json(name = &quot;id&quot;)<br>val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
