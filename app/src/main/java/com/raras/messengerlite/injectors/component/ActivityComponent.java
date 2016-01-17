package com.raras.messengerlite.injectors.component;

import android.content.Context;

import com.raras.messengerlite.injectors.Activity;
import com.raras.messengerlite.injectors.module.ActivityModule;

import dagger.Component;

@Activity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Context context();
}
