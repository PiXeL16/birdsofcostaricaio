package com.greenpixels.birdsofcostarica.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;

import com.greenpixels.birdsofcostarica.MainApp;
import com.greenpixels.birdsofcostarica.R;
import com.greenpixels.birdsofcostarica.injection.components.AppComponent;
import com.greenpixels.birdsofcostarica.injection.components.BirdDetailActivityComponent;
import com.greenpixels.birdsofcostarica.injection.components.DaggerBirdDetailActivityComponent;
import com.greenpixels.birdsofcostarica.injection.modules.ActivityModule;
import com.greenpixels.birdsofcostarica.injection.modules.DBModule;
import com.greenpixels.birdsofcostarica.models.Bird;
import com.greenpixels.birdsofcostarica.presenters.BirdPresenter;
import com.greenpixels.birdsofcostarica.views.BirdView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceActivity;

/**
 * Detail Activity for Elementes
 *
 * @author PiXeL16
 * @date 6/2/15
 */
public class BirdDetailActivity extends MvpLceActivity <CoordinatorLayout,Bird,BirdView,BirdPresenter> implements BirdView {



//    @InjectView(R.id.recyclerView) RecyclerView recyclerView;
//
//    CountriesAdapter adapter;

    BirdDetailActivityComponent _component;

    @Override protected void injectDependencies() {

        AppComponent appComponent = MainApp.get(this).appComponent();

        _component = DaggerBirdDetailActivityComponent
                .builder()
                .appComponent(appComponent)
                .activityModule(new ActivityModule(this))
                .dBModule(new DBModule())
                .build();

        _component.inject(this);

    }


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_detail);


        loadData(false);
    }

    @Override protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    public void loadData(boolean pullToRefresh) {
        presenter.loadBirdById(0);
    }


    @Override
    protected String getErrorMessage(Throwable throwable, boolean b) {
        return this.getString(R.string.general_error_message);
    }

    @Override
    public BirdPresenter createPresenter() {
        return _component.presenter();
    }

    @Override
    public void setData(Bird data) {

    }

}
