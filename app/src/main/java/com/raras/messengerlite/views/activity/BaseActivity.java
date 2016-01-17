package com.raras.messengerlite.views.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.appevents.AppEventsLogger;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        onCreateActivity(savedInstanceState);
        initUi();
    }

    public abstract int getLayoutResId();

    protected abstract void onCreateActivity(Bundle savedInstanceState);

    protected abstract void initUi();

    @Override
    protected void onResume() {
        super.onResume();

        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        AppEventsLogger.deactivateApp(this);
    }

}
