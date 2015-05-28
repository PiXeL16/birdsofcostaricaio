package com.greenpixels.birdsofcostarica.presenters;

import com.greenpixels.birdsofcostarica.db.BirdDBManager;
import com.greenpixels.birdsofcostarica.events.BusProvider;
import com.greenpixels.birdsofcostarica.models.Bird;
import com.greenpixels.birdsofcostarica.views.BirdsView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.squareup.sqlbrite.SqlBrite;

import java.util.List;

import javax.inject.Inject;

import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Presenter for the Birds Functionality
 *
 * @author PiXeL16
 * @date 5/26/15
 */
public class BirdsPresenter extends MvpBasePresenter<BirdsView> {

    private SqlBrite _db;
    private Subscription _subscription;


    @Inject public BirdsPresenter(SqlBrite db) {

        this._db = db;
    }

    public void loadBirds()
    {

        if(isViewAttached())
        {
            getView().showLoading(false);
        }

        _subscription = _db.createQuery(BirdDBManager.TABLE, BirdDBManager.QUERY)
                .map(BirdDBManager.MAP)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Bird>>() {
                    @Override public void call(List<Bird> birds) {

                        getView().setData(birds);
                        getView().showContent();

                    }
                });

    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);

//        if (!retainInstance) {
            BusProvider.getInstance().unregister(this);
//        }
        _subscription.unsubscribe();

    }


    @Override
    public void attachView(BirdsView view) {
        super.attachView(view);
        BusProvider.getInstance().register(this);
    }

}
