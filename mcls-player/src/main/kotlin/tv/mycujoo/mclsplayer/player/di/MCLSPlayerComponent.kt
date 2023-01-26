package tv.mycujoo.mclsplayer.player.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tv.mycujoo.mclsplayer.player.MCLSPlayer
import tv.mycujoo.mclsplayer.player.analytics.AnalyticsClient
import tv.mycujoo.mclsplayer.player.ima.IIma
import tv.mycujoo.mclsplayer.player.ima.IImaContainer
import tv.mycujoo.mclsplayer.player.utils.ExoPlayerContainer
import tv.mycujoo.mclsplayer.player.widget.IMCLSPlayerView
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
        @BindsInstance
        fun bindExoPlayerContainer(exoPlayerContainer: ExoPlayerContainer): Builder

        @BindsInstance
        fun bindContext(context: Context): Builder

        @BindsInstance
        fun bindMCLSPlayerView(mclsPlayerView: IMCLSPlayerView): Builder

        @BindsInstance
        fun bindIma(ima: IIma?): Builder

        fun bindAnalyticsClient(analyticsClient: AnalyticsClient?):Builder

        fun build(): MCLSPlayerComponent
    }

    fun inject(mMCLSPlayer: MCLSPlayer)
}