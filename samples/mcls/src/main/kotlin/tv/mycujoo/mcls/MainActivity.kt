package tv.mycujoo.mcls

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import timber.log.Timber
import tv.mycujoo.mcls.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mclsView.setPublicKey(
            publicKey = getString(R.string.mcls_public_key)
        )

        binding.mclsView.playEvent(
            "2NQ40aBBUfv73zENi0XqtkpOsn7"
        )

        binding.mclsView.setActions(SampleActions.getActions())
    }
}