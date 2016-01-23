package com.raras.testing.injectors.component;

import android.content.Context;

import com.raras.testing.injectors.Activity;
import com.raras.testing.injectors.module.ActivityModule;

import dagger.Component;

@Activity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Context context();
}
