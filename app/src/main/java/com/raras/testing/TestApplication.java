package com.raras.testing;

import android.app.Application;

import com.raras.testing.injectors.component.AppComponent;
import com.raras.testing.injectors.component.DaggerAppComponent;
import com.raras.testing.injectors.module.AppModule;

public class TestApplication extends Application{

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();
    }

    private void initInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
