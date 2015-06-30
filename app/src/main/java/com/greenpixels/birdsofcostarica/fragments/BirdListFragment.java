package com.greenpixels.birdsofcostarica.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.greenpixels.birdsofcostarica.MainApp;
import com.greenpixels.birdsofcostarica.R;
import com.greenpixels.birdsofcostarica.adapters.BirdsListAdapter;
import com.greenpixels.birdsofcostarica.injection.components.AppComponent;
import com.greenpixels.birdsofcostarica.injection.components.BirdListFragmentComponent;
import com.greenpixels.birdsofcostarica.injection.components.DaggerBirdListFragmentComponent;
import com.greenpixels.birdsofcostarica.injection.modules.ContextProvider;
import com.greenpixels.birdsofcostarica.injection.modules.DBProvider;
import com.greenpixels.birdsofcostarica.injection.modules.UtilProvider;
import com.greenpixels.birdsofcostarica.models.Bird;
import com.greenpixels.birdsofcostarica.presenters.BirdsListPresenter;
import com.greenpixels.birdsofcostarica.views.BirdsListView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;

import java.util.List;

import butterknife.InjectView;
import xyz.danoz.recyclerviewfastscroller.vertical.VerticalRecyclerViewFastScroller;

/**
 * Frament to show the main list of birds
 *
 * @author PiXeL16
 * @date 5/26/15
 */
public class BirdListFragment extends MvpLceFragment<LinearLayout,List<Bird>,BirdsListView,BirdsListPresenter> implements BirdsListView {


    @InjectView(R.id.recyclerView) RecyclerView _recyclerView;
    @InjectView(R.id.fast_scroller) VerticalRecyclerViewFastScroller _verticalFastScroller;

    BirdsListAdapter adapter;

    BirdListFragmentComponent birdListFragmentComponent;

    @Override protected void injectDependencies() {

        AppComponent appComponent = MainApp.get(this.getActivity()).appComponent();

        birdListFragmentComponent = DaggerBirdListFragmentComponent
                .builder()
                .appComponent(appComponent)
                .contextProvider(new ContextProvider(this.getActivity()))
                .dBProvider(new DBProvider())
                .utilProvider(new UtilProvider())
                .build();

        birdListFragmentComponent.inject(this);

    }


    @Override public void onViewCreated(View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);

        // Setup recycler view
        adapter = birdListFragmentComponent.adapter();

        _recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        _recyclerView.setAdapter(adapter);

        _verticalFastScroller.setRecyclerView(_recyclerView);

        _recyclerView.setOnScrollListener(_verticalFastScroller.getOnScrollListener());

        loadData(false);
    }


    @Override
    protected String getErrorMessage(Throwable throwable, boolean pullToRefresh) {

        return this.getString(R.string.general_error_message);

    }

    @Override
    public BirdsListPresenter createPresenter() {
       return birdListFragmentComponent.presenter();
    }

    @Override protected int getLayoutRes() {
        return R.layout.fragment_bird_list;
    }

    @Override
    public void setData(List<Bird> data) {
        adapter.setBirds(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadData(boolean pullToRefresh) {

        presenter.loadBirds();

    }
}
