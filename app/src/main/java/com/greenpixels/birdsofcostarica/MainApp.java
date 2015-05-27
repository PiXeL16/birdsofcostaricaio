package com.greenpixels.birdsofcostarica;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.facebook.stetho.Stetho;
import com.greenpixels.birdsofcostarica.utils.ForegroundUtils;
import com.greenpixels.birdsofcostarica.utils.LogUtils;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import timber.log.Timber;

/**
 * Main App
 *
 * @author PiXeL16
 * @date 5/6/15
 */
public class MainApp extends Application {

    private static MainApp instance;
    private static final String TAG = LogUtils.makeLogTag(MainApp.class);

    // Monitors Memory Leaks
    private RefWatcher refWatcher;


    @Override
    public void onCreate() {
        super.onCreate();
        this.init();
    }

    public void init()
    {
        //RequestManager.init(this);
        ForegroundUtils.init(this);
        //Leak Tracking
        refWatcher = LeakCanary.install(this);
        //Logging
        Timber.plant(new Timber.DebugTree());

        //Remote Debugging
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }


    public MainApp() {
        instance = this;
    }

    @NonNull
    public static Context getContext() {
        return instance;
    }

    @NonNull
    public static MainApp get(@NonNull Context context) {
        return (MainApp) context.getApplicationContext();
    }

    @NonNull
    public static Application getApplication() {
        return instance;
    }

    @NonNull
    public RefWatcher refWatcher() {
        return refWatcher;
    }


}
