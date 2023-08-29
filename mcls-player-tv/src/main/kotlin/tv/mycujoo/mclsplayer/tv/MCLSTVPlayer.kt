package tv.mycujoo.mclsplayer.tv

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.ExoPlayer
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclsplayer.tv.di.DaggerMCLSTVPlayerComponent
import tv.mycujoo.mclsima.IIma
import tv.mycujoo.mclsplayer.tv.player.TvVideoPlayer
import tv.mycujoo.mclsplayer.tv.ui.MCLSPlayerFragment
import java.lang.IllegalStateException
import javax.inject.Inject

interface MCLSTVPlayer : DefaultLifecycleObserver {

    fun playEvent(event: MCLSEvent, defaultStreamId: String? = null)

    fun currentPosition(): Long

    fun isPlayingAd(): Boolean

    class Builder {
        @Inject
        lateinit var mclsPlayer: MCLSTVPlayer

        private var activity: FragmentActivity? = null
        private var mclsTvFragment: MCLSPlayerFragment? = null
        private var lifecycle: Lifecycle? = null
        private var ima: IIma? = null

        fun withContext(context: FragmentActivity) = apply {
            this.activity = context
        }

        fun withLifecycle(lifecycle: Lifecycle) = apply {
            this.lifecycle = lifecycle
        }

        fun withMCLSTvFragment(mclsTvFragment: MCLSPlayerFragment) = apply {
            this.mclsTvFragment = mclsTvFragment
        }

        fun withIma(ima: IIma) = apply {
            this.ima = ima
        }

        fun build(): MCLSTVPlayer {

            val activity = activity
                ?: throw IllegalStateException("Please use withContext before using this method")

            val mclsTvFragment = mclsTvFragment
                ?: throw IllegalStateException("Please use withMCLSTvFragment before using this method")

            val lifecycle = lifecycle
                ?: throw IllegalStateException("Please use withLifecycle before using this method")

            DaggerMCLSTVPlayerComponent.builder()
                .bindActivity(activity)
                .bindMCLSTvFragment(mclsTvFragment)
                .bindIma(ima)
                .build()
                .inject(this)

            lifecycle.addObserver(mclsPlayer)

            return mclsPlayer
        }
    }
}

class MCLSTVPlayerImpl @Inject constructor(
    private val videoPlayer: TvVideoPlayer,
    private val mMCLSTVFragment: MCLSPlayerFragment,
    private val exoPlayer: ExoPlayer
) : MCLSTVPlayer {

    var currentEvent: MCLSEvent? = null
    var defaultStreamId: String? = null

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        videoPlayer.initialize(mMCLSTVFragment)
        currentEvent?.let {
            videoPlayer.playVideo(it, defaultStreamId)
        }
    }

    override fun playEvent(event: MCLSEvent, defaultStreamId: String?) {
        currentEvent = event
        this.defaultStreamId = defaultStreamId
        videoPlayer.playVideo(event, defaultStreamId)
    }

    override fun currentPosition(): Long {
        return exoPlayer.currentPosition
    }

    override fun isPlayingAd(): Boolean {
        return exoPlayer.isPlayingAd
    }
}
