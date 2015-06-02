package com.greenpixels.birdsofcostarica.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.greenpixels.birdsofcostarica.R;
import com.greenpixels.birdsofcostarica.utils.PlayServicesUtils;
import com.hannesdorfmann.mosby.MosbyActivity;

/**
 * Base Activity that other activities should extend
 *
 * @author PiXeL16
 * @date 5/6/15
 */
public abstract class BaseActivity extends MosbyActivity {

    @Nullable
    private Toolbar _toolbar;


    public BaseActivity()
    {
        super();
    }


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        setupToolbar();
    }

    protected void setupToolbar() {
        _toolbar = getView(R.id.toolbar);

        if (_toolbar != null) {
            setSupportActionBar(_toolbar);
        }
    }


    @Nullable
    protected Toolbar getToolbar() {
        return _toolbar;
    }

    public void checkPlayServices()
    {
        //PlayServicesUtils.checkGooglePlaySevices(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @SuppressWarnings("unchecked")
    public final <E extends View> E getView (int id) {
        try {
            return (E) findViewById(id);
        } catch (ClassCastException ex) {
            //Timber.e("Could not cast View to concrete class.", ex);
            throw ex;
        }
    }

    protected boolean homeAsBackButton() {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home && homeAsBackButton()) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

}
