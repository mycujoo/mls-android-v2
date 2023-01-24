---
title: Builder
---
//[mcls-cast](../../../../index.html)/[tv.mycujoo.mclscast.di](../../index.html)/[MCLSCastComponent](../index.html)/[Builder](index.html)



# Builder



[androidJvm]\
@Component.Builder



interface [Builder](index.html)



## Functions


| Name | Summary |
|---|---|
| [bindAppId](bind-app-id.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindAppId](bind-app-id.html)(appId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [MCLSCastComponent.Builder](index.html) |
| [bindCastContext](bind-cast-context.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindCastContext](bind-cast-context.html)(castContext: CastContext): [MCLSCastComponent.Builder](index.html) |
| [bindMediaRouteButton](bind-media-route-button.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindMediaRouteButton](bind-media-route-button.html)(mediaRouteButton: [MediaRouteButton](https://developer.android.com/reference/kotlin/androidx/mediarouter/app/MediaRouteButton.html)): [MCLSCastComponent.Builder](index.html) |
| [bindRemotePlayerView](bind-remote-player-view.html) | [androidJvm]<br>@BindsInstance<br>abstract fun [bindRemotePlayerView](bind-remote-player-view.html)(remotePlayerView: [IRemotePlayerView](../../../tv.mycujoo.mclscast.widget/-i-remote-player-view/index.html)?): [MCLSCastComponent.Builder](index.html) |
| [build](build.html) | [androidJvm]<br>abstract fun [build](build.html)(): [MCLSCastComponent](../index.html) |

