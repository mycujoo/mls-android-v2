//[mcls-annotations](../../index.md)/[tv.mycujoo.annotation.di](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [CountingIdlingResourceViewIdentifierManager](-counting-idling-resource-view-identifier-manager/index.md) | [androidJvm]<br>@Qualifier<br>annotation class [CountingIdlingResourceViewIdentifierManager](-counting-idling-resource-view-identifier-manager/index.md) |
| [MCLSAnnotationBinds](-m-c-l-s-annotation-binds/index.md) | [androidJvm]<br>@Module<br>interface [MCLSAnnotationBinds](-m-c-l-s-annotation-binds/index.md) |
| [MCLSAnnotationModule](-m-c-l-s-annotation-module/index.md) | [androidJvm]<br>@Module(includes = [[MCLSAnnotationBinds::class](-m-c-l-s-annotation-binds/index.md), [MCLSAnnotationProvides::class](-m-c-l-s-annotation-provides/index.md)])<br>class [MCLSAnnotationModule](-m-c-l-s-annotation-module/index.md) |
| [MCLSAnnotationProvides](-m-c-l-s-annotation-provides/index.md) | [androidJvm]<br>@Module<br>class [MCLSAnnotationProvides](-m-c-l-s-annotation-provides/index.md) |
| [MCLSAnnotationsComponent](-m-c-l-s-annotations-component/index.md) | [androidJvm]<br>@Singleton<br>@Component(modules = [[MCLSAnnotationModule::class](-m-c-l-s-annotation-module/index.md)])<br>interface [MCLSAnnotationsComponent](-m-c-l-s-annotations-component/index.md) |
