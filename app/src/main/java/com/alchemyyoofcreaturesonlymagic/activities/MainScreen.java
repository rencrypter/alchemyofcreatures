package com.alchemyyoofcreaturesonlymagic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.alchemyyoofcreaturesonlymagic.R;
import com.alchemyyoofcreaturesonlymagic.Ref;
import com.alchemyyoofcreaturesonlymagic.databinding.ActivityMainScreenBinding;
import com.alchemyyoofcreaturesonlymagic.services.BgMusicService;

import java.util.Locale;

public class MainScreen extends AppCompatActivity {

    ActivityMainScreenBinding binding;

    @Override
    protected void onResume() {
        super.onResume();
        loadLanguage();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //loadlanguage;
        loadLanguage();
        //
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //

        binding = ActivityMainScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //start bg music
        startBackgroundMusic();
        //
        binding.settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainScreen.this, SettingsScreen.class));
                finish();
            }
        });

        //rules screen
        binding.rulesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainScreen.this, RulesScreen.class));
            }
        });

        //play btn
        binding.playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainScreen.this, BookScreenActivity.class));
            }
        });

    }

    private void loadLanguage() {

        if (Ref.langR) {
            SettingsScreen.changeLanguageApp("ru", MainScreen.this);
//            this.recreate();
//            startActivity(getIntent());

        } else {
            SettingsScreen.changeLanguageApp("en", MainScreen.this);
//            this.recreate();
//            startActivity(getIntent());

        }
    }

    private void startBackgroundMusic() {

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            Intent i = new Intent(this, BgMusicService.class);
//            startForegroundService(i);
//        } else {
        Intent i = new Intent(this, BgMusicService.class);
        startService(i);
//        }
    }
}