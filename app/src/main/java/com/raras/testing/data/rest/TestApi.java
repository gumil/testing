package com.raras.testing.data.rest;

import com.raras.testing.model.Post;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface TestApi {
    String END_POINT = "http://jsonplaceholder.typicode.com/";

    @GET("/users/{userId}/posts")
    Observable<List<Post>> getPostsByUser(@Path("userId") int userId);
}
