---
title: joinEvent
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.network.socket](../index.html)/[ReactorSocket](index.html)/[joinEvent](join-event.html)



# joinEvent



[androidJvm]\
open override fun [joinEvent](join-event.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))



Joins to an Event with eventId by sending JOIN command. before doing so, it checks if active connection is already established, if so it will terminate that. Also, it checks if a socket client has been created, if not, it will create one.



#### Parameters


androidJvm

| |
|---|
| eventId |




