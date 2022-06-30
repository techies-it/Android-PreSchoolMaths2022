package techies.it.preschoolmaths.services;

import android.app.Service;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

import androidx.annotation.Nullable;

/**
 * Created by Compaq123 on 14-Apr-16.
 */
public class SoundService extends Service implements MediaPlayer.OnCompletionListener,
        MediaPlayer.OnPreparedListener
{

    private String tag = "SoundService";
    private MediaPlayer mPlayer;

    int CHEERS_SOUND = 1;
    int AWW_SOUND = 2;

    private static final String TAG = SoundService.class.getSimpleName();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.d(tag, "onStartCommand(int flags, int startId)");
       // Log.isLoggable(tag,"onStartCommand(int %d, int %d)", flags, startId);

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
        /*Timber.tag(TAG);
        Log.d(tag,"onCreate()");*/

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
            Log.d(tag,"prepareAsync()");
            mPlayer.prepareAsync();

        }
        catch (IOException e)
        {
            Log.e(TAG, "Media Player", e);
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
            Log.d(tag,"prepareAsync()");
            mPlayer.prepareAsync();

        }
        catch (IOException e)
        {
            Log.e(TAG, "Media Player", e);
        }
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();


        Log.d(tag,"onDestroy()");

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
        Log.d(tag,"onCompletion()");

        stopSelf();
    }

    @Override
    public void onPrepared(MediaPlayer mp)
    {
        Log.d(tag,"onPrepared()");
        mp.start();
    }


}
