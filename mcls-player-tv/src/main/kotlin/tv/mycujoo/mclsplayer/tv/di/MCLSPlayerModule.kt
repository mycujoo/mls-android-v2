package tv.mycujoo.mclsplayer.tv.di

import android.content.Context
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import tv.mycujoo.mclsplayer.tv.MCLSTVPlayer
import tv.mycujoo.mclsplayer.tv.MCLSTVPlayerImpl
import tv.mycujoo.mclsplayer.tv.player.IPlayer
import tv.mycujoo.mclsplayer.tv.player.MediaFactory
import tv.mycujoo.mclsplayer.tv.player.Player
import javax.inject.Singleton

@Module(
    includes = [
        MCLSPlayerModuleBinds::class,
        MCLSPlayerModuleProvides::class,
    ]
)
class MCLSPlayerModule

@Module
interface MCLSPlayerModuleBinds {
    @Singleton
    @Binds
    fun bindMCLSTVPlayer(mclsTvPlayer: MCLSTVPlayerImpl): MCLSTVPlayer

    @Singleton
    @Binds
    fun bindPlayer(player: Player): IPlayer
}

@Module
class MCLSPlayerModuleProvides {

    @Singleton
    @Provides
    fun provideDefaultMediaSourceFactory(
        context: Context
    ): DefaultMediaSourceFactory {
        val httpSourceFactory = DefaultHttpDataSource
            .Factory()
            .setAllowCrossProtocolRedirects(true)

        val source = DefaultDataSource.Factory(
            context,
            httpSourceFactory
        )

        return DefaultMediaSourceFactory(source)
    }

    @Singleton
    @Provides
    fun provideHlsMediaSource(
        okHttpClient: OkHttpClient
    ): HlsMediaSource.Factory {
        return HlsMediaSource.Factory(
            OkHttpDataSource.Factory(okHttpClient)
        )
    }

    @Provides
    @Singleton
    fun provideMediaFactory(
        hlsMediaSource: HlsMediaSource.Factory,
        defaultMediaSourceFactory: DefaultMediaSourceFactory,
    ): MediaFactory {
        return MediaFactory(
            defaultMediaSourceFactory,
            hlsMediaSource,
            MediaItem.Builder()
        )
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        // I'm using the builder to allow Logging interceptor to be injected here
        return OkHttpClient
            .Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideExoPlayer(context: Context): ExoPlayer {
        return ExoPlayer.Builder(context)
            .build()
    }
}