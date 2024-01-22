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
import com.alchemyyoofcreaturesonlymagic.databinding.FragmentDiaryBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DiaryFragment extends Fragment {

    FragmentDiaryBinding binding;
    //
    int index = 0;
    //


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
        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Ref.countForDiary == 10) {

                } else {
                    if (index == diaryText1.length) {
                        index = 0;
                        binding.txt1.setText(diaryText1[index]);
                        binding.txt2.setText(diaryText2[index]);
                    } else {
                        binding.txt1.setText(diaryText1[index]);
                        binding.txt2.setText(diaryText2[index]);
                        index = index+1;
                    }
                }
            }
        });
    }
}