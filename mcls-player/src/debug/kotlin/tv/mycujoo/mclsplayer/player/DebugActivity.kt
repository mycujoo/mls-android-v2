package tv.mycujoo.mclsplayer.player

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import tv.mycujoo.mclsplayer.databinding.ActivityDebugBinding

/**
 * @suppress
 */
class DebugActivity : FragmentActivity() {
    lateinit var binding: ActivityDebugBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDebugBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}