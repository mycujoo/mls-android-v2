package tv.mycujoo.mclsplayer.player.di

import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import tv.mycujoo.mclsplayer.player.mediator.VideoPlayerMediator
import tv.mycujoo.mclsplayer.player.mediator.VideoPlayerMediatorImpl
import tv.mycujoo.mclsplayer.player.model.MediaFactory
import tv.mycujoo.mclsplayer.player.player.ISegmentProcessor
import tv.mycujoo.mclsplayer.player.player.Player
import tv.mycujoo.mclsplayer.player.player.PlayerImpl
import tv.mycujoo.mclsplayer.player.player.SegmentProcessor
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
        hlsMediaSource: HlsMediaSource.Factory
    ): MediaFactory {
        return MediaFactory(
            hlsMediaSource,
            MediaItem.Builder()
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