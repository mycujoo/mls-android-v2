package tv.mycujoo.samplemcls.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import tv.mycujoo.samplemcls.app.SampleActions.getActions
import tv.mycujoo.samplemcls.databinding.ActivityMainBinding


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
