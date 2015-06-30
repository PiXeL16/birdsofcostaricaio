package com.greenpixels.birdsofcostarica.injection.modules;

import android.app.Application;
import android.support.annotation.NonNull;

import com.greenpixels.birdsofcostarica.db.DBOpenHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * Created by chris on 6/29/15.
 */

@Module
public class UtilProvider {

    @Provides
    @NonNull
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }


}
