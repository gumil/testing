package com.raras.messengerlite.model.rest;

import com.raras.messengerlite.model.entities.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TestApi {
    String END_POINT       = "http://jsonplaceholder.typicode.com/";
    @GET("/users/{userId}/posts")
    Call<List<Post>> getPosts (@Path("userId") int userId);
}
