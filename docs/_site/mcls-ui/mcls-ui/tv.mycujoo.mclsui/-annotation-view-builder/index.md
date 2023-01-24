//[mcls-ui](../../../index.md)/[tv.mycujoo.mclsui](../index.md)/[AnnotationViewBuilder](index.md)

# AnnotationViewBuilder

[androidJvm]\
abstract class [AnnotationViewBuilder](index.md)

## Constructors

| | |
|---|---|
| [AnnotationViewBuilder](-annotation-view-builder.md) | [androidJvm]<br>fun [AnnotationViewBuilder](-annotation-view-builder.md)() |

## Functions

| Name | Summary |
|---|---|
| [build](build.md) | [androidJvm]<br>fun [build](build.md)(): IAnnotationView |
| [getAnnotationView](get-annotation-view.md) | [androidJvm]<br>open fun [getAnnotationView](get-annotation-view.md)(): IAnnotationView |
| [withActivity](with-activity.md) | [androidJvm]<br>open fun [withActivity](with-activity.md)(activity: [FragmentActivity](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity.html)): [AnnotationViewBuilder](index.md) |
| [withAnnotationView](with-annotation-view.md) | [androidJvm]<br>open fun [withAnnotationView](with-annotation-view.md)(annotationView: IAnnotationView): [AnnotationViewBuilder](index.md) |
| [withPlayer](with-player.md) | [androidJvm]<br>abstract fun [withPlayer](with-player.md)(exoPlayer: ExoPlayer): [AnnotationViewBuilder](index.md) |

## Properties

| Name | Summary |
|---|---|
| [activity](activity.md) | [androidJvm]<br>lateinit var [activity](activity.md): [FragmentActivity](https://developer.android.com/reference/kotlin/androidx/fragment/app/FragmentActivity.html) |
| [videoPlayer](video-player.md) | [androidJvm]<br>lateinit var [videoPlayer](video-player.md): VideoPlayer |

## Inheritors

| Name |
|---|
| [ExoAnnotationViewBuilder](../-exo-annotation-view-builder/index.md) |
