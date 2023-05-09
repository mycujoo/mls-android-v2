package tv.mycujoo.mclsplayer.tv

import com.google.android.exoplayer2.ui.StyledPlayerView
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclsplayer.tv.di.DaggerMCLSPlayerComponent
import tv.mycujoo.mclsplayer.tv.player.TvVideoPlayer
import tv.mycujoo.mclsplayer.tv.ui.MCLSTVFragment
import javax.inject.Inject

interface MCLSTVPlayer {

    fun playEvent(event: MCLSEvent)

    class Builder {
        @Inject
        lateinit var mclsPlayer: MCLSTVPlayer

        private var styledPlayerView: StyledPlayerView? = null
        private var mMCLSTVPlayer: MCLSTVPlayer? = null

        fun withMCLSTVPlayer(MCLSTVPlayer: MCLSTVPlayer) = apply {
            this.mMCLSTVPlayer = MCLSTVPlayer
        }

        fun withStyledPlayerView(styledPlayerView: StyledPlayerView) = apply {
            this.styledPlayerView = styledPlayerView
        }

        fun build(): MCLSTVPlayer {
            val styledPlayerView = styledPlayerView
                ?: throw Exception("Please set withStyledPlayerView before building this component")

            val mMCLSTVPlayer = mMCLSTVPlayer
                ?: throw Exception("Please set withMCLSTVPlayer before building this component")

            DaggerMCLSPlayerComponent.builder()
                .bindStyledPlayerView(styledPlayerView)
                .bindMCLSTVPlayer(mMCLSTVPlayer)
                .build()
                .inject(this)

            return mclsPlayer
        }
    }
}

class MCLSTVPlayerImpl @Inject constructor(
    private val videoPlayer: TvVideoPlayer,
    mMCLSTVFragment: MCLSTVFragment,
) : MCLSTVPlayer {

    init {
        videoPlayer.initialize(mMCLSTVFragment)
    }

    override fun playEvent(event: MCLSEvent) {
        videoPlayer.playVideo(event)
    }
}
