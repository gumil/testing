package com.raras.testing.data;

import com.raras.testing.model.Comment;
import com.raras.testing.model.Post;

import java.util.List;

import rx.Observable;

public interface Repository {

    Observable<List<Post>> getPostsByUser(int userId);

    Observable<List<Comment>> getCommentsById(int postId);
}
