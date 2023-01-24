---
title: CastSessionManager
---
//[mcls-cast](../../../index.html)/[tv.mycujoo.mclscast.manager](../index.html)/[CastSessionManager](index.html)



# CastSessionManager



[androidJvm]\
@Singleton



class [CastSessionManager](index.html)@Injectconstructor(playerView: [IRemotePlayerView](../../tv.mycujoo.mclscast.widget/-i-remote-player-view/index.html)?, castListenerManager: [CastListenerManagerImpl](../-cast-listener-manager-impl/index.html), logger: Logger) : SessionManagerListener&lt;CastSession&gt;



## Constructors


| | |
|---|---|
| [CastSessionManager](-cast-session-manager.html) | [androidJvm]<br>@Inject<br>fun [CastSessionManager](-cast-session-manager.html)(playerView: [IRemotePlayerView](../../tv.mycujoo.mclscast.widget/-i-remote-player-view/index.html)?, castListenerManager: [CastListenerManagerImpl](../-cast-listener-manager-impl/index.html), logger: Logger) |


## Functions


| Name | Summary |
|---|---|
| [getCurrentSession](get-current-session.html) | [androidJvm]<br>fun [getCurrentSession](get-current-session.html)(): CastSession? |
| [onSessionEnded](on-session-ended.html) | [androidJvm]<br>open override fun [onSessionEnded](on-session-ended.html)(p0: CastSession, p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [onSessionEnding](on-session-ending.html) | [androidJvm]<br>open override fun [onSessionEnding](on-session-ending.html)(p0: CastSession) |
| [onSessionResumed](on-session-resumed.html) | [androidJvm]<br>open override fun [onSessionResumed](on-session-resumed.html)(p0: CastSession, p1: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [onSessionResumeFailed](on-session-resume-failed.html) | [androidJvm]<br>open override fun [onSessionResumeFailed](on-session-resume-failed.html)(p0: CastSession, p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [onSessionResuming](on-session-resuming.html) | [androidJvm]<br>open override fun [onSessionResuming](on-session-resuming.html)(p0: CastSession, p1: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onSessionStarted](on-session-started.html) | [androidJvm]<br>open override fun [onSessionStarted](on-session-started.html)(p0: CastSession, p1: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onSessionStartFailed](on-session-start-failed.html) | [androidJvm]<br>open override fun [onSessionStartFailed](on-session-start-failed.html)(p0: CastSession, p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [onSessionStarting](on-session-starting.html) | [androidJvm]<br>open override fun [onSessionStarting](on-session-starting.html)(p0: CastSession) |
| [onSessionSuspended](on-session-suspended.html) | [androidJvm]<br>open override fun [onSessionSuspended](on-session-suspended.html)(p0: CastSession, p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |

