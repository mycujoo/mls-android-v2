---
title: OverlayViewHelper
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.helper](../index.html)/[OverlayViewHelper](index.html)



# OverlayViewHelper



[androidJvm]\
@Singleton



class [OverlayViewHelper](index.html)@Injectconstructor(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.html), viewHandler: [IViewHandler](../-i-view-handler/index.html), overlayFactory: [IOverlayFactory](../-i-overlay-factory/index.html), animationFactory: [AnimationFactory](../-animation-factory/index.html))

Helps with View related operations. i.e. Add/Remove overlay view to/from screen.



## Constructors


| | |
|---|---|
| [OverlayViewHelper](-overlay-view-helper.html) | [androidJvm]<br>@Inject<br>constructor(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.html), viewHandler: [IViewHandler](../-i-view-handler/index.html), overlayFactory: [IOverlayFactory](../-i-overlay-factory/index.html), animationFactory: [AnimationFactory](../-animation-factory/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [addOrUpdateLingeringIntroOverlay](add-or-update-lingering-intro-overlay.html) | [androidJvm]<br>fun [addOrUpdateLingeringIntroOverlay](add-or-update-lingering-intro-overlay.html)(showOverlayAction: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>region Add or Update lingering intro view |
| [addOrUpdateLingeringMidwayOverlay](add-or-update-lingering-midway-overlay.html) | [androidJvm]<br>fun [addOrUpdateLingeringMidwayOverlay](add-or-update-lingering-midway-overlay.html)(showOverlayAction: AnnotationAction.ShowOverlayAction) |
| [addOrUpdateLingeringOutroOverlay](add-or-update-lingering-outro-overlay.html) | [androidJvm]<br>fun [addOrUpdateLingeringOutroOverlay](add-or-update-lingering-outro-overlay.html)(showOverlayAction: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>region Add or Update lingering outro view |
| [addView](add-view.html) | [androidJvm]<br>fun [addView](add-view.html)(showOverlayAction: AnnotationAction.ShowOverlayAction)<br>Add overlay view to host view with specified animation. If there is a specified animation, it will be add with amimation, otherwise no animation will be created. This is the only method that should be used for 'Adding' overlay. All other methods are private and considered internal service. |
| [clearScreen](clear-screen.html) | [androidJvm]<br>fun [clearScreen](clear-screen.html)() |
| [removeView](remove-view.html) | [androidJvm]<br>fun [removeView](remove-view.html)(hideOverlayActionEntity: [HideOverlayActionEntity](../../tv.mycujoo.annotation.domain.entity/-hide-overlay-action-entity/index.html))<br>fun [removeView](remove-view.html)(customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), outroTransitionSpec: TransitionSpec?)<br>Remove overlay view from host view with specified animation. |

