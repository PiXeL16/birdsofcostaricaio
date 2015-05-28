package com.greenpixels.birdsofcostarica;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.facebook.stetho.Stetho;
import com.greenpixels.birdsofcostarica.inyection.components.AppComponent;
import com.greenpixels.birdsofcostarica.inyection.components.DaggerAppComponent;
import com.greenpixels.birdsofcostarica.inyection.modules.AppModule;
import com.greenpixels.birdsofcostarica.utils.ForegroundUtils;
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

    // Monitors Memory Leaks
    private RefWatcher refWatcher;

    @Nullable
    private volatile AppComponent appComponent;


    private static MainApp instance;


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
    public AppComponent appComponent() {
        if (appComponent == null) {
            synchronized (MainApp.class) {
                if (appComponent == null) {
                    appComponent = createAppComponent();
                }
            }
        }

        //noinspection ConstantConditions
        return appComponent;
    }

    @NonNull
    private AppComponent createAppComponent() {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();

    }

    @NonNull
    public RefWatcher refWatcher() {
        return refWatcher;
    }


}
