package com.alchemyyoofcreaturesonlymagic.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.alchemyyoofcreaturesonlymagic.R;

public class BgMusicService extends Service {
    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize and set up the MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.vopna_bg);
        mediaPlayer.setLooping(true); // To enable looping
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Start playback
        mediaPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Release the MediaPlayer resources
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
