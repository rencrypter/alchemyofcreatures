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
import com.alchemyyoofcreaturesonlymagic.Ref;
import com.alchemyyoofcreaturesonlymagic.Sounds;
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
    //
    boolean monster5 = false;
    boolean monster6 = false;
    boolean monster7 = false;
    boolean monster8 = false;

    //frame 3
    boolean monster9 = false;
    boolean monster10 = false;
    boolean monster11 = false;

    private List<Integer> clickedCreatures = new ArrayList<>();


    //to stop double clicks on same creature
    int one = 0;
    int two = 0;
    int three = 0;
    int four = 0;
    //
    int five = 0;
    int six = 0;
    int seven = 0;
    int eight = 0;
    //frame 3
    int nine = 0;
    int ten = 0;
    int eleven = 0;

    public CreaturesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        dataUpdate();
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
        binding = FragmentCreaturesBinding.inflate(inflater, container, false);
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
        //frame2
        binding.monster5.setOnClickListener(this);
        binding.monster6.setOnClickListener(this);
        binding.monster7.setOnClickListener(this);
        binding.monster8.setOnClickListener(this);

        //frame 3
        binding.monster9.setOnClickListener(this);
        binding.monster10.setOnClickListener(this);
        binding.monster11.setOnClickListener(this);

        binding.closedResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.newCreature.setImageDrawable(null);
                binding.resultLayout.setVisibility(View.GONE);
                //
                Sounds.playButtonClickSound(getActivity());
                //achievements onLock//
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        achievementsUnlock();
                    }
                }, 400);

            }
        });

        //next frames and previous logic
        binding.next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sounds.playButtonClickSound(getActivity());

                binding.frame1.setVisibility(View.GONE);
                binding.frame2.setVisibility(View.VISIBLE);

            }
        });
        binding.next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sounds.playButtonClickSound(getActivity());

                binding.frame2.setVisibility(View.GONE);
                binding.frame3.setVisibility(View.VISIBLE);

            }
        });
        binding.next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sounds.playButtonClickSound(getActivity());
                binding.frame3.setVisibility(View.GONE);
                dataUpdate();
                binding.resultFrame.setVisibility(View.VISIBLE);
            }
        });
        //
        binding.previousToF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sounds.playButtonClickSound(getActivity());

                binding.frame2.setVisibility(View.GONE);
                binding.frame1.setVisibility(View.VISIBLE);
            }
        });
        binding.previousToF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sounds.playButtonClickSound(getActivity());

                binding.frame3.setVisibility(View.GONE);
                binding.frame2.setVisibility(View.VISIBLE);
            }
        });

        binding.previousToF3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sounds.playButtonClickSound(getActivity());

                binding.resultFrame.setVisibility(View.GONE);
                binding.frame3.setVisibility(View.VISIBLE);
            }
        });
        binding.achievementImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sounds.playButtonClickSound(getActivity());
                binding.achievementLayout.setVisibility(View.GONE);
            }
        });

    }

    private void achievementsUnlock() {
        if (Ref.countOfUnlockCreatures == 1) {
            Sounds.playAchievementUnlockSound(getActivity());
            binding.achievementLayout.setVisibility(View.VISIBLE);
            binding.achievementImg.setImageResource(R.drawable.achie_sorcerer);
            Ref.isUnlockCh2 = true;
        }
        if (Ref.countOfUnlockCreatures == 5) { //khud se
            Sounds.playAchievementUnlockSound(getActivity());
            binding.achievementLayout.setVisibility(View.VISIBLE);
            binding.achievementImg.setImageResource(R.drawable.achie_new_master);
            Ref.isUnlockCh3 = true;
        }
        if (Ref.countOfUnlockCreatures == 10) {
            Sounds.playAchievementUnlockSound(getActivity());
            binding.achievementLayout.setVisibility(View.VISIBLE);
            binding.achievementImg.setImageResource(R.drawable.achie_tammer_of_evil);
            Ref.isUnlockCh4 = true;
        }

        if (Ref.countOfUnlockCreatures == 11) {
            Sounds.playAchievementUnlockSound(getActivity());
            binding.achievementLayout.setVisibility(View.VISIBLE);
            binding.achievementImg.setImageResource(R.drawable.achie_onthe_right_track);
            Ref.isUnlockCh5 = true;
        }
//missing
//        if(Ref.countOfUnlockCreatures == 12){
//            binding.achievementLayout.setVisibility(View.VISIBLE);
//            binding.achievementImg.setImageResource(R.drawable.achie_);
//            Ref.isUnlockCh6 = true;
//        }
        if (Ref.countOfUnlockCreatures == 18) { //khud se
            Sounds.playAchievementUnlockSound(getActivity());
            binding.achievementLayout.setVisibility(View.VISIBLE);
            binding.achievementImg.setImageResource(R.drawable.achie_dragon_master);
            Ref.isUnlockCh6 = true;
        }

        if (Ref.countOfUnlockCreatures == 19) {
            Sounds.playAchievementUnlockSound(getActivity());
            binding.achievementLayout.setVisibility(View.VISIBLE);
            binding.achievementImg.setImageResource(R.drawable.achie_last_hero);
            Ref.isUnlockCh7 = true;
        }

        if (Ref.countOfUnlockCreatures == 20) {
            Sounds.playAchievementUnlockSound(getActivity());
            binding.achievementLayout.setVisibility(View.VISIBLE);
            binding.achievementImg.setImageResource(R.drawable.achie_grand_master);
            Ref.isUnlockCh8 = true;
            Ref.isUnlockCh9 = true;
            Ref.isUnlockCh10 = true;
        }
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == binding.monster1.getId()) {
            Sounds.playDragonClickSound(getActivity());
            one++;
            monster1 = true;
            if (one == 2) {
                monster1 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                one = 0;
                clickCounter = 0;
                drawableUnselected();
            } else {
                clickCounter++; //this one for two clicks on creatures //click counter
                clickedCreatures.add(1);
                binding.monster1.setImageResource(R.drawable.ic_monster1_shadow);
                onImageViewClick();
            }

        } else if (view.getId() == binding.monster2.getId()) {
            Sounds.playMonsterClickSound(getActivity());
            monster2 = true;
            two++;
            if (two == 2) {
                monster2 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                two = 0;
                clickCounter = 0;
                drawableUnselected();
            } else {
                clickCounter++;
                clickedCreatures.add(2);
                binding.monster2.setImageResource(R.drawable.ic_monster2_shadow);
                onImageViewClick();
            }
        } else if (view.getId() == binding.monster3.getId()) {
            Sounds.playMonsterClickSound(getActivity());
            monster3 = true;
            three++;
            if (three == 2) {
                monster3 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                clickCounter = 0;
                three = 0;
                drawableUnselected();
            } else {
                clickCounter++;
                clickedCreatures.add(3);
                binding.monster3.setImageResource(R.drawable.ic_monster3_shadow);
                onImageViewClick();
            }
        } else if (view.getId() == binding.monster4.getId()) {
            Sounds.playDragonClickSound(getActivity());
            monster4 = true;
            four++;
            if (four == 2) {
                monster4 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                clickCounter = 0;
                four = 0;
                drawableUnselected();
            } else {
                clickCounter++;
                clickedCreatures.add(4);
                binding.monster4.setImageResource(R.drawable.ic_monster4_shadow);
                onImageViewClick();
            }
            //frame_2
        } else if (view.getId() == binding.monster5.getId()) {
            Sounds.playDragonClickSound(getActivity());
            monster5 = true;
            five++;
            if (five == 2) {
                monster5 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                clickCounter = 0;
                five = 0;
                drawableUnselected();
            } else {
                clickCounter++;
                clickedCreatures.add(5);
                binding.monster5.setImageResource(R.drawable.ic_monster5_shadow);
                onImageViewClick();
            }
        } else if (view.getId() == binding.monster6.getId()) {
            Sounds.playMonsterClickSound(getActivity());
            monster6 = true;
            six++;
            if (six == 2) {
                monster6 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                clickCounter = 0;
                six = 0;
                drawableUnselected();
            } else {
                clickCounter++;
                clickedCreatures.add(6);
                binding.monster6.setImageResource(R.drawable.ic_monster6_shadow);

                onImageViewClick();
            }
        } else if (view.getId() == binding.monster7.getId()) {
            Sounds.playMonsterClickSound(getActivity());
            monster7 = true;
            seven++;
            if (seven == 2) {
                monster7 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                clickCounter = 0;
                seven = 0;
                drawableUnselected();
            } else {
                clickCounter++;
                clickedCreatures.add(7);
                binding.monster7.setImageResource(R.drawable.ic_monster7_shadow);
                onImageViewClick();
            }
        } else if (view.getId() == binding.monster8.getId()) {
            Sounds.playDragonClickSound(getActivity());
            monster8 = true;
            eight++;
            if (eight == 2) {
                monster8 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                clickCounter = 0;
                eight = 0;
                drawableUnselected();
            } else {
                clickCounter++;
                clickedCreatures.add(8);
                binding.monster8.setImageResource(R.drawable.ic_monster8_shadow);
                onImageViewClick();
            }
        } else if (view.getId() == binding.monster9.getId()) {
            Sounds.playDragonClickSound(getActivity());
            monster9 = true;
            nine++;
            if (nine == 2) {
                monster9 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                clickCounter = 0;
                nine = 0;
                drawableUnselected();
            } else {
                clickCounter++;
                clickedCreatures.add(9);
                binding.monster9.setImageResource(R.drawable.ic_monster9_shadow);
                onImageViewClick();
            }
        } else if (view.getId() == binding.monster10.getId()) {
            Sounds.playMonsterClickSound(getActivity());
            monster10 = true;
            ten++;
            if (ten == 2) {
                monster10 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                clickCounter = 0;
                ten = 0;
                drawableUnselected();
            } else {
                clickCounter++;
                clickedCreatures.add(10);
                binding.monster10.setImageResource(R.drawable.ic_monster10_shadow);
                onImageViewClick();
            }
        } else if (view.getId() == binding.monster11.getId()) {
            Sounds.playMonsterClickSound(getActivity());
            monster11 = true;
            eleven++;
            if (eleven == 2) {
                monster11 = false;
                Snackbar.make(binding.monster1, "You already selected this creature, Select different creatures!", 1000).show();
                clickCounter = 0;
                eleven = 0;
                drawableUnselected();
            } else {
                clickCounter++;
                clickedCreatures.add(11);
                binding.monster11.setImageResource(R.drawable.ic_monster11_shadow);
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
            five = 0;
            six = 0;
            seven = 0;
            eight = 0;
            //
            nine = 0;
            ten = 0;
            eleven = 0;

            monster1 = false;
            monster2 = false;
            monster3 = false;
            monster4 = false;
            //
            monster5 = false;
            monster6 = false;
            monster7 = false;
            monster8 = false;
            //
            monster9 = false;
            monster10 = false;
            monster11 = false;
            //
            clickedCreatures.clear();

            //drawable selection remove
            drawableUnselected();
        }

    }

    private void drawableUnselected() {
        binding.monster1.setImageResource(R.drawable.ic_monster1);
        binding.monster2.setImageResource(R.drawable.ic_monster2);
        binding.monster3.setImageResource(R.drawable.ic_monster3);
        binding.monster4.setImageResource(R.drawable.ic_monster4);
        binding.monster5.setImageResource(R.drawable.ic_monster5);
        binding.monster6.setImageResource(R.drawable.ic_monster6);
        binding.monster7.setImageResource(R.drawable.ic_monster7);
        binding.monster8.setImageResource(R.drawable.ic_monster8);
        binding.monster9.setImageResource(R.drawable.ic_monster9);
        binding.monster10.setImageResource(R.drawable.ic_monster10);
        binding.monster11.setImageResource(R.drawable.ic_monster11);

    }

    private void performAction() {

        int firstCreature = clickedCreatures.get(0);
        int secondCreature = clickedCreatures.get(1);
        //
        if (firstCreature == 3 && secondCreature == 7) { //new add

            //if it trues then it already unlocked
            if (Ref.creature37) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();
            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_37);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature37 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }

        } else if (firstCreature == 1 && secondCreature == 2) {

            //if it trues then it already unlocked
            if (Ref.creature12) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();
            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_12);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature12 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }

        } else if (firstCreature == 1 & secondCreature == 4) {

            if (Ref.creature14) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();
            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_14);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature14 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 2 & secondCreature == 3) {
            if (Ref.creature23) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_23);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature23 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }

        } else if (firstCreature == 3 & secondCreature == 2) {
            if (Ref.creature32) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_32);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature32 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 2 & secondCreature == 7) {
            if (Ref.creature27) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_27);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature27 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 6 & secondCreature == 7) {
            if (Ref.creature67) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_67);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature67 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 3 & secondCreature == 11) {
            if (Ref.creature311) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_311);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature311 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 10 & secondCreature == 7) {
            if (Ref.creature107) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_107);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature107 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 10 & secondCreature == 3) {
            if (Ref.creature103) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_103);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature103 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 10 & secondCreature == 6) {
            if (Ref.creature106) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_106);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature106 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 6 & secondCreature == 11) {
            if (Ref.creature611) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_611);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature611 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 11 & secondCreature == 9) {
            if (Ref.creature119) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_119);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature119 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 11 & secondCreature == 4) {
            if (Ref.creature114) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_114);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature114 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 8 & secondCreature == 6) {
            if (Ref.creature86) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_86);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature86 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 10 & secondCreature == 9) {
            if (Ref.creature109) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_109);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature109 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 7 & secondCreature == 8) {
            if (Ref.creature78) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_78);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature78 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 5 & secondCreature == 10) {
            if (Ref.creature510) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_510);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature510 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 11 & secondCreature == 8) {
            if (Ref.creature118) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_118);
                        Snackbar.make(binding.newCreature, R.string.new_creature_unlocked, 1000).show();
                        Ref.creature118 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        } else if (firstCreature == 7 & secondCreature == 5) {
            if (Ref.creature75) {
                Snackbar.make(binding.newCreature, R.string.creature_already_unlocked, 1000).show();

            } else {
                binding.resultLayout.setVisibility(View.VISIBLE);
                binding.newCreature.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.newCreature.setImageResource(R.drawable.creature_merge_by_75);
                        Snackbar.make(binding.newCreature.getRootView(), R.string.new_creature_unlocked, 1000).show();
                        Ref.creature75 = true;
                        Ref.countOfUnlockCreatures++;
                    }
                }, 2000);
            }
        }

    }

    //
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
        if (Ref.creature37) {
            binding.creature21.setImageResource(R.drawable.creature_merge_by_37);

        }
    }
}