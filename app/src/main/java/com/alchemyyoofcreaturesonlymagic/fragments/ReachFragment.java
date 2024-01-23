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
        if (Ref.countOfUnlockCreatures == 1) {
            binding.achievement1.setImageResource(R.drawable.achie_sorcerer);
        }
        if (Ref.countOfUnlockCreatures == 10) {
            binding.achievement2.setImageResource(R.drawable.achie_new_master);
        }
        if (Ref.countOfUnlockCreatures == 20) {
            binding.achievement5.setImageResource(R.drawable.achie_dragon_master);
        }
    }

}