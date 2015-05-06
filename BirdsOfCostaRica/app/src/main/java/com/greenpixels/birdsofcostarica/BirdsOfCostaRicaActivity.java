package com.greenpixels.birdsofcostarica;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.greenpixels.birdsofcostarica.utils.AlertUtils;
import com.greenpixels.birdsofcostarica.utils.PlayServicesUtils;

/**
 * Main Activity that other activities should extend
 *
 * @author PiXeL16
 * @date 5/6/15
 */
public abstract class BirdsOfCostaRicaActivity extends ActionBarActivity implements IListener{

    public abstract void init();


    public BirdsOfCostaRicaActivity()
    {
        super();
    }


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    public void checkPlayServices()
    {
        PlayServicesUtils.checkGooglePlaySevices(this);
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

}
