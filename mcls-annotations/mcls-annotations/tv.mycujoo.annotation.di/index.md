---
title: tv.mycujoo.annotation.di
---
//[mcls-annotations](../../index.html)/[tv.mycujoo.annotation.di](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [CountingIdlingResourceViewIdentifierManager](-counting-idling-resource-view-identifier-manager/index.html) | [androidJvm]<br>@Qualifier<br>annotation class [CountingIdlingResourceViewIdentifierManager](-counting-idling-resource-view-identifier-manager/index.html) |
| [MCLSAnnotationBinds](-m-c-l-s-annotation-binds/index.html) | [androidJvm]<br>@Module<br>interface [MCLSAnnotationBinds](-m-c-l-s-annotation-binds/index.html) |
| [MCLSAnnotationModule](-m-c-l-s-annotation-module/index.html) | [androidJvm]<br>@Module(includes = [[MCLSAnnotationBinds::class](-m-c-l-s-annotation-binds/index.html), [MCLSAnnotationProvides::class](-m-c-l-s-annotation-provides/index.html)])<br>class [MCLSAnnotationModule](-m-c-l-s-annotation-module/index.html) |
| [MCLSAnnotationProvides](-m-c-l-s-annotation-provides/index.html) | [androidJvm]<br>@Module<br>class [MCLSAnnotationProvides](-m-c-l-s-annotation-provides/index.html) |
| [MCLSAnnotationsComponent](-m-c-l-s-annotations-component/index.html) | [androidJvm]<br>@Singleton<br>@Component(modules = [[MCLSAnnotationModule::class](-m-c-l-s-annotation-module/index.html)])<br>interface [MCLSAnnotationsComponent](-m-c-l-s-annotations-component/index.html) |

