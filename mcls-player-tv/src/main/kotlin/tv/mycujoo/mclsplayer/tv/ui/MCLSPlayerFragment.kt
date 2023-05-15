package tv.mycujoo.mclsplayer.tv.ui

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.leanback.app.VideoSupportFragment

abstract class MCLSPlayerFragment : Fragment() {

    abstract fun getVideoSupportFragment(): VideoSupportFragment
    abstract fun getFragmentRootView(): FrameLayout
}