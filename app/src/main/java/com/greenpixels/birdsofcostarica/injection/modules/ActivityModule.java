package com.greenpixels.birdsofcostarica.injection.modules;

import android.content.Context;

import com.greenpixels.birdsofcostarica.injection.scope.Activity;

import dagger.Module;
import dagger.Provides;

/**
 * Module to provide context of activities
 *
 * @author PiXeL16
 * @date 6/3/15
 */
@Module
public class ActivityModule {

    private final Context _context;

    public ActivityModule(Context context) {

        this._context = context;
    }

    @Provides
    Context provideActivityContext() {
        return _context;
    }
}
