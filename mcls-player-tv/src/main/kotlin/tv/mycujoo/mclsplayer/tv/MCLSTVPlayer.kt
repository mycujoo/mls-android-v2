package tv.mycujoo.mclsplayer.tv

import android.content.Context
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclsplayer.tv.di.DaggerMCLSTVPlayerComponent
import tv.mycujoo.mclsima.IIma
import tv.mycujoo.mclsplayer.tv.player.TvVideoPlayer
import tv.mycujoo.mclsplayer.tv.ui.MCLSTVFragment
import java.lang.IllegalStateException
import javax.inject.Inject

interface MCLSTVPlayer : DefaultLifecycleObserver {

    fun playEvent(event: MCLSEvent)

    class Builder {
        @Inject
        lateinit var mclsPlayer: MCLSTVPlayer

        private var context: Context? = null
        private var mclsTvFragment: MCLSTVFragment? = null
        private var lifecycle: Lifecycle? = null
        private var ima: IIma? = null

        fun withContext(context: Context) = apply {
            this.context = context
        }

        fun withLifecycle(lifecycle: Lifecycle) = apply {
            this.lifecycle = lifecycle
        }

        fun withMCLSTvFragment(mclsTvFragment: MCLSTVFragment) = apply {
            this.mclsTvFragment = mclsTvFragment
        }

        fun withIma(ima: IIma) = apply {
            this.ima = ima
        }

        fun build(): MCLSTVPlayer {

            val context = context ?: throw IllegalStateException("Please use withContext before using this method")

            val mclsTvFragment = mclsTvFragment ?: throw IllegalStateException("Please use withMCLSTvFragment before using this method")

            val lifecycle = lifecycle ?: throw
                    IllegalStateException("Please use withLifecycle before using this method")

            DaggerMCLSTVPlayerComponent.builder()
                .bindContext(context)
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
    private val mMCLSTVFragment: MCLSTVFragment,
) : MCLSTVPlayer {

    var currentEvent: MCLSEvent? = null

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        videoPlayer.initialize(mMCLSTVFragment)
        currentEvent?.let {
            videoPlayer.playVideo(it)
        }
    }

    override fun playEvent(event: MCLSEvent) {
        currentEvent = event

    }
}
