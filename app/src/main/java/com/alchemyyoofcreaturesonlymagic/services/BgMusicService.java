package com.alchemyyoofcreaturesonlymagic.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

import com.alchemyyoofcreaturesonlymagic.R;

public class BgMusicService extends Service implements AudioManager.OnAudioFocusChangeListener{
    public  MediaPlayer mediaPlayer;
    AudioManager audioManager;

    @Override
    public void onCreate() {
        super.onCreate();
        // Initialize and set up the MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.vopna_bg);
        mediaPlayer.setLooping(true); // To enable looping

        audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Start playback
        // Request audio focus
        int result = audioManager.requestAudioFocus(
                this, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            // Start playback
            mediaPlayer.start();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Release the MediaPlayer resources
        mediaPlayer.stop();
        mediaPlayer.release();
        // Abandon audio focus
        audioManager.abandonAudioFocus(this);
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onAudioFocusChange(int i) {
        // Handle audio focus changes
        switch (i) {
            case AudioManager.AUDIOFOCUS_LOSS:
                // The service lost audio focus, stop playback
                stopSelf();
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                // Temporary loss of audio focus, pause playback
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
                break;
            case AudioManager.AUDIOFOCUS_GAIN:
                // Audio focus gained, resume playback
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                }
                break;
        }
    }
}
