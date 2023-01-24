//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.helper](../index.md)/[AnimationFactory](index.md)

# AnimationFactory

[androidJvm]\
open class [AnimationFactory](index.md)@Injectconstructor

Creates Android animation object 'ObjectAnimator' with given parameters. Parameter used in creating animation, Each animation needs a combination of these to be created:

#### See also

androidJvm

| |
|---|
| [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md) |
| AnimationType |
| TransitionSpec |

## Constructors

| | |
|---|---|
| [AnimationFactory](-animation-factory.md) | [androidJvm]<br>@Inject<br>fun [AnimationFactory](-animation-factory.md)() |

## Functions

| Name | Summary |
|---|---|
| [createAddViewDynamicAnimation](create-add-view-dynamic-animation.md) | [androidJvm]<br>open fun [createAddViewDynamicAnimation](create-add-view-dynamic-animation.md)(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.md), scaffoldView: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md), introTransitionSpec: TransitionSpec, viewHandler: [IViewHandler](../-i-view-handler/index.md)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [createAddViewStaticAnimation](create-add-view-static-animation.md) | [androidJvm]<br>open fun [createAddViewStaticAnimation](create-add-view-static-animation.md)(scaffoldView: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md), animationType: AnimationType, animationDuration: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [createLingeringIntroViewAnimation](create-lingering-intro-view-animation.md) | [androidJvm]<br>open fun [createLingeringIntroViewAnimation](create-lingering-intro-view-animation.md)(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.md), scaffoldView: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md), overlayEntity: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), viewHandler: [IViewHandler](../-i-view-handler/index.md)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [createLingeringOutroAnimation](create-lingering-outro-animation.md) | [androidJvm]<br>open fun [createLingeringOutroAnimation](create-lingering-outro-animation.md)(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.md), scaffoldView: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md), overlayEntity: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html), viewHandler: [IViewHandler](../-i-view-handler/index.md)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [createRemoveViewDynamicAnimation](create-remove-view-dynamic-animation.md) | [androidJvm]<br>open fun [createRemoveViewDynamicAnimation](create-remove-view-dynamic-animation.md)(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.md), actionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), outroTransitionSpec: TransitionSpec, view: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md), viewHandler: [IViewHandler](../-i-view-handler/index.md)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)? |
| [createRemoveViewStaticAnimation](create-remove-view-static-animation.md) | [androidJvm]<br>open fun [createRemoveViewStaticAnimation](create-remove-view-static-animation.md)(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.md), showOverlayAction: AnnotationAction.ShowOverlayAction, overlayView: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md), viewHandler: [IViewHandler](../-i-view-handler/index.md)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html)<br>open fun [createRemoveViewStaticAnimation](create-remove-view-static-animation.md)(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.md), actionId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), outroTransitionSpec: TransitionSpec, overlayView: [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md), viewHandler: [IViewHandler](../-i-view-handler/index.md)): [ObjectAnimator](https://developer.android.com/reference/kotlin/android/animation/ObjectAnimator.html) |
