//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.helper](../index.md)/[OverlayViewHelper](index.md)

# OverlayViewHelper

[androidJvm]\
@Singleton

class [OverlayViewHelper](index.md)@Injectconstructor(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.md), viewHandler: [IViewHandler](../-i-view-handler/index.md), overlayFactory: [IOverlayFactory](../-i-overlay-factory/index.md), animationFactory: [AnimationFactory](../-animation-factory/index.md))

Helps with View related operations. i.e. Add/Remove overlay view to/from screen.

## Constructors

| | |
|---|---|
| [OverlayViewHelper](-overlay-view-helper.md) | [androidJvm]<br>@Inject<br>fun [OverlayViewHelper](-overlay-view-helper.md)(overlayHost: [IAnnotationView](../../tv.mycujoo.annotation.annotation/-i-annotation-view/index.md), viewHandler: [IViewHandler](../-i-view-handler/index.md), overlayFactory: [IOverlayFactory](../-i-overlay-factory/index.md), animationFactory: [AnimationFactory](../-animation-factory/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [addOrUpdateLingeringIntroOverlay](add-or-update-lingering-intro-overlay.md) | [androidJvm]<br>fun [addOrUpdateLingeringIntroOverlay](add-or-update-lingering-intro-overlay.md)(showOverlayAction: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>region Add or Update lingering intro view |
| [addOrUpdateLingeringMidwayOverlay](add-or-update-lingering-midway-overlay.md) | [androidJvm]<br>fun [addOrUpdateLingeringMidwayOverlay](add-or-update-lingering-midway-overlay.md)(showOverlayAction: AnnotationAction.ShowOverlayAction) |
| [addOrUpdateLingeringOutroOverlay](add-or-update-lingering-outro-overlay.md) | [androidJvm]<br>fun [addOrUpdateLingeringOutroOverlay](add-or-update-lingering-outro-overlay.md)(showOverlayAction: AnnotationAction.ShowOverlayAction, animationPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), isPlaying: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>region Add or Update lingering outro view |
| [addView](add-view.md) | [androidJvm]<br>fun [addView](add-view.md)(showOverlayAction: AnnotationAction.ShowOverlayAction)<br>Add overlay view to host view with specified animation. If there is a specified animation, it will be add with amimation, otherwise no animation will be created. This is the only method that should be used for 'Adding' overlay. All other methods are private and considered internal service. |
| [clearScreen](clear-screen.md) | [androidJvm]<br>fun [clearScreen](clear-screen.md)() |
| [removeView](remove-view.md) | [androidJvm]<br>fun [removeView](remove-view.md)(hideOverlayActionEntity: [HideOverlayActionEntity](../../tv.mycujoo.annotation.domain.entity/-hide-overlay-action-entity/index.md))<br>fun [removeView](remove-view.md)(customId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), outroTransitionSpec: TransitionSpec?)<br>Remove overlay view from host view with specified animation. |
