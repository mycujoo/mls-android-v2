package tv.mycujoo.samplemcls.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tv.mycujoo.samplemcls.app.SampleActions.getActions
import tv.mycujoo.samplemcls.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playEvent1.setOnClickListener {
            binding.mclsView.playEvent("2FIj79Gm2gqZhvom8w778KX07Cl")
            binding.mclsView.setActions(getActions())
        }

        binding.playEvent2.setOnClickListener {
            binding.mclsView.playEvent("2Js0ryFLbJHDSjAFoOKp3bZylgf")
            binding.mclsView.setActions(getActions())
        }
    }
}
