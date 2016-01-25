package com.raras.testing.data.rest;

import com.raras.testing.model.Comment;
import com.raras.testing.model.Post;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface TestApi {
    String BASE_URL = "http://jsonplaceholder.typicode.com/";

    @GET("/users/{userId}/posts")
    Observable<List<Post>> getPostsByUser(@Path("userId") int userId);

    @GET("/posts/{postId}/comments")
    Observable<List<Comment>> getCommentsById(@Path("postId") int postId);
}
