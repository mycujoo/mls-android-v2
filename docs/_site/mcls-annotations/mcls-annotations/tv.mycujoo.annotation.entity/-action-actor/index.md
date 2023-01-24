//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.entity](../index.md)/[ActionActor](index.md)

# ActionActor

[androidJvm]\
class [ActionActor](index.md)

Actor for Annotation Actions

## Constructors

| | |
|---|---|
| [ActionActor](-action-actor.md) | [androidJvm]<br>fun [ActionActor](-action-actor.md)() |

## Types

| Name | Summary |
|---|---|
| [ActionAct](-action-act/index.md) | [androidJvm]<br>enum [ActionAct](-action-act/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[ActionActor.ActionAct](-action-act/index.md)&gt; |

## Functions

| Name | Summary |
|---|---|
| [act](act.md) | [androidJvm]<br>fun [act](act.md)(now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), showOverlayActions: [ArrayList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)&lt;AnnotationAction.ShowOverlayAction&gt;, hideOverlayActions: [ArrayList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)&lt;AnnotationAction.HideOverlayAction&gt;): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[ActionActor.ActionAct](-action-act/index.md), AnnotationAction&gt;&gt;<br>Actions should be provided sorted based on their offset |
