package com.raras.messengerlite.views.activity;

import android.content.Intent;
import android.os.Bundle;

import com.raras.messengerlite.R;

public class SplashActivity extends BaseActivity {

    @Override
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {
        Intent intent = new Intent(this, PostsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void initUi() {

    }

}
