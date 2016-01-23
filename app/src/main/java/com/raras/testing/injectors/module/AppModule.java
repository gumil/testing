package com.raras.testing.injectors.module;

import com.raras.testing.TestApplication;
import com.raras.testing.data.rest.Repository;
import com.raras.testing.data.rest.RestDataSource;

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

    @Provides @Singleton
    Repository provideDataRepository(RestDataSource restDataSource) {
        return restDataSource;
    }
}
