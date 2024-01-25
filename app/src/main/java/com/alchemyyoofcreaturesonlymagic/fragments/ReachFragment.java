package com.alchemyyoofcreaturesonlymagic.fragments;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alchemyyoofcreaturesonlymagic.R;
import com.alchemyyoofcreaturesonlymagic.Ref;
import com.alchemyyoofcreaturesonlymagic.databinding.FragmentReachBinding;


public class ReachFragment extends Fragment {


    FragmentReachBinding binding;

    public ReachFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
//        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentReachBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        //

        achievementsUnlock();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //

        achievementsUnlock();
    }

    private void achievementsUnlock() {
//        if (Ref.isUnlockCh2) {
//            binding.achievement1.setImageResource(R.drawable.achie_sorcerer);
//        }
//        if (Ref.isUnlockCh3) {
//            binding.achievement2.setImageResource(R.drawable.achie_new_master);
//        }
//        if (Ref.isUnlockCh4) {
//            binding.achievement5.setImageResource(R.drawable.achie_dragon_master);
//        }

        //
        if (Ref.isUnlockCh2) {
            binding.achievement1.setImageResource(R.drawable.achie_sorcerer);
        }
        if (Ref.isUnlockCh3) { //khud se
            binding.achievement2.setImageResource(R.drawable.achie_new_master);
        }
        if (Ref.isUnlockCh4) {
            binding.achievement3.setImageResource(R.drawable.achie_tammer_of_evil);
        }

        if (Ref.isUnlockCh5) {
            binding.achievement4.setImageResource(R.drawable.achie_onthe_right_track);
        }
//missing
//        if(Ref.countOfUnlockCreatures == 12){
//            binding.achievementLayout.setVisibility(View.VISIBLE);
//            binding.achievementImg.setImageResource(R.drawable.achie_);
//            Ref.isUnlockCh6 = true;
//        }
        if (Ref.isUnlockCh6) { //khud se
            binding.achievement6.setImageResource(R.drawable.achie_dragon_master);
        }

        if (Ref.isUnlockCh7) {
            binding.achievement7.setImageResource(R.drawable.achie_last_hero);
        }

        if (Ref.isUnlockCh8) {
            binding.achievement8.setImageResource(R.drawable.achie_grand_master);
        }
    }

}