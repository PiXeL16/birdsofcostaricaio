package com.greenpixels.birdsofcostarica.injection.components;

import com.greenpixels.birdsofcostarica.activities.BirdDetailActivity;
import com.greenpixels.birdsofcostarica.injection.modules.ContextProvider;
import com.greenpixels.birdsofcostarica.injection.modules.DBProvider;
import com.greenpixels.birdsofcostarica.injection.modules.UtilProvider;
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
        modules = {ContextProvider.class,DBProvider.class, UtilProvider.class}
)
public interface BirdDetailActivityComponent {

    void inject (BirdDetailActivity detailActivity);

    BirdPresenter presenter();

}