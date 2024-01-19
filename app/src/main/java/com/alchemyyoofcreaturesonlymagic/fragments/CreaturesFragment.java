package com.alchemyyoofcreaturesonlymagic.fragments;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.alchemyyoofcreaturesonlymagic.R;
import com.alchemyyoofcreaturesonlymagic.databinding.FragmentCreaturesBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class CreaturesFragment extends Fragment implements View.OnClickListener {

    FragmentCreaturesBinding binding;
    //
    private int clickCounter = 0;

    //to keep record of which creature is selected
    boolean monster1 = false;
    boolean monster2 = false;
    boolean monster3 = false;
    boolean monster4 = false;

    private List<Integer> clickedCreatures = new ArrayList<>();


    //to stop double clicks on same creature
    int one = 0;
    int two = 0;
    int three = 0;
    int four = 0;

    public CreaturesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCreaturesBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //click listener
        binding.monster1.setOnClickListener(this);
        binding.monster2.setOnClickListener(this);
        binding.monster3.setOnClickListener(this);
        binding.monster4.setOnClickListener(this);

        binding.closedResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.newCreature.setImageDrawable(null);
                binding.resultLayout.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == binding.monster1.getId()) {
            one++;
            monster1 = true;
            if (one == 2) {
                monster1 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                one = 0;
                clickCounter = 0;
            } else {
                clickCounter++; //this one for two clicks on creatures //click counter
                clickedCreatures.add(1);
                onImageViewClick();
            }

        } else if (view.getId() == binding.monster2.getId()) {
            monster2 = true;
            two++;
            if (two == 2) {
                monster2 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                two = 0;
                clickCounter = 0;
            } else {
                clickCounter++;
                clickedCreatures.add(2);
                onImageViewClick();
            }
        } else if (view.getId() == binding.monster3.getId()) {
            monster3 = true;
            three++;
            if (three == 2) {
                monster3 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                clickCounter = 0;
                three = 0;
            } else {
                clickCounter++;
                clickedCreatures.add(3);
                onImageViewClick();
            }
        } else if (view.getId() == binding.monster4.getId()) {
            monster4 = true;
            four++;
            if (four == 2) {
                monster4 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                clickCounter = 0;
                four = 0;
            } else {
                clickCounter++;
                clickedCreatures.add(4);
                onImageViewClick();
            }
        }
    }

    private void onImageViewClick() {


        if (clickCounter == 2) {
            performAction();

            //null
            clickCounter = 0;
            one = 0;
            two = 0;
            three = 0;
            four = 0;
            //
            monster1 = false;
            monster2 = false;
            monster3 = false;
            monster4 = false;
            clickedCreatures.clear();
        }

    }

    private void performAction() {

        int firstCreature = clickedCreatures.get(0);
        int secondCreature = clickedCreatures.get(1);

        if (firstCreature == 1 && secondCreature == 2) {
            binding.resultLayout.setVisibility(View.VISIBLE);
            binding.newCreature.setVisibility(View.VISIBLE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    binding.newCreature.setImageResource(R.drawable.creature_merge_by_12);
                }
            }, 2000);

        } else if (firstCreature == 1 && secondCreature == 3) {

        } else if (firstCreature == 1 & secondCreature == 4) {
            binding.resultLayout.setVisibility(View.VISIBLE);
            binding.newCreature.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    binding.newCreature.setImageResource(R.drawable.creature_merge_by_14);

                }
            }, 2000);
        } else if (firstCreature == 2 & secondCreature == 1) {

        } else if (firstCreature == 2 & secondCreature == 2) {

        } else if (firstCreature == 2 & secondCreature == 3) {

            binding.resultLayout.setVisibility(View.VISIBLE);
            binding.newCreature.setVisibility(View.VISIBLE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    binding.newCreature.setImageResource(R.drawable.creature_merge_by_23);
                }
            }, 2000);

        } else if (firstCreature == 2 & secondCreature == 4) {

        }

    }

}