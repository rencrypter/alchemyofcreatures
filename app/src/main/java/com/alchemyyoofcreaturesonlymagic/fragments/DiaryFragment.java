package com.alchemyyoofcreaturesonlymagic.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alchemyyoofcreaturesonlymagic.R;
import com.alchemyyoofcreaturesonlymagic.Ref;
import com.alchemyyoofcreaturesonlymagic.databinding.FragmentDiaryBinding;

import java.util.ArrayList;


public class DiaryFragment extends Fragment {

    FragmentDiaryBinding binding;
    //
    int index = 0;
    //

    private ArrayList<String> stringsList1 = new ArrayList<>();
    private ArrayList<String> stringsList2 = new ArrayList<>();

    String[] diaryText1;
    String[] diaryText2;


    public DiaryFragment() {
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
        binding = FragmentDiaryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        diaryText1 = getResources().getStringArray(R.array.diaryOne);
        diaryText2 = getResources().getStringArray(R.array.diaryTwo);
        //


        //
        if (!Ref.isUnlockCh2) {//btn gone
            binding.nextBtn.setVisibility(View.GONE);
        } else {
            binding.nextBtn.setVisibility(View.VISIBLE);
            stringsList1.add(getResources().getString(R.string.chapter2_1));
            stringsList2.add(getResources().getString(R.string.chapter2_2));
        }

        if (Ref.isUnlockCh3) {
            stringsList1.add(getResources().getString(R.string.chapter3_1));
            stringsList2.add(getResources().getString(R.string.chapter3_2));
        }
        if (Ref.isUnlockCh4) {
            stringsList1.add(getResources().getString(R.string.chapter4_1));
            stringsList2.add(getResources().getString(R.string.chapter4_2));
        }
        if (Ref.isUnlockCh5) {
            stringsList1.add(getResources().getString(R.string.chapter5_1));
            stringsList2.add(getResources().getString(R.string.chapter5_2));
        }
        if (Ref.isUnlockCh6) {
            stringsList1.add(getResources().getString(R.string.chapter6_1));
            stringsList2.add(getResources().getString(R.string.chapter6_2));
        }
        if (Ref.isUnlockCh7) {
            stringsList1.add(getResources().getString(R.string.chapter7_1));
            stringsList2.add(getResources().getString(R.string.chapter7_2));
        }
        if (Ref.isUnlockCh8) {
            stringsList1.add(getResources().getString(R.string.chapter8_1));
            stringsList2.add(getResources().getString(R.string.chapter8_2));
        }
        if (Ref.isUnlockCh9) {
            stringsList1.add(getResources().getString(R.string.chapter9_1));
            stringsList2.add(getResources().getString(R.string.chapter9_2));
        }
        if (Ref.isUnlockCh10) {
            stringsList1.add(getResources().getString(R.string.chapter10_1));
            stringsList2.add(getResources().getString(R.string.chapter10_2));
        }

        //

        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (index == diaryText1.length) {
                    index = 0;
                    binding.txt1.setText(stringsList1.get(index));
                    binding.txt2.setText(stringsList2.get(index));
                } else {
                    binding.txt1.setText(stringsList1.get(index));
                    binding.txt2.setText(stringsList2.get(index));
                    index = index + 1;
                }

            }
        });
    }
}