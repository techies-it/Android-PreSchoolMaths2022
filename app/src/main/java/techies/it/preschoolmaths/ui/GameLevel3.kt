package techies.it.preschoolmaths.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import techies.it.preschoolmaths.R
import techies.it.preschoolmaths.databinding.ActivityGameLevel2Binding
import techies.it.preschoolmaths.databinding.ActivityGameLevel3Binding
import techies.it.preschoolmaths.services.SoundService
import java.util.*

class GameLevel3 : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityGameLevel3Binding
    var view: View?=null
    
    // to store ImageButton number123
    var sum = 0
    // array of images to generate random images in two image views
    var image1 = intArrayOf(1, 2, 3, 4)
    var image2 = intArrayOf(1, 2, 3, 4, 5)
    var CHEERS_SOUND = 1
    var AWW_SOUND = 2
    // to store image id
    var randomImage1 = 1
    var randomImage2 = 1
    var animation270Sec: Animation? = null
    var animation330Sec: Animation? = null
    var animation390Sec: Animation? = null
    var rotation: Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameLevel3Binding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)
        
        generateRandomImage()
        
        if (resources.getBoolean(R.bool.isTab)) {
            // for tab
            animation270Sec = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.translation_left_to_right_270_sec_600
            )
            animation330Sec = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.translation_left_to_right_330_sec_600
            )
            animation390Sec = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.translation_left_to_right_390_sec_600
            )
            rotation = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.rotation_600
            )
            binding.cloud0IV.startAnimation(animation270Sec)
            binding.cloud1IV.startAnimation(animation330Sec)
            binding.cloud3IV.startAnimation(animation330Sec)
            binding.cloud6IV.startAnimation(animation390Sec)
            binding.cloud7IV.startAnimation(animation390Sec)
            binding.sunRaysIV.startAnimation(rotation)
        } else {
            // for mobile
            /*animation270Sec = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.translation_left_to_right_270_sec_320
            )
            animation330Sec = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.translation_left_to_right_330_sec_320
            )
            animation390Sec = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.translation_left_to_right_390_sec_320
            )*/
            rotation = AnimationUtils.loadAnimation(
                applicationContext,
                R.anim.rotation_320
            )
            binding.sunRaysIV.startAnimation(rotation)
        }

        binding.backBT.setOnClickListener(this)
        binding.btNext.setOnClickListener(this)
        binding.btOne.setOnClickListener(this)
        binding.btTwo.setOnClickListener(this)
        binding.btThree.setOnClickListener(this)
        binding.btFour.setOnClickListener(this)
        binding.btFive.setOnClickListener(this)
        binding.btSix.setOnClickListener(this)
        binding.btSeven.setOnClickListener(this)
        binding.btEight.setOnClickListener(this)
        binding.btNine.setOnClickListener(this)
    }

    /**
     * to check total of apples in images and ImageButton press
     *
     * @param sum
     */
    private fun checkTotal(sum: Int) {
        val imageNumberIV1 = getImageNumberLeft(randomImage1)
        val imageNumberIV2 = getImageNumberRight(randomImage2)
        if (imageNumberIV1 + imageNumberIV2 == sum) {
            startSoundService(CHEERS_SOUND)
            generateRandomImage()
        } else {
            startSoundService(AWW_SOUND)
        }
    }

    /**
     * to set random image in image views
     */
    private fun generateRandomImage() {
        randomImage1 = image1[Random().nextInt(image1.size)]
        randomImage2 = image2[Random().nextInt(image2.size)]
        when (randomImage1) {
            1 -> {
                binding.star1.visibility = View.INVISIBLE
                binding.star2.visibility = View.INVISIBLE
                binding.star3.visibility = View.INVISIBLE
                binding.star4.visibility = View.INVISIBLE
                binding.star5.visibility = View.VISIBLE
                binding.star6.visibility = View.INVISIBLE
                binding.star7.visibility = View.INVISIBLE
                binding.star8.visibility = View.INVISIBLE
                binding.star9.visibility = View.INVISIBLE
            }
            2 -> {
                binding.star1.visibility = View.INVISIBLE
                binding.star2.visibility = View.INVISIBLE
                binding.star3.visibility = View.INVISIBLE
                binding.star4.visibility = View.VISIBLE
                binding.star5.visibility = View.INVISIBLE
                binding.star6.visibility = View.VISIBLE
                binding.star7.visibility = View.INVISIBLE
                binding.star8.visibility = View.INVISIBLE
                binding.star9.visibility = View.INVISIBLE
            }
            3 -> {
                binding.star1.visibility = View.VISIBLE
                binding.star2.visibility = View.INVISIBLE
                binding.star3.visibility = View.INVISIBLE
                binding.star4.visibility = View.INVISIBLE
                binding.star5.visibility = View.VISIBLE
                binding.star6.visibility = View.INVISIBLE
                binding.star7.visibility = View.INVISIBLE
                binding.star8.visibility = View.INVISIBLE
                binding.star9.visibility = View.VISIBLE
            }
            4 -> {
                binding.star1.visibility = View.INVISIBLE
                binding.star2.visibility = View.VISIBLE
                binding.star3.visibility = View.INVISIBLE
                binding.star4.visibility = View.VISIBLE
                binding.star5.visibility = View.INVISIBLE
                binding.star6.visibility = View.VISIBLE
                binding.star7.visibility = View.INVISIBLE
                binding.star8.visibility = View.VISIBLE
                binding.star9.visibility = View.INVISIBLE
            }
        }
        when (randomImage2) {
            1 -> {
                binding.star01.visibility = View.INVISIBLE
                binding.star02.visibility = View.INVISIBLE
                binding.star03.visibility = View.INVISIBLE
                binding.star04.visibility = View.INVISIBLE
                binding.star05.visibility = View.VISIBLE
                binding.star06.visibility = View.INVISIBLE
                binding.star07.visibility = View.INVISIBLE
                binding.star08.visibility = View.INVISIBLE
                binding.star09.visibility = View.INVISIBLE
            }
            2 -> {
                binding.star01.visibility = View.INVISIBLE
                binding.star02.visibility = View.INVISIBLE
                binding.star03.visibility = View.INVISIBLE
                binding.star04.visibility = View.VISIBLE
                binding.star05.visibility = View.INVISIBLE
                binding.star06.visibility = View.VISIBLE
                binding.star07.visibility = View.INVISIBLE
                binding.star08.visibility = View.INVISIBLE
                binding.star09.visibility = View.INVISIBLE
            }
            3 -> {
                binding.star01.visibility = View.VISIBLE
                binding.star02.visibility = View.INVISIBLE
                binding.star03.visibility = View.INVISIBLE
                binding.star04.visibility = View.INVISIBLE
                binding.star05.visibility = View.VISIBLE
                binding.star06.visibility = View.INVISIBLE
                binding.star07.visibility = View.INVISIBLE
                binding.star08.visibility = View.INVISIBLE
                binding.star09.visibility = View.VISIBLE
            }
            4 -> {
                binding.star01.visibility = View.INVISIBLE
                binding.star02.visibility = View.VISIBLE
                binding.star03.visibility = View.INVISIBLE
                binding.star04.visibility = View.VISIBLE
                binding.star05.visibility = View.INVISIBLE
                binding.star06.visibility = View.VISIBLE
                binding.star07.visibility = View.INVISIBLE
                binding.star08.visibility = View.VISIBLE
                binding.star09.visibility = View.INVISIBLE
            }
            5 -> {
                binding.star01.visibility = View.INVISIBLE
                binding.star02.visibility = View.VISIBLE
                binding.star03.visibility = View.INVISIBLE
                binding.star04.visibility = View.VISIBLE
                binding.star05.visibility = View.VISIBLE
                binding.star06.visibility = View.VISIBLE
                binding.star07.visibility = View.INVISIBLE
                binding.star08.visibility = View.VISIBLE
                binding.star09.visibility = View.INVISIBLE
            }
        }

        //mPic1.setImageResource(randomImage1);
        //mPic2.setImageResource(randomImage2);
    }

    private fun getImageNumberLeft(image: Int): Int {
        if (image == 1) {
            return 1
        } else if (image == 2) {
            return 2
        } else if (image == 3) {
            return 3
        } else if (image == 4) {
            return 4
        }
        return 0
    }

    private fun getImageNumberRight(image: Int): Int {
        if (image == 1) {
            return 1
        } else if (image == 2) {
            return 2
        } else if (image == 3) {
            return 3
        } else if (image == 4) {
            return 4
        } else if (image == 5) {
            return 5
        }
        return 0
    }

    private fun startSoundService(soundToPlay: Int) {
        Thread {
            val intent = Intent(this@GameLevel3, SoundService::class.java)
            intent.putExtra("Sound_To_Play", soundToPlay)
            startService(intent)
        }.start()
    }

    private fun stopSoundService() {
        Thread { stopService(Intent(this@GameLevel3, SoundService::class.java)) }.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopSoundService()
    }

    override fun onPause() {
        super.onPause()
        stopSoundService()
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
        if (v.id == R.id.btOne) {
            sum = 1
            checkTotal(sum)
        } else if (v.id == R.id.btTwo) {
            sum = 2
            checkTotal(sum)
        } else if (v.id == R.id.btThree) {
            sum = 3
            checkTotal(sum)
        } else if (v.id == R.id.btFour) {
            sum = 4
            checkTotal(sum)
        } else if (v.id == R.id.btFive) {
            sum = 5
            checkTotal(sum)
        } else if (v.id == R.id.btSix) {
            sum = 6
            checkTotal(sum)
        } else if (v.id == R.id.btSeven) {
            sum = 7
            checkTotal(sum)
        } else if (v.id == R.id.btEight) {
            sum = 8
            checkTotal(sum)
        } else if (v.id == R.id.btNine) {
            sum = 9
            checkTotal(sum)
        } else if (v.id == R.id.backBT) {
            finish()
        } else if (v.id == R.id.btNext) {
            generateRandomImage()
        } else if (v.id == R.id.backBT) {
            finish()
        }
    }
}