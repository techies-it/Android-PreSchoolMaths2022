package techies.it.preschoolmaths.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
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

public class GameLevel4 extends AppCompatActivity implements View.OnClickListener
{
    int maxValue = 99; // set max value
    int minValue = 0;
    int startValue = 0; //set initial value
    private int currentApiVersion;
    DrawingView drawingView;

    private Paint mPaint;

    private boolean mBtnEnable = true;

    @Bind(R.id.backBT)
    ImageButton mBack;

    @Bind(R.id.smallBoardLabel)
    TextView smallBoardLabel;

    @Bind(R.id.bigBoardLabel)
    TextView bigBoardLabel;

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

    @Bind(R.id.contentLayoutGameLevel4)
    RelativeLayout mContentLayoutGameLevel4;

    @Bind(R.id.numbersTV)
    TextView mNumber;

    @Bind(R.id.number1)
    TextView mNumber1;

    @Bind(R.id.number2)
    TextView mNumber2;

    @Bind(R.id.number3)
    TextView mNumber3;

    @Bind(R.id.number4)
    TextView mNumber4;

    @Bind(R.id.sunRaysIV)
    ImageView mSunRays;

    Animation animation270Sec, animation330Sec, animation390Sec, rotation;

    @Bind(R.id.btPrevious)
    ImageButton mPrevious;

    @Bind(R.id.dusterIB)
    ImageButton mDuster;

    @Bind(R.id.chalkIB)
    ImageButton mChalk;

    @Bind(R.id.btNext)
    ImageButton mNext;

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
        if(currentApiVersion >= Build.VERSION_CODES.KITKAT)
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
                            if((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0)
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

        setContentView(R.layout.activity_game_level4);

        ButterKnife.bind(this);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/cabin_sketch_bold.ttf");

        mNumber.setTypeface(typeface);

        smallBoardLabel.setTypeface(typeface);
        mNumber1.setTypeface(typeface);
        mNumber2.setTypeface(typeface);
        mNumber3.setTypeface(typeface);
        mNumber4.setTypeface(typeface);



        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        GameLevel1.brushSize(GameLevel4.this, mPaint);

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
        mContentLayoutGameLevel4.addView(drawingView);

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

        mPrevious.setClickable(false);
        mPrevious.setEnabled(false);

        mChalk.setOnClickListener(this);
        mDuster.setOnClickListener(this);
        mNext.setOnClickListener(this);
        mPrevious.setOnClickListener(this);
        mBack.setOnClickListener(this);
    }

    public void setLayout(int number)
    {
        if (number <= 3)
        {
            mNumber1.setText("0");
            mNumber2.setText("1");
            mNumber3.setText("2");
            mNumber4.setText("3");

            if (number == 0)
            {
                mNumber1.setTextColor(Color.parseColor("#00ff00"));
                mNumber2.setTextColor(Color.parseColor("#ffffff"));
                mNumber3.setTextColor(Color.parseColor("#ffffff"));
                mNumber4.setTextColor(Color.parseColor("#ffffff"));
            }
            else if (number == 1)
            {
                mNumber1.setTextColor(Color.parseColor("#ffffff"));
                mNumber2.setTextColor(Color.parseColor("#00ff00"));
                mNumber3.setTextColor(Color.parseColor("#ffffff"));
                mNumber4.setTextColor(Color.parseColor("#ffffff"));
            }
            else if (number == 2)
            {
                mNumber1.setTextColor(Color.parseColor("#ffffff"));
                mNumber2.setTextColor(Color.parseColor("#ffffff"));
                mNumber3.setTextColor(Color.parseColor("#00ff00"));
                mNumber4.setTextColor(Color.parseColor("#ffffff"));
            }
            else if (number == 3)
            {
                mNumber1.setTextColor(Color.parseColor("#ffffff"));
                mNumber2.setTextColor(Color.parseColor("#ffffff"));
                mNumber3.setTextColor(Color.parseColor("#ffffff"));
                mNumber4.setTextColor(Color.parseColor("#00ff00"));
            }
        }
        else if (number >=96)
        {
            mNumber1.setText("96");
            mNumber2.setText("97");
            mNumber3.setText("98");
            mNumber4.setText("99");

            if (number == 96)
            {
                mNumber1.setTextColor(Color.parseColor("#00ff00"));
                mNumber2.setTextColor(Color.parseColor("#ffffff"));
                mNumber3.setTextColor(Color.parseColor("#ffffff"));
                mNumber4.setTextColor(Color.parseColor("#ffffff"));
            }
            else if (number == 97)
            {
                mNumber1.setTextColor(Color.parseColor("#ffffff"));
                mNumber2.setTextColor(Color.parseColor("#00ff00"));
                mNumber3.setTextColor(Color.parseColor("#ffffff"));
                mNumber4.setTextColor(Color.parseColor("#ffffff"));
            }
            else if (number == 98)
            {
                mNumber1.setTextColor(Color.parseColor("#ffffff"));
                mNumber2.setTextColor(Color.parseColor("#ffffff"));
                mNumber3.setTextColor(Color.parseColor("#00ff00"));
                mNumber4.setTextColor(Color.parseColor("#ffffff"));
            }
            else if (number == 99)
            {
                mNumber1.setTextColor(Color.parseColor("#ffffff"));
                mNumber2.setTextColor(Color.parseColor("#ffffff"));
                mNumber3.setTextColor(Color.parseColor("#ffffff"));
                mNumber4.setTextColor(Color.parseColor("#00ff00"));
            }
        }
        else
        {
            mNumber1.setText(String.format("%d", number));
            mNumber2.setText(String.format("%d", number + 1));
            mNumber3.setText(String.format("%d", number + 2));
            mNumber4.setText(String.format("%d", number + 3));

            int text1 = Integer.parseInt(mNumber1.getText().toString().trim());
            int text2 = Integer.parseInt(mNumber2.getText().toString().trim());
            int text3 = Integer.parseInt(mNumber3.getText().toString().trim());
            int text4 = Integer.parseInt(mNumber4.getText().toString().trim());

            if (number == text1)
            {
                mNumber1.setTextColor(Color.parseColor("#00ff00"));
                mNumber2.setTextColor(Color.parseColor("#ffffff"));
                mNumber3.setTextColor(Color.parseColor("#ffffff"));
                mNumber4.setTextColor(Color.parseColor("#ffffff"));
            }
            else if (number == text2)
            {
                mNumber1.setTextColor(Color.parseColor("#ffffff"));
                mNumber2.setTextColor(Color.parseColor("#00ff00"));
                mNumber3.setTextColor(Color.parseColor("#ffffff"));
                mNumber4.setTextColor(Color.parseColor("#ffffff"));
            }
            else if (number == text3)
            {
                mNumber1.setTextColor(Color.parseColor("#ffffff"));
                mNumber2.setTextColor(Color.parseColor("#ffffff"));
                mNumber3.setTextColor(Color.parseColor("#00ff00"));
                mNumber4.setTextColor(Color.parseColor("#ffffff"));
            }
            else if (number == text4)
            {
                mNumber1.setTextColor(Color.parseColor("#ffffff"));
                mNumber2.setTextColor(Color.parseColor("#ffffff"));
                mNumber3.setTextColor(Color.parseColor("#ffffff"));
                mNumber4.setTextColor(Color.parseColor("#00ff00"));
            }
        }


    }

    @SuppressLint("NewApi")
    @Override
    public void onWindowFocusChanged(boolean hasFocus)
    {
        super.onWindowFocusChanged(hasFocus);
        if(currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus)
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
    public void onClick(View v)
    {
        if (mBtnEnable)
        {
            mPaint.setXfermode(null);
            mPaint.setAlpha(0xFF);

            if (v.getId() == R.id.btNext)
            {
                // to clear the drawing view
                drawingView.startNew();
                mPaint.setColor(Color.WHITE);
                GameLevel1.brushSize(GameLevel4.this, mPaint);

                if (startValue < maxValue)
                {
                    startValue++;
                    if (startValue == maxValue)
                    {
                        mNumber.setText(String.valueOf(startValue));
                        mNext.setClickable(false);
                        mNext.setEnabled(false);
                        mNext.setAlpha(0.5f);
                    }
                    else
                    {
                        mNumber.setText(String.valueOf(startValue));
                        mNext.setClickable(true);
                        mNext.setEnabled(true);
                        mNext.setAlpha(1.0f);
                        mPrevious.setClickable(true);
                        mPrevious.setEnabled(true);
                        mPrevious.setAlpha(1.0f);
                    }

                    setLayout(startValue);

                }
                else
                {
                    mNext.setClickable(false);
                    mNext.setEnabled(false);
                    mNext.setAlpha(0.5f);
                }
            }
            else if (v.getId() == R.id.btPrevious)
            {
                // to clear the drawing view
                drawingView.startNew();
                mPaint.setColor(Color.WHITE);
                GameLevel1.brushSize(GameLevel4.this, mPaint);

                if (startValue > minValue)
                {
                    startValue--;
                    if (startValue == minValue)
                    {
                        mNumber.setText(String.valueOf(startValue));
                        mPrevious.setClickable(false);
                        mPrevious.setEnabled(false);
                        mPrevious.setAlpha(0.5f);
                    }
                    else
                    {
                        mNumber.setText(String.valueOf(startValue));
                        mNext.setClickable(true);
                        mNext.setEnabled(true);
                        mNext.setAlpha(1.0f);
                        mPrevious.setClickable(true);
                        mPrevious.setEnabled(true);
                        mPrevious.setAlpha(1.0f);
                    }


                    setLayout(startValue);

                }
                else
                {
                    mPrevious.setClickable(false);
                    mPrevious.setEnabled(false);
                    mPrevious.setAlpha(0.5f);
                }
            }
            else if (v.getId() == R.id.dusterIB)
            {
                mPaint.setStrokeWidth(40);
                mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            else if (v.getId() == R.id.chalkIB)
            {
                mPaint.setColor(Color.WHITE);
                GameLevel1.brushSize(GameLevel4.this, mPaint);
            }
            else if (v.getId() == R.id.backBT)
            {
                finish();
            }
        }
    }
}
