package com.raras.testing.domain;

import rx.Observable;

public interface Interactor<T> {

    Observable<T> execute();

}
