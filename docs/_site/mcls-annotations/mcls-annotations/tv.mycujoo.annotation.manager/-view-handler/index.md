//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.manager](../index.md)/[ViewHandler](index.md)

# ViewHandler

[androidJvm]\
open class [ViewHandler](index.md)@Injectconstructor(val idlingResource: [CountingIdlingResource](https://developer.android.com/reference/kotlin/androidx/test/espresso/idling/CountingIdlingResource.html), overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.md)) : [IViewHandler](../../tv.mycujoo.annotation.helper/-i-view-handler/index.md)

## Constructors

| | |
|---|---|
| [ViewHandler](-view-handler.md) | [androidJvm]<br>@Inject<br>fun [ViewHandler](-view-handler.md)(idlingResource: [CountingIdlingResource](https://developer.android.com/reference/kotlin/androidx/test/espresso/idling/CountingIdlingResource.html), overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [addAnimation](add-animation.md) | [androidJvm]<br>open override fun [addAnimation](add-animation.md)(overlayTag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), objectAnimator: [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html))<br>region Animation |
| [attachOverlayView](attach-overlay-view.md) | [androidJvm]<br>open override fun [attachOverlayView](attach-overlay-view.md)(view: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md))<br>region Overlay views |
| [clearAll](clear-all.md) | [androidJvm]<br>open override fun [clearAll](clear-all.md)()<br>region msc |
| [decrementIdlingResource](decrement-idling-resource.md) | [androidJvm]<br>open override fun [decrementIdlingResource](decrement-idling-resource.md)() |
| [detachOverlayView](detach-overlay-view.md) | [androidJvm]<br>open override fun [detachOverlayView](detach-overlay-view.md)(view: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md)?) |
| [getAnimations](get-animations.md) | [androidJvm]<br>open override fun [getAnimations](get-animations.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)&gt; |
| [getAnimationWithTag](get-animation-with-tag.md) | [androidJvm]<br>open override fun [getAnimationWithTag](get-animation-with-tag.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [getOverlayView](get-overlay-view.md) | [androidJvm]<br>open override fun [getOverlayView](get-overlay-view.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md)? |
| [incrementIdlingResource](increment-idling-resource.md) | [androidJvm]<br>open override fun [incrementIdlingResource](increment-idling-resource.md)() |
| [overlayIsAttached](overlay-is-attached.md) | [androidJvm]<br>open override fun [overlayIsAttached](overlay-is-attached.md)(tag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [overlayIsNotAttached](overlay-is-not-attached.md) | [androidJvm]<br>open override fun [overlayIsNotAttached](overlay-is-not-attached.md)(tag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>region Overlay objects |
| [removeAnimation](remove-animation.md) | [androidJvm]<br>open override fun [removeAnimation](remove-animation.md)(overlayTag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [idlingResource](idling-resource.md) | [androidJvm]<br>val [idlingResource](idling-resource.md): [CountingIdlingResource](https://developer.android.com/reference/kotlin/androidx/test/espresso/idling/CountingIdlingResource.html) |
