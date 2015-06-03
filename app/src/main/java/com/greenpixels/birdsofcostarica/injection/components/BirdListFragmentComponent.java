package com.greenpixels.birdsofcostarica.injection.components;

import com.greenpixels.birdsofcostarica.adapters.BirdsListAdapter;
import com.greenpixels.birdsofcostarica.injection.modules.ActivityModule;
import com.greenpixels.birdsofcostarica.injection.modules.DBModule;
import com.greenpixels.birdsofcostarica.fragments.BirdListFragment;
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
        modules = {ActivityModule.class,DBModule.class}
)
public interface BirdListFragmentComponent {

    void inject (BirdListFragment listFragment);

    BirdsListPresenter presenter();

    BirdsListAdapter adapter();
}