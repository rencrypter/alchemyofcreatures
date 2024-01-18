package com.alchemyyoofcreaturesonlymagic.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.alchemyyoofcreaturesonlymagic.DepthPageTransformer;
import com.alchemyyoofcreaturesonlymagic.adapters.MyPagerAdapter;
import com.alchemyyoofcreaturesonlymagic.databinding.ActivityBookScreenBinding;


public class BookScreenActivity extends AppCompatActivity {

    ActivityBookScreenBinding binding;
    MyPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //
        binding = ActivityBookScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //
        // Get ViewPager and Set Adapter
        pagerAdapter = new MyPagerAdapter(this);
//        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        binding.myViewPager2.setPageTransformer(new DepthPageTransformer());
        binding.myViewPager2.setAdapter(pagerAdapter);

        binding.creaturesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.myViewPager2.setCurrentItem(1);
            }
        });

        binding.reachBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.myViewPager2.setCurrentItem(2);
            }
        });

        binding.diaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.myViewPager2.setCurrentItem(0);
            }
        });

    }


}