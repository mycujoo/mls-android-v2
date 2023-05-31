---
title: MediaDatum
---
//[mcls-player](../../../index.html)/[tv.mycujoo.mclsplayer.player.model](../index.html)/[MediaDatum](index.html)



# MediaDatum

sealed class [MediaDatum](index.html)

#### Inheritors


| |
|---|
| [MediaData](-media-data/index.html) |
| [DRMMediaData](-d-r-m-media-data/index.html) |


## Types


| Name | Summary |
|---|---|
| [DRMMediaData](-d-r-m-media-data/index.html) | [androidJvm]<br>data class [DRMMediaData](-d-r-m-media-data/index.html)(val fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val dvrWindowSize: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = Long.MAX_VALUE, val licenseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val autoPlay: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val streamId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val eventStatus: EventStatus? = null) : [MediaDatum](index.html) |
| [MediaData](-media-data/index.html) | [androidJvm]<br>data class [MediaData](-media-data/index.html)(val fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val dvrWindowSize: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = Long.MAX_VALUE, val autoPlay: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val streamId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val eventStatus: EventStatus? = null) : [MediaDatum](index.html) |


## Properties


| Name | Summary |
|---|---|
| [dvrWindowSize](dvr-window-size.html) | [androidJvm]<br>open val [dvrWindowSize](dvr-window-size.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [eventId](event-id.html) | [androidJvm]<br>open val [eventId](event-id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [eventStatus](event-status.html) | [androidJvm]<br>open val [eventStatus](event-status.html): EventStatus? |
| [fullUrl](full-url.html) | [androidJvm]<br>open val [fullUrl](full-url.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [streamId](stream-id.html) | [androidJvm]<br>open val [streamId](stream-id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |

