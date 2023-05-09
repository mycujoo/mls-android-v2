package tv.mycujoo.mclsplayer.tv.ima

import android.content.Context
import com.google.android.exoplayer2.ui.StyledPlayerView
import tv.mycujoo.mclsplayer.tv.player.IPlayer
import tv.mycujoo.mclsplayer.tv.utils.ExoPlayerContainer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IImaContainer @Inject constructor(
    iima: IIma?,
    private val context: Context,
    private val exoPlayerContainer: ExoPlayerContainer,
    private val playerView: StyledPlayerView
) {

    var ima: IIma? = null
        set(value) {
            field = value
            exoPlayerContainer.exoPlayer?.let { player ->
                field?.prepare(context, playerView, player)
            }
        }

    init {
        ima = iima
    }
}
