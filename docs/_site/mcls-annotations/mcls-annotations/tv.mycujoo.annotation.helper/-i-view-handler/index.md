//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.helper](../index.md)/[IViewHandler](index.md)

# IViewHandler

[androidJvm]\
interface [IViewHandler](index.md)

## Functions

| Name | Summary |
|---|---|
| [addAnimation](add-animation.md) | [androidJvm]<br>abstract fun [addAnimation](add-animation.md)(overlayTag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), objectAnimator: [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)) |
| [attachOverlayView](attach-overlay-view.md) | [androidJvm]<br>abstract fun [attachOverlayView](attach-overlay-view.md)(view: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md)) |
| [clearAll](clear-all.md) | [androidJvm]<br>abstract fun [clearAll](clear-all.md)() |
| [decrementIdlingResource](decrement-idling-resource.md) | [androidJvm]<br>abstract fun [decrementIdlingResource](decrement-idling-resource.md)() |
| [detachOverlayView](detach-overlay-view.md) | [androidJvm]<br>abstract fun [detachOverlayView](detach-overlay-view.md)(view: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md)?) |
| [getAnimations](get-animations.md) | [androidJvm]<br>abstract fun [getAnimations](get-animations.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)&gt; |
| [getAnimationWithTag](get-animation-with-tag.md) | [androidJvm]<br>abstract fun [getAnimationWithTag](get-animation-with-tag.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [getOverlayView](get-overlay-view.md) | [androidJvm]<br>abstract fun [getOverlayView](get-overlay-view.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md)? |
| [incrementIdlingResource](increment-idling-resource.md) | [androidJvm]<br>abstract fun [incrementIdlingResource](increment-idling-resource.md)() |
| [overlayIsAttached](overlay-is-attached.md) | [androidJvm]<br>abstract fun [overlayIsAttached](overlay-is-attached.md)(tag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [overlayIsNotAttached](overlay-is-not-attached.md) | [androidJvm]<br>abstract fun [overlayIsNotAttached](overlay-is-not-attached.md)(tag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [removeAnimation](remove-animation.md) | [androidJvm]<br>abstract fun [removeAnimation](remove-animation.md)(overlayTag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Inheritors

| Name |
|---|
| [ViewHandler](../../tv.mycujoo.annotation.manager/-view-handler/index.md) |
