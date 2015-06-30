package com.greenpixels.birdsofcostarica.injection.modules;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.greenpixels.birdsofcostarica.db.DBOpenHelper;
import com.greenpixels.birdsofcostarica.utils.StringFetcher;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

/**
 * Created by chris on 6/29/15.
 */

@Module(
        includes = ContextProvider.class
)
public class UtilProvider {

    @Provides
    @NonNull
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides @Singleton
    public StringFetcher provideStringFetcher(Context context) {
        return new StringFetcher(context);
    }

}
