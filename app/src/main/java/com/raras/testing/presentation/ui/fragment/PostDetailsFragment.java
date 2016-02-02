package com.raras.testing.presentation.ui.fragment;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.raras.testing.R;
import com.raras.testing.databinding.FragmentPostDetailBinding;
import com.raras.testing.injectors.component.CommentsComponent;
import com.raras.testing.model.Comment;
import com.raras.testing.model.Post;
import com.raras.testing.presentation.presenter.CommentsListPresenter;
import com.raras.testing.presentation.ui.adapter.CommentsAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PostDetailsFragment extends BaseListFragment<Comment> {

    private static final String ARGUMENT_KEY_POST = "post";

    @Inject
    CommentsListPresenter mCommentsListPresenter;

    @Inject
    Activity mActivity;

    @Bind(R.id.post_detail_toolbar)
    Toolbar mToolbar;

    @Bind(R.id.post_detail_recycler_view)
    RecyclerView mRecyclerView;

    @Bind(R.id.post_detail_progress)
    ProgressBar mProgressBar;

    @Bind(R.id.post_detail_text)
    TextView mTextView;

    private Post mPost;

    public static PostDetailsFragment newInstance(Post post) {
       PostDetailsFragment userDetailsFragment = new PostDetailsFragment();

       Bundle argumentsBundle = new Bundle();
       argumentsBundle.putParcelable(ARGUMENT_KEY_POST, post);
       userDetailsFragment.setArguments(argumentsBundle);

       return userDetailsFragment;
   }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_post_detail, container, false);
        mPost = getArguments().getParcelable(ARGUMENT_KEY_POST);
        FragmentPostDetailBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_post_detail, container, false);
        binding.setPost(mPost);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getComponent(CommentsComponent.class).inject(this);
        mCommentsListPresenter.attachView(this);
        mCommentsListPresenter.onCreate();
    }

    @Override
    public void renderList(List<Comment> list) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setAdapter(new CommentsAdapter(mActivity, list));
        mRecyclerView.scheduleLayoutAnimation();
    }

    @Override
    public void viewItem(Comment comment) {

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
}
