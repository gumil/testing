package com.raras.messengerlite.views.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.raras.messengerlite.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PostsActivity extends BaseActivity {

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.fab) FloatingActionButton mFab;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_posts;
    }

    @Override
    protected void onCreateActivity(Bundle savedInstanceState) {

    }

    @Override
    protected void initUi() {
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
    }

    @OnClick(R.id.fab)
    public void onClickFab(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
