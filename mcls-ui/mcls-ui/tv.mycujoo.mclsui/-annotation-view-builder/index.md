---
title: AnnotationViewBuilder
---
//[mcls-ui](../../../index.html)/[tv.mycujoo.mclsui](../index.html)/[AnnotationViewBuilder](index.html)



# AnnotationViewBuilder

abstract class [AnnotationViewBuilder](index.html)

#### Inheritors


| |
|---|
| [ExoAnnotationViewBuilder](../-exo-annotation-view-builder/index.html) |


## Constructors


| | |
|---|---|
| [AnnotationViewBuilder](-annotation-view-builder.html) | [androidJvm]<br>constructor() |


## Functions


| Name | Summary |
|---|---|
| [build](build.html) | [androidJvm]<br>fun [build](build.html)(): IAnnotationView |
| [getAnnotationView](get-annotation-view.html) | [androidJvm]<br>open fun [getAnnotationView](get-annotation-view.html)(): IAnnotationView |
| [withActivity](with-activity.html) | [androidJvm]<br>open fun [withActivity](with-activity.html)(activity: [FragmentActivity](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity.html)): [AnnotationViewBuilder](index.html) |
| [withAnnotationView](with-annotation-view.html) | [androidJvm]<br>open fun [withAnnotationView](with-annotation-view.html)(annotationView: IAnnotationView): [AnnotationViewBuilder](index.html) |
| [withPlayer](with-player.html) | [androidJvm]<br>abstract fun [withPlayer](with-player.html)(exoPlayer: ExoPlayer): [AnnotationViewBuilder](index.html) |


## Properties


| Name | Summary |
|---|---|
| [activity](activity.html) | [androidJvm]<br>lateinit var [activity](activity.html): [FragmentActivity](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity.html) |
| [videoPlayer](video-player.html) | [androidJvm]<br>lateinit var [videoPlayer](video-player.html): VideoPlayer |

