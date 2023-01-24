---
title: IAnnotationView
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.annotation](../index.html)/[IAnnotationView](index.html)



# IAnnotationView



[androidJvm]\
interface [IAnnotationView](index.html) : [DefaultLifecycleObserver](https://developer.android.com/reference/kotlin/androidx/lifecycle/DefaultLifecycleObserver.html)



## Functions


| Name | Summary |
|---|---|
| [addView](add-view.html) | [androidJvm]<br>abstract fun [addView](add-view.html)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html)) |
| [getChildren](get-children.html) | [androidJvm]<br>abstract fun [getChildren](get-children.html)(): [Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)&lt;[View](https://developer.android.com/reference/kotlin/android/view/View.html)&gt; |
| [getHeight](get-height.html) | [androidJvm]<br>abstract fun [getHeight](get-height.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getWidth](get-width.html) | [androidJvm]<br>abstract fun [getWidth](get-width.html)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onCreate](../../tv.mycujoo.annotation.widget/-annotation-view/index.html#139941652%2FFunctions%2F378504164) | [androidJvm]<br>open override fun [onCreate](../../tv.mycujoo.annotation.widget/-annotation-view/index.html#139941652%2FFunctions%2F378504164)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onDestroy](../../tv.mycujoo.annotation.widget/-annotation-view/index.html#1057561704%2FFunctions%2F378504164) | [androidJvm]<br>open override fun [onDestroy](../../tv.mycujoo.annotation.widget/-annotation-view/index.html#1057561704%2FFunctions%2F378504164)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onPause](../../tv.mycujoo.annotation.widget/-annotation-view/index.html#187777572%2FFunctions%2F378504164) | [androidJvm]<br>open override fun [onPause](../../tv.mycujoo.annotation.widget/-annotation-view/index.html#187777572%2FFunctions%2F378504164)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onResume](../../tv.mycujoo.annotation.widget/-annotation-view/index.html#-1807945979%2FFunctions%2F378504164) | [androidJvm]<br>open override fun [onResume](../../tv.mycujoo.annotation.widget/-annotation-view/index.html#-1807945979%2FFunctions%2F378504164)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStart](../../tv.mycujoo.annotation.widget/-annotation-view/index.html#1240777104%2FFunctions%2F378504164) | [androidJvm]<br>open override fun [onStart](../../tv.mycujoo.annotation.widget/-annotation-view/index.html#1240777104%2FFunctions%2F378504164)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStop](../../tv.mycujoo.annotation.widget/-annotation-view/index.html#487071706%2FFunctions%2F378504164) | [androidJvm]<br>open override fun [onStop](../../tv.mycujoo.annotation.widget/-annotation-view/index.html#487071706%2FFunctions%2F378504164)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [post](post.html) | [androidJvm]<br>abstract fun [post](post.html)(runnable: [Runnable](https://developer.android.com/reference/kotlin/java/lang/Runnable.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [removeAllViewsInLayout](remove-all-views-in-layout.html) | [androidJvm]<br>abstract fun [removeAllViewsInLayout](remove-all-views-in-layout.html)() |
| [removeView](remove-view.html) | [androidJvm]<br>abstract fun [removeView](remove-view.html)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html)) |


## Inheritors


| Name |
|---|
| [AnnotationView](../../tv.mycujoo.annotation.widget/-annotation-view/index.html) |

