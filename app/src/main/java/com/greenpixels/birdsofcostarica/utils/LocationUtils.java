package com.greenpixels.birdsofcostarica.utils;

import android.location.Location;

/**
 * Random location utils
 *
 * @author PiXeL16
 * @date 9/23/14
 */
public class LocationUtils {

    public static String format(Location location) {
        return String.format("%s,%s", location.getLatitude(), location.getLongitude());
    }
}
