package com.alchemyyoofcreaturesonlymagic.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.alchemyyoofcreaturesonlymagic.fragments.CreaturesFragment;
import com.alchemyyoofcreaturesonlymagic.fragments.DiaryFragment;
import com.alchemyyoofcreaturesonlymagic.fragments.ReachFragment;

public class MyPagerAdapter extends FragmentStateAdapter {

    public MyPagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        // Create and return your fragments based on the position
        switch (position) {
            case 0:
                return new DiaryFragment();
            case 1:
                return new CreaturesFragment();
            case 2:
                return new ReachFragment();
            default:
                return new DiaryFragment(); // Return a default fragment if needed
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Number of pages/fragments
    }
}