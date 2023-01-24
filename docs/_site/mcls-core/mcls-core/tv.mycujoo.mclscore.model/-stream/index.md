//[mcls-core](../../../index.md)/[tv.mycujoo.mclscore.model](../index.md)/[Stream](index.md)

# Stream

[androidJvm]\
data class [Stream](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val dvrWindowString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, val widevine: [Widevine](../-widevine/index.md)?, val err: [Err](../-err/index.md)? = null)

## Constructors

| | |
|---|---|
| [Stream](-stream.md) | [androidJvm]<br>fun [Stream](-stream.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), dvrWindowString: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, widevine: [Widevine](../-widevine/index.md)?, err: [Err](../-err/index.md)? = null) |

## Functions

| Name | Summary |
|---|---|
| [getDvrWindowSize](get-dvr-window-size.md) | [androidJvm]<br>fun [getDvrWindowSize](get-dvr-window-size.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [hasError](has-error.md) | [androidJvm]<br>fun [hasError](has-error.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [hasUnknownError](has-unknown-error.md) | [androidJvm]<br>fun [hasUnknownError](has-unknown-error.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isGeoBlocked](is-geo-blocked.md) | [androidJvm]<br>fun [isGeoBlocked](is-geo-blocked.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isNoEntitlement](is-no-entitlement.md) | [androidJvm]<br>fun [isNoEntitlement](is-no-entitlement.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isStreamPlayable](is-stream-playable.md) | [androidJvm]<br>fun [isStreamPlayable](is-stream-playable.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

## Properties

| Name | Summary |
|---|---|
| [dvrWindowString](dvr-window-string.md) | [androidJvm]<br>val [dvrWindowString](dvr-window-string.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [err](err.md) | [androidJvm]<br>val [err](err.md): [Err](../-err/index.md)? = null |
| [fullUrl](full-url.md) | [androidJvm]<br>val [fullUrl](full-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [id](id.md) | [androidJvm]<br>val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [widevine](widevine.md) | [androidJvm]<br>val [widevine](widevine.md): [Widevine](../-widevine/index.md)? |
