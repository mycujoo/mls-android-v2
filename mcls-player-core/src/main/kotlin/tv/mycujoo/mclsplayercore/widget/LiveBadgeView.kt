package tv.mycujoo.mclsplayercore.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import tv.mycujoo.mclsplayercore.R
import tv.mycujoo.mclsplayercore.databinding.ViewLiveBadgeBinding
import tv.mycujoo.mclsplayercore.entity.LiveState

class LiveBadgeView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        val binding = ViewLiveBadgeBinding.inflate(LayoutInflater.from(context), this, true)

        binding.text.text = context.getString(R.string.live)
        background = ContextCompat.getDrawable(context, R.drawable.bg_live)
        binding.text.setTextColor(ContextCompat.getColor(context, R.color.white))
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