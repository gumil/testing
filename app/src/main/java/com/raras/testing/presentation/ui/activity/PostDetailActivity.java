package com.raras.testing.presentation.ui.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;

import com.raras.testing.R;
import com.raras.testing.injectors.HasComponent;
import com.raras.testing.injectors.component.CommentsComponent;
import com.raras.testing.injectors.component.DaggerCommentsComponent;
import com.raras.testing.injectors.module.CommentsModule;
import com.raras.testing.model.Post;
import com.raras.testing.presentation.NavigationUtils;
import com.raras.testing.presentation.ui.fragment.PostDetailsFragment;
import com.raras.testing.utils.Log;

public class PostDetailActivity extends BaseActivity implements HasComponent<CommentsComponent>{

    private Post mPost;
    private CommentsComponent mComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        mPost = getIntent().getParcelableExtra(NavigationUtils.EXTRA_POST);
        Log.d("tantrums", "" + mPost.getId());
        initInjection();
        initUi();
    }

    private void initInjection() {
        mComponent = DaggerCommentsComponent.builder()
                .appComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .commentsModule(new CommentsModule(mPost.getId()))
                .build();
    }

    private void initUi() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        addFragment(R.id.post_detail_container, PostDetailsFragment.newInstance(mPost));
    }

    @Override
    public CommentsComponent getComponent() {
        return mComponent;
    }
}
