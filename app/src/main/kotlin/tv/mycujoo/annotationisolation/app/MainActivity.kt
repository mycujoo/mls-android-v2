package tv.mycujoo.annotationisolation.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import tv.mycujoo.annotationisolation.app.SampleActions.getActions
import tv.mycujoo.annotationisolation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mclsView.playEvent("2FIj79Gm2gqZhvom8w778KX07Cl")
        binding.mclsView.setActions(getActions())

    }
}
