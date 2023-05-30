package tv.mycujoo.mclsplayer.compose

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.view.View
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
                    mclsPlayer = getActivityFromViewContext(context)?.let {
                        MCLSPlayer.Builder()
                            .withContext(context)
                            .withPlayerView(playerView)
                            .withActivity(it)
                            .build()
                    }
                }

                playerView
            },
            modifier = modifier
        )
    }

    fun getActivityFromViewContext(ctx: Context): Activity? {
        var context = ctx
        while (context is ContextWrapper) {
            if (context is Activity) {
                return context
            }
            context = context.baseContext
        }
        return null
    }

    fun playEvent(event: MCLSEvent) {
        mclsPlayer?.playEvent(event)
    }

    @Composable
    fun MCLSPlayerViewPreview() {
        MCLSPlayerView()
    }
}
