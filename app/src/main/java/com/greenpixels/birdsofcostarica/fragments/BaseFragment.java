package com.greenpixels.birdsofcostarica.fragments;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.greenpixels.birdsofcostarica.MainApp;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Base Fragment to extends
 *
 * @author PiXeL16
 * @date 5/21/15
 */
public class BaseFragment extends Fragment {

    @NonNull
    private final CompositeSubscription compositeSubscriptionForOnStop = new CompositeSubscription();

    protected void unsubscribeOnStop(@NonNull Subscription subscription) {
        compositeSubscriptionForOnStop.add(subscription);
    }

    @Override
    public void onStop() {
        compositeSubscriptionForOnStop.clear();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainApp.get(getActivity()).refWatcher().watch(this);
    }


}
