package techies.it.preschoolmaths.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
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
import techies.it.preschoolmaths.databinding.ActivityGameLevel4Binding
import techies.it.preschoolmaths.ui.GameLevel1.Companion.brushSize
import techies.it.preschoolmaths.utils.DrawingView

class GameLevel4 : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityGameLevel4Binding
    var view: View?=null
    
    var maxValue = 99 // set max value
    var minValue = 0
    var startValue = 0 //set initial value
    var drawingView: DrawingView? = null
    private var mPaint: Paint? = null
    private var mBtnEnable = true
    var animation270Sec: Animation? = null
    var animation330Sec: Animation? = null
    var animation390Sec: Animation? = null
    var rotation: Animation? = null
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameLevel4Binding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)
        
        mPaint = Paint()
        mPaint?.isAntiAlias = true
        mPaint?.isDither = true
        mPaint?.color = Color.WHITE
        mPaint?.style = Paint.Style.STROKE
        mPaint?.strokeJoin = Paint.Join.ROUND
        mPaint?.strokeCap = Paint.Cap.ROUND
        brushSize(this@GameLevel4, mPaint)
        drawingView = DrawingView(this, mPaint)
        drawingView?.setBackgroundColor(Color.TRANSPARENT)
        
        drawingView?.setButtonEnableListener { enable -> mBtnEnable = enable }

        binding.contentLayoutGameLevel4.addView(drawingView)
        
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
        binding.btPrevious.isClickable = false
        binding.btPrevious.isEnabled = false
        binding.chalkIB.setOnClickListener(this)
        binding.dusterIB.setOnClickListener(this)
        binding.btNext.setOnClickListener(this)
        binding.btPrevious.setOnClickListener(this)
        binding.backBT.setOnClickListener(this)
    }

    private fun setLayout(number: Int) {
        if (number <= 3) {
            binding.number1.text = "0"
            binding.number2.text = "1"
            binding.number3.text = "2"
            binding.number4.text = "3"
            if (number == 0) {
                binding.number1.setTextColor(Color.parseColor("#00ff00"))
                binding.number2.setTextColor(Color.parseColor("#ffffff"))
                binding.number3.setTextColor(Color.parseColor("#ffffff"))
                binding.number4.setTextColor(Color.parseColor("#ffffff"))
            } else if (number == 1) {
                binding.number1.setTextColor(Color.parseColor("#ffffff"))
                binding.number2.setTextColor(Color.parseColor("#00ff00"))
                binding.number3.setTextColor(Color.parseColor("#ffffff"))
                binding.number4.setTextColor(Color.parseColor("#ffffff"))
            } else if (number == 2) {
                binding.number1.setTextColor(Color.parseColor("#ffffff"))
                binding.number2.setTextColor(Color.parseColor("#ffffff"))
                binding.number3.setTextColor(Color.parseColor("#00ff00"))
                binding.number4.setTextColor(Color.parseColor("#ffffff"))
            } else if (number == 3) {
                binding.number1.setTextColor(Color.parseColor("#ffffff"))
                binding.number2.setTextColor(Color.parseColor("#ffffff"))
                binding.number3.setTextColor(Color.parseColor("#ffffff"))
                binding.number4.setTextColor(Color.parseColor("#00ff00"))
            }
        } else if (number >= 96) {
            binding.number1.text = "96"
            binding.number2.text = "97"
            binding.number3.text = "98"
            binding.number4.text = "99"
            if (number == 96) {
                binding.number1.setTextColor(Color.parseColor("#00ff00"))
                binding.number2.setTextColor(Color.parseColor("#ffffff"))
                binding.number3.setTextColor(Color.parseColor("#ffffff"))
                binding.number4.setTextColor(Color.parseColor("#ffffff"))
            } else if (number == 97) {
                binding.number1.setTextColor(Color.parseColor("#ffffff"))
                binding.number2.setTextColor(Color.parseColor("#00ff00"))
                binding.number3.setTextColor(Color.parseColor("#ffffff"))
                binding.number4.setTextColor(Color.parseColor("#ffffff"))
            } else if (number == 98) {
                binding.number1.setTextColor(Color.parseColor("#ffffff"))
                binding.number2.setTextColor(Color.parseColor("#ffffff"))
                binding.number3.setTextColor(Color.parseColor("#00ff00"))
                binding.number4.setTextColor(Color.parseColor("#ffffff"))
            } else if (number == 99) {
                binding.number1.setTextColor(Color.parseColor("#ffffff"))
                binding.number2.setTextColor(Color.parseColor("#ffffff"))
                binding.number3.setTextColor(Color.parseColor("#ffffff"))
                binding.number4.setTextColor(Color.parseColor("#00ff00"))
            }
        } else {
            binding.number1.text = String.format("%d", number)
            binding.number2.text = String.format("%d", number + 1)
            binding.number3.text = String.format("%d", number + 2)
            binding.number4.text = String.format("%d", number + 3)
            val text1 = binding.number1.text.toString().trim { it <= ' ' }.toInt()
            val text2 = binding.number2.text.toString().trim { it <= ' ' }.toInt()
            val text3 = binding.number3.text.toString().trim { it <= ' ' }.toInt()
            val text4 = binding.number4.text.toString().trim { it <= ' ' }.toInt()
            when (number) {
                text1 -> {
                    binding.number1.setTextColor(Color.parseColor("#00ff00"))
                    binding.number2.setTextColor(Color.parseColor("#ffffff"))
                    binding.number3.setTextColor(Color.parseColor("#ffffff"))
                    binding.number4.setTextColor(Color.parseColor("#ffffff"))
                }
                text2 -> {
                    binding.number1.setTextColor(Color.parseColor("#ffffff"))
                    binding.number2.setTextColor(Color.parseColor("#00ff00"))
                    binding.number3.setTextColor(Color.parseColor("#ffffff"))
                    binding.number4.setTextColor(Color.parseColor("#ffffff"))
                }
                text3 -> {
                    binding.number1.setTextColor(Color.parseColor("#ffffff"))
                    binding.number2.setTextColor(Color.parseColor("#ffffff"))
                    binding.number3.setTextColor(Color.parseColor("#00ff00"))
                    binding.number4.setTextColor(Color.parseColor("#ffffff"))
                }
                text4 -> {
                    binding.number1.setTextColor(Color.parseColor("#ffffff"))
                    binding.number2.setTextColor(Color.parseColor("#ffffff"))
                    binding.number3.setTextColor(Color.parseColor("#ffffff"))
                    binding.number4.setTextColor(Color.parseColor("#00ff00"))
                }
            }
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
        if (mBtnEnable) {
            mPaint?.xfermode = null
            mPaint?.alpha = 0xFF
            if (v.id == R.id.btNext) {
                // to clear the drawing view
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel4, mPaint)
                if (startValue < maxValue) {
                    startValue++
                    if (startValue == maxValue) {
                        binding.numbersTV.text = startValue.toString()
                        binding.btNext.isClickable = false
                        binding.btNext.isEnabled = false
                        binding.btNext.alpha = 0.5f
                    } else {
                        binding.numbersTV.text = startValue.toString()
                        binding.btNext.isClickable = true
                        binding.btNext.isEnabled = true
                        binding.btNext.alpha = 1.0f
                        binding.btPrevious.isClickable = true
                        binding.btPrevious.isEnabled = true
                        binding.btPrevious.alpha = 1.0f
                    }
                    setLayout(startValue)
                } else {
                    binding.btNext.isClickable = false
                    binding.btNext.isEnabled = false
                    binding.btNext.alpha = 0.5f
                }
            } else if (v.id == R.id.btPrevious) {
                // to clear the drawing view
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel4, mPaint)
                if (startValue > minValue) {
                    startValue--
                    if (startValue == minValue) {
                        binding.numbersTV.text = startValue.toString()
                        binding.btPrevious.isClickable = false
                        binding.btPrevious.isEnabled = false
                        binding.btPrevious.alpha = 0.5f
                    } else {
                        binding.numbersTV.text = startValue.toString()
                        binding.btNext.isClickable = true
                        binding.btNext.isEnabled = true
                        binding.btNext.alpha = 1.0f
                        binding.btPrevious.isClickable = true
                        binding.btPrevious.isEnabled = true
                        binding.btPrevious.alpha = 1.0f
                    }
                    setLayout(startValue)
                } else {
                    binding.btPrevious.isClickable = false
                    binding.btPrevious.isEnabled = false
                    binding.btPrevious.alpha = 0.5f
                }
            } else if (v.id == R.id.dusterIB) {
                mPaint?.strokeWidth = 40f
                mPaint?.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
            } else if (v.id == R.id.chalkIB) {
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel4, mPaint)
            } else if (v.id == R.id.backBT) {
                finish()
            }
        }
    }
}