package com.raras.testing.presentation.viewmodel;

import com.raras.testing.model.Post;

import java.util.List;

public interface PostsListView extends LoadListView {

    void renderPostsList(List<Post> posts);

    void viewPost(Post post);
}
