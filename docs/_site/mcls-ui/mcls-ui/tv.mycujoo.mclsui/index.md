//[mcls-ui](../../index.md)/[tv.mycujoo.mclsui](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AnnotationViewBuilder](-annotation-view-builder/index.md) | [androidJvm]<br>abstract class [AnnotationViewBuilder](-annotation-view-builder/index.md) |
| [ExoAnnotationViewBuilder](-exo-annotation-view-builder/index.md) | [androidJvm]<br>class [ExoAnnotationViewBuilder](-exo-annotation-view-builder/index.md) : [AnnotationViewBuilder](-annotation-view-builder/index.md) |
| [MLSAnnotationView](-m-l-s-annotation-view/index.md) | [androidJvm]<br>class [MLSAnnotationView](-m-l-s-annotation-view/index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), attrs: [AttributeSet](https://developer.android.com/reference/kotlin/android/util/AttributeSet.html)? = null, defStyleAttr: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) = 0) : [ConstraintLayout](https://developer.android.com/reference/kotlin/androidx/constraintlayout/widget/ConstraintLayout.html), IAnnotationView |
| [MLSComponent](-m-l-s-component/index.md) | [androidJvm]<br>@Singleton<br>@Component(modules = [[MlsUiModule::class](-mls-ui-module/index.md)])<br>interface [MLSComponent](-m-l-s-component/index.md) |
| [MlsModuleBinds](-mls-module-binds/index.md) | [androidJvm]<br>@Module<br>interface [MlsModuleBinds](-mls-module-binds/index.md) |
| [MlsModuleProvides](-mls-module-provides/index.md) | [androidJvm]<br>@Module<br>class [MlsModuleProvides](-mls-module-provides/index.md) |
| [MlsUiModule](-mls-ui-module/index.md) | [androidJvm]<br>@Module(includes = [[MlsModuleBinds::class](-mls-module-binds/index.md), [MlsModuleProvides::class](-mls-module-provides/index.md)])<br>class [MlsUiModule](-mls-ui-module/index.md) |
