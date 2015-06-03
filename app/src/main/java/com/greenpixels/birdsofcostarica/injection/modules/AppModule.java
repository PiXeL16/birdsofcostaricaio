package com.greenpixels.birdsofcostarica.injection.modules;

/**
 * Main app Module for Inyection
 *
 * @author PiXeL16
 * @date 5/27/15
 */

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.greenpixels.birdsofcostarica.MainApp;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @NonNull
    private final Application application;

    public AppModule(@NonNull Application app) {
        this.application = app;
    }

    @Provides Application provideApplication() {
        return application;
    }
}