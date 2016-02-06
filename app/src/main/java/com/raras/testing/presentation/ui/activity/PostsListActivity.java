package com.raras.testing.presentation.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.raras.testing.R;
import com.raras.testing.injectors.HasComponent;
import com.raras.testing.injectors.component.DaggerPostsComponent;
import com.raras.testing.injectors.component.PostsComponent;
import com.raras.testing.injectors.module.PostsModule;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PostsListActivity extends BaseActivity implements HasComponent<PostsComponent> {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Bind(R.id.fab)
    FloatingActionButton mFab;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.navigation_view)
    NavigationView mNavigationView;

    private PostsComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_list);
        initInjection();
        initUi();
    }

    private void initInjection() {
        mComponent = DaggerPostsComponent.builder()
                .activityModule(getActivityModule())
                .appComponent(getApplicationComponent())
                .postsModule(new PostsModule(1))
                .build();
    }


    protected void initUi() {
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(getString(R.string.app_name));
        mToolbar.setNavigationIcon(R.drawable.ic_menu_24dp);
        mToolbar.setTitleTextAppearance(this, R.style.ActionBarTextColor);
    }

    @OnClick(R.id.fab)
    public void onClickFab(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public PostsComponent getComponent() {
        return mComponent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(mNavigationView)) {
            mDrawerLayout.closeDrawer(mNavigationView);
            return;
        }
        super.onBackPressed();
    }
}
