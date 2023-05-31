---
title: getEventDetails
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork](../index.html)/[MCLSNetworkImpl](index.html)/[getEventDetails](get-event-details.html)



# getEventDetails



[androidJvm]\
open suspend override fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), onEventComplete: (MCLSEvent) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))



Gets event details



#### Parameters


androidJvm

| |
|---|
| eventId |
| onEventComplete | a callback that triggers when the call finishes successfully |





[androidJvm]\
open suspend override fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), onEventComplete: (MCLSEvent) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), onError: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?)



Gets event details



#### Parameters


androidJvm

| |
|---|
| eventId |
| onEventComplete | a callback that triggers when the call finishes successfully |
| onError | a callback that triggers when an error happens |





[androidJvm]\
open suspend override fun [getEventDetails](get-event-details.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), MCLSEvent&gt;



Gets the event details raw response



#### Return



the raw response



#### Parameters


androidJvm

| |
|---|
| eventId |



#### See also


| | |
|---|---|
| MCLSResult | for usage |



