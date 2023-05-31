---
title: AnnotationManager
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.mediator](../index.html)/[AnnotationManager](index.html)



# AnnotationManager

interface [AnnotationManager](index.html)

Annotation management in AnnotationView.



#### Inheritors


| |
|---|
| [AnnotationManagerImpl](../-annotation-manager-impl/index.html) |


## Types


| Name | Summary |
|---|---|
| [Builder](-builder/index.html) | [androidJvm]<br>class [Builder](-builder/index.html) |


## Functions


| Name | Summary |
|---|---|
| [attachPlayer](attach-player.html) | [androidJvm]<br>abstract fun [attachPlayer](attach-player.html)(videoPlayer: [VideoPlayer](../../tv.mycujoo.annotation.annotation/-video-player/index.html))<br>A shorthand recurrent call to [setTime](set-time.html) and takes care of the rate of refreshes based on our recommendations |
| [release](release.html) | [androidJvm]<br>abstract fun [release](release.html)()<br>Releases the player from memory. |
| [setActions](set-actions.html) | [androidJvm]<br>abstract fun [setActions](set-actions.html)(actions: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;)<br>Sets the actions in memory, queuing them for processing when [setTime](set-time.html) is triggered. |
| [setTime](set-time.html) | [androidJvm]<br>abstract fun [setTime](set-time.html)(currentPosition: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))<br>Processes actions and add/remove them to the AnnotationView |

