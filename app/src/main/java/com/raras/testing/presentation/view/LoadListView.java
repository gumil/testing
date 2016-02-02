package com.raras.testing.presentation.view;

import java.util.List;

public interface LoadListView<T> extends BaseView {

    void showLoading();

    void hideLoading();

    void showError();

    void renderList(List<T> list);

    void viewItem(T t);
}
