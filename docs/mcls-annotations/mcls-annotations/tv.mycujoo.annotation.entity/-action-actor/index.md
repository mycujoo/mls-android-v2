---
title: ActionActor
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.entity](../index.html)/[ActionActor](index.html)



# ActionActor



[androidJvm]\
class [ActionActor](index.html)

Actor for Annotation Actions



## Constructors


| | |
|---|---|
| [ActionActor](-action-actor.html) | [androidJvm]<br>fun [ActionActor](-action-actor.html)() |


## Types


| Name | Summary |
|---|---|
| [ActionAct](-action-act/index.html) | [androidJvm]<br>enum [ActionAct](-action-act/index.html) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[ActionActor.ActionAct](-action-act/index.html)&gt; |


## Functions


| Name | Summary |
|---|---|
| [act](act.html) | [androidJvm]<br>fun [act](act.html)(now: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), showOverlayActions: [ArrayList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)&lt;AnnotationAction.ShowOverlayAction&gt;, hideOverlayActions: [ArrayList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)&lt;AnnotationAction.HideOverlayAction&gt;): [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[ActionActor.ActionAct](-action-act/index.html), AnnotationAction&gt;&gt;<br>Actions should be provided sorted based on their offset |

