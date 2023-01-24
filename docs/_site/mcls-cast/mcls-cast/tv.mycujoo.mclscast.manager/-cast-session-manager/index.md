//[mcls-cast](../../../index.md)/[tv.mycujoo.mclscast.manager](../index.md)/[CastSessionManager](index.md)

# CastSessionManager

[androidJvm]\
@Singleton

class [CastSessionManager](index.md)@Injectconstructor(playerView: [IRemotePlayerView](../../tv.mycujoo.mclscast.widget/-i-remote-player-view/index.md)?, castListenerManager: [CastListenerManagerImpl](../-cast-listener-manager-impl/index.md), logger: Logger) : SessionManagerListener&lt;CastSession&gt;

## Constructors

| | |
|---|---|
| [CastSessionManager](-cast-session-manager.md) | [androidJvm]<br>@Inject<br>fun [CastSessionManager](-cast-session-manager.md)(playerView: [IRemotePlayerView](../../tv.mycujoo.mclscast.widget/-i-remote-player-view/index.md)?, castListenerManager: [CastListenerManagerImpl](../-cast-listener-manager-impl/index.md), logger: Logger) |

## Functions

| Name | Summary |
|---|---|
| [getCurrentSession](get-current-session.md) | [androidJvm]<br>fun [getCurrentSession](get-current-session.md)(): CastSession? |
| [onSessionEnded](on-session-ended.md) | [androidJvm]<br>open override fun [onSessionEnded](on-session-ended.md)(p0: CastSession, p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [onSessionEnding](on-session-ending.md) | [androidJvm]<br>open override fun [onSessionEnding](on-session-ending.md)(p0: CastSession) |
| [onSessionResumed](on-session-resumed.md) | [androidJvm]<br>open override fun [onSessionResumed](on-session-resumed.md)(p0: CastSession, p1: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [onSessionResumeFailed](on-session-resume-failed.md) | [androidJvm]<br>open override fun [onSessionResumeFailed](on-session-resume-failed.md)(p0: CastSession, p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [onSessionResuming](on-session-resuming.md) | [androidJvm]<br>open override fun [onSessionResuming](on-session-resuming.md)(p0: CastSession, p1: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onSessionStarted](on-session-started.md) | [androidJvm]<br>open override fun [onSessionStarted](on-session-started.md)(p0: CastSession, p1: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [onSessionStartFailed](on-session-start-failed.md) | [androidJvm]<br>open override fun [onSessionStartFailed](on-session-start-failed.md)(p0: CastSession, p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [onSessionStarting](on-session-starting.md) | [androidJvm]<br>open override fun [onSessionStarting](on-session-starting.md)(p0: CastSession) |
| [onSessionSuspended](on-session-suspended.md) | [androidJvm]<br>open override fun [onSessionSuspended](on-session-suspended.md)(p0: CastSession, p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
