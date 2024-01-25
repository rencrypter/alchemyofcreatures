package com.alchemyyoofcreaturesonlymagic.activities;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.alchemyyoofcreaturesonlymagic.R;
import com.alchemyyoofcreaturesonlymagic.Ref;
import com.alchemyyoofcreaturesonlymagic.databinding.ActivitySettingsScreenBinding;
import com.alchemyyoofcreaturesonlymagic.services.BgMusicService;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

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
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Back is pressed... Finishing the activity
                startActivity(new Intent(SettingsScreen.this, MainScreen.class));
                finish();

            }
        });
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingsScreen.this, MainScreen.class));
                finish();
            }
        });

        //
        binding.engLangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ref.langR = false;
                changeLanguageApp("en", SettingsScreen.this);
                finish();
                startActivity(getIntent());
            }
        });
        binding.russiaLangBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ref.langR = true;
                changeLanguageApp("ru", SettingsScreen.this);
                finish();
                startActivity(getIntent());
            }
        });
        //
        binding.onSoundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMyServiceRunning(BgMusicService.class, SettingsScreen.this)) {
                    Snackbar.make(view, R.string.sound_is_already_on, 1000).show();
                } else {
                    Intent i = new Intent(SettingsScreen.this, BgMusicService.class);
                    startService(i);
                    Snackbar.make(view, R.string.sound_is_on_now, 1000).show();
                    Ref.isMusicOff = false;//
                }
            }
        });
        //
        binding.offSoundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isMyServiceRunning(BgMusicService.class, SettingsScreen.this)) {
                    stopService(new Intent(SettingsScreen.this, BgMusicService.class));
                    Snackbar.make(view, R.string.sound_is_off_now, 1000).show();
                    Ref.isMusicOff = true;//ref bool for not turning the sound when the mainscreen is recreated
                } else {
                    Snackbar.make(view, R.string.sound_is_already_off, 1000).show();
                }
            }
        });
    }

    public static void changeLanguageApp(String lan, Activity a) {
        Locale locale = new Locale(lan);
        Configuration config = new Configuration();
        config.locale = locale;
        a.getResources().updateConfiguration(config, a.getResources().getDisplayMetrics());
    }

    public static boolean isMyServiceRunning(Class<?> serviceClass, Activity a) {
        ActivityManager manager = (ActivityManager) a.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}