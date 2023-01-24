---
title: tv.mycujoo.annotation.manager
---
//[mcls-annotations](../../index.html)/[tv.mycujoo.annotation.manager](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [ITimer](-i-timer/index.html) | [androidJvm]<br>interface [ITimer](-i-timer/index.html) |
| [IVariableKeeper](-i-variable-keeper/index.html) | [androidJvm]<br>interface [IVariableKeeper](-i-variable-keeper/index.html) |
| [Logger](-logger/index.html) | [androidJvm]<br>class [Logger](-logger/index.html)@Injectconstructor(logLevel: [LogLevel](../tv.mycujoo.annotation.domain.enum/-log-level/index.html)) |
| [TimerEntity](-timer-entity/index.html) | [androidJvm]<br>sealed class [TimerEntity](-timer-entity/index.html) |
| [TimerVariable](-timer-variable/index.html) | [androidJvm]<br>class [TimerVariable](-timer-variable/index.html)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), format: ScreenTimerFormat, direction: ScreenTimerDirection, startValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), capValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [ITimer](-i-timer/index.html) |
| [VariableKeeper](-variable-keeper/index.html) | [androidJvm]<br>@Singleton<br>class [VariableKeeper](-variable-keeper/index.html)@Injectconstructor(dispatcher: CoroutineScope) : [IVariableKeeper](-i-variable-keeper/index.html) |
| [ViewHandler](-view-handler/index.html) | [androidJvm]<br>open class [ViewHandler](-view-handler/index.html)@Injectconstructor(val idlingResource: [CountingIdlingResource](https://developer.android.com/reference/kotlin/androidx/test/espresso/idling/CountingIdlingResource.html), overlayHost: [IAnnotationView](../tv.mycujoo.annotation.annotation/-i-annotation-view/index.html)) : [IViewHandler](../tv.mycujoo.annotation.helper/-i-view-handler/index.html) |

