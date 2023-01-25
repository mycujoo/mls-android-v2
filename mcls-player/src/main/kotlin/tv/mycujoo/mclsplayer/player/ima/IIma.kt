package tv.mycujoo.mclsplayer.player.ima

import android.content.Context
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.ui.AdViewProvider
import com.google.android.exoplayer2.ui.StyledPlayerView

interface IIma {

    fun getAdUnit(): String

    fun createAdsLoader(context: Context)

    fun setAdsLoaderProvider(
        defaultMediaSourceFactory: DefaultMediaSourceFactory,
        styledPlayerView: StyledPlayerView
    )

    fun setPlayer(player: Player)

    fun setAdViewProvider(adViewProvider: AdViewProvider)

    fun createMediaSource(
        defaultMediaSourceFactory: DefaultMediaSourceFactory,
        hlsMediaSource: MediaSource,
        imaCustomParams: ImaCustomParams
    ): MediaSource

    fun onStop()
    fun onDestroy()
}