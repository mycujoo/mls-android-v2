---
title: removeView
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.helper](../index.html)/[OverlayViewHelper](index.html)/[removeView](remove-view.html)



# removeView



[androidJvm]\
fun [removeView](remove-view.html)(customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), outroTransitionSpec: TransitionSpec?)



Remove overlay view from host view with specified animation.



#### Parameters


androidJvm

| | |
|---|---|
| overlayHost | the host that overlay view is displayed in currently |
| customId | overlay identifier (view tag) |
| outroTransitionSpec | transition specification needed for outro animation type and duration |





[androidJvm]\
fun [removeView](remove-view.html)(hideOverlayActionEntity: [HideOverlayActionEntity](../../tv.mycujoo.annotation.domain.entity/-hide-overlay-action-entity/index.html))



Remove overlay view from host view with specified animation.



#### Parameters


androidJvm

| | |
|---|---|
| overlayHost | the host that overlay view is displayed in currently |
| hideOverlayActionEntity | hide overlay Action which provides customId for removing overlay view with same identifier as 'Tag' |




