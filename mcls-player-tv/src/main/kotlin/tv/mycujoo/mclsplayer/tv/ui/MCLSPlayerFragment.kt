package tv.mycujoo.mclsplayer.tv.ui

import android.content.Context
import androidx.constraintlayout.widget.ConstraintLayout

interface MCLSPlayerFragment {
    fun context(): Context
    fun overlayHost(): ConstraintLayout
}