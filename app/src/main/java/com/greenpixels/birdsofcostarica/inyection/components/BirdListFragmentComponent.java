package com.greenpixels.birdsofcostarica.inyection.components;

import com.greenpixels.birdsofcostarica.adapters.BirdsListAdapter;
import com.greenpixels.birdsofcostarica.inyection.modules.DBModule;
import com.greenpixels.birdsofcostarica.fragments.BirdListFragment;
import com.greenpixels.birdsofcostarica.inyection.scope.FragmentScope;
import com.greenpixels.birdsofcostarica.presenters.BirdsPresenter;

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
        modules = DBModule.class
)
public interface BirdListFragmentComponent {

    void inject (BirdListFragment listFragment);

    BirdsPresenter presenter();

    BirdsListAdapter adapter();
}