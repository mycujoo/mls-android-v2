---
title: AnnotationManagerImpl
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.mediator](../index.html)/[AnnotationManagerImpl](index.html)



# AnnotationManagerImpl



[androidJvm]\
class [AnnotationManagerImpl](index.html)@Injectconstructor(annotationFactory: [IAnnotationFactory](../../tv.mycujoo.annotation.core/-i-annotation-factory/index.html)) : [AnnotationManager](../-annotation-manager/index.html)



## Constructors


| | |
|---|---|
| [AnnotationManagerImpl](-annotation-manager-impl.html) | [androidJvm]<br>@Inject<br>constructor(annotationFactory: [IAnnotationFactory](../../tv.mycujoo.annotation.core/-i-annotation-factory/index.html)) |


## Functions


| Name | Summary |
|---|---|
| [attachPlayer](attach-player.html) | [androidJvm]<br>open override fun [attachPlayer](attach-player.html)(videoPlayer: [VideoPlayer](../../tv.mycujoo.annotation.annotation/-video-player/index.html))<br>A shorthand recurrent call to [setTime](set-time.html) and takes care of the rate of refreshes based on our recommendations |
| [release](release.html) | [androidJvm]<br>open override fun [release](release.html)()<br>Releases the player from memory. |
| [setActions](set-actions.html) | [androidJvm]<br>open override fun [setActions](set-actions.html)(actions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;)<br>region Over-ridden Functions |
| [setTime](set-time.html) | [androidJvm]<br>open override fun [setTime](set-time.html)(currentPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))<br>Processes actions and add/remove them to the AnnotationView |

