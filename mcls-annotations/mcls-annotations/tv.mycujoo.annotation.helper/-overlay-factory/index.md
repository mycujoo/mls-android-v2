---
title: OverlayFactory
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.helper](../index.html)/[OverlayFactory](index.html)



# OverlayFactory





@Singleton



class [OverlayFactory](index.html)@Injectconstructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), variableKeeper: [IVariableKeeper](../../tv.mycujoo.annotation.manager/-i-variable-keeper/index.html)) : [IOverlayFactory](../-i-overlay-factory/index.html)

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
| [OverlayFactory](-overlay-factory.html) | [androidJvm]<br>@Inject<br>constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), variableKeeper: [IVariableKeeper](../../tv.mycujoo.annotation.manager/-i-variable-keeper/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [createScaffoldView](create-scaffold-view.html) | [androidJvm]<br>open override fun [createScaffoldView](create-scaffold-view.html)(showOverlayAction: AnnotationAction.ShowOverlayAction): [ScaffoldView](../../tv.mycujoo.annotation.widget/-scaffold-view/index.html) |

