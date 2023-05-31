---
title: tv.mycujoo.mclsima
---
//[mcls-ima](../../index.html)/[tv.mycujoo.mclsima](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [IIma](-i-ima/index.html) | [androidJvm]<br>interface [IIma](-i-ima/index.html) |
| [Ima](-ima/index.html) | [androidJvm]<br>class [Ima](-ima/index.html)(adUnit: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), liveAdUnit: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, paramProvider: () -&gt; [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, listener: [ImaEventListener](-ima-event-listener/index.html)? = null, debugMode: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, logger: Logger = Logger(LogLevel.VERBOSE)) : [IIma](-i-ima/index.html)<br>MLS IMA integration to use Google IMA |
| [ImaCustomParams](-ima-custom-params/index.html) | [androidJvm]<br>data class [ImaCustomParams](-ima-custom-params/index.html)(val eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val streamId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val eventStatus: EventStatus? = null) |
| [ImaEventListener](-ima-event-listener/index.html) | [androidJvm]<br>interface [ImaEventListener](-ima-event-listener/index.html)<br>Callback on Ads events |

