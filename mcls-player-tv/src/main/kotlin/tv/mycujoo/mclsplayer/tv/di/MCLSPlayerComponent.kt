package tv.mycujoo.mclsplayer.tv.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tv.mycujoo.mclsplayer.tv.MCLSTVPlayer
import tv.mycujoo.mclsplayer.tv.ui.MCLSTVFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MCLSPlayerModule::class
    ]
)
interface MCLSPlayerComponent {

    @Component.Builder
    interface Builder {

//        @BindsInstance
//        fun bindMCLSTVPlayer(MCLSTVPlayer: MCLSTVPlayer): Builder

        @BindsInstance
        fun bindContext(context: Context): Builder

        @BindsInstance
        fun bindMCLSTvFragment(mclsTvFragment: MCLSTVFragment): Builder

        fun build(): MCLSPlayerComponent
    }

    fun inject(playerTV: MCLSTVPlayer.Builder)
}