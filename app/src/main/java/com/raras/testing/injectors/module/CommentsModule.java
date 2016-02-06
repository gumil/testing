package com.raras.testing.injectors.module;

import com.raras.testing.data.Repository;
import com.raras.testing.domain.GetCommentsInteractor;
import com.raras.testing.domain.GetPostsInteractor;
import com.raras.testing.domain.Interactor;
import com.raras.testing.injectors.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class CommentsModule {

    private final int mPostId;

    public CommentsModule(int userId) {
        mPostId = userId;
    }

    @Provides @PerActivity
    Interactor provideGetCommentsInteractor(Repository repository) {
        return new GetCommentsInteractor(repository, mPostId);
    }
}
