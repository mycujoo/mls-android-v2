package tv.mycujoo.mclsplayer.player.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import tv.mycujoo.mclsplayer.R
import tv.mycujoo.mclsplayer.player.entity.LiveState

class LiveBadgeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        text = context.getString(R.string.live)
        background = ContextCompat.getDrawable(context, R.drawable.bg_live)
        setTextColor(ContextCompat.getColor(context, R.color.white))
    }

    fun setLiveMode(liveState: LiveState) {
        when (liveState) {
            LiveState.LIVE_ON_THE_EDGE -> {
                visibility = View.VISIBLE

                background =
                    ContextCompat.getDrawable(context, R.drawable.bg_live)
                isEnabled = false
            }
            LiveState.LIVE_TRAILING -> {
                visibility = View.VISIBLE

                background =
                    ContextCompat.getDrawable(context, R.drawable.bg_live_gray)
                isEnabled = true
            }
            LiveState.VOD -> {
                visibility = View.GONE
            }
        }
    }
}