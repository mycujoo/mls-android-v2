package tv.mycujoo.mclscast.di

import dagger.Binds
import dagger.Module
import tv.mycujoo.mclscast.player.MCLSCastPlayer
import tv.mycujoo.mclscast.player.RemotePlayer
import tv.mycujoo.mclscast.widget.IRemotePlayerView
import tv.mycujoo.mclscast.widget.RemotePlayerView
import javax.inject.Singleton

@Module(
    includes = [
        MCLSCastModuleBinds::class,
        MCLSCastModuleProvides::class
    ]
)
interface MCLSCastModule

@Module
class MCLSCastModuleProvides

@Module
interface MCLSCastModuleBinds {

    @Binds
    @Singleton
    fun bindRemotePlayer(remotePlayer: MCLSCastPlayer): RemotePlayer
}