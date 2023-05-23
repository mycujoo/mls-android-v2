package tv.mycujoo.mcls

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tv.mycujoo.mcls.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mclsView.initialize(
            publicKey = "",
            castAppId = null,
            adUnit = null,
            liveAdUnit = null,
        )
    }
}