//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.helper](../index.md)/[OverlayFactory](index.md)

# OverlayFactory

[androidJvm]\
@Singleton

class [OverlayFactory](index.md)@Injectconstructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), variableKeeper: [IVariableKeeper](../../tv.mycujoo.annotation.manager/-i-variable-keeper/index.md)) : [IOverlayFactory](../-i-overlay-factory/index.md)

Create overlay, which is the view used for displaying Annotation Action on screen.

#### Parameters

androidJvm

| | |
|---|---|
| context | context to create View from |
| variableKeeper | provides observables to for variables defined/used in Overlay |

## Constructors

| | |
|---|---|
| [OverlayFactory](-overlay-factory.md) | [androidJvm]<br>@Inject<br>fun [OverlayFactory](-overlay-factory.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), variableKeeper: [IVariableKeeper](../../tv.mycujoo.annotation.manager/-i-variable-keeper/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [createScaffoldView](create-scaffold-view.md) | [androidJvm]<br>open override fun [createScaffoldView](create-scaffold-view.md)(showOverlayAction: AnnotationAction.ShowOverlayAction): [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.md) |
