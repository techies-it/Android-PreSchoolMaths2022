package techies.it.preschoolmaths.ui;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import techies.it.preschoolmaths.R;

public class InstructionsScreen extends FragmentActivity
{
    @Bind(R.id.backBT)
    ImageButton mBack;

    @OnClick(R.id.backBT)
    public void back(View v)
    {
        finish();
    }

    private int currentApiVersion;

    private SliderLayout mDemoSlider;

    public int[] IMAGE_NAME;

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

        setContentView(R.layout.activity_instructions_screen);

        ButterKnife.bind(this);

        if (getResources().getBoolean(R.bool.isTab))
        {
            // for tab
            IMAGE_NAME = new int[]{R.drawable.screen_level1_600, R.drawable.screen_level2_600, R.drawable.screen_level3_600, R.drawable.screen_level4_600};
        }
        else
        {
            // for mobile
            IMAGE_NAME = new int[]{R.drawable.level1_320, R.drawable.level2_320, R.drawable.level3_320, R.drawable.level4_320};
        }

        mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        mDemoSlider.stopAutoCycle();

        for (int image = 0; image < IMAGE_NAME.length; image++)
        {
            DefaultSliderView slide = new DefaultSliderView(this);
            slide.image(IMAGE_NAME[image]);
            mDemoSlider.addSlider(slide);
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

}
