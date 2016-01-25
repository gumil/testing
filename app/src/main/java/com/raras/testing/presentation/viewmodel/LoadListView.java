package com.raras.testing.presentation.viewmodel;

import com.raras.testing.model.Post;

import java.util.List;

public interface LoadListView<T> extends BaseView {

    void showLoading();

    void hideLoading();

    void showError(String message);

    void renderList(List<T> list);

    void viewItem(T t);
}
