package com.greenpixels.birdsofcostarica.utils;

import android.content.Context;
import android.os.Vibrator;


/**
 * Clase que vibra, colocar el dispositivo cerca de un lugar sensible
 *
 * @author PiXeL16
 * @date 10/3/14
 */
public class VibratorUtils {

    public static void vibrate(int length, Context context)
    {
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(length);
    }

}
