package com.raras.testing.domain;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public abstract class Interactor<T> {

    protected abstract Observable<T> buildUseCaseObservable();

    public Observable<T> execute() {
        return buildUseCaseObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
