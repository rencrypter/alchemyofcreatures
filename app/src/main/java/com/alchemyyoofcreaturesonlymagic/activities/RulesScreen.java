package com.alchemyyoofcreaturesonlymagic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.alchemyyoofcreaturesonlymagic.R;
import com.alchemyyoofcreaturesonlymagic.Ref;
import com.alchemyyoofcreaturesonlymagic.databinding.ActivityRulesScreenBinding;
import com.alchemyyoofcreaturesonlymagic.services.BgMusicService;

public class RulesScreen extends AppCompatActivity {

    ActivityRulesScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        loadLanguage();
        //
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //
        binding = ActivityRulesScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void loadLanguage() {

        if (Ref.langR) {
            SettingsScreen.changeLanguageApp("ru", RulesScreen.this);
        } else {
            SettingsScreen.changeLanguageApp("en", RulesScreen.this);
        }
    }
}