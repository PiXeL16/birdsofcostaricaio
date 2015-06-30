package com.greenpixels.birdsofcostarica.presenters;

import com.greenpixels.birdsofcostarica.db.BirdDBManager;
import com.greenpixels.birdsofcostarica.event.TestEvent;
import com.greenpixels.birdsofcostarica.models.Bird;
import com.greenpixels.birdsofcostarica.views.BirdsListView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.squareup.sqlbrite.SqlBrite;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
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
public class BirdsListPresenter extends MvpBasePresenter<BirdsListView> {

    private SqlBrite _db;
    private Subscription _subscription;
    protected EventBus _eventBus;


    @Inject public BirdsListPresenter(SqlBrite db, EventBus eventBus) {

        this._db = db;
        this._eventBus = eventBus;
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

        if (!retainInstance) {
            _eventBus.unregister(this);
        }
        if(_subscription != null)
        _subscription.unsubscribe();

    }


    @Override
    public void attachView(BirdsListView view) {
        super.attachView(view);
        _eventBus.register(this);
    }

    public void onEventMainThread(TestEvent event) {
//        if (isViewAttached()) {
//        }
    }


}
