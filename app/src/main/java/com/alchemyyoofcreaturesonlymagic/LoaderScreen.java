package com.alchemyyoofcreaturesonlymagic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.alchemyyoofcreaturesonlymagic.activities.MainScreen;
import com.alchemyyoofcreaturesonlymagic.databinding.ActivityLoaderScreenBinding;

public class LoaderScreen extends AppCompatActivity {

    ActivityLoaderScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //
        binding = ActivityLoaderScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoaderScreen.this, MainScreen.class));
                finish();
            }
        }, 5500);
    }
}