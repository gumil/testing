package com.raras.testing.domain;

import com.raras.testing.data.Repository;
import com.raras.testing.model.Comment;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class GetCommentsInteractor extends Interactor<List<Comment>> {
    private Repository mRepository;
    private int postId;

    @Inject
    public GetCommentsInteractor(Repository repository, int postId) {
        mRepository = repository;
        this.postId = postId;
    }

    @Override
    protected Observable<List<Comment>> buildUseCaseObservable() {
        return mRepository.getCommentsById(postId);
    }
}
