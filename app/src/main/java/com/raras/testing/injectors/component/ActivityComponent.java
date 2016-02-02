package com.raras.testing.injectors.component;

import android.app.Activity;
import android.content.Context;

import com.raras.testing.injectors.PerActivity;
import com.raras.testing.injectors.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity activity();
}
