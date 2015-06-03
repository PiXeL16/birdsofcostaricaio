package com.greenpixels.birdsofcostarica.presenters;

import com.greenpixels.birdsofcostarica.db.BirdDBManager;
import com.greenpixels.birdsofcostarica.events.BusProvider;
import com.greenpixels.birdsofcostarica.models.Bird;
import com.greenpixels.birdsofcostarica.views.BirdView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.squareup.sqlbrite.SqlBrite;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Bird Activity Presenter
 *
 * @author PiXeL16
 * @date 6/2/15
 */
public class BirdPresenter extends MvpBasePresenter<BirdView> {

    private SqlBrite _db;
    private Subscription _subscription;

    @Inject
    public BirdPresenter(SqlBrite db) {

        this._db = db;
    }

    public void loadBirdById(long id)
    {

//        if(isViewAttached())
//        {
//            getView().showLoading(false);
//        }
//
//        _subscription = _db.createQuery(BirdDBManager.TABLE, BirdDBManager.QUERY)
//                .map(BirdDBManager.MAP)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<List<Bird>>() {
//                    @Override
//                    public void call(List<Bird> birds) {
//
//                        getView().setData(birds.get(0));
//                        getView().showContent();
//
//                    }
//                });

        getView().showContent();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);

        BusProvider.getInstance().unregister(this);

        if(_subscription != null)
        _subscription.unsubscribe();

    }


    @Override
    public void attachView(BirdView view) {
        super.attachView(view);
        BusProvider.getInstance().register(this);
    }


}
