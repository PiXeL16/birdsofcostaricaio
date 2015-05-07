package com.greenpixels.birdsofcostarica;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.greenpixels.birdsofcostarica.utils.AlertUtils;


public class MainActivity extends BirdsOfCostaRicaActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void init() {

    }


    @Override
    public void onResume()
    {
        super.onResume();

        AlertUtils.showErrorDialog("test", "test", this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void addListeners() {

    }

    @Override
    public void removeListeners() {

    }
}