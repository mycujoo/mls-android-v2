package tv.mycujoo.mclsplayer.player.di

import android.content.Context
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
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclsplayer.player.mediator.VideoPlayerMediator
import tv.mycujoo.mclsplayer.player.mediator.VideoPlayerMediatorImpl
import tv.mycujoo.mclsplayer.player.model.MediaFactory
import tv.mycujoo.mclsplayer.player.player.ISegmentProcessor
import tv.mycujoo.mclsplayer.player.player.Player
import tv.mycujoo.mclsplayer.player.player.PlayerImpl
import tv.mycujoo.mclsplayer.player.player.SegmentProcessor
import tv.mycujoo.mclsplayer.player.user.User
import javax.inject.Singleton

@Module(
    includes = [
        MCLSPlayerModuleProvides::class,
        MCLSPlayerModuleBinds::class
    ]
)
interface MCLSPlayerModule

@Module
class MCLSPlayerModuleProvides {

    @Singleton
    @Provides
    fun provideUser(): User {
        return User()
    }

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
    fun provideOkHttpClient(): OkHttpClient {
        // I'm using the builder to allow Logging interceptor to be injected here
        return OkHttpClient
            .Builder()
            .build()
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
    fun provideLogger(logLevel: LogLevel): Logger {
        return Logger(
            logLevel = logLevel
        )
    }
}

@Module
interface MCLSPlayerModuleBinds {
    @Binds
    @Singleton
    fun bindSegmentProcessor(segmentProcessor: SegmentProcessor): ISegmentProcessor

    @Binds
    @Singleton
    fun bindMCLSPlayer(mclsPlayer: PlayerImpl): Player

    @Binds
    @Singleton
    fun bindMCLSPlayerMediator(playerMediator: VideoPlayerMediatorImpl): VideoPlayerMediator
}