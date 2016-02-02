package com.raras.testing.presentation.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.raras.testing.R;
import com.raras.testing.injectors.component.PostsComponent;
import com.raras.testing.model.Post;
import com.raras.testing.presentation.NavigationUtils;
import com.raras.testing.presentation.presenter.PostsListPresenter;
import com.raras.testing.presentation.view.LoadListView;
import com.raras.testing.presentation.ui.adapter.PostsAdapter;
import com.raras.testing.presentation.ui.listener.ListItemClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PostsListFragment extends BaseListFragment<Post> {

    private static final String TAG = PostsListFragment.class.getSimpleName();

    @Inject
    PostsListPresenter mPostsListPresenter;

    @Inject
    Activity mActivity;

    @Bind(R.id.posts_recycler_view)
    RecyclerView mRecyclerView;

    @Bind(R.id.posts_progress)
    ProgressBar mProgressBar;

    @Bind(R.id.posts_text)
    TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts_list, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    protected RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    @Override
    protected TextView getListTextView() {
        return mTextView;
    }

    @Override
    protected ProgressBar getProgressBar() {
        return mProgressBar;
    }

    @Override
    protected Activity getContextActivity() {
        return mActivity;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getComponent(PostsComponent.class).inject(this);
        mPostsListPresenter.attachView(this);
        mPostsListPresenter.onCreate();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void renderList(List<Post> posts) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setAdapter(new PostsAdapter(mActivity, posts, new ListItemClickListener<Post>() {
            @Override
            public void onItemClick(Post post) {
                viewItem(post);
            }
        }));
        mRecyclerView.scheduleLayoutAnimation();
    }

    @Override
    public void viewItem(Post post) {
        //Toast.makeText(mContext, post.toString(), Toast.LENGTH_LONG).show();
        NavigationUtils.startDetailActivity(mActivity, post);
    }

    @OnClick(R.id.posts_text)
    public void retry() {
        mPostsListPresenter.loadData();
    }

}
