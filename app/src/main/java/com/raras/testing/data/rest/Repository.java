package com.raras.testing.data.rest;

import com.raras.testing.data.entities.Post;

import java.util.List;

import rx.Observable;

public interface Repository {

    Observable<List<Post>> getPostsByUser(int userId);

}
