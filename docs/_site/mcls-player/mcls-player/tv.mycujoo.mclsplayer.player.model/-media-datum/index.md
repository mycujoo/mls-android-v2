//[mcls-player](../../../index.md)/[tv.mycujoo.mclsplayer.player.model](../index.md)/[MediaDatum](index.md)

# MediaDatum

[androidJvm]\
sealed class [MediaDatum](index.md)

## Types

| Name | Summary |
|---|---|
| [DRMMediaData](-d-r-m-media-data/index.md) | [androidJvm]<br>data class [DRMMediaData](-d-r-m-media-data/index.md)(val fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val dvrWindowSize: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = Long.MAX_VALUE, val licenseUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val autoPlay: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val streamId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val eventStatus: EventStatus? = null) : [MediaDatum](index.md) |
| [MediaData](-media-data/index.md) | [androidJvm]<br>data class [MediaData](-media-data/index.md)(val fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val dvrWindowSize: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = Long.MAX_VALUE, val autoPlay: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val streamId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val eventStatus: EventStatus? = null) : [MediaDatum](index.md) |

## Properties

| Name | Summary |
|---|---|
| [dvrWindowSize](dvr-window-size.md) | [androidJvm]<br>open val [dvrWindowSize](dvr-window-size.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [eventId](event-id.md) | [androidJvm]<br>open val [eventId](event-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |
| [eventStatus](event-status.md) | [androidJvm]<br>open val [eventStatus](event-status.md): EventStatus? |
| [fullUrl](full-url.md) | [androidJvm]<br>open val [fullUrl](full-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [streamId](stream-id.md) | [androidJvm]<br>open val [streamId](stream-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? |

## Inheritors

| Name |
|---|
| [MediaData](-media-data/index.md) |
| [DRMMediaData](-d-r-m-media-data/index.md) |
