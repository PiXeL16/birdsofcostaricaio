/*
 * Copyright 2014 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.greenpixels.birdsofcostarica.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

import static com.greenpixels.birdsofcostarica.utils.LogUtils.LOGE;
import static com.greenpixels.birdsofcostarica.utils.LogUtils.LOGD;
import static com.greenpixels.birdsofcostarica.utils.LogUtils.LOGI;
import static com.greenpixels.birdsofcostarica.utils.LogUtils.makeLogTag;

/**
 * Helper for Google Play services-related operations.
 */
public class PlayServicesUtils {

    private final static String TAG = makeLogTag(PlayServicesUtils.class);

    public static boolean checkGooglePlaySevices(final Activity activity) {

        boolean returnValue = false;

        final int googlePlayServicesCheck = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        switch (googlePlayServicesCheck) {
            case ConnectionResult.SUCCESS:
                LOGD(TAG,"Play service available");
                returnValue = true;
                break;
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
            case ConnectionResult.SERVICE_DISABLED:
            case ConnectionResult.SERVICE_INVALID:
            case ConnectionResult.SERVICE_MISSING:
                returnValue = false;
                LOGE(TAG,"Play service unavailable");
                LOGE(TAG, GooglePlayServicesUtil.getErrorString(googlePlayServicesCheck));
                showErrorDialog(googlePlayServicesCheck,activity);
                break;



        }
        return returnValue;
    }

    private static void showErrorDialog(int googlePlayServicesCheck ,final Activity activity)
    {
        if (GooglePlayServicesUtil.isUserRecoverableError(googlePlayServicesCheck)) {

            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(googlePlayServicesCheck, activity, 0);
            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialogInterface) {

                    activity.finish();

                }
            });
            dialog.show();
        }else
        {
            LOGI(TAG,"This device is not supported");
        }

    }


    public static boolean checkGooglePlaySevices(final Context context) {

        boolean returnValue = false;
        final int googlePlayServicesCheck = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        switch (googlePlayServicesCheck) {
            case ConnectionResult.SUCCESS:
                LOGD(TAG,"Play service available");
                returnValue =  true;
                break;
            case ConnectionResult.SERVICE_DISABLED:
            case ConnectionResult.SERVICE_INVALID:
            case ConnectionResult.SERVICE_MISSING:
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
                LOGE(TAG,"Play service unavailable");
                break;

        }
        return returnValue;
    }
}
