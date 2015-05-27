package com.greenpixels.birdsofcostarica.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.greenpixels.birdsofcostarica.R;
import com.greenpixels.birdsofcostarica.adapters.BirdsListAdapter;
import com.greenpixels.birdsofcostarica.models.Bird;
import com.greenpixels.birdsofcostarica.presenters.BirdsPresenter;
import com.greenpixels.birdsofcostarica.views.BirdsView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;

import java.util.List;

import butterknife.InjectView;

/**
 * Frament to show the main list of birds
 *
 * @author PiXeL16
 * @date 5/26/15
 */
public class BirdListFragment extends MvpLceFragment<LinearLayout,List<Bird>,BirdsView,BirdsPresenter> implements BirdsView {


    @InjectView(R.id.recyclerView) RecyclerView _recyclerView;

    private BirdsListAdapter _adapter;


    @Override public void onViewCreated(View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);



        // Setup recycler view
        _adapter = new BirdsListAdapter(getActivity());

        _recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        _recyclerView.setAdapter(_adapter);

        loadData(false);
    }



    @Override
    protected String getErrorMessage(Throwable throwable, boolean pullToRefresh) {

        return this.getString(R.string.general_error_message);
        
    }

    @Override
    public BirdsPresenter createPresenter() {
       return new BirdsPresenter();
    }

    @Override protected int getLayoutRes() {
        return R.layout.fragment_bird_list;
    }

    @Override
    public void setData(List<Bird> data) {

        _adapter.setBirds(data);
        _adapter.notifyDataSetChanged();
    }

    @Override
    public void loadData(boolean pullToRefresh) {

        presenter.loadBirds();

    }
}
