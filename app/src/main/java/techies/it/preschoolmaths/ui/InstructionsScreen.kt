package techies.it.preschoolmaths.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.FragmentActivity
import com.daimajia.slider.library.SliderTypes.DefaultSliderView
import techies.it.preschoolmaths.R
import techies.it.preschoolmaths.databinding.ActivityInstructionsScreenBinding

class InstructionsScreen : FragmentActivity() {

    private lateinit var binding: ActivityInstructionsScreenBinding
    var view: View? = null
    lateinit var imagesName: IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInstructionsScreenBinding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)

        binding.backBT.setOnClickListener { finish() }

        imagesName = if (resources.getBoolean(R.bool.isTab)) {
            // for tab
            intArrayOf(
                R.drawable.screen_level1_600,
                R.drawable.screen_level2_600,
                R.drawable.screen_level3_600,
                R.drawable.screen_level4_600
            )
        } else {
            // for mobile
            intArrayOf(
                R.drawable.level1_320,
                R.drawable.level2_320,
                R.drawable.level3_320,
                R.drawable.level4_320
            )
        }
        binding.slider.stopAutoCycle()

        for (image in imagesName.indices) {
            val slide = DefaultSliderView(this)
            slide.image(imagesName[image])
            binding.slider.addSlider(slide)
        }
    }

    @SuppressLint("NewApi")
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.decorView.windowInsetsController?.hide(
                android.view.WindowInsets.Type.statusBars()
                        or android.view.WindowInsets.Type.navigationBars()
            )
        } else {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            view?.let {
                WindowInsetsControllerCompat(window, it).let { controller ->
                    controller.hide(WindowInsetsCompat.Type.systemBars())
                    controller.systemBarsBehavior =
                        WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }
            }
        }
    }
}