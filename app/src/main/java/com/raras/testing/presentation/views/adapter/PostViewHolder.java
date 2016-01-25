package com.raras.testing.presentation.views.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raras.testing.model.Post;
import com.raras.testing.databinding.ListItemPostBinding;
import com.raras.testing.presentation.views.listener.ListItemClickListener;

public class PostViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = PostViewHolder.class.getSimpleName();
    private static ListItemClickListener<Post> mListener;

    private final ListItemPostBinding mBinding;

    static PostViewHolder create(LayoutInflater inflater, ViewGroup parent, ListItemClickListener<Post> listener) {
        ListItemPostBinding binding = ListItemPostBinding
                .inflate(inflater, parent, false);
        mListener = listener;
        return new PostViewHolder(binding);
    }

    private PostViewHolder(ListItemPostBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
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
