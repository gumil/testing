package com.raras.testing.presentation.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.raras.testing.R;
import com.raras.testing.model.Post;
import com.raras.testing.presentation.ui.adapter.PostsAdapter;
import com.raras.testing.presentation.ui.listener.ListItemClickListener;
import com.raras.testing.presentation.view.LoadListView;

import java.util.List;

public abstract class BaseListFragment<T> extends BaseFragment implements LoadListView<T> {

    private RecyclerView mRecyclerView;
    private TextView mTextView;
    private ProgressBar mProgressBar;

    protected abstract RecyclerView getRecyclerView();

    protected abstract TextView getListTextView();

    protected abstract ProgressBar getProgressBar();

    protected abstract Activity getContextActivity();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView = getRecyclerView();
        mTextView = getListTextView();
        mProgressBar = getProgressBar();
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
    public void showError() {
        mRecyclerView.setVisibility(View.GONE);
        mTextView.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);

        mTextView.setText(R.string.error_message_generic);
    }

}
