package com.raras.messengerlite.injectors.module;

import com.raras.messengerlite.TestApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final TestApplication mTestApplication;

    public AppModule(TestApplication testApplication) {
        mTestApplication = testApplication;
    }

    @Provides @Singleton
    TestApplication provideMessengerApplicationContext() {
        return mTestApplication;
    }
}
