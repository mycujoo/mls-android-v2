//[mcls-player](../../../../index.md)/[tv.mycujoo.mclsplayer.player.model](../../index.md)/[MediaDatum](../index.md)/[MediaData](index.md)

# MediaData

[androidJvm]\
data class [MediaData](index.md)(val fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val dvrWindowSize: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = Long.MAX_VALUE, val autoPlay: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), val eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val streamId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, val eventStatus: EventStatus? = null) : [MediaDatum](../index.md)

## Constructors

| | |
|---|---|
| [MediaData](-media-data.md) | [androidJvm]<br>fun [MediaData](-media-data.md)(fullUrl: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), dvrWindowSize: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) = Long.MAX_VALUE, autoPlay: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, streamId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, eventStatus: EventStatus? = null) |

## Properties

| Name | Summary |
|---|---|
| [autoPlay](auto-play.md) | [androidJvm]<br>val [autoPlay](auto-play.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [dvrWindowSize](dvr-window-size.md) | [androidJvm]<br>open override val [dvrWindowSize](dvr-window-size.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [eventId](event-id.md) | [androidJvm]<br>open override val [eventId](event-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
| [eventStatus](event-status.md) | [androidJvm]<br>open override val [eventStatus](event-status.md): EventStatus? = null |
| [fullUrl](full-url.md) | [androidJvm]<br>open override val [fullUrl](full-url.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [streamId](stream-id.md) | [androidJvm]<br>open override val [streamId](stream-id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null |
