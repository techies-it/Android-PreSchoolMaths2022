package techies.it.preschoolmaths.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import techies.it.preschoolmaths.R
import techies.it.preschoolmaths.databinding.ActivityGameLevelsBinding
import techies.it.preschoolmaths.ui.GameLevel1

class GameLevels : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityGameLevelsBinding
    var view: View?=null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameLevelsBinding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)

        binding.backBT.setOnClickListener(this)
        binding.btLevel1.setOnClickListener(this)
        binding.btLevel2.setOnClickListener(this)
        binding.btLevel3.setOnClickListener(this)
        binding.btLevel4.setOnClickListener(this)
    }

    @SuppressLint("NewApi")
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.decorView.windowInsetsController?.hide(
                android.view.WindowInsets.Type.statusBars()
                        or android.view.WindowInsets.Type.navigationBars()
            )
        }else{
            WindowCompat.setDecorFitsSystemWindows(window, false)
            view?.let {
                WindowInsetsControllerCompat(window, it).let { controller ->
                    controller.hide(WindowInsetsCompat.Type.systemBars())
                    controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }
            }
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.backBT) {
            finish()
        } else if (v.id == R.id.btLevel1) {
            // this button take us to game level 1
            val goToLevel1 = Intent(this@GameLevels, GameLevel1::class.java)
            startActivity(goToLevel1)
        } else if (v.id == R.id.btLevel2) {
            // this button take us to game level 2
            val goToLevel1 = Intent(this@GameLevels, GameLevel2::class.java)
            startActivity(goToLevel1)
        } else if (v.id == R.id.btLevel3) {
            // this button take us to game level 3
            val goToLevel1 = Intent(this@GameLevels, GameLevel3::class.java)
            startActivity(goToLevel1)
        } else if (v.id == R.id.btLevel4) {
            // this button take us to game level 4
            val goToLevel1 = Intent(this@GameLevels, GameLevel4::class.java)
            startActivity(goToLevel1)
        }
    }
}