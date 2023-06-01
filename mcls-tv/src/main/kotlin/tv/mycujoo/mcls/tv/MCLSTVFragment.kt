package tv.mycujoo.mcls.tv

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import timber.log.Timber
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.mediator.AnnotationManager
import tv.mycujoo.mcls.tv.databinding.FragmentMlsTvBinding
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclsima.IIma
import tv.mycujoo.mclsima.Ima
import tv.mycujoo.mclsnetwork.MCLSNetwork
import tv.mycujoo.mclsplayer.tv.MCLSTVPlayer
import tv.mycujoo.mclsplayer.tv.ui.MCLSPlayerFragment

class MCLSTVFragment : Fragment() {

    private val playerFragment = MCLSPlayerFragment()

    lateinit var uiBinding: FragmentMlsTvBinding

    var player: MCLSTVPlayer? = null

    private lateinit var annotationManager: AnnotationManager

    private var mclsNetwork: MCLSNetwork? = null

    private var publicKey = ""
    private var identityToken = ""

    private var eventIdParam = ""

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

        publicKey = arguments?.getString(
            PUBLIC_KEY
        ) ?: getString(R.string.mcls_public_key)

        identityToken = arguments?.getString(
            MCLS_IDENTITY_TOKEN
        ).orEmpty()

        val imaVodAdUnit = arguments?.getString(
            IMA_AD_UNIT_VOD
        ) ?: getString(R.string.ima_adunit_vod)

        val imaLiveAdUnit = arguments?.getString(
            IMA_AD_UNIT_LIVE
        ) ?: getString(R.string.ima_adunit_live)

        eventIdParam = arguments?.getString(
            MCLS_EVENT_ID
        ).orEmpty()

        val imaParamsArgs: MCLSIMAParams? =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                arguments?.getParcelable(IMA_PARAMS, MCLSIMAParams::class.java)
            } else {
                @Suppress("DEPRECATION")
                arguments?.getParcelable(IMA_PARAMS)
            }

        val imaParams = imaParamsArgs?.data ?: emptyMap()

        annotationManager = AnnotationManager.Builder()
            .withContext(requireContext())
            .withAnnotationView(uiBinding.annotationView)
            .build()

        player = MCLSTVPlayer.Builder()
            .withContext(requireActivity())
            .withMCLSTvFragment(playerFragment)
            .withLifecycle(lifecycle)
            .withIma(Ima(
                adUnit = imaVodAdUnit,
                liveAdUnit = imaLiveAdUnit,
                paramProvider = {
                    imaParams
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

    override fun onResume() {
        super.onResume()

        if (eventIdParam.isNotEmpty()) {
            playEvent(eventIdParam)
        }
    }

    fun playEvent(event: MCLSEvent) {
        val player = player ?: throw IllegalStateException("Please use this method after OnCreate")

        Timber.d("Playing Event")
        player.playEvent(event)
    }

    fun setAnnotationActions(actions: List<AnnotationAction>) {
        annotationManager.setActions(actions)
    }

    fun playEvent(eventId: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            getMCLSNetwork().getEventDetails(
                eventId
            ) {
                player?.playEvent(it)
            }
        }
    }

    fun setPublicKey(key: String) {
        publicKey = key
        mclsNetwork?.setPublicKey(key)
    }

    fun setIdentityToken(token: String) {
        identityToken = token
        mclsNetwork?.setIdentityToken(token)
    }

    private fun getMCLSNetwork(): MCLSNetwork {
        val networkClient = mclsNetwork

        if (networkClient != null) {
            return networkClient
        }

        val clientBuilder = MCLSNetwork.Builder()
            .withContext(requireContext())
            .withPublicKey(publicKey)

        if (identityToken.isNotEmpty()) {
            clientBuilder.withIdentityToken(identityToken)
        }

        val client = clientBuilder.build()

        this.mclsNetwork = client

        return client
    }

    companion object {
        const val MCLS_EVENT_ID = "event_id"
        const val PUBLIC_KEY = "public_key"
        const val IMA_AD_UNIT_VOD = "ima_adunit_vod"
        const val IMA_AD_UNIT_LIVE = "ima_adunit_live"
        const val IMA_PARAMS = "ima_params"
        const val MCLS_IDENTITY_TOKEN = "identity_token"
    }
}