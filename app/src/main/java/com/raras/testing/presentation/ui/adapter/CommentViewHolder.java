package com.raras.testing.presentation.ui.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.raras.testing.databinding.ListItemCommentBinding;
import com.raras.testing.model.Comment;

public class CommentViewHolder extends RecyclerView.ViewHolder{

    private final ListItemCommentBinding mBinding;

    static CommentViewHolder create(LayoutInflater inflater, ViewGroup parent) {
        ListItemCommentBinding binding = ListItemCommentBinding
                .inflate(inflater, parent, false);
        return new CommentViewHolder(binding);
    }

    private CommentViewHolder(ListItemCommentBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public ViewDataBinding getBinding() {
        return mBinding;
    }

    public void bindTo(final Comment comment) {
        mBinding.setComment(comment);
        mBinding.executePendingBindings();
    }
}
