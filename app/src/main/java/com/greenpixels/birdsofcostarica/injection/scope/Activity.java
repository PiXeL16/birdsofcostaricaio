package com.greenpixels.birdsofcostarica.injection.scope;


import java.lang.annotation.Retention;

import javax.inject.Scope;
/**
 * Activity Scope from injection
 *
 * @author PiXeL16
 * @date 6/3/15
 */
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Scope @Retention(RUNTIME)
public @interface Activity {}