package com.raras.testing.presentation.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.raras.testing.model.Post;
import com.raras.testing.presentation.ui.listener.ListItemClickListener;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private final List<Post> mPosts;
    private final Context mContext;
    private final ListItemClickListener<Post> mListener;

    public PostsAdapter(Context context, List<Post> posts, ListItemClickListener<Post> listener) {
        mContext = context;
        mPosts = posts;
        mListener = listener;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return PostViewHolder.create(LayoutInflater.from(mContext), parent, mListener);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = mPosts.get(position);
        holder.bindTo(post);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }


}
