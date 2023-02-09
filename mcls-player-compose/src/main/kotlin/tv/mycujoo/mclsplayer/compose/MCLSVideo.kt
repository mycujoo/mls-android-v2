package tv.mycujoo.mclsplayer.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclsplayer.player.MCLSPlayer
import tv.mycujoo.mclsplayer.player.widget.MCLSPlayerView

class MCLSVideo {

    var mclsPlayer: MCLSPlayer? = null

    @Composable
    fun MCLSPlayerView(modifier: Modifier = Modifier) {
        AndroidView(
            factory = { context ->
                val playerView = MCLSPlayerView(context)

                if (mclsPlayer == null) {
                    mclsPlayer = MCLSPlayer.Builder()
                        .withContext(context)
                        .withPlayerView(playerView)
                        .build()
                }

                playerView
            },
            modifier = modifier
        )
    }

    fun playEvent(event: MCLSEvent) {
        mclsPlayer?.playEvent(event)
    }

    @Composable
    fun MCLSPlayerViewPreview() {
        MCLSPlayerView()
    }
}
