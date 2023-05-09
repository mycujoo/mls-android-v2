package tv.mycujoo.mclsplayer.tv.di

import com.google.android.exoplayer2.ui.StyledPlayerView
import dagger.BindsInstance
import dagger.Component
import tv.mycujoo.mclsplayer.tv.MCLSTVPlayer
import javax.inject.Singleton

@Singleton
@Component
interface MCLSPlayerComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindStyledPlayerView(styledPlayerView: StyledPlayerView): Builder

        @BindsInstance
        fun bindMCLSTVPlayer(MCLSTVPlayer: MCLSTVPlayer): Builder

        fun build(): MCLSPlayerComponent
    }

    fun inject(playerTV: MCLSTVPlayer.Builder)
}