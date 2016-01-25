package com.raras.testing.presentation.presenter;

import android.content.Context;
import android.view.View;

import com.raras.testing.R;
import com.raras.testing.domain.GetPostsInteractor;
import com.raras.testing.model.Post;
import com.raras.testing.presentation.viewmodel.BaseView;
import com.raras.testing.presentation.viewmodel.LoadListView;
import com.raras.testing.presentation.viewmodel.PostsListView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.functions.Action1;

public class PostsListPresenter implements Presenter {

    private final Context mContext;
    private final GetPostsInteractor mGetPostsInteractor;
    private LoadListView<Post> mPostsListView;

    @Inject
    public PostsListPresenter(GetPostsInteractor getPostsInteractor, Context context) {
        mGetPostsInteractor = getPostsInteractor;
        mContext = context;
    }

    @Override
    public void attachView(BaseView view) {
        mPostsListView = (LoadListView<Post>) view;
    }

    @Override
    public void onCreate() {
        loadData();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    private void showError() {
        mPostsListView.showError(mContext.getString(R.string.error_message_generic));
    }

    private void showList(List<Post> posts) {
        mPostsListView.hideLoading();
        mPostsListView.renderList(posts);
    }

    public void loadData(){
        mPostsListView.showLoading();
        mGetPostsInteractor.execute().subscribe(new Subscriber<List<Post>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                showError();
            }

            @Override
            public void onNext(List<Post> posts) {
                showList(posts);
            }
        });
    }
}
