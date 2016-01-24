package com.raras.testing.presentation.views.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.raras.testing.model.Post;
import com.raras.testing.databinding.ListItemPostBinding;

public class PostViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = PostViewHolder.class.getSimpleName();

    private final ListItemPostBinding mBinding;

    static PostViewHolder create(LayoutInflater inflater, ViewGroup parent) {
        ListItemPostBinding binding = ListItemPostBinding
                .inflate(inflater, parent, false);
        return new PostViewHolder(binding);
    }

    private PostViewHolder(ListItemPostBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public ViewDataBinding getBinding() {
        return mBinding;
    }

    public void bindTo(Post post) {
        mBinding.setPost(post);
        mBinding.executePendingBindings();
    }

}
