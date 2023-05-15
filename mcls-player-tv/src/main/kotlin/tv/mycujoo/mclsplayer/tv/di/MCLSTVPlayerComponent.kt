package tv.mycujoo.mclsplayer.tv.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tv.mycujoo.mclsima.IIma
import tv.mycujoo.mclsplayer.tv.MCLSTVPlayer
import tv.mycujoo.mclsplayer.tv.ui.MCLSPlayerFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MCLSPlayerModule::class
    ]
)
interface MCLSTVPlayerComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindContext(context: Context): Builder

        @BindsInstance
        fun bindMCLSTvFragment(mclsTvFragment: MCLSPlayerFragment): Builder

        @BindsInstance
        fun bindIma(ima: IIma?): Builder

        fun build(): MCLSTVPlayerComponent
    }

    fun inject(playerTV: MCLSTVPlayer.Builder)
}