package com.raras.testing.data.rest;

import com.raras.testing.data.entities.Post;

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
                .baseUrl(TestApi.END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mTestApi = apiAdapter.create(TestApi.class);
    }

    @Override
    public Observable<List<Post>> getPostsByUser(int userId) {
        return mTestApi.getPostsByUser(userId);
    }
}
