---
title: playEvent
---
//[mcls-tv](../../../index.html)/[tv.mycujoo.mcls.tv](../index.html)/[MCLSTVFragment](index.html)/[playEvent](play-event.html)



# playEvent



[androidJvm]\
fun [playEvent](play-event.html)(event: MCLSEvent)



plays event based on MCLSEvent



use in [FragmentActivity.onResumeFragments](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity.html#onResumeFragments--)



#### Throws


| | |
|---|---|
| [IllegalStateException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-state-exception/index.html) | when playback requested before the fragment is ready. |




[androidJvm]\
fun [playEvent](play-event.html)(eventId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), enableAnnotations: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true)



Plays event using Event Id.



#### Parameters


androidJvm

| | |
|---|---|
| eventId | MCLS Event Id |
| enableAnnotations | (true by default), used to disable annotations when not needed. |



#### Throws


| | |
|---|---|
| [PublicKeyNotSetException](../-public-key-not-set-exception/index.html) | when you try playback without providing a public key |



