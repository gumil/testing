package com.raras.testing.presentation.presenter;

import com.raras.testing.domain.Interactor;
import com.raras.testing.model.Comment;
import com.raras.testing.presentation.view.BaseView;
import com.raras.testing.presentation.view.LoadListView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

public class CommentsListPresenter implements BaseListPresenter<Comment> {

    private Interactor<List<Comment>> mInteractor;
    private LoadListView<Comment> mView;

    @Inject
    public CommentsListPresenter(Interactor interactor) {
        mInteractor = interactor;
    }

    @Override
    public void attachView(BaseView view) {
        mView = (LoadListView<Comment>) view;
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

    @Override
    public void loadData() {
        mView.showLoading();
        mInteractor.execute().subscribe(new Subscriber<List<Comment>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                showError();
            }

            @Override
            public void onNext(List<Comment> comments) {
                showList(comments);
            }
        });
    }
    private void showError() {
        mView.showError();
    }

    private void showList(List<Comment> comments) {
        mView.hideLoading();
        mView.renderList(comments);
    }
}
