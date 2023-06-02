---
title: playEvent
---
//[mcls](../../../index.html)/[tv.mycujoo.mcls.widget](../index.html)/[MCLSView](index.html)/[playEvent](play-event.html)



# playEvent



[androidJvm]\
fun [playEvent](play-event.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), imaParamsMap: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;? = null)



Play an event using event id



#### Parameters


androidJvm

| | |
|---|---|
| eventId | the MCLS Event id |
| imaParamsMap | Extra Params used for targeting in IMA |



#### Samples

playEvent



[androidJvm]\
fun [playEvent](play-event.html)(event: MCLSEvent)



Plays an event in active player:     1. If a cast session is established, play the event in cast     2. If not, it will be played in the local VideoPlayer



#### Throws


| | |
|---|---|
| [NotAttachedToActivityException](../-not-attached-to-activity-exception/index.html) | when the view is not attached to [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html) |



