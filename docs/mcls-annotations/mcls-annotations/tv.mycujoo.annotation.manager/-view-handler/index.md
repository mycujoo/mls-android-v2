---
title: ViewHandler
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.manager](../index.html)/[ViewHandler](index.html)



# ViewHandler



[androidJvm]\
open class [ViewHandler](index.html)@Injectconstructor(val idlingResource: [CountingIdlingResource](https://developer.android.com/reference/kotlin/androidx/test/espresso/idling/CountingIdlingResource.html), overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.html)) : [IViewHandler](../../tv.mycujoo.annotation.helper/-i-view-handler/index.html)



## Constructors


| | |
|---|---|
| [ViewHandler](-view-handler.html) | [androidJvm]<br>@Inject<br>fun [ViewHandler](-view-handler.html)(idlingResource: [CountingIdlingResource](https://developer.android.com/reference/kotlin/androidx/test/espresso/idling/CountingIdlingResource.html), overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [addAnimation](add-animation.html) | [androidJvm]<br>open override fun [addAnimation](add-animation.html)(overlayTag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), objectAnimator: [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html))<br>region Animation |
| [attachOverlayView](attach-overlay-view.html) | [androidJvm]<br>open override fun [attachOverlayView](attach-overlay-view.html)(view: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html))<br>region Overlay views |
| [clearAll](clear-all.html) | [androidJvm]<br>open override fun [clearAll](clear-all.html)()<br>region msc |
| [decrementIdlingResource](decrement-idling-resource.html) | [androidJvm]<br>open override fun [decrementIdlingResource](decrement-idling-resource.html)() |
| [detachOverlayView](detach-overlay-view.html) | [androidJvm]<br>open override fun [detachOverlayView](detach-overlay-view.html)(view: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html)?) |
| [getAnimations](get-animations.html) | [androidJvm]<br>open override fun [getAnimations](get-animations.html)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)&gt; |
| [getAnimationWithTag](get-animation-with-tag.html) | [androidJvm]<br>open override fun [getAnimationWithTag](get-animation-with-tag.html)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [getOverlayView](get-overlay-view.html) | [androidJvm]<br>open override fun [getOverlayView](get-overlay-view.html)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html)? |
| [incrementIdlingResource](increment-idling-resource.html) | [androidJvm]<br>open override fun [incrementIdlingResource](increment-idling-resource.html)() |
| [overlayIsAttached](overlay-is-attached.html) | [androidJvm]<br>open override fun [overlayIsAttached](overlay-is-attached.html)(tag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [overlayIsNotAttached](overlay-is-not-attached.html) | [androidJvm]<br>open override fun [overlayIsNotAttached](overlay-is-not-attached.html)(tag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>region Overlay objects |
| [removeAnimation](remove-animation.html) | [androidJvm]<br>open override fun [removeAnimation](remove-animation.html)(overlayTag: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |


## Properties


| Name | Summary |
|---|---|
| [idlingResource](idling-resource.html) | [androidJvm]<br>val [idlingResource](idling-resource.html): [CountingIdlingResource](https://developer.android.com/reference/kotlin/androidx/test/espresso/idling/CountingIdlingResource.html) |

