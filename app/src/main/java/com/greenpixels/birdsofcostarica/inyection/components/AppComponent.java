package com.greenpixels.birdsofcostarica.inyection.components;

/**
 * Main app component
 *
 * @author PiXeL16
 * @date 5/27/15
 */

import android.content.Context;

import com.greenpixels.birdsofcostarica.inyection.modules.AppModule;

import dagger.Component;

@Component(
        modules = AppModule.class
)
public interface AppComponent {

   Context context();

}