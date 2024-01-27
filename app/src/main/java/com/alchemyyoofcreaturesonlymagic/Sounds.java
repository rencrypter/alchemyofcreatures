package com.alchemyyoofcreaturesonlymagic;

import android.content.Context;
import android.media.MediaPlayer;

public class Sounds {


    private static MediaPlayer mediaPlayer;

    public static void playButtonClickSound(Context context) {
        playSound(context, R.raw.other_buttons);
    }

    public static void playDiaryBtnSound(Context context) {
        playSound(context, R.raw.diary_buttons);
    }

    public static void playAchievementUnlockSound(Context context) {
        playSound(context, R.raw.getting_an_achievement);
    }

    public static void playMonsterClickSound(Context context) {
        playSound(context, R.raw.monster_sound_when_you_click_on_it);
    }
    public static void playDragonClickSound(Context context) {
        playSound(context, R.raw.dragon_sound_when_you_click_on_it);
    }

    private static void playSound(Context context, int soundResourceId) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(context, soundResourceId);
        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });
        }
    }
}