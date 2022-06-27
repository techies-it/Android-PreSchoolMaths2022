package techies.it.preschoolmaths.ui

import androidx.appcompat.app.AppCompatActivity
import butterknife.Bind
import techies.it.preschoolmaths.R
import android.widget.ImageButton
import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.view.View.OnSystemUiVisibilityChangeListener
import android.view.WindowManager
import butterknife.ButterKnife
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.View
import techies.it.preschoolmaths.ui.GameLevel1
import techies.it.preschoolmaths.ui.GameLevel2
import techies.it.preschoolmaths.ui.GameLevel3
import techies.it.preschoolmaths.ui.GameLevel4

class GameLevels : AppCompatActivity(), View.OnClickListener {
    private var currentApiVersion = 0
    var mContext: Context = this

    @Bind(R.id.backBT)
    var mBack: ImageButton? = null

    @Bind(R.id.btLevel1)
    var mLevel1: ImageButton? = null

    @Bind(R.id.btLevel2)
    var mLevel2: ImageButton? = null

    @Bind(R.id.btLevel3)
    var mLevel3: ImageButton? = null

    @Bind(R.id.btLevel4)
    var mLevel4: ImageButton? = null
    @TargetApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentApiVersion = Build.VERSION.SDK_INT
        val flags = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)

        // This work only for android 4.4+
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {
            window.decorView.systemUiVisibility = flags

            // Code below is to handle presses of Volume up or Volume down.
            // Without this, after pressing volume buttons, the navigation bar will
            // show up and won't hide
            val decorView = window.decorView
            decorView
                .setOnSystemUiVisibilityChangeListener { visibility ->
                    if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                        decorView.systemUiVisibility = flags
                    }
                }
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        setContentView(R.layout.activity_game_levels)
        ButterKnife.bind(this)
        mBack!!.setOnClickListener(this)
        mLevel1!!.setOnClickListener(this)
        mLevel2!!.setOnClickListener(this)
        mLevel3!!.setOnClickListener(this)
        mLevel4!!.setOnClickListener(this)
    }

    @SuppressLint("NewApi")
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.backBT) {
            finish()
        } else if (v.id == R.id.btLevel1) {
            // this button take us to game level 1
            val goToLevel1 = Intent(mContext, GameLevel1::class.java)
            startActivity(goToLevel1)
        } else if (v.id == R.id.btLevel2) {
            // this button take us to game level 2
            val goToLevel1 = Intent(mContext, GameLevel2::class.java)
            startActivity(goToLevel1)
        } else if (v.id == R.id.btLevel3) {
            // this button take us to game level 3
            val goToLevel1 = Intent(mContext, GameLevel3::class.java)
            startActivity(goToLevel1)
        } else if (v.id == R.id.btLevel4) {
            // this button take us to game level 4
            val goToLevel1 = Intent(mContext, GameLevel4::class.java)
            startActivity(goToLevel1)
        }
    }
}