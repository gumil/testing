package com.raras.testing.injectors.module;

import com.raras.testing.domain.GetPostsInteractor;
import com.raras.testing.domain.Interactor;
import com.raras.testing.injectors.PerActivity;
import com.raras.testing.data.Repository;

import dagger.Module;
import dagger.Provides;

@Module
public class PostsModule {

    private final int mUserId;

    public PostsModule(int userId) {
        mUserId = userId;
    }

    @Provides @PerActivity
    Interactor provideGetPostsInteractor(Repository repository) {
        return new GetPostsInteractor(repository, mUserId);
    }
}
