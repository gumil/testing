package com.raras.messengerlite.views.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raras.messengerlite.R;
import com.raras.messengerlite.model.entities.Post;
import com.raras.messengerlite.model.rest.TestApi;
import com.raras.messengerlite.utils.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostsFragment extends Fragment {

    private static final String TAG = PostsFragment.class.getSimpleName();

    public PostsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Retrofit testApiAdapter = new Retrofit.Builder().
                baseUrl(TestApi.END_POINT).
                addConverterFactory(GsonConverterFactory.create()).build();
        TestApi testApi = testApiAdapter.create(TestApi.class);
        Call<List<Post>> call = testApi.getPosts(1);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Response<List<Post>> response) {
                Log.d(TAG, response.body().toString());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

}
