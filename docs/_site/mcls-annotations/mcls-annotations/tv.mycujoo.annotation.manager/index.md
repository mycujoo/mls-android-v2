//[mcls-annotations](../../index.md)/[tv.mycujoo.annotation.manager](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [ITimer](-i-timer/index.md) | [androidJvm]<br>interface [ITimer](-i-timer/index.md) |
| [IVariableKeeper](-i-variable-keeper/index.md) | [androidJvm]<br>interface [IVariableKeeper](-i-variable-keeper/index.md) |
| [Logger](-logger/index.md) | [androidJvm]<br>class [Logger](-logger/index.md)@Injectconstructor(logLevel: [LogLevel](../tv.mycujoo.annotation.domain.enum/-log-level/index.md)) |
| [TimerEntity](-timer-entity/index.md) | [androidJvm]<br>sealed class [TimerEntity](-timer-entity/index.md) |
| [TimerVariable](-timer-variable/index.md) | [androidJvm]<br>class [TimerVariable](-timer-variable/index.md)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), format: ScreenTimerFormat, direction: ScreenTimerDirection, startValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), capValue: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [ITimer](-i-timer/index.md) |
| [VariableKeeper](-variable-keeper/index.md) | [androidJvm]<br>@Singleton<br>class [VariableKeeper](-variable-keeper/index.md)@Injectconstructor(dispatcher: CoroutineScope) : [IVariableKeeper](-i-variable-keeper/index.md) |
| [ViewHandler](-view-handler/index.md) | [androidJvm]<br>open class [ViewHandler](-view-handler/index.md)@Injectconstructor(val idlingResource: [CountingIdlingResource](https://developer.android.com/reference/kotlin/androidx/test/espresso/idling/CountingIdlingResource.html), overlayHost: [IAnnotationView](../tv.mycujoo.annotation.annotation/-i-annotation-view/index.md)) : [IViewHandler](../tv.mycujoo.annotation.helper/-i-view-handler/index.md) |
