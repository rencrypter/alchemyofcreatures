package com.alchemyyoofcreaturesonlymagic;

import android.app.Application;


import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.alchemyyoofcreaturesonlymagic.services.BgMusicService;


public class CheckLifeCycle extends Application implements LifecycleObserver {

    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onAppBackground() {
        if (BgMusicService.mediaPlayer != null) {
            if(BgMusicService.mediaPlayer.isPlaying()){
                BgMusicService.mediaPlayer.pause();
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onAppOpen() {
        if (BgMusicService.mediaPlayer != null) {
            if(!BgMusicService.mediaPlayer.isPlaying()){
                BgMusicService.mediaPlayer.start();
            }
        }
    }

}