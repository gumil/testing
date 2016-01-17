package com.raras.messengerlite.injectors.component;

import com.raras.messengerlite.TestApplication;
import com.raras.messengerlite.injectors.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton @Component(modules = AppModule.class)
public interface AppComponent {
    TestApplication app();
}
