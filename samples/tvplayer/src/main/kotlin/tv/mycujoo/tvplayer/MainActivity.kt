package tv.mycujoo.tvplayer

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import tv.mycujoo.mclsplayer.tv.MCLSTVPlayer
import tv.mycujoo.mclsplayer.tv.ui.MCLSTVFragment
import tv.mycujoo.tvplayer.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val frag = binding.fragmentContainer.getFragment<MCLSTVFragment>()

        val player = MCLSTVPlayer.Builder()
//            .withStyledPlayerView()
//            .withMCLSTVPlayer()
            .build()
    }
}