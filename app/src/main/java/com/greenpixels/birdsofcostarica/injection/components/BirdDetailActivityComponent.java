package com.greenpixels.birdsofcostarica.injection.components;

import com.greenpixels.birdsofcostarica.activities.BirdDetailActivity;
import com.greenpixels.birdsofcostarica.injection.modules.ActivityModule;
import com.greenpixels.birdsofcostarica.injection.modules.DBModule;
import com.greenpixels.birdsofcostarica.presenters.BirdPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Bird Detail Component for injection
 *
 * @author PiXeL16
 * @date 6/2/15
 */
@Singleton
@Component(
        dependencies = AppComponent.class,
        modules = {ActivityModule.class,DBModule.class}
)
public interface BirdDetailActivityComponent {

    void inject (BirdDetailActivity detailActivity);

    BirdPresenter presenter();

}