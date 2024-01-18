package com.alchemyyoofcreaturesonlymagic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.alchemyyoofcreaturesonlymagic.R;
import com.alchemyyoofcreaturesonlymagic.databinding.ActivitySettingsScreenBinding;
import com.alchemyyoofcreaturesonlymagic.services.BgMusicService;
import com.google.android.material.snackbar.Snackbar;

public class SettingsScreen extends AppCompatActivity {

    ActivitySettingsScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //
        binding = ActivitySettingsScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //
        binding.onSoundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMyServiceRunning(BgMusicService.class)) {
                    Snackbar.make(view,"Sound is already on", 1000).show();
                } else {
                    Intent serviceIntent = new Intent(SettingsScreen.this, BgMusicService.class);
                    startService(serviceIntent);
                    Snackbar.make(view,"Sound is on now", 1000).show();
                }
            }
        });
        //
        binding.offSoundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMyServiceRunning(BgMusicService.class)) {
                    stopService(new Intent(SettingsScreen.this, BgMusicService.class));
                    Snackbar.make(view,"Sound is off now", 1000).show();
                } else {
                    Snackbar.make(view,"Sound is already off", 1000).show();
                }
            }
        });
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}