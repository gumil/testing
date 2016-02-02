package com.raras.testing.injectors.component;

import com.raras.testing.TestApplication;
import com.raras.testing.injectors.module.AppModule;
import com.raras.testing.data.Repository;
import com.raras.testing.presentation.ui.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = AppModule.class)
public interface AppComponent {
    void inject(BaseActivity baseActivity);

    TestApplication app();
    Repository dataRepository();
}
