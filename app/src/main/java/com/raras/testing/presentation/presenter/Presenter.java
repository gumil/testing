package com.raras.testing.presentation.presenter;

import com.raras.testing.presentation.view.BaseView;

public interface Presenter {

    void attachView(BaseView view);

    void onCreate();

    void onResume();

    void onPause();

    void onDestroy();
}
