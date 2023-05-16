package tv.mycujoo.mcls.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import timber.log.Timber
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.mediator.AnnotationManager
import tv.mycujoo.mcls.tv.databinding.FragmentMlsTvBinding
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclsima.Ima
import tv.mycujoo.mclsplayer.tv.MCLSTVPlayer
import tv.mycujoo.mclsplayer.tv.ui.MCLSPlayerFragment

class MCLSTVFragment : Fragment() {

    private val playerFragment = MCLSPlayerFragment()

    lateinit var uiBinding: FragmentMlsTvBinding

    var player: MCLSTVPlayer? = null

    lateinit var annotationManager: AnnotationManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        uiBinding = FragmentMlsTvBinding.inflate(layoutInflater, container, false)

        childFragmentManager
            .beginTransaction()
            .replace(uiBinding.playbackFragmentHost.id, playerFragment)
            .commit()

        val imaVodAdUnit = arguments?.getString(IMA_AD_UNIT_VOD) ?: getString(R.string.ima_adunit_vod)
        val imaLiveAdUnit = arguments?.getString(IMA_AD_UNIT_LIVE) ?: getString(R.string.ima_adunit_live)

        annotationManager = AnnotationManager.Builder()
            .withContext(requireContext())
            .withAnnotationView(uiBinding.annotationView)
            .build()

        player = MCLSTVPlayer.Builder()
            .withContext(requireContext())
            .withMCLSTvFragment(playerFragment)
            .withLifecycle(lifecycle)
            .withIma(Ima(
                adUnit = imaVodAdUnit,
                liveAdUnit = imaLiveAdUnit,
                paramProvider = {
                    buildMap {
                    }
                }
            ))
            .build()

        annotationManager.attachPlayer(object : VideoPlayer {
            override fun currentPosition(): Long {
                val player = player ?: return -1

                if (player.isPlayingAd()) {
                    return -1
                }

                return player.currentPosition()
            }
        })

        return uiBinding.root
    }

    fun playEvent(event: MCLSEvent) {
        val player = player ?: throw IllegalStateException("Please use this method after OnCreate")

        Timber.d("Playing Event")
        player.playEvent(event)
    }

    fun setAnnotationActions(actions: List<AnnotationAction>) {
        annotationManager.setActions(actions)
    }

    companion object {
        const val IMA_AD_UNIT_VOD = "ima_adunit_vod"
        const val IMA_AD_UNIT_LIVE = "ima_adunit_live"
    }
}