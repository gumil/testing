package com.raras.testing.views.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raras.testing.R;
import com.raras.testing.TestApplication;
import com.raras.testing.domain.GetPostsInteractor;
import com.raras.testing.injectors.component.DaggerPostsComponent;
import com.raras.testing.injectors.module.ActivityModule;
import com.raras.testing.injectors.module.PostsModule;
import com.raras.testing.data.entities.Post;
import com.raras.testing.views.adapter.PostsAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

public class PostsFragment extends Fragment {

    private static final String TAG = PostsFragment.class.getSimpleName();

    @Inject
    GetPostsInteractor mGetPostsInteractor;

    @Inject
    Context mContext;

    @Bind(R.id.posts_recycler_view)
    RecyclerView mRecyclerView;

    public PostsFragment() {
    }

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mGetPostsInteractor.execute().subscribe(new Action1<List<Post>>() {
            @Override
            public void call(List<Post> posts) {
                mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
                mRecyclerView.setAdapter(new PostsAdapter(mContext, posts));
            }
        });
    }
}
