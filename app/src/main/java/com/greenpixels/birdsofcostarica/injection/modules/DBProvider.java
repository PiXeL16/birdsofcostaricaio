package com.greenpixels.birdsofcostarica.injection.modules;

/**
 * DB Module for inyection
 *
 * @author PiXeL16
 * @date 5/27/15
 */

import android.app.Application;
import android.support.annotation.NonNull;

import com.greenpixels.birdsofcostarica.BuildConfig;
import com.greenpixels.birdsofcostarica.db.DBOpenHelper;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import timber.log.Timber;

@Module
public class DBProvider {

    @Provides @NonNull @Singleton
    DBOpenHelper provideOpenHelper(Application application) {
        return new DBOpenHelper(application);
    }

    @Provides @NonNull @Singleton SqlBrite provideSqlBrite(DBOpenHelper openHelper) {
        SqlBrite db = SqlBrite.create(openHelper);

        if (BuildConfig.DEBUG) {
            db.setLogger(new SqlBrite.Logger() {
                @Override public void log(String message) {
                    Timber.tag("Database").v(message);
                }
            });
            db.setLoggingEnabled(true);
        }

        return db;
    }
}