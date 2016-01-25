package com.raras.testing.presentation.presenter;

import com.raras.testing.presentation.viewmodel.BaseView;

public interface Presenter {

    void attachView(BaseView view);

    void onCreate();

    void onResume();

    void onPause();

    void onDestroy();
}
