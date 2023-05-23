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
            publicKey = getString(R.string.mcls_public_key),
            castAppId = null,
            adUnit = getString(R.string.ima_adunit_vod),
            liveAdUnit = getString(R.string.ima_adunit_live),
            concurrencyControlEnabled = false
        )

        binding.mclsView.playEvent(
            "2NQ40aBBUfv73zENi0XqtkpOsn7"
        )

        binding.mclsView.setActions(SampleActions.getActions())
    }
}