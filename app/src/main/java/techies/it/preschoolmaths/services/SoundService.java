package techies.it.preschoolmaths.services;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.IOException;

import timber.log.Timber;

/**
 * Created by Compaq123 on 14-Apr-16.
 */
public class SoundService extends Service implements MediaPlayer.OnCompletionListener,
        MediaPlayer.OnPreparedListener
{

    private MediaPlayer mPlayer;

    int CHEERS_SOUND = 1;
    int AWW_SOUND = 2;

    private static final String TAG = SoundService.class.getSimpleName();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Timber.d("onStartCommand(int flags, int startId)");
        Timber.d("onStartCommand(int %d, int %d)", flags, startId);

        int sound = (int) intent.getExtras().get("Sound_To_Play");

        if (sound == CHEERS_SOUND)
        {
            playCheersMusic();
        }
        else
        {
            playAWWMusic();
        }

        return START_NOT_STICKY;
    }


    @Override
    public void onCreate()
    {
        super.onCreate();
        Timber.tag(TAG);
        Timber.d("onCreate()");

    }



    private void initPlayer()
    {
        mPlayer = new MediaPlayer();
        mPlayer.setOnCompletionListener(this);
        mPlayer.setOnPreparedListener(this);

    }

    public void playCheersMusic()
    {
        if (mPlayer == null)
        {
            initPlayer();
        }

        if (mPlayer.isPlaying())
        {
            mPlayer.stop();
        }

        mPlayer.reset();

        try
        {
            AssetFileDescriptor afd = getAssets().openFd("sound/cheers.mp3");
            mPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            Timber.d("prepareAsync()");
            mPlayer.prepareAsync();

        }
        catch (IOException e)
        {
            Timber.e(e, "Media Player");
        }
    }

    public void playAWWMusic()
    {
        if (mPlayer == null)
        {
            initPlayer();
        }

        if (mPlayer.isPlaying())
        {
            mPlayer.stop();
        }

        mPlayer.reset();

        try
        {
            AssetFileDescriptor afd = getAssets().openFd("sound/aww.mp3");
            mPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            Timber.d("prepareAsync()");
            mPlayer.prepareAsync();

        }
        catch (IOException e)
        {
            Timber.e(e, "Media Player");
        }
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();


        Timber.d("onDestroy()");

        if (mPlayer != null)
        {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    public void onCompletion(MediaPlayer mp)
    {
        Timber.d("onCompletion()");

        stopSelf();
    }

    @Override
    public void onPrepared(MediaPlayer mp)
    {
        Timber.d("onPrepared()");
        mp.start();
    }


}
