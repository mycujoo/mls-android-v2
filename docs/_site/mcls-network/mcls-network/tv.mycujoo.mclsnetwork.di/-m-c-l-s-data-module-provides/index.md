//[mcls-network](../../../index.md)/[tv.mycujoo.mclsnetwork.di](../index.md)/[MCLSDataModuleProvides](index.md)

# MCLSDataModuleProvides

[androidJvm]\
@Module

class [MCLSDataModuleProvides](index.md)

## Constructors

| | |
|---|---|
| [MCLSDataModuleProvides](-m-c-l-s-data-module-provides.md) | [androidJvm]<br>fun [MCLSDataModuleProvides](-m-c-l-s-data-module-provides.md)() |

## Functions

| Name | Summary |
|---|---|
| [provideConcurrencySocketUrl](provide-concurrency-socket-url.md) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideConcurrencySocketUrl](provide-concurrency-socket-url.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [provideGlobalScope](provide-global-scope.md) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideGlobalScope](provide-global-scope.md)(): CoroutineScope |
| [provideLogger](provide-logger.md) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideLogger](provide-logger.md)(): Logger |
| [provideLogLevel](provide-log-level.md) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideLogLevel](provide-log-level.md)(): LogLevel |
| [provideReactorSocketUrl](provide-reactor-socket-url.md) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideReactorSocketUrl](provide-reactor-socket-url.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [provideSharedPreferences](provide-shared-preferences.md) | [androidJvm]<br>@Provides<br>@Singleton<br>fun [provideSharedPreferences](provide-shared-preferences.md)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [SharedPreferences](https://developer.android.com/reference/kotlin/android/content/SharedPreferences.html) |
