package com.greenpixels.birdsofcostarica.db;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import javax.inject.Inject;

/**
 * DB Helper that handles the db migration from assets to resources folder to be used
 *
 * @author PiXeL16
 * @date 5/27/15
 */
public class DBOpenHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "birdsofcostarica.db";
    private static final int DATABASE_VERSION = 1;

    @Inject public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
