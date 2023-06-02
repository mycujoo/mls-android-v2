package tv.mycujoo.mcls.tv

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import timber.log.Timber
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.mediator.AnnotationManager
import tv.mycujoo.mcls.tv.databinding.FragmentMlsTvBinding
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.MCLSResult
import tv.mycujoo.mclsima.Ima
import tv.mycujoo.mclsnetwork.MCLSNetwork
import tv.mycujoo.mclsplayer.tv.MCLSTVPlayer
import tv.mycujoo.mclsplayer.tv.ui.MCLSPlayerFragment
import kotlin.jvm.Throws

class MCLSTVFragment : Fragment() {

    private val playerFragment = MCLSPlayerFragment()

    lateinit var uiBinding: FragmentMlsTvBinding

    var player: MCLSTVPlayer? = null

    private var annotationManager: AnnotationManager? = null

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
        ).orEmpty()

        identityToken = arguments?.getString(
            MCLS_IDENTITY_TOKEN
        ).orEmpty()

        val imaVodAdUnit = arguments?.getString(
            IMA_AD_UNIT_VOD
        )

        val imaLiveAdUnit = arguments?.getString(
            IMA_AD_UNIT_LIVE
        )

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

        val playerBuilder = MCLSTVPlayer.Builder()
            .withContext(requireActivity())
            .withMCLSTvFragment(playerFragment)
            .withLifecycle(lifecycle)

        imaVodAdUnit?.let { vodAdUnit ->
            if (vodAdUnit.isEmpty()) {
                return@let
            }

            playerBuilder.withIma(
                Ima(
                    adUnit = vodAdUnit,
                    liveAdUnit = imaLiveAdUnit ?: vodAdUnit,
                    paramProvider = {
                        imaParams
                    }
                )
            )
        }

        player = playerBuilder
            .build()

        return uiBinding.root
    }

    override fun onResume() {
        super.onResume()

        if (eventIdParam.isNotEmpty()) {
            playEvent(eventIdParam)
        }
    }

    /**
     * plays event based on [MCLSEvent]
     *
     * use in [FragmentActivity.onResumeFragments]
     *
     * @throws IllegalStateException when playback requested before the fragment is ready.
     *
     */
    @Throws(IllegalStateException::class)
    fun playEvent(event: MCLSEvent) {
        val player = player ?: throw IllegalStateException("Please use this method after OnCreate")

        Timber.d("Playing Event")
        player.playEvent(event)
    }

    /**
     * Sets annotations actions mapped manually
     *
     * @param actions The Annotation Actions needed.
     */
    fun setAnnotationActions(actions: List<AnnotationAction>) {
        getAnnotationManager().setActions(actions)
    }

    /**
     *
     * Plays event using Event Id.
     *
     * @param eventId MCLS Event Id
     * @param enableAnnotations (true by default), used to disable annotations when not needed.
     *
     * @throws PublicKeyNotSetException when you try playback without providing a public key
     */
    @Throws(PublicKeyNotSetException::class)
    fun playEvent(
        eventId: String,
        enableAnnotations: Boolean = true
    ) {
        if (publicKey.isEmpty()) throw PublicKeyNotSetException()

        viewLifecycleOwner.lifecycleScope.launch {
            getMCLSNetwork().getEventDetails(
                eventId
            ) { event ->

                if (enableAnnotations) {
                    setAnnotations(event)
                }

                player?.playEvent(event)
            }
        }
    }

    /**
     * sets annotations into annotation view when needed.
     * using this ignores the disable marker in [playEvent]
     *
     * @param eventId MCLS Event Id, we extract the first Timeline Id, and set annotations based on it.
     *
     * @throws PublicKeyNotSetException when public key is not set
     */
    fun setAnnotationsByEventId(eventId: String) {
        if (publicKey.isEmpty()) throw PublicKeyNotSetException()

        viewLifecycleOwner.lifecycleScope.launch {
            getMCLSNetwork().getEventDetails(eventId) {
                setAnnotations(it)
            }
        }
    }

    /**
     * sets annotations into annotation view when needed.
     * using this ignores the disable marker in [playEvent]
     * To use other timelines, please use [setAnnotationActionsByTimelineId]
     *
     * @param event MCLSEvent. We use the first timeline id and set annotations based on it.
     *
     * @throws PublicKeyNotSetException when public key is not set
     */
    @Throws(PublicKeyNotSetException::class)
    fun setAnnotations(event: MCLSEvent) {
        if (publicKey.isEmpty()) throw PublicKeyNotSetException()

        val timelineId = event.timeline_ids.firstOrNull() ?: return
        setAnnotationActionsByTimelineId(timelineId, null)
    }

    /**
     * sets annotation actions based on timeline id.
     *
     * @param timelineId the id of the timeline needed
     * @param updateId an id used to get live updates about MCLS timelines.
     *
     * @throws PublicKeyNotSetException when public key is not set
     */
    @Throws(PublicKeyNotSetException::class)
    fun setAnnotationActionsByTimelineId(timelineId: String, updateId: String? = null) {
        viewLifecycleOwner.lifecycleScope.launch {
            val actions = getMCLSNetwork().getTimelineActions(timelineId, updateId)

            if (actions !is MCLSResult.Success) {
                return@launch
            }

            getAnnotationManager().setActions(actions.value)
        }

    }

    /**
     * sets public key for MCLS network requests.
     *
     * If you're mapping your own MCLSEvent, this is not needed.
     *
     * @param key MCLS Public Key (tied to your account)
     */
    fun setPublicKey(key: String) {
        publicKey = key
        mclsNetwork?.setPublicKey(key)
    }

    /**
     * Sets identity token.
     * Used for protected content (i.e. paid content), and concurrency limit.
     *
     * @param token Identity Token
     *
     * @see { https://mcls.mycujoo.tv/api-docs/ }
     */
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

    private fun getAnnotationManager(): AnnotationManager {
        val manager = annotationManager
        if (manager != null) {
            return manager
        }

        val newManager = AnnotationManager.Builder()
            .withContext(requireContext())
            .withAnnotationView(uiBinding.annotationView)
            .build()

        newManager.attachPlayer(object : VideoPlayer {
            override fun currentPosition(): Long {
                val player = player ?: return -1

                if (player.isPlayingAd()) {
                    return -1
                }

                return player.currentPosition()
            }
        })

        annotationManager = newManager

        return newManager
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