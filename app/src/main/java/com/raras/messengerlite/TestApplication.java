package com.raras.messengerlite;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.raras.messengerlite.injectors.component.AppComponent;
import com.raras.messengerlite.injectors.component.DaggerAppComponent;
import com.raras.messengerlite.injectors.module.AppModule;

public class TestApplication extends Application{

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initInjector();
        initSdk();
    }

    private void initSdk() {
        FacebookSdk.sdkInitialize(this);
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
