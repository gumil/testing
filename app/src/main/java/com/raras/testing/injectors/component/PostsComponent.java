package com.raras.testing.injectors.component;

import com.raras.testing.injectors.Activity;
import com.raras.testing.injectors.module.ActivityModule;
import com.raras.testing.injectors.module.PostsModule;
import com.raras.testing.presentation.views.fragment.PostsListFragment;

import dagger.Component;

@Activity
@Component(dependencies = AppComponent.class, modules = {PostsModule.class, ActivityModule.class})
public interface PostsComponent extends ActivityComponent {
    void inject(PostsListFragment postsListFragment);
}
