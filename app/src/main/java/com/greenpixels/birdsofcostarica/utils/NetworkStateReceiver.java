package com.greenpixels.birdsofcostarica.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Heriberto Ureña Madrigal on 09/10/2014.
 */
public class NetworkStateReceiver extends BroadcastReceiver {
    private static final String TAG = "NetworkStateReceiver";

    @Override
    public void onReceive(final Context context, final Intent intent) {
//        if (intent.getExtras() != null) {
//            final ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
//            final NetworkInfo ni = connectivityManager.getActiveNetworkInfo();
//            if (ni != null && ni.isConnectedOrConnecting()) {
//                BusProvider.getInstance().post(new NetworkConnectionEvent(true));
//            } else if (intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, Boolean.FALSE)) {
//                BusProvider.getInstance().post(new NetworkConnectionEvent(false));
//            }
//        }
    }
}