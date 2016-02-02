package com.raras.testing.presentation.ui.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raras.testing.model.Post;
import com.raras.testing.databinding.ListItemPostBinding;
import com.raras.testing.presentation.ui.listener.ListItemClickListener;

public class PostViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = PostViewHolder.class.getSimpleName();
    private final ListItemClickListener<Post> mListener;

    private final ListItemPostBinding mBinding;

    static PostViewHolder create(LayoutInflater inflater, ViewGroup parent, ListItemClickListener<Post> listener) {
        ListItemPostBinding binding = ListItemPostBinding
                .inflate(inflater, parent, false);
        return new PostViewHolder(binding, listener);
    }

    private PostViewHolder(ListItemPostBinding binding, ListItemClickListener<Post> listener) {
        super(binding.getRoot());
        mBinding = binding;
        mListener = listener;
    }

    public ViewDataBinding getBinding() {
        return mBinding;
    }

    public void bindTo(final Post post) {
        mBinding.setPost(post);
        mBinding.executePendingBindings();
        mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(post);
            }
        });
    }

}
