package com.greenpixels.birdsofcostarica.activities;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;

import com.greenpixels.birdsofcostarica.MainApp;
import com.greenpixels.birdsofcostarica.R;
import com.greenpixels.birdsofcostarica.injection.components.AppComponent;
import com.greenpixels.birdsofcostarica.injection.components.BirdDetailActivityComponent;
import com.greenpixels.birdsofcostarica.injection.components.DaggerBirdDetailActivityComponent;
import com.greenpixels.birdsofcostarica.injection.modules.ContextProvider;
import com.greenpixels.birdsofcostarica.injection.modules.DBProvider;
import com.greenpixels.birdsofcostarica.injection.modules.UtilProvider;
import com.greenpixels.birdsofcostarica.models.Bird;
import com.greenpixels.birdsofcostarica.presenters.BirdPresenter;
import com.greenpixels.birdsofcostarica.utils.StringFetcher;
import com.greenpixels.birdsofcostarica.views.GeneralTextCard;
import com.greenpixels.birdsofcostarica.views.BirdView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceActivity;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * Detail Activity for Element
 *
 * @author PiXeL16
 * @date 6/2/15
 */
public class BirdDetailActivity extends MvpLceActivity <CoordinatorLayout,Bird,BirdView,BirdPresenter> implements BirdView {

    @InjectView(R.id.toolbar) Toolbar _toolbar;
    @InjectView(R.id.collapsing_toolbar) CollapsingToolbarLayout _collapsingToolbar;
    @InjectView(R.id.cards_container) LinearLayout _cardContainer;

    @Inject
    StringFetcher _stringFetcher;

    BirdDetailActivityComponent _component;

    @Override protected void injectDependencies() {

        AppComponent appComponent = MainApp.get(this).appComponent();

        _component = DaggerBirdDetailActivityComponent
                .builder()
                .appComponent(appComponent)
                .contextProvider(new ContextProvider(this))
                .dBProvider(new DBProvider())
                .utilProvider(new UtilProvider())
                .build();

        _component.inject(this);


    }


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bird_detail);

        setSupportActionBar(_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //For paralax effect
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setStatusBarColor(Color.TRANSPARENT);
        }

        _collapsingToolbar.setTitle(_stringFetcher.getString(R.string.app_name));


        loadData(false);

        addCards();
    }

    private void addCards()
    {

        for(int i=0;i<5;i++)
        {
            GeneralTextCard card = new GeneralTextCard(this);
            card.setCardBody("tasdfa sdf asdf asdf asdf asd fasdf ");
            card.setCardTitle("This is a test");
            _cardContainer.addView(card);
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
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
