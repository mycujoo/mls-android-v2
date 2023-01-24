//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.network.socket](../index.md)/[ReactorSocket](index.md)/[joinEvent](join-event.md)

# joinEvent

[androidJvm]\
open override fun [joinEvent](join-event.md)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Joins to an Event with eventId by sending JOIN command. before doing so, it checks if active connection is already established, if so it will terminate that. Also, it checks if a socket client has been created, if not, it will create one.

#### Parameters

androidJvm

| |
|---|
| eventId |
