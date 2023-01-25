package tv.mycujoo.mclsplayer.player.ima

import android.content.Context
import timber.log.Timber
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
            exoPlayerContainer.exoPlayer?.let { player ->
                field?.prepare(context, playerView.getPlayerView(), player)
            }
        }

    init {
        ima = iima
    }
}
