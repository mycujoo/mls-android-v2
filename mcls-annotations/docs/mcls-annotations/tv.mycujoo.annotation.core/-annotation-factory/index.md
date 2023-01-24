---
title: AnnotationFactory
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.core](../index.html)/[AnnotationFactory](index.html)



# AnnotationFactory



[androidJvm]\
class [AnnotationFactory](index.html)@Injectconstructor(annotationListener: [IAnnotationListener](../-i-annotation-listener/index.html), variableKeeper: [IVariableKeeper](../../tv.mycujoo.annotation.manager/-i-variable-keeper/index.html)) : [IAnnotationFactory](../-i-annotation-factory/index.html)



## Constructors


| | |
|---|---|
| [AnnotationFactory](-annotation-factory.html) | [androidJvm]<br>@Inject<br>fun [AnnotationFactory](-annotation-factory.html)(annotationListener: [IAnnotationListener](../-i-annotation-listener/index.html), variableKeeper: [IVariableKeeper](../../tv.mycujoo.annotation.manager/-i-variable-keeper/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [build](build.html) | [androidJvm]<br>open override fun [build](build.html)(currentPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [clearOverlays](clear-overlays.html) | [androidJvm]<br>open override fun [clearOverlays](clear-overlays.html)()<br>endregion |
| [getCurrentActions](get-current-actions.html) | [androidJvm]<br>open override fun [getCurrentActions](get-current-actions.html)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt; |
| [setActions](set-actions.html) | [androidJvm]<br>open override fun [setActions](set-actions.html)(actions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;)<br>Set Local Actions, used for Mapped GQL events |

