package com.raras.testing.injectors.component;

import com.raras.testing.TestApplication;
import com.raras.testing.injectors.module.AppModule;
import com.raras.testing.data.rest.Repository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = AppModule.class)
public interface AppComponent {
    TestApplication app();
    Repository dataRepository();
}
