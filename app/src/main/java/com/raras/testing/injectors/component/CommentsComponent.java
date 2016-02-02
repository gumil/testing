package com.raras.testing.injectors.component;

import com.raras.testing.injectors.PerActivity;
import com.raras.testing.injectors.module.ActivityModule;
import com.raras.testing.injectors.module.CommentsModule;
import com.raras.testing.presentation.ui.fragment.PostDetailsFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = {CommentsModule.class, ActivityModule.class})
public interface CommentsComponent extends ActivityComponent {
    void inject(PostDetailsFragment postDetailsFragment);
}
