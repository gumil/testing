package com.raras.testing.presentation.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.raras.testing.R;
import com.raras.testing.model.Comment;
import com.raras.testing.model.Post;
import com.raras.testing.presentation.ui.listener.ListItemClickListener;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentViewHolder> {

    private final Context mContext;
    private final List<Comment> mComments;

    public CommentsAdapter(Context context, List<Comment> comments) {
        mContext = context;
        mComments = comments;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return CommentViewHolder.create(LayoutInflater.from(mContext), parent);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.bindTo(mComments.get(position));
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }
}
