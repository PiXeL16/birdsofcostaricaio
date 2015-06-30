package com.greenpixels.birdsofcostarica.presenters;

import android.app.usage.UsageEvents;

import com.greenpixels.birdsofcostarica.event.TestEvent;
import com.greenpixels.birdsofcostarica.views.BirdView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import rx.Subscription;

/**
 * Bird Activity Presenter
 *
 * @author PiXeL16
 * @date 6/2/15
 */
public class BirdPresenter extends MvpBasePresenter<BirdView> {

    private SqlBrite _db;
    private Subscription _subscription;
    protected EventBus _eventBus;

    @Inject
    public BirdPresenter(SqlBrite db, EventBus eventBus) {
        _eventBus = eventBus;
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

        _eventBus.unregister(this);

        if(_subscription != null)
        _subscription.unsubscribe();

    }


    @Override
    public void attachView(BirdView view) {
        super.attachView(view);

        _eventBus.register(this);
    }

    public void onEventMainThread(TestEvent event) {
//        if (isViewAttached()) {
//        }
    }


}
