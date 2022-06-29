package techies.it.preschoolmaths.ui

import androidx.appcompat.app.AppCompatActivity
import android.view.animation.Animation
import techies.it.preschoolmaths.utils.DrawingView
import techies.it.preschoolmaths.R
import android.os.Build
import android.os.Bundle
import butterknife.ButterKnife
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import techies.it.preschoolmaths.databinding.ActivityGameLevel1Binding

class GameLevel1 : AppCompatActivity(), View.OnClickListener, Animation.AnimationListener {
    private lateinit var binding: ActivityGameLevel1Binding
    var view: View?=null
    var drawingView: DrawingView? = null
    var mPaint: Paint? = null
    private var mBtnEnable = true
    var animation270Sec: Animation? = null
    var animation330Sec: Animation? = null
    var animation390Sec: Animation? = null
    var rotation: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameLevel1Binding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)
        
        mPaint = Paint()
        mPaint?.isAntiAlias = true
        mPaint?.isDither = true
        mPaint?.color = Color.WHITE
        mPaint?.style = Paint.Style.STROKE
        mPaint?.strokeJoin = Paint.Join.ROUND
        mPaint?.strokeCap = Paint.Cap.ROUND
        brushSize(this@GameLevel1, mPaint)
        drawingView = DrawingView(this, mPaint)
        drawingView?.setBackgroundColor(Color.TRANSPARENT)
        drawingView?.setButtonEnableListener { enable -> mBtnEnable = enable }
        
        binding.contentLayoutGameLevel1.addView(drawingView)
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
        binding.btPlay0.setOnClickListener(this)
        binding.btPlay1.setOnClickListener(this)
        binding.btPlay2.setOnClickListener(this)
        binding.btPlay3.setOnClickListener(this)
        binding.btPlay4.setOnClickListener(this)
        binding.btPlay5.setOnClickListener(this)
        binding.btPlay6.setOnClickListener(this)
        binding.btPlay7.setOnClickListener(this)
        binding.btPlay8.setOnClickListener(this)
        binding.btPlay9.setOnClickListener(this)
        binding.dusterIB.setOnClickListener(this)
        binding.chalkIB.setOnClickListener(this)
        binding.backBT.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        Log.d(TAG, "onClick: ")
        if (mBtnEnable) {
            Log.d(TAG, "onClick: enabled true")
            mPaint?.xfermode = null
            mPaint?.alpha = 0xFF
            if (v.id == R.id.btPlay0) {
                binding.numbersTV.text = "0"
                binding.star1.visibility = View.INVISIBLE
                binding.star2.visibility = View.INVISIBLE
                binding.star3.visibility = View.INVISIBLE
                binding.star4.visibility = View.INVISIBLE
                binding.star5.visibility = View.INVISIBLE
                binding.star6.visibility = View.INVISIBLE
                binding.star7.visibility = View.INVISIBLE
                binding.star8.visibility = View.INVISIBLE
                binding.star9.visibility = View.INVISIBLE
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel1, mPaint)
            } else if (v.id == R.id.btPlay1) {
                binding.numbersTV.text = "1"
                binding.star1.visibility = View.INVISIBLE
                binding.star2.visibility = View.INVISIBLE
                binding.star3.visibility = View.INVISIBLE
                binding.star4.visibility = View.INVISIBLE
                binding.star5.visibility = View.VISIBLE
                binding.star6.visibility = View.INVISIBLE
                binding.star7.visibility = View.INVISIBLE
                binding.star8.visibility = View.INVISIBLE
                binding.star9.visibility = View.INVISIBLE
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel1, mPaint)
            } else if (v.id == R.id.btPlay2) {
                binding.numbersTV.text = "2"
                binding.star1.visibility = View.INVISIBLE
                binding.star2.visibility = View.INVISIBLE
                binding.star3.visibility = View.INVISIBLE
                binding.star4.visibility = View.VISIBLE
                binding.star5.visibility = View.INVISIBLE
                binding.star6.visibility = View.VISIBLE
                binding.star7.visibility = View.INVISIBLE
                binding.star8.visibility = View.INVISIBLE
                binding.star9.visibility = View.INVISIBLE
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel1, mPaint)
            } else if (v.id == R.id.btPlay3) {
                binding.numbersTV.text = "3"
                binding.star1.visibility = View.VISIBLE
                binding.star2.visibility = View.INVISIBLE
                binding.star3.visibility = View.INVISIBLE
                binding.star4.visibility = View.INVISIBLE
                binding.star5.visibility = View.VISIBLE
                binding.star6.visibility = View.INVISIBLE
                binding.star7.visibility = View.INVISIBLE
                binding.star8.visibility = View.INVISIBLE
                binding.star9.visibility = View.VISIBLE
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel1, mPaint)
            } else if (v.id == R.id.btPlay4) {
                binding.numbersTV.text = "4"
                binding.star1.visibility = View.INVISIBLE
                binding.star2.visibility = View.VISIBLE
                binding.star3.visibility = View.INVISIBLE
                binding.star4.visibility = View.VISIBLE
                binding.star5.visibility = View.INVISIBLE
                binding.star6.visibility = View.VISIBLE
                binding.star7.visibility = View.INVISIBLE
                binding.star8.visibility = View.VISIBLE
                binding.star9.visibility = View.INVISIBLE
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel1, mPaint)
            } else if (v.id == R.id.btPlay5) {
                binding.numbersTV.text = "5"
                binding.star1.visibility = View.INVISIBLE
                binding.star2.visibility = View.VISIBLE
                binding.star3.visibility = View.INVISIBLE
                binding.star4.visibility = View.VISIBLE
                binding.star5.visibility = View.VISIBLE
                binding.star6.visibility = View.VISIBLE
                binding.star7.visibility = View.INVISIBLE
                binding.star8.visibility = View.VISIBLE
                binding.star9.visibility = View.INVISIBLE
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel1, mPaint)
            } else if (v.id == R.id.btPlay6) {
                binding.numbersTV.text = "6"
                binding.star1.visibility = View.VISIBLE
                binding.star2.visibility = View.INVISIBLE
                binding.star3.visibility = View.VISIBLE
                binding.star4.visibility = View.VISIBLE
                binding.star5.visibility = View.INVISIBLE
                binding.star6.visibility = View.VISIBLE
                binding.star7.visibility = View.VISIBLE
                binding.star8.visibility = View.INVISIBLE
                binding.star9.visibility = View.VISIBLE
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel1, mPaint)
            } else if (v.id == R.id.btPlay7) {
                binding.numbersTV.text = "7"
                binding.star1.visibility = View.VISIBLE
                binding.star2.visibility = View.VISIBLE
                binding.star3.visibility = View.VISIBLE
                binding.star4.visibility = View.INVISIBLE
                binding.star5.visibility = View.VISIBLE
                binding.star6.visibility = View.INVISIBLE
                binding.star7.visibility = View.VISIBLE
                binding.star8.visibility = View.VISIBLE
                binding.star9.visibility = View.VISIBLE
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel1, mPaint)
            } else if (v.id == R.id.btPlay8) {
                binding.numbersTV.text = "8"
                binding.star1.visibility = View.VISIBLE
                binding.star2.visibility = View.VISIBLE
                binding.star3.visibility = View.VISIBLE
                binding.star4.visibility = View.VISIBLE
                binding.star5.visibility = View.INVISIBLE
                binding.star6.visibility = View.VISIBLE
                binding.star7.visibility = View.VISIBLE
                binding.star8.visibility = View.VISIBLE
                binding.star9.visibility = View.VISIBLE
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel1, mPaint)
            } else if (v.id == R.id.btPlay9) {
                binding.numbersTV.text = "9"
                binding.star1.visibility = View.VISIBLE
                binding.star2.visibility = View.VISIBLE
                binding.star3.visibility = View.VISIBLE
                binding.star4.visibility = View.VISIBLE
                binding.star5.visibility = View.VISIBLE
                binding.star6.visibility = View.VISIBLE
                binding.star7.visibility = View.VISIBLE
                binding.star8.visibility = View.VISIBLE
                binding.star9.visibility = View.VISIBLE
                drawingView?.startNew()
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel1, mPaint)
            } else if (v.id == R.id.dusterIB) {
                mPaint?.strokeWidth = 40f
                mPaint?.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
            } else if (v.id == R.id.chalkIB) {
                mPaint?.color = Color.WHITE
                brushSize(this@GameLevel1, mPaint)
            } else if (v.id == R.id.backBT) {
                finish()
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

    override fun onAnimationStart(animation: Animation) {}
    override fun onAnimationEnd(animation: Animation) {}
    override fun onAnimationRepeat(animation: Animation) {}

    companion object {
        private const val TAG = "GameLevel1"
        @JvmStatic
        fun brushSize(context: Context, mPaint: Paint?) {
            if (context.resources.getBoolean(R.bool.isTab)) {
                mPaint?.strokeWidth = 12f
            } else {
                mPaint?.strokeWidth = 24f
            }
        }
    }
}