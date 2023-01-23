package tv.mycujoo.mclscast.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import tv.mycujoo.mclscast.manager.CastListenerManager
import tv.mycujoo.mclscast.manager.CastListenerManagerImpl
import tv.mycujoo.mclscast.player.MCLSCastPlayer
import tv.mycujoo.mclscast.player.CastPlayer
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclscore.logger.Logger
import javax.inject.Singleton

@Module(
    includes = [
        MCLSCastModuleBinds::class,
        MCLSCastModuleProvides::class
    ]
)
interface MCLSCastModule

@Module
class MCLSCastModuleProvides {
    @Singleton
    @Provides
    fun provideLogger(): Logger {
        return Logger(logLevel = LogLevel.MINIMAL)
    }
}

@Module
interface MCLSCastModuleBinds {

    @Binds
    @Singleton
    fun bindRemotePlayer(remotePlayer: MCLSCastPlayer): CastPlayer

    @Binds
    @Singleton
    fun bindCastListenersManager(castListenerManagerImpl: CastListenerManagerImpl): CastListenerManager
}