package techies.it.preschoolmaths.ui

import android.annotation.SuppressLint
import android.graphics.*
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import techies.it.preschoolmaths.R
import techies.it.preschoolmaths.databinding.ActivityGameLevel2Binding
import techies.it.preschoolmaths.ui.GameLevel1.Companion.brushSize
import techies.it.preschoolmaths.utils.DrawingView

class GameLevel2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGameLevel2Binding
    var view: View?=null
    var drawingView: DrawingView? = null
    private var mPaint: Paint? = null
    private var mBtnEnable = true
    var apple = 0
    var animation270Sec: Animation? = null
    var animation330Sec: Animation? = null
    var animation390Sec: Animation? = null
    var rotation: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameLevel2Binding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)

        binding.btPrevious.isEnabled = false
        binding.btPrevious.isClickable = false
        
        mPaint = Paint()
        mPaint?.isAntiAlias = true
        mPaint?.isDither = true
        mPaint?.color = Color.WHITE
        mPaint?.style = Paint.Style.STROKE
        mPaint?.strokeJoin = Paint.Join.ROUND
        mPaint?.strokeCap = Paint.Cap.ROUND
        brushSize(this@GameLevel2, mPaint)
        drawingView = DrawingView(this, mPaint)
        drawingView?.setBackgroundColor(Color.TRANSPARENT)
        drawingView?.setButtonEnableListener { enable -> mBtnEnable = enable }
        binding.contentLayoutGameLevel2.addView(drawingView)
        val width = 0
        val height = 0
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
        
        binding.chalkIB.setOnClickListener(this)
        binding.dusterIB.setOnClickListener(this)
        binding.btNext.setOnClickListener(this)
        binding.btPrevious.setOnClickListener(this)
        binding.backBT.setOnClickListener(this)
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
                Log.d("Next: ", apple.toString())
                apple++
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel2, mPaint)
                when (apple) {
                    1 -> {
                        binding.star1.visibility = View.INVISIBLE
                        binding.star2.visibility = View.INVISIBLE
                        binding.star3.visibility = View.INVISIBLE
                        binding.star4.visibility = View.VISIBLE
                        binding.star5.visibility = View.INVISIBLE
                        binding.star6.visibility = View.VISIBLE
                        binding.star7.visibility = View.INVISIBLE
                        binding.star8.visibility = View.INVISIBLE
                        binding.star9.visibility = View.INVISIBLE
                        binding.btPrevious.isEnabled = true
                        binding.btPrevious.isClickable = true
                        binding.btPrevious.alpha = 1.0f
                        binding.btNext.isClickable = true
                        binding.btNext.alpha = 1.0f
                    }
                    2 -> {
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
                    3 -> {
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
                    4 -> {
                        binding.star1.visibility = View.INVISIBLE
                        binding.star2.visibility = View.VISIBLE
                        binding.star3.visibility = View.INVISIBLE
                        binding.star4.visibility = View.VISIBLE
                        binding.star5.visibility = View.VISIBLE
                        binding.star6.visibility = View.VISIBLE
                        binding.star7.visibility = View.INVISIBLE
                        binding.star8.visibility = View.VISIBLE
                        binding.star9.visibility = View.INVISIBLE
                    }
                    5 -> {
                        binding.star1.visibility = View.VISIBLE
                        binding.star2.visibility = View.INVISIBLE
                        binding.star3.visibility = View.VISIBLE
                        binding.star4.visibility = View.VISIBLE
                        binding.star5.visibility = View.INVISIBLE
                        binding.star6.visibility = View.VISIBLE
                        binding.star7.visibility = View.VISIBLE
                        binding.star8.visibility = View.INVISIBLE
                        binding.star9.visibility = View.VISIBLE
                    }
                    6 -> {
                        binding.star1.visibility = View.VISIBLE
                        binding.star2.visibility = View.VISIBLE
                        binding.star3.visibility = View.VISIBLE
                        binding.star4.visibility = View.INVISIBLE
                        binding.star5.visibility = View.VISIBLE
                        binding.star6.visibility = View.INVISIBLE
                        binding.star7.visibility = View.VISIBLE
                        binding.star8.visibility = View.VISIBLE
                        binding.star9.visibility = View.VISIBLE
                    }
                    7 -> {
                        binding.star1.visibility = View.VISIBLE
                        binding.star2.visibility = View.VISIBLE
                        binding.star3.visibility = View.VISIBLE
                        binding.star4.visibility = View.VISIBLE
                        binding.star5.visibility = View.INVISIBLE
                        binding.star6.visibility = View.VISIBLE
                        binding.star7.visibility = View.VISIBLE
                        binding.star8.visibility = View.VISIBLE
                        binding.star9.visibility = View.VISIBLE
                    }
                    8 -> {
                        binding.star1.visibility = View.VISIBLE
                        binding.star2.visibility = View.VISIBLE
                        binding.star3.visibility = View.VISIBLE
                        binding.star4.visibility = View.VISIBLE
                        binding.star5.visibility = View.VISIBLE
                        binding.star6.visibility = View.VISIBLE
                        binding.star7.visibility = View.VISIBLE
                        binding.star8.visibility = View.VISIBLE
                        binding.star9.visibility = View.VISIBLE
                        binding.btNext.isClickable = false
                        binding.btNext.isEnabled = false
                        binding.btNext.alpha = 0.5f
                    }
                }
            } else if (v.id == R.id.btPrevious) {
                apple--
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel2, mPaint)
                when (apple) {
                    0 -> {
                        binding.star1.visibility = View.INVISIBLE
                        binding.star2.visibility = View.INVISIBLE
                        binding.star3.visibility = View.INVISIBLE
                        binding.star4.visibility = View.INVISIBLE
                        binding.star5.visibility = View.VISIBLE
                        binding.star6.visibility = View.INVISIBLE
                        binding.star7.visibility = View.INVISIBLE
                        binding.star8.visibility = View.INVISIBLE
                        binding.star9.visibility = View.INVISIBLE
                        binding.btPrevious.isClickable = false
                        binding.btPrevious.isEnabled = false
                        binding.btPrevious.alpha = 0.5f
                    }
                    1 -> {
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
                    2 -> {
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
                    3 -> {
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
                    4 -> {
                        binding.star1.visibility = View.INVISIBLE
                        binding.star2.visibility = View.VISIBLE
                        binding.star3.visibility = View.INVISIBLE
                        binding.star4.visibility = View.VISIBLE
                        binding.star5.visibility = View.VISIBLE
                        binding.star6.visibility = View.VISIBLE
                        binding.star7.visibility = View.INVISIBLE
                        binding.star8.visibility = View.VISIBLE
                        binding.star9.visibility = View.INVISIBLE
                    }
                    5 -> {
                        binding.star1.visibility = View.VISIBLE
                        binding.star2.visibility = View.INVISIBLE
                        binding.star3.visibility = View.VISIBLE
                        binding.star4.visibility = View.VISIBLE
                        binding.star5.visibility = View.INVISIBLE
                        binding.star6.visibility = View.VISIBLE
                        binding.star7.visibility = View.VISIBLE
                        binding.star8.visibility = View.INVISIBLE
                        binding.star9.visibility = View.VISIBLE
                    }
                    6 -> {
                        binding.star1.visibility = View.VISIBLE
                        binding.star2.visibility = View.VISIBLE
                        binding.star3.visibility = View.VISIBLE
                        binding.star4.visibility = View.INVISIBLE
                        binding.star5.visibility = View.VISIBLE
                        binding.star6.visibility = View.INVISIBLE
                        binding.star7.visibility = View.VISIBLE
                        binding.star8.visibility = View.VISIBLE
                        binding.star9.visibility = View.VISIBLE
                    }
                    7 -> {
                        binding.star1.visibility = View.VISIBLE
                        binding.star2.visibility = View.VISIBLE
                        binding.star3.visibility = View.VISIBLE
                        binding.star4.visibility = View.VISIBLE
                        binding.star5.visibility = View.INVISIBLE
                        binding.star6.visibility = View.VISIBLE
                        binding.star7.visibility = View.VISIBLE
                        binding.star8.visibility = View.VISIBLE
                        binding.star9.visibility = View.VISIBLE
                        binding.btPrevious.isClickable = true
                        binding.btPrevious.isEnabled = true
                        binding.btPrevious.alpha = 1.0f
                        binding.btNext.isClickable = true
                        binding.btNext.isEnabled = true
                        binding.btNext.alpha = 1.0f
                    }
                }
            } else if (v.id == R.id.dusterIB) {
                mPaint?.strokeWidth = 40f
                mPaint?.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
            } else if (v.id == R.id.chalkIB) {
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel2, mPaint)
            } else if (v.id == R.id.backBT) {
                finish()
            }
        }
    }
}