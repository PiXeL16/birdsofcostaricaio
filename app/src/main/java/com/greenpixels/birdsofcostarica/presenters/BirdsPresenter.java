package com.greenpixels.birdsofcostarica.presenters;

import com.greenpixels.birdsofcostarica.events.BusProvider;
import com.greenpixels.birdsofcostarica.views.BirdsView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Inject;

/**
 * Presenter for the Birds Functionality
 *
 * @author PiXeL16
 * @date 5/26/15
 */
public class BirdsPresenter extends MvpBasePresenter<BirdsView> {

    SqlBrite _db;

    @Inject public BirdsPresenter(SqlBrite db) {

        this._db = db;
    }

    public void loadBirds()
    {

        if(isViewAttached())
        {
            getView().showLoading(false);
        }


        getView().setData(null);
        getView().showContent();


    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);

//        if (!retainInstance) {
            BusProvider.getInstance().unregister(this);
//        }


    }


    @Override
    public void attachView(BirdsView view) {
        super.attachView(view);
        BusProvider.getInstance().register(this);
    }

}
