package tv.mycujoo.mcls.tv

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.leanback.app.VideoSupportFragment
import tv.mycujoo.mcls.tv.databinding.FragmentMlsTvBinding
import tv.mycujoo.mclsplayer.tv.ui.MCLSPlayerFragment

class MCLSTVFragment : MCLSPlayerFragment() {

    lateinit var uiBinding: FragmentMlsTvBinding

    private lateinit var videoSupportFragment: VideoSupportFragment
    private lateinit var overlayHost: ConstraintLayout

    override fun getVideoSupportFragment(): VideoSupportFragment {
        return videoSupportFragment
    }

    override fun getFragmentRootView(): FrameLayout {
        return uiBinding.root
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        uiBinding = FragmentMlsTvBinding.inflate(layoutInflater, container, false)

        overlayHost = uiBinding.overlayHost
        videoSupportFragment = VideoSupportFragment()

        childFragmentManager
            .beginTransaction()
            .replace(uiBinding.playbackFragmentHost.id, videoSupportFragment)
            .commit()

        return uiBinding.root
    }
}