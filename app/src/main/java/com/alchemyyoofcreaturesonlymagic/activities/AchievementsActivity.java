package com.alchemyyoofcreaturesonlymagic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.alchemyyoofcreaturesonlymagic.R;
import com.alchemyyoofcreaturesonlymagic.Ref;
import com.alchemyyoofcreaturesonlymagic.databinding.ActivityAchievementsBinding;

public class AchievementsActivity extends AppCompatActivity {

    ActivityAchievementsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //
        binding = ActivityAchievementsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //
        achievementsUnlock();
    }

    private void achievementsUnlock() {
        if (Ref.countOfUnlockCreatures == 1) {
            binding.achievement1.setImageResource(R.drawable.achievement1);
        }
        if (Ref.countOfUnlockCreatures == 10) {
            binding.achievement2.setImageResource(R.drawable.achievement2);
        }
        if (Ref.countOfUnlockCreatures == 20) {
            binding.achievement5.setImageResource(R.drawable.achievement5);
        }
    }
}