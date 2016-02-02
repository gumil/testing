package com.raras.testing.injectors.module;

import android.app.Activity;
import android.content.Context;

import com.raras.testing.injectors.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    Activity provideActivityContext() {
        return mActivity;
    }
}
