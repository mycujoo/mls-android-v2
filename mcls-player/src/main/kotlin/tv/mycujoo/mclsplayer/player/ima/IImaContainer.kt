package tv.mycujoo.mclsplayer.player.ima

import android.content.Context
import tv.mycujoo.mclsplayer.player.utils.ExoPlayerContainer
import tv.mycujoo.mclsplayer.player.widget.IMCLSPlayerView
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IImaContainer @Inject constructor(
    iima: IIma?,
    private val playerView: IMCLSPlayerView,
    private val context: Context,
    private val exoPlayerContainer: ExoPlayerContainer,
) {

    var ima: IIma? = null
        set(value) {
            field = value
            field?.createAdsLoader(context)
            field?.setAdViewProvider(playerView.getPlayerView())
            exoPlayerContainer.exoPlayer?.let {
                field?.setPlayer(it)
            }
        }

    init {
        ima = iima
        ima?.setAdViewProvider(playerView.getPlayerView())
        ima?.createAdsLoader(context = context)
        exoPlayerContainer.exoPlayer?.let {
            ima?.setPlayer(it)
        }
    }
}
