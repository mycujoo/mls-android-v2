//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.annotation](../index.md)/[IAnnotationView](index.md)

# IAnnotationView

[androidJvm]\
interface [IAnnotationView](index.md) : [DefaultLifecycleObserver](https://developer.android.com/reference/kotlin/androidx/lifecycle/DefaultLifecycleObserver.html)

## Functions

| Name | Summary |
|---|---|
| [addView](add-view.md) | [androidJvm]<br>abstract fun [addView](add-view.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html)) |
| [getChildren](get-children.md) | [androidJvm]<br>abstract fun [getChildren](get-children.md)(): [Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)&lt;[View](https://developer.android.com/reference/kotlin/android/view/View.html)&gt; |
| [getHeight](get-height.md) | [androidJvm]<br>abstract fun [getHeight](get-height.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getWidth](get-width.md) | [androidJvm]<br>abstract fun [getWidth](get-width.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onCreate](../../tv.mycujoo.annotation.widget/-annotation-view/index.md#139941652%2FFunctions%2F-416046473) | [androidJvm]<br>open override fun [onCreate](../../tv.mycujoo.annotation.widget/-annotation-view/index.md#139941652%2FFunctions%2F-416046473)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onDestroy](../../tv.mycujoo.annotation.widget/-annotation-view/index.md#1057561704%2FFunctions%2F-416046473) | [androidJvm]<br>open override fun [onDestroy](../../tv.mycujoo.annotation.widget/-annotation-view/index.md#1057561704%2FFunctions%2F-416046473)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onPause](../../tv.mycujoo.annotation.widget/-annotation-view/index.md#187777572%2FFunctions%2F-416046473) | [androidJvm]<br>open override fun [onPause](../../tv.mycujoo.annotation.widget/-annotation-view/index.md#187777572%2FFunctions%2F-416046473)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onResume](../../tv.mycujoo.annotation.widget/-annotation-view/index.md#-1807945979%2FFunctions%2F-416046473) | [androidJvm]<br>open override fun [onResume](../../tv.mycujoo.annotation.widget/-annotation-view/index.md#-1807945979%2FFunctions%2F-416046473)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStart](../../tv.mycujoo.annotation.widget/-annotation-view/index.md#1240777104%2FFunctions%2F-416046473) | [androidJvm]<br>open override fun [onStart](../../tv.mycujoo.annotation.widget/-annotation-view/index.md#1240777104%2FFunctions%2F-416046473)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [onStop](../../tv.mycujoo.annotation.widget/-annotation-view/index.md#487071706%2FFunctions%2F-416046473) | [androidJvm]<br>open override fun [onStop](../../tv.mycujoo.annotation.widget/-annotation-view/index.md#487071706%2FFunctions%2F-416046473)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)p0: [LifecycleOwner](https://developer.android.com/reference/kotlin/androidx/lifecycle/LifecycleOwner.html)) |
| [post](post.md) | [androidJvm]<br>abstract fun [post](post.md)(runnable: [Runnable](https://developer.android.com/reference/kotlin/java/lang/Runnable.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [removeAllViewsInLayout](remove-all-views-in-layout.md) | [androidJvm]<br>abstract fun [removeAllViewsInLayout](remove-all-views-in-layout.md)() |
| [removeView](remove-view.md) | [androidJvm]<br>abstract fun [removeView](remove-view.md)(view: [View](https://developer.android.com/reference/kotlin/android/view/View.html)) |

## Inheritors

| Name |
|---|
| [AnnotationView](../../tv.mycujoo.annotation.widget/-annotation-view/index.md) |
