package com.raras.testing.injectors.module;

import android.content.Context;

import com.raras.testing.injectors.Activity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Context mContext;

    public ActivityModule(Context context) {
        mContext = context;
    }

    @Provides
    @Activity
    Context provideActivityContext() {
        return mContext;
    }
}
