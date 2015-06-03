package com.greenpixels.birdsofcostarica.injection.components;

/**
 * Main app component
 *
 * @author PiXeL16
 * @date 5/27/15
 */

import android.app.Application;
import android.content.Context;

import com.greenpixels.birdsofcostarica.injection.modules.AppModule;

import dagger.Component;

@Component(
        modules = AppModule.class
)
public interface AppComponent {

   Application application();

}