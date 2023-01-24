---
title: Stream
---
//[mcls-core](../../../index.html)/[tv.mycujoo.mclscore.model](../index.html)/[Stream](index.html)



# Stream



[androidJvm]\
data class [Stream](index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val dvrWindowString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val widevine: [Widevine](../-widevine/index.html)?, val err: [Err](../-err/index.html)? = null)



## Constructors


| | |
|---|---|
| [Stream](-stream.html) | [androidJvm]<br>fun [Stream](-stream.html)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), dvrWindowString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, widevine: [Widevine](../-widevine/index.html)?, err: [Err](../-err/index.html)? = null) |


## Functions


| Name | Summary |
|---|---|
| [getDvrWindowSize](get-dvr-window-size.html) | [androidJvm]<br>fun [getDvrWindowSize](get-dvr-window-size.html)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [hasError](has-error.html) | [androidJvm]<br>fun [hasError](has-error.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hasUnknownError](has-unknown-error.html) | [androidJvm]<br>fun [hasUnknownError](has-unknown-error.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isGeoBlocked](is-geo-blocked.html) | [androidJvm]<br>fun [isGeoBlocked](is-geo-blocked.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isNoEntitlement](is-no-entitlement.html) | [androidJvm]<br>fun [isNoEntitlement](is-no-entitlement.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isStreamPlayable](is-stream-playable.html) | [androidJvm]<br>fun [isStreamPlayable](is-stream-playable.html)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |


## Properties


| Name | Summary |
|---|---|
| [dvrWindowString](dvr-window-string.html) | [androidJvm]<br>val [dvrWindowString](dvr-window-string.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [err](err.html) | [androidJvm]<br>val [err](err.html): [Err](../-err/index.html)? = null |
| [fullUrl](full-url.html) | [androidJvm]<br>val [fullUrl](full-url.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [id](id.html) | [androidJvm]<br>val [id](id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [widevine](widevine.html) | [androidJvm]<br>val [widevine](widevine.html): [Widevine](../-widevine/index.html)? |

