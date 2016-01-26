package com.raras.testing.presentation.views.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toolbar;
import android.view.View;

import com.raras.testing.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PostsListActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.fab) FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_list);
        initUi();
    }


    protected void initUi() {
        ButterKnife.bind(this);
        setActionBar(mToolbar);
        getActionBar().setTitle(getString(R.string.app_name));
        mToolbar.setNavigationIcon(R.drawable.ic_menu_24dp);
    }

    @OnClick(R.id.fab)
    public void onClickFab(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
