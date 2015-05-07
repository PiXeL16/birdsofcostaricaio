package com.greenpixels.birdsofcostarica.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Clase para sonar sonidos, duh
 *
 * @author PiXeL16
 * @date 10/3/14
 */
public class SoundUtils {

    private static SoundPool _soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

    public static void playSound(int soundID, Context context) {
        _soundPool.load(context, soundID, 1);
        _soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                _soundPool.play(sampleId, 1, 1, 0, 0, 1);
            }
        });
    }
}
