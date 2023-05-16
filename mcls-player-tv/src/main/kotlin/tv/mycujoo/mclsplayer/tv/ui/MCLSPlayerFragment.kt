package tv.mycujoo.mclsplayer.tv.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.leanback.app.VideoSupportFragment
import tv.mycujoo.mclsplayer.tv.databinding.FragmentMclsPlayerBinding

class MCLSPlayerFragment : Fragment() {

    private val videoSupportFragment = VideoSupportFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = FragmentMclsPlayerBinding.inflate(layoutInflater, container, false)

        childFragmentManager.beginTransaction()
            .replace(view.fragmentContainer.id, getVideoSupportFragment())
            .commit()

        return view.root
    }

    fun getVideoSupportFragment() = videoSupportFragment

    fun getFragmentRootView(): ViewGroup {
        return requireView() as ViewGroup
    }
}