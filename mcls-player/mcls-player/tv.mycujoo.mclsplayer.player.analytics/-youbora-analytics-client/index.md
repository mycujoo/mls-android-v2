---
title: YouboraAnalyticsClient
---
//[mcls-player](../../../index.html)/[tv.mycujoo.mclsplayer.player.analytics](../index.html)/[YouboraAnalyticsClient](index.html)



# YouboraAnalyticsClient



[androidJvm]\
@Singleton



class [YouboraAnalyticsClient](index.html)@Injectconstructor(val activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html), val exoPlayerContainer: [ExoPlayerContainer](../../tv.mycujoo.mclsplayer.player.utils/-exo-player-container/index.html), val accountCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), logger: Logger, user: [UserPrefs](../../tv.mycujoo.mclsplayer.player.user/-user-prefs/index.html))



## Constructors


| | |
|---|---|
| [YouboraAnalyticsClient](-youbora-analytics-client.html) | [androidJvm]<br>@Inject<br>constructor(activity: [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html), exoPlayerContainer: [ExoPlayerContainer](../../tv.mycujoo.mclsplayer.player.utils/-exo-player-container/index.html), accountCode: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), logger: Logger, user: [UserPrefs](../../tv.mycujoo.mclsplayer.player.user/-user-prefs/index.html)) |


## Types


| Name | Summary |
|---|---|
| [Companion](-companion/index.html) | [androidJvm]<br>object [Companion](-companion/index.html)<br>endregion |


## Functions


| Name | Summary |
|---|---|
| [initialize](initialize.html) | [androidJvm]<br>fun [initialize](initialize.html)() |
| [logEvent](log-event.html) | [androidJvm]<br>fun [logEvent](log-event.html)(MCLSEvent: MCLSEvent) |
| [setup](setup.html) | [androidJvm]<br>fun [setup](setup.html)(videoAnalyticsCustomData: [VideoAnalyticsCustomData](../-video-analytics-custom-data/index.html)) |


## Properties


| Name | Summary |
|---|---|
| [accountCode](account-code.html) | [androidJvm]<br>val [accountCode](account-code.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [activity](activity.html) | [androidJvm]<br>val [activity](activity.html): [Activity](https://developer.android.com/reference/kotlin/android/app/Activity.html) |
| [exoPlayerContainer](exo-player-container.html) | [androidJvm]<br>val [exoPlayerContainer](exo-player-container.html): [ExoPlayerContainer](../../tv.mycujoo.mclsplayer.player.utils/-exo-player-container/index.html) |
| [videoAnalyticsCustomData](video-analytics-custom-data.html) | [androidJvm]<br>var [videoAnalyticsCustomData](video-analytics-custom-data.html): [VideoAnalyticsCustomData](../-video-analytics-custom-data/index.html)? |

