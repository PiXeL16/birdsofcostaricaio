package com.greenpixels.birdsofcostarica.injection.components;

import com.bumptech.glide.util.Util;
import com.greenpixels.birdsofcostarica.adapters.BirdsListAdapter;
import com.greenpixels.birdsofcostarica.injection.modules.ContextProvider;
import com.greenpixels.birdsofcostarica.injection.modules.DBProvider;
import com.greenpixels.birdsofcostarica.fragments.BirdListFragment;
import com.greenpixels.birdsofcostarica.injection.modules.UtilProvider;
import com.greenpixels.birdsofcostarica.presenters.BirdsListPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Component for dependency inyection of Fragment
 *
 * @author PiXeL16
 * @date 5/27/15
 */
@Singleton
@Component(
        dependencies = AppComponent.class,
        modules = {ContextProvider.class,DBProvider.class, UtilProvider.class}
)
public interface BirdListFragmentComponent {

    void inject (BirdListFragment listFragment);

    BirdsListPresenter presenter();

    BirdsListAdapter adapter();
}