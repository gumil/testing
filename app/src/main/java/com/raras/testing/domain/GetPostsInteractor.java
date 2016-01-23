package com.raras.testing.domain;

import com.raras.testing.data.entities.Post;
import com.raras.testing.data.rest.Repository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GetPostsInteractor implements Interactor<List<Post>> {

    private final Repository mRepository;
    private final int mUserId;

    @Inject
    public GetPostsInteractor(Repository repository, int userId) {
        mRepository = repository;
        mUserId = userId;
    }

    @Override
    public Observable<List<Post>> execute() {
        return mRepository.getPostsByUser(mUserId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
