package com.alchemyyoofcreaturesonlymagic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.alchemyyoofcreaturesonlymagic.R;
import com.alchemyyoofcreaturesonlymagic.databinding.ActivityMainScreenBinding;
import com.alchemyyoofcreaturesonlymagic.services.BgMusicService;

public class MainScreen extends AppCompatActivity {

    ActivityMainScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    private void startBackgroundMusic() {
        Intent serviceIntent = new Intent(this, BgMusicService.class);
        startService(serviceIntent);

    }
}