package com.raras.testing.injectors.component;

import com.raras.testing.injectors.PerActivity;
import com.raras.testing.injectors.module.ActivityModule;
import com.raras.testing.injectors.module.PostsModule;
import com.raras.testing.presentation.ui.fragment.PostsListFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = {PostsModule.class, ActivityModule.class})
public interface PostsComponent extends ActivityComponent {
    void inject(PostsListFragment postsListFragment);
}
