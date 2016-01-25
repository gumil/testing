package com.raras.testing.data.rest;

import com.raras.testing.data.Repository;
import com.raras.testing.model.Comment;
import com.raras.testing.model.Post;

import java.util.List;

import javax.inject.Inject;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;

public class RestDataSource implements Repository {

    private final TestApi mTestApi;

    @Inject
    public RestDataSource() {
        Retrofit apiAdapter = new Retrofit.Builder()
                .baseUrl(TestApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mTestApi = apiAdapter.create(TestApi.class);
    }

    @Override
    public Observable<List<Post>> getPostsByUser(int userId) {
        return mTestApi.getPostsByUser(userId);
    }

    @Override
    public Observable<List<Comment>> getCommentsById(int postId) {
        return mTestApi.getCommentsById(postId);
    }
}
