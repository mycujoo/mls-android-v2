package tv.mycujoo.mcls

import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import dagger.Module
import dagger.Provides
import tv.mycujoo.mcls.player.MediaFactory
import javax.inject.Singleton

@Module(
    includes = [
        MCLSPlayerViewModuleBinds::class,
        MCLSPlayerViewModuleProvides::class,
    ]
)
interface MCLSPlayerViewModule

@Module
class MCLSPlayerViewModuleProvides {
    @Provides
    @Singleton
    fun provideMediaFactory(
        mediaSourceFactory: DefaultMediaSourceFactory,
        hlsMediaSource: HlsMediaSource.Factory
    ): MediaFactory {
        return MediaFactory(
            mediaSourceFactory,
            hlsMediaSource,
            MediaItem.Builder()
        )
    }
}

@Module
interface MCLSPlayerViewModuleBinds {

}