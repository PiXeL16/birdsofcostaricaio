package com.greenpixels.birdsofcostarica.utils;

import android.content.Context;

import rx.android.internal.Preconditions;


public class StringFetcher implements IStringFetcher {

        private final Context mContext;

        public StringFetcher(Context context) {
            mContext = Preconditions.checkNotNull(context, "context cannot be null");
        }

        @Override
        public String getString(int id) {
            return mContext.getString(id);
        }

        @Override
        public String getString(int id, Object... format) {
            return mContext.getString(id, format);
        }
    }

