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
        dataUpdate();
    }

    private void dataUpdate() {

        if (Ref.creature12) {
            binding.creature1.setImageResource(R.drawable.creature_merge_by_12);
        }
        if (Ref.creature14) {
            binding.creature2.setImageResource(R.drawable.creature_merge_by_14);
        }
        if (Ref.creature23) {
            binding.creature3.setImageResource(R.drawable.creature_merge_by_23);
        }
        if (Ref.creature32) {
            binding.creature4.setImageResource(R.drawable.creature_merge_by_32);
        }
        //
        if (Ref.creature27) {
            binding.creature5.setImageResource(R.drawable.creature_merge_by_27);
        }
        if (Ref.creature67) {
            binding.creature6.setImageResource(R.drawable.creature_merge_by_67);
        }
        if (Ref.creature311) {
            binding.creature7.setImageResource(R.drawable.creature_merge_by_311);
        }
        if (Ref.creature107) {
            binding.creature8.setImageResource(R.drawable.creature_merge_by_107);
        }
        if (Ref.creature103) {
            binding.creature9.setImageResource(R.drawable.creature_merge_by_103);
        }
        if (Ref.creature106) {
            binding.creature10.setImageResource(R.drawable.creature_merge_by_106);
        }
        if (Ref.creature611) {
            binding.creature11.setImageResource(R.drawable.creature_merge_by_611);
        }
        if (Ref.creature119) {
            binding.creature12.setImageResource(R.drawable.creature_merge_by_119);
        }
        if (Ref.creature114) {
            binding.creature13.setImageResource(R.drawable.creature_merge_by_114);
        }
        if (Ref.creature86) {
            binding.creature14.setImageResource(R.drawable.creature_merge_by_86);
        }
        if (Ref.creature109) {
            binding.creature15.setImageResource(R.drawable.creature_merge_by_109);
        }
        if (Ref.creature78) {
            binding.creature16.setImageResource(R.drawable.creature_merge_by_78);
        }
        if (Ref.creature510) {
            binding.creature17.setImageResource(R.drawable.creature_merge_by_510);
        }
        if (Ref.creature118) {
            binding.creature18.setImageResource(R.drawable.creature_merge_by_118);
        }
        if (Ref.creature75) {
            binding.creature19.setImageResource(R.drawable.creature_merge_by_75);
        }
        if (Ref.creature32) {
            binding.creature20.setImageResource(R.drawable.creature_merge_by_32);
        }
    }
}