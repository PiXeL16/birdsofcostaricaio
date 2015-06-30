package com.greenpixels.birdsofcostarica.injection.modules;

import android.content.Context;

import com.greenpixels.birdsofcostarica.injection.scope.Activity;

import dagger.Module;
import dagger.Provides;
import rx.android.internal.Preconditions;

/**
 * Module to provide context of activities
 *
 * @author PiXeL16
 * @date 6/3/15
 */
@Module
public class ContextProvider {

    private final Context _context;

    public ContextProvider(Context context) {

        this._context = Preconditions.checkNotNull(context, "context cannot be null");;
    }

    @Provides
    Context provideActivityContext() {
        return _context;
    }
}
