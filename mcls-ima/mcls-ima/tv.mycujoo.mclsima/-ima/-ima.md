---
title: Ima
---
//[mcls-ima](../../../index.html)/[tv.mycujoo.mclsima](../index.html)/[Ima](index.html)/[Ima](-ima.html)



# Ima



[androidJvm]\
constructor(builder: ImaAdsLoader.Builder, listener: [ImaEventListener](../-ima-event-listener/index.html), adUnit: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), liveAdUnit: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))





[androidJvm]\
constructor(adUnit: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), liveAdUnit: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, paramProvider: () -&gt; [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null, listener: [ImaEventListener](../-ima-event-listener/index.html)? = null, debugMode: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, logger: Logger = Logger(LogLevel.VERBOSE))



#### Parameters


androidJvm

| | |
|---|---|
| adUnit | adUnit which is provided by Google IMA panel |
| liveAdUnit | adUnit for live events, provided by Google IMA panel |
| paramProvider | custom parameter to log through IMA |
| debugMode | debug/release mode the SDK is running. Caused to use debug adUnit |




