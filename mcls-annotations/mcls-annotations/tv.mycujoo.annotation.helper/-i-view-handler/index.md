---
title: IViewHandler
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.helper](../index.html)/[IViewHandler](index.html)



# IViewHandler

interface [IViewHandler](index.html)

#### Inheritors


| |
|---|
| [ViewHandler](../../tv.mycujoo.annotation.manager/-view-handler/index.html) |


## Functions


| Name | Summary |
|---|---|
| [addAnimation](add-animation.html) | [androidJvm]<br>abstract fun [addAnimation](add-animation.html)(overlayTag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), objectAnimator: [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)) |
| [attachOverlayView](attach-overlay-view.html) | [androidJvm]<br>abstract fun [attachOverlayView](attach-overlay-view.html)(view: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html)) |
| [clearAll](clear-all.html) | [androidJvm]<br>abstract fun [clearAll](clear-all.html)() |
| [decrementIdlingResource](decrement-idling-resource.html) | [androidJvm]<br>abstract fun [decrementIdlingResource](decrement-idling-resource.html)() |
| [detachOverlayView](detach-overlay-view.html) | [androidJvm]<br>abstract fun [detachOverlayView](detach-overlay-view.html)(view: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html)?) |
| [getAnimations](get-animations.html) | [androidJvm]<br>abstract fun [getAnimations](get-animations.html)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)&gt; |
| [getAnimationWithTag](get-animation-with-tag.html) | [androidJvm]<br>abstract fun [getAnimationWithTag](get-animation-with-tag.html)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [getOverlayView](get-overlay-view.html) | [androidJvm]<br>abstract fun [getOverlayView](get-overlay-view.html)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html)? |
| [incrementIdlingResource](increment-idling-resource.html) | [androidJvm]<br>abstract fun [incrementIdlingResource](increment-idling-resource.html)() |
| [overlayIsAttached](overlay-is-attached.html) | [androidJvm]<br>abstract fun [overlayIsAttached](overlay-is-attached.html)(tag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [overlayIsNotAttached](overlay-is-not-attached.html) | [androidJvm]<br>abstract fun [overlayIsNotAttached](overlay-is-not-attached.html)(tag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [removeAnimation](remove-animation.html) | [androidJvm]<br>abstract fun [removeAnimation](remove-animation.html)(overlayTag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

