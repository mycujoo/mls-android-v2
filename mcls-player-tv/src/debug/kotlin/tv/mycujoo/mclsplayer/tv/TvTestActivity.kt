package tv.mycujoo.mclsplayer.tv

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import tv.mycujoo.mclsplayer.tv.R
import tv.mycujoo.mclsplayer.tv.databinding.ActivityTvTestBinding

class TvTestActivity : FragmentActivity() {

    lateinit var binding: ActivityTvTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}