package com.raras.testing.presentation.views.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.raras.testing.R;
import com.raras.testing.TestApplication;
import com.raras.testing.domain.GetPostsInteractor;
import com.raras.testing.injectors.component.DaggerPostsComponent;
import com.raras.testing.injectors.module.ActivityModule;
import com.raras.testing.injectors.module.PostsModule;
import com.raras.testing.model.Post;
import com.raras.testing.presentation.presenter.PostsListPresenter;
import com.raras.testing.presentation.viewmodel.LoadListView;
import com.raras.testing.presentation.viewmodel.PostsListView;
import com.raras.testing.presentation.views.adapter.PostsAdapter;
import com.raras.testing.presentation.views.listener.ListItemClickListener;
import com.raras.testing.utils.Log;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.functions.Action1;

public class PostsFragment extends Fragment implements LoadListView<Post> {

    private static final String TAG = PostsFragment.class.getSimpleName();

    @Inject
    PostsListPresenter mPostsListPresenter;

    @Bind(R.id.posts_recycler_view)
    RecyclerView mRecyclerView;

    @Bind(R.id.posts_progress)
    ProgressBar mProgressBar;

    @Bind(R.id.posts_text)
    TextView mTextView;

    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestApplication testApplication = (TestApplication) getActivity().getApplication();
        DaggerPostsComponent.builder()
                .activityModule(new ActivityModule(getActivity()))
                .appComponent(testApplication.getAppComponent())
                .postsModule(new PostsModule(1))
                .build().inject(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPostsListPresenter.attachView(this);
        mPostsListPresenter.onCreate();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void renderList(List<Post> posts) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(new PostsAdapter(mContext, posts, new ListItemClickListener<Post>() {
            @Override
            public void onItemClick(Post post) {
                viewItem(post);
            }
        }));
    }

    @Override
    public void viewItem(Post post) {
        Toast.makeText(mContext, post.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        mRecyclerView.setVisibility(View.GONE);
        mTextView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mTextView.setVisibility(View.GONE);
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        mRecyclerView.setVisibility(View.GONE);
        mTextView.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);

        mTextView.setText(message);
    }

    @OnClick(R.id.posts_text)
    public void retry() {
        mPostsListPresenter.loadData();
    }

}
