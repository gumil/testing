package com.raras.testing.presentation;

import android.content.Context;
import android.content.Intent;

import com.raras.testing.model.Post;
import com.raras.testing.presentation.ui.activity.PostDetailActivity;

public class NavigationUtils {

    public static final String EXTRA_POST = "post";

    public static void startDetailActivity(Context context, Post post) {
        Intent intent = new Intent(context, PostDetailActivity.class);
        intent.putExtra(EXTRA_POST, post);
        context.startActivity(intent);
    }
}
