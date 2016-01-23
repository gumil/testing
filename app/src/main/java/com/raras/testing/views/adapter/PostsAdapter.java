package com.raras.testing.views.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raras.testing.BR;
import com.raras.testing.R;
import com.raras.testing.data.entities.Post;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder>{

    private final List<Post> mPosts;
    private final Context mContext;

    public PostsAdapter(Context context, List<Post> posts) {
        mContext = context;
        mPosts = posts;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_posts_layout, parent, false);
        return new PostViewHolder(view);
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

    class PostViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding mBinding;

        public PostViewHolder(View itemView) {
            super(itemView);

            mBinding = DataBindingUtil.bind(itemView);
        }

        public ViewDataBinding getBinding() {
            return mBinding;
        }

        public void bindTo(Post post) {
            mBinding.setVariable(BR.post, post);
            mBinding.executePendingBindings();
        }

    }
}
