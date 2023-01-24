//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.core](../index.md)/[AnnotationFactory](index.md)

# AnnotationFactory

[androidJvm]\
class [AnnotationFactory](index.md)@Injectconstructor(annotationListener: [IAnnotationListener](../-i-annotation-listener/index.md), variableKeeper: [IVariableKeeper](../../tv.mycujoo.annotation.manager/-i-variable-keeper/index.md)) : [IAnnotationFactory](../-i-annotation-factory/index.md)

## Constructors

| | |
|---|---|
| [AnnotationFactory](-annotation-factory.md) | [androidJvm]<br>@Inject<br>fun [AnnotationFactory](-annotation-factory.md)(annotationListener: [IAnnotationListener](../-i-annotation-listener/index.md), variableKeeper: [IVariableKeeper](../../tv.mycujoo.annotation.manager/-i-variable-keeper/index.md)) |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [androidJvm]<br>open override fun [build](build.md)(currentPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [clearOverlays](clear-overlays.md) | [androidJvm]<br>open override fun [clearOverlays](clear-overlays.md)()<br>endregion |
| [getCurrentActions](get-current-actions.md) | [androidJvm]<br>open override fun [getCurrentActions](get-current-actions.md)(): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt; |
| [setActions](set-actions.md) | [androidJvm]<br>open override fun [setActions](set-actions.md)(actions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;)<br>Set Local Actions, used for Mapped GQL events |
