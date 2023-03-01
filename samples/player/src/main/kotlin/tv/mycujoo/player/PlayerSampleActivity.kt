package tv.mycujoo.player

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tv.mycujoo.player.databinding.ActivityMainBinding

class PlayerSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlayback.setOnClickListener {
            val intent = Intent(this, PlaybackActivity::class.java)
            startActivity(intent)
        }
    }
}