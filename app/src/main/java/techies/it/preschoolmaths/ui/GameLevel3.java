package techies.it.preschoolmaths.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import techies.it.preschoolmaths.R;
import techies.it.preschoolmaths.services.SoundService;

public class GameLevel3 extends AppCompatActivity implements View.OnClickListener
{
    int sum; // to store ImageButton number123
    private int currentApiVersion;
    // array of images to generate random images in two image views
    int[] image1 = {1, 2, 3, 4};
    int[] image2 = {1, 2, 3, 4, 5};

    int CHEERS_SOUND = 1;
    int AWW_SOUND = 2;


    // to store image id
    int randomImage1 = 1, randomImage2 = 1;

    @Bind(R.id.backBT)
    ImageButton mBack;

    @Bind(R.id.smallBoardLabel)
    TextView smallBoardLabel;

    @Bind(R.id.plusLabel)
    TextView plusLabel;

    @Bind(R.id.equalLabel)
    TextView equalLabel;

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

    @Bind(R.id.star01)
    ImageView mStar01;

    @Bind(R.id.star02)
    ImageView mStar02;

    @Bind(R.id.star03)
    ImageView mStar03;

    @Bind(R.id.star04)
    ImageView mStar04;

    @Bind(R.id.star05)
    ImageView mStar05;

    @Bind(R.id.star06)
    ImageView mStar06;

    @Bind(R.id.star07)
    ImageView mStar07;

    @Bind(R.id.star08)
    ImageView mStar08;

    @Bind(R.id.star09)
    ImageView mStar09;

    @Bind(R.id.btOne)
    ImageButton btOne;

    @Bind(R.id.btTwo)
    ImageButton btTwo;

    @Bind(R.id.btThree)
    ImageButton btThree;

    @Bind(R.id.btFour)
    ImageButton btFour;

    @Bind(R.id.btFive)
    ImageButton btFive;

    @Bind(R.id.btSix)
    ImageButton btSix;

    @Bind(R.id.btSeven)
    ImageButton btSeven;

    @Bind(R.id.btEight)
    ImageButton btEight;

    @Bind(R.id.btNine)
    ImageButton btNine;

    @Bind(R.id.btNext)
    ImageButton btNext;

    @Bind(R.id.sunRaysIV)
    ImageView mSunRays;

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

        setContentView(R.layout.activity_game_level3);

        ButterKnife.bind(this);

        generateRandomImage();

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/cabin_sketch_bold.ttf");

        plusLabel.setTypeface(typeface);
        equalLabel.setTypeface(typeface);
        smallBoardLabel.setTypeface(typeface);

        if (getResources().getBoolean(R.bool.isTab))
        {
            // for tab
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

        mBack.setOnClickListener(this);
        btNext.setOnClickListener(this);
        btOne.setOnClickListener(this);
        btTwo.setOnClickListener(this);
        btThree.setOnClickListener(this);
        btFour.setOnClickListener(this);
        btFive.setOnClickListener(this);
        btSix.setOnClickListener(this);
        btSeven.setOnClickListener(this);
        btEight.setOnClickListener(this);
        btNine.setOnClickListener(this);
    }


    /**
     * to check total of apples in images and ImageButton press
     *
     * @param sum
     */
    public void checkTotal(int sum)
    {
        int imageNumberIV1 = getImageNumberLeft(randomImage1);
        int imageNumberIV2 = getImageNumberRight(randomImage2);

        if (imageNumberIV1 + imageNumberIV2 == sum)
        {

            startSoundService(CHEERS_SOUND);
            generateRandomImage();
        }
        else
        {
            startSoundService(AWW_SOUND);
        }
    }

    /**
     * to set random image in image views
     */
    public void generateRandomImage()
    {

        randomImage1 = image1[new Random().nextInt(image1.length)];
        randomImage2 = image2[new Random().nextInt(image2.length)];

        switch (randomImage1)
        {
            case 1:
                mStar1.setVisibility(View.INVISIBLE);
                mStar2.setVisibility(View.INVISIBLE);
                mStar3.setVisibility(View.INVISIBLE);
                mStar4.setVisibility(View.INVISIBLE);
                mStar5.setVisibility(View.VISIBLE);
                mStar6.setVisibility(View.INVISIBLE);
                mStar7.setVisibility(View.INVISIBLE);
                mStar8.setVisibility(View.INVISIBLE);
                mStar9.setVisibility(View.INVISIBLE);
                break;

            case 2:
                mStar1.setVisibility(View.INVISIBLE);
                mStar2.setVisibility(View.INVISIBLE);
                mStar3.setVisibility(View.INVISIBLE);
                mStar4.setVisibility(View.VISIBLE);
                mStar5.setVisibility(View.INVISIBLE);
                mStar6.setVisibility(View.VISIBLE);
                mStar7.setVisibility(View.INVISIBLE);
                mStar8.setVisibility(View.INVISIBLE);
                mStar9.setVisibility(View.INVISIBLE);
                break;

            case 3:
                mStar1.setVisibility(View.VISIBLE);
                mStar2.setVisibility(View.INVISIBLE);
                mStar3.setVisibility(View.INVISIBLE);
                mStar4.setVisibility(View.INVISIBLE);
                mStar5.setVisibility(View.VISIBLE);
                mStar6.setVisibility(View.INVISIBLE);
                mStar7.setVisibility(View.INVISIBLE);
                mStar8.setVisibility(View.INVISIBLE);
                mStar9.setVisibility(View.VISIBLE);
                break;

            case 4:
                mStar1.setVisibility(View.INVISIBLE);
                mStar2.setVisibility(View.VISIBLE);
                mStar3.setVisibility(View.INVISIBLE);
                mStar4.setVisibility(View.VISIBLE);
                mStar5.setVisibility(View.INVISIBLE);
                mStar6.setVisibility(View.VISIBLE);
                mStar7.setVisibility(View.INVISIBLE);
                mStar8.setVisibility(View.VISIBLE);
                mStar9.setVisibility(View.INVISIBLE);
                break;
        }

        switch (randomImage2)
        {
            case 1:
                mStar01.setVisibility(View.INVISIBLE);
                mStar02.setVisibility(View.INVISIBLE);
                mStar03.setVisibility(View.INVISIBLE);
                mStar04.setVisibility(View.INVISIBLE);
                mStar05.setVisibility(View.VISIBLE);
                mStar06.setVisibility(View.INVISIBLE);
                mStar07.setVisibility(View.INVISIBLE);
                mStar08.setVisibility(View.INVISIBLE);
                mStar09.setVisibility(View.INVISIBLE);
                break;

            case 2:
                mStar01.setVisibility(View.INVISIBLE);
                mStar02.setVisibility(View.INVISIBLE);
                mStar03.setVisibility(View.INVISIBLE);
                mStar04.setVisibility(View.VISIBLE);
                mStar05.setVisibility(View.INVISIBLE);
                mStar06.setVisibility(View.VISIBLE);
                mStar07.setVisibility(View.INVISIBLE);
                mStar08.setVisibility(View.INVISIBLE);
                mStar09.setVisibility(View.INVISIBLE);
                break;

            case 3:
                mStar01.setVisibility(View.VISIBLE);
                mStar02.setVisibility(View.INVISIBLE);
                mStar03.setVisibility(View.INVISIBLE);
                mStar04.setVisibility(View.INVISIBLE);
                mStar05.setVisibility(View.VISIBLE);
                mStar06.setVisibility(View.INVISIBLE);
                mStar07.setVisibility(View.INVISIBLE);
                mStar08.setVisibility(View.INVISIBLE);
                mStar09.setVisibility(View.VISIBLE);
                break;

            case 4:
                mStar01.setVisibility(View.INVISIBLE);
                mStar02.setVisibility(View.VISIBLE);
                mStar03.setVisibility(View.INVISIBLE);
                mStar04.setVisibility(View.VISIBLE);
                mStar05.setVisibility(View.INVISIBLE);
                mStar06.setVisibility(View.VISIBLE);
                mStar07.setVisibility(View.INVISIBLE);
                mStar08.setVisibility(View.VISIBLE);
                mStar09.setVisibility(View.INVISIBLE);
                break;

            case 5:
                mStar01.setVisibility(View.INVISIBLE);
                mStar02.setVisibility(View.VISIBLE);
                mStar03.setVisibility(View.INVISIBLE);
                mStar04.setVisibility(View.VISIBLE);
                mStar05.setVisibility(View.VISIBLE);
                mStar06.setVisibility(View.VISIBLE);
                mStar07.setVisibility(View.INVISIBLE);
                mStar08.setVisibility(View.VISIBLE);
                mStar09.setVisibility(View.INVISIBLE);
                break;
        }

        //mPic1.setImageResource(randomImage1);
        //mPic2.setImageResource(randomImage2);
    }


    public int getImageNumberLeft(int image)
    {
        if (image == 1)
        {
            return 1;
        }
        else if (image == 2)
        {
            return 2;
        }
        else if (image == 3)
        {
            return 3;
        }
        else if (image == 4)
        {
            return 4;
        }

        return 0;
    }

    public int getImageNumberRight(int image)
    {
        if (image == 1)
        {
            return 1;
        }
        else if (image == 2)
        {
            return 2;
        }
        else if (image == 3)
        {
            return 3;
        }
        else if (image == 4)
        {
            return 4;
        }
        else if (image == 5)
        {
            return 5;
        }

        return 0;
    }

    public void startSoundService(final int soundToPlay)
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(GameLevel3.this, SoundService.class);
                intent.putExtra("Sound_To_Play", soundToPlay);
                startService(intent);
            }
        }).start();
    }


    public void stopSoundService()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                stopService(new Intent(GameLevel3.this, SoundService.class));
            }
        }).start();

    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        stopSoundService();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        stopSoundService();
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
    public void onClick(View v)
    {

        if (v.getId() == R.id.btOne)
        {
            sum = 1;
            checkTotal(sum);
        }
        else if (v.getId() == R.id.btTwo)
        {
            sum = 2;
            checkTotal(sum);
        }
        else if (v.getId() == R.id.btThree)
        {
            sum = 3;
            checkTotal(sum);
        }
        else if (v.getId() == R.id.btFour)
        {
            sum = 4;
            checkTotal(sum);
        }
        else if (v.getId() == R.id.btFive)
        {
            sum = 5;
            checkTotal(sum);
        }
        else if (v.getId() == R.id.btSix)
        {
            sum = 6;
            checkTotal(sum);
        }
        else if (v.getId() == R.id.btSeven)
        {
            sum = 7;
            checkTotal(sum);
        }
        else if (v.getId() == R.id.btEight)
        {
            sum = 8;
            checkTotal(sum);
        }
        else if (v.getId() == R.id.btNine)
        {
            sum = 9;
            checkTotal(sum);
        }
        else if (v.getId() == R.id.backBT)
        {
            finish();
        }
        else if (v.getId() == R.id.btNext)
        {
            generateRandomImage();
        }
        else if (v.getId() == R.id.backBT)
        {
            finish();
        }
    }
}
