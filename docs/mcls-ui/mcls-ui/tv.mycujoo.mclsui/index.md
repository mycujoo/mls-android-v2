---
title: tv.mycujoo.mclsui
---
//[mcls-ui](../../index.html)/[tv.mycujoo.mclsui](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [AnnotationViewBuilder](-annotation-view-builder/index.html) | [androidJvm]<br>abstract class [AnnotationViewBuilder](-annotation-view-builder/index.html) |
| [ExoAnnotationViewBuilder](-exo-annotation-view-builder/index.html) | [androidJvm]<br>class [ExoAnnotationViewBuilder](-exo-annotation-view-builder/index.html) : [AnnotationViewBuilder](-annotation-view-builder/index.html) |
| [MLSAnnotationView](-m-l-s-annotation-view/index.html) | [androidJvm]<br>class [MLSAnnotationView](-m-l-s-annotation-view/index.html)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), attrs: [AttributeSet](https://developer.android.com/reference/kotlin/android/util/AttributeSet.html)? = null, defStyleAttr: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0) : [ConstraintLayout](https://developer.android.com/reference/kotlin/androidx/constraintlayout/widget/ConstraintLayout.html), IAnnotationView |
| [MLSComponent](-m-l-s-component/index.html) | [androidJvm]<br>@Singleton<br>@Component(modules = [[MlsUiModule::class](-mls-ui-module/index.html)])<br>interface [MLSComponent](-m-l-s-component/index.html) |
| [MlsModuleBinds](-mls-module-binds/index.html) | [androidJvm]<br>@Module<br>interface [MlsModuleBinds](-mls-module-binds/index.html) |
| [MlsModuleProvides](-mls-module-provides/index.html) | [androidJvm]<br>@Module<br>class [MlsModuleProvides](-mls-module-provides/index.html) |
| [MlsUiModule](-mls-ui-module/index.html) | [androidJvm]<br>@Module(includes = [[MlsModuleBinds::class](-mls-module-binds/index.html), [MlsModuleProvides::class](-mls-module-provides/index.html)])<br>class [MlsUiModule](-mls-ui-module/index.html) |

