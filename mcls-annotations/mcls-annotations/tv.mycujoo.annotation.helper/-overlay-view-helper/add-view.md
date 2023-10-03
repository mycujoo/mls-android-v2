---
title: addView
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.helper](../index.html)/[OverlayViewHelper](index.html)/[addView](add-view.html)



# addView



[androidJvm]\
fun [addView](add-view.html)(showOverlayAction: AnnotationAction.ShowOverlayAction)



Add overlay view to host view with specified animation. If there is a specified animation, it will be add with amimation, otherwise no animation will be created. This is the only method that should be used for 'Adding' overlay. All other methods are private and considered internal service.



#### Parameters


androidJvm

| | |
|---|---|
| overlayHost | to host to overlay view |
| showOverlayAction | data needed for type of animation and overlay |



