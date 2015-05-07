package com.greenpixels.birdsofcostarica;

import android.app.Application;
import android.content.Context;

import com.greenpixels.birdsofcostarica.utils.ForegroundUtils;
import com.greenpixels.birdsofcostarica.utils.LogUtils;

/**
 * Main App
 *
 * @author PiXeL16
 * @date 5/6/15
 */
public class BirdsOfCostaRicaApplication extends Application {

    private static BirdsOfCostaRicaApplication instance;
    private static final String TAG = LogUtils.makeLogTag(BirdsOfCostaRicaApplication.class);


    @Override
    public void onCreate() {
        super.onCreate();
        this.init();
    }
    public void init()
    {
//        RequestManager.init(this);
        ForegroundUtils.init(this);

    }

    public BirdsOfCostaRicaApplication() {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }

    public static Application getApplication() {
        return instance;
    }




}
