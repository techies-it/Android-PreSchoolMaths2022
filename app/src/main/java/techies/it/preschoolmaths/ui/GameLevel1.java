package techies.it.preschoolmaths.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import techies.it.preschoolmaths.R;
import techies.it.preschoolmaths.utils.DrawingView;

public class GameLevel1 extends AppCompatActivity implements View.OnClickListener, Animation.AnimationListener
{

    private static final String TAG = "GameLevel1";

    private int currentApiVersion;
    DrawingView drawingView;
    public Paint mPaint;
    private boolean mBtnEnable = true;

    @Bind(R.id.contentLayoutGameLevel1)
    RelativeLayout mContentLayoutGameLevel1;

    @Bind(R.id.bigBoardLabel)
    TextView bigBoardLabel;

    @Bind(R.id.smallBoardLabel)
    TextView smallBoardLabel;

    @Bind(R.id.numbersTV)
    TextView mNumbers;

    @Bind(R.id.btPlay0)
    ImageButton mPlay0;

    @Bind(R.id.btPlay1)
    ImageButton mPlay1;

    @Bind(R.id.btPlay2)
    ImageButton mPlay2;

    @Bind(R.id.btPlay3)
    ImageButton mPlay3;

    @Bind(R.id.btPlay4)
    ImageButton mPlay4;

    @Bind(R.id.btPlay5)
    ImageButton mPlay5;

    @Bind(R.id.btPlay6)
    ImageButton mPlay6;

    @Bind(R.id.btPlay7)
    ImageButton mPlay7;

    @Bind(R.id.btPlay8)
    ImageButton mPlay8;

    @Bind(R.id.btPlay9)
    ImageButton mPlay9;

    @Bind(R.id.backBT)
    ImageButton mBack;

    @Bind(R.id.star1)
    ImageView mStar1;

    @Bind(R.id.star2)
    ImageView mStar2;

    @Bind(R.id.star3)
    ImageView mStar3;

    @Bind(R.id.star4)
    ImageView mStar4;

    @Bind(R.id.star5)
    ImageView mStar5;

    @Bind(R.id.star6)
    ImageView mStar6;

    @Bind(R.id.star7)
    ImageView mStar7;

    @Bind(R.id.star8)
    ImageView mStar8;

    @Bind(R.id.star9)
    ImageView mStar9;

    @Bind(R.id.cloud0IV)
    ImageView mCloud0;

    @Bind(R.id.cloud6IV)
    ImageView mCloud6;

    @Bind(R.id.cloud7IV)
    ImageView mCloud7;

    @Bind(R.id.cloud1IV)
    ImageView mCloud1;

    @Bind(R.id.cloud3IV)
    ImageView mCloud3;

    @Bind(R.id.sunRaysIV)
    ImageView mSunRays;

    @Bind(R.id.dusterIB)
    ImageButton mDuster;

    @Bind(R.id.chalkIB)
    ImageButton mChalk;

    Animation animation270Sec, animation330Sec, animation390Sec, rotation;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        currentApiVersion = android.os.Build.VERSION.SDK_INT;

        final int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        // This work only for android 4.4+
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT)
        {

            getWindow().getDecorView().setSystemUiVisibility(flags);

            // Code below is to handle presses of Volume up or Volume down.
            // Without this, after pressing volume buttons, the navigation bar will
            // show up and won't hide
            final View decorView = getWindow().getDecorView();
            decorView
                    .setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
                    {

                        @Override
                        public void onSystemUiVisibilityChange(int visibility)
                        {
                            if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
                            {
                                decorView.setSystemUiVisibility(flags);
                            }
                        }
                    });
        }
        else
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        setContentView(R.layout.activity_game_level1);

        ButterKnife.bind(this);



        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/cabin_sketch_bold.ttf");


        smallBoardLabel.setTypeface(typeface);
        mNumbers.setTypeface(typeface);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        brushSize(GameLevel1.this, mPaint);

        drawingView = new DrawingView(this, mPaint);
        drawingView.setBackgroundColor(Color.TRANSPARENT);
        drawingView.setButtonEnableListener(new DrawingView.BtnEnableListener()
        {
            @Override
            public void enableButton(boolean enable)
            {
                mBtnEnable = enable;
            }
        });
        mContentLayoutGameLevel1.addView(drawingView);

        if (getResources().getBoolean(R.bool.isTab))
        {
            // for tab
            bigBoardLabel.setTypeface(typeface);

            animation270Sec = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.translation_left_to_right_270_sec_600);

            animation330Sec = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.translation_left_to_right_330_sec_600);

            animation390Sec = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.translation_left_to_right_390_sec_600);

            rotation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.rotation_600);

            mCloud0.startAnimation(animation270Sec);
            mCloud1.startAnimation(animation330Sec);
            mCloud3.startAnimation(animation330Sec);
            mCloud6.startAnimation(animation390Sec);
            mCloud7.startAnimation(animation390Sec);
            mSunRays.startAnimation(rotation);
        }
        else
        {
            // for mobile

            animation270Sec = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.translation_left_to_right_270_sec_320);

            animation330Sec = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.translation_left_to_right_330_sec_320);

            animation390Sec = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.translation_left_to_right_390_sec_320);

            rotation = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.rotation_320);

            mCloud0.startAnimation(animation270Sec);
            mCloud1.startAnimation(animation330Sec);
            mCloud3.startAnimation(animation330Sec);
            mCloud6.startAnimation(animation390Sec);
            mCloud7.startAnimation(animation390Sec);
            mSunRays.startAnimation(rotation);
        }

        mPlay0.setOnClickListener(this);
        mPlay1.setOnClickListener(this);
        mPlay2.setOnClickListener(this);
        mPlay3.setOnClickListener(this);
        mPlay4.setOnClickListener(this);
        mPlay5.setOnClickListener(this);
        mPlay6.setOnClickListener(this);
        mPlay7.setOnClickListener(this);
        mPlay8.setOnClickListener(this);
        mPlay9.setOnClickListener(this);
        mDuster.setOnClickListener(this);
        mChalk.setOnClickListener(this);
        mBack.setOnClickListener(this);
    }


    public static void brushSize(Context context, Paint mPaint)
    {
        if (context.getResources().getBoolean(R.bool.isTab))
        {
            mPaint.setStrokeWidth(12);
        }
        else
        {
            mPaint.setStrokeWidth(24);
        }

    }


    @Override
    public void onClick(View v)
    {


        Log.d(TAG, "onClick: ");

        if (mBtnEnable)
        {
            Log.d(TAG, "onClick: enabled true");

            mPaint.setXfermode(null);
            mPaint.setAlpha(0xFF);

            if (v.getId() == R.id.btPlay0)
            {
                mNumbers.setText("0");
                mStar1.setVisibility(View.INVISIBLE);
                mStar2.setVisibility(View.INVISIBLE);
                mStar3.setVisibility(View.INVISIBLE);
                mStar4.setVisibility(View.INVISIBLE);
                mStar5.setVisibility(View.INVISIBLE);
                mStar6.setVisibility(View.INVISIBLE);
                mStar7.setVisibility(View.INVISIBLE);
                mStar8.setVisibility(View.INVISIBLE);
                mStar9.setVisibility(View.INVISIBLE);
                drawingView.startNew();
                mPaint.setColor(Color.WHITE);
                brushSize(GameLevel1.this, mPaint);
            }
            else if (v.getId() == R.id.btPlay1)
            {
                mNumbers.setText("1");
                mStar1.setVisibility(View.INVISIBLE);
                mStar2.setVisibility(View.INVISIBLE);
                mStar3.setVisibility(View.INVISIBLE);
                mStar4.setVisibility(View.INVISIBLE);
                mStar5.setVisibility(View.VISIBLE);
                mStar6.setVisibility(View.INVISIBLE);
                mStar7.setVisibility(View.INVISIBLE);
                mStar8.setVisibility(View.INVISIBLE);
                mStar9.setVisibility(View.INVISIBLE);
                drawingView.startNew();
                mPaint.setColor(Color.WHITE);
                brushSize(GameLevel1.this, mPaint);
            }
            else if (v.getId() == R.id.btPlay2)
            {
                mNumbers.setText("2");
                mStar1.setVisibility(View.INVISIBLE);
                mStar2.setVisibility(View.INVISIBLE);
                mStar3.setVisibility(View.INVISIBLE);
                mStar4.setVisibility(View.VISIBLE);
                mStar5.setVisibility(View.INVISIBLE);
                mStar6.setVisibility(View.VISIBLE);
                mStar7.setVisibility(View.INVISIBLE);
                mStar8.setVisibility(View.INVISIBLE);
                mStar9.setVisibility(View.INVISIBLE);
                drawingView.startNew();
                mPaint.setColor(Color.WHITE);
                brushSize(GameLevel1.this, mPaint);
            }
            else if (v.getId() == R.id.btPlay3)
            {
                mNumbers.setText("3");
                mStar1.setVisibility(View.VISIBLE);
                mStar2.setVisibility(View.INVISIBLE);
                mStar3.setVisibility(View.INVISIBLE);
                mStar4.setVisibility(View.INVISIBLE);
                mStar5.setVisibility(View.VISIBLE);
                mStar6.setVisibility(View.INVISIBLE);
                mStar7.setVisibility(View.INVISIBLE);
                mStar8.setVisibility(View.INVISIBLE);
                mStar9.setVisibility(View.VISIBLE);
                drawingView.startNew();
                mPaint.setColor(Color.WHITE);
                brushSize(GameLevel1.this, mPaint);
            }
            else if (v.getId() == R.id.btPlay4)
            {
                mNumbers.setText("4");
                mStar1.setVisibility(View.INVISIBLE);
                mStar2.setVisibility(View.VISIBLE);
                mStar3.setVisibility(View.INVISIBLE);
                mStar4.setVisibility(View.VISIBLE);
                mStar5.setVisibility(View.INVISIBLE);
                mStar6.setVisibility(View.VISIBLE);
                mStar7.setVisibility(View.INVISIBLE);
                mStar8.setVisibility(View.VISIBLE);
                mStar9.setVisibility(View.INVISIBLE);
                drawingView.startNew();
                mPaint.setColor(Color.WHITE);
                brushSize(GameLevel1.this, mPaint);
            }
            else if (v.getId() == R.id.btPlay5)
            {
                mNumbers.setText("5");
                mStar1.setVisibility(View.INVISIBLE);
                mStar2.setVisibility(View.VISIBLE);
                mStar3.setVisibility(View.INVISIBLE);
                mStar4.setVisibility(View.VISIBLE);
                mStar5.setVisibility(View.VISIBLE);
                mStar6.setVisibility(View.VISIBLE);
                mStar7.setVisibility(View.INVISIBLE);
                mStar8.setVisibility(View.VISIBLE);
                mStar9.setVisibility(View.INVISIBLE);
                drawingView.startNew();
                mPaint.setColor(Color.WHITE);
                brushSize(GameLevel1.this, mPaint);
            }
            else if (v.getId() == R.id.btPlay6)
            {
                mNumbers.setText("6");
                mStar1.setVisibility(View.VISIBLE);
                mStar2.setVisibility(View.INVISIBLE);
                mStar3.setVisibility(View.VISIBLE);
                mStar4.setVisibility(View.VISIBLE);
                mStar5.setVisibility(View.INVISIBLE);
                mStar6.setVisibility(View.VISIBLE);
                mStar7.setVisibility(View.VISIBLE);
                mStar8.setVisibility(View.INVISIBLE);
                mStar9.setVisibility(View.VISIBLE);
                drawingView.startNew();
                mPaint.setColor(Color.WHITE);
                brushSize(GameLevel1.this, mPaint);
            }
            else if (v.getId() == R.id.btPlay7)
            {
                mNumbers.setText("7");
                mStar1.setVisibility(View.VISIBLE);
                mStar2.setVisibility(View.VISIBLE);
                mStar3.setVisibility(View.VISIBLE);
                mStar4.setVisibility(View.INVISIBLE);
                mStar5.setVisibility(View.VISIBLE);
                mStar6.setVisibility(View.INVISIBLE);
                mStar7.setVisibility(View.VISIBLE);
                mStar8.setVisibility(View.VISIBLE);
                mStar9.setVisibility(View.VISIBLE);
                drawingView.startNew();
                mPaint.setColor(Color.WHITE);
                brushSize(GameLevel1.this, mPaint);
            }
            else if (v.getId() == R.id.btPlay8)
            {
                mNumbers.setText("8");
                mStar1.setVisibility(View.VISIBLE);
                mStar2.setVisibility(View.VISIBLE);
                mStar3.setVisibility(View.VISIBLE);
                mStar4.setVisibility(View.VISIBLE);
                mStar5.setVisibility(View.INVISIBLE);
                mStar6.setVisibility(View.VISIBLE);
                mStar7.setVisibility(View.VISIBLE);
                mStar8.setVisibility(View.VISIBLE);
                mStar9.setVisibility(View.VISIBLE);
                drawingView.startNew();
                mPaint.setColor(Color.WHITE);
                brushSize(GameLevel1.this, mPaint);
            }
            else if (v.getId() == R.id.btPlay9)
            {
                mNumbers.setText("9");
                mStar1.setVisibility(View.VISIBLE);
                mStar2.setVisibility(View.VISIBLE);
                mStar3.setVisibility(View.VISIBLE);
                mStar4.setVisibility(View.VISIBLE);
                mStar5.setVisibility(View.VISIBLE);
                mStar6.setVisibility(View.VISIBLE);
                mStar7.setVisibility(View.VISIBLE);
                mStar8.setVisibility(View.VISIBLE);
                mStar9.setVisibility(View.VISIBLE);
                drawingView.startNew();
                mPaint.setColor(Color.WHITE);
                brushSize(GameLevel1.this, mPaint);
            }
            else if (v.getId() == R.id.dusterIB)
            {
                mPaint.setStrokeWidth(40);
                mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            else if (v.getId() == R.id.chalkIB)
            {
                mPaint.setColor(Color.WHITE);
                brushSize(GameLevel1.this, mPaint);
            }
            else if (v.getId() == R.id.backBT)
            {
                finish();
            }
        }

    }

    @SuppressLint("NewApi")
    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus)
        {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public void onAnimationStart(Animation animation)
    {

    }

    @Override
    public void onAnimationEnd(Animation animation)
    {

    }

    @Override
    public void onAnimationRepeat(Animation animation)
    {

    }
}
