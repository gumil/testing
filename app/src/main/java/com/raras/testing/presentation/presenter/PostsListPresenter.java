package com.raras.testing.presentation.presenter;

import com.raras.testing.domain.GetPostsInteractor;
import com.raras.testing.model.Post;
import com.raras.testing.presentation.view.BaseView;
import com.raras.testing.presentation.view.LoadListView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

public class PostsListPresenter implements BaseListPresenter<Post> {

    private final GetPostsInteractor mGetPostsInteractor;
    private LoadListView<Post> mPostsListView;

    @Inject
    public PostsListPresenter(GetPostsInteractor getPostsInteractor) {
        mGetPostsInteractor = getPostsInteractor;
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
        mPostsListView.showError();
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
