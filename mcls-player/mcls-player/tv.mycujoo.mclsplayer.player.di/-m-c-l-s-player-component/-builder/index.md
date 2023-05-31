---
title: Builder
---
//[mcls-player](../../../../index.html)/[tv.mycujoo.mclsplayer.player.di](../../index.html)/[MCLSPlayerComponent](../index.html)/[Builder](index.html)



# Builder



[androidJvm]\
@Component.Builder



interface [Builder](index.html)



## Functions


| Name | Summary |
|---|---|
| [bindActivity](bind-activity.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindActivity](bind-activity.html)(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html)): [MCLSPlayerComponent.Builder](index.html) |
| [bindContext](bind-context.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindContext](bind-context.html)(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [MCLSPlayerComponent.Builder](index.html) |
| [bindExoPlayerContainer](bind-exo-player-container.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindExoPlayerContainer](bind-exo-player-container.html)(exoPlayerContainer: [ExoPlayerContainer](../../../tv.mycujoo.mclsplayer.player.utils/-exo-player-container/index.html)): [MCLSPlayerComponent.Builder](index.html) |
| [bindIma](bind-ima.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindIma](bind-ima.html)(ima: IIma?): [MCLSPlayerComponent.Builder](index.html) |
| [bindLogLevel](bind-log-level.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindLogLevel](bind-log-level.html)(logLevel: LogLevel): [MCLSPlayerComponent.Builder](index.html) |
| [bindMCLSPlayerView](bind-m-c-l-s-player-view.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindMCLSPlayerView](bind-m-c-l-s-player-view.html)(mclsPlayerView: [IMCLSPlayerView](../../../tv.mycujoo.mclsplayer.player.widget/-i-m-c-l-s-player-view/index.html)): [MCLSPlayerComponent.Builder](index.html) |
| [bindYouboraAccountCode](bind-youbora-account-code.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindYouboraAccountCode](bind-youbora-account-code.html)(youboraAccountCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MCLSPlayerComponent.Builder](index.html) |
| [build](build.html) | [androidJvm]<br>abstract fun [build](build.html)(): [MCLSPlayerComponent](../index.html) |

