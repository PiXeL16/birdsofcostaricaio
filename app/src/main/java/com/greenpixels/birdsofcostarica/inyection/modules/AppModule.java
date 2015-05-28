package com.greenpixels.birdsofcostarica.inyection.modules;

/**
 * Main app Module for Inyection
 *
 * @author PiXeL16
 * @date 5/27/15
 */

import android.content.Context;
import android.support.annotation.NonNull;

import com.greenpixels.birdsofcostarica.MainApp;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @NonNull
    private final MainApp application;

    public AppModule(@NonNull MainApp app) {
        this.application = app;
    }

    @Provides  Context provideContext() {
        return application;
    }
}