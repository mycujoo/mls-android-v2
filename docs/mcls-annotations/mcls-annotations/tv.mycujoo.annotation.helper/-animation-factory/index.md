---
title: AnimationFactory
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.helper](../index.html)/[AnimationFactory](index.html)



# AnimationFactory



[androidJvm]\
open class [AnimationFactory](index.html)@Injectconstructor

Creates Android animation object 'ObjectAnimator' with given parameters. Parameter used in creating animation, Each animation needs a combination of these to be created:



#### See also


androidJvm

| |
|---|
| [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html) |
| AnimationType |
| TransitionSpec |



## Constructors


| | |
|---|---|
| [AnimationFactory](-animation-factory.html) | [androidJvm]<br>@Inject<br>fun [AnimationFactory](-animation-factory.html)() |


## Functions


| Name | Summary |
|---|---|
| [createAddViewDynamicAnimation](create-add-view-dynamic-animation.html) | [androidJvm]<br>open fun [createAddViewDynamicAnimation](create-add-view-dynamic-animation.html)(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.html), scaffoldView: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html), introTransitionSpec: TransitionSpec, viewHandler: [IViewHandler](../-i-view-handler/index.html)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [createAddViewStaticAnimation](create-add-view-static-animation.html) | [androidJvm]<br>open fun [createAddViewStaticAnimation](create-add-view-static-animation.html)(scaffoldView: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html), animationType: AnimationType, animationDuration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [createLingeringIntroViewAnimation](create-lingering-intro-view-animation.html) | [androidJvm]<br>open fun [createLingeringIntroViewAnimation](create-lingering-intro-view-animation.html)(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.html), scaffoldView: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html), overlayEntity: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), viewHandler: [IViewHandler](../-i-view-handler/index.html)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [createLingeringOutroAnimation](create-lingering-outro-animation.html) | [androidJvm]<br>open fun [createLingeringOutroAnimation](create-lingering-outro-animation.html)(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.html), scaffoldView: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html), overlayEntity: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), viewHandler: [IViewHandler](../-i-view-handler/index.html)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [createRemoveViewDynamicAnimation](create-remove-view-dynamic-animation.html) | [androidJvm]<br>open fun [createRemoveViewDynamicAnimation](create-remove-view-dynamic-animation.html)(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.html), actionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), outroTransitionSpec: TransitionSpec, view: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html), viewHandler: [IViewHandler](../-i-view-handler/index.html)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [createRemoveViewStaticAnimation](create-remove-view-static-animation.html) | [androidJvm]<br>open fun [createRemoveViewStaticAnimation](create-remove-view-static-animation.html)(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.html), showOverlayAction: AnnotationAction.ShowOverlayAction, overlayView: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html), viewHandler: [IViewHandler](../-i-view-handler/index.html)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)<br>open fun [createRemoveViewStaticAnimation](create-remove-view-static-animation.html)(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.html), actionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), outroTransitionSpec: TransitionSpec, overlayView: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html), viewHandler: [IViewHandler](../-i-view-handler/index.html)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html) |

