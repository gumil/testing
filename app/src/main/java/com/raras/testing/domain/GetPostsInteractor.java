package com.raras.testing.domain;

import com.raras.testing.data.Repository;
import com.raras.testing.model.Post;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class GetPostsInteractor extends Interactor<List<Post>> {

    private final Repository mRepository;
    private final int mUserId;

    @Inject
    public GetPostsInteractor(Repository repository, int userId) {
        mRepository = repository;
        mUserId = userId;
    }

    @Override
    protected Observable<List<Post>> buildUseCaseObservable() {
        return mRepository.getPostsByUser(mUserId);
    }
}
